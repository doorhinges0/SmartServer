package com.sunrise.common.validate;


import hbm.jsonvalidate.JsonValidateEngine;
import hbm.jsonvalidate.ValidateException;
import hbm.jsonvalidate.Validator;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.common.utils.JsonResponseUtils;
import com.sunrise.common.validate.annotation.ValidatorClassPath;
import com.sunrise.common.validate.literalvalidate.LiteralValidateEngine;

/**
 * 校验处理切面
 * 
 *  
 * @author livan.c 增加容错处理逻辑
 *
 */
public class ValidatorAspect {

	static Logger logger = LoggerFactory.getLogger(ValidatorAspect.class);
	
	private static final String VALIDATE_DATATYPE_JSON = "json";
	private static final String VALIDATE_DATATYPE_LITERAL = "literal";

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		Method targetMethod = joinPoint.getTarget().getClass()
				.getMethod(method.getName(), method.getParameterTypes());

		logger.debug("ValidatorAspect before method:" + method.getName());
		
		ValidatorClassPath p = targetMethod.getAnnotation(ValidatorClassPath.class);
		Object rs = null;
		if (p != null) {//容错处理,若没有配置检验器则不需检验
			int argSize = joinPoint.getArgs().length;
			if (argSize > 0){//没有入参不需要校验
				Validator validator = p.validator().newInstance();
				int chkInputPath = p.chkInputPath();//默认以第4个参数为待检验的入参
				String dataType = p.dataType();

				chkInputPath = chkInputPath+1 > argSize ? argSize-1 : chkInputPath;//避免数组越界，期望的参数个数与实际入参个数比较，取最小值
				rs = verify((String) joinPoint.getArgs()[chkInputPath], validator,dataType);
			}
		}
		
		if (rs != null) {
			// 校验不通过，返回之
			return rs;
		} else {
			rs = joinPoint.proceed();
		}

		logger.debug("ValidatorAspect after method");
		return rs;
	}

	private Validator method2Validator(Method method)
			throws InstantiationException, IllegalAccessException {

		ValidatorClassPath p = method.getAnnotation(ValidatorClassPath.class);

		if (p != null) {
			return p.validator().newInstance();
		}

		return null;

	}

	// 统一校验方法
	private String verify(String data, Validator validator,String dataType ) {
		if (validator == null) {
			return null;
		}
		try {
			if (VALIDATE_DATATYPE_JSON.equals(dataType)){
				JsonValidateEngine.verify(data, validator);
			}else if (VALIDATE_DATATYPE_LITERAL.equals(dataType)){
				new LiteralValidateEngine().verify(data, validator);
			}
			
		} catch (ValidateException e) {
			StringBuffer sb = new StringBuffer();
			List<String> list = e.getErrorList();
			
			/*
			for (String line : list) {
				sb.append(line).append(";");
			}
			*/
			
			/**
			 * modify by sheng at 2015/05/18
			 * 去掉只有一个验证错误时,错误信息后多一个;号的问题
			 * */
			if( list!=null && list.size()>0 ){
				sb.append(list.get(0));
				for(int i=1,length=list.size(); i<length; i++){
					sb.append( ";" ).append(list.get(i));
				}
				
			}
			return JsonResponseUtils.error(sb.toString());
		}
		return null;
	}

}

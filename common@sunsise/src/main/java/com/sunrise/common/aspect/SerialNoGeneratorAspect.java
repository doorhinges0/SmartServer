package com.sunrise.common.aspect;

import com.sunrise.common.exception.ServiceException;
import com.sunrise.common.model.codegenerator.CodeGenratorTool;
import com.sunrise.common.model.codegenerator.ObjectType;
import com.sunrise.common.utils.log.LogUtils;
import com.sunrise.common.utils.string.StringToolkit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.common.model.SerialNoHolder;

/**
 * 服务类参数切面
 * 在线程级别保存应用编码、交易流水号、操作用户编码
 * @author livan.c
 *
 */
public class SerialNoGeneratorAspect {

static Logger logger = LoggerFactory.getLogger(SerialNoGeneratorAspect.class);

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object result = "";
		Object[] args = joinPoint.getArgs();
		if (null == args || args.length < 3){
			return new ServiceException(joinPoint.getTarget().getClass() + ":无效的业务参数，前三个业务参数应为应用编码、交易流水号、操作人编码。");
		}
		//默认从线 中获取流水号
		String serialNo = SerialNoHolder.serialNo.get();
		
		if (StringToolkit.isEmpty(serialNo)){
			serialNo = StringToolkit.getObjectString(args[1]);//从业务参数中获取
			if (StringToolkit.isEmpty(serialNo)){
				serialNo = CodeGenratorTool.genObjectCode(ObjectType.SERIALNO); //生成序列号
			}
			SerialNoHolder.serialNo.set(serialNo);
		}
		LogUtils.debug(logger, String.format("use serialno -- [%s]", serialNo));
			
		//设置应用编码
		String appcode = StringToolkit.getObjectString(args[0]);
		if (StringToolkit.isNotEmpty(appcode)){
			SerialNoHolder.appcode.set(appcode);
		}
				
		//设置操作用户编码
		String oprcode = StringToolkit.getObjectString(args[2]);
		if (StringToolkit.isNotEmpty(oprcode)){
			SerialNoHolder.userCode.set(oprcode);
		}
		/*try {
			*//**
			 * 临时处理逻辑,用于初始化服务接口定义表
			 *//*
			if (args.length > 3 && (args[3].equals("Interfdef") || args[3].equals("DictItem")) ){
				
			}else {
				InterfdefVO interfDef = CommonServiceUtils.getInterDef(Settings.APPCODE.value(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
				if (null == interfDef){
					interfDef = new InterfdefVO();
					interfDef.setAppcode(Settings.APPCODE.value());
					interfDef.setInterfclass(joinPoint.getSignature().getDeclaringTypeName());
					interfDef.setMethodname(joinPoint.getSignature().getName());
					interfDef.setSaveexceptionlog(true);
					interfDef.setSaveservinput(true);
					interfDef.setSaveservlog(true);
					interfDef.setSaveservoutput(false);
					interfDef.setInterfname(joinPoint.getTarget().getClass().getName());
					CommonServiceUtils.addInterDef(interfDef);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		result = joinPoint.proceed();
		
		return result;
	}
}

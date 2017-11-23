package com.sunrise.common.aspect;

import java.util.Date;

import com.sunrise.common.dal.ext.dao.ExceptionlogVOMapperExt;
import com.sunrise.common.dal.gen.model.ExceptionlogVO;
import com.sunrise.common.utils.JsonResponseUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sunrise.common.exception.ExceptionUtils;
import com.sunrise.common.model.SerialNoHolder;
import com.sunrise.common.utils.string.StringToolkit;

/**
 * 异常处理切面
 * 
 * @author livan.c
 *
 */
public class ExceptionHandleAspect {

	static Logger logger = LoggerFactory.getLogger(ExceptionHandleAspect.class);
	
	@Autowired
    ExceptionlogVOMapperExt mapper;

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			return joinPoint.proceed();
		} catch (Exception e) {
			logger.error("", e);
			String errMsg = ExceptionUtils.makeStackTrace(e);
			errorLog(errMsg,joinPoint);
			
			return JsonResponseUtils.error(String.format("服务调用时发生未知错误，错误流水号【%s】，请联系管理员。", SerialNoHolder.serialNo.get()));
		}
	}

	/**
	 * 记录异常日志
	 * 
	 * @param e
	 */
	private void errorLog(String errMsg,ProceedingJoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		ExceptionlogVO record = new ExceptionlogVO();
		record.setCreatetime(new Date());
		record.setExceptionmsg(errMsg);
		record.setHostid(StringToolkit.getObjectString(args[2]));//暂填操作人编码
		record.setSerialno(SerialNoHolder.serialNo.get());//tenantid用作流水号
		record.setAppcode(SerialNoHolder.appcode.get());
		record.setServicemethod(joinPoint.getTarget().getClass().getName() + "#" + joinPoint.getSignature().getName());
		
		mapper.save(record);
	}

}

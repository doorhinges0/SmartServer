package com.dtsjy.mdboss.common.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtsjy.mdboss.common.dal.ext.dao.ServicelogVOMapperExt;
import com.dtsjy.mdboss.common.dal.gen.model.ServicelogVO;
import com.dtsjy.mdboss.common.model.SerialNoHolder;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

/**
 * 调用日志切面
 * 
 * @author livan.c
 *
 */
public class InvokeLogAspect {

	static Logger logger = LoggerFactory.getLogger(InvokeLogAspect.class);
	
	@Autowired
	ServicelogVOMapperExt mapper;

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		Object result = "";
		try {
			result = joinPoint.proceed();
		}finally{
			try {
				logTheCall(joinPoint,result);//确保业务类发生异常时，抛出异常，并登记日志；
			} catch (Exception e) {//日志登记异常不影响业务类的正常返回
				e.printStackTrace();
				logger.warn(joinPoint.getTarget().getClass() + ":登记业务日志时出错，【" + e.getMessage() + "】");
			}
		}
		
		return result;
	}

	/**
	 * 记录外部调用日志
	 * 
	 * @param joinPoint
	 */
	private void logTheCall(ProceedingJoinPoint joinPoint,Object result) {
		// 方法格式 xxx(String appid, String appkey, String user,String... jsonData);
		Object[] args = joinPoint.getArgs();
		String oprcode = StringToolkit.getObjectString(args[2]);
		StringBuffer buf = new StringBuffer();
		for (int i = 3; i < args.length; i++){
			buf.append("【").append(StringToolkit.getObjectString(args[i])).append("】");
		}

		String apiName = joinPoint.getTarget().getClass().getName() + "#" + joinPoint.getSignature().getName();

		ServicelogVO log = new ServicelogVO();
		log.setUsercode(oprcode);
		log.setSerialno(SerialNoHolder.serialNo.get());//tenatid用作流水号
		log.setApiname(apiName);
		log.setAppcode(SerialNoHolder.appcode.get());
		log.setCreatetime(new Date());
		log.setInputdata(buf.toString());
		log.setOutputdata(StringToolkit.getObjectString(result));;

		mapper.save(log);
	
	}
}

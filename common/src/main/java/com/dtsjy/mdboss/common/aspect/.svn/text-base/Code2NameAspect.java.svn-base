package com.dtsjy.mdboss.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dtsjy.mdboss.common.cache.redis.handler.RedisManager;

public class Code2NameAspect {

	static Logger logger = LoggerFactory.getLogger(Code2NameAspect.class);
	
	private RedisManager manager;

	public void setManager(RedisManager manager) {
		this.manager = manager;
	}

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		String type = null;
		Object value = null;
		Object[] args = joinPoint.getArgs();
		if(joinPoint.getSignature().getName().equals("appCode2Name")){
			type = "code2Name";
			value = manager.get(type, args);
		}else if (joinPoint.getSignature().getName().equals("appCode2NameValueList")){
			type = "code2NameValueList";
			value = manager.get(type, args);
		}
		
		if (null != value) {// 查缓存
			return value;
		} else {
			value = joinPoint.proceed();
			if (value != null) {
				manager.put(type, value, args);// 保存到缓存
			}else {//如果从数据库查询的值为空，则判断缓存是否有值，有值的话就清空掉。
				if (manager.exist(type, args)){
					manager.remove(type, args);
				}
			}
			return value;
		}
	}
	

}

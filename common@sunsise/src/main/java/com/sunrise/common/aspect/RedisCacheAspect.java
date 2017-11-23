package com.sunrise.common.aspect;

import com.sunrise.common.cache.redis.handler.RedisManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisCacheAspect {

	static Logger logger = LoggerFactory.getLogger(RedisCacheAspect.class);
	
	private RedisManager manager;
	private String type;

	public void setManager(RedisManager manager) {
		this.manager = manager;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		Object value = manager.get(type, args);
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

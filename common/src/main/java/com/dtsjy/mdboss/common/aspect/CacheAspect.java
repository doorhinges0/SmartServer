package com.dtsjy.mdboss.common.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dtsjy.mdboss.common.cache.redis.keyresolver.KeyResolver;

public class CacheAspect {

	static Logger logger = LoggerFactory.getLogger(CacheAspect.class);

	Map<Object, Object> mapping;
	KeyResolver keyResolver;
	String group;

	public void setMapping(Map<Object, Object> mapping) {
		this.mapping = mapping;
	}

	public void setKeyResolver(KeyResolver keyResolver) {
		this.keyResolver = keyResolver;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		String key = group + ":" + keyResolver.getKey(joinPoint.getArgs());

		if (mapping.containsKey(key)) {// 查缓存
			return mapping.get(key);
		} else {
			Object value = joinPoint.proceed();
			if (value != null) {
				mapping.put(key, value);// 保存到缓存
			}
			return value;
		}

	}

}

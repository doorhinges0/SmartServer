package com.sunrise.common.cache.redis.valueresolver;

import com.sunrise.common.cache.redis.handler.RedisClient;
import com.sunrise.common.cache.redis.keyresolver.KeyResolver;
import com.sunrise.common.utils.redis.SerializeUtils;
import com.sunrise.common.utils.string.StringToolkit;

public class CommonObjValueResolver implements ValueResolver {
	
	private static final String CLASSMAPPING_KEY = "CommonObj_CLASS_MAPPING";

	@Override
	public Object getValue(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		Object val = null;
		String field = keyResolver.getField(args);
		try {
			String clsName = redisClient.hget(CLASSMAPPING_KEY, field);
			if (StringToolkit.isNotEmpty(clsName)) {
				Class<?> clazz = Class.forName(clsName);
				String key = String.format("%s:%s", keyResolver.getGroup(), clsName);
				byte[] bytes = redisClient.hget(key.getBytes(), field.getBytes());
				String jsonVal = redisClient.hget(key, field);
				return SerializeUtils.unserialize(bytes);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return val;
	}

	@Override
	public void putValue(Object val, Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		if (null == val) {
			return;
		}
		
		String field = keyResolver.getField(args);
		String group = keyResolver.getGroup();
		String clsName = val.getClass().getName();
		
		redisClient.hset(CLASSMAPPING_KEY, field, clsName);
		String key = String.format("%s:%s", group, clsName);
		redisClient.hset(key.getBytes(), field.getBytes(), SerializeUtils.serialize(val));
	}

	@Override
	public boolean exist(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long remove(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		// TODO Auto-generated method stub
		return null;
	}

}

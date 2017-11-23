package com.sunrise.common.cache.redis.valueresolver;

import com.sunrise.common.cache.redis.handler.RedisClient;
import com.sunrise.common.cache.redis.keyresolver.KeyResolver;
import com.sunrise.common.utils.string.StringToolkit;

public class DefaultValueResolver implements ValueResolver {
	
	public Object getValue(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		String key = keyResolver.getKey(args);
		if (StringToolkit.isNotEmpty(key)){
			return redisClient.get(key);
		}
		return null;
	}
	
	@Override
	public boolean exist(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		String key = keyResolver.getKey(args);
		return redisClient.exists(key);
	}
	
	
	public void putValue(Object val, Object[] args,KeyResolver keyResolver,RedisClient redisClient) {
		String key = keyResolver.getKey(args);
		if (StringToolkit.isNotEmpty(key)){
			redisClient.set(key,StringToolkit.getObjectString(val));
		}
	}
	
	@Override
	public Long remove(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		Long result = 0L;
		String key = keyResolver.getKey(args);
		if (StringToolkit.isNotEmpty(key)){
			result = redisClient.del(key);
		}
		return result;
	}
}

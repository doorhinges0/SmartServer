package com.sunrise.common.cache.redis.valueresolver;

import com.sunrise.common.cache.redis.handler.RedisClient;
import com.sunrise.common.cache.redis.keyresolver.KeyResolver;
import com.sunrise.common.utils.string.StringToolkit;

public class Code2NameValueResolver implements ValueResolver {

	public Object getValue(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		String field = keyResolver.getField(args);
		String key =  keyResolver.getKey(args);
		if (redisClient.hexists(key, field)){
			return redisClient.hget(key, field);
		}
		return null;
	}
	
	@Override
	public boolean exist(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		String field = keyResolver.getField(args);
		String key =  keyResolver.getKey(args);
		return redisClient.hexists(key, field);
	}
	
	public void putValue(Object val, Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		String field = keyResolver.getField(args);
		String key =  keyResolver.getKey(args);
		if (StringToolkit.isNotEmpty(key)&&StringToolkit.isNotEmpty(field)){
			redisClient.hset(key, field, StringToolkit.getObjectString(val));
		}
	}
	
	@Override
	public Long remove(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		Long result = 0L;
		String field = keyResolver.getField(args);
		String key =  keyResolver.getKey(args);
		if (redisClient.hexists(key, field)){
			result = redisClient.hdel(key, field);
		}
		
		return result;
	}
}

package com.dtsjy.mdboss.common.cache.redis.valueresolver;

import java.util.Map;

import com.dtsjy.mdboss.common.cache.redis.handler.RedisClient;
import com.dtsjy.mdboss.common.cache.redis.keyresolver.KeyResolver;

public class Code2NameValueListValueResolver implements ValueResolver {

	public Object getValue(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		String key =  keyResolver.getKey(args);
		if (redisClient.exists(key)){
			return redisClient.hgetAll(key);
		}
		return null;
	}
	
	@Override
	public boolean exist(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		String key =  keyResolver.getKey(args);
		return redisClient.exists(key);
	}
	
	public void putValue(Object vMap, Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		if (null != vMap && Map.class.isAssignableFrom(vMap.getClass())){
			String key =  keyResolver.getKey(args);
			Map<String, String> valueMap = (Map<String, String>)vMap;
			redisClient.pipelinedHSet(valueMap, key);
		}
	}
	
	@Override
	public Long remove(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		Long result = 0L;
		String key =  keyResolver.getKey(args);
		if (redisClient.exists(key)){
			result = redisClient.del(key);
		}
		
		return result;
	}
}

package com.sunrise.common.cache.redis.valueresolver;

import com.sunrise.common.cache.redis.handler.RedisClient;
import com.sunrise.common.cache.redis.keyresolver.KeyResolver;


public interface ValueResolver {
	Object getValue(Object[] args,KeyResolver keyResolver,RedisClient redisClient);
	void putValue(Object val,Object[] args,KeyResolver keyResolver,RedisClient redisClient);
	boolean exist(Object[] args,KeyResolver keyResolver,RedisClient redisClient);
	Long remove(Object[] args,KeyResolver keyResolver,RedisClient redisClient);
}

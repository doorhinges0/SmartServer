package com.dtsjy.mdboss.common.cache.redis.handler;

import java.util.List;
import java.util.Set;

import com.dtsjy.mdboss.common.cache.redis.keyresolver.KeyResolver;
import com.dtsjy.mdboss.common.cache.redis.valueresolver.ValueResolver;

public interface RedisManager {

	void setKeyResolver(KeyResolver keyResolver);
	
	void setValueResolver(ValueResolver valueResolver);
	
	RedisClient getClient();
	
	void setRedisClient(RedisClient redisClient);
	
	Object get(String type,Object[] args);
	
	void put(String type,Object val,Object[] args);
	
	void refresh(List<Object> voList,String refreshKey);
	
	void remove(String type,Object[] args);
	
	boolean exist(String type,Object[] args);
	
	Set<String> keys(String type,String pattern);
	
}

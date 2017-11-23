package com.sunrise.common.cache.redis.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sunrise.common.cache.redis.refresh.RedisRefresher;
import com.sunrise.common.cache.redis.valueresolver.ValueResolver;
import com.sunrise.common.utils.config.CommonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.common.cache.redis.keyresolver.KeyResolver;
import com.sunrise.common.utils.SpringCtxUtils;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.string.StringToolkit;

public class DefaultRedisManager implements RedisManager {
	
	private static Logger logger = LoggerFactory.getLogger(DefaultRedisManager.class);
	
	private KeyResolver keyResolver;
	private ValueResolver valueResolver;
	private RedisClient redisClient;
	private Map<String, KeyResolver> keyResolverMap;
	private Map<String, ValueResolver> valueResolverMap;
	private Map<String, RedisClient> redisClientMap;
	private Map<String, RedisRefresher> redisRefresherMap;
	
	public void setKeyResolver(KeyResolver keyResolver) {
		this.keyResolver = keyResolver;

	}

	public void setValueResolver(ValueResolver valueResolver) {
		this.valueResolver = valueResolver;
	}
	
	public void setRedisClient(RedisClient redisClient) {
		this.redisClient = redisClient;
	}
	

	public void setRedisClientMap(Map<String, RedisClient> redisClientMap) {
		this.redisClientMap = redisClientMap;
	}

	public RedisClient getClient() {
		return redisClient;
	}
	
	
	public void setRedisRefresherMap(Map<String, RedisRefresher> redisRefresherMap) {
		this.redisRefresherMap = redisRefresherMap;
	}
	
	public boolean exist(String type,Object[] args){
		KeyResolver keyResolver = getKeyResolver(type);
		ValueResolver valueResolver = getValueResolver(type);
		RedisClient redisClient = getRedisClient(type);
		return valueResolver.exist(args, keyResolver, redisClient);
	}
	
	@Override
	public void remove(String type, Object[] args) {
		KeyResolver keyResolver = getKeyResolver(type);
		ValueResolver valueResolver = getValueResolver(type);
		RedisClient redisClient = getRedisClient(type);
		valueResolver.remove(args, keyResolver, redisClient);
	}

	public Object get(String type, Object[] args) {
		if (CommonConfig.isRedisCacheDisabled() || CommonConfig.isRedisCacheGetDisabled()){
			return null;
		}
		
		KeyResolver keyResolver = getKeyResolver(type);
		ValueResolver valueResolver = getValueResolver(type);
		RedisClient redisClient = getRedisClient(type);
		return valueResolver.getValue(args, keyResolver,redisClient);
	}

	public void put(String type,Object val,Object[] args){
		if (CommonConfig.isRedisCacheDisabled() || CommonConfig.isRedisCachePutDisabled()){
			return ;
		}
		
		KeyResolver keyResolver = getKeyResolver(type);
		ValueResolver valueResolver = getValueResolver(type);
		RedisClient redisClient = getRedisClient(type);
		valueResolver.putValue(val, args, keyResolver, redisClient);
	}
	
	
	private RedisClient getRedisClient(String type){
		RedisClient ret = this.redisClient;
		if (null != redisClientMap && StringToolkit.isNotEmpty(type)){
			if (redisClientMap.containsKey(type)){
				ret = redisClientMap.get(type);
			}
		}
		
		return ret;
	}
	
	private RedisRefresher getRedisRefresher(String type){
		RedisRefresher ret = null;
		if (null != redisRefresherMap && StringToolkit.isNotEmpty(type)){
			if (redisRefresherMap.containsKey(type)){
				ret = redisRefresherMap.get(type);
			}
		}
		
		return ret;
	}
	
	
	private KeyResolver getKeyResolver(String type){
		KeyResolver ret = this.keyResolver;
		if (null != keyResolverMap && StringToolkit.isNotEmpty(type)){
			if (keyResolverMap.containsKey(type)){
				ret = keyResolverMap.get(type);
			}
		}
		
		if (null == ret){
			ret = SpringCtxUtils.getBean("defaultKeyResolver",KeyResolver.class);
		}
		return ret;
	}
	
	private ValueResolver getValueResolver(String type){
		ValueResolver ret = this.valueResolver;
		if (null != valueResolverMap && StringToolkit.isNotEmpty(type)){
			if (valueResolverMap.containsKey(type)){
				ret =  valueResolverMap.get(type);
			}
		}
		
		if (null == ret){
			ret = SpringCtxUtils.getBean("defaultValueResolver",ValueResolver.class);
		}
		return ret;
	}

	public void setKeyResolverMap(Map<String, KeyResolver> keyResolverMap) {
		this.keyResolverMap = keyResolverMap;
	}

	public void setValueResolverMap(Map<String, ValueResolver> valueResolverMap) {
		this.valueResolverMap = valueResolverMap;
	}
	
	@Override
	public void refresh(List<Object> voList, String refreshKey) {
		RedisRefresher.lock.lock();
		try {
			if (CollectionUtils.isNotEmpty(voList)){
				if (StringToolkit.isEmpty(refreshKey)){
					refreshKey = voList.get(0).getClass().getName();
				}
				RedisRefresher refresher = getRedisRefresher(refreshKey);
				if (null != refresher){
					refresher.refreshCache(voList);
				}
				
			}
		} catch (Exception e) {
			logger.error("refresh error, voList: " + voList + ", refreshKey: " + refreshKey, e);
		}finally{
			RedisRefresher.lock.unlock();
		}
	}
	
	@Override
	public Set<String> keys(String type, String pattern) {
		KeyResolver keyResolver = getKeyResolver(type);
		if (StringToolkit.isNotEmpty(keyResolver.getGroup())){
			pattern = keyResolver.getGroup() + ":" + pattern;
		}
		RedisClient redisClient = getRedisClient(type);
		return redisClient.keys(pattern);
	}
}

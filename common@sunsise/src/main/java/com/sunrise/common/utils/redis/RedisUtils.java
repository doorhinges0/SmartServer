package com.sunrise.common.utils.redis;

import com.sunrise.common.cache.redis.handler.RedisManager;
import com.sunrise.common.cache.redis.handler.SentinelRedisClientTemplate;
import com.sunrise.common.utils.SpringCtxUtils;
import com.sunrise.common.utils.config.CommonConfig;

public class RedisUtils {

	private static RedisManager redisManager = SpringCtxUtils.getBean(RedisManager.class);
	
	private static SentinelRedisClientTemplate redisTemplate=SpringCtxUtils.getBean(SentinelRedisClientTemplate.class); 
	
	
	
	
	public static enum RTYPE {
		DEFAULT("default"),
		CODE2NAME("code2Name"),
		CODE2NAMEVALUELIST("code2NameValueList"),
		COMMONCONFIG("commonConfig"),
		COMMONOBJ("commonObj");
		
//		<entry key="default" value-ref="defaultValueResolver"></entry>
//		<entry key="code2Name" value-ref="code2NameValueResolver"></entry>
//		<entry key="code2NameValueList" value-ref="code2NameValueListValueResolver"></entry>
//		<entry key="commonConfig" value-ref="commonConfigValueResolver"></entry>
		
		private String text;
		
		private RTYPE(String text) {
			this.text = text;
		}
		
		public String text() {
			return this.text;
		}
	}
	
	/**
	 * 从 commonConfig 类型的缓存获取对象
	 * @param args
	 * @return
	 */
	/*public static Object getCommonConfig(Object[] args) {
		return redisManager.get(RTYPE.COMMONCONFIG.text(), args);
	}*/
	
	/**
	 * 从 commonConfig 类型的缓存获取对象
	 * @param args
	 * @return
	 */
	/*@SuppressWarnings("unchecked")
	public static <T>T getCommonConfigObj(Object[] args) {
		Object obj = getCommonConfig(args);
		if (obj != null) {
			return (T) obj;
		}
		return null;
	}*/
	
	/**
	 * 放进 commonConfig 类型的缓存内
	 * @param val
	 * @param args
	 */
	public static void putCommonConfig(Object val, Object[] args) {
		redisManager.put(RTYPE.COMMONCONFIG.text(), val, args);
	}
	
	/**
	 * 从 commonConfig 类型的缓存获取对象
	 * @param args
	 * @return
	 */
	public static Object getDefault(Object[] args) {
		return redisManager.get(RTYPE.DEFAULT.text(), args);
	}
	
	/**
	 * 从 commonConfig 类型的缓存获取对象
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T>T getDefaultObj(Object[] args) {
		Object obj = getDefault(args);
		if (obj != null) {
			return (T) obj;
		}
		return null;
	}
	
	/**
	 * 放进 commonConfig 类型的缓存内
	 * @param val
	 * @param args
	 */
	public static void putDefault(Object val, Object[] args) {
		redisManager.put(RTYPE.DEFAULT.text(), val, args);
	}
	
	/**
	 * 从 commonConfig 类型的缓存获取对象
	 * @param args
	 * @return
	 */
	public static Object getCommonObj(Object[] args) {
		return redisManager.get(RTYPE.COMMONOBJ.text(), args);
	}
	
	/**
	 * 从 commonConfig 类型的缓存获取对象
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T>T getCommonObjObj(Object[] args) {
		Object obj = getCommonObj(args);
		if (obj != null) {
			return (T) obj;
		}
		return null;
	}
	
	/**
	 * 放进 commonConfig 类型的缓存内
	 * @param val
	 * @param args
	 */
	public static void putCommonObj(Object val, Object[] args) {
		redisManager.put(RTYPE.COMMONOBJ.text(), val, args);
	}
	
	
	/**
	 * 从缓存取值
	 * @param key
	 * @param value
	 * @return
	 */
	public static String set(String key,String value){
		if (CommonConfig.isRedisCacheDisabled() || CommonConfig.isRedisCachePutDisabled()){
			return null;
		}
		return redisTemplate.set(key, value);
	}
	/**
	 * 从缓存取值
	 * @param key
	 * @return 
	 */
	public static String get(String key){
		if (CommonConfig.isRedisCacheDisabled() || CommonConfig.isRedisCacheGetDisabled()){
			return null;
		}
		return redisTemplate.get(key);
	}
	/**
	 * 
	 * @param key
	 * @return 被删除 key的数量
	 */
	public static long del(String key){
		return redisTemplate.del(key);
	}
	/**
	 * 设置过期时间
	 * @param key
	 * @param seconds
	 * @return
	 */
	public static long expire(String key, int seconds){
		return redisTemplate.expire(key, seconds);
	}
}
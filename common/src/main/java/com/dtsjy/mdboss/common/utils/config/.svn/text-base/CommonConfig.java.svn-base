package com.dtsjy.mdboss.common.utils.config;

import com.dtsjy.mdboss.common.cache.redis.handler.RedisManager;
import com.dtsjy.mdboss.common.model.SerialNoHolder;
import com.dtsjy.mdboss.common.model.SerialNoHolder4Rest;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class CommonConfig {
	private static final String runMode = Settings.RUNMODE.toString();

	public static boolean runInProduct() {
		return runMode.toUpperCase().equals(RunMode.PRODUCT);
	}

	public static boolean runInLocal() {
		return runMode.toUpperCase().equals(RunMode.LOCAL);
	}

	public static boolean runInTest() {
		return runMode.toUpperCase().equals(RunMode.LOCAL);
	}

	public static boolean runNotInProduct() {
		return runMode.toUpperCase().equals(RunMode.LOCAL)
				|| runMode.toUpperCase().equals(RunMode.TEST);
	}
	
	public static String getEnvAppCode(){
		if (StringToolkit.isNotEmpty(SerialNoHolder.appcode.get())){
			return SerialNoHolder.appcode.get();
		}
		return "None-EnvAppCode";
	}
	
	public static String getEnvUserCode(){
		if (StringToolkit.isNotEmpty(SerialNoHolder.userCode.get())){
			return SerialNoHolder.userCode.get();
		}else if (StringToolkit.isNotEmpty(SerialNoHolder4Rest.userCode.get())){
			return SerialNoHolder4Rest.userCode.get();
		}
		return "None-EvnUserCode";
	}
	
	public static String getEnvSerialNo(){
		if (StringToolkit.isNotEmpty(SerialNoHolder.serialNo.get())){
			return SerialNoHolder.serialNo.get();
		}else if (StringToolkit.isNotEmpty(SerialNoHolder4Rest.serialNo.get())){
			return SerialNoHolder4Rest.serialNo.get();
		}
		return "None-EvnserialNo";
	}
	
	public static void enableRedisCache(){
		RedisManager manager = SpringCtxUtils.getBean(RedisManager.class);
		manager.getClient().set("mdboss_disable_rediscache", "0");
	}
	
	public static void disableRedisCache(){
		RedisManager manager = SpringCtxUtils.getBean(RedisManager.class);
		manager.getClient().set("mdboss_disable_rediscache", "1");
	}
	
	public static void disableRedisCachePut(){
		RedisManager manager = SpringCtxUtils.getBean(RedisManager.class);
		manager.getClient().set("mdboss_disable_rediscache", "2");
	}
	
	public static void disableRedisCacheGet(){
		RedisManager manager = SpringCtxUtils.getBean(RedisManager.class);
		manager.getClient().set("mdboss_disable_rediscache", "3");
	}
	
	public static boolean isRedisCacheDisabled(){
		RedisManager manager = SpringCtxUtils.getBean(RedisManager.class);
		String enable = manager.getClient().get("mdboss_disable_rediscache");
		return "1".equals(enable);
	}
	
	public static boolean isRedisCachePutDisabled(){
		RedisManager manager = SpringCtxUtils.getBean(RedisManager.class);
		String enable = manager.getClient().get("mdboss_disable_rediscache");
		return "2".equals(enable);
	}
	
	public static boolean isRedisCacheGetDisabled(){
		RedisManager manager = SpringCtxUtils.getBean(RedisManager.class);
		String enable = manager.getClient().get("mdboss_disable_rediscache");
		return "3".equals(enable);
	}
}

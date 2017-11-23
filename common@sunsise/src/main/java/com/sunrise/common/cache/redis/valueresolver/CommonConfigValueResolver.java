package com.sunrise.common.cache.redis.valueresolver;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.sunrise.common.cache.redis.handler.RedisClient;
import com.sunrise.common.cache.redis.keyresolver.KeyResolver;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.json.JsonUtil;
import com.sunrise.common.utils.string.StringToolkit;

public class CommonConfigValueResolver implements ValueResolver {
	private static final String CLASSMAPPING_KEY = "CommonConfig_CLASS_MAPPING";

	public Object getValue(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		Object val = null;
		String field = keyResolver.getField(args);

		try {
			String clsName = redisClient.hget(CLASSMAPPING_KEY, field);
			if (StringToolkit.isNotEmpty(clsName)) {
				Class<?> clazz = Class.forName(clsName);
				String key = String.format("%s:%s", keyResolver.getGroup(),
						clsName);
				String jsonVal = redisClient.hget(key, field);

				if (JsonUtil.isJSONArray(jsonVal)) {
					val = JSONArray.parseArray(jsonVal, clazz);
				} else {
					val = JsonUtil.parseObject(jsonVal, clazz);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return val;
	}

	@Override
	public boolean exist(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		Boolean val = false;
		String field = keyResolver.getField(args);
		String clsName = redisClient.hget(CLASSMAPPING_KEY, field);
		if (StringToolkit.isNotEmpty(clsName)) {
			String key = String
					.format("%s:%s", keyResolver.getGroup(), clsName);
			val = redisClient.hexists(key, field);
		}
		return val;
	}

	public void putValue(Object val, Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		if (null == val) {
			val = "";
		}

		String field = keyResolver.getField(args);
		String group = keyResolver.getGroup();
		String clsName = val.getClass().getName();

		if (List.class.isAssignableFrom(val.getClass())) {
			if (CollectionUtils.isNotEmpty((List) val)) {// 不为空
				clsName = ((List) val).get(0).getClass().getName();
			} else {
				clsName = Object.class.getName();
			}
		}
		redisClient.hset(CLASSMAPPING_KEY, field, clsName);
		String key = String.format("%s:%s", group, clsName);
		redisClient.hset(key, field, JsonUtil.toJSonWithDate(val));
	}

	@Override
	public Long remove(Object[] args, KeyResolver keyResolver,
			RedisClient redisClient) {
		String field = keyResolver.getField(args);
		Long result = 0L;
		try {
			String clsName = redisClient.hget(CLASSMAPPING_KEY, field);
			if (StringToolkit.isNotEmpty(clsName)) {
				Class<?> clazz = Class.forName(clsName);
				String key = String.format("%s:%s", keyResolver.getGroup(),
						clsName);
				if (redisClient.hexists(key, field)) {
					result = redisClient.hdel(key, field);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}
}

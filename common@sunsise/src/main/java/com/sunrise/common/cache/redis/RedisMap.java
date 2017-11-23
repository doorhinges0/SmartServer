package com.sunrise.common.cache.redis;

import java.util.HashMap;

import redis.clients.jedis.JedisPool;

public class RedisMap extends HashMap<String, String> {

	private static final long serialVersionUID = -5261292936721575704L;

	JedisPool pool;

	public void setPool(JedisPool pool) {
		this.pool = pool;
	}

	@Override
	public String put(String key, String value) {
		pool.getResource().set(key.toString(), value.toString());
		return value;
	}

	@Override
	public String get(Object key) {
		if (key != null) {
			return pool.getResource().get(key.toString());
		} else {
			return null;
		}
	}
}

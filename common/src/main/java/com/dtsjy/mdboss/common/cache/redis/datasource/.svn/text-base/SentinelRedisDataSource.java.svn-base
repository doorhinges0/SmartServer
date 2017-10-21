package com.dtsjy.mdboss.common.cache.redis.datasource;

import redis.clients.jedis.Jedis;

public interface SentinelRedisDataSource {
	public abstract Jedis getRedisClient();
    public void returnResource(Jedis jedis);
    public void returnResource(Jedis jedis,boolean broken);
}

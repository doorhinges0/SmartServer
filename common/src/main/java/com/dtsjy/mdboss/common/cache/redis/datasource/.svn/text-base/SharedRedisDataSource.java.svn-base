package com.dtsjy.mdboss.common.cache.redis.datasource;

import redis.clients.jedis.ShardedJedis;

public interface SharedRedisDataSource {
	public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}

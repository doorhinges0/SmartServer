package com.dtsjy.mdboss.common.cache.redis.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class SharedRedisDataSourceImpl implements SharedRedisDataSource {

	private static final Logger log = LoggerFactory.getLogger(SharedRedisDataSourceImpl.class);

    @Autowired
    private ShardedJedisPool    shardedJedisPool;

    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            log.error("getSharedRedisClent error", e);
        }
        return null;
    }

    public void returnResource(ShardedJedis shardedJedis) {
    	shardedJedis.close();
//        shardedJedisPool.returnResource(shardedJedis);
    }

    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
    	returnResource(shardedJedis);
//        if (broken) {
//            shardedJedisPool.returnBrokenResource(shardedJedis);
//        } else {
//            shardedJedisPool.returnResource(shardedJedis);
//        }
    }

}

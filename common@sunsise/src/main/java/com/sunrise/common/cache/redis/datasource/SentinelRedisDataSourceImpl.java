package com.sunrise.common.cache.redis.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class SentinelRedisDataSourceImpl implements SentinelRedisDataSource {

	private static final Logger log = LoggerFactory.getLogger(SentinelRedisDataSourceImpl.class);

    @Autowired
    private JedisSentinelPool    sentinelJedisPool;

    public Jedis getRedisClient() {
        try {
            Jedis jedis = sentinelJedisPool.getResource();
            return jedis;
        } catch (Exception e) {
            log.error("getSentinelRedisClent error", e);
        }
        return null;
    }

    public void returnResource(Jedis Jedis) {
    	Jedis.close();
    }

    public void returnResource(Jedis Jedis, boolean broken) {
    	returnResource(Jedis);
    }

}

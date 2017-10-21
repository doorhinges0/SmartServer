package com.dtsjy.mdboss.common.cache.redis.handler;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtsjy.mdboss.common.cache.redis.datasource.SharedRedisDataSource;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

public class SharedRedisClientTemplate implements RedisClient {
	private static final Logger log = LoggerFactory
			.getLogger(SharedRedisClientTemplate.class);

	@Autowired
	private SharedRedisDataSource redisDataSource;

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#disconnect()
	 */
	public void disconnect() {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		shardedJedis.disconnect();
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#set(java.lang.String, java.lang.String)
	 */
	public String set(String key, String value) {
		String result = null;

		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.set(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#get(java.lang.String)
	 */
	public String get(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}

		boolean broken = false;
		try {
			result = shardedJedis.get(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#exists(java.lang.String)
	 */
	public Boolean exists(String key) {
		Boolean result = false;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.exists(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#type(java.lang.String)
	 */
	public String type(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.type(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#expire(java.lang.String, int)
	 */
	public Long expire(String key, int seconds) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.expire(key, seconds);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#expireAt(java.lang.String, long)
	 */
	public Long expireAt(String key, long unixTime) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.expireAt(key, unixTime);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#ttl(java.lang.String)
	 */
	public Long ttl(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.ttl(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#setbit(java.lang.String, long, boolean)
	 */
	public boolean setbit(String key, long offset, boolean value) {

		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		boolean result = false;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.setbit(key, offset, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getbit(java.lang.String, long)
	 */
	public boolean getbit(String key, long offset) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		boolean result = false;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;

		try {
			result = shardedJedis.getbit(key, offset);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#setrange(java.lang.String, long, java.lang.String)
	 */
	public long setrange(String key, long offset, String value) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		long result = 0;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.setrange(key, offset, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getrange(java.lang.String, long, long)
	 */
	public String getrange(String key, long startOffset, long endOffset) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		String result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getrange(key, startOffset, endOffset);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getSet(java.lang.String, java.lang.String)
	 */
	public String getSet(String key, String value) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getSet(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#setnx(java.lang.String, java.lang.String)
	 */
	public Long setnx(String key, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.setnx(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#setex(java.lang.String, int, java.lang.String)
	 */
	public String setex(String key, int seconds, String value) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.setex(key, seconds, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#decrBy(java.lang.String, long)
	 */
	public Long decrBy(String key, long integer) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.decrBy(key, integer);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#decr(java.lang.String)
	 */
	public Long decr(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.decr(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#incrBy(java.lang.String, long)
	 */
	public Long incrBy(String key, long integer) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.incrBy(key, integer);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#incr(java.lang.String)
	 */
	public Long incr(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.incr(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#append(java.lang.String, java.lang.String)
	 */
	public Long append(String key, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.append(key, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#substr(java.lang.String, int, int)
	 */
	public String substr(String key, int start, int end) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.substr(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Long hset(String key, String field, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hset(key, field, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hget(java.lang.String, java.lang.String)
	 */
	public String hget(String key, String field) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hget(key, field);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hsetnx(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Long hsetnx(String key, String field, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hsetnx(key, field, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hmset(java.lang.String, java.util.Map)
	 */
	public String hmset(String key, Map<String, String> hash) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hmset(key, hash);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hmget(java.lang.String, java.lang.String)
	 */
	public List<String> hmget(String key, String... fields) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hmget(key, fields);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hincrBy(java.lang.String, java.lang.String, long)
	 */
	public Long hincrBy(String key, String field, long value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hincrBy(key, field, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hexists(java.lang.String, java.lang.String)
	 */
	public Boolean hexists(String key, String field) {
		Boolean result = false;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hexists(key, field);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#del(java.lang.String)
	 */
	public Long del(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.del(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hdel(java.lang.String, java.lang.String)
	 */
	public Long hdel(String key, String field) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hdel(key, field);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hlen(java.lang.String)
	 */
	public Long hlen(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hlen(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hkeys(java.lang.String)
	 */
	public Set<String> hkeys(String key) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hkeys(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hvals(java.lang.String)
	 */
	public List<String> hvals(String key) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hvals(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hgetAll(java.lang.String)
	 */
	public Map<String, String> hgetAll(String key) {
		Map<String, String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.hgetAll(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	// ================list ====== l表示 list或 left, r表示right====================
	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#rpush(java.lang.String, java.lang.String)
	 */
	public Long rpush(String key, String string) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.rpush(key, string);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lpush(java.lang.String, java.lang.String)
	 */
	public Long lpush(String key, String string) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.lpush(key, string);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#llen(java.lang.String)
	 */
	public Long llen(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.llen(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lrange(java.lang.String, long, long)
	 */
	public List<String> lrange(String key, long start, long end) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.lrange(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#ltrim(java.lang.String, long, long)
	 */
	public String ltrim(String key, long start, long end) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.ltrim(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lindex(java.lang.String, long)
	 */
	public String lindex(String key, long index) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.lindex(key, index);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lset(java.lang.String, long, java.lang.String)
	 */
	public String lset(String key, long index, String value) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.lset(key, index, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lrem(java.lang.String, long, java.lang.String)
	 */
	public Long lrem(String key, long count, String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.lrem(key, count, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lpop(java.lang.String)
	 */
	public String lpop(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.lpop(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#rpop(java.lang.String)
	 */
	public String rpop(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.rpop(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	// return 1 add a not exist value ,
	// return 0 add a exist value
	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#sadd(java.lang.String, java.lang.String)
	 */
	public Long sadd(String key, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.sadd(key, member);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#smembers(java.lang.String)
	 */
	public Set<String> smembers(String key) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.smembers(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#srem(java.lang.String, java.lang.String)
	 */
	public Long srem(String key, String member) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();

		Long result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.srem(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#spop(java.lang.String)
	 */
	public String spop(String key) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		String result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.spop(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#scard(java.lang.String)
	 */
	public Long scard(String key) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		Long result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.scard(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#sismember(java.lang.String, java.lang.String)
	 */
	public Boolean sismember(String key, String member) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		Boolean result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.sismember(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#srandmember(java.lang.String)
	 */
	public String srandmember(String key) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		String result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.srandmember(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zadd(java.lang.String, double, java.lang.String)
	 */
	public Long zadd(String key, double score, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.zadd(key, score, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrange(java.lang.String, int, int)
	 */
	public Set<String> zrange(String key, int start, int end) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.zrange(key, start, end);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrem(java.lang.String, java.lang.String)
	 */
	public Long zrem(String key, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.zrem(key, member);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zincrby(java.lang.String, double, java.lang.String)
	 */
	public Double zincrby(String key, double score, String member) {
		Double result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zincrby(key, score, member);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrank(java.lang.String, java.lang.String)
	 */
	public Long zrank(String key, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrank(key, member);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrank(java.lang.String, java.lang.String)
	 */
	public Long zrevrank(String key, String member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrank(key, member);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrange(java.lang.String, int, int)
	 */
	public Set<String> zrevrange(String key, int start, int end) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrange(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeWithScores(java.lang.String, int, int)
	 */
	public Set<Tuple> zrangeWithScores(String key, int start, int end) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeWithScores(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeWithScores(java.lang.String, int, int)
	 */
	public Set<Tuple> zrevrangeWithScores(String key, int start, int end) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrangeWithScores(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zcard(java.lang.String)
	 */
	public Long zcard(String key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zcard(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zscore(java.lang.String, java.lang.String)
	 */
	public Double zscore(String key, String member) {
		Double result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zscore(key, member);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#sort(java.lang.String)
	 */
	public List<String> sort(String key) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.sort(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#sort(java.lang.String, redis.clients.jedis.SortingParams)
	 */
	public List<String> sort(String key, SortingParams sortingParameters) {
		List<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.sort(key, sortingParameters);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zcount(java.lang.String, double, double)
	 */
	public Long zcount(String key, double min, double max) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zcount(key, min, max);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeByScore(java.lang.String, double, double)
	 */
	public Set<String> zrangeByScore(String key, double min, double max) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeByScore(key, min, max);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeByScore(java.lang.String, double, double)
	 */
	public Set<String> zrevrangeByScore(String key, double max, double min) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrangeByScore(key, max, min);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeByScore(java.lang.String, double, double, int, int)
	 */
	public Set<String> zrangeByScore(String key, double min, double max,
			int offset, int count) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeByScore(key, min, max, offset, count);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeByScore(java.lang.String, double, double, int, int)
	 */
	public Set<String> zrevrangeByScore(String key, double max, double min,
			int offset, int count) {
		Set<String> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis
					.zrevrangeByScore(key, max, min, offset, count);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeByScoreWithScores(java.lang.String, double, double)
	 */
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeByScoreWithScores(key, min, max);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeByScoreWithScores(java.lang.String, double, double)
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max,
			double min) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrangeByScoreWithScores(key, max, min);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeByScoreWithScores(java.lang.String, double, double, int, int)
	 */
	public Set<Tuple> zrangeByScoreWithScores(String key, double min,
			double max, int offset, int count) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeByScoreWithScores(key, min, max,
					offset, count);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeByScoreWithScores(java.lang.String, double, double, int, int)
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max,
			double min, int offset, int count) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrangeByScoreWithScores(key, max, min,
					offset, count);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zremrangeByRank(java.lang.String, int, int)
	 */
	public Long zremrangeByRank(String key, int start, int end) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zremrangeByRank(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zremrangeByScore(java.lang.String, double, double)
	 */
	public Long zremrangeByScore(String key, double start, double end) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zremrangeByScore(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#linsert(java.lang.String, redis.clients.jedis.BinaryClient.LIST_POSITION, java.lang.String, java.lang.String)
	 */
	public Long linsert(String key, LIST_POSITION where, String pivot,
			String value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.linsert(key, where, pivot, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#set(byte[], byte[])
	 */
	public String set(byte[] key, byte[] value) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.set(key, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#get(byte[])
	 */
	public byte[] get(byte[] key) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.get(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#exists(byte[])
	 */
	public Boolean exists(byte[] key) {
		Boolean result = false;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.exists(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#type(byte[])
	 */
	public String type(byte[] key) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.type(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#expire(byte[], int)
	 */
	public Long expire(byte[] key, int seconds) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.expire(key, seconds);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#expireAt(byte[], long)
	 */
	public Long expireAt(byte[] key, long unixTime) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.expireAt(key, unixTime);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#ttl(byte[])
	 */
	public Long ttl(byte[] key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.ttl(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getSet(byte[], byte[])
	 */
	public byte[] getSet(byte[] key, byte[] value) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.getSet(key, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#setnx(byte[], byte[])
	 */
	public Long setnx(byte[] key, byte[] value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.setnx(key, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#setex(byte[], int, byte[])
	 */
	public String setex(byte[] key, int seconds, byte[] value) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.setex(key, seconds, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#decrBy(byte[], long)
	 */
	public Long decrBy(byte[] key, long integer) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.decrBy(key, integer);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#decr(byte[])
	 */
	public Long decr(byte[] key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.decr(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#incrBy(byte[], long)
	 */
	public Long incrBy(byte[] key, long integer) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.incrBy(key, integer);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#incr(byte[])
	 */
	public Long incr(byte[] key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.incr(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#append(byte[], byte[])
	 */
	public Long append(byte[] key, byte[] value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.append(key, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#substr(byte[], int, int)
	 */
	public byte[] substr(byte[] key, int start, int end) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.substr(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hset(byte[], byte[], byte[])
	 */
	public Long hset(byte[] key, byte[] field, byte[] value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hset(key, field, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hget(byte[], byte[])
	 */
	public byte[] hget(byte[] key, byte[] field) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hget(key, field);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hsetnx(byte[], byte[], byte[])
	 */
	public Long hsetnx(byte[] key, byte[] field, byte[] value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hsetnx(key, field, value);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hmset(byte[], java.util.Map)
	 */
	public String hmset(byte[] key, Map<byte[], byte[]> hash) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hmset(key, hash);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hmget(byte[], byte)
	 */
	public List<byte[]> hmget(byte[] key, byte[]... fields) {
		List<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hmget(key, fields);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hincrBy(byte[], byte[], long)
	 */
	public Long hincrBy(byte[] key, byte[] field, long value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hincrBy(key, field, value);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hexists(byte[], byte[])
	 */
	public Boolean hexists(byte[] key, byte[] field) {
		Boolean result = false;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hexists(key, field);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hdel(byte[], byte[])
	 */
	public Long hdel(byte[] key, byte[] field) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hdel(key, field);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hlen(byte[])
	 */
	public Long hlen(byte[] key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hlen(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hkeys(byte[])
	 */
	public Set<byte[]> hkeys(byte[] key) {
		Set<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hkeys(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hvals(byte[])
	 */
	public Collection<byte[]> hvals(byte[] key) {
		Collection<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hvals(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#hgetAll(byte[])
	 */
	public Map<byte[], byte[]> hgetAll(byte[] key) {
		Map<byte[], byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.hgetAll(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#rpush(byte[], byte[])
	 */
	public Long rpush(byte[] key, byte[] string) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.rpush(key, string);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lpush(byte[], byte[])
	 */
	public Long lpush(byte[] key, byte[] string) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.lpush(key, string);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#llen(byte[])
	 */
	public Long llen(byte[] key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.llen(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lrange(byte[], int, int)
	 */
	public List<byte[]> lrange(byte[] key, int start, int end) {
		List<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.lrange(key, start, end);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#ltrim(byte[], int, int)
	 */
	public String ltrim(byte[] key, int start, int end) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.ltrim(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lindex(byte[], int)
	 */
	public byte[] lindex(byte[] key, int index) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.lindex(key, index);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lset(byte[], int, byte[])
	 */
	public String lset(byte[] key, int index, byte[] value) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.lset(key, index, value);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lrem(byte[], int, byte[])
	 */
	public Long lrem(byte[] key, int count, byte[] value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.lrem(key, count, value);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#lpop(byte[])
	 */
	public byte[] lpop(byte[] key) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.lpop(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#rpop(byte[])
	 */
	public byte[] rpop(byte[] key) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.rpop(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#sadd(byte[], byte[])
	 */
	public Long sadd(byte[] key, byte[] member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.sadd(key, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#smembers(byte[])
	 */
	public Set<byte[]> smembers(byte[] key) {
		Set<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.smembers(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#srem(byte[], byte[])
	 */
	public Long srem(byte[] key, byte[] member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.srem(key, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#spop(byte[])
	 */
	public byte[] spop(byte[] key) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.spop(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#scard(byte[])
	 */
	public Long scard(byte[] key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.scard(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#sismember(byte[], byte[])
	 */
	public Boolean sismember(byte[] key, byte[] member) {
		Boolean result = false;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.sismember(key, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#srandmember(byte[])
	 */
	public byte[] srandmember(byte[] key) {
		byte[] result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.srandmember(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zadd(byte[], double, byte[])
	 */
	public Long zadd(byte[] key, double score, byte[] member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zadd(key, score, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrange(byte[], int, int)
	 */
	public Set<byte[]> zrange(byte[] key, int start, int end) {
		Set<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrange(key, start, end);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrem(byte[], byte[])
	 */
	public Long zrem(byte[] key, byte[] member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrem(key, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zincrby(byte[], double, byte[])
	 */
	public Double zincrby(byte[] key, double score, byte[] member) {
		Double result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zincrby(key, score, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrank(byte[], byte[])
	 */
	public Long zrank(byte[] key, byte[] member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrank(key, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrank(byte[], byte[])
	 */
	public Long zrevrank(byte[] key, byte[] member) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrank(key, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrange(byte[], int, int)
	 */
	public Set<byte[]> zrevrange(byte[] key, int start, int end) {
		Set<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrange(key, start, end);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeWithScores(byte[], int, int)
	 */
	public Set<Tuple> zrangeWithScores(byte[] key, int start, int end) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeWithScores(key, start, end);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeWithScores(byte[], int, int)
	 */
	public Set<Tuple> zrevrangeWithScores(byte[] key, int start, int end) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrangeWithScores(key, start, end);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zcard(byte[])
	 */
	public Long zcard(byte[] key) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zcard(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zscore(byte[], byte[])
	 */
	public Double zscore(byte[] key, byte[] member) {
		Double result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zscore(key, member);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#sort(byte[])
	 */
	public List<byte[]> sort(byte[] key) {
		List<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.sort(key);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#sort(byte[], redis.clients.jedis.SortingParams)
	 */
	public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
		List<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.sort(key, sortingParameters);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zcount(byte[], double, double)
	 */
	public Long zcount(byte[] key, double min, double max) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zcount(key, min, max);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeByScore(byte[], double, double)
	 */
	public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
		Set<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeByScore(key, min, max);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeByScore(byte[], double, double, int, int)
	 */
	public Set<byte[]> zrangeByScore(byte[] key, double min, double max,
			int offset, int count) {
		Set<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeByScore(key, min, max, offset, count);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeByScoreWithScores(byte[], double, double)
	 */
	public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeByScoreWithScores(key, min, max);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrangeByScoreWithScores(byte[], double, double, int, int)
	 */
	public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min,
			double max, int offset, int count) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrangeByScoreWithScores(key, min, max,
					offset, count);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeByScore(byte[], double, double)
	 */
	public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
		Set<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrangeByScore(key, max, min);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeByScore(byte[], double, double, int, int)
	 */
	public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min,
			int offset, int count) {
		Set<byte[]> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis
					.zrevrangeByScore(key, max, min, offset, count);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeByScoreWithScores(byte[], double, double)
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max,
			double min) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrangeByScoreWithScores(key, max, min);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zrevrangeByScoreWithScores(byte[], double, double, int, int)
	 */
	public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max,
			double min, int offset, int count) {
		Set<Tuple> result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zrevrangeByScoreWithScores(key, max, min,
					offset, count);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zremrangeByRank(byte[], int, int)
	 */
	public Long zremrangeByRank(byte[] key, int start, int end) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zremrangeByRank(key, start, end);

		} catch (Exception e) {

			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#zremrangeByScore(byte[], double, double)
	 */
	public Long zremrangeByScore(byte[] key, double start, double end) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.zremrangeByScore(key, start, end);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#linsert(byte[], redis.clients.jedis.BinaryClient.LIST_POSITION, byte[], byte[])
	 */
	public Long linsert(byte[] key, LIST_POSITION where, byte[] pivot,
			byte[] value) {
		Long result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {

			result = shardedJedis.linsert(key, where, pivot, value);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#pipelined(redis.clients.jedis.ShardedJedisPipeline)
	 */
	public List<Object> pipelined(ShardedJedisPipeline shardedJedisPipeline) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		List<Object> result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.pipelined(shardedJedisPipeline);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getShard(byte[])
	 */
	public Jedis getShard(byte[] key) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		Jedis result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getShard(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getShard(java.lang.String)
	 */
	public Jedis getShard(String key) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		Jedis result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getShard(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getShardInfo(byte[])
	 */
	public JedisShardInfo getShardInfo(byte[] key) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		JedisShardInfo result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getShardInfo(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getShardInfo(java.lang.String)
	 */
	public JedisShardInfo getShardInfo(String key) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		JedisShardInfo result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getShardInfo(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getKeyTag(java.lang.String)
	 */
	public String getKeyTag(String key) {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		String result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getKeyTag(key);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getAllShardInfo()
	 */
	public Collection<JedisShardInfo> getAllShardInfo() {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		Collection<JedisShardInfo> result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getAllShardInfo();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dtsjy.mdboss.common.cache.redis.handler.RedisClient#getAllShards()
	 */
	public Collection<Jedis> getAllShards() {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		Collection<Jedis> result = null;
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.getAllShards();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}
	
	public List<Object> pipelinedHSet(Map<String, String> valueMap, String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Set<String> keys(String pattern) {
		throw new UnsupportedOperationException("Method keys is not supported!");
	}
}

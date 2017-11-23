package com.sunrise.common.cache.redis.handler;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.BinaryClient.LIST_POSITION;

public interface RedisClient {

	public abstract void disconnect();

	/**
	 * 设置单个值
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public abstract String set(String key, String value);

	/**
	 * 获取单个值
	 * 
	 * @param key
	 * @return
	 */
	public abstract String get(String key);

	public abstract Boolean exists(String key);

	public abstract String type(String key);

	/**
	 * 在某段时间后实现
	 * 
	 * @param key
	 * @param unixTime
	 * @return
	 */
	public abstract Long expire(String key, int seconds);

	/**
	 * 在某个时间点失效
	 * 
	 * @param key
	 * @param unixTime
	 * @return
	 */
	public abstract Long expireAt(String key, long unixTime);

	public abstract Long ttl(String key);

	public abstract boolean setbit(String key, long offset, boolean value);

	public abstract boolean getbit(String key, long offset);

	public abstract long setrange(String key, long offset, String value);

	public abstract String getrange(String key, long startOffset, long endOffset);

	public abstract String getSet(String key, String value);

	public abstract Long setnx(String key, String value);

	public abstract String setex(String key, int seconds, String value);

	public abstract Long decrBy(String key, long integer);

	public abstract Long decr(String key);

	public abstract Long incrBy(String key, long integer);

	public abstract Long incr(String key);

	public abstract Long append(String key, String value);

	public abstract String substr(String key, int start, int end);

	public abstract Long hset(String key, String field, String value);

	public abstract String hget(String key, String field);

	public abstract Long hsetnx(String key, String field, String value);

	public abstract String hmset(String key, Map<String, String> hash);

	public abstract List<String> hmget(String key, String... fields);

	public abstract Long hincrBy(String key, String field, long value);

	public abstract Boolean hexists(String key, String field);

	public abstract Long del(String key);

	public abstract Long hdel(String key, String field);

	public abstract Long hlen(String key);

	public abstract Set<String> hkeys(String key);

	public abstract List<String> hvals(String key);

	public abstract Map<String, String> hgetAll(String key);

	// ================list ====== l表示 list或 left, r表示right====================
	public abstract Long rpush(String key, String string);

	public abstract Long lpush(String key, String string);

	public abstract Long llen(String key);

	public abstract List<String> lrange(String key, long start, long end);

	public abstract String ltrim(String key, long start, long end);

	public abstract String lindex(String key, long index);

	public abstract String lset(String key, long index, String value);

	public abstract Long lrem(String key, long count, String value);

	public abstract String lpop(String key);

	public abstract String rpop(String key);

	// return 1 add a not exist value ,
	// return 0 add a exist value
	public abstract Long sadd(String key, String member);

	public abstract Set<String> smembers(String key);

	public abstract Long srem(String key, String member);

	public abstract String spop(String key);

	public abstract Long scard(String key);

	public abstract Boolean sismember(String key, String member);

	public abstract String srandmember(String key);

	public abstract Long zadd(String key, double score, String member);

	public abstract Set<String> zrange(String key, int start, int end);

	public abstract Long zrem(String key, String member);

	public abstract Double zincrby(String key, double score, String member);

	public abstract Long zrank(String key, String member);

	public abstract Long zrevrank(String key, String member);

	public abstract Set<String> zrevrange(String key, int start, int end);

	public abstract Set<Tuple> zrangeWithScores(String key, int start, int end);

	public abstract Set<Tuple> zrevrangeWithScores(String key, int start,
			int end);

	public abstract Long zcard(String key);

	public abstract Double zscore(String key, String member);

	public abstract List<String> sort(String key);

	public abstract List<String> sort(String key,
			SortingParams sortingParameters);

	public abstract Long zcount(String key, double min, double max);

	public abstract Set<String> zrangeByScore(String key, double min, double max);

	public abstract Set<String> zrevrangeByScore(String key, double max,
			double min);

	public abstract Set<String> zrangeByScore(String key, double min,
			double max, int offset, int count);

	public abstract Set<String> zrevrangeByScore(String key, double max,
			double min, int offset, int count);

	public abstract Set<Tuple> zrangeByScoreWithScores(String key, double min,
			double max);

	public abstract Set<Tuple> zrevrangeByScoreWithScores(String key,
			double max, double min);

	public abstract Set<Tuple> zrangeByScoreWithScores(String key, double min,
			double max, int offset, int count);

	public abstract Set<Tuple> zrevrangeByScoreWithScores(String key,
			double max, double min, int offset, int count);

	public abstract Long zremrangeByRank(String key, int start, int end);

	public abstract Long zremrangeByScore(String key, double start, double end);

	public abstract Long linsert(String key, LIST_POSITION where, String pivot,
			String value);

	public abstract String set(byte[] key, byte[] value);

	public abstract byte[] get(byte[] key);

	public abstract Boolean exists(byte[] key);

	public abstract String type(byte[] key);

	public abstract Long expire(byte[] key, int seconds);

	public abstract Long expireAt(byte[] key, long unixTime);

	public abstract Long ttl(byte[] key);

	public abstract byte[] getSet(byte[] key, byte[] value);

	public abstract Long setnx(byte[] key, byte[] value);

	public abstract String setex(byte[] key, int seconds, byte[] value);

	public abstract Long decrBy(byte[] key, long integer);

	public abstract Long decr(byte[] key);

	public abstract Long incrBy(byte[] key, long integer);

	public abstract Long incr(byte[] key);

	public abstract Long append(byte[] key, byte[] value);

	public abstract byte[] substr(byte[] key, int start, int end);

	public abstract Long hset(byte[] key, byte[] field, byte[] value);

	public abstract byte[] hget(byte[] key, byte[] field);

	public abstract Long hsetnx(byte[] key, byte[] field, byte[] value);

	public abstract String hmset(byte[] key, Map<byte[], byte[]> hash);

	public abstract List<byte[]> hmget(byte[] key, byte[]... fields);

	public abstract Long hincrBy(byte[] key, byte[] field, long value);

	public abstract Boolean hexists(byte[] key, byte[] field);

	public abstract Long hdel(byte[] key, byte[] field);

	public abstract Long hlen(byte[] key);

	public abstract Set<byte[]> hkeys(byte[] key);

	public abstract Collection<byte[]> hvals(byte[] key);

	public abstract Map<byte[], byte[]> hgetAll(byte[] key);

	public abstract Long rpush(byte[] key, byte[] string);

	public abstract Long lpush(byte[] key, byte[] string);

	public abstract Long llen(byte[] key);

	public abstract List<byte[]> lrange(byte[] key, int start, int end);

	public abstract String ltrim(byte[] key, int start, int end);

	public abstract byte[] lindex(byte[] key, int index);

	public abstract String lset(byte[] key, int index, byte[] value);

	public abstract Long lrem(byte[] key, int count, byte[] value);

	public abstract byte[] lpop(byte[] key);

	public abstract byte[] rpop(byte[] key);

	public abstract Long sadd(byte[] key, byte[] member);

	public abstract Set<byte[]> smembers(byte[] key);

	public abstract Long srem(byte[] key, byte[] member);

	public abstract byte[] spop(byte[] key);

	public abstract Long scard(byte[] key);

	public abstract Boolean sismember(byte[] key, byte[] member);

	public abstract byte[] srandmember(byte[] key);

	public abstract Long zadd(byte[] key, double score, byte[] member);

	public abstract Set<byte[]> zrange(byte[] key, int start, int end);

	public abstract Long zrem(byte[] key, byte[] member);

	public abstract Double zincrby(byte[] key, double score, byte[] member);

	public abstract Long zrank(byte[] key, byte[] member);

	public abstract Long zrevrank(byte[] key, byte[] member);

	public abstract Set<byte[]> zrevrange(byte[] key, int start, int end);

	public abstract Set<Tuple> zrangeWithScores(byte[] key, int start, int end);

	public abstract Set<Tuple> zrevrangeWithScores(byte[] key, int start,
			int end);

	public abstract Long zcard(byte[] key);

	public abstract Double zscore(byte[] key, byte[] member);

	public abstract List<byte[]> sort(byte[] key);

	public abstract List<byte[]> sort(byte[] key,
			SortingParams sortingParameters);

	public abstract Long zcount(byte[] key, double min, double max);

	public abstract Set<byte[]> zrangeByScore(byte[] key, double min, double max);

	public abstract Set<byte[]> zrangeByScore(byte[] key, double min,
			double max, int offset, int count);

	public abstract Set<Tuple> zrangeByScoreWithScores(byte[] key, double min,
			double max);

	public abstract Set<Tuple> zrangeByScoreWithScores(byte[] key, double min,
			double max, int offset, int count);

	public abstract Set<byte[]> zrevrangeByScore(byte[] key, double max,
			double min);

	public abstract Set<byte[]> zrevrangeByScore(byte[] key, double max,
			double min, int offset, int count);

	public abstract Set<Tuple> zrevrangeByScoreWithScores(byte[] key,
			double max, double min);

	public abstract Set<Tuple> zrevrangeByScoreWithScores(byte[] key,
			double max, double min, int offset, int count);

	public abstract Long zremrangeByRank(byte[] key, int start, int end);

	public abstract Long zremrangeByScore(byte[] key, double start, double end);

	public abstract Long linsert(byte[] key, LIST_POSITION where, byte[] pivot,
			byte[] value);

	public abstract List<Object> pipelined(
			ShardedJedisPipeline shardedJedisPipeline);

	public abstract Jedis getShard(byte[] key);

	public abstract Jedis getShard(String key);

	public abstract JedisShardInfo getShardInfo(byte[] key);

	public abstract JedisShardInfo getShardInfo(String key);

	public abstract String getKeyTag(String key);

	public abstract Collection<JedisShardInfo> getAllShardInfo();

	public abstract Collection<Jedis> getAllShards();
	
	/////////////////////////////////////
	public List<Object> pipelinedHSet(Map<String, String> valueMap,String key);
	
	///
	public Set<String> keys(final String pattern);

}
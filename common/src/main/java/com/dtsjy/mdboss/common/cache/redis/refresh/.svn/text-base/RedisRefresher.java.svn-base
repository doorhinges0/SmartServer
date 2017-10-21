package com.dtsjy.mdboss.common.cache.redis.refresh;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface RedisRefresher {
	public static final Lock lock = new ReentrantLock();
	public  void  refreshCache(List<?> voList);
}

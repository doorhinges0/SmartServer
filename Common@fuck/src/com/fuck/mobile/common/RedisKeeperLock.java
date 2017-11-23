package com.fuck.mobile.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisKeeperLock implements IRedisKeeperLock {
	static Log log = LogFactory.getLog(RedisKeeperLock.class);
	private static final String PREX = "RedisKeeperLock->";
	@Autowired
	private IRedisService redis;
	
	public RedisKeeperLock()
	{
		
	}
	
	public RedisKeeperLock(IRedisService redis)
	{
		this.redis = redis;
	}
	

	private class LockEx implements IRedisKeeperLock.Lock {
		String name;
		boolean isStart = true;
		Object lock = new Object();

		public LockEx(String name) {
			this.name = name;
		}

		@Override
		public void lock() {
			while (redis.incr(PREX + name, 1L) != 1L) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
			new Thread(() -> {
				while (isStart) {
					redis.set(PREX + name, "1",3);
					synchronized (lock) {
						try {
							lock.wait(1000);
						} catch (Exception e) {
						}
					}
				}
				redis.del(PREX + name);
			}).start();
		}

		@Override
		public void unlock() {
			isStart = false;
			synchronized (lock) {
				try {
					lock.notify();
				} catch (Exception e) {
				}
			}
		}

	}

	/**
	 * 永久锁，除非是应用解锁或程序结束
	 * 
	 * @param name
	 */
	public Lock getLock(String name) {
		return new LockEx(name);
	}

	public static void main(String[] args) {
		RedisServiceImp imp = new RedisServiceImp();
		imp.initRedis("redis-cluster://redis.fuck.com:7006,redis.fuck.com:7001,redis.fuck.com:7002,redis.fuck.com:7003,redis.fuck.com:7004,redis.fuck.com:7005", null, null, null);
		
		final RedisKeeperLock l = new RedisKeeperLock(imp);
		
		
		new Thread(()->{
			Lock lock =	l.getLock("a");
			
			lock.lock();
			System.out.println("in lock 1....");
			try {
				Thread.sleep(15000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("un lock 1....");
			lock.unlock();
			
		}).start();
		
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		new Thread(()->{
			
    Lock lock =	l.getLock("a");
			
			lock.lock();
			System.out.println("in lock 2....");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("un lock 2....");
			lock.unlock();
			
		}).start();
		
	}



}

package com.fuck.mobile.common;

import java.util.ArrayList;
import java.util.List;

import com.fuck.mobile.spring.DefaultTransactionSynchronization;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class RedisLockImp implements IRedisLock {

	static Log log = LogFactory.getLog(RedisLockImp.class);
	private static final String PREX = "RedisLock->";

	@Autowired
	private IRedisService redis;
	
	private class TransactionSynchronizationEx extends DefaultTransactionSynchronization
	{
		String lockName;
		TransactionSynchronizationEx(String name)
		{
			this.lockName = name;
		}
		@Override
		public void afterCompletion(int status) {
			unlock(lockName);
		}
	}

	private ThreadLocal<List<String>> localThreadlockName = new ThreadLocal<List<String>>() {
		@Override
		protected List<String> initialValue() {
			return new ArrayList<>();
		}
	};

	/**
	 * @category 根据名称锁
	 * @param name
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void lock(String name) {
		lock(name, 60);

	}

	
	/**
	 * @category 内存锁
	 * @param name
	 * @param timeout 单位上秒
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void lock(String name, int timeout) {
		if(localThreadlockName.get().contains(name))
		{
			return;
		}
		log.debug("Try to lock -> " + name);
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationEx(name));
		while(redis.incr(PREX + name, 1L) != 1L)
		{
			try
			{
				Thread.sleep(20);
			}catch(Exception e){}
		}
		redis.expire(PREX + name, timeout);
		log.debug("lock -> " + name);
		localThreadlockName.get().add(name);
		
	}
	
	
	@Override
	public void unlock(String name) {
		localThreadlockName.get().remove(name);
		log.debug("unlock -> " + name);
		redis.del(PREX + name);
	}

	@Override
	public boolean repeatOperateLock(String name, int timeout) {
		boolean f = redis.incr(PREX + name, 1L) == 1L;
		if(f)
		{
			redis.expire(PREX + name, timeout);
		}
		return f;
	}

	@Override
	public void repeatOperateLockWithException(String name, int timeout) throws RepeatOperateExcetion {
		
		boolean f = repeatOperateLock(name,timeout);
		if(!f)
		{
			throw new RepeatOperateExcetion();
		}
	}

}

package com.fuck.mobile.common;

/**
 * @category redis分布式锁，这个应用于非重要业务上，但也需要全局锁来实现
 * @author MegaX
 *
 */
public interface IRedisLock {
	
	public static class RepeatOperateExcetion extends Exception 
	{
		private static final long serialVersionUID = -296799782404619505L;
		
	}
	

	/**
	 * @category 根据名称锁
	 * @param name
	 */
	void lock(String name);
	
	/**
	 * @category 内存锁
	 * @param name
	 * @param timeout 单位上秒
	 */
	void lock(String name,int timeout);
	

	
	/**
	 * @category 解锁
	 * @param name
	 */
	void unlock(String name);
	
	/**
	 * @category 重复操作锁
	 * @param name
	 * @param timeout 单位上秒
	 * @return true，代表以前没加锁或加锁已失效，这次加锁成功，false，代表已经加速，这次加锁失败
	 */
	boolean repeatOperateLock(String name,int timeout);
	
	/**
	 * @category 重复操作锁
	 * @param name
	 * @param timeout
	 * @throws RepeatOperateExcetion
	 */
	void repeatOperateLockWithException(String name,int timeout) throws RepeatOperateExcetion;
	
}

package com.fuck.mobile.common;

/**
 * @category 永久锁,不会超时结束，除非是解锁或程序结束
 * @author MegaX
 *
 */
public interface IRedisKeeperLock {

	public static interface Lock
	{
		/**
		 * 永久锁，除非是应用解锁或程序结束
		 * @param name
		 */
		public void lock();
		public void unlock();
	}
	
	/**
	 * 永久锁，除非是应用解锁或程序结束
	 * @param name
	 */
	public Lock getLock(String name);
	
}

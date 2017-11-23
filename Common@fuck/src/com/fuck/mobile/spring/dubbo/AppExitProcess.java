package com.fuck.mobile.spring.dubbo;

import java.util.concurrent.locks.ReentrantLock;

public final class AppExitProcess {
	
	private static long invokeTime = 0;
	private static ReentrantLock lock = new ReentrantLock();
	private static boolean isExit = false;

	
	public static boolean isExit()
	{
		return isExit;
	}
	public static void Exit()
	{
		 isExit = true;
	}
	
	public static void beforeInvoke()
	{
		try
		{
			lock.lock();
			invokeTime++;
		}finally
		{
			lock.unlock();
		}
		
	}
	
	public static long getInvokeTimes()
	{
		return invokeTime;
	}
	
	
	public static void afterInvoke()
	{
		try
		{
			lock.lock();
			invokeTime--;
		}finally
		{
			lock.unlock();
		}
	}
	
}

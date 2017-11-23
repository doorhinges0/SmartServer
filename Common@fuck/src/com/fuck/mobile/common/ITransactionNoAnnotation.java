package com.fuck.mobile.common;

import org.springframework.transaction.annotation.Propagation;

/**
 * @category 手动支持事务，非代码注解
 * @author MegaX
 *
 */
public interface ITransactionNoAnnotation {

	public static interface TransactionRunnable
	{
		public void run() throws Exception;
	}
	
	public static interface Transaction4ReturnRunnable<T>
	{
		public T run() throws Exception;
	}
	
	
	/**
	 * @category 运行一个事务，默认是Propagation.REQUIRED
	 * @param run
	 */
	void execute(TransactionRunnable run) throws Exception;
	
	void execute(TransactionRunnable run,Propagation r) throws Exception;
	
	<T> T execute4Return(Transaction4ReturnRunnable<T> run) throws Exception;
	<T> T execute4Return(Transaction4ReturnRunnable<T> run,Propagation r) throws Exception;
	
}

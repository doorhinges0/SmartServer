package com.fuck.mobile.spring;

import org.springframework.transaction.support.TransactionSynchronization;

public class DefaultTransactionSynchronization implements
		TransactionSynchronization {
	
	/**
	 * @category Invoked after transaction commit.
	 */
	@Override
	public void afterCommit() {
	
	}
	/**
	 * @category Invoked after transaction commit/rollback.
	 */
	@Override
	public void afterCompletion(int status) {
		

	}
	
	

	/**
	 * @category Suspend this synchronization.
	 */
	@Override
	public void suspend() {
	

	}

	/**
	 * @category Resume this synchronization.
	 */
	@Override
	public void resume() {
		

	}

	/**
	 * @category Flush the underlying session to the datastore, if applicable: for example, a Hibernate/JPA session.
	 */
	@Override
	public void flush() {
	}

	/**
	 * @category Invoked before transaction commit (before "beforeCompletion").
	 */
	@Override
	public void beforeCommit(boolean readOnly) {
	

	}

	/**
	 * @category Invoked before transaction commit/rollback.
	 */
	@Override
	public void beforeCompletion() {
	}





}

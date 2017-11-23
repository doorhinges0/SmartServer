package com.fuck.mobile.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
class TransactionNoAnnotationImp implements ITransactionNoAnnotation {

	@Autowired
	private PlatformTransactionManager transactionManager;

	private static class MyProxyException extends RuntimeException {
		private static final long serialVersionUID = -8747494717633552543L;
		private Exception e;

		public MyProxyException(Exception cause) {
			super(cause);
			this.e = cause;
		}
	}

	@Override
	public void execute(TransactionRunnable run) throws Exception {
		execute(run,Propagation.REQUIRED);
	}

	@Override
	public void execute(TransactionRunnable run, Propagation r) throws Exception {
		TransactionTemplate tt = new TransactionTemplate(transactionManager);
		tt.setPropagationBehavior(r.value());
		try {
			tt.execute(new TransactionCallbackWithoutResult() {
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					try {
						run.run();
					} catch (Exception e) {
						throw new MyProxyException(e);
					}
				}
			});
		} catch (MyProxyException e) {
			throw e.e;
		}
	}
	
	@Override
	public <T> T execute4Return(Transaction4ReturnRunnable<T> run) throws Exception
	{
		return execute4Return(run,Propagation.REQUIRED);
	}
	@Override
	public <T> T execute4Return(Transaction4ReturnRunnable<T> run,Propagation r) throws Exception
	{
		TransactionTemplate tt = new TransactionTemplate(transactionManager);
		tt.setPropagationBehavior(r.value());
		try {
			return tt.execute(new TransactionCallback<T>() {

				@Override
				public T doInTransaction(TransactionStatus status) {
					try {
						return run.run();
					} catch (Exception e) {
						throw new MyProxyException(e);
					}
				}
			});
		} catch (MyProxyException e) {
			throw e.e;
		}
	}

}

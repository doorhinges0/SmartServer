package com.fuck.mobile.base.dao;

public class WaitForConnect {
	private boolean isFinished = false;
	private Throwable t= null;

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public boolean isFinished() {
		return isFinished;
	}
	
	public void setError(Throwable e)
	{
		this.t = e;
		isFinished = true;
	}
	
	public Throwable getError()
	{
		return this.t;
	}
	
	public boolean isError()
	{
		return t != null;
	}
}

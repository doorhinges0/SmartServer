package com.fuck.mobile.base.exception;

import com.fuck.mobile.util.ErrorCodeProperty;

public class BaseException extends Exception {

	private static final long serialVersionUID = -2553662280126616101L;

	private int errorCode = -1;
	private String msg;

	public BaseException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public BaseException(int errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public BaseException(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.msg = message;

	}

	public BaseException(int errorCode, String message, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.msg = message;
	}

	public String getMessage() {
		if(this.msg==null || "".equals(this.msg)){
			return  ErrorCodeProperty.getInstance().getValue(getErrorCode());
		}
		return this.msg;
	}
	
	public int getErrorCode()
	{
		return this.errorCode;
	}

}

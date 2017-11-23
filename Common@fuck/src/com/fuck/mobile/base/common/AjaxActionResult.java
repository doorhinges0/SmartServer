package com.fuck.mobile.base.common;



import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;



public class AjaxActionResult {
	static Log logger = LogFactory.getLog(AjaxActionResult.class);
	private boolean success;
	private Throwable exception;
	private String message;
	private int resultCode;
	private String accessToken;
	public final static String KEY_SUCCESS = "success";
	public final static String KEY_MESSAGE = "message";
	public final static String KEY_RESULT_CODE = "resultCode";
	public final static String KEY_EXCEPTION = "exception";
	public final static String KEY_ACCESS_TOKEN = "accessToken";
	private static Gson gs = new Gson();

	public String getJSONString() {
		Map<String, Object> jo = new HashMap<String, Object>();
		try {
			jo.put(KEY_SUCCESS, success);
			jo.put(KEY_MESSAGE, message);
			jo.put(KEY_RESULT_CODE, resultCode);
			jo.put(KEY_EXCEPTION, exception);
			jo.put(KEY_ACCESS_TOKEN, accessToken);
		} catch (Exception e) {
		}
		String r = gs.toJson(jo);
		logger.info(r);
		return r;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public static void main(String[] args)
	{
		AjaxActionResult arg = new AjaxActionResult();
		arg.setException(new Exception());
		arg.setMessage("msg");
		arg.setResultCode(100);
		arg.setSuccess(false);
		
		System.out.println(arg.getJSONString());
		
	}

}

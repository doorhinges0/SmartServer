package com.fuck.mobile.base.constant;

import java.util.concurrent.atomic.AtomicReference;

public interface Constants {
	
	public static final String  YunYing = "YunYing";
	public static final String  YunWei = "YunWei";
	
	public static final int DEFAULT_PAGESIZE = 10;
	
	public static final int DEFAULT_PAGENUM = 1;
	
	
	public static AtomicReference<String> FastdfsAccessBasePath = new AtomicReference<String>("http://192.168.0.206");
	
	
}

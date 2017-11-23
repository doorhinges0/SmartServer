package com.fuck.mobile.spring.dubbo;

public abstract class DubboApp {
	static {
		try {
			Class.forName("com.fuck.mobile.spring.dubbo.DubboClassLoader");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	private Object app;
	public DubboApp(String zkUrl, String zkPath, String appName, String appId, String packageName) {
		this(zkUrl, zkPath, appName, appId, packageName, false);
	}

	public DubboApp(String zkUrl, String zkPath, String appName, String appId, String packageName, boolean b) {
		app = new DubboAppSafe(zkUrl, zkPath, appName, appId, packageName, b); 
	}

	
	public final void startApp() {
		DubboAppSafe selfapp = (DubboAppSafe) app;
		selfapp.startApp();

	}
}

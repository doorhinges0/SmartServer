package com.fuck.mobile.base.utils;

import javax.servlet.http.HttpSession;

public class ControllerContext {
	private ControllerContext() {

	}
	private static final ThreadLocal<HttpSession> threadLocal = new ThreadLocal<HttpSession>();

	public static HttpSession getSession() {
		return threadLocal.get();
	}

	public static void setSession(HttpSession session) {
		threadLocal.set(session);
	}
}

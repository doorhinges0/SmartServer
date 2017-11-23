package com.fuck.mobile.spring.test;

import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class ServletConfigTest implements ServletConfig {
	Vector<?> obj = new Vector<Object>();
	@Override
	public String getServletName() {
	
		return "Test";
	}

	@Override
	public ServletContext getServletContext() {
		return new ServletContextTest();
	}

	@Override
	public String getInitParameter(String paramString) {
		return null;
	}

	@Override
	public Enumeration getInitParameterNames() {
		return obj.elements();
	}

}

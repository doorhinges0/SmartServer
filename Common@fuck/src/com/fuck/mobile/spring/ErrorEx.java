package com.fuck.mobile.spring;

import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.ServletContext;

public final class ErrorEx {

	final static String codestr = "<%@page import=\"java.lang.reflect.Method\"%><%@ page language=\"java\" contentType=\"text/html; charset=utf-8\" pageEncoding=\"utf-8\" trimDirectiveWhitespaces=\"true\" isErrorPage=\"true\"%><html><head><title>{$title}</title></head><body><%if(exception != null)exception.printStackTrace();	%>{$body}</body></html>";
	final static String errpath = "/WEB-INF/errpage/";
	static HashMap<Integer, String> errcodeString = new HashMap<Integer, String>();

	static {
		errcodeString.put(400, "400 Bad Request");
		errcodeString.put(401, "401 Unauthorized");
		errcodeString.put(402, "402 Payment Required");
		errcodeString.put(403, "403 Forbidden");
		errcodeString.put(404, "404 Not Found");
		errcodeString.put(405, "405 Method Not Allowed");
		errcodeString.put(406, "406 Not Acceptable");
		errcodeString.put(407, "407 Proxy Authentication Required");
		errcodeString.put(408, "408 Request Timeout");
		errcodeString.put(409, "409 Conflict");
		errcodeString.put(410, "410 Gone");
		errcodeString.put(411, "411 Length Required");
		errcodeString.put(412, "412 Precondition Failed");
		errcodeString.put(413, "413 Request Entity Too Large");
		errcodeString.put(414, "414 Request-URI Too Long");
		errcodeString.put(415, "415 Unsupported Media Type");
		errcodeString.put(416, "416 Requested Range Not Satisfiable");
		errcodeString.put(417, "417 Expectation Failed");

		errcodeString.put(500, "500 Internal Server Error");
		errcodeString.put(501, "501 Not Implemented");
		errcodeString.put(502, "502 Bad Gateway");
		errcodeString.put(503, "503 Service Unavailable");
		errcodeString.put(504, "504 Gateway Timeout");
		errcodeString.put(505, "505 HTTP Version Not Supported");

	}
	
	public static void init(ServletContext content)
	{
		try {
			Field f = content.getClass().getDeclaredField("context");
			f.setAccessible(true);
			Object context = f.get(content);
			f = context.getClass().getDeclaredField("context");
			f.setAccessible(true);
			context = f.get(context);			
			Method findErrorPage = context.getClass().getDeclaredMethod(
					"findErrorPage", int.class);
			findErrorPage.setAccessible(true);
			Class<?> ErrorPageClass = null;
			
			try
			{
				ErrorPageClass = Class.forName("org.apache.catalina.deploy.ErrorPage");
			}catch(ClassNotFoundException e)
			{
				
			}
			try
			{
				if(ErrorPageClass == null)
					ErrorPageClass = Class.forName("org.apache.tomcat.util.descriptor.web.ErrorPage");
			}catch(ClassNotFoundException e)
			{
			}
			
			if(ErrorPageClass == null)
			{
				throw new ClassNotFoundException("org.apache.tomcat.util.descriptor.web.ErrorPage");
			}
			
			Method addErrorPage = context.getClass().getDeclaredMethod(
					"addErrorPage", ErrorPageClass);
			addErrorPage.setAccessible(true);
			Method setErrorCode = ErrorPageClass.getDeclaredMethod("setErrorCode", int.class);
			setErrorCode.setAccessible(true);
			Method setLocation =  ErrorPageClass.getDeclaredMethod("setLocation", String.class);
			setLocation.setAccessible(true);
			
			String path = content.getRealPath("/");
			File dir =  new File(new File(path), errpath);
			dir.mkdirs();
			for (int i = 400; i <= 417; i++) {
				Object errpage = findErrorPage.invoke(context, i);
				if (errpage == null) {
					File file = new File(new File(path), errpath + "/" + i
							+ ".jsp");
					if (!file.exists()) {
						String msg = errcodeString.get(i);
						String codes = codestr.replaceAll("\\{\\$title\\}", msg);
						codes = codes.replaceAll("\\{\\$body\\}", msg);
						RandomAccessFile raf = null;
						try {
							raf = new RandomAccessFile(file, "rw");
							byte[] b = codes.getBytes("utf-8");
							raf.write(b);
						} catch (Exception ex) {
							ex.printStackTrace();
						} finally {
							if (raf != null) {
								try {
									raf.close();
								} catch (Exception ex1) {

								}
							}
						}
					}
					
					errpage = ErrorPageClass.newInstance();
					setErrorCode.invoke(errpage, i);
					setLocation.invoke(errpage, errpath + "/" + i
							+ ".jsp");
					
					addErrorPage.invoke(context, errpage);

				}
			}

			for (int i = 500; i <= 505; i++) {
				Object errpage = findErrorPage.invoke(context, i);
				if (errpage == null) {
					File file = new File(new File(path), errpath + "/" + i
							+ ".jsp");
					if (!file.exists()) {
						String msg = errcodeString.get(i);
						String codes = codestr.replaceAll("\\{\\$title\\}", msg);
						codes = codes.replaceAll("\\{\\$body\\}", msg);
						RandomAccessFile raf = null;
						try {
							raf = new RandomAccessFile(file, "rw");
							byte[] b = codes.getBytes("utf-8");
							raf.write(b);
						} catch (Exception ex) {
							ex.printStackTrace();
						} finally {
							if (raf != null) {
								try {
									raf.close();
								} catch (Exception ex1) {

								}
							}
						}
					}
					
					errpage = ErrorPageClass.newInstance();
					setErrorCode.invoke(errpage, i);
					setLocation.invoke(errpage, errpath + "/" + i
							+ ".jsp");
					
					addErrorPage.invoke(context, errpage);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}

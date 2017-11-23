package com.fuck.mobile.spring;

import org.springframework.web.servlet.HandlerInterceptor;

@SuppressWarnings("unchecked")
public class WebSpringDispatcherServlet extends SpringDispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6055349885445574096L;

	static
	{
		try
		{
			Class<?> c = Class.forName("com.fuck.user.interceptor.CheckLoginInterceptor");
			if(c == null)
			{
				throw new NullPointerException();
			}
			if(c != null)
			{
				SpringConfigurerEx.addInterceptorsEx((Class<? extends HandlerInterceptor>) c);
			}
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	

}

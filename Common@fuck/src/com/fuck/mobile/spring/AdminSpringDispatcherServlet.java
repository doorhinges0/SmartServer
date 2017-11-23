package com.fuck.mobile.spring;

import org.springframework.web.servlet.HandlerInterceptor;

@SuppressWarnings("unchecked")
public class AdminSpringDispatcherServlet extends SpringDispatcherServlet {

	private static final long serialVersionUID = -3321282160168736383L;
	
	static
	{
		try
		{
			Class<?> c = Class.forName("com.fuck.mobile.admin.permission.PermissionInterceptor");
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

package com.fuck.mobile.spring;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

public class SpringUtil {

	private static ApplicationContext app;
	private static Log log = LogFactory.getLog(SpringUtil.class);
	
	@Service
	public static class SprintUtilService
	{
		@Autowired
		ApplicationContext app;
		
		@PostConstruct
		void init()
		{
			log.debug("SprintUtil init app -> " +app);
			SpringUtil.app = this.app;
		}	
	}
	
	
	
	public static ApplicationContext ApplicationContext()
	{
		return app;
	}
	
	
	public static void main(String[] args) {
		System.out.println("init");
	}
}



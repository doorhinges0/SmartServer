package com.fuck.mobile.common.config;

import java.io.File;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ConfigServiceImp implements IConfigService {

	static Log log = LogFactory.getLog(ConfigServiceImp.class);
	
    private boolean isProduction = true;
	
	private boolean isWindow=false;
	
	@PostConstruct
	private void init()
	{
		log.debug("ConfigServiceImp init");
		try
		{
			String osname = System.getProperties().getProperty("os.name").toLowerCase();
			log.debug("OSName " + osname);
			if(osname.indexOf("windows") >= 0)
			{
				isProduction = false;
				isWindow=true;
			}else
			{
				File f = new File("/data/debug.oem");
				if(f.exists())
				{
					isProduction = false;
				}
			}
			log.debug("isProduction " + isProduction);
			
			
		}catch(Exception ex)
		{
			log.error("",ex);
		}
		
	}
	
	
	@Override
	public boolean isProduction() {
		return this.isProduction;
	}

	@Override
	public boolean isWindow() {
		return this.isWindow;
	}

}

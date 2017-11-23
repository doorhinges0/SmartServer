package com.fuck.mobile.spring.dubbo.kryo2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.serialize.Serialization;

@Component
public class Kryo2Check {
	
	static Log log = LogFactory.getLog(Kryo2Check.class);
	
	static
	{
		log.debug("do Kryo2Check....");
		ExtensionLoader<Serialization> loader=	ExtensionLoader.getExtensionLoader(Serialization.class);
		loader.getDefaultExtension();
		Serialization s = null;
		try
		{
			 s =	loader.getExtension("kryo2");
		}catch(Exception e)
		{
//			log.warn("", e);
		}
		
		if(s == null)
		{
			log.debug("not found kryo2...");
			log.debug("auto add kryo2...");
			loader.addExtension("kryo2", Kryo2Serialization.class);
			
			
		}
		
	}

}

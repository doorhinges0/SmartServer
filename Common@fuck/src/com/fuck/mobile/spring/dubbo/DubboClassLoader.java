package com.fuck.mobile.spring.dubbo;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import com.fuck.mobile.loader.CustomerRunnerJar;

public class DubboClassLoader {
	
	

	static
	{
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		
		if(cl instanceof URLClassLoader)
		{
			try {
			
			Method m = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
			m.setAccessible(true);
			List<File> fs =	CustomerRunnerJar.getRunAppJar();
			for(int i = 0; i < fs.size();i++)
			{
				m.invoke(cl, fs.get(i).toURI().toURL());
				
			}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
//		URLClassLoaderEx exloader = new URLClassLoaderEx(us, cl);
//		Thread.currentThread().setContextClassLoader(exloader);
	}
}

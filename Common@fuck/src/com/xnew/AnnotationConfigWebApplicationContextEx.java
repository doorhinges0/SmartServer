package com.xnew;

import com.fuck.mobile.spring.dubbo.DubboCleanup;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class AnnotationConfigWebApplicationContextEx extends
		AnnotationConfigWebApplicationContext {
	static Log log = LogFactory.getLog(AnnotationConfigWebApplicationContextEx.class);
	
	public AnnotationConfigWebApplicationContextEx()
	{
		setClassLoader(Thread.currentThread().getContextClassLoader());
//		KryoFactory.setDefaultClassLoader(Thread.currentThread().getContextClassLoader());
	}
	
	@Override
	public void close()
	{
		CloseEx cx = getBean(CloseEx.class);
		DubboCleanup conf = DubboCleanup.beginCleanUp(this);
		try
		{
			super.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		cx.closeEx();
		DubboCleanup.endCleanUp(conf);
	}

}

package com.xnew;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fuck.mobile.base.utils.ReflectUtil;



public class CloseEx {
	static Log log = LogFactory.getLog(CloseEx.class);
	private ArrayList<Object> objs = new ArrayList<Object>();
	
	
	public void addClose(Object obj)
	{
		if(obj == null)
		{
			return;
		}
		if(!objs.contains(obj))
		{
			objs.add(obj);
		}
	}
	
	
	void closeEx()
	{
		for(Object o : objs)
		{
			try
			{
				ReflectUtil.callMethod(o, "close2");
			}catch(Exception ex)
			{
			}
			
		}
		
		
	}
	
	
	

}

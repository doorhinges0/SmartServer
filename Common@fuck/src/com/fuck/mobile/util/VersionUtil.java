package com.fuck.mobile.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class VersionUtil {
	static Log log = LogFactory.getLog(VersionUtil.class);

	public static int StringVersion2IntVersion(String version)
	{
		try
		{
			if(version == null)
			{
				return 0;
			}
			int c = 0;
			String[] ss = version.split("\\.");
			if(ss.length >= 3)
			{
				c = Integer.parseInt( ss[2]) + ( Integer.parseInt( ss[1]) * 100) + ( Integer.parseInt( ss[0]) * 10000);
			}else if(ss.length >= 2)
			{
				c =  ( Integer.parseInt( ss[1]) * 100) + ( Integer.parseInt( ss[0]) * 10000);
			}else if(ss.length == 1)
			{
				c =  ( Integer.parseInt( ss[0]) * 10000);
			}
			
			
			return c;
		}catch(Exception e)
		{
			log.error("", e);
		}
		
		return -1;
	}
	
	
	
	public static void main(String[] args)
	{
		System.out.println(StringVersion2IntVersion("2.0.6"));
		System.out.println(StringVersion2IntVersion("2.0.11"));
	}
	
}

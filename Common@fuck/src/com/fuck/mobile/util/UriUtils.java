package com.fuck.mobile.util;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UriUtils {

	public static String getUrlWithQueryString(String url,Map<String, ?> maps,String charset)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		
		if(maps != null && maps.size() > 0)
		{
			if(sb.indexOf("?") < 0)
			{
				sb.append("?");
			}
			
			Iterator<String> k = maps.keySet().iterator();
			
			while(k.hasNext())
			{
				String key = k.next();
				Object v = maps.get(key);
				String value = "";
				if(v != null)
				{
					value = v.toString();
				}
				try
				{
				key =  URLEncoder.encode(key,charset);
				value =  URLEncoder.encode(value,charset);
				}catch(Exception ex)
				{
					
				}
				sb.append(key).append("=").append(value).append("&");
				
			}
			sb.delete(sb.length() - 1, sb.length());	
		}
		
		
		return sb.toString();
		
	}
	
	
	public static void main(String[] args)
	{
		HashMap<String, Object> maps = new HashMap<String, Object>();
		maps.put("aaa", "kkk");
		maps.put("aaa1", "测试短信");
		System.out.println(getUrlWithQueryString("abxc",maps,"utf-8"));
	}
	
}

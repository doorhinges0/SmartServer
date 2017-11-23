package com.fuck.mobile.base.utils;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;

public final class RedisHostAndPortUtil {
	
	
	public static Set<HostAndPort> getAddresses(String url)
	{
		HashSet<HostAndPort> addrs = new HashSet<HostAndPort>();
		String[] us = url.split(",");
		
		for(String u : us)
		{
			u = u.trim();
			int k = u.indexOf(":");
			HostAndPort ap = null; 
			if(k > 0)
			{
				int p = Integer.parseInt(u.substring(k + 1, u.length()));
				ap = new HostAndPort(u.substring(0,k), p);
				
			}else
			{
				ap = new HostAndPort(u, 6379);
			}
			addrs.add(ap);
		}	
		return addrs;
		 
	}
	
	public static void main(String[] args)
	{
		String u = "127.0.0.1,127.0.0.1:1234";
		
		System.out.println(getAddresses(u));
		
	}
	

}

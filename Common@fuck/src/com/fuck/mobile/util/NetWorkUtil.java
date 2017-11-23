package com.fuck.mobile.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.SecureRandom;

public final class NetWorkUtil {
	
	private static SecureRandom sr = new SecureRandom();
	private static int minPort = 50000;
	private static int maxPort = 60000;
	
	private static void bindPort(String host, int port) throws Exception {
		Socket s = new Socket();
		try {
			s.bind(new InetSocketAddress(host, port));
		} finally {
			s.close();
		}

	}

	public static boolean isPortAvailable(int port) {
		try {
			bindPort("0.0.0.0", port);
			bindPort(InetAddress.getLocalHost().getHostAddress(), port);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static int getAvailablePort()
	{
		do
		{
			int c = sr.nextInt();
			if(c == Integer.MIN_VALUE)
				continue;
			int port = Math.abs(c) % maxPort;
			if(port < minPort)
			{
				//port = minPort;
				continue;
			}
			
			if(isPortAvailable(port))
			{
				return port;
			}
			
		}while(true);
	}
	
	
	public static void main(String[] args) {
		for(int i = 0 ; i < 100; i++)
		{
			System.out.println(getAvailablePort());
		}
	}
	
}

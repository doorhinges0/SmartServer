package com.fuck.mobile.util;


import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class Device {
	
	private static String did = null;
	private static String servletName = "";

	public static void setDeviceId(String newid)
	{
		did = newid;
	}
	
	public static void setServletName(String name)
	{
		servletName = name;
	}
	
	public static String getDeviceId() {
		if(did != null)
		{
			return did;
		}
		
		String name = (System.getProperty("os.name", "Linux") +"_"+ System.getProperty("os.version","") + "-" + servletName );
		try {
//			name += "_" + java.net.InetAddress.getLocalHost().getHostAddress();
			Enumeration<NetworkInterface> el = NetworkInterface
					.getNetworkInterfaces();

			while (el.hasMoreElements()) {
				NetworkInterface inf =  el.nextElement();
				Enumeration<InetAddress> e2=	inf.getInetAddresses();
				while(e2.hasMoreElements())
				{
					InetAddress i4 =	e2.nextElement();
					if(i4 instanceof Inet4Address)
					{
						if(!"127.0.0.1".equalsIgnoreCase(i4.getHostAddress()))
						{
							name += "_" + i4.getHostAddress();
							byte[] mac =inf.getHardwareAddress();
							if (mac != null && mac.length > 0) {
								StringBuilder builder = new StringBuilder();
								for (byte b : mac) {
									String x = "00" + Integer.toHexString(b);
									builder.append(x.substring(x.length() - 2));
									//builder.append("_");
								}
								//builder.deleteCharAt(builder.length() - 1);
								did = name +"_" +  builder.toString();
								return did;
//								System.out.println(builder);
//								System.out.println(el.nextElement());
							}
						}

					}
					
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		did = name + "_00";
		return did;
	}

	public static void main(String[] args) {
		System.out.println(getDeviceId());
	}
}

package com.fuck.mobile.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class CustomerRunnerJar {

	private static final String localWindowsConfigName = "d:/config.properties";
	private static final String linuxConfigName = "/data/config/config.properties";
	
	public static List<File> getRunAppJar()
	{
		ArrayList<File> list = new ArrayList<>();
		Properties p =	PropertiesUtil.loadResource(localWindowsConfigName, linuxConfigName);
		String extDir = String.valueOf(p.get("ExtJar"));
		System.out.println("extDir -> " + extDir);
		if(extDir != null && extDir.length() > 0)
		{
			File dir = new File(extDir);
			if(dir.exists() && dir.isDirectory())
			{
				System.out.println("-----------------------------------------");
				System.out.println("Load app Jar.................................");
				System.out.println("-----------------------------------------");
				File[] fs =	dir.listFiles();
				ArrayList<File> log4jover = new ArrayList<>();
				ArrayList<File> log4j = new ArrayList<>();
				
				
				ArrayList<File> slf4japi = new ArrayList<>();
				ArrayList<File> slf4jlog4j = new ArrayList<>();
				
				for(File f : fs)
				{
					if(f.isFile() && f.getName().endsWith(".jar"))
					{
						if(f.getName().startsWith("log4j-over"))
						{
							log4jover.add(f);
						}else if(f.getName().startsWith("log4j")){
							log4j.add(f);
						}
						if(f.getName().startsWith("slf4j-api"))
						{
							slf4japi.add(f);
						}else if(f.getName().startsWith("slf4j-log4j") || f.getName().indexOf("slf4j")>=0){
							slf4jlog4j.add(f);
						}
						
						else
						{
							list.add(f);
						}
						
						
					}					
				}
				list.addAll(log4j);
				list.addAll(log4jover);
				
				list.addAll(slf4japi);
				list.addAll(slf4jlog4j);
				
				
			}
		}
		return list;
	}
	
	public static List<File> getRunTomcatJar()
	{
		ArrayList<File> list = new ArrayList<>();
		Properties p =	PropertiesUtil.loadResource(localWindowsConfigName, linuxConfigName);
		String extDir = String.valueOf(p.get("ExtJar"));
		if(extDir != null && extDir.length() > 0)
		{
			File dir = new File(extDir);
			if(dir.exists() && dir.isDirectory())
			{
				System.out.println("-----------------------------------------");
				System.out.println("Load tomcat Jar.................................");
				System.out.println("-----------------------------------------");
				File[] fs =	dir.listFiles();
				ArrayList<File> log4jover = new ArrayList<>();
				ArrayList<File> log4j = new ArrayList<>();
				
				
				ArrayList<File> slf4japi = new ArrayList<>();
				ArrayList<File> slf4jlog4j = new ArrayList<>();
				for(File f : fs)
				{
					if(f.isFile() && f.getName().endsWith(".jar") && !f.getName().startsWith("tomcat-"))
					{
					
						if(f.getName().startsWith("log4j-over"))
						{
							log4jover.add(f);
						}else if(f.getName().startsWith("log4j")){
							log4j.add(f);
						}
						if(f.getName().startsWith("slf4j-api"))
						{
							slf4japi.add(f);
						}else if(f.getName().startsWith("slf4j-log4j") || f.getName().indexOf("slf4j")>=0){
							slf4jlog4j.add(f);
						}
						
						else
						{
							list.add(f);
						}
					}					
				}
				list.addAll(log4j);
				list.addAll(log4jover);
				
				list.addAll(slf4japi);
				list.addAll(slf4jlog4j);
			}
		}
		return list;
	}
	
	
}

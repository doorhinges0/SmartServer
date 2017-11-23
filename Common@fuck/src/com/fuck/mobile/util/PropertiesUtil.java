package com.fuck.mobile.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class PropertiesUtil {
	static Log log = LogFactory.getLog(PropertiesUtil.class);
	
    private static Properties properties;
    
    private String proper_resource;

    
    public PropertiesUtil(String proper_resource) {
        this.proper_resource = proper_resource;
    }

    public Properties getProperties(){
        properties = getInstance();
        try {
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(proper_resource);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
    
    public static Properties getInstance(){
        if(null == properties){
            properties = new Properties();
        }
        return properties;
    }
    
    public static Properties loadResource(String file){
        properties = getInstance();
        try {
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(file);
            if(properties != null){
                properties.load(inputStream);
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    
    public static Properties loadResource(String jarFileName,String windowsFileName,String linuxFilename){
        properties = getInstance();
        try {
        	InputStream is = null;
    		
    		String osname = System.getProperties().getProperty("os.name").toLowerCase();
    		if(osname.indexOf("windows") >= 0)
    		{
    			try
    			{
    				File f = new File(windowsFileName);
    				if(f.exists() && f.isFile())
    				{
    					is = new FileInputStream(f);
    				}else
    				{
    					is = PropertiesUtil.class.getClassLoader().getResourceAsStream(jarFileName);
    				}
    			}catch(Exception e)
    			{
    			}
    			try
    			{
    				if(is == null)
    					is = PropertiesUtil.class.getResourceAsStream(jarFileName);
    			}catch(Exception e)
    			{}
    		}else
    		{
    			try {
    				is = new  FileInputStream(linuxFilename);
    			} catch (FileNotFoundException e1) {
    			}
    				
    			if(is == null){
    				log.debug(linuxFilename+"不存在，读取class里面"+jarFileName);
    				
    				try
    				{
    					is = PropertiesUtil.class.getClassLoader().getResourceAsStream(jarFileName);
    				}catch(Exception e)
    				{
    				}
    				try
    				{
    					if(is == null)
    						is = PropertiesUtil.class.getResourceAsStream(jarFileName);
    				}catch(Exception e)
    				{}
    				
    			}
    			 
    		}
    		if(is!=null){
    			properties.load(is);
    			is.close();
    		}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    
    public static void main(String[] args) {
        PropertiesUtil pu = new PropertiesUtil("weixin_basic.properties");
        Properties propsMap = pu.getProperties();
        
       
        Properties properties = loadResource("weixin_basic.properties");
        System.out.println(properties.getProperty("appId"));
    }
}
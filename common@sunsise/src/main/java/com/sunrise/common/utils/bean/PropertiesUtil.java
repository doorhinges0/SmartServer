package com.sunrise.common.utils.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

import com.sunrise.common.utils.string.StringToolkit;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesUtil {
	public static Properties loadProperties(EncodedResource resource) throws IOException {
		return PropertiesLoaderUtils.loadProperties(resource);
	}

	public static void fillProperties(Properties props, EncodedResource resource)
			throws IOException {
		PropertiesLoaderUtils.fillProperties(props, resource);
	}

	public static Properties loadProperties(Resource resource) throws IOException {
		return PropertiesLoaderUtils.loadProperties(resource);
	}

	public static void fillProperties(Properties props, Resource resource) throws IOException {
		PropertiesLoaderUtils.fillProperties(props, resource);
	}

	public static Properties loadAllProperties(String resourceName) throws IOException {
		return loadAllProperties(resourceName, null);
	}

	public static Properties loadAllProperties(String resourceName, ClassLoader classLoader) throws IOException {
		return PropertiesLoaderUtils.loadAllProperties(resourceName, classLoader);
	}
	
	  /**
	   * 更新指定properties文件的指定项
	   * @param filepath String
	   * @param key String
	   * @param value String
	   * @throws IOException
	   * @return boolean true:成功更新  false,不存在指定的项
	   */
	  public static boolean updatePropertyValue( String filepath, String key, String value ) throws IOException {
	    if ( !StringToolkit.isValuedString(filepath) )
	      throw new IOException( "文件路径为空" );

	    boolean isUpdate = false;

	    BufferedReader input = null;
	    BufferedWriter output = null;
	    String line = null;
	    StringBuffer buffer = new StringBuffer();
	    try {
	      //读
	      input = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
	      while ( (line=input.readLine())!=null ) {
	        if ( !line.startsWith("#") ) { //不是注解
	          String[] pair = line.split("=");
	          if (pair != null && pair.length > 0) { //读到数据
	            if ( pair[0].equals(key) ) {
	              //value = StringToolkit.GBtoISO( value );
	              line = key+"=" + value;
	              isUpdate = true; //是更新ZipUtils.java
	            }
	          }
	        }
	        buffer.append( line + "\r\n" );//换行
	      }


	      //写
	      output = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(filepath)));
	      output.write(buffer.toString());
	      output.flush();
	      output.close();
	      output = null;
	    } finally {
	      if ( input!=null ) input.close();
	      if ( output!=null ) output.close();
	    }
	    return isUpdate;
	  }
}

package com.fuck.mobile.loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



class PropertiesUtil {


	private static Properties properties;

	private String proper_resource;

	public PropertiesUtil(String proper_resource) {
		this.proper_resource = proper_resource;
	}

	public Properties getProperties() {
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

	public static Properties getInstance() {
		if (null == properties) {
			properties = new Properties();
		}
		return properties;
	}

	public static Properties loadResource(String file) {
		properties = getInstance();
		try {
			InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(file);
			if (properties != null) {
				properties.load(inputStream);
				inputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public static Properties loadResource(String windowsFileName, String linuxFilename) {
		properties = getInstance();
		try {
			InputStream is = null;

			String osname = System.getProperties().getProperty("os.name").toLowerCase();
			if (osname.indexOf("windows") >= 0) {
				try {
					is = new FileInputStream(windowsFileName);
				} catch (Exception e) {
				}
			} else {
				try {
					is = new FileInputStream(linuxFilename);
				} catch (FileNotFoundException e1) {
				}

			}
			if (is != null) {
				properties.load(is);
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
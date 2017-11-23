package com.sunrise.common.spring.ext;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.util.ObjectUtils;

import com.sunrise.common.utils.network.NetUtils;
import com.sunrise.common.utils.security.SecurityPass;

public class PropertyPlaceholderConfigurerExt extends
		PropertyPlaceholderConfigurer {
	private static final String mkey="70469B26CBF1E575";
	
	protected void convertProperties(Properties props) {
		Enumeration propertyNames = props.propertyNames();
		while (propertyNames.hasMoreElements()) {
			String propertyName = (String) propertyNames.nextElement();
			String propertyValue = props.getProperty(propertyName);
			String convertedValue = convertPropertyValue(propertyName,propertyValue);
			if (!ObjectUtils.nullSafeEquals(propertyValue, convertedValue)) {
				props.setProperty(propertyName, convertedValue);
			}
		}
	}
	
	protected String convertPropertyValue(String propertyName,String originalValue) {
		String value = originalValue;
		if (propertyName.endsWith("jdbc.password") || propertyName.endsWith("redis.password")){
			try {
				value = new String( SecurityPass.decode(SecurityPass.hex2byte(originalValue), SecurityPass.hex2byte(mkey)) );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (propertyName.endsWith("hostname")){
			if ("localhost".equals(originalValue)){
				value = NetUtils.getLocalhostMacAddress();
			}
		}else {
			value = super.convertPropertyValue(originalValue);
		}
		return value;
	}
	
	public void setLocation(Resource location) {
	/*	try {
			String runMode = Message.getString(location.getFile(), "run.enviroment", "local");
			if (StringToolkit.isEmpty(runMode)){
				runMode = Settings.RUNMODE.value();
			}
			String configFilePath = "";
			if ("local".equals(runMode)){
				configFilePath = "/setting/settings.properties";
			}else if ("product".equals(runMode)){
				configFilePath = "/setting/settings-product.properties";
			}else if ("test".equals(runMode)){
				configFilePath = "/setting/settings-test.properties";
			}else if ("develope".equals(runMode)){
				configFilePath = "/setting/settings.bak.properties";
			}
			if (!configFilePath.trim().equals("")){
				location = new ClassPathResource(configFilePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
//		String configFilePath = "/setting/settings.bak2.properties";
//		if (!configFilePath.trim().equals("")){
//			location = new ClassPathResource(configFilePath);
//		}
		super.setLocation(location);
	}
}

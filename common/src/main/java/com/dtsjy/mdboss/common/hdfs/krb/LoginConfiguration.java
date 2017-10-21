package com.dtsjy.mdboss.common.hdfs.krb;

import java.util.HashMap;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

/**
 * Kerberos 登录配置拓展
 *
 * @author cola
 * @version 2016年6月2日
 */
public class LoginConfiguration extends Configuration {

	private static final String LOGIN_MODULE_NAME = "com.sun.security.auth.module.Krb5LoginModule";

	/**
	 * 标记是否debug模式
	 */
	private boolean isDebug;

	public LoginConfiguration(boolean isDebug) {
		super();
		this.isDebug = isDebug;
	}

	@Override
	public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("storeKey", "true");
		if (isDebug) {
			options.put("debug", "true");
		}

		AppConfigurationEntry[] entries = new AppConfigurationEntry[] { 
			new AppConfigurationEntry(LOGIN_MODULE_NAME,
				AppConfigurationEntry.LoginModuleControlFlag.REQUIRED, options) };

		return entries;
	}

}

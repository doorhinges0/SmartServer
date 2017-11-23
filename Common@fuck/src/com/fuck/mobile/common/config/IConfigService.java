package com.fuck.mobile.common.config;

public interface IConfigService {

	/**
	 * @category 判断是否是正式环境，true是正式环境
	 */
	public boolean isProduction();
	
	/**
	 * @category 判断是否window环境
	 */
	public boolean isWindow();
	
}

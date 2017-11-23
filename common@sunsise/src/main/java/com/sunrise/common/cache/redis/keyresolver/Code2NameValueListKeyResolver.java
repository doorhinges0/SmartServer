package com.sunrise.common.cache.redis.keyresolver;

import com.sunrise.common.utils.string.StringToolkit;
import com.sunrise.common.services.CommonServiceUtils;

public class Code2NameValueListKeyResolver implements KeyResolver {
	private String group;
	/**
	 * 以"appcode:definition"为key(如果有group，则key前面会加上【group:】)
	 * @see CommonServiceUtils#appCode2NameValueList(String, String, String)
	 */
	public String getKey(Object[] args) {
		String prefix = "";
		if (StringToolkit.isNotEmpty(group)){
			prefix = group + ":";
		}
		return String.format("%s%s:%s",prefix,StringToolkit.getObjectString(args[0]), StringToolkit.getObjectString(args[1]));
	}
	
	/**
	 */
	public String getField(Object[] args) {
		return null;
	}
	
	public void setGroup(String group) {
		this.group = group;
		
	}
	
	public String getGroup() {
		return group;
	}
}

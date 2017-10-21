package com.dtsjy.mdboss.common.cache.redis.keyresolver;

import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class Code2NameValueListKeyResolver implements KeyResolver {
	private String group;
	/**
	 * 以"appcode:definition"为key(如果有group，则key前面会加上【group:】)
	 * @see com.dtsjy.mdboss.common.services.CommonServiceUtils#appCode2NameValueList(String, String, String)
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

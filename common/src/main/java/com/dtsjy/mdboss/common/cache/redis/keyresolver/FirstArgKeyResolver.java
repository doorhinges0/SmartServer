package com.dtsjy.mdboss.common.cache.redis.keyresolver;

import com.dtsjy.mdboss.common.utils.string.StringToolkit;


/**
 * 以第一个参数作为Key
 * 
 *  
 *
 */
public class FirstArgKeyResolver implements KeyResolver {
	private String group;
	
	public String getKey(Object[] args) {
		String prefix = "";
		if (StringToolkit.isNotEmpty(group)){
			prefix = group + ":";
		}
		return prefix + args[0].toString();
	}

	public String getField(Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getGroup() {
		return group;
	}
}

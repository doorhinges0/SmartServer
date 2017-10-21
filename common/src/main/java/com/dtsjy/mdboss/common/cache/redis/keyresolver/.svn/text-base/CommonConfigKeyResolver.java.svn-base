package com.dtsjy.mdboss.common.cache.redis.keyresolver;

import org.apache.commons.lang.ArrayUtils;

import com.dtsjy.mdboss.common.utils.string.StringToolkit;


public class CommonConfigKeyResolver implements KeyResolver {

	private int keyOffSet;
	private String keyIdx;
	private int fieldOffSet;
	private String fieldIdx;
	private String group;

	public void setKeyOffSet(int keyOffSet) {
		this.keyOffSet = keyOffSet;
	}

	public void setKeyIdx(String keyIdx) {
		this.keyIdx = keyIdx;
	}

	public void setFieldOffSet(int fieldOffSet) {
		this.fieldOffSet = fieldOffSet;
	}

	public void setFieldIdx(String fieldIdx) {
		this.fieldIdx = fieldIdx;
	}

	public String getKey(Object[] args) {
		String prefix = "";
		if (StringToolkit.isNotEmpty(group)){
			prefix = group + ":";
		}
		
		if (ArrayUtils.isEmpty(args)){
			return prefix;
		}
		
		StringBuffer key = new StringBuffer();
		if (StringToolkit.isNotEmpty(keyIdx)){
			String[] argIdxs = keyIdx.split(",");
			for (int i = 0; i < args.length; i++) {
				if (ArrayUtils.contains(argIdxs, i+"")){
					key.append(":").append(args[i]);
				}
			}
		}else{
			if (keyOffSet > 0){
				for (int i = 0; i < keyOffSet && i < args.length; i++) {
					key.append(":").append(args[i]);
				}
			}
		}
		
		if (key.length() > 0){
			return prefix + key.substring(1);
		}else {
			return prefix + StringToolkit.getObjectString(args[0]);
		}
	}

	public String getField(Object[] args) {
		return getKey(args);
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getGroup() {
		return null == group ? "" : group;
	}
}

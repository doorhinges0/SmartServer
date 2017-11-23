package com.sunrise.common.utils.json;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class ValueUsingPropertyFilter extends SimplePropertyPreFilter {
	private Map<String, Object> includeValuePairs = new HashMap<String, Object>();
	private Map<String, Object> excludeValuePairs = new HashMap<String, Object>();

	public ValueUsingPropertyFilter(String... properties) {
		this(null, properties);
	}

	public ValueUsingPropertyFilter(Class<?> clazz, String... properties) {
		super(clazz, properties);
	}

	private boolean containsProperty(Object obj,String key) {
		try {
			return PropertyUtils.describe(obj).containsKey(key);
		}  catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean apply(JSONSerializer serializer, Object source, String name) {
		if (source == null) {
            return true;
        }
		
		if (getClazz() != null && !getClazz().isInstance(source)) {
            return true;
        }
		
		//排除判断
		for (String key : excludeValuePairs.keySet()) {
			if (containsProperty(source, key)){
				try {
					Object v1 = excludeValuePairs.get(key);
					Object v2 = PropertyUtils.getProperty(source, key);
					if (null == v2 || null == v1){
						continue;//忽略空值比较
					}
					if (v1.equals(v2)){
						return false;
					}
				} catch (Exception e) {
					//continue
				}
			}
		}
		
		
		//包含判断
		for (String key : includeValuePairs.keySet()) {
			if (containsProperty(source, key)){
				try {
					Object v1 = includeValuePairs.get(key);
					Object v2 = PropertyUtils.getProperty(source, key);
					if (null == v2 || null == v1){
						continue;//忽略空值比较
					}
					if (v1.equals(v2)){
						return true;
					}
				} catch (Exception e) {
					//continue
				}
			}
		}
		
		

		return super.apply(serializer, source, name);
	}

	public void include(String key, Object value) {
		includeValuePairs.put(key, value);
	}

	public void exclude(String key, Object value) {
		excludeValuePairs.put(key, value);
	}

	public Map<String, Object> getIncludeValueParis() {
		return includeValuePairs;
	}

	public Map<String, Object> getExcludeValueParis() {
		return excludeValuePairs;
	}
}

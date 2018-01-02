package com.rfc.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 */
public class PropertiesUtils {

	private String fileName = "";

	public  PropertiesUtils( String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 根据key获取value
	 * 
	 * @param key
	 * @return
	 */
	public  String getValueByKey(String key) {
		if (fileName == null || "".equals(fileName.trim()) || key == null || "".equals(key.trim())) {
			return "";
		}
		Map<String, String> map = ResourceUtils.getResource(fileName).getMap();;
		return map.get(key.trim()) != null ? map.get(key.trim()) : "";
	}


	/**
	 * 键值去首尾空格
	 * 
	 * @param map
	 * @return
	 */
	private  Map<String, String> trimKeyAndValue(Map<String, String> map) {
		Map<String, String> finalMap = new HashMap<String, String>();
		if (map == null || map.size() == 0) {
			return finalMap;
		}
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			if (key != null) {
				key = key.trim();
			}
			if (value != null) {
				value = value.trim();
			}
			finalMap.put(key, value);
		}
		return finalMap;
	}

}

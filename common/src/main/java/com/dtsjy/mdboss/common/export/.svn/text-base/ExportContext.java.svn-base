package com.dtsjy.mdboss.common.export;

import java.util.HashMap;
import java.util.Map;

public class ExportContext {
	private Map<String,Object> map = new HashMap<String, Object>();
	
	public void assign(String oprName,Object value){
		if (value != null)
			map.put(oprName, new Double(value.toString()));
	}
	
	public Double lookup(String oprName) throws IllegalArgumentException{
		Double value = (Double)map.get(oprName);
		if (value == null){
			throw new IllegalArgumentException("变量"+oprName+"未被赋值");
		}
		return value;
	}
}

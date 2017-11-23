package com.sunrise.common.utils.dal.proxy;

import java.util.List;

import org.apache.commons.lang.reflect.MethodUtils;

public class CriteriaProxy {
	private Object target;

	public CriteriaProxy(Object target) {
		super();
		this.target = target;
	}
	
	public Object getTarget(){
		return target;
	}
	
	public boolean isValid() throws Exception{
		return (Boolean)MethodUtils.invokeMethod(target, "isValid",
				null);
	}
	
	public List<Object> getAllCriteria() throws Exception{
		return (List<Object>)MethodUtils.invokeMethod(target, "getAllCriteria",
				null);
	}
	
	public List<Object> getCriteria() throws Exception{
		return (List<Object>)MethodUtils.invokeMethod(target, "getCriteria",
				null);
	}
}

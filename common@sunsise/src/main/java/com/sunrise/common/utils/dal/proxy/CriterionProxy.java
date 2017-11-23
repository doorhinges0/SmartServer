package com.sunrise.common.utils.dal.proxy;

import org.apache.commons.lang.reflect.MethodUtils;

public class CriterionProxy {
	private Object target;

	public CriterionProxy(Object target) {
		super();
		this.target = target;
	}
	
	public Object getTarget(){
		return target;
	}
	
	public String getCondition() throws Exception{
		return (String)MethodUtils.invokeMethod(target, "getCondition",
				null);
	}
	
	public Object getValue() throws Exception{
		return MethodUtils.invokeMethod(target, "getValue",
				null);
	}
	
	public Object getSecondValue() throws Exception{
		return MethodUtils.invokeMethod(target, "getSecondValue",
				null);
	}
	
	public boolean isNoValue() throws Exception{
		return (Boolean)MethodUtils.invokeMethod(target, "isNoValue",
				null);
	}
	
	public boolean isSingleValue() throws Exception{
		return (Boolean)MethodUtils.invokeMethod(target, "isSingleValue",
				null);
	}
	
	public boolean isBetweenValue() throws Exception{
		return (Boolean)MethodUtils.invokeMethod(target, "isBetweenValue",
				null);
	}
	
	public boolean isListValue() throws Exception{
		return (Boolean)MethodUtils.invokeMethod(target, "isListValue",
				null);
	}
}

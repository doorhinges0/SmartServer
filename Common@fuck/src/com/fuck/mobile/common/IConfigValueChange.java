package com.fuck.mobile.common;

public interface IConfigValueChange <T>{
	void onChange(String key,T oldval,T newval);
}

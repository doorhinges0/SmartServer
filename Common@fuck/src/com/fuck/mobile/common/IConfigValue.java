package com.fuck.mobile.common;

import java.util.concurrent.atomic.AtomicReference;

public interface IConfigValue {
		
	public String get(String key);

	public boolean exist(String key);

	public void set(String key, String data);

	public boolean delete(String key);
	
	public boolean deleteCascade(String key);
	
	public <T> void dataChanges(String key,AtomicReference<T> field,T defaultValue);
	
	public <T> void dataChanges(String key,IConfigValueChange<T> field,T defaultValue);
	
}

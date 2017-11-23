package com.fuck.mobile.common;

import java.util.concurrent.atomic.AtomicReference;

public class ConfigValueImp implements IConfigValue{

	private IZooKeeperConfig zkConfig;
	private String appName;
	
	public ConfigValueImp(IZooKeeperConfig config,String appName)
	{
		this.zkConfig = config;
		this.appName = appName;
	}
	
	@Override
	public String get(String key) {
		return zkConfig.get(key);
	}

	@Override
	public boolean exist(String key) {
		return zkConfig.exist(key);
	}

	@Override
	public void set(String key, String data) {
		zkConfig.set(key, data);
	}

	@Override
	public boolean delete(String key) {
		return zkConfig.delete(key);
	}
	
	@Override
	public boolean deleteCascade(String key) {
		return zkConfig.deleteCascade(key);
	}

	@Override
	public <T> void dataChanges(String key, final AtomicReference<T> field,
			final T defaultValue) {
		zkConfig.dataChanges(key, field, defaultValue);
	}
	
	@Override
	public <T> void dataChanges(String key,IConfigValueChange<T> field,T defaultValue)
	{
		zkConfig.dataChanges(key, field, defaultValue);	
	}

}

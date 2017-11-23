package com.fuck.mobile.common;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public interface IZooKeeperConfig {

	/**
	 * @category 获取值
	 * @param key
	 * @return
	 */
	public String get(String key);
	
	/**
	 * @category 判断是否存在	
	 * @param key
	 * @return
	 */
	public boolean exist(String key);
	
	/**
	 * @category 设置值
	 * @param key
	 * @param data
	 */
	public void set(String key,String data);
	
	/**
	 * @category 删除key,如果有子节点，不删除
	 * @param key
	 * @return
	 */
	public boolean delete(String key);
	
	/**
	 * @category 删除key,连带删除子节点
	 * @param key
	 * @return
	 */
	public boolean deleteCascade(String key);

	/**
	 * @category 创建目录
	 * @param key
	 */
	public void createDir(String key);
	
	/**
	 * @category 列出所有的key
	 * @return
	 */
	public List<String> listAllKeys();
	
	
	public IZooKeeperConfig openDir(String key);
	
	/**
	 * @category 是否根节点
	 * @return
	 */
	public boolean isRoot();
	
	
	public String getPath(String key);
	
	public String getCommonPath(String key);
	
	public <T> void dataChanges(String key,AtomicReference<T> field,T defaultValue);
	
	public <T> void dataChanges(String key,IConfigValueChange<T> field,T defaultValue);
	
}

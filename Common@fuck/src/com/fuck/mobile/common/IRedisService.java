package com.fuck.mobile.common;

import java.util.List;
import java.util.Map;

public interface IRedisService {
	

	/**
	 * @category 组设置
	 * @param groupName
	 * @param key
	 * @param value
	 * @param ttl key的超时时间
	 */
	void gset(String groupName,String key,String value,int ttl);
	void gsetObject(String groupName,String key,Object value,int ttl);
	
	/**
	 * @category get方法
	 * @param groupName
	 * @param key
	 */
	String gget(String groupName,String key);
	Object ggetObject(String groupName,String key);
	
	/**
	 * @category 删除组下某一个key
	 * @param groupName
	 * @param key
	 */
	void gdel(String groupName,String key);
	
	/**
	 * @category 删除该组下全部值
	 * @param groupName
	 */
	void gdel(String groupName);
	
	/**
	 * @category 列出该组下全部key
	 * @param groupName
	 * @return
	 */
	List<String> glistKey(String groupName);
	
	/**
	 * @category 判断该组下是否有值
	 * @param groupName
	 * @param key
	 * @return
	 */
	boolean gexists(String groupName,String key);
	
	
	/**
	 * @category 设置值
	 * @param key
	 * @param value
	 */
	void set(String key, String value);
	/**
	 * @category 设置值 同时设置过期时间 单位秒
	 * @param key
	 * @param value
	 * @param exp
	 */
	void set(String key, String value, int exp);
	
	/**
	 * @category 设置值，如果存在不设置
	 * @param key
	 * @param value
	 * @return
	 */
	boolean setNx(String key, String value);
	/**
	 * @category 设置值，设置过期时间，如果存在不设置
	 * @param key
	 * @param value
	 * @return
	 */
	boolean setNx(String key, String value, int exp);
	
	/**
	 * @category 获取值
	 * @param key
	 * @return
	 */
	String get(String key);
	
	/**
	 * @category 设置对象
	 * @param key
	 * @param obj
	 */
	void setObject(String key, Object obj);
	/**
	 * @category 设置对象，设置过期时间
	 * @param key
	 * @param obj
	 * @param exp
	 */
	void setObject(String key, Object obj, int exp);
	/**
	 * @category 设置对象，如果存在不设置
	 * @param key
	 * @param obj
	 * @return
	 */
	boolean setNxObjec(String key, Object obj);
	/**
	 * @category 设置对象，设置过期时间，如果存在不设置
	 * @param key
	 * @param obj
	 * @param exp
	 * @return
	 */
	boolean setNxObjec(String key, Object obj, int exp);
	
	/**
	 * @category 获取对象
	 * @param key
	 * @return
	 */
	public Object getObject(String key);
	
	
	/**
	 * @category 用于设置指定字段各自的值，在存储于键的散列。
	 *   此命令将覆盖哈希任何现有字段。如果键不存在，新的key由哈希创建。
	 * @param key
	 * @param maps
	 * @return
	 */
	boolean hmSet(String key,Map<String, String> maps);
	
	/**
	 * @category 获取hmset中得值
	 * @param key
	 * @param field 字段
	 * @return
	 */
	String hget(String key,String field);
	
	
	/**
	 * @category 使key对应的值增加num. 参数num可以为负数.如果原来的值不是整数(字符串形式的整数), 它会被先转换成整数.
	 * @param key
	 * @param num
	 * @return
	 */
	public Long incr(String key,Long num);
	
	/**
	 * @category 设置过期时间
	 * @param key
	 * @param ttl
	 * @return
	 */
	boolean expire(String key, int ttl);

	
	/**
	 * @category 判断原始key是否存在	
	 * @param key
	 * @return
	 */
	public boolean exists(String key);
	
	/**
	 * @category 删除原始key
	 * @param key
	 */
	public void del(String key);

}

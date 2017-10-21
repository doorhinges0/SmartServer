package com.dtsjy.mdboss.common.services;

import java.util.List;
import java.util.Map;

public interface CommonService {

	// 根据主键删除记录
	String deleteByPrimaryKey(String appcode, String tenant, String oprcode,String voName, Integer id);
	
	
	// 根据主键删除记录
	String deleteByPrimaryKey(String appcode, String tenant, String oprcode,String voName, String id);
	

	// 新增
	String insertSelectiveWithReturnVO(String appcode, String tenant, String oprcode,String voName, String voJson);
	
	// 新增
	String createBatch(String appcode, String tenant, String oprcode,String voName, String voJson);

	// 局部新增，为null的字段不覆盖数据库的默认值
	String insertSelective(String appcode, String tenant, String oprcode,String voName, String voJson);

	// 高级查询
	String selectByExample(String appcode, String tenant, String oprcode,String voName, String json);

	// 根据主键查询
	String selectByPrimaryKey(String appcode, String tenant, String oprcode,String voName, Integer id);

	// 根据主键局部更新，为null的字段不覆盖数据库的默认值
	String updateByPrimaryKeySelective(String appcode, String tenant, String oprcode,String voName, String voJson);

	// 根据主键更新（含BLOB）
	String updateByPrimaryKeyWithBLOBs(String appcode, String tenant, String oprcode,String voName, String voJson);

	// 根据主键更新（不含BLOB）
	String updateByPrimaryKey(String appcode, String tenant, String oprcode,String voName, String voJson);
	
	// 批量更新，不包括BLOB,返回值为Integer，代表更新的条数
	public String updateByPrimaryKeys(String appcode, String tenant, String oprcode,String voName, String vosJson);
		
	// 批量更新，包括BLOB,返回值为Integer，代表更新的条数
	public String updateByPrimaryKeysWihtBLOBs(String appcode, String tenant, String oprcode,String voName, String vosJson);
		
	// 批量删除多条记录，返回值为Integer，代表删除的记录数
	public String deleteByPrimaryKeys(String appcode, String tenant, String oprcode,String voName, String idsJson);
	
	// 批量删除多条记录，返回值为Integer，代表删除的记录数
	public String deleteByExample(String appcode, String tenant, String oprcode,String voName, String idsJson);
		
	/**
	 * 根据字典项编码取得字典项名称
	 * @param definition 字典分类
	 * @param codeValue 字典项编码
	 * @param userCode 用户编码
	 * @return 返回翻译的名称
	 */
	public String code2Name(String appcode, String tenant, String oprcode,String definition,String codeValue,String userCode);
	
	/**
	 * 获取字典分类的字典项列表
	 * @param definition 
	 * @param userCode 用户编码
	 * @return 返回code和name的Map
	 */
	public Map getCode2NameValueList(String appcode, String tenant, String oprcode,String definition,String userCode);
	
	/**
	 * 获取字典分类的字典项列表
	 * @param definition 
	 * @param condition
	 * @param userCode 用户编码
	 * @return 返回code和name的Map
	 */
	public Map getCode2NameValueList(String appcode, String tenant, String oprcode,String definition,String condition,String userCode);
	
	/**
	 * 执行自定义sql语句
	 * @param appcode
	 * @param tenant
	 * @param oprcode
	 * @param userCode
	 * @return
	 */
	public List<Map<String, Object>> executeSql(String appcode, String tenant, String oprcode,String jsonData);

	/**
	 * 统计记录数
	 * @param appcode
	 * @param tenant
	 * @param oprcode
	 * @param voName 查询实体
	 * @param json 查询条件
	 * @return 记录数
	 * */
	public int selectCountByExample(String appcode, String tenant, String oprcode, String voName, String json);
	
	
}
package com.sunrise.common.model.code2name;

import java.util.Map;

import com.sunrise.common.model.BaseQuery;
import com.sunrise.common.model.DataPackage;

public interface Code2Name {
	/**
	 * 转换编码值为名称
	 * 
	 * @param definition
	 * @param codeName
	 * @param nameName
	 * @param codeValue
	 * @return
	 * @throws Exception
	 */
	String code2Name(String definition, String codeValue, String userCode);

	/**
	 * 获取指定编码的名称列表
	 * 
	 * @param definition
	 * @return
	 */
	Map valueList(String definition, String userCode);

	/**
	 * 获取指定编码的名称列表
	 * 
	 * @param definition
	 * @return
	 */
	Map valueList(String definition, String condition, String userCode);

	/**
	 * 
	 * @param def
	 * @param condition
	 * @param param
	 * @param userCode
	 * @return
	 */
	Map valueList(String def, String condition, BaseQuery param, String userCode);

	/**
	 * 从单表中 获取指定编码的名称列表。由于数据量过大，采用分页的方式获取，一次一页，必须指定页号。
	 * 
	 * @param definition
	 * @param condition
	 * @param param
	 * @param userCode
	 * @return
	 */
	DataPackage valueListPackage(String definition, String condition,
			BaseQuery param, String userCode);
}

package com.dtsjy.mdboss.common.dal.ext.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

public interface GeneralMapper {

	@Select(value={"${sql}"})
	public List<Map<String, Object>> executeSql(@Param("sql")String sql);
	
	/**
	 * 
	 * @param params
	 * @return
	 */
    @Select("CALL getParentsOrChilds(#{tableName},#{col},#{pcol},#{selfCode},#{type},#{parentCodes,mode=OUT,jdbcType=VARCHAR},#{childCodes,mode=OUT,jdbcType=VARCHAR})")
    @Options(statementType= StatementType.CALLABLE )
	public Map<String, Object> getParentsAndChilds(Map<String, Object> params);
}

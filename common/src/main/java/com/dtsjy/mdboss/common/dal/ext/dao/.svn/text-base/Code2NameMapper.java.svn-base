package com.dtsjy.mdboss.common.dal.ext.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Code2NameMapper {

	@Select(value={"${sql}"})
	public List<Map<String, Object>> code2Name(@Param("sql")String sql);
}

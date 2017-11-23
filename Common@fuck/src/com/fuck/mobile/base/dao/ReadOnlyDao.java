package com.fuck.mobile.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface ReadOnlyDao {
	public Integer queryForFirstValueInt(String sql, Object... args) throws DataAccessException;

	public Long queryForFirstValueLong(String sql, Object... args) throws DataAccessException;

	public Double queryForFirstValueDouble(String sql, Object... args) throws DataAccessException;
	
	public String queryForFirstValueString(String sql, Object... args) throws DataAccessException;
	
	public Object queryForFirstValueObject(String sql, Object... args) throws DataAccessException;
	
	public SqlRowSetEx queryForRowSet(String sql, Object... args) throws DataAccessException;

	public Map<String, Object> queryForSignleRow(String sql, Object... args);

	public List<Map<String, Object>> queryForList(String sql, Object... args);
}

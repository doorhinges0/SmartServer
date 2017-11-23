package com.fuck.mobile.base.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;

public interface BaseDao {
	public Integer queryForFirstValueInt(String sql, Object... args) throws DataAccessException;

	public Long queryForFirstValueLong(String sql, Object... args) throws DataAccessException;

	public Double queryForFirstValueDouble(String sql, Object... args) throws DataAccessException;
	
	public Object queryForFirstValueObject(String sql, Object... args) throws DataAccessException;
	
	public String queryForFirstValueString(String sql, Object... args) throws DataAccessException;
	
	public int update(String sql, Object... args) throws DataAccessException;
	
	public <T> int insert(Class<T> c,String table, List<T> objs) throws DataAccessException;
	
	public <T> int insert(Class<T> c,String table, T objs) throws DataAccessException;

	/**
	 * 更新，并返回主键id
	 * 
	 * @param sql
	 * @param args
	 * @return
	 * @throws DataAccessException
	 */
	public Number update4Key(String sql, Object... args) throws DataAccessException;

	public SqlRowSetEx queryForRowSet(String sql, Object... args) throws DataAccessException;

	public int update(PreparedStatementCreator psc, KeyHolder generatedKeyHolder) throws DataAccessException;

	public Map<String, Object> queryForSignleRow(String sql, Object... args);

	public List<Map<String, Object>> queryForList(String sql, Object... args);

	public Connection getConnectionEx();

	public void releaseConnectionEx(Connection conn);

	public long genSeq(String seqName);
	
	public void waitForConnectExit(WaitForConnect wait);
	public void waitForConnectExit(WaitForConnect wait,int timeout);

	int[] batchUpdate(String[] sql);
	int[] batchUpdate(String sql,List<Object[]> list);
}

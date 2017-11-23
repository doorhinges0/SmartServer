package com.fuck.mobile.base.dao.db;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.fuck.mobile.base.dao.SqlRowSetEx;

@Repository
public class MainReadOnlyDaoImp implements MainReadOnlyDao {
	
	protected final Log logger = LogFactory.getLog(MainReadOnlyDaoImp.class);
	
	private JdbcTemplate jdbctmp = null;
	
	@Resource(name="mainReadOnlyDataSource")	
	private void setDataSource(DataSource readOnlyDataSource)
	{
		jdbctmp = new JdbcTemplate(readOnlyDataSource);
		
	}
	
	private JdbcTemplate  getJdbcTemplate()
	{
		return jdbctmp;
	}
	
	

	@Override
	public Integer queryForFirstValueInt(String sql, Object... args) throws DataAccessException {

		SqlRowSet sr = getJdbcTemplate().queryForRowSet(sql, args);

		if (sr.next()) {
			return sr.getInt(1);
		}

		return null;

	}

	@Override
	public Long queryForFirstValueLong(String sql, Object... args) throws DataAccessException {

		SqlRowSet sr = getJdbcTemplate().queryForRowSet(sql, args);

		if (sr.next()) {
			return sr.getLong(1);
		}

		return null;

	}
	@Override
	public Double queryForFirstValueDouble(String sql, Object... args) throws DataAccessException
	{
		SqlRowSet sr = getJdbcTemplate().queryForRowSet(sql, args);

		if (sr.next()) {
			return sr.getDouble(1);
		}
		return null;
	}
	
	@Override
	public String queryForFirstValueString(String sql, Object... args) throws DataAccessException
	{
		SqlRowSet sr = getJdbcTemplate().queryForRowSet(sql, args);

		if (sr.next()) {
			return sr.getString(1);
		}
		return null;
	}
	
	@Override
	public Object queryForFirstValueObject(String sql, Object... args) throws DataAccessException
	{
		SqlRowSet sr = getJdbcTemplate().queryForRowSet(sql, args);

		if (sr.next()) {
			return sr.getObject(1);
		}
		return null;
	}
	

	@Override
	public SqlRowSetEx queryForRowSet(String sql, Object... args) throws DataAccessException {
		return new SqlRowSetEx(getJdbcTemplate().queryForRowSet(sql, args));
	}

	@Override
	public Map<String, Object> queryForSignleRow(String sql, Object... args) {
		List<Map<String, Object>> list = this.queryForList(sql, args);
		if (list != null && list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql, Object... args) {
		List<Map<String, Object>> list = null;

		try {
			if (args == null || args.length == 0)
				list = this.getJdbcTemplate().queryForList(sql);
			else
				list = this.getJdbcTemplate().queryForList(sql, args);
		} catch (Exception e) {
			e.printStackTrace();
			String errMsg = "queryForList error [" + sql + "]: " + e.getMessage();
			logger.error(errMsg);

		}
		return list;
	}


}

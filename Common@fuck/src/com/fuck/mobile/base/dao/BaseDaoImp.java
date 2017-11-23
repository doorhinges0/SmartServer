package com.fuck.mobile.base.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.fuck.mobile.base.utils.StringUtils;

public abstract class BaseDaoImp extends JdbcDaoSupport implements BaseDao {

	public abstract void setDs(DataSource ds);
	
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
	public Object queryForFirstValueObject(String sql, Object... args) throws DataAccessException
	{
		SqlRowSet sr = getJdbcTemplate().queryForRowSet(sql, args);

		if (sr.next()) {
			return sr.getObject(1);
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
	public int update(String sql, Object... args) throws DataAccessException {
		return getJdbcTemplate().update(sql, args);
	}

	@Override
	public SqlRowSetEx queryForRowSet(String sql, Object... args) throws DataAccessException {
		return new SqlRowSetEx(getJdbcTemplate().queryForRowSet(sql, args));
	}

	public int update(PreparedStatementCreator psc, KeyHolder generatedKeyHolder) throws DataAccessException {
		return getJdbcTemplate().update(psc, generatedKeyHolder);
	}

	/**
	 * 更新，并返回主键id
	 * 
	 * @param sql
	 * @param args
	 * @return
	 * @throws DataAccessException
	 */
	public Number update4Key(String sql, Object... args) throws DataAccessException {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int k = update(new PreparedStatementIDKey(sql, args), keyHolder);
		if (k > 0) {
			return keyHolder.getKey();
		}
		return -1;
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

	@Override
	public Connection getConnectionEx() {
		return getConnection();
	}

	@Override
	public void releaseConnectionEx(Connection conn) {
		releaseConnection(conn);
	}
	
	@Override
	public <T> int insert(Class<T> c,String table, T objs) throws DataAccessException
	{
		if(objs == null)
		{
			return 0;
		}
		ArrayList<T> list = new ArrayList<T>();
		list.add(objs);
		return insert(c,table,list);
	}
	


	@Override
	public <T> int insert(Class<T> c,String table, List<T> objs) throws DataAccessException
	{
		if(objs == null || objs.size() == 0)
		{
			return 0;
		}
		String sql = "show columns from " + table;
		SqlRowSetEx sr =  queryForRowSet(sql);
		HashMap<String,String> fields = new HashMap<>();
		while(sr.next())
		{
			String fsrc = sr.getString(1);
			fields.put(StringUtils.sqlColumnName2JavaName(fsrc) , fsrc);
		}
		if(fields.size() == 0)
		{
			return 0;
		}
		Field[] fs = c.getFields();
		if(fs == null)
		{
			return 0;
		}
		ArrayList<String> csNames = new ArrayList<>();
		ArrayList<Field> cs = new ArrayList<>();
		for(Field f : fs)
		{
			String fname =StringUtils.sqlColumnName2JavaName(f.getName());
			if(fields.containsKey(fname))
			{
				csNames.add(fields.get(fname));
				cs.add(f);
				f.setAccessible(true);
			}else if(fields.containsKey(f.getName()))
			{
				csNames.add(fields.get(f.getName()));
				cs.add(f);
				f.setAccessible(true);
			}
		}
		if(cs.size() == 0)
		{
			return 0;
		}
		
		StringBuilder sb = new StringBuilder("insert into " ).append(table).append(" (");
		for(String s : csNames)
		{
			sb.append("`").append(s).append("`,");
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append(") values (");
		for(int i = 0; i < cs.size();i++)
		{
			sb.append("?").append(",");
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append(");");
		sql = sb.toString();
		int retc = 0;
		for(T t : objs)
		{
			Object[] argobjs = new Object[cs.size()];
			for(int i = 0; i < cs.size();i++)
			{
				Object v = null;
				Field f = cs.get(i);
				try {
					 v = f.get(t);
				} catch (IllegalArgumentException e) {
				} catch (IllegalAccessException e) {
				}
				if(v != null && v.getClass().isEnum())
				{
					try {
						Method m = v.getClass().getMethod("Enum2Number", v.getClass());
						v = m.invoke(null, v);
					} catch (Exception e) {
						throw new DataAccessException("Enum2Number",e){};
					} 
					
				}
				if(v == null)
				{
					DefaultValue df = f.getAnnotation(DefaultValue.class);
					if(df != null)
					{
						v = df.value();
					}
				}
				argobjs[i] = v;
			}
			retc += update(sql, argobjs);
		}
		return retc;
		
	}
	
	@Override
	public int[] batchUpdate(String[] sql)
	{
		return getJdbcTemplate().batchUpdate(sql);
	}
	
	@Override
	public int[] batchUpdate(String sql,List<Object[]> list)
	{
		return getJdbcTemplate().batchUpdate(sql,list);
	}

		

}

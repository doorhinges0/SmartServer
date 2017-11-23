package com.fuck.mobile.base.dao;


import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class PreparedStatementIDKey implements PreparedStatementCreator {

	String sql;
	Object[] objs;

	public PreparedStatementIDKey(String sql, Object... obj) {
		this.sql = sql;
		this.objs = obj;
		if (objs == null) {
			objs = new Object[0];
		}
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection paramConnection)
			throws SQLException {
		PreparedStatement ps = paramConnection.prepareStatement(sql,
				Statement.RETURN_GENERATED_KEYS);

		for (int i = 0; i < objs.length; i++) {
			Object v = objs[i];
			if(v == null)
			{
				ps.setObject(i+1, v);
			}else if (v instanceof String) {
				ps.setString(i + 1, (String) v);
			} else if (v instanceof Integer) {
				ps.setInt(i + 1, (Integer) v);
			} else if (v instanceof Long) {
				ps.setLong(i + 1, (Long) v);
			} else if (v instanceof Short) {
				ps.setShort(i + 1, (Short) v);
			} else if (v instanceof Byte) {
				ps.setByte(i + 1, (Byte) v);
			} else if (v instanceof Array) {
				ps.setArray(i + 1, (Array) v);
			} else if (v instanceof BigDecimal) {
				ps.setBigDecimal(i + 1, (BigDecimal) v);
			} else if (v instanceof InputStream) {
				ps.setBlob(i + 1, (InputStream) v);
			} else if (v instanceof Boolean) {
				ps.setBoolean(i + 1, (Boolean) v);
			} else if (v instanceof Date) {
				ps.setDate(i + 1, (Date) v);
			} else if (v instanceof java.util.Date) {
				ps.setTimestamp(i + 1, new java.sql.Timestamp(
						((java.util.Date) v).getTime()));
			} else if (v instanceof Double) {
				ps.setDouble(i + 1, (Double) v);
			} else if (v instanceof Float) {
				ps.setFloat(i + 1, (Float) v);
			} else if (v instanceof java.sql.Time) {
				ps.setTime(i + 1, (java.sql.Time) v);
			} else if (v instanceof java.sql.Timestamp) {
				ps.setTimestamp(i + 1, (java.sql.Timestamp) v);
			} else if (v instanceof URL) {
				ps.setURL(i + 1, (URL) v);
			}else
			{
				ps.setObject(i+1, v);
			}

		}
		return ps;
	}

}

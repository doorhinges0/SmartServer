package com.fuck.mobile.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.fuck.mobile.base.utils.ReflectUtil;

/**
 * @category 自动配置数据源
 * @author megax
 *
 */
public class AtomicDataSource implements DataSource {

	private DataSource ds;
	
	public AtomicDataSource(DataSource ds)
	{
		setDataSource(ds);
	}
	
	public void setDataSource(DataSource ds)
	{
		this.ds = ds;
	}
	
	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return ds.getLogWriter();
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		ds.setLogWriter(out);
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		ds.setLoginTimeout(seconds);

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return ds.getLoginTimeout();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return ds.getParentLogger();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return ds.unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return ds.isWrapperFor(iface);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return ds.getConnection(username, password);
	}

	public void close2() throws IOException {
		if(ds == null) return;
		if(ds instanceof Closeable)
		{
			((Closeable)ds).close();
		}else
		{
			try
			{
				ReflectUtil.callMethod(ds, "close");
			}
			catch(Exception ex)
			{
				if(ex instanceof IOException)
				{
					throw (IOException)ex;
				}
			}
			try
			{
				ReflectUtil.callMethod(ds, "close2");
			}
			catch(Exception ex)
			{
				if(ex instanceof IOException)
				{
					throw (IOException)ex;
				}
			}
		}
		
	}

}

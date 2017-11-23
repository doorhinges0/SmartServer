package com.fuck.mobile.base.dao.db;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.fuck.mobile.base.dao.BaseDaoImp;
import com.fuck.mobile.base.dao.TimeoutException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fuck.mobile.base.dao.WaitForConnect;

@Repository
public class MainDaoImp extends BaseDaoImp implements MainDao {

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public long genSeq(String seqName) {
		return this.queryForFirstValueLong("select nextval(?)", seqName);
	}

	@Override
	public void waitForConnectExit(WaitForConnect wait) {
		//5分钟
		waitForConnectExit(wait,5 * 60 * 1000);
	}

	@Override
	public void waitForConnectExit(WaitForConnect wait, int timeout) {
		if(timeout <= 0)
		{
			timeout = 120 * 1000;//120秒
		}
		long reqtimeout = timeout + 5000;
		long currentime = 0;
		final String sql = "SELECT 1;";
		long l = 0;

		while(!wait.isFinished())
		{
			if(l >= 2000)
			{
				this.queryForFirstValueInt(sql);
				l = 0;//2秒内重新连接
			}
			if(currentime > reqtimeout)
			{
				throw new TimeoutException();
			}
			l++;
			currentime++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			
			
		}
		
	}

	@Resource(name = "dataSource")
	@Override
	public void setDs(DataSource ds) {
		super.setDataSource(ds);
		
	}

}

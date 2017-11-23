package com.fuck.commom;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;

import com.fuck.commom.test.JUnitTestBase;
import com.fuck.mobile.base.dao.db.MainDao;
import com.fuck.mobile.common.ITransactionNoAnnotation;

public class TestTx extends JUnitTestBase{

	
	@Autowired
	MainDao main;
	
	@Autowired
	ITransactionNoAnnotation tx;
	
	
//	@Test
	public void testCommit() throws  Exception
	{
		tx.execute(()->{
			
			main.update("insert into test.test1(name) values(?)", "yeah -> " + System.currentTimeMillis());
			
		});
		
		System.out.println(main.queryForFirstValueInt("select id from test.test1 order by id desc limit 0,1"));
		
		
	}
	
	
//	@Test
	public void testRockback()
	{
		int i = main.queryForFirstValueInt("select id from test.test1 order by id desc limit 0,1");
		try
		{
			tx.execute(()->{
				
				tx.execute(()->{
					main.update("insert into test.test1(name) values(?)", "yeah -> " + System.currentTimeMillis());
				},Propagation.NOT_SUPPORTED);
				
				main.update("insert into test.test1(name) values(?)", "yeah -> " + System.currentTimeMillis());
				throw new Exception();
				
			});
		}catch(Exception e)
		{
			e.printStackTrace(System.err);
		}

		int i2 = main.queryForFirstValueInt("select id from test.test1 order by id desc limit 0,1");
		System.out.println(i2);
		Assert.assertTrue( i == (i2 - 1));
		
		
	}
	@Autowired
	ITestService testService;
	@Test
	public void test(){

		try {
			testService.add("55555");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

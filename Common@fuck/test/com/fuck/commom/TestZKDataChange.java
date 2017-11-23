package com.fuck.commom;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fuck.commom.test.JUnitTestBase;
import com.fuck.mobile.common.IConfigValue;

public class TestZKDataChange  extends JUnitTestBase{
	@Autowired
	IConfigValue config;
	
	@Test
	public void test() throws Exception
	{
		
		config.dataChanges("_____test", (k1,old,newv)->{
			
			System.out.println("k1 -> " + k1);
			System.out.println("old -> " + old);
			System.out.println("new value -> " + newv);
			
			
		}, "yeah");
	Thread.sleep(100000);	
	}
	
}

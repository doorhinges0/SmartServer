package com.fuck.commom;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuck.commom.test.JUnitTestBase;
import com.fuck.mobile.common.ntp.INtpService;
import com.fuck.mobile.common.ntp.NtpServiceImp;

public class TestTime extends JUnitTestBase {

	@Service
	public static class Exxx extends NtpServiceImp
	{
		
	}
	
	@Autowired
	INtpService server;
	
	
	@Test
	public void test() throws InterruptedException
	{
		for(int i = 0; i < 1000; i++)
		{
			System.out.println( server.getNow() + " -> " + server.getNow().getTime());
			Thread.sleep(100);
		}
		
		
	}
	
	
	
}

package com.fuck.commom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fuck.commom.test.JUnitTestBase;
import com.fuck.mobile.common.rabbitmq.IRabbitMqService;

public class TestRabbitMqSend extends JUnitTestBase{
	static Log log = LogFactory.getLog(TestRabbitMqSend.class);
	@Autowired
	IRabbitMqService rabbitmq;
	
//	@Test
	public void testSend() throws Exception {
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 100000000;i++)
		{
			rabbitmq.sendMsg("Test2", "msg -> " + i);
		}
		System.out.println("end -> " + (System.currentTimeMillis() - start));
	
		Thread.sleep(500000);
	}
	
	@Test
	public void testSend2() throws Exception {
		long start = System.currentTimeMillis();
		
	
		rabbitmq.sendMsg("Test2", "xxxx -> " + System.currentTimeMillis());
		
		Thread.sleep(5000);
	}
	
}

package com.fuck.commom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fuck.commom.test.JUnitTestBase;
import com.fuck.mobile.common.rabbitmq.IRabbitMqService;
import com.fuck.mobile.common.rabbitmq.RabbitMqType;

public class TestRabbitMQRecv extends JUnitTestBase {

	static Log log = LogFactory.getLog(TestRabbitMQRecv.class);
	@Autowired
	IRabbitMqService rabbitmq;

	
//	@Test
	public void testRecv() throws Exception {
		System.out.println("test.................");
		rabbitmq.setMQListerner("Test2", RabbitMqType.fanout, null, (String name, String routingkey, String msg) -> {
			System.out.println("ThreadId->" + Thread.currentThread().getId());
			System.out.println(msg);
		});
		
		Thread.sleep(6000);
	}
	
	@Test
	public void testRecv2() throws Exception {
		System.out.println("test.................");
		rabbitmq.setMQListerner("Test2", RabbitMqType.fanout, "yeah", (String name, String routingkey, String msg) -> {
			System.out.println("yeah.......");
			System.out.println(msg);
		});
		rabbitmq.setMQListerner("Test2", RabbitMqType.fanout, null, (String name, String routingkey, String msg) -> {
			System.out.println("ThreadId->" + Thread.currentThread().getId());
			System.out.println(msg);
		});
		
		Thread.sleep(6000);
	}
	
	
	@After
	public void after() throws InterruptedException
	{
		Thread.sleep(10000000);
	}

}

package com.fuck.commom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fuck.commom.test.JUnitTestBase;
import com.fuck.mobile.common.rabbitmq.IRabbitMqService;
import com.fuck.mobile.common.rabbitmq.RabbitMqType;
import com.fuck.mobile.util.Device;

public class TestRabbitMQRecv2 extends JUnitTestBase {
	static Log log = LogFactory.getLog(TestRabbitMQRecv2.class);
	@Autowired
	IRabbitMqService rabbitmq;

	static
	{
		System.out.println("before...");
		
		
		Device.setDeviceId("AAAAAAAAA");
	}
	
	
	@Test
	public void testRecv() throws Exception {
		System.out.println("test.................");
		rabbitmq.setMQListerner("Test2", RabbitMqType.fanout, null, (String name, String routingkey, String msg) -> {
			log.error("ThreadId->" + Thread.currentThread().getId());
			log.error(msg);
		});
		System.out.println("test2.................");
		Thread.sleep(6000);
		System.out.println("test3.................");
	}
	@After
	public void after() throws InterruptedException
	{
		Thread.sleep(10000000);
	}
}

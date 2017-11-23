package com.fuck.commom;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fuck.commom.test.JUnitTestBase;
import com.fuck.mobile.common.IRedisService;

public class TestGRedis extends JUnitTestBase {

	@Autowired
	IRedisService redis;
	
	String TestGName = "TestGName";
	
	@Test
	public void testgset()
	{
		redis.gdel(TestGName);
		System.out.println("testgset............");
		String ret = redis.gget(TestGName, "key1");
		Assert.assertNull(ret);
		redis.gset(TestGName, "key1", "v1",60);
		ret = redis.gget(TestGName, "key1");
		Assert.assertEquals(ret, "v1");
		redis.gdel(TestGName);
	}
	
	@Test
	public void testggetObject()
	{
		redis.gdel(TestGName);
		System.out.println("ggetObject............");
		Object ret = redis.ggetObject(TestGName, "key1");
		Assert.assertNull(ret);
		redis.gsetObject(TestGName, "key1", "v1",60);
		ret = redis.ggetObject(TestGName, "key1");
		Assert.assertEquals(ret, "v1");
		redis.gdel(TestGName);
	}
	
	
	
	
	
	@Test
	public void testgdel()
	{
		redis.gdel(TestGName);
		System.out.println("gdel............");
		redis.gset(TestGName, "key1", "v1",60);
		redis.gset(TestGName, "key2", "v2",60);
		redis.gset(TestGName, "key3", "v3",60);
		redis.gdel(TestGName, "key2");
		
		List<String> l=  redis.glistKey(TestGName);
		System.out.println(l);
		for(String s : l)
		{
			Assert.assertNotEquals(s, "key2");
		}
		Assert.assertNull(redis.get("key2"));
		
		redis.gdel(TestGName);
	}
	
	
	@Test
	public void testglistKey()
	{
		redis.gdel(TestGName);
		System.out.println("glistKey............");
		
		Assert.assertTrue(redis.glistKey(TestGName).size() == 0);
		redis.gset(TestGName, "key1", "v1",60);
		redis.gset(TestGName, "key2", "v2",60);
		redis.gset(TestGName, "key3", "v3",60);
		
		String r = redis.get("key1");
		System.out.println(r);
		Assert.assertEquals("v1", r);
		Assert.assertTrue(redis.glistKey(TestGName).size() > 0);
		
		redis.gdel(TestGName);
	}
	
	
	@Test
	public void testgexists()
	{
		redis.gdel(TestGName);
		System.out.println("gexists............");
		
		Assert.assertFalse( redis.gexists(TestGName, "k1") );
		redis.gset(TestGName, "k1", "b1",60);
		
		Assert.assertTrue( redis.gexists(TestGName, "k1") );
		
		
		redis.gdel(TestGName);
	}
}

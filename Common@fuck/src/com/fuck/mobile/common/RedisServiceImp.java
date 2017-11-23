package com.fuck.mobile.common;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fuck.mobile.base.constant.Constants;
import com.fuck.mobile.base.utils.RedisHostAndPortUtil;
import com.fuck.mobile.util.Base64;
import com.fuck.mobile.util.SerializeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.google.gson.Gson;
import com.xnew.CloseEx;
import com.fuck.mobile.spring.SpringConfigurerEx;
import com.fuck.mobile.spring.test.ServletConfigTest;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.Pool;

@Service
public class RedisServiceImp implements IRedisService {
	private static class OldSetting
	{
		String redisUrl;
		String masterName;
		Integer RedisDatabaseNumber;
		Integer RedisTimeout;
		
	}

	static Log log = LogFactory.getLog(RedisServiceImp.class);

	final Long l = 1L;

	//private JedisCluster client;
	private JedisCommands client;
	private Pool<Jedis> pool;
	static Gson gs = new Gson();
	private static OldSetting old = new OldSetting(); 
	@Autowired
	IZooKeeperConfig zkConfig;
	

	private class MyInvocationHandler implements InvocationHandler
	{

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			
			Jedis r =  pool.getResource();
			try
			{
				return method.invoke(r, args);
				
				
			}catch(Throwable e)
			{
				pool.returnBrokenResource(r);
				throw e;
			}finally
			{
				pool.returnResource(r);
			}
			
		}
		
	}
	
	@Autowired
	public CloseEx closeEx;
	private boolean isInit = false;

	private synchronized void lazyInit()
	{
		if(isInit) return;
		
		log.debug("RedisServiceImp init");
		
		if(zkConfig!=null){
			try {
				String redisUrl = zkConfig.get(Constants.YunWei+"/RedisServer/Redis4APP/url");
				String masterName = zkConfig.get(Constants.YunWei+"/RedisServer/Redis4APP/masterName");
				Integer RedisDatabaseNumber = Integer.parseInt(zkConfig.get(Constants.YunWei+"/RedisServer/Redis4APP/databaseNumber"));
				Integer RedisTimeout = Integer.parseInt(zkConfig.get(Constants.YunWei+"/RedisServer/Redis4APP/timeout"));
				
				initRedis(redisUrl, masterName, RedisDatabaseNumber, RedisTimeout);
			} catch (Exception e) {
				log.error(e);
			}
		}else {
			log.debug("not run on web???");
		}
		
		log.debug("RedisServiceImp end");
		closeEx.addClose(this);
		
//		log.debug("RedisServiceImp init");
//		
//		client = new JedisCluster(RedisHostAndPortUtil.getAddresses(Config.RedisUrl));
//		log.debug("RedisServiceImp end");
//		closeEx.addClose(this);
		
	}
	
//	@PostConstruct
	public void init() throws IOException {
		lazyInit();
	}
	
	public void initReidsWithLastSetting()
	{
		initRedis(old.redisUrl,old. masterName,old. RedisDatabaseNumber,old. RedisTimeout);
	}

	public void initRedis(String redisUrl, String masterName, Integer RedisDatabaseNumber, Integer RedisTimeout) {
		old.masterName = masterName;
		old.RedisDatabaseNumber = RedisDatabaseNumber;
		old.RedisTimeout = RedisTimeout;
		old.redisUrl = redisUrl;
		if(redisUrl.startsWith("redis-sentinel://"))
		{
			HashSet<String> sentinels = new HashSet<String>();
			
			Set<HostAndPort>	nodes = RedisHostAndPortUtil.getAddresses(redisUrl.substring("redis-sentinel://".length()));
			
			for(HostAndPort h : nodes)
			{
				sentinels.add(h.getHost() +":"+ h.getPort());
			}
			
			org.apache.commons.pool2.impl.GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			
			pool = new JedisSentinelPool(masterName, sentinels,poolConfig,RedisTimeout,null,RedisDatabaseNumber);
			
			client = (JedisCommands) Proxy.newProxyInstance(IRedisService.class.getClassLoader(), new Class[]{JedisCommands.class}, new MyInvocationHandler());

		}else if(redisUrl.startsWith("redis://"))
		{
			
			pool = new JedisPool(redisUrl);
			
			client = (JedisCommands) Proxy.newProxyInstance(IRedisService.class.getClassLoader(), new Class[]{JedisCommands.class}, new MyInvocationHandler());	
			
		}else if(redisUrl.startsWith("redis-cluster://"))
		{
			
			HashSet<String> sentinels = new HashSet<String>();
			
			Set<HostAndPort>	nodes = RedisHostAndPortUtil.getAddresses(redisUrl.substring("redis-cluster://".length()));
			
			for(HostAndPort h : nodes)
			{
				sentinels.add(h.getHost() +":"+ h.getPort());
			}

			client = new JedisCluster(nodes,5000,5);
		}
		isInit = true;
	}

	public void close2() {
		isInit = false;
		log.debug("RedisServiceImp destory");
		if (client != null && client instanceof JedisCluster) {
			try {
				((JedisCluster)client).close();
			} catch (IOException e) {
				log.error("", e);
			}
		}
		if(pool != null)
		{
			pool.close();
		}
		log.debug("RedisServiceImp destory end");

	}

	
	
	public static void main(String[] args) throws Exception {
//		RedisServiceImp imp = new RedisServiceImp();
//		imp.closeEx = new CloseEx();
//		imp.init();
//		imp.initRedis("redis-sentinel://172.20.30.101:26379,172.20.30.102:26379", "themaster", 1, 2000);
//	
//		String s = imp.get("A1");
//		System.out.println(s);
//		imp.set("A1", "333");
//
//		s = imp.get("A1");
//		System.out.println(s);
//
//		
//		imp.close2();
		
		
		
		AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
		String appId = "123232";
		String AppName = "test";
		String zooKeeperUrl = "192.168.0.204:2181";
		String zooKeeperRootPath = "/AppConfig/ZYXR";
		String packageName = "com.fuck.mobile";
		
		SpringConfigurerEx.AppId = appId;
		SpringConfigurerEx.AppName = AppName;
		SpringConfigurerEx.zooKeeperUrl = zooKeeperUrl;
		SpringConfigurerEx.zooKeeperRootPath = zooKeeperRootPath;
		
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(AppName);
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(zooKeeperUrl);
		registryConfig.setProtocol("zookeeper");
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(packageName);

		
		SpringConfigurerEx.setApplicationConfig(applicationConfig);
		SpringConfigurerEx.setRegistryConfig(registryConfig);
		SpringConfigurerEx.setAnnotationBean(annotationBean);
		
		app.register(SpringConfigurerEx.class);
		app.setServletConfig(new ServletConfigTest());
		app.refresh();
		
	
		IRedisService imp = app.getBean(IRedisService.class);
		String s = imp.get("A1");
		System.out.println(s);
		imp.set("A1", "333");

		s = imp.get("A1");
		System.out.println(s);
		
		app.close();
	}

	@Override
	public boolean exists(String key) {
		lazyInit();
		return client.exists(key);
	}

	@Override
	public void del(String key) {
		client.del(key);
	}
	
	@Override
	public void set(String key, String value) {
		lazyInit();
		client.set(key, value);
		
	}

	@Override
	public void set(String key, String value, int exp) {
		lazyInit();
		client.set(key, value);
		client.expire(key, exp);
	}

	@Override
	public boolean setNx(String key, String value) {
		lazyInit();
		Long l = client.setnx(key, value);
		if(l != null && l.longValue() == 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean setNx(String key, String value, int exp) {
		lazyInit();
		Long l = client.setnx(key, value);
		if(l != null && l.longValue() == 1)
		{
			client.expire(key, exp);
			return true;
		}
		
		return false;
	}

	@Override
	public String get(String key) {
		lazyInit();
		return client.get(key);
	}

	@Override
	public void setObject(String key, Object obj) {
		lazyInit();
		try {
			String b64 = Base64.ToBase64String(SerializeUtil.serialize(obj));
			client.set(key,  b64);
		} catch (Exception ex) {
			log.error("", ex);
		}
		
	}

	@Override
	public void setObject(String key, Object obj, int exp) {
		lazyInit();
		try {
			String b64 = Base64.ToBase64String(SerializeUtil.serialize(obj));
			client.set(key,  b64);
			client.expire(key, exp);
		} catch (Exception ex) {
			log.error("", ex);
		}
		
	}

	@Override
	public boolean setNxObjec(String key, Object obj) {
		lazyInit();
		try {
			String b64 = Base64.ToBase64String(SerializeUtil.serialize(obj));
			Long l = client.setnx(key,  b64);
			if(l != null && l.longValue() == 1)
			{
				return true;
			}
		} catch (Exception ex) {
			log.error("", ex);
		}
		return false;
	}

	@Override
	public boolean setNxObjec(String key, Object obj, int exp) {
		lazyInit();
		try {
			String b64 = Base64.ToBase64String(SerializeUtil.serialize(obj));
			Long l = client.setnx(key,  b64);
			if(l != null && l.longValue() == 1)
			{
				client.expire(key, exp);
				return true;
			}
		} catch (Exception ex) {
			log.error("", ex);
		}
		return false;
	}

	@Override
	public Object getObject(String key) {
		lazyInit();
		try {
			String b64 = (String) client.get(key);
			if(StringUtils.isNotBlank(b64)){
				byte[] d = Base64.FromBase64String(b64);
				
				return SerializeUtil.deserialize(d);
			}

		} catch (Exception ex) {
			log.debug("RedisServiceImp getObject error!");
			//log.error("", ex);
		}
		return null;
	}

	@Override
	public boolean hmSet(String key, Map<String, String> maps) {
		lazyInit();
		String s = client.hmset(key, maps);
		if("OK".equalsIgnoreCase(s)){
			return true;
		}
		return false;
	}

	@Override
	public String hget(String key, String field) {
		lazyInit();
		return client.hget(key,field);
	}

	/**
	 * @category 使key对应的值增加num 参数num可以为负数.如果原来的值不是整数(字符串形式的整数), 它会被先转换成整数.
	 */
	@Override
	public Long incr(String key, Long num) {
		lazyInit();
		return client.incrBy(key, num);
	}

	@Override
	public boolean expire(String key, int ttl) {
		lazyInit();
		return l.equals( client.expire(key, ttl));
	}
	
	
	/**
	 * @category 组设置
	 * @param groupName
	 * @param key
	 * @param value
	 */
	@Override
	public void gset(String groupName,String key,String value,int ttl)
	{
		lazyInit();
		client.sadd(groupName, key);
		set(key, value,ttl);
	}
	@Override
	public void gsetObject(String groupName,String key,Object value,int ttl)
	{
		lazyInit();
		client.sadd(groupName, key);
		setObject(key, value,ttl);
	}
	
	/**
	 * @category get方法
	 * @param groupName
	 * @param key
	 */
	@Override
	public String gget(String groupName,String key)
	{
		lazyInit();
		if(client.sismember(groupName, key))
		{
			return get(key);
		}
		return null;
	}
	@Override
	public Object ggetObject(String groupName,String key)
	{
		lazyInit();
		if(client.sismember(groupName, key))
		{
			return getObject(key);
		}
		return null;
	}
	
	/**
	 * @category 删除组下某一个key
	 * @param groupName
	 * @param key
	 */
	@Override
	public void gdel(String groupName,String key)
	{
		lazyInit();
		client.srem(groupName, key);
		client.del(key);
	}
	
	/**
	 * @category 删除该组下全部值
	 * @param groupName
	 */
	@Override
	public void gdel(String groupName)
	{
		lazyInit();
		List<String> ss = glistKey(groupName);
		for(String s : ss)
		{
			client.del(s);
		}
		client.del(groupName);
	}
	
	/**
	 * @category 列出该组下全部key
	 * @param groupName
	 * @return
	 */
	@Override
	public List<String> glistKey(String groupName)
	{
		lazyInit();
		return new ArrayList<>(client.smembers(groupName));
	}
	
	/**
	 * @category 判断该组下是否有值
	 * @param groupName
	 * @param key
	 * @return
	 */
	@Override
	public boolean gexists(String groupName,String key)
	{
		lazyInit();
		if(client.sismember(groupName, key) && client.exists(key))
		{
			return true;
		}
		return false;
	}
	
}

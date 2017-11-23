package com.fuck.mobile.spring.dubbo;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fuck.mobile.base.constant.Constants;
import com.fuck.mobile.common.ConfigValueImp;
import com.fuck.mobile.common.IConfigValue;
import com.fuck.mobile.common.IZooKeeperConfig;
import com.fuck.mobile.common.zkclient.IZkClientService;
import com.fuck.mobile.common.zkclient.ZkClientServiceImp;
import com.fuck.mobile.spring.DBInit;
import com.fuck.mobile.spring.dubbo.kryo2.Kryo2Factory;
import com.fuck.mobile.util.AtomicDataSource;
import com.fuck.mobile.util.HttpContextHandler;
import com.fuck.mobile.util.NetWorkUtil;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.xnew.CloseEx;
import com.xnew.Log4j2LogBack;
import com.xnew.RequestMappingHandlerMappingEx;
import com.fuck.mobile.common.ZooKeeperConfigImp;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

@Configuration
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = "com.fuck.mobile")
public class SpringConfigurerEx extends ApplicationObjectSupport implements
		SchedulingConfigurer, AsyncConfigurer, TransactionManagementConfigurer{

	static Log log = LogFactory.getLog(SpringConfigurerEx.class);
	
	public static boolean isEnableRest = false;
	public static boolean isEnableThrift = false;
	public static boolean isSchedule = false;
	public static int DobboThreads = 1024;
	public static int RestThreads = 1024;
	public static int ThriftThreads = 1024;
	public static int DobboPort = 0;
	public static int RestPort = 0;
	public static int ThriftPort= 0;
	
	public static String zooKeeperUrl = null;
	public static String zooKeeperRootPath = null;
	public static String AppId = null;
	public static String AppName = null;
	

	@Autowired
	ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	ThreadPoolTaskScheduler taskScheduler;
	@Autowired
	DataSourceTransactionManager dataSourceManager;

	@Autowired
	ApplicationContext applicationContext;

	@Resource(name = "dataSource")
	DataSource mainDataSource;

	private static ArrayList<Class<? extends HandlerInterceptor>> handlerInterceptorList = new ArrayList<Class<? extends HandlerInterceptor>>();

	
	static {
		Log4j2LogBack.ChangeLog4j2LogBack();
		Kryo2Factory.setClassLoader(Thread.currentThread().getContextClassLoader());
		try {
			Class.forName("com.fuck.mobile.config.CustomerConfig");
		} catch (ClassNotFoundException e) {

		}
		// 添加拦截器
		addInterceptorsEx(HttpContextHandler.class);
	}
	
	public static void initLog() {
		try {
			System.setProperty("dubbo.application.logger","slf4j");
			// 初始化logback
			ILoggerFactory ilg = StaticLoggerBinder.getSingleton()
					.getLoggerFactory();
			if (ilg instanceof LoggerContext) {
				LoggerContext ct = (LoggerContext) ilg;
				ct.reset();
				JoranConfigurator configurator = new JoranConfigurator();
				configurator.setContext(ct);

				InputStream is = null;

				String deflog = System.getProperty("logback.configurationFile",null);
				System.out.println("logback.configurationFile -> " + deflog);
				if(StringUtils.isNotEmpty(deflog))
				{
					File f = new File(deflog);
					if(f.exists() && f.isFile())
					{
						is = new FileInputStream(f);
					}
				}
				if(is == null)
				{
					String zooKeeperUrl = SpringConfigurerEx.zooKeeperUrl;
					if(StringUtils.isNotEmpty(zooKeeperUrl))
					{
						ZkClient client = new ZkClient(zooKeeperUrl);
						client.setZkSerializer(new BytesPushThroughSerializer());
						String path = null;
						String commonPath=null;
						String rootPath = SpringConfigurerEx.zooKeeperRootPath;
						String key = Constants.YunWei+"/logback";
						if("/".equals(rootPath)){
							path = rootPath + AppName +"/" + key;
							commonPath = rootPath + "Common" + "/" + key;
						}else{
							path = rootPath + "/" + AppName +"/" + key;
							commonPath = rootPath + "/" + "Common" +"/"+ key;
						}
						byte[] b = null;
						if(client.exists(path)){
							b = client.readData(path);
						}else {
							if(client.exists(commonPath)){
								b = client.readData(commonPath);
							}
						}
						
						if(b != null){
							is = new ByteArrayInputStream(b); 
						}
						client.close();
					}
				}
				
				
				
				if(is == null){
					is = SpringConfigurerEx.class.getResourceAsStream("log.xml");
				}

				if (is == null) {
					is = SpringConfigurerEx.class.getClassLoader().getResourceAsStream("log.xml");
				}

//				String name = ZookeeperUtil.logbackPath;
//				byte[] b = ZookeeperUtil.readDataByte(name);
//				is = new ByteArrayInputStream(b);   
				
				configurator.doConfigure(is);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	

	private static class MyObjx
	{
		private static ApplicationConfig dobboApplicationConfig;
		private static RegistryConfig dobboRegistryConfig;
		private static AnnotationBean dobboAnnotationBean;
	}
	


	public static void setApplicationConfig(ApplicationConfig c) {
		MyObjx.dobboApplicationConfig = c;
	}

	public static void setRegistryConfig(RegistryConfig r) {
		MyObjx.dobboRegistryConfig = r;
	}

	public static void setAnnotationBean(AnnotationBean a) {
		MyObjx.dobboAnnotationBean = a;
	}

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig c = MyObjx.dobboApplicationConfig;
		if (c == null)
			throw new RuntimeException("dobboApplicationConfig not set");
		return c;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig r = MyObjx.dobboRegistryConfig;
		if (r == null)
			throw new RuntimeException("dobboRegistryConfig not set");

		return r;
	}
	
	@Bean
	public IZkClientService zkClientService()
	{
		if(zooKeeperUrl == null)
		{
			throw new RuntimeException("zooKeeperUrl not set");
		}
		return new ZkClientServiceImp(zooKeeperUrl);
	}
	
	@Bean
	public IZooKeeperConfig ZooKeeperConfig(IZkClientService s)
	{
		if(zooKeeperRootPath == null)
		{
			throw new RuntimeException("zooKeeperRootPath not set");
		}
		if (AppName== null) {
			throw new RuntimeException("AppName not set");
		}
		return new ZooKeeperConfigImp(s, zooKeeperRootPath,AppName);
	}
	
	@Bean
	@Autowired
	public IConfigValue ConfigValue(IZooKeeperConfig config)
	{
		if(AppName == null)
		{
			throw new RuntimeException("AppName not set");
		}
		
		return new ConfigValueImp(config, AppName);
	}
	

	@Bean
	public static AnnotationBean annotationBean() {
		AnnotationBean a = MyObjx.dobboAnnotationBean;
		if (a == null)
			throw new RuntimeException("dobboAnnotationBean not set");
		return a;
	}
	
	private void initDubboConfig(IZooKeeperConfig config)
	{
		ConfigurableApplicationContext app = (ConfigurableApplicationContext) applicationContext;	
		{
			ProviderConfig pc = new ProviderConfig();
			pc.setProxy("jdk");
			pc.setAccesslog(true);
			pc.setCharset("utf-8");
			pc.setRetries(0);
			
			String key = Constants.YunWei+"/DubboConfig/Threads";
			int thread = 1024;
			try {
				thread = Integer.valueOf(config.get(key));
			} catch (Exception e) {
				thread = 1024;
			}
			
			pc.setThreads(thread);
			
			
			app.getBeanFactory().registerSingleton("providerConfig", pc);
		}
		if(isSchedule)
		{
			log.info("app run in Schedule。。。");
			ProtocolConfig protocol = new ProtocolConfig();
			protocol.setName("injvm");
			app.getBeanFactory().registerSingleton("injvmProtocolConfig", protocol);
			return;
		}
		
		{
			log.debug("dubboProtocolConfig....");
			ProtocolConfig protocol = new ProtocolConfig();
			protocol.setName("dubbo");
			protocol.setSerialization("kryo2");
			if(DobboPort != 0)
			{
				protocol.setPort(DobboPort);
			}else
			{
				protocol.setPort(NetWorkUtil.getAvailablePort());
			}
			log.debug("DobboPort -> " + protocol.getPort());
			
			protocol.setThreads(DobboThreads);
			app.getBeanFactory().registerSingleton("dubboProtocolConfig", protocol);
		}
		if(isEnableRest)
		{
			ProtocolConfig protocol2 = new ProtocolConfig();
			log.debug("RestProtocolConfig....");
			protocol2.setName("rest");
			if(RestPort != 0)
			{
				protocol2.setPort(RestPort);
			}else
			{
				protocol2.setPort(NetWorkUtil.getAvailablePort());
			}
			
			protocol2.setThreads(RestThreads);
			app.getBeanFactory().registerSingleton("RestProtocolConfig", protocol2);	
			
		}
		if(isEnableThrift)
		{
			log.debug("ThriftProtocolConfig....");
			ProtocolConfig protocol2 = new ProtocolConfig();
			protocol2.setName("thrift");
			if(ThriftPort != 0)
			{
				protocol2.setPort(ThriftPort);
			}else
			{
				protocol2.setPort(NetWorkUtil.getAvailablePort());
			}
			
			protocol2.setThreads(ThriftThreads);
			app.getBeanFactory().registerSingleton("ThriftProtocolConfig", protocol2);
			
		}
	}

		
	@Bean
	@Autowired
	public ConsumerConfig consumerConfig(IZooKeeperConfig config)
	{
		initDubboConfig(config);
		ConsumerConfig c = new ConsumerConfig();
		c.setTimeout(60000);
		c.setCheck(false);
		c.setRetries(0);
		c.setProxy("jdk");
		c.setCluster("failoverx");
		return c;
	}
	

	/**
	 * @category 添加拦截器
	 * @param handle
	 */
	public static void addInterceptorsEx(
			Class<? extends HandlerInterceptor> handle) {
		handlerInterceptorList.add(handle);
	}

	

	@Lazy
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		log.debug("requestMappingHandlerMapping .......................");
		RequestMappingHandlerMappingEx map = new RequestMappingHandlerMappingEx();
		if (handlerInterceptorList != null) {
			try {
				List<Class<? extends HandlerInterceptor>> objs = handlerInterceptorList;
				if (objs != null && objs.size() > 0) {
					AbstractApplicationContext myapp = null;
					if (applicationContext instanceof AbstractApplicationContext) {
						myapp = (AbstractApplicationContext) applicationContext;
					}
					Object[] os = new Object[objs.size()];
					for (int i = 0; i < objs.size(); i++) {
						Class<? extends HandlerInterceptor> c = objs.get(i);
						Object o = null;
						if (myapp == null) {
							o = c.newInstance();
						} else {
							try {
								o = myapp.getBeanFactory().getBean(c);
							} catch (Exception ex) {

							}
							if (o == null) {
								o = myapp.getBeanFactory().createBean(c);
							}
						}

						os[i] = o;
					}

					map.setInterceptors(os);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return map;
	}

	/**
	 * @category 配置事务
	 */
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		{
			log.debug("using DataSourceTransactionManager...............");
			DataSourceTransactionManager dts = new DataSourceTransactionManager(
					mainDataSource);
			return dts;
		}
	}

	/**
	 * @category 配置Asyc
	 */
	@Override
	public Executor getAsyncExecutor() {

		return taskExecutor;
	}

	/**
	 * @category 配置Scheduler
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

		scheduledTaskRegistrar.setTaskScheduler(taskScheduler);
	}

	/**
	 * @category 文件上传支持
	 * @return
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(512000000L);
		multipartResolver.setMaxInMemorySize(10240);
		return multipartResolver;
	}

	/**
	 * @category 视图解析器
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/**
	 * @category Async任务
	 * @return
	 */
	@Bean
	@Autowired
	public ThreadPoolTaskExecutor taskExecutor(IZooKeeperConfig config) {

		org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor r = new org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor();
		
		String key = Constants.YunWei+"/DubboConfig/ExecutorPoolSize";
		int ExecutorPoolSize = 128;
		try {
			ExecutorPoolSize = Integer.valueOf(config.get(key));
		} catch (Exception e) {
			ExecutorPoolSize = 128;
		}
		
		log.debug("taskExecutor Pool Size -> " + ExecutorPoolSize);
		r.setCorePoolSize(ExecutorPoolSize);
		long c = ExecutorPoolSize;
		if (c * 2 > Integer.MAX_VALUE) {
			r.setMaxPoolSize((int) c);
		} else {
			r.setMaxPoolSize(Integer.MAX_VALUE);
		}
		r.setQueueCapacity(Integer.MAX_VALUE);
		r.setWaitForTasksToCompleteOnShutdown(true);
		r.setAwaitTerminationSeconds(60);
		r.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

		// r.initialize();

		return r;
	}

	/**
	 * @category Scheduler任务
	 * @return
	 */
	@Bean
	@Autowired
	public ThreadPoolTaskScheduler taskScheduler(IZooKeeperConfig config) {

		org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler r = new org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler();
		String key = Constants.YunWei+"/DubboConfig/SchedulerPoolSize";
		int SchedulerPoolSize = 128;
		try {
			SchedulerPoolSize = Integer.valueOf(config.get(key));
		} catch (Exception e) {
			SchedulerPoolSize = 128;
		}
		
		log.debug("taskScheduler Pool Size -> " + SchedulerPoolSize);
		r.setPoolSize(SchedulerPoolSize);
		// r.setWaitForTasksToCompleteOnShutdown(true);
		r.setAwaitTerminationSeconds(60);
		r.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());

		return r;
	}

	private static void SetPropertieValue(Object self, String propertieName,
			Object value) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			SecurityException, NoSuchMethodException {

		String setter = "set" + propertieName;

		ArrayList<Method> allmethods = new ArrayList<Method>();

		Class<?> objclass = self.getClass();
		while (objclass != Object.class) {
			Method[] ms = objclass.getDeclaredMethods();
			for (Method m : ms) {
				allmethods.add(m);
			}
			objclass = objclass.getSuperclass();
		}

		Method method = null;
		for (Method m : allmethods) {
			String name = m.getName();
			if (name.equalsIgnoreCase(setter)) {
				method = m;
				break;
			}
		}
		if (method == null) {
			throw new NoSuchMethodError(setter);
		}
		method.setAccessible(true);

		Class<?> cc = method.getParameterTypes()[0];

		if (value.getClass().isAssignableFrom(cc)) {
			method.invoke(self, value);
		} else if (cc == int.class || cc == Integer.class) {
			method.invoke(self, Integer.parseInt(value.toString()));
		} else if (cc == long.class || cc == Long.class) {
			method.invoke(self, Long.parseLong(value.toString()));
		} else if (cc == short.class || cc == Short.class) {
			method.invoke(self, Short.parseShort(value.toString()));
		} else if (cc == float.class || cc == Float.class) {
			method.invoke(self, Float.parseFloat(value.toString()));
		} else if (cc == double.class || cc == Double.class) {
			method.invoke(self, Double.parseDouble(value.toString()));
		} else if (cc == BigInteger.class) {
			method.invoke(self, new BigInteger(value.toString()));
		} else if (cc == BigDecimal.class) {
			method.invoke(self, new BigDecimal(value.toString()));
		} else if (cc == byte.class || cc == Byte.class) {
			method.invoke(self, Byte.parseByte(value.toString()));
		} else if (cc.isAssignableFrom(String.class)) {
			method.invoke(self, value.toString());
		} else if (cc == boolean.class || cc == Boolean.class) {
			String vv = value.toString();
			if ("1".equals(vv) || "true".equalsIgnoreCase(vv)) {
				method.invoke(self, true);
			} else if ("0".equals(vv) || "false".equals(vv)) {
				method.invoke(self, false);
			} else {
				method.invoke(self, Boolean.parseBoolean(vv));
			}

		} else {
			throw new IllegalArgumentException("Not support Args,Method->"
					+ setter + ",ArgType->" + method.getParameterTypes());
		}

	}

	/**
	 * @category 数据库
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NamingException
	 */
	@Bean(name = "dataSource")
	@Autowired
	public DataSource dataSource(CloseEx closeEx,IZooKeeperConfig config,IZkClientService zkClient) {
		String sourceName = Constants.YunWei+"/DataSource/DB_MAIN/";
		AtomicDataSource ret = new AtomicDataSource(null);
		try {
			
			DataSource sdb = DBInit.createNewDataSource();
			
			SetPropertieValue(sdb,"driverClassName", config.get(sourceName+"driverClassName"));
			SetPropertieValue(sdb,"url",			 config.get(sourceName+"url"));
			SetPropertieValue(sdb,"maxActive",		 config.get(sourceName+"maxActive"));
			SetPropertieValue(sdb,"maxIdle",		 config.get(sourceName+"maxIdle"));
			SetPropertieValue(sdb,"maxWait",		 config.get(sourceName+"maxWait"));
			SetPropertieValue(sdb,"username",		 config.get(sourceName+"username"));
			SetPropertieValue(sdb,"password",		 config.get(sourceName+"password"));
			SetPropertieValue(sdb,"validationQuery", config.get(sourceName+"validationQuery"));
			SetPropertieValue(sdb,"testWhileIdle",	 config.get(sourceName+"testWhileIdle"));
	
			log.debug("dataSource ->" + config.get(sourceName+"url"));
			ret.setDataSource(sdb);
			closeEx.addClose(ret);
			
			//检测数据源变化
			String urlPath = sourceName + "url";
			dataChanges(sourceName,urlPath,ret,config,zkClient);
			
			return ret;
			
		}catch(Exception ex){
			log.debug("DB Init Error??????",ex);
			
			log.debug("run on app?????");
			BasicDataSource sds = new BasicDataSource();
			
			sds.setDriverClassName("com.mysql.jdbc.Driver");
			sds.setUrl("jdbc:mysql://172.20.31.107:3306/neo?characterEncoding=utf-8&autoReconnect=true");
			sds.setUsername("root");
			sds.setPassword("123456");
			sds.setValidationQuery("select 1;");
//			sds.setValidationQueryTimeout(5);
			ret.setDataSource(sds);
			closeEx.addClose(ret);
			return ret;
		} 
		
	}
	
	@Bean(name = "mainReadOnlyDataSource")
	@Autowired
	public DataSource mainReadOnlyDataSource(CloseEx closeEx,IZooKeeperConfig config,IZkClientService zkClient) {
		String sourceName = Constants.YunWei+"/DataSource/DB_MAIN_READONLY/";
		String url = null;
		try
		{
			url = config.get(sourceName+"url");
		}catch(Exception e)
		{
		}
		if(url == null)
		{
			sourceName = Constants.YunWei+"/DataSource/DB_MAIN/";
		}
		AtomicDataSource ret = new AtomicDataSource(null);
		try {
			
			DataSource sdb = DBInit.createNewDataSource();
			
			SetPropertieValue(sdb,"driverClassName", config.get(sourceName+"driverClassName"));
			SetPropertieValue(sdb,"url",			 config.get(sourceName+"url"));
			SetPropertieValue(sdb,"maxActive",		 config.get(sourceName+"maxActive"));
			SetPropertieValue(sdb,"maxIdle",		 config.get(sourceName+"maxIdle"));
			SetPropertieValue(sdb,"maxWait",		 config.get(sourceName+"maxWait"));
			SetPropertieValue(sdb,"username",		 config.get(sourceName+"username"));
			SetPropertieValue(sdb,"password",		 config.get(sourceName+"password"));
			SetPropertieValue(sdb,"validationQuery", config.get(sourceName+"validationQuery"));
			SetPropertieValue(sdb,"testWhileIdle",	 config.get(sourceName+"testWhileIdle"));
			log.debug("dataSource ->" + config.get(sourceName+"url"));
			ret.setDataSource(sdb);
			closeEx.addClose(ret);
			
			//检测数据源变化
			String urlPath = sourceName + "url";
			dataChanges(sourceName,urlPath,ret,config,zkClient);
			
			return ret;
			
		}catch(Exception ex){
			log.debug("DB Init Error??????",ex);
			
			log.debug("run on app?????");
			BasicDataSource sds = new BasicDataSource();
			
			sds.setDriverClassName("com.mysql.jdbc.Driver");
			sds.setUrl("jdbc:mysql://172.20.31.107:3306/neo?characterEncoding=utf-8&autoReconnect=true");
			sds.setUsername("root");
			sds.setPassword("123456");
			sds.setValidationQuery("select 1;");
//			sds.setValidationQueryTimeout(5);
			ret.setDataSource(sds);
			closeEx.addClose(ret);
			return ret;
		} 
		
	}
	
	private void dataChanges(final String sourceName,final String urlPath,final AtomicDataSource ret,final IZooKeeperConfig config,IZkClientService zkClient) {
		
		ZkClient client = zkClient.getZkClient();
		String path = config.getPath(urlPath);
		if(!client.exists(path)){
			path = config.getCommonPath(urlPath);
		}
		
		client.subscribeDataChanges(path, new IZkDataListener() {
			
			@Override
			public void handleDataDeleted(String arg0) throws Exception {
				
			}
			
			@Override
			public void handleDataChange(String arg0, Object arg1) throws Exception {
				if(arg1 == null)
					return;
				Object argObj = null;
				if(arg1 instanceof String)
				{
					argObj = (String) arg1;
				}else if(arg1 instanceof byte[])
				{
					argObj = new String((byte[]) arg1,"utf-8");
				}else
				{
					argObj = arg1;
				}
				log.debug("handleDataChange arg0->" + arg0 +" ,arg1-> "+ argObj );
				
				
				DataSource sdb = DBInit.createNewDataSource();
				SetPropertieValue(sdb,"driverClassName", config.get(sourceName+"driverClassName"));
				SetPropertieValue(sdb,"url",			 config.get(sourceName+"url"));
				SetPropertieValue(sdb,"maxActive",		 config.get(sourceName+"maxActive"));
				SetPropertieValue(sdb,"maxIdle",		 config.get(sourceName+"maxIdle"));
				SetPropertieValue(sdb,"maxWait",		 config.get(sourceName+"maxWait"));
				SetPropertieValue(sdb,"username",		 config.get(sourceName+"username"));
				SetPropertieValue(sdb,"password",		 config.get(sourceName+"password"));
				SetPropertieValue(sdb,"validationQuery", config.get(sourceName+"validationQuery"));
				SetPropertieValue(sdb,"testWhileIdle",	 config.get(sourceName+"testWhileIdle"));
				
				ret.close2();
				ret.setDataSource(sdb);
			}
		});
	}

	@Bean
	@Resource(name = "dataSource")
	public DataSourceTransactionManager dataSourceManager(DataSource dataSource) {
		DataSourceTransactionManager dataSourceManager = new DataSourceTransactionManager();
		dataSourceManager.setDataSource(dataSource);
		return dataSourceManager;
	}

	@Bean
	@Resource(name = "dataSource")
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new org.springframework.jdbc.core.JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}

	
	@Bean
	public CloseEx closeEx() {
		return new CloseEx();
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

		return new SimpleAsyncUncaughtExceptionHandler();
	}
	
}

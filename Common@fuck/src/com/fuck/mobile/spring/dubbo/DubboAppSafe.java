package com.fuck.mobile.spring.dubbo;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import com.fuck.mobile.base.constant.Constants;
import com.fuck.mobile.common.RedisKeeperLock;
import com.fuck.mobile.common.RedisServiceImp;
import com.fuck.mobile.spring.AppSpringDispatcherServlet;
import com.fuck.mobile.util.NetWorkUtil;
import com.fuck.mobile.util.PropertiesUtil;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.xnew.AnnotationConfigApplicationContextEx;
import com.xnew.LocalNetServer;
import com.fuck.mobile.common.IRedisKeeperLock;
import com.fuck.mobile.util.Device;

class DubboAppSafe {
	static 
	{
		SpringConfigurerEx.initLog();
	}
	
	static Log log = LogFactory.getLog(DubboApp.class);

	public static class ServiceSetting {
		public boolean isEnable;
		public int port;
		public int threadCount;

		public ServiceSetting() {
		}

		public ServiceSetting(boolean isEnable) {
			this.isEnable = isEnable;
		}

		public ServiceSetting(boolean isEnable, int port, int threadCount) {
			this.isEnable = isEnable;
			this.port = port;
			this.threadCount = threadCount;
		}

	}

	protected static AnnotationConfigApplicationContextEx appContext;

	private String zkUrl, zkPath, AppName, AppId, PackageName;
	private boolean isSchedule = false;

	public String getAppName() {
		return AppName;
	}

	public String getAppId() {
		return AppId;
	}

	public String getZooKeeperUrl() {
		return zkUrl;
	}

	public String getZooKeeperPath() {
		return zkPath;
	}

	public String getPackageName() {
		return PackageName;
	}

	public DubboAppSafe(String zkUrl, String zkPath, String appName, String appId, String packageName) {
		this(zkUrl, zkPath, appName, appId, packageName, false);
	}

	public DubboAppSafe(String zkUrl, String zkPath, String appName, String appId, String packageName, boolean isSchedule) {
		this.zkUrl = zkUrl;
		this.zkPath = zkPath;
		String osname = System.getProperties().getProperty("os.name").toLowerCase();
		if(osname.indexOf("windows") < 0)
		{
			Properties p= PropertiesUtil.loadResource(AppSpringDispatcherServlet.jarConfigName, AppSpringDispatcherServlet.localWindowsConfigName, AppSpringDispatcherServlet.linuxConfigName);
			String ZooKeeperUrl = p.getProperty("ZooKeeperUrl");
			String zooKeeperPath = p.getProperty("ZooKeeperPath");
			if(StringUtils.isNotEmpty(ZooKeeperUrl) && StringUtils.isNotEmpty(zooKeeperPath))
			{
				log.debug("use local ZooKeeperUrl setting");
				this.zkUrl = ZooKeeperUrl;
				this.zkPath = zooKeeperPath;
			}
		}
		this.AppId = appId;
		this.AppName = appName;
		this.PackageName = packageName;
		this.isSchedule = isSchedule;
	}

	public ServiceSetting getRestServiceSetting() {
		ServiceSetting s = new ServiceSetting(false);

		return s;
	}

	public ServiceSetting getThriftServiceSetting() {
		ServiceSetting s = new ServiceSetting(false);

		return s;
	}

	public ServiceSetting getDubboServiceSetting() {
		ServiceSetting s = new ServiceSetting(true, SpringConfigurerEx.DobboPort, SpringConfigurerEx.DobboThreads);

		if(s.port == 0)
		{
			try
			{
				String portstr = "5" + AppId;
				int p = Integer.parseInt(portstr);
				if(NetWorkUtil.isPortAvailable(p))
				{
					s.port = p;
				}else
				{
					for(int i = 5; i < 10;i++)
					{
						p += 5;
						if(NetWorkUtil.isPortAvailable(p))
						{
							s.port = p;
							break;
						}
					}
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return s;
	}

	public final void stopApp() {
		try {
			String localPortFile = System.getProperty("LocalStop.Port", null);
			if (localPortFile == null) {
				log.warn("LocalStop.Port not set");
				return;
			}
			File f = new File(localPortFile);
			if (!f.exists()) {
				log.warn(localPortFile + " not found");
				return;
			}

			String s = new String(FileUtils.readFileToByteArray(f));
			int port = Integer.parseInt(s);
			LocalNetServer.sendLocalMsg("Stop", port);
		} catch (Exception e) {
			log.warn("", e);
		} finally {
			System.exit(0);
		}

	}
	
	private void checkExit()
	{
		String localPortFile = System.getProperty("LocalStop.Exit", null);
		if(StringUtils.equals("Stop", localPortFile))
		{
			stopApp();
		}
	}

	public final void startApp() {
//		System.setProperty("LocalStop.Exit", "Stop");
		checkExit();
		
		SpringConfigurerEx.AppId = getAppId();
		SpringConfigurerEx.AppName = getAppName();
		SpringConfigurerEx.zooKeeperUrl = getZooKeeperUrl();
		SpringConfigurerEx.zooKeeperRootPath = getZooKeeperPath();
		SpringConfigurerEx.isSchedule = isSchedule;

		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(getAppName());
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(getZooKeeperUrl());
		registryConfig.setProtocol("zookeeper");
		registryConfig.setCheck(false);
		AnnotationBean annotationBean = new AnnotationBeanEx();
		annotationBean.setPackage(getPackageName());

		SpringConfigurerEx.setApplicationConfig(applicationConfig);
		SpringConfigurerEx.setRegistryConfig(registryConfig);
		SpringConfigurerEx.setAnnotationBean(annotationBean);

		SpringConfigurerEx.isEnableRest = getRestServiceSetting().isEnable;
		SpringConfigurerEx.RestPort = getRestServiceSetting().port;
		SpringConfigurerEx.RestThreads = getRestServiceSetting().threadCount;

		SpringConfigurerEx.isEnableThrift = getThriftServiceSetting().isEnable;
		SpringConfigurerEx.ThriftPort = getThriftServiceSetting().port;
		SpringConfigurerEx.ThriftThreads = getThriftServiceSetting().threadCount;

		if (!getDubboServiceSetting().isEnable) {
			throw new RuntimeException("dubbo must enable");
		}
		SpringConfigurerEx.DobboPort = getDubboServiceSetting().port;
		SpringConfigurerEx.DobboThreads = getDubboServiceSetting().threadCount;

		SpringConfigurerEx.initLog();
		ScheduleWait();
		appContext = new AnnotationConfigApplicationContextEx();
		appContext.register(SpringConfigurerEx.class);
		appContext.refresh();
		appContext.startApp();

		ScheduleExit();
	}

	// ---
	private static RedisServiceImp redis = null;
	private static IRedisKeeperLock.Lock lock = null;

	private static void ScheduleWait()  {
		if (!SpringConfigurerEx.isSchedule) {
			return;
		}
		Log log = LogFactory.getLog(DubboApp.class);
		log.debug("--------------------------");
		log.debug("ScheduleWait");
		log.debug("--------------------------");

		ZkClient 	zkConfig = new ZkClient(SpringConfigurerEx.zooKeeperUrl);
		zkConfig.setZkSerializer(new BytesPushThroughSerializer());
		// ZkClientServiceImp
		
		String path = SpringConfigurerEx.zooKeeperRootPath + "/Common/"; 
		
		try
		{
			String redisUrl = new String((byte[])zkConfig.readData(path + Constants.YunWei+"/RedisServer/Redis4APP/url"),"utf-8");
			String masterName = new String((byte[])zkConfig.readData(path +Constants.YunWei+"/RedisServer/Redis4APP/masterName"),"utf-8");
			Integer RedisDatabaseNumber = Integer.parseInt(new String((byte[])zkConfig.readData(path + Constants.YunWei+"/RedisServer/Redis4APP/databaseNumber"),"utf-8"));
			Integer RedisTimeout = Integer.parseInt(new String((byte[])zkConfig.readData(path +Constants.YunWei+"/RedisServer/Redis4APP/timeout"),"utf-8"));
			redis = new RedisServiceImp();
			redis.initRedis(redisUrl, masterName, RedisDatabaseNumber, RedisTimeout);
			RedisKeeperLock rkeeplock = new RedisKeeperLock(redis);
			
			lock = rkeeplock.getLock(Device.getDeviceId());
			lock.lock();
			log.debug("--------------------------");
			log.debug("ScheduleWait start.......");
			log.debug("--------------------------");
		}catch( UnsupportedEncodingException e)
		{
			
		}
		
		
	
	}

	private static void ScheduleExit() {
		if (lock != null) {
			lock.unlock();
		}
		if (redis != null) {
			try {
				redis.close2();
			} catch (Exception e) {
			}
		}
	}
}

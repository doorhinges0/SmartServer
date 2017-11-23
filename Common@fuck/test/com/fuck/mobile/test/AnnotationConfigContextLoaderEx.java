package com.fuck.mobile.test;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextLoader;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.xnew.AnnotationConfigApplicationContextEx;
import com.fuck.mobile.spring.dubbo.SpringConfigurerEx;

public class AnnotationConfigContextLoaderEx implements  ContextLoader{
	
	private static final String AppName = "trustee";
	private static final String AppID = "1f1f1f1f1f";
	private static final String PackageName = "com.fuck.trustee";
	static
	{
		init();
	}
	
	public static void init()
	{
		String zkaddr = "192.168.0.204:2181";
		String configPath= "/AppConfig/ZYXR";
		
		SpringConfigurerEx.AppId = AppID;
		SpringConfigurerEx.AppName = AppName;
		SpringConfigurerEx.zooKeeperUrl = zkaddr;
		SpringConfigurerEx.zooKeeperRootPath = configPath;
		
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(AppName);
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(zkaddr);
		registryConfig.setProtocol("zookeeper");
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(PackageName);

		
		SpringConfigurerEx.setApplicationConfig(applicationConfig);
		SpringConfigurerEx.setRegistryConfig(registryConfig);
		SpringConfigurerEx.setAnnotationBean(annotationBean);
		
		SpringConfigurerEx.initLog();
	}
	
	@Override
	public String[] processLocations(Class<?> paramClass,
			String... paramVarArgs) {
//		System.out.println("processLocations -> " +  paramClass + ", args -> " + Arrays.toString(paramVarArgs));
		if(paramVarArgs.length == 0)
		{
			return new String[1];
		}
		return paramVarArgs;
	}
	
	
	AnnotationConfigApplicationContextEx appContext = null;
	@Override
	public ApplicationContext loadContext(String... paramVarArgs)
			throws Exception {
//		System.out.println("loadContext");
		
		
		if(appContext != null)
		{
			return appContext;
		}
		
		appContext = new AnnotationConfigApplicationContextEx();
		
		appContext.register(SpringConfigurerEx.class);
		appContext.refresh();
		return appContext;
	}

	

	


}

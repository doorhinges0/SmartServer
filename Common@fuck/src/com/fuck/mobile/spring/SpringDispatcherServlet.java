package com.fuck.mobile.spring;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

import javax.el.ELResolver;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.jsp.JspApplicationContext;
import javax.servlet.jsp.JspFactory;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.xnew.AnnotationConfigWebApplicationContextEx;
import com.fuck.mobile.base.constant.Constants;
import com.fuck.mobile.base.jstl.FieldELResolver;
import com.fuck.mobile.spring.dubbo.AnnotationBeanEx;
import com.fuck.mobile.spring.test.ServletConfigTest;
import com.fuck.mobile.util.Device;
import com.fuck.mobile.util.PropertiesUtil;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

public class SpringDispatcherServlet extends HttpServlet {
	private static Log log = LogFactory.getLog(SpringDispatcherServlet.class);
	private static final long serialVersionUID = 4752159844101984081L;
    protected AnnotationConfigWebApplicationContext appContext = null;
    protected DispatcherServlet defaultServlet = null;
    protected FieldELResolver felr = new FieldELResolver();

    private static String appId=null;
    private static String appName=null;
    private static String packageName =null;
    
    public static final String jarConfigName = "/config.properties";
    public static final String localWindowsConfigName = "d:/config.properties";
    public static final String linuxConfigName = "/data/config/config.properties";
	
	public void setAppConfig(String appId,String appName,String packageName) {
		SpringDispatcherServlet.appId = appId;
		SpringDispatcherServlet.appName = appName;
		SpringDispatcherServlet.packageName = packageName;
	}
    
    public static void initLog()
    {
    	log.debug("SpringDispatcherServlet---> initLog");
    	try {
			// 初始化logback
			ILoggerFactory ilg = StaticLoggerBinder.getSingleton()
					.getLoggerFactory();
			if (ilg instanceof LoggerContext) {
				LoggerContext ct = (LoggerContext) ilg;
				ct.reset();
				JoranConfigurator configurator = new JoranConfigurator();
				configurator.setContext(ct);

				InputStream is = null;
				
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
						path = rootPath + SpringConfigurerEx.AppName +"/" + key;
						commonPath = rootPath + "Common" + "/" + key;
					}else{
						path = rootPath + "/" + SpringConfigurerEx.AppName +"/" + key;
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
					
					if(b!=null){
						is = new ByteArrayInputStream(b); 
					}
					client.close();
				}
				
				if (is == null) {
					is = SpringConfigurerEx.class.getResourceAsStream("log.xml");
				}
				if (is == null) {
					is = SpringConfigurerEx.class.getClassLoader().getResourceAsStream("log.xml");
				}
				
				configurator.doConfigure(is);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		defaultServlet.service(req, res);
	}

	@Override
	public void destroy() {
		JspApplicationContext japc=	JspFactory.getDefaultFactory().getJspApplicationContext(this.getServletContext());
		try
		{
			Field f  = japc.getClass().getDeclaredField("resolvers");
			f.setAccessible(true);
			@SuppressWarnings("unchecked")
			List<ELResolver> ll = (List<ELResolver>) f.get(japc);
			ll.remove(felr);
			log.debug("remove FieldELResolver success......");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		super.destroy();
		defaultServlet.destroy();
	}
	
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		Properties p= PropertiesUtil.loadResource(jarConfigName,localWindowsConfigName, linuxConfigName);  
		String ZooKeeperUrl = p.getProperty("ZooKeeperUrl");
		String zooKeeperPath = p.getProperty("ZooKeeperPath");
		
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(appName);
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(ZooKeeperUrl);
		registryConfig.setProtocol("zookeeper");
		registryConfig.setCheck(false);
		AnnotationBean annotationBean = new AnnotationBeanEx();
		annotationBean.setPackage(packageName);

		
		SpringConfigurerEx.setApplicationConfig(applicationConfig);
		SpringConfigurerEx.setRegistryConfig(registryConfig);
		SpringConfigurerEx.setAnnotationBean(annotationBean);
		
		SpringConfigurerEx.AppId = appId;
		SpringConfigurerEx.AppName = appName;
		SpringConfigurerEx.zooKeeperRootPath = zooKeeperPath;
		SpringConfigurerEx.zooKeeperUrl = ZooKeeperUrl;
		
		initLog();
		
		super.init(config);
		
		ErrorEx.init(config.getServletContext());
		Device.setServletName(config.getServletContext().getContextPath().replaceAll("/", "-"));
		JspFactory jspFact = JspFactory.getDefaultFactory();
		if(jspFact == null)
		{
			try
			{
				Class.forName("org.apache.jasper.compiler.JspRuntimeContext");
				jspFact = JspFactory.getDefaultFactory();
			}catch(Exception e){}
		}
		if(jspFact != null)
		{
			log.debug("Got JspFactory ............");
			JspApplicationContext japc=	jspFact.getJspApplicationContext(this.getServletContext());
			japc.addELResolver(felr);
		}
		
		
		
		appContext = new AnnotationConfigWebApplicationContextEx();
		
		appContext.register(SpringConfigurerEx.class);
		
		appContext.setServletContext(config.getServletContext());
	
		
		defaultServlet = new DispatcherServlet(appContext);
		defaultServlet.init(config);
		

	}
	
//	static interface IServerXXXXXXX
//	{
//
//		void doTT() throws Exception;
//		
//	}
//	
//	
//	@Repository
//	 static class xx implements IServerXXXXXXX
//	 {
//
//		@Override
//		public void doTT() throws Exception {
//			System.out.println("doTT");
//			
//		}
//		 
//	 }
	
	
	
	public static void main(String[] args) throws Exception
	{
		AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContextEx();
		app.register(SpringConfigurerEx.class);
		app.setServletConfig(new ServletConfigTest());
		app.refresh();
//		IServerXXXXXXX s = app.getBean(IServerXXXXXXX.class);
//		s.doTT();
		
		
		
		
//		Thread.sleep(1000);
//		log.debug("Wait Exit");
		app.close();
//		log.debug("Exit");
		
	}

	
	

}

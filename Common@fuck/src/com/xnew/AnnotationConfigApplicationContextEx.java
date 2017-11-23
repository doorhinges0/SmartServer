package com.xnew;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.serialize.support.kryo.KryoFactory;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.container.Container;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.dubbo.DubboRegistryFactory;
import com.alibaba.dubbo.registry.zookeeper.ZookeeperRegistry;
import com.alibaba.dubbo.remoting.zookeeper.ZookeeperClient;
import com.fuck.mobile.spring.dubbo.AppExitProcess;

public class AnnotationConfigApplicationContextEx extends AnnotationConfigApplicationContext {
	private static Log log = LogFactory.getLog(AnnotationConfigApplicationContextEx.class);

	public AnnotationConfigApplicationContextEx() {
		setClassLoader(Thread.currentThread().getContextClassLoader());
//		KryoFactory.setDefaultClassLoader(Thread.currentThread().getContextClassLoader());
	}

	ExtensionLoader<Container> loader = ExtensionLoader.getExtensionLoader(Container.class);

	@Override
	public void close() {
		AppExitProcess.Exit();
		log.debug("wait dubbo invoke exit ...............");
		System.out.println("wait dubbo invoke exit ...............");
		for(int i = 0; i < 60; i++)
		{
			long tt = AppExitProcess.getInvokeTimes();
			if(tt <= 0)
			{
				log.debug("wait for send objs............");
				System.out.println("wait for send objs............");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				}
				break;
			}
			log.debug("dubbo has " + tt + " invokers");
			System.out.println("dubbo has " + tt + " invokers");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		log.debug("all invoke has finished............");
		System.out.println("all invoke has finished............");
		
		ProtocolConfig.destroyAll();
		CloseEx cx = getBean(CloseEx.class);
		try {
			super.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cx.closeEx();
	}

	private boolean isStart = false;
	private boolean isSystemExit = true;
	private Object waitObj = new Object();

	private LocalNetServer lc = null;

	public void startApp() {
		isStart = true;
		lc = new LocalNetServer((msg) -> {
			if (StringUtils.equals("Stop", msg)) {
				log.debug("got exit status.......................");
				System.out.println("got exit status.......................");
				isStart = false;
				synchronized (waitObj) {
					try {
						waitObj.notify();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				lc.stop();
			}
		});
		try {
			String localPortFile = System.getProperty("LocalStop.Port", null);
			if (localPortFile != null) {
				lc.start();
				FileOutputStream fs = new FileOutputStream(localPortFile);
				fs.write(String.valueOf(lc.getPort()).getBytes());
				fs.close();
			}

		} catch (IOException e1) {
			log.error("", e1);
		}

		synchronized (waitObj) {
			while (isStart) {
				try {
					waitObj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		log.info("---------------------------------");
		log.info("app Start exit");
		log.info("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("app Start exit");
		System.out.println("---------------------------------");
		this.close();
		log.info("---------------------------------");
		log.info("app exited");
		log.info("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("app exited");
		System.out.println("---------------------------------");
		if (isSystemExit) {
			System.out.println("force exit.......");
			System.exit(0);
		}

	}

}

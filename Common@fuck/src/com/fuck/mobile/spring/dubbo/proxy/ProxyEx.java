package com.fuck.mobile.spring.dubbo.proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.ProxyFactory;

@SuppressWarnings("deprecation")
@Component
public class ProxyEx {

	static Log log = LogFactory.getLog(ProxyEx.class);

	static {
		log.debug("ProxyEx ....");
		ExtensionLoader<ProxyFactory> pf = ExtensionLoader.getExtensionLoader(ProxyFactory.class);
		ProxyFactory pp = pf.getExtension("javassist");
		pf.replaceExtension("javassist", JavassistProxyFactoryEx.class);
		pp = pf.getExtension("javassist");
		pp = 	pf.getAdaptiveExtension();
	    log.debug("pp->" + pp.getClass());
	}

}

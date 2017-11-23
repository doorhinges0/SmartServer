package com.fuck.mobile.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.xnew.CloseEx;
/**
 * @category http请求连接池实现
 * @author MegaX
 *
 */
@Repository
public class HttpClientPoolsImp implements IHttpClientPools {

	private static PoolingHttpClientConnectionManager phcm = null;
	static Log log = LogFactory.getLog(HttpClientPoolsImp.class);
	/**
	 * @category 用于保存连接池
	 */
	static HashMap<String, ConnectionRequest> maps = new HashMap<String, ConnectionRequest>();
	static int excucount = 0;

	@Autowired
	CloseEx closeEx;
	
	/**
	 * @category 自动启动
	 */
	@PostConstruct
	void Init() {
		closeEx.addClose(this);
		excucount = 0;
		maps.clear();
//		log.debug("init  HttpClientPools");
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
//		log.debug("PoolingHttpClientConnectionManager MaxTotal :"
//				+ cm.getMaxTotal());
		cm.setMaxTotal(Integer.MAX_VALUE);
		cm.setDefaultMaxPerRoute(Integer.MAX_VALUE);
		phcm = cm;
	}
	
	void close2() {
		maps.clear();
		log.debug("Destory  HttpClientPools");
		if (phcm != null) {
			phcm.shutdown();
		}
	}
	
	private static PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {
		if (phcm == null) {
			log.debug("Not Start in Spring?");
			phcm = new PoolingHttpClientConnectionManager();
			phcm.setMaxTotal(1024);
			phcm.setDefaultMaxPerRoute(1024);
		}
		return phcm;
	}
	
	/**
	 * @category 关闭无用的连接，不要调用这个方法，系统会自动的调用
	 */
	@Scheduled(cron = "0/5 * *  * * ? ")
	// 每5秒执行一次
	@Override
	public void CloseIdleConnection() {
		try {
			//log.debug("CloseIdleConnection .....");
			PoolingHttpClientConnectionManager cm = getPoolingHttpClientConnectionManager();
			cm.closeExpiredConnections();
			cm.closeIdleConnections(15, TimeUnit.SECONDS);
		} catch (Exception ex) {
			log.error("CloseIdleConnection", ex);
		}
	}

	/**
	 *@category 执行http请求
	 * @param paramHttpUriRequest
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Override
	public HttpResponse execute(HttpUriRequest paramHttpUriRequest)
			throws ClientProtocolException, IOException {
		 CloseableHttpClient http = null;
		 paramHttpUriRequest.setHeader("Connection", "close");
		 
		 PoolingHttpClientConnectionManager cm = getPoolingHttpClientConnectionManager();
		
		 http = HttpClients.custom()
		 .setConnectionManager(cm)
		 .build();
		// HttpProtocolParams.setUseExpectContinue(http.getParams(),false);
		 return http.execute(paramHttpUriRequest);
	}

}

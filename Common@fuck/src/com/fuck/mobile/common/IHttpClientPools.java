package com.fuck.mobile.common;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
/**
 * @category http请求连接池，用于高效的请求http
 * @author MegaX
 *
 */
public interface IHttpClientPools {

	/**
	 * @category 关闭无用的连接，不要调用这个方法，系统会自动的调用
	 */
	void  CloseIdleConnection();
	
	/**
	 *@category 执行http请求
	 * @param paramHttpUriRequest
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HttpResponse execute(HttpUriRequest paramHttpUriRequest) throws ClientProtocolException, IOException;
}

package com.dtsjy.mdboss.common.hdfs.client;

import java.util.Date;

import org.apache.hadoop.security.authentication.client.AuthenticatedURL;
import org.apache.hadoop.security.authentication.client.AuthenticatedURL.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dtsjy.mdboss.common.hdfs.krb.HDFSKerberosAuthenticator;
import com.dtsjy.mdboss.common.hdfs.utils.TokenGenerator;

/**
 * HDFS 使用Kerberos安全机制客户端实现类, 继承HDFSClient
 *
 * @author cola
 * @version 2016年6月3日
 */
public class HDFSKerberosClientImpl extends HDFSClientImpl {

	private static final Logger logger = LoggerFactory.getLogger(HDFSKerberosClientImpl.class);

	private String principal = "hdfs/hadoop-mastre-1";
	private String password = "";

	public HDFSKerberosClientImpl(String httpfsUrl, String principal, String password) {
		super(httpfsUrl);
		this.httpfsUrl = httpfsUrl;
		this.principal = principal;
		this.password = password;
		this.authenticatedURL = new AuthenticatedURL(new HDFSKerberosAuthenticator(principal, password));
	}
	
	public HDFSKerberosClientImpl(String httpfsUrl, String principal, String password, Token token) {
		super(httpfsUrl, token);
		this.httpfsUrl = httpfsUrl;
		this.principal = principal;
		this.password = password;
		this.authenticatedURL = new AuthenticatedURL(new HDFSKerberosAuthenticator(principal, password));
	}

	/**
	 * 验证token,如果为空，或者失效，重新生成
	 * 
	 * @param token
	 * @return
	 */
	protected void ensureToken() {
		try {
			if (token == null || !token.isSet()) {
				token = TokenGenerator.generateToken(new String[]{httpfsUrl}, principal, password);
			} else {
				long currentTime = new Date().getTime();
				long tokenExpired = Long.parseLong(token.toString().split("&")[3].split("=")[1]);
				logger.info("[currentTime vs. tokenExpired] " + currentTime + " " + tokenExpired);
				// token 过期
				if (currentTime > tokenExpired) {
					token = TokenGenerator.generateToken(new String[]{httpfsUrl}, principal, password);
				}
			}
		} catch (Exception e) {
			logger.error("ensure token error : " + e.getMessage());
		}
	}

	/**
	 * 获取认证URL
	 */
	protected AuthenticatedURL getAuthenticatedURL() {
		if (authenticatedURL == null) {
			authenticatedURL = new AuthenticatedURL(new HDFSKerberosAuthenticator(principal, password));
		}
		return authenticatedURL;
	}

}

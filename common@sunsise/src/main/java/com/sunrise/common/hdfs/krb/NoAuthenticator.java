package com.sunrise.common.hdfs.krb;

import java.io.IOException;
import java.net.URL;

import org.apache.hadoop.security.authentication.client.AuthenticatedURL.Token;
import org.apache.hadoop.security.authentication.client.AuthenticationException;
import org.apache.hadoop.security.authentication.client.Authenticator;
import org.apache.hadoop.security.authentication.client.ConnectionConfigurator;

/**
 * 免认证，针对没有做安全机制的HDFS访问
 *
 * @author cola
 * @version 2016年6月3日
 */
public class NoAuthenticator implements Authenticator {
	
	public NoAuthenticator() {
		
	}

	@Override
	public void setConnectionConfigurator(ConnectionConfigurator configurator) {

	}

	@Override
	public void authenticate(URL url, Token token) throws IOException, AuthenticationException {	
		//不进行认证
		return ;
	}

}

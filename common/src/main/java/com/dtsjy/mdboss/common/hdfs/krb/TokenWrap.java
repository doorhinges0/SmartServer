package com.dtsjy.mdboss.common.hdfs.krb;

import java.io.Serializable;

/**
 * Token 包装器，客户端除了要获取token外，
 * 还需要获取处于Active状态的NameNode节点地址和端口
 * 
 * @author cola
 * @version 2016年6月3日
 */
public class TokenWrap implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3839987679509335404L;
	
	/**
	 * Kerberos Token
	 */
	private String token = "";
	
	/**
	 * 处于Active状态的namenode（IP或hostname,与Kerberos中realms配置一致）
	 */
	private String activeHost;
	
	/**
	 * 获取Token的端口号
	 */
	private String port;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getActiveHost() {
		return activeHost;
	}
	public void setActiveHost(String activeHost) {
		this.activeHost = activeHost;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	public static TokenWrap newinstance(String token, String hostname, String port) {
		TokenWrap tokenWrap = new TokenWrap();
		tokenWrap.setToken(token);
		tokenWrap.setActiveHost(hostname);
		tokenWrap.setPort(port);
		return tokenWrap;
	}
	
}

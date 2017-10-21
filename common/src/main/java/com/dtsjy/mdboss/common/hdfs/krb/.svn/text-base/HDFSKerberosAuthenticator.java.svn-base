package com.dtsjy.mdboss.common.hdfs.krb;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.apache.commons.codec.binary.Base64;
import org.apache.hadoop.security.authentication.client.AuthenticatedURL;
import org.apache.hadoop.security.authentication.client.AuthenticatedURL.Token;
import org.apache.hadoop.security.authentication.client.AuthenticationException;
import org.apache.hadoop.security.authentication.client.Authenticator;
import org.apache.hadoop.security.authentication.client.ConnectionConfigurator;
import org.apache.hadoop.security.authentication.client.PseudoAuthenticator;
import org.apache.hadoop.security.authentication.util.KerberosUtil;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.Oid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义HDFS Kerberos 认证,实现Authenticator 接口
 *
 * @author cola
 * @version 2016年6月2日
 */
public class HDFSKerberosAuthenticator implements Authenticator {
	private static final Logger logger = LoggerFactory.getLogger(HDFSKerberosAuthenticator.class);

	public static final String USER_NAME = "user.name";

	/**
	 * 使用negotiate方式，第一次发送OPTIONS请求，返回401，再次发送请求进行验证
	 */
	public static final String NEGOTIATE = "Negotiate";

	private static final String AUTH_HTTP_METHOD = "OPTIONS";
	public static final String AUTHORIZATION = "Authorization";
	public static final String WWW_AUTHENTICATE = "WWW-Authenticate";

	private boolean isDebug = true;
	private URL url;
	private HttpURLConnection conn;
	private Base64 base64;

	private String username;
	private String password;
	private ConnectionConfigurator connConfigurator;

	public HDFSKerberosAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public void setConnectionConfigurator(ConnectionConfigurator configurator) {
		connConfigurator = configurator;
	}

	@Override
	public void authenticate(URL url, Token token) throws IOException, AuthenticationException {
		if (!token.isSet()) {
			logger.debug("Begin authentication...");
			this.url = url;
			base64 = new Base64(0);

			conn = (HttpURLConnection) url.openConnection();
			if (connConfigurator != null) {
				conn = connConfigurator.configure(conn);
			}
			conn.setRequestMethod(AUTH_HTTP_METHOD);
			conn.connect();

			if (isNegotiate()) {
				logger.debug("Negatiate Module, Send ");
				authenticWithSPNEGO(token);
			} else {
				Authenticator auth = getFallBackAuthenticator();
				
				auth.setConnectionConfigurator(connConfigurator);
				auth.authenticate(url, token);
			}

		}

	}

	protected Authenticator getFallBackAuthenticator() {
		Authenticator auth = new PseudoAuthenticator();
		if (connConfigurator != null) {
			auth.setConnectionConfigurator(connConfigurator);
		}
		return auth;
	}

	protected String getUserName() {
		return username != null ? username : System.getProperty("user.name");
	}

	/**
	 * 判断是否是Negotiation第一次发送的请求，返回码是401
	 * 
	 * @return
	 * @throws IOException
	 */
	private boolean isNegotiate() throws IOException {
		boolean negotiate = false;
		// 返回 401 UNAUTHORIZED
		if (conn.getResponseCode() == HttpURLConnection.HTTP_UNAUTHORIZED) {
			String authHeader = conn.getHeaderField(WWW_AUTHENTICATE);
			negotiate = authHeader != null && authHeader.trim().startsWith(NEGOTIATE);
		}
		return negotiate;
	}

	/**
	 * 采用SPNEGO协议进行验证, SPNEGO是一种使用GSS-API(通用安全服务应用接口)认证机制的安全协议, 拓展了Kerberos
	 * 
	 * @param token
	 * @throws IOException
	 * @throws AuthenticationException
	 * @throws LoginException
	 */
	private void authenticWithSPNEGO(Token token) throws IOException, AuthenticationException {
		try {
			LoginContext loginContext = new LoginContext("", null,
					new KerberosAuthenticCallbackHandler(username, password), new LoginConfiguration(this.isDebug));

			logger.debug("Begin Login ....");
			loginContext.login();
			Subject subject = loginContext.getSubject();

			// 获取认证Token
			Subject.doAs(subject, new PrivilegedExceptionAction<Void>() {

				@Override
				public Void run() throws Exception {
					GSSContext gssContext = null;
					try {
						GSSManager gssManager = GSSManager.getInstance();
						String servicePrincipal = "HTTP/" + HDFSKerberosAuthenticator.this.url.getHost();
						Oid oid = KerberosUtil.getOidInstance("NT_GSS_KRB5_PRINCIPAL");
						GSSName serviceName = gssManager.createName(servicePrincipal, oid);

						oid = KerberosUtil.getOidInstance("GSS_KRB5_MECH_OID");
						gssContext = gssManager.createContext(serviceName, oid, null, GSSContext.DEFAULT_LIFETIME);
						gssContext.requestCredDeleg(true);
						gssContext.requestMutualAuth(true);

						byte[] inToken = new byte[0];
						byte[] outToken;
						boolean established = false;

						// 安全令牌的交换会一直进行下去，直到一边决定认证失败或两边都认为认证成功
						while (!established) {
							// 客户端部分的认证协议建立一个安全令牌
							outToken = gssContext.initSecContext(inToken, 0, inToken.length);
							if (outToken != null) {
								// 发送安全令牌到服务端
								sendToken(outToken);
							}

							if (!gssContext.isEstablished()) {
								inToken = readToken();
							} else {
								established = true;
							}
						}
					} finally {
						if (gssContext != null) {
							gssContext.dispose();
							gssContext = null;
						}
					}
					return null;
				}
			});
		} catch (LoginException ex) {
			logger.error("LoginException message : " + ex);
			throw new AuthenticationException("Authentication Failed : ", ex);
		} catch (PrivilegedActionException ex) {
			logger.error("PrivilegedActionException message : " + ex);
			throw new AuthenticationException("Authentication Failed : ", ex);
		}
		// 解析请求，构造token
		AuthenticatedURL.extractToken(conn, token);
	}

	/**
	 * 发送Token到服务端
	 * 
	 * @param outToken
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	private void sendToken(byte[] outToken) throws IOException, AuthenticationException {
		String token = base64.encodeToString(outToken);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(AUTH_HTTP_METHOD);
		conn.setRequestProperty(AUTHORIZATION, NEGOTIATE + " " + token);
		conn.connect();
	}

	/**
	 * 接收KDC返回的token
	 * 
	 * @return
	 * @throws IOException
	 * @throws AuthenticationException
	 */
	private byte[] readToken() throws IOException, AuthenticationException {
		int status = conn.getResponseCode();
		if (status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_UNAUTHORIZED) {
			String authHeader = conn.getHeaderField(WWW_AUTHENTICATE);
			if (authHeader == null || !authHeader.trim().startsWith(NEGOTIATE)) {
				throw new AuthenticationException(
						"Invalid SPNEGO sequence, '" + WWW_AUTHENTICATE + "' header incorrect: " + authHeader);
			}
			String negotiation = authHeader.trim().substring((NEGOTIATE + " ").length()).trim();
			return base64.decode(negotiation);
		}
		throw new AuthenticationException("Invalid SPNEGO sequence, status code: " + status);
	}

}

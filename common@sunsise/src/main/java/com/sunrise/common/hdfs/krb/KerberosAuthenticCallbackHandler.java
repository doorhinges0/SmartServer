package com.sunrise.common.hdfs.krb;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * 实现CallbackHandler 接口，在安全验证中可以回调该函数，
 * 传递自定义数据（如：用户名，密码）到安全验证服务中
 *
 * @author cola
 * @version 2016年6月2日
 */
public class KerberosAuthenticCallbackHandler implements CallbackHandler{
	
	private String username;
	private String password;
	
	public KerberosAuthenticCallbackHandler(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (Callback callback : callbacks) {
			if (callback instanceof NameCallback) {
				NameCallback nameCallback = (NameCallback) callback;
				nameCallback.setName(this.username);
			} else if (callback instanceof PasswordCallback) {
				PasswordCallback pwdCallback = (PasswordCallback) callback;
				pwdCallback.setPassword(this.password.toCharArray());
			} else {
				throw new UnsupportedCallbackException(callback, "Support NameCallback and PasswordCallback");
			}
		}
	}

}

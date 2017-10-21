package com.dtsjy.mdboss.common.hdfs.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

import org.apache.hadoop.security.authentication.client.AuthenticatedURL;
import org.apache.hadoop.security.authentication.client.AuthenticatedURL.Token;
import org.apache.hadoop.security.authentication.client.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.dtsjy.mdboss.common.hdfs.krb.NoAuthenticator;
import com.dtsjy.mdboss.common.hdfs.utils.URLUtil;

/**
 * HDFS JAVA 客户端，不需要进行授权
 *
 * @author cola
 * @version 2016年6月1日
 */
public class HDFSClientImpl implements HDFSClient {

	private static final Logger logger = LoggerFactory.getLogger(HDFSKerberosClientImpl.class);

	protected String httpfsUrl = "http://localhost:50070";
	protected Token token = new AuthenticatedURL.Token();
	protected AuthenticatedURL authenticatedURL = null;

	public HDFSClientImpl(String httpfsUrl) {
		this.httpfsUrl = httpfsUrl;
	}
	
	public HDFSClientImpl(String httpfsUrl, Token token) {
		this.httpfsUrl = httpfsUrl;
		this.token = token;
	}

	@Override
	public String getHomeDirectory() throws MalformedURLException, IOException, AuthenticationException {
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL()
				.openConnection(new URL(new URL(httpfsUrl), "/webhdfs/v1/?op=GETHOMEDIRECTORY"), token);
		conn.connect();

		String resp = parseResult(conn, true);
		conn.disconnect();
		return resp;
	}

	@Override
	public String create(String path, InputStream is)
			throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();

		String redirectUrl = null;
		HttpURLConnection conn = getAuthenticatedURL().openConnection(new URL(new URL(httpfsUrl),
				MessageFormat.format("/webhdfs/v1/{0}?op=CREATE", URLUtil.encodePath(path))), token);
		conn.setRequestMethod("PUT");
		conn.setInstanceFollowRedirects(false);
		conn.connect();
		logger.info("Location:" + conn.getHeaderField("Location"));
		resp = parseResult(conn, true);
		if (conn.getResponseCode() == 307)
			redirectUrl = conn.getHeaderField("Location");
		conn.disconnect();

		if (redirectUrl != null) {
			conn = getAuthenticatedURL().openConnection(new URL(redirectUrl), token);
			conn.setRequestMethod("PUT");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type", "application/octet-stream");
			// conn.setRequestProperty("Transfer-Encoding", "chunked");
			final int _SIZE = is.available();
			conn.setRequestProperty("Content-Length", "" + _SIZE);
			conn.setFixedLengthStreamingMode(_SIZE);
			conn.connect();
			OutputStream os = conn.getOutputStream();
			copy(is, os);
			// Util.copyStream(is, os);
			is.close();
			os.close();
			resp = parseResult(conn, false);
			conn.disconnect();
		}

		return resp;
	}

	@Override
	public String mkdirs(String path) throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(new URL(new URL(httpfsUrl),
				MessageFormat.format("/webhdfs/v1/{0}?op=MKDIRS", URLUtil.encodePath(path))), token);
		conn.setRequestMethod("PUT");
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String delete(String path) throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(new URL(new URL(httpfsUrl),
				MessageFormat.format("/webhdfs/v1/{0}?op=DELETE", URLUtil.encodePath(path))), token);
		conn.setRequestMethod("DELETE");
		conn.setInstanceFollowRedirects(false);
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String getFileStatus(String path) throws MalformedURLException, IOException, AuthenticationException {
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(new URL(new URL(httpfsUrl),
				MessageFormat.format("/webhdfs/v1/{0}?op=GETFILESTATUS", URLUtil.encodePath(path))), token);
		conn.setRequestMethod("GET");
		conn.connect();
		String resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String rename(String srcPath, String destPath)
			throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(
				new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=RENAME&destination={1}",
						URLUtil.encodePath(srcPath), URLUtil.encodePath(destPath))),
				token);
		conn.setRequestMethod("PUT");
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String listStatus(String path) throws MalformedURLException, IOException, AuthenticationException {
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(new URL(new URL(httpfsUrl),
				MessageFormat.format("/webhdfs/v1/{0}?op=LISTSTATUS", URLUtil.encodePath(path))), token);
		conn.setRequestMethod("GET");
		conn.connect();
		String resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String open(String path, OutputStream os)
			throws MalformedURLException, IOException, AuthenticationException {
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(
				new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=OPEN", URLUtil.encodePath(path))),
				token);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/octet-stream");
		conn.connect();
		InputStream is = conn.getInputStream();
		copy(is, os);
		is.close();
		os.close();
		String resp = parseResult(conn, false);
		conn.disconnect();

		return resp;
	}

	@Override
	public String append(String path, InputStream is)
			throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();
		
		String redirectUrl = null;
		HttpURLConnection conn = getAuthenticatedURL().openConnection(new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=APPEND", path)), token);
		conn.setRequestMethod("POST");
		conn.setInstanceFollowRedirects(false);
		conn.connect();
		resp = parseResult(conn, true);
		if (conn.getResponseCode() == 307) {
			//获取namenode返回的重定向地址
			redirectUrl = conn.getHeaderField("Location");
		}
		conn.disconnect();
		
		if (redirectUrl != null) {
			conn = getAuthenticatedURL().openConnection(new URL(redirectUrl), token);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			//写入文件
			conn.setRequestProperty("Content-Type", "application/octet-stream");
			final int _SIZE = is.available();
			conn.setRequestProperty("Content-Length", "" + _SIZE);
			conn.setFixedLengthStreamingMode(_SIZE);
			conn.connect();
			OutputStream os = conn.getOutputStream();
			copy(is, os);
			is.close();
			os.close();
			resp = parseResult(conn, true);
			conn.disconnect();
		}

		return resp;
	}

	@Override
	public String createSymLink(String srcPath, String destPath)
			throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();
		
		HttpURLConnection conn = getAuthenticatedURL().openConnection(new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=CREATESYMLINK&destination={1}",
				URLUtil.encodePath(srcPath), URLUtil.encodePath(destPath))), token);
		conn.setRequestMethod("PUT");
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();
		return resp;
	}

	@Override
	public String getContentSummary(String path) throws MalformedURLException, IOException, AuthenticationException {
		ensureToken();
		HttpURLConnection conn = getAuthenticatedURL().openConnection(
				new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=GETCONTENTSUMMARY",
						URLUtil.encodePath(path))), token);
		conn.setRequestMethod("GET");
		conn.connect();
		String resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String getFileCheckSum(String path) throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		HttpURLConnection conn = getAuthenticatedURL().openConnection(
				new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=GETFILECHECKSUM",
						URLUtil.encodePath(path))), token);

		conn.setRequestMethod("GET");
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();
		return resp;
	}

	@Override
	public String setOwner(String path) throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(
				new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=SETOWNER",
						URLUtil.encodePath(path))), token);
		conn.setRequestMethod("PUT");
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String setPermission(String path) throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(
				new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=SETPERMISSION",
						URLUtil.encodePath(path))), token);
		conn.setRequestMethod("PUT");
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String setReplication(String path) throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(
				new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=SETREPLICATION",
						URLUtil.encodePath(path))), token);
		conn.setRequestMethod("PUT");
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}

	@Override
	public String setTimes(String path) throws MalformedURLException, IOException, AuthenticationException {
		String resp = null;
		ensureToken();

		HttpURLConnection conn = getAuthenticatedURL().openConnection(
				new URL(new URL(httpfsUrl), MessageFormat.format("/webhdfs/v1/{0}?op=SETTIMES",
						URLUtil.encodePath(path))), token);
		conn.setRequestMethod("PUT");
		conn.connect();
		resp = parseResult(conn, true);
		conn.disconnect();

		return resp;
	}
	
	/**
	 * 提供接口后续拓展 验证token,如果为空，或者失效，重新生成
	 * 
	 * @param token
	 * @return
	 */
	protected void ensureToken() {
		return;
	}

	/**
	 * 获取验证URL
	 */
	protected AuthenticatedURL getAuthenticatedURL() {
		if (authenticatedURL == null) {
			authenticatedURL = new AuthenticatedURL(new NoAuthenticator());
		}
		return authenticatedURL;
	}

	/**
	 * 解析请求结果
	 * 
	 * @param conn
	 * @param input
	 * @return
	 * @throws IOException
	 */
	protected static String parseResult(HttpURLConnection conn, boolean input) throws IOException {
		StringBuffer sb = new StringBuffer();
		if (input) {
			InputStream is = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			is.close();
		}
		
		JSONObject json = new JSONObject();
		json.put("code", conn.getResponseCode());
		json.put("msg", conn.getResponseMessage());
		json.put("type", conn.getContentType());
		json.put("data", sb);

		return JSONObject.toJSONString(json);
	}

	/**
	 * 复制流
	 * 
	 * @param input
	 * @param result
	 * @return
	 * @throws IOException
	 */
	protected static long copy(InputStream input, OutputStream result) throws IOException {
		byte[] buffer = new byte[12288];
		long count = 0L;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			result.write(buffer, 0, n);
			count += n;
			result.flush();
		}
		result.flush();
		return count;
	}

}

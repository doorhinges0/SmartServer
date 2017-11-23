package com.sunrise.common.hdfs.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sunrise.common.hdfs.krb.TokenWrap;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.security.authentication.client.AuthenticatedURL.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hdfs Kerberos Token生成类
 *
 * @author cola
 * @version 2016年6月1日
 */
public class TokenGenerator {

	private static final Logger logger = LoggerFactory.getLogger(TokenGenerator.class);

	/**
	 * Token 生成器
	 * @param srvUrl 所有NameNode节点的URL
	 * @param principal Kerberos用户 如 hdfs/hadoop-master-1
	 * @param password Kerberos用户对应的密码
	 * @return token包装器
	 */
	public static TokenWrap generateTokenWrap(String[] srvUrl, String principal, String password) {
		TokenWrap tokenWrap = new TokenWrap();
		try {
			if (srvUrl != null && srvUrl.length > 0) {
				for (String url : srvUrl) {
					tokenWrap = generateTokenWrap(url, principal, password);
					if (StringUtils.isNotBlank(tokenWrap.getToken())) {
						break;
					}
				}
				
				if(StringUtils.isEmpty(tokenWrap.getToken())) {
					//刷新Ticket,针对Ticket过期无法生成
					runKinitCommand(principal);
					for (String url : srvUrl) {
						tokenWrap = generateTokenWrap(url, principal, password);
						
						if (StringUtils.isNotBlank(tokenWrap.getToken())) {
							break;
						}
					}
				}
			}
		} catch (Exception e) {
		
			logger.error("Failed to generate Token with : [princal: " + principal + ", password:"
					+ password + "]");
		}
		
		return tokenWrap;
	}
	
	/**
	 * 直接通过curl命令请求获取Token
	 * @param url
	 * @param principal
	 * @param password
	 * @return
	 */
	public static TokenWrap generateTokenWrap(String url, String principal, String password) {
		TokenWrap tokenWrap = new TokenWrap();
		
        String shellString = "curl -i --negotiate -u " + principal + ":" + password + " " + url + "/webhdfs/v1/?op=LISTSTATUS";
		
        List<String> processList = new ArrayList<String>();
        try {
      	   logger.error("Getting Token ... ");

            Process process = Runtime.getRuntime().exec(shellString);
            BufferedReader read = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = read.readLine()) != null) {
                processList.add(line);
            }
            read.close();

        } catch (Throwable e) {
        	logger.error("Generate token by curl failed..." , e);
            return tokenWrap;
        }

        /**
         * 这里通过正则找到hadoop-auth
         *
         */
        String hadoopAuth = null;
        boolean isHadoopAuth = false;
        for (String line : processList) {

            if (line.matches(".*(HTTP/1.1 200 OK).*")) {
                isHadoopAuth = true;
            }

            if (isHadoopAuth && line.matches(".*(Set-Cookie:).*")) {
                String string = line.replace("Set-Cookie:", "");

                Pattern p = Pattern.compile("\"(.*)\"");
                Matcher m = p.matcher(string);
                if (m.find()) {
                    hadoopAuth = m.group(1);
                }
                break;
            }
        }

        if (isHadoopAuth) {
        	//获取Token
           String host = url;
           String port = "50070";
           try {
        	   URL httpUrl = new URL(url);
        	   host = httpUrl.getHost();
        	   port = httpUrl.getPort() + "";
           } catch (Exception e){
        	   logger.error("Get Hostname and port from url occured error!", e);
           }
           return TokenWrap.newinstance(hadoopAuth, host, port);
           
        } else {
     	   logger.error("Token is null... ");
     	   return tokenWrap;
        }
	}
	
	/**
	 * Token 生成器
	 * @param srvUrl
	 * @param principal
	 * @param password
	 * @return 返回Token
	 */
	public static Token generateToken(String[] srvUrl, String principal, String password) {
		String tokenStr = generateTokenWrap(srvUrl, principal, password).getToken();
		return new Token(tokenStr);
	}

	
	/**
	 * 针对Token过期无法生成的问题，需要重新运行Kinit命令
	 * 
	 * @param princ
	 *            Kerberos 用户
	 * @return
	 */
	public static boolean runKinitCommand(String princ) {
		String cmd = "kinit -kt /usr/local/hadoop/hadoop.keytab " + princ;
		try {
			logger.debug("Exec Command " + cmd);
			Runtime.getRuntime().exec(cmd);
			/*Process ps = Runtime.getRuntime().exec(cmd);
			LineNumberReader br = new LineNumberReader(new InputStreamReader(ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			logger.debug("Exec kinit output: " + sb.toString());*/
			return true;
		} catch (Exception e) {
			logger.error("Exec command kinit failed " + e);
		}
		return false;
	}
}

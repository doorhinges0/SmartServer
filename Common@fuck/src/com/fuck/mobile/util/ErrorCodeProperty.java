package com.fuck.mobile.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.fuck.mobile.spring.dubbo.SpringConfigurerEx;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.apache.commons.lang3.StringUtils;

import com.fuck.mobile.base.constant.Constants;

public class ErrorCodeProperty {

	// 单例模式
	private static ErrorCodeProperty property = null;

	private Map<String, String> propertyMap = null;
		
	/**
	 * @function 获取该类实例对象
	 * @return
	 */
	public static ErrorCodeProperty getInstance() {
		if (property == null) {
			property = new ErrorCodeProperty();
		}
		return property;
	}

	/**
	 * 返回String
	 * 
	 * @param key
	 * @return
	 * @author 
	 */
	public String getValue(Object key) {
		if(propertyMap==null){
			return "";
		}
		String tempStr = property.getMap().get(key.toString());
		if (tempStr == null && key instanceof Integer) {
			tempStr = property.getMap().get(
					"0x" + Integer.toHexString((Integer) key));
		}
		return tempStr == null ? "" : tempStr;
	}

	/**
	 * 返回Map
	 * 
	 * @return
	 * @author 
	 */
	public Map<String, String> getMap() {
		return propertyMap;
	}

	/**
	 * 构造方法
	 * 
	 * @author 
	 */
	private ErrorCodeProperty() {
		
		InputStream inStream = null;
		
		String zooKeeperUrl = com.fuck.mobile.spring.SpringConfigurerEx.zooKeeperUrl;
		String zooKeeperRootPath = com.fuck.mobile.spring.SpringConfigurerEx.zooKeeperRootPath;
		String appName = com.fuck.mobile.spring.SpringConfigurerEx.AppName;
		
		if(zooKeeperUrl==null){
			zooKeeperUrl= SpringConfigurerEx.zooKeeperUrl;
		}
		if(zooKeeperRootPath==null){
			zooKeeperRootPath= SpringConfigurerEx.zooKeeperRootPath;
		}
		if(appName==null){
			appName= SpringConfigurerEx.AppName;
		}
		
		if(StringUtils.isNotEmpty(zooKeeperUrl))
		{
			ZkClient client = new ZkClient(zooKeeperUrl);
			client.setZkSerializer(new BytesPushThroughSerializer());
			String path = null;
			String commonPath=null;
			String rootPath = zooKeeperRootPath;
			String key = Constants.YunWei+"/ErrorCode";
			if("/".equals(rootPath)){
				path = rootPath + appName + "/" + key;
				commonPath = rootPath + "Common" + "/" + key;
			}else{
				path = rootPath + "/" + appName +"/"+ key;
				commonPath = rootPath + "/" + "Common" +"/"+ key;
			}
			
			byte[] b = null;
			if(client.exists(path)){
				b = client.readData(path);
			}else {
				if(client.exists(commonPath)){
					b = client.readData(commonPath);
				}
			}
			if(b!=null){
				inStream = new ByteArrayInputStream(b); 
			}
			if(inStream!=null){
				Properties pro = null;
				try {
					pro = new Properties();
					
					BufferedReader bf = new BufferedReader(new    InputStreamReader(inStream));  
					pro.load(bf);
					propertyMap = new HashMap<String, String>();
					Enumeration<?> enumer = pro.keys();
					while (enumer.hasMoreElements()) {
						String keyName = (String) enumer.nextElement();
						propertyMap.put(keyName, pro.getProperty(keyName));
					}
				} catch (Exception e) {
//				new Throwable(e);
				} finally {
					if (inStream != null) {
						try {
							inStream.close();
						} catch (IOException e) {
//						new Throwable(e);
						}
					}
				}
				
				client.subscribeDataChanges(path, new IZkDataListener() {
					
					@Override
					public void handleDataDeleted(String arg0) throws Exception {
						property = null;
						propertyMap = null;
					}
					
					@Override
					public void handleDataChange(String arg0, Object arg1) throws Exception {
						property = null;
						propertyMap = null;
					}
				});
			}
		
			}
			
	}

	/**
	 * 是否能够继续下一步
	 * 
	 * @param retCode
	 * @return
	 * @author 
	 */
	public static boolean goNext(int retCode) {
		if (retCode == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
//		SpringConfigurerEx.zooKeeperUrl ="192.168.0.204:2181";
//		SpringConfigurerEx.zooKeeperRootPath ="/AppConfig/ZYXR";
//		SpringConfigurerEx.AppName ="Test";
		
		
//		ZkClient client = new ZkClient("192.168.0.204:2181");
//		client.setZkSerializer(new BytesPushThroughSerializer());
//		byte[] b = client.readData("/AppConfig/ZYXR/Common/MongoDb/connectTimeout");
//		String str = new String(b);
//		System.out.println(str);
		try {
			System.out.println(getInstance().getValue(101));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


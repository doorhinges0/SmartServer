package com.fuck.mobile.common;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import com.fuck.mobile.common.zkclient.IZkClientService;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ZooKeeperConfigImp implements IZooKeeperConfig {

	static Charset CharsetUTF8 = Charset.forName("utf-8");
	static Log log = LogFactory.getLog(ZooKeeperConfigImp.class);
	private IZkClientService zooKeeper;
	private String rootPath;// ${rootPath}/${appName}/${key}
	private String appName;
	private String commonName = "Common";// 取不到值取Common
											// ${rootPath}/${commonName}/${key}

	public ZooKeeperConfigImp(IZkClientService zkClientService, String path, String appName) {
		this.zooKeeper = zkClientService;
		this.rootPath = path;
		this.appName = appName;
	}

	private ZkClient getZkClient() {
		ZkClient client = zooKeeper.getZkClient();
		return client;
	}

	private String getPath(String key, String appName) {
		if (key != null) {
			if ("/".equals(key)) {
				return rootPath + "/" + appName;
			}
			if (key.startsWith("/")) {
				key = key.substring(1);
			}
			if (key.endsWith("/")) {
				key = key.substring(0, key.length() - 1);
			}
		}

		String path = null;
		if ("/".equals(rootPath)) {
			path = rootPath + appName + "/" + key;
		} else {
			path = rootPath + "/" + appName + "/" + key;
		}
		return path;
	}

	@Override
	public String get(String key) {
		ZkClient client = getZkClient();
		String path = getPath(key, appName);
		byte[] b = null;
		if (client.exists(path)) {
			b = client.readData(path);
			if (b == null) {
				path = getPath(key, commonName);
				log.debug("get common path->" + path);
				b = client.readData(path);
			}
		} else {
			path = getPath(key, commonName);
			log.debug("get common path->" + path);
			b = client.readData(path);
		}
		if (b != null) {
			return new String(b, CharsetUTF8);
		}
		return null;
	}

	@Override
	public boolean exist(String key) {
		ZkClient client = getZkClient();
		String path = getPath(key, appName);
		boolean f = client.exists(path);
		return f;
	}

	@Override
	public void set(String key, String data) {
		ZkClient client = getZkClient();
		String path = getPath(key, appName);
		boolean flag = client.exists(path);
		if (flag) {
			client.writeData(path, data.getBytes(CharsetUTF8));
		} else {
			client.createPersistent(path, true);
			client.writeData(path, data.getBytes(CharsetUTF8));
		}
	}

	@Override
	public boolean delete(String key) {
		boolean flag = false;
		ZkClient client = getZkClient();
		String path = getPath(key, appName);
		List<String> nodes = client.getChildren(path);
		if (null != nodes && nodes.size() > 0) {
			// 有子节点不删除
		} else {
			if (client.exists(path)) {
				flag = client.delete(path);
			}
		}
		return flag;
	}

	@Override
	public boolean deleteCascade(String key) {
		boolean flag = false;
		ZkClient client = getZkClient();
		List<String> nodes = client.getChildren(key);
		if (null != nodes && nodes.size() > 0) {
			for (String nodeName : nodes) {
				if ("/".equals(key)) {
					deleteCascade(key + nodeName);
				} else {
					deleteCascade(key + "/" + nodeName);
				}
			}
		}
		if (client.exists(key)) {
			flag = client.delete(key);
		}
		return flag;
	}

	@Override
	public void createDir(String key) {
		ZkClient client = getZkClient();
		String path = getPath(key, appName);
		boolean f = client.exists(path);
		if (!f) {
			client.createPersistent(path, true);
		}
	}

	@Override
	public List<String> listAllKeys() {

		ZkClient client = getZkClient();
		List<String> nodeList = new ArrayList<String>();
		getChildren(client, rootPath, nodeList);
		return nodeList;
	}

	@Override
	public IZooKeeperConfig openDir(String key) {
		String path = getPath(key, appName);
		IZooKeeperConfig config = new ZooKeeperConfigImp(zooKeeper, path, "");
		return config;
	}

	@Override
	public boolean isRoot() {

		if ("/".equals(rootPath)) {
			return true;
		}
		return false;
	}

	private void getChildren(ZkClient client, String path, List<String> nodeList) {
		List<String> list = client.getChildren(path);
		if (list != null && !list.isEmpty()) {
			if (nodeList == null) {
				nodeList = new ArrayList<String>();
			}
			for (String s : list) {
				String pp = "";
				if ("/".equals(path)) {
					pp = path + s;
				} else {
					pp = path + "/" + s;
				}
				nodeList.add(pp);

				if (pp.startsWith("/")) {
					getChildren(client, pp, nodeList);
				} else {
					getChildren(client, "/" + pp, nodeList);
				}
			}
		}
	}

	private static class IZkDataListenerEx<T> implements IZkDataListener {
		T defaultValue;
		T lastValue;
		IConfigValueChange<T> f;
		String key;

		IZkDataListenerEx(String key, T defaultValue, IConfigValueChange<T> f) {
			this.defaultValue = defaultValue;
			lastValue = defaultValue;
			this.key = key;
			this.f = f;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleDataChange(String dataPath, Object data) throws Exception {
			if (data == null)
				return;
			Object argObj = null;
			if (data instanceof String) {
				argObj = (String) data;
			} else if (data instanceof byte[]) {
				argObj = new String((byte[]) data, "utf-8");
			} else {
				argObj = data;
			}
			log.debug("handleDataChange arg0->" + data + " ,arg1-> " + argObj);

			T o = null;
			if (defaultValue instanceof Byte) {
				o = (T) (Byte.valueOf(String.valueOf(argObj)));
			} else if (defaultValue instanceof Boolean) {
				boolean bol = "1".equals(String.valueOf(argObj)) || "true".equalsIgnoreCase(String.valueOf(argObj));
				o = (T) (Boolean.valueOf(bol));
			} else if (defaultValue instanceof Short) {
				o = (T) (Short.valueOf(String.valueOf(argObj)));
			} else if (defaultValue instanceof Integer) {
				o = (T) (Integer.valueOf(String.valueOf(argObj)));
			} else if (defaultValue instanceof Long) {
				o = (T) (Long.valueOf(String.valueOf(argObj)));
			} else if (defaultValue instanceof Float) {
				o = (T) (Float.valueOf(String.valueOf(argObj)));
			} else if (defaultValue instanceof Double) {
				o = (T) (Double.valueOf(String.valueOf(argObj)));
			} else if (defaultValue instanceof BigInteger) {
				o = (T) (new BigInteger(String.valueOf(argObj)));
			} else if (defaultValue instanceof BigDecimal) {
				o = (T) (new BigDecimal(String.valueOf(argObj)));
			} else {
				o = (T) argObj;
			}
			try
			{
				f.onChange(key, lastValue, o);
			}catch(Throwable t)
			{
				log.error("",t);
			}
			lastValue = o;
		}

		@Override
		public void handleDataDeleted(String dataPath) throws Exception {
			f.onChange(key, lastValue, defaultValue);
			lastValue = defaultValue;
		}

	}

	@Override
	public <T> void dataChanges(String key, IConfigValueChange<T> field, T defaultValue) {
		ZkClient client = getZkClient();
		String path = getPath(key, appName);
		log.debug("dataChanges path -> " + path);
		if (!client.exists(path)) {
			path = getCommonPath(key);
			log.debug("dataChanges common path -> " + path);
			if (!client.exists(path)) {
				log.debug("dataChanges not exist path -> " + key);
				return;
			}
		}
		client.subscribeDataChanges(path, new IZkDataListenerEx<T>(key, defaultValue, field));
	}

	@Override
	public <T> void dataChanges(String key, final AtomicReference<T> field, final T defaultValue) {
		dataChanges(key, new IConfigValueChange<T>() {
			@Override
			public void onChange(String key, T oldval, T newval) {
				field.set(newval);
			}
		}, defaultValue);

	}

	@Override
	public String getPath(String key) {
		return getPath(key, appName);
	}

	@Override
	public String getCommonPath(String key) {
		return getPath(key, commonName);
	}
		
}

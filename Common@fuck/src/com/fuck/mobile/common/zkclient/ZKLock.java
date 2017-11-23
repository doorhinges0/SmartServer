package com.fuck.mobile.common.zkclient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import com.fuck.mobile.util.SHA1Util;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;

public final class ZKLock {

	public final static String LockPrex = "ZYXR_ZKLock";
	private static Hashtable<String, Object> lockobj = new Hashtable<>();
	private static org.apache.commons.logging.Log log = LogFactory.getLog(ZKLock.class);

	private static class ZKLockImp implements IZKLock {
		private ZkClient client;
		private String name;
		private Object lock = null;
		private String nodeName;
		private long index = -1;


		public ZKLockImp(ZkClient client, String lname) {
			this.client = client;
			this.name = SHA1Util.getSHA1String(lname);
			try {
				client.createPersistent("/" + LockPrex);
			} catch (Exception e) {
			}

			synchronized (lockobj) {
				if (lockobj.contains(this.name)) {
					lock = lockobj.get(this.name);
				} else {
					lock = new Object();
					lockobj.put(this.name, lock);
				}
			}
			client.subscribeChildChanges("/" + LockPrex, (parentPath, currentChilds) -> {
				List<Long> ll = new ArrayList<>();
				for(String c : currentChilds)
				{
					if(c.startsWith(this.name))
					{
						ll.add(Long.parseLong(c.substring(40)));
					}
				}
				Collections.sort(ll);
				if(ll.size() > 0 && ll.get(0) == index)
				{
					synchronized(lock)
					{
						try
						{
							lock.notify();
						}catch(Exception e){}
					}
				}

			});

		}

		@Override
		public synchronized void lock() {
			if(StringUtils.isNoneEmpty(nodeName))
			{
				throw new RuntimeException("lock has locked");
			}
			String ret = client.createEphemeralSequential("/" + LockPrex + "/" + name, null);
			nodeName = ret;
			int ss = ret.lastIndexOf("/");
			String sss = ret.substring(ss + 1 + 40);
			index = Long.parseLong(sss);

			while (true) {
				try {
					List<String> list = client.getChildren("/" + LockPrex);
					List<Long> l = sortL(list);
					if (l.get(0) != index) {
						synchronized(lock)
						{
							lock.wait(3000);
						}
						
					} else {
						break;
					}
				} catch (InterruptedException e) {
					// log.error("",e);
				}
			}

		}

		private List<Long> sortL(List<String> list) {
			List<Long> ll = new ArrayList<>(list.size());
			for (String l : list) {
				if (l.startsWith(name)) {
					ll.add(Long.parseLong(l.substring(40)));
				}
			}
			Collections.sort(ll);
			return ll;
		}

		@Override
		public synchronized void unlock() {
			if(nodeName == null) return;
			client.delete(nodeName);
			nodeName = null;
		}

	}

	public static IZKLock createZkLock(ZkClient c, String name) {
		return new ZKLockImp(c, name);
	}

	public static void main(String[] args) throws Exception {

		 ZkClient c = new ZkClient("192.168.0.204:2181");

		 IZKLock i1 = createZkLock(c,"abc");
		 IZKLock i2 = createZkLock(c,"abc");
		 log.debug("log..........");
		new Thread(() ->{
			log.debug("t1 -> start....");
			i1.lock();
			log.debug("t1 -> lock....");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			
			log.debug("t1 -> unlock....");
			i1.unlock();
		}).start();
		new Thread(() ->{
			log.debug("t2 -> start....");
			i2.lock();
			log.debug("t2 -> lock....");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			
			log.debug("t2 -> unlock....");
			i2.unlock();
			
		}).start();
		 log.debug("unlog..........");
		Thread.sleep(100000);
	}

}

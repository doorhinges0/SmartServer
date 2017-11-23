package com.fuck.mobile.common.zkclient;

import org.I0Itec.zkclient.ZkClient;



public interface IZkClientService {

	public ZkClient getZkClient();
	
	/**
	 * 创建分布式锁
	 * @param name
	 * @return
	 */
	@Deprecated
	public IZKLock createZKlock(String name);
}

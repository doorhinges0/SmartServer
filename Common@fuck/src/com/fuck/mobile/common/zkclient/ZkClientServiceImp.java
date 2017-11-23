package com.fuck.mobile.common.zkclient;

import java.io.Closeable;
import java.io.IOException;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class ZkClientServiceImp implements IZkClientService,Closeable {
	static Log log = LogFactory.getLog(ZkClientServiceImp.class);
	private ZkClient client;
	
	
	public ZkClientServiceImp(String url)
	{
		log.debug("new ZkClientServiceImp");
		client = new ZkClient(url);
		client.setZkSerializer(new BytesPushThroughSerializer());
	}
	
	
	@Override
	public ZkClient getZkClient() {
		return client;
	}





	@Override
	public void close() throws IOException {
		if(client != null)
		{
			client.close();
		}
	}


	@Override
	public IZKLock createZKlock(String name) {
		return ZKLock.createZkLock(client, name);
	}
	
	
	
	

}

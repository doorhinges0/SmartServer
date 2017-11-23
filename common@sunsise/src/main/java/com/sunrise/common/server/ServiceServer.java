package com.sunrise.common.server;

import com.sunrise.common.utils.SpringCtxUtils;

public class ServiceServer {
	public static void start(String[] springConfigs) {
		SpringCtxUtils.init(springConfigs);
		SpringCtxUtils.start();
		System.out.println(">>>UCPServer启动完毕");
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				super.run();
				try {
					while (true) {
						Thread.sleep(1000 * 60 * 30);
						//TODO 实现监控，停止
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}
}

package com.fuck.mobile.common.ntp;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.esotericsoftware.minlog.Log;
import com.fuck.mobile.common.IZooKeeperConfig;

//默认不启动，需要启动单独继承
public abstract class NtpServiceImp implements INtpService {
	static org.apache.commons.logging.Log log = LogFactory.getLog(NtpServiceImp.class);
	private RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
	private long startUpTime = bean.getUptime();
	private long lastServerTime = 0;
	private long lastUpdate = 0;
	private boolean isUpdating = false;
	
	//1小时更新一次
	private static final long updateTime = 3600 * 1000;
	
	@Autowired
	IZooKeeperConfig config;	
	
	
	@PostConstruct
	private void init()
	{
		getServerDate();
	}
	
	
	private void getServerDate()
	{
		updateDate();
		while(isUpdating)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
	
	protected final synchronized void updateDate()
	{
		if(isUpdating) return;
		isUpdating = true;
		new Thread(()->{
			String ntpServer = null;
			log.debug("start get server date");
			try
			{
				ntpServer = config.get("NtpServer");
			}catch(Exception e)
			{
				
			}
			
			if(StringUtils.isEmpty(ntpServer))
			{
				ntpServer = "0.asia.pool.ntp.org";
			}
			NTPUDPClient timeClient = new NTPUDPClient();
			timeClient.setDefaultTimeout(2000);
			TimeInfo tif;
			InetAddress[] ies =null;
			try {
				 ies = InetAddress.getAllByName(ntpServer);
			} catch (Exception e1) {
			}
			try {
				
				for(InetAddress ie : ies)
				{
					log.debug("start 2 ..... get server date -> " + ie);
					try
					{
						tif = timeClient.getTime(ie);
						lastServerTime =  tif.getMessage().getReceiveTimeStamp().getTime();
						lastUpdate = bean.getUptime();
						startUpTime = lastUpdate;
						log.debug("get server date -> " + new Date(lastServerTime));
						log.debug("get server date -> " + lastServerTime);
						
						break;
					}catch(SocketTimeoutException e){
					}
				}
								
			} catch (Exception e) {
				Log.error("",e);
			}finally
			{
				try
				{
					timeClient.close();
				}catch(Exception e){}
				
			}
			isUpdating = false;
		}).start();
		
	}
	
	
	
	@Override
	public Date getNow() {
		
		if(bean.getUptime() - lastUpdate > updateTime)
		{
			if(lastServerTime == 0)
			{
				getServerDate();
			}else
			{
				updateDate();
			}
			
		}
		if(lastServerTime==0) return  new Date();
		return new Date(lastServerTime +  bean.getUptime() - startUpTime);
	}

	
	
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		NTPUDPClient timeClient = new NTPUDPClient();
		timeClient.setDefaultTimeout(2000);
		System.out.println("start...");
		InetAddress[] ies = InetAddress.getAllByName("0.asia.pool.ntp.org");
		System.out.println("start2..." + Arrays.toString(ies));
		TimeInfo tif  = null;
		for(InetAddress ie : ies)
		{
			System.out.println("start x ..." + ie);
			try
			{
				tif =	timeClient.getTime((ie));
			}catch(SocketTimeoutException e){
				e.printStackTrace();
			}
		
		}

		
		System.out.println("start3...");
		System.out.println(new Date(tif.getReturnTime()));  
		
	}
	
}

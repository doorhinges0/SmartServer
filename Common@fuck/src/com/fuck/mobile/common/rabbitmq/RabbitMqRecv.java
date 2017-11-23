package com.fuck.mobile.common.rabbitmq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.fuck.mobile.common.IRedisService;
import com.fuck.mobile.common.rabbitmq.exception.RepeatedDefinitionListenerException;
import com.fuck.mobile.util.Device;
import com.fuck.mobile.util.SHA1Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;
import com.rabbitmq.client.ShutdownSignalException;

class RabbitMqRecv {
	private static class RabbitMqRecvDef {
		String name;
		RabbitMqType type;
		String Routingkey;
		IRabbitMqMsgListener lis;

		public RabbitMqRecvDef(String name, RabbitMqType type, String routingkey, IRabbitMqMsgListener lis) {
			super();
			this.name = name;
			this.type = type;
			Routingkey = routingkey;
			this.lis = lis;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof RabbitMqRecvDef)) {
				return false;
			}
			RabbitMqRecvDef s = (RabbitMqRecvDef) obj;
			if (Objects.equals(s.name, this.name) && Objects.equals(s.type, this.type)
					&& Objects.equals(s.Routingkey, this.Routingkey)) {
				return true;
			}
			return false;
		}
	}
	
	// ----------------------------
	private static Log log = LogFactory.getLog(RabbitMqRecv.class);
	private List<ConnectionFactory> factorys;
	private Channel recvChannel;
	private Connection recvconnection;
	private boolean isStart;
	private IRedisService redisService = null;
	private ArrayList<RabbitMqRecvDef> list = new ArrayList<>();
	private ThreadPoolTaskExecutor taskExecutor;
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Thread mRecvThread = null;
	

	// ------------------------------

	private Runnable recvRun = () -> {
		try {
			Thread.sleep(5000);
			// 等待其他服务启动,setMQListerner全部执行完毕
		} catch (Exception e) {
		}
		String qname = null;
		while (isStart) {
			try {
				if (qname == null) {
					qname = getRecvChannel().queueDeclare(Device.getDeviceId(), true, false, false, null).getQueue();
				}
				GetResponse delivery = getRecvChannel().basicGet(qname, false);
				if(delivery == null)
				{
					Thread.sleep(10);
					continue;
				}
				taskExecutor.execute(()->
				{
					
					try
					{
						String rkey = delivery.getEnvelope().getRoutingKey();
						String name = delivery.getEnvelope().getExchange();
						byte[] data = delivery.getBody();
						String msg = data == null ? null : new String(data,"utf-8");
						boolean isRedeliver = delivery.getEnvelope().isRedeliver();
						StringBuilder sb = new StringBuilder(256 + msg.length());
						sb.append(Device.getDeviceId()).append(",").append(rkey).append(",").append(name).append(",").append(msg);
						
						String key = "RabbitMq_" + SHA1Util.getSHA1String(sb.toString());
						if(isRedeliver)
						{
							if(redisService.exists(key))
							{
								log.debug("已处理了该消息 ->" + delivery.getEnvelope());
								getRecvChannel().basicAck(delivery.getEnvelope().getDeliveryTag(),false);
								redisService.del(key);
								return;
							}
						}
						boolean iscc = false;
						for(RabbitMqRecvDef def : list)
						{
							if(StringUtils.equals(def.name, name) && (StringUtils.equals(rkey, def.Routingkey) || (def.Routingkey == null && StringUtils.isEmpty(rkey))))
							{
								iscc = true;
								if(def.lis != null)
								{
									
									Exception exx = null;
									try
									{
										def.lis.handleMsg(name, rkey, msg);
									}catch(Exception e)
									{
										exx = e;
										log.error("", e);
									}
									if(exx == null)
									{
										redisService.setNx(key, "1", 3600 * 24 * 3);
										getRecvChannel().basicAck(delivery.getEnvelope().getDeliveryTag(),false);
										redisService.del(key);
									}
								}								
								break;
							}
						}
						if(iscc == false)
						{
							getRecvChannel().basicReject(delivery.getEnvelope().getDeliveryTag(),false);
						}
						
					}catch (ShutdownSignalException e) {
						log.warn("", e);
						try {
							Thread.sleep(1000);
						} catch (Exception e1) {
						}
						CloseRecvChannel();
					} catch (IOException e) {
						log.warn("", e);
						try {
							Thread.sleep(1000);
						} catch (Exception e1) {
						}
						CloseRecvChannel();
					} catch (Throwable e) {
						log.error("", e);
					}
					
				}
				);
				
			} catch (ShutdownSignalException e) {
				log.warn("", e);
				try {
					Thread.sleep(1000);
				} catch (Exception e1) {
				}
				CloseRecvChannel();
			} catch (IOException e) {
				log.warn("", e);
				try {
					Thread.sleep(1000);
				} catch (Exception e1) {
				}
				CloseRecvChannel();
			} catch (Throwable e) {
				log.error("", e);
			}

		}
		CloseRecvChannel();
	};
	
	

	private Channel getRecvChannel() throws IOException, TimeoutException {
		readWriteLock.readLock().lock();
		try
		{
			if (recvChannel != null) {
				return recvChannel;
			}
		}finally
		{
			readWriteLock.readLock().unlock();
		}
		readWriteLock.writeLock().lock();
		Exception laste = null;
		try
		{
			if (recvconnection == null) {
				
				for (ConnectionFactory factory : factorys) {
					try {
						recvconnection = factory.newConnection();
						recvChannel = recvconnection.createChannel();
						recvChannel.basicQos(0, 1, false);
						if (list.size() > 0) {
							String qname = recvChannel.queueDeclare(Device.getDeviceId(), true, false, false, null).getQueue();
							for (RabbitMqRecvDef def : list) {
								recvChannel.exchangeDeclare(def.name, def.type.getString(),true);
								if( def.Routingkey != null)
								{
									recvChannel.queueBind(qname, def.name,def.Routingkey);
								}else
								{
									recvChannel.queueBind(qname, def.name,"");
								}
								
							}
						}
						break;
					} catch (Exception e) {
						laste = e;
						log.error("", e);
					}
				}
			}
		}finally
		{
			readWriteLock.writeLock().unlock();
		}
		if (recvChannel == null) {
			CloseRecvChannel();
			if (laste != null) {
				if (laste instanceof IOException) {
					throw (IOException) laste;
				} else if (laste instanceof TimeoutException) {
					throw (TimeoutException) laste;
				}
			}
		}
		log.debug("--------------------------------------------");
		log.debug("init RabbitMq Recv .....");
		log.debug("--------------------------------------------");
		return recvChannel;
	}

	private void CloseRecvChannel() {
		readWriteLock.writeLock().lock();
		try
		{
			try {
				recvChannel.close();
			} catch (Exception e) {
			}
			recvChannel = null;
			try {
				recvconnection.close();
			} catch (Exception e) {
			}
			recvconnection = null;
		}finally
		{
			readWriteLock.writeLock().unlock();
		}
		
	}

	public RabbitMqRecv(List<ConnectionFactory> factorys,ThreadPoolTaskExecutor taskExecutor,IRedisService redisService) {
		super();
		this.taskExecutor = taskExecutor;
		this.factorys = factorys;
		this.redisService = redisService;
	}

	public void stop() {
		isStart = false;
		long times = 0;
		long waiter = 3 * 1000;
		while (mRecvThread != null && mRecvThread.isAlive() && times < waiter)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			times++;
		}
	}

	public synchronized void setMQListerner(String name, RabbitMqType type, String Routingkey, IRabbitMqMsgListener lis)
			throws RepeatedDefinitionListenerException {
		RabbitMqRecvDef def = new RabbitMqRecvDef(name, type, Routingkey, lis);
		if (list.contains(def)) {
			throw new RepeatedDefinitionListenerException();
		}
		list.add(def);
		if (isStart == false) {
			mRecvThread = new Thread(recvRun);
			mRecvThread.start();
			isStart = true;
		}

	}
}

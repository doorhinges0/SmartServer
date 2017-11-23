package com.fuck.mobile.common.rabbitmq;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.fuck.mobile.common.IRedisService;
import com.fuck.mobile.common.RedisServiceImp;
import com.fuck.mobile.common.rabbitmq.exception.MQNotStartException;
import com.fuck.mobile.util.SHA1Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.Exchange;
import com.xnew.CloseEx;
import com.fuck.mobile.util.Device;

class RabbitMqSend {
	private static class RabbitMqMsg {
		String name;
		String Routingkey;
		String msg;
		boolean isSent = false;

		public RabbitMqMsg(String name, String routingkey, String msg) {
			super();
			this.name = name;
			Routingkey = routingkey;
			this.msg = msg;
		}

		@Override
		public String toString() {
			return "RabbitMqMsg [name=" + name + ", Routingkey=" + Routingkey + ", msg=" + msg + "]";
		}

	}

	private static Log log = LogFactory.getLog(RabbitMqSend.class);
	private List<ConnectionFactory> factorys;
	private boolean isStart = false;
	private Channel sendChannel;
	private Connection sendconnection;
	private BlockingQueue<RabbitMqMsg> sendMsg = new LinkedBlockingQueue<RabbitMqMsg>();
	private IRedisService redisService = null;
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private HashMap<String,Object> existExchange = new HashMap<>();
	private Thread mSendThread = null;

	private Runnable myrun = () -> {
		readOldSendMsg();
		while (isStart) {
			RabbitMqMsg msg = null;
			try {
				msg = sendMsg.poll(2, TimeUnit.SECONDS);
				if (msg == null)
					continue;
				
				if(!existExchange.containsKey(msg.name))
				{
					try
					{
						Exchange.DeclareOk d = getSendChannel().exchangeDeclarePassive(msg.name);
						existExchange.put(msg.name,"");
					}catch(IOException e)
					{
						CloseSendChannel();
						getSendChannel().exchangeDeclare(msg.name, RabbitMqType.fanout.getString(), true);
						existExchange.put(msg.name,"");
					}
					
				}
				
				
				
				getSendChannel().basicPublish(msg.name, msg.Routingkey == null ? "" : msg.Routingkey, null,
						String2Bytes(msg.msg));
				msg.isSent = true;
			} catch (ShutdownSignalException e) {
				log.warn("", e);
				CloseSendChannel();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
				if (msg != null && msg.isSent == false) {
					try {
						sendMsg.put(msg);
					} catch (Exception e2) {
						log.error("", e2);
					}

				}
			} catch (IOException e) {
				log.warn("", e);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
				CloseSendChannel();
				if (msg != null && msg.isSent == false) {
					try {
						sendMsg.put(msg);
					} catch (Exception e2) {
						log.error("", e2);
					}
				}
			} catch (Exception e) {
				log.warn("", e);
				if (msg != null && msg.isSent == false) {
					try {
						sendMsg.put(msg);
					} catch (Exception e2) {
						log.error("", e2);
					}
				}
			}
		}
		CloseSendChannel();
		saveSendMsg();
	};

	private void saveSendMsg() {
		log.debug("saving Send Msg....");
		if (sendMsg.size() > 0) {
			RedisServiceImp imp = new RedisServiceImp();
			imp.closeEx = new CloseEx();
			imp.initReidsWithLastSetting();
			String key = "RabbitMqMsg_Send_" + SHA1Util.getSHA1String(Device.getDeviceId());
			imp.setObject(key, sendMsg, 3600 * 24 * 30);
			imp.close2();
		}
		sendMsg.clear();
	}

	@SuppressWarnings("unchecked")
	private void readOldSendMsg() {
		// 等待其他数据初始化
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		String key = "RabbitMqMsg_Send_" + SHA1Util.getSHA1String(Device.getDeviceId());
		Object o = redisService.getObject(key);
		BlockingQueue<RabbitMqMsg> msg = null;
		if (o != null) {
			msg = (BlockingQueue<RabbitMqMsg>) o;
		}
		redisService.del(key);
		if (msg != null && msg.size() > 0) {
			sendMsg.addAll(msg);
		}

	}

	private static byte[] String2Bytes(String data) {
		if (data == null)
			return null;
		try {
			return data.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	RabbitMqSend(List<ConnectionFactory> factorys, IRedisService redisService) {
		this.factorys = factorys;
		this.redisService = redisService;
	}

	private Channel getSendChannel() throws IOException, TimeoutException {
		readWriteLock.readLock().lock();
		try {
			if (sendChannel != null) {
				return sendChannel;
			}
		} finally {
			readWriteLock.readLock().unlock();
		}
		readWriteLock.writeLock().lock();
		Exception laste = null;
		try {

			if (sendconnection == null) {
				for (ConnectionFactory factory : factorys) {
					try {
						sendconnection = factory.newConnection();
						sendChannel = sendconnection.createChannel();
						break;
					} catch (Exception e) {
						laste = e;
						log.error("", e);
					}
				}
			}
		} finally {
			readWriteLock.writeLock().unlock();
		}

		if (sendChannel == null) {
			CloseSendChannel();
			if (laste != null) {
				if (laste instanceof IOException) {
					throw (IOException) laste;
				} else if (laste instanceof TimeoutException) {
					throw (TimeoutException) laste;
				}
			}
		}

		log.debug("--------------------------------------------");
		log.debug("init RabbitMq Send .....");
		log.debug("--------------------------------------------");
		return sendChannel;
	}

	private void CloseSendChannel() {
		log.debug("CloseSendChannel.................");
		readWriteLock.writeLock().lock();
		try {
			try {
				sendChannel.close();
			} catch (Exception e) {
			}
			sendChannel = null;
			try {
				sendconnection.close();
			} catch (Exception e) {
			}
			sendconnection = null;
		} finally {
			readWriteLock.writeLock().unlock();
		}

	}

	public synchronized void start() {
		if (isStart) {
			log.warn("RabbitMqSend already start");
			return;
		}
		isStart = true;
		mSendThread = new Thread(myrun);
		mSendThread.start();
	}

	public void stop() {
		isStart = false;
        long times = 0;
        long waiter = 3 * 1000;
		while (mSendThread != null && mSendThread.isAlive() && times < waiter)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
            times++;
		}
	}

	public void sendMsg(String name, String Routingkey, String msg) throws MQNotStartException {
		if (!isStart) {
			throw new MQNotStartException();
		}
		RabbitMqMsg msgx = new RabbitMqMsg(name, Routingkey, msg);
		try {
			sendMsg.put(msgx);
		} catch (InterruptedException e) {
			log.error("msg -> " + msgx.toString(), e);
		}
	}

}

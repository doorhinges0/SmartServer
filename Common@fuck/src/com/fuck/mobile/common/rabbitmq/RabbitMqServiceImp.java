package com.fuck.mobile.common.rabbitmq;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.fuck.mobile.common.IRedisService;
import com.fuck.mobile.common.rabbitmq.exception.RepeatedDefinitionListenerException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.ConnectionFactory;
import com.fuck.mobile.base.constant.Constants;
import com.fuck.mobile.common.IZooKeeperConfig;
import com.fuck.mobile.common.rabbitmq.exception.MQNotStartException;

/**
 * @category mq核心服务
 * @author MegaX
 *
 */
@Service
class RabbitMqServiceImp implements IRabbitMqService {
	private static Log log = LogFactory.getLog(RabbitMqServiceImp.class);

	// --------------------------------
	@Autowired
	private IZooKeeperConfig zkConfig;
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	private IRedisService redisService;

	// ---------------------------------
	private List<ConnectionFactory> factorys = new ArrayList<>();
	private RabbitMqSend rabbitMqSend;
	private RabbitMqRecv rabbitMqRecv;
	private boolean isInit = false;
	// -----------------------------------

	@PostConstruct
	private synchronized void init() {
		if(isInit) return;
		
		log.debug("start RabbitMqServiceImp.............");
		String rabbitMQUrl = zkConfig.get(Constants.YunWei+"/RabbitMQ/RabbitMQUrl");
		List<HostAndPort> hosts = new ArrayList<>();
		if(StringUtils.isEmpty(rabbitMQUrl))
		{
			String rabbitMQHost = zkConfig.get(Constants.YunWei+"/RabbitMQ/RabbitMQHost");
			Integer rabbitMQHostPort = Integer.parseInt(zkConfig.get(Constants.YunWei+"/RabbitMQ/RabbitMQPort"));
			hosts.add(new HostAndPort( rabbitMQHost, rabbitMQHostPort));
		}else
		{
			hosts.addAll(HostAndPort.getAddresses(rabbitMQUrl));
		}		
		initMQService(hosts);
		isInit = true;
		log.debug("start RabbitMqServiceImp end.............");
	}

	private void initMQService(List<HostAndPort> hosts) {
		for(HostAndPort h : hosts)
		{
			log.debug("MQ Server ->" + h);
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(h.host);
			factory.setPort(h.port);
			factory.setThreadFactory(taskExecutor);
			factory.setSharedExecutor(taskExecutor.getThreadPoolExecutor());
			factory.setConnectionTimeout(60000);
			factory.setRequestedHeartbeat(5);
			factorys.add(factory);
		}
		
		log.debug("factory init.....");
		startSend();
	}

	private void startSend() {
		log.debug("start Mq Send......");
		if (rabbitMqSend == null)
			rabbitMqSend = new RabbitMqSend(factorys,redisService);
		rabbitMqSend.start();
	}

	@PreDestroy
	private void destory() {
		log.debug("destory RabbitMqServiceImp.............");
		if (rabbitMqSend != null)
			rabbitMqSend.stop();
		if(rabbitMqRecv != null)
			rabbitMqRecv.stop();
		log.debug("destory RabbitMqServiceImp end.............");
	}

	// -----------------------------------------

	@Override
	public void sendMsg(String name, String Routingkey, String msg) throws MQNotStartException {
			rabbitMqSend.sendMsg(name,  Routingkey, msg);
	}

	@Override
	public void sendMsg(String name, String msg) throws MQNotStartException {
			rabbitMqSend.sendMsg(name, null, msg);
	}

	@Override
	public synchronized void setMQListerner(String name, RabbitMqType type, String Routingkey, IRabbitMqMsgListener lis)
			throws RepeatedDefinitionListenerException {
		if(rabbitMqRecv == null)
		{
			rabbitMqRecv = new RabbitMqRecv(factorys,taskExecutor,redisService);
		}
		rabbitMqRecv.setMQListerner(name, type, Routingkey, lis);
		
	}	
}

package com.fuck.mobile.common.rabbitmq;

import java.io.IOException;

import com.fuck.mobile.common.rabbitmq.exception.RepeatedDefinitionListenerException;
import com.fuck.mobile.common.rabbitmq.exception.MQNotStartException;

/**
 * @category rabbitmq基础服务
 * @author MegaX
 *
 */
public interface IRabbitMqService {

	/**
	 * @category 发消息
	 * @param name 消息名称
	 * @param type 类型，建议使用direct
	 * @param Routingkey 理由key
	 * @param msg
	 * @throws MQNotStartException 
	 * @throws IOException
	 */
	void sendMsg(String name,String Routingkey, String msg) throws MQNotStartException;
	/**
	 * @category 发消息
	 * @param name 消息名称
	 * @param type 类型
	 * @param msg
	 * @throws MQNotStartException 
	 * @throws IOException
	 */
	void sendMsg(String name,String msg) throws MQNotStartException;
	
	/**
	 * @category 设置mq消息回调
	 * @param name 消息名称
	 * @param type 类型
	 * @param Routingkey 理由key
	 * @param lis
	 */
	void setMQListerner(String name,RabbitMqType type,String Routingkey,IRabbitMqMsgListener lis) throws RepeatedDefinitionListenerException;
	
	
	
	
}

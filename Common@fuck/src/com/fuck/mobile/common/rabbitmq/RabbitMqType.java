package com.fuck.mobile.common.rabbitmq;

public enum RabbitMqType {
	 headers("headers"),fanout("fanout"),direct("direct"),topic("topic");
	
	private String name;
	private RabbitMqType(String name) {
        this.name = name;
    }
	public String getString()
	{
		return name;
	}
}

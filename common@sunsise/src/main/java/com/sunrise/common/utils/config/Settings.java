package com.sunrise.common.utils.config;

import com.sunrise.common.utils.i18n.Message;

public enum Settings {

	//系统配置文件
	RUNMODE(Message.getString("/setting/settings.properties",
			"run.enviroment", "local")),
	APPCODE(Message.getString("/setting/settings.properties",
			"appcode", "ucp"));

	private final String value;
	
	Settings(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}

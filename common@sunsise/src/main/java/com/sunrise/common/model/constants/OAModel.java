package com.sunrise.common.model.constants;

public enum OAModel {
	//应用编码
	APP_CODE("OA"),
	
	//数据表与voName的对应关系
	OA_ANNOUNCE("Announce"),
	OA_ANNOUNCE_TRACE("AnnounceTrace"),
	OA_SERIAL("Serial");
	
	private final String value;

	OAModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}

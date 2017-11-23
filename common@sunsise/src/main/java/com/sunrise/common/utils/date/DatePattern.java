package com.sunrise.common.utils.date;

public enum DatePattern {
	_YYYYMMDD ("yyyy-MM-dd"),
	_YYYYMMDDHHMISS("yyyy-MM-dd HH:mm:ss"),
	YYYYMMDD ("yyyyMMdd"),
	YYYYMMDDHHMISS("yyyyMMddHHmmss");
	
	private final String value;
	private DatePattern(String value) {
		this.value = value;
	}
	
	public String toString(){
		return value;
	}
	
}

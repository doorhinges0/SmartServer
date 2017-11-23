package com.sunrise.common.model.constants;


public enum CmModel {
	//默认的应用编码
	APP_CODE("CM");
	
	private final String value;

	CmModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
	public boolean valEquals(String val) {
		return value.equals(val);
	}
}

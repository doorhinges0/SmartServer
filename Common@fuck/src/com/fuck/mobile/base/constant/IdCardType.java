package com.fuck.mobile.base.constant;

public enum IdCardType {

	IDENTITYCARD(0,"身份证"),TAIWAIPASS(1,"台湾居民来往大陆通行证"),HKMACO(2,"港澳居民来往内地通行证");

	private Integer value;

	private String desc;

	private IdCardType(Integer value,String desc){
		this.value = value;
		this.desc = desc;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}

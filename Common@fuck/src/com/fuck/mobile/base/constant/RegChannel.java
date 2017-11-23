package com.fuck.mobile.base.constant;

public enum RegChannel {
	PC("PC","PC"),APP("M","APP"),WeiXin("WeiXin","WeiXin");

	private String value;

	private String desc;

	private RegChannel(String value,String desc){
		this.value = value;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}

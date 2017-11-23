
package com.fuck.mobile.base.constant;

public enum Ostype {
	
	ALL(0,"ALL"),ANDROID(1,"ANDROID"),IOS(2,"IOS"),PC(3,"PC"),WEIXIN(4,"WEIXIN"),WAP(5,"WAP");

	private Integer value;

	private String desc;

	private Ostype(Integer value,String desc){
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

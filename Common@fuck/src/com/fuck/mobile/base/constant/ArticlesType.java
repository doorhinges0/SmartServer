
package com.fuck.mobile.base.constant;

public enum ArticlesType {
	//1-媒体报道，2公司资讯3-行业资讯4-公告
	
	Media(1,"媒体报道"),Company(2,"公司资讯"),Industry(3,"行业资讯"),Notices(4,"公告");

	private int value;

	private String desc;

	private ArticlesType(int value,String desc){
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}

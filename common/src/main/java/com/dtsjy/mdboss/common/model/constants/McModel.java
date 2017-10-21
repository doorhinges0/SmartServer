package com.dtsjy.mdboss.common.model.constants;

public enum McModel {

	//应用编码
	APP_CODE("MC"),
	
	RTX_SN_TASKTITLE("taskTitle"),
	RTX_SN_TASKPROCESSNAME("taskProcessname"),
	RTX_SN_TASKNAME("taskName")
	;
	
	private final String value;

	McModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
	public boolean valEquals(String val) {
		return value.equals(val);
	}
	
}

package com.dtsjy.mdboss.common.model.constants;

public enum HRModel {
	//应用编码
	APP_CODE("HR"),
	
	//数据表与voName的对应关系
	HR_ATTENDANCE_ALLDAYSIGNIN("AttendanceAlldaysignin"),
	HR_ATTENDANCE_DAYDEF("AttendanceDaydef"),
	HR_ATTENDANCE_DEVICE("AttendanceDevice"),
	HR_ATTENDANCE_MONTHSIGNINCOUNT("AttendanceMonthsignincount"),
	HR_ATTENDANCE_RESIGNIN("AttendanceResignin"),
	HR_SERIAL("Serial");
	
	private final String value;

	HRModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
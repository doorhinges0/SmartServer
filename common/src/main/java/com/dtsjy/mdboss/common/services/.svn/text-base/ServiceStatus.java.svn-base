package com.dtsjy.mdboss.common.services;

public enum ServiceStatus {
	// 成功
	OK(new String[] { "200", "操作成功" }),

	// 错误
	ERROR(new String[] { "300", "操作失败" }),
	// 超时
	TIMEOUT(new String[] { "302", "会话超时" }),
	// 超时
	UNKNOW(new String[] { "900", "未知的处理结果" });

	private final String[] value;

	ServiceStatus(String[] valid) {
		this.value = valid;
	}

	public String code() {
		return value[0];
	}

	public String msg() {
		return value[1];
	}
}

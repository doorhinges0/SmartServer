package com.sunrise.common.model.constants;

public enum CommonModel {
	
	COMMON_SYS_PARAM("SysParam"),
	COMMON_EXCEPTIONLOG("Exceptionlog"),
	COMMON_SERVICELOG("Servicelog"),
	//状态
	ENABLE("enable"),
	DISABLED("disabled"),
	
	//是否删除
	YES("1"),
	NO("0"),
	
	//编码前缀
	PREFIX_GROUPCODE("group-"),
	PREFIX_PROJECTCODE("project-"),
	PREFIX_ROLECODE("role-"),
	PREFIX_ORGCODE("org-"),
	PREFIX_USRCODE("user-"),
	PREFIX_FORMCODE("form-"),
	PREFIX_TASKCODE("task-"),
	PREFIX_PROJECTROLE("projectrole-"),
	PREFIX_SPECIALTYTEMPLATE("specialtytemplate-"),
	PREFIX_QRCODE("qrcode-"),
	PREFIX_PROJECTPHASECODE("projectphase-"),
	PREFIX_PROJECTTEMPLATE("projecttemplate-"),
	PREFIX_RMISSUECODE("rmissue-"),
	PREFIX_VOTE("vote-"),
	PREFIX_SENDGROUPCODE("sendgroup-"),
	PREFIX_VIRTUALORG("vorg-"),
	
	//管理员角色编码
	SYSADMIN_ROLECODE("role-sysadmin"),
	
	//接口定义对象指定的方法类型
	SAVESERVLOG("saveservlog"),
	SAVEEXCEPTIONLOG("saveexceptionlog"),
	SAVESERVOUTPUT("saveservouput"),
	SAVESERVINPUT("saveservinput")
	;
	
	
	
	
	private final String value;

	CommonModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
	public boolean valueEqual(String val) {
		return value.equals(val);
	}
}

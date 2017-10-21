package com.dtsjy.mdboss.common.model.constants;

public enum CmsModel {
	
	//应用编码
	APP_CODE("CMS"),
	
	//资讯状态
	INFO_STATUS_CREATE("create"),
	INFO_STATUS_MODIFY("modify"),
	INFO_STATUS_AUDITING("auditing"),
	INFO_STATUS_PUBLISHED("published"),
	INFO_STATUS_HANGUP("hangup"), 
	INFO_STATUS_DELETE("delete"),
	
	//是否是新的资讯
	INFO_ISNEW_YES("yes"),
	INFO_ISNEW_NO("no"),
	
	//新闻状态
	NEWS_STATUS_PUBLISHED("published"),//已发布
	NEWS_STATUS_NOTPUBLISHED("notpublished"),//未发布,
	
	//通知状态
	NOTIFY_STATUS_PUBLISHED("published"),//已发布
	NOTIFY_STATUS_NOTPUBLISHED("notpublished"),//未发布
	;
	
	private final String value;

	CmsModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
	
}

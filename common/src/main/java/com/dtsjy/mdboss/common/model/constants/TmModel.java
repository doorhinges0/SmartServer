package com.dtsjy.mdboss.common.model.constants;

public enum TmModel {

	//应用编码
	APP_CODE("TM"),
	
	AVATAR_DIR("dir-avatar"),
	ATTACHMENT_DIR("dir-attachments"),
	
	//文件类型
	FILETYPE_AVATAR("avatar"),//头像
	FILETYPE_ATTACHMENTS("attachment"),//附件，流程/项目/任务/评论/报告等的附件
	
	//数据表与voName的对应关系
	OA_ANNOUNCE("Announce"),
	OA_ANNOUNCE_TRACE("AnnounceTrace"),
	OA_SERIAL("Serial");
	


	
	private final String value;

	TmModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}

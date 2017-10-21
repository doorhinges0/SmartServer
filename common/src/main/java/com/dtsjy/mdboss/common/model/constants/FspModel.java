package com.dtsjy.mdboss.common.model.constants;

public enum FspModel {
	//应用编码
	APP_CODE("FSP"),
	AVATAR_DIR("dir-avatar"),
	USERSIGN_DIR("dir-usersign"),
	ATTACHMENT_DIR("dir-attachments"),
	
	//文件类型
	FILETYPE_AVATAR("avatar"),//头像
	FILETYPE_USERSIGN("usersign"),//签名
	FILETYPE_ATTACHMENTS("attachment"),//附件，流程/项目/任务/评论/报告等的附件
	//数据表与voName的对应关系
	FSP_FILE_LOG("FileLog"),
	FSP_FILE_OPERATION("FileOperation"),
	FSP_FILE_REPOSITORY("FileRepository"),
	FSP_FILE_REPOSITORY_LOG("FileRepositoryLog"),
	FSP_FILE("File"),
	FSP_VIRTUALFILE("Virtualfile"),
	FSP_FOLDER("Folder"),
	FSP_FOLDER_LOG("FolderLog"),
	FSP_TABLOG("Tablog"),
	FSP_TMPFILE("Tmpfile"),
	
	//文件关系类型
	FSP_FILERELATYPE_PDF2IMG("pdf2img"),
	FSP_FILERELATYPE_PDF2QRCODEPDF("pdf2qrcodepdf")
	;
	
	private final String value;

	FspModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}

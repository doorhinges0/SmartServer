package com.dtsjy.mdboss.common.model.constants;

public enum PMModel {
	//应用编码
	APP_CODE("PM"),
		
	//数据表与voName的对应关系
	PM_PROJECT("Project"),
	PM_PROJECT_ANNOUNCE("ProjectAnnounce"),
	PM_PROJECT_RELA("ProjectRela"),
	PM_PROJECT_REPOS("ProjectRepos"),
	PM_PROJECT_STATINFO("ProjectStatinfo"),
	PM_TABLOG("Tablog"),
	TC_CALENDARDEF("Calendardef"),
	TC_TASK("Task"),
	TC_TASK_ATTACHMENT("TaskAttachment"),
	TC_TASK_COMMENT("TaskComment"),
	TC_TASK_LOG("TaskLog"),
	TC_TASK_MEMBERS("TaskMembers"),
	TC_TASK_REMIND("TaskRemind"),
	TC_USER_CALLENDAR("UserCallendar"),
	TC_WORKREPORT("Workreport"),
	PM_PROJECT_ORG_TEMPLATE("ProjectOrgTemplate");
	
	private final String value;

	PMModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}

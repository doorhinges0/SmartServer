package com.sunrise.common.model.constants;

public enum UcpModel {
	//应用编码
	APP_CODE("UCP"),
	
	//数据表与voName的对应关系
	UCP_APPS("Apps"),
	UCP_DELEGATE("Delegate"),
	UCP_DELEGATE_DETAIL("DelegateDetail"),
	UCP_DICT_GROUP("DictGroup"),
	UCP_DICT_ITEM("DictItem"),
	UCP_FREQUENCE_CONTACTS("FrequenceContacts"),
	UCP_FUCNTION("Fucntion"),
	UCP_LOGIN_LOG("LoginLog"),
	UCP_MODULE("Module"),
	UCP_ORG("Org"),
	UCP_ORG_ROLE("OrgRole"),
	UCP_PERM("Perm"),
	UCP_ROLE("Role"),
	UCP_ROLE_PERM("RolePerm"),
	UCP_TABLOG("Tablog"),
	UCP_USER("User"),
	UCP_USER_AVATAR("UserAvatar"),
	UCP_USER_PERM("UserPerm"),
	UCP_USER_ROLE("UserRole"),
	UCP_USER_TAG("UserTag"),
	UCP_USERGROUP("Usergroup"),
	UCP_USERGROUP_MEMBER("UsergroupMember"),
	UCP_USERRELA("Userrela"),
	UCP_WORDS_COMMONUSE("WordsCommonuse"),
	UCP_INTERFDEF("Interfdef"),
	UCP_TABLE_CONFIG("TableConfig"),
	UCP_TABLE_COLUMN_CONFIG("TableColumnConfig"),
	UCP_VIEW_VIEWUSERGROUPMEMBER("ViewUsergroupMember"),
	
	ORG_ISENABLED_ENABLE("enable"),//组织可用
	ORG_ISENABLED_DISABLED("disabled"),//不可用组织
	
	//组类型
	USERGROUP_TYPE_PUBLIC("public"),//通用群组
	USERGROUP_TYPE_PROCESS("process"),//项目组
	USERGROUP_TYPE_CUSTOM("custom"),//自定义群组
	USERGROUP_TYPE_DEPARTMENT("department"),//部门群组
	
	//群组角色
	ROLE_GROUP_PUBLIC("role-public-group"),//院群组管理角色
	ROLE_GROUP_DEPARTMENT("role-department-group"),//部门群组管理角色
	
	//特定参数
	USER_RELATYPE_FOLLOWER("isfollower"),
	USER_RELATYPE_SUBORDINATE("isusbordinate"),
	
	//表字段类型
	TABLE_COLUMNTYPE_EXT("ext"),//定义字段
	TABLE_COLUMNTYPE_DEF("def"),//扩展字段
	
	//是否是MDBOSS管理员
	ROLENAME_MDBOSS("MDBOSS管理员"),
	
	//角色类型
	ROLETYPE_ORGROLE("orgrole"),
	ROLETYPE_FLOWROLE("flowrole"),
	ROLETYPE_COMMONROLE("commonrole")
	;

	private final String value;

	UcpModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}

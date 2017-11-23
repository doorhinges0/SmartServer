package com.sunrise.common.model.constants;

import java.util.HashMap;
import java.util.Map;

public enum WfsModel {
	//默认的应用编码
	APP_CODE("WFS"),
	
	//环节类型
	DEFAULT_STEPTYPE("userTask"),
	TASKTYPE_CIRCULARIZE("circularize"),
	
	//启动任务的虚拟环节编码
	STARTUP_TASK_VIRTUAL_STEPCODE("startup-virtual-taskcode-notexist"),//违反唯一键，舍弃
	STARTUP_TASK_NAME("开始[启动流程]"),

	//环节关系类型
	STEP_RELATYPE_INCOMING("incoming"),
	STEP_RELATYPE_OUTGOING("outgoing"),
	
	//流程相关-默认的开始环节编码
	PROCESS_START_ACTIVITY("start-0"),
	PROCESS_END_ACTIVITY("end-0"),
	
	EXECLOG_ERROR("error"),
	EXECLOG_SUCCESS("success"),
	EXECLOG_RUNNING("running"),
	EXECLOG_DEBUG("debug"),
	EXECLOG_DEL("delete"),
	
//###########Selectpersionconfig配置###############################
	//处理人选择类型
	SELECTPERSON_CHECKBOX("checkbox"),
	SELECTPERSON_RADIO("radio"),
	//处理人选择数据类别(同编码前缀）
	SELECTPERSON_DATACLASS_PROJECT("project-"),
	SELECTPERSON_DATACLASS_GROUP("group-"),
	SELECTPERSON_DATACLASS_ROLE("role-"),
	SELECTPERSON_DATACLASS_ORG("org-"),
	SELECTPERSON_DATACLASS_SENDGROUP("sendgroup"),
	SELECTPERSON_DATACLASS_VIRTUALORG("vorg-"),
	//处理人选择数据类型
	SELECTPERSON_DATATYPE_TREE("tree"),
	SELECTPERSON_DATATYPE_LIST("list"),
	//处理人选择范围
	SELECTPERSON_ROLEBASE_LEVEL1("1"),//一级部门
	SELECTPERSON_ROLEBASE_LEVEL2("2"),//二级部门
	SELECTPERSON_ROLEBASE_LEVEL3("3"),//三级部门
	SELECTPERSON_ROLEBASE_LEVEL4("4"),//四级部门
	
	//流程环节配置，选择全部组织、全部项目、全部角色、全部群组、本组织
	SELECTPERSON_ALLGROUP("group-all"),
	SELECTPERSON_BMGROUP("group-bm"),//部门
	SELECTPERSON_ZDYGROUP("group-zdy"),//自定义
	SELECTPERSON_TYGROUP("group-ty"),//院群组
	SELECTPERSON_ALLPROJECT("project-all"),
	SELECTPERSON_ALLROLE("role-all"),
	SELECTPERSON_ALLORG("org-all"),
	SELECTPERSON_CURRENTORG("org-current"),
	
	//数据表与voName的对应关系
	WFS_ACTIVITY_CREATION("ActivityCreation"),
	WFS_ACTIVITY_PERMISSION("ActivityPermission"),
	WFS_ASSIGNEE_CONFIG("AssigneeConfig"),
	WFS_ATTACHMENT("Attachment"),
	WFS_DELEGATION("Delegation"),
	WFS_FORM("Form"),
	WFS_FORM_ATTR("FormAttr"),
	WFS_FORMINST("Forminst"),
	WFS_FORMITEM("Formitem"),
	WFS_HIS_TASK("HisTask"),
	WFS_HIS_WORKFLOW_INSTANCE("HisWorkflowInstance"),
	WFS_STEP("Step"),
	WFS_TASK("Task"),
	WFS_VALIDATOR("Validator"),
	WFS_WORKFLOW("Workflow"),
	WFS_WORKFLOW_INSTANCE("WorkflowInstance"),
	WFS_WORKFLOW_RELA("WorkflowRela"),
	WFS_SERIAL("Serial"),
	
	//字典参数-任务状态
	TASKSTATUS_TODO("todo"),
	TASKSTATUS_COMPLETE("complete"),
	TASKSTATUS_WITHDRAW("withdraw"),
//	TASKSTATUS_COMPLETEBYMOVETO("completebymoveto"),//跳转时自动结束任务
	TASKSTATUS_TERMINAL("terminal"),//终止流程实例时，会终止该流程实例的所有待办任务，此时待办任务状态设为terminal
	
	//流程实例状态
	PROCESSINSTANCE_STATUS_DRAFT("draft"),
	PROCESSINSTANCE_STATUS_RUNNING("running"),
	PROCESSINSTANCE_STATUS_SUSPEND("suspend"),
	PROCESSINSTANCE_STATUS_COMPLETE("complete"),
	PROCESSINSTANCE_STATUS_TERMINAL("terminal"),
	PROCESSINSTANCE_STATUS_CANCEL("cancel"),
	
	//流程实例是否被使用
	PROCESSINSTANCE_ISUSED_USED("used"),
	
	
	//公文流程关联信息
	PROCESSINSTANCE_RELA_WATCHED("watched"),
	PROCESSINSTANCE_RELA_SHARED("shared"),
	PROCESSINSTANCE_RELATYPE_PROCESS("process"),
	PROCESSINSTANCE_RELATYPE_USER("user"),
	
	//提醒方式
	TASK_REMINDWAY_MSG("msg"),
	TASK_REMINDWAY_EMAIL("email"),
	TASK_REMINDWAY_SMS("sms"),

	//表单类型
	FORMTYPE_PRINT("printform"),
	FORMTYPE_HANDLE("handleform"),
	
	//公文委派状态
	TASK_DELEGATION_RUNNING("running"),//委派中
	TASK_DELEGATION_FININSHED("finished")//委派结束
	;
	
	public static Map<String, String> TASK_STATUS = new HashMap<String, String>();
	static {
		TASK_STATUS.put("todo", "未处理");
		TASK_STATUS.put("complete", "已完成");
		TASK_STATUS.put("withdraw", "已撤回");
		TASK_STATUS.put("terminal", "已终止");
	}
	
	private final String value;

	WfsModel(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
	
	public boolean valEquals(String val) {
		return value.equals(val);
	}
}

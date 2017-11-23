package com.sunrise.wfs.dal.gen.model;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class FormDataVO {

	private String title;
	
	private String serialcode;
	
	private String comorg; // "来文单位, 来文部门?
	
	private String comopr; // 来文经办人, 发文人
	
	private String officephone; // 联系方式
	
	private String urgency; // 重要程度,  general, worry, urgent
	
	private String maincontent; // 正文摘要
	
	private List<JSONObject> maindoc;//正文
	
	private List<JSONObject> attaches;//附件

	
	// 处理时限
//	durdate", "2016-02-03"
	// 收文日期
//	recdocdate, "2016-01-27"
//	recdocdate, "2016-01-27"
//	projectinfoname "";
//	selectproject, "[]";
//	selectproject, "[]";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSerialcode() {
		return serialcode;
	}

	public void setSerialcode(String serialcode) {
		this.serialcode = serialcode;
	}

	public String getComorg() {
		return comorg;
	}

	public void setComorg(String comorg) {
		this.comorg = comorg;
	}

	public String getComopr() {
		return comopr;
	}

	public void setComopr(String comopr) {
		this.comopr = comopr;
	}

	public String getOfficephone() {
		return officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		
		this.urgency = urgency;
		
	}

	public String getMaincontent() {
		return maincontent;
	}

	public void setMaincontent(String maincontent) {
		this.maincontent = maincontent;
	}

	public List<JSONObject> getMaindoc() {
		return maindoc;
	}

	public void setMaindoc(List<JSONObject> maindoc) {
		this.maindoc = maindoc;
	}

	public List<JSONObject> getAttaches() {
		return attaches;
	}

	public void setAttaches(List<JSONObject> attaches) {
		this.attaches = attaches;
	}

	

}

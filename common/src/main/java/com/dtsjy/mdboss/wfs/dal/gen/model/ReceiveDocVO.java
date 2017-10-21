package com.dtsjy.mdboss.wfs.dal.gen.model;


public class ReceiveDocVO {
	
	private String usercode;
	
	private String processcode;
	
	private String submittype;
	
	private HandleInfoVO handleinfo;
	
	private FormDataVO formdata;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getSubmittype() {
		return submittype;
	}
	
	public void setSubmittype(String submittype) {
		this.submittype = submittype;
	}
	
	public String getProcesscode() {
		return processcode;
	}

	public void setProcesscode(String processcode) {
		this.processcode = processcode;
	}

	public HandleInfoVO getHandleinfo() {
		return handleinfo;
	}

	public void setHandleinfo(HandleInfoVO handleinfo) {
		this.handleinfo = handleinfo;
	}

	public FormDataVO getFormdata() {
		return formdata;
	}

	public void setFormdata(FormDataVO formdata) {
		this.formdata = formdata;
	}
}

package com.sunrise.common.model;

public class ResponseObject<VO> {
	private Integer rc;
	private String msg;
	private DataPackage<VO> data;

	public Integer getRc() {
		return rc;
	}

	public void setRc(Integer rc) {
		this.rc = rc;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public DataPackage<VO> getData() {
		return data;
	}

	public void setData(DataPackage<VO> data) {
		this.data = data;
	}

}

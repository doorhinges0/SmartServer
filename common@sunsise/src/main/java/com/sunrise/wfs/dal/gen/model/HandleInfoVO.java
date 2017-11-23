package com.sunrise.wfs.dal.gen.model;

import com.alibaba.fastjson.JSONObject;

public class HandleInfoVO {
	
	private String transition;
	
	private JSONObject[] nextuser;

	public void setTransition(String transition) {
		this.transition = transition;
	}
	
	public String getTransition() {
		return transition;
	}
	
	public void setNextuser(JSONObject[] nextuser) {
		this.nextuser = nextuser;
	}
	
	public JSONObject[] getNextuser() {
		return nextuser;
	}
}

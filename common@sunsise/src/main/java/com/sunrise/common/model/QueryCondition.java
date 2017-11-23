package com.sunrise.common.model;

import java.util.List;

public class QueryCondition {
	private String key;
	private String operate;
	private Object v1;
	private Object v2;
	private List<QueryCondition> orConditions;
	
	public QueryCondition(){}
	
	
	public QueryCondition(String key, String operate, Object v1) {
		this(key,operate,v1,null);
	}


	public QueryCondition(String key, String operate, Object v1, Object v2) {
		super();
		this.key = key;
		this.operate = operate;
		this.v1 = v1;
		this.v2 = v2;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public Object getV1() {
		return v1;
	}
	public void setV1(Object v1) {
		this.v1 = v1;
	}
	public Object getV2() {
		return v2;
	}
	public void setV2(Object v2) {
		this.v2 = v2;
	}


	public List<QueryCondition> getOrConditions() {
		return orConditions;
	}


	public void setOrConditions(List<QueryCondition> orConditions) {
		this.orConditions = orConditions;
	}
	
	public QueryCondition addOrCondition(String key,String operate,Object v1,Object v2 ){
		orConditions.add(new QueryCondition(key,operate,v1,v2));
		return this;
	}
	
	public  QueryCondition addOrCondition(String key,String operate,Object v1 ){
		return addOrCondition(key, operate, v1,null);
	}
	
}
package com.sunrise.common.model.code2name;

/**
 * 
 * @author livan.c
 *
 */
public class Node {

	private String valueObject;

	private String code;

	private String name;

	private String sql;
	
	private ExtConfig extConfig = new ExtConfig();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueObject() {
		return valueObject;
	}

	public void setValueObject(String valueObject) {
		this.valueObject = valueObject;
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setCondition(String condition){
		extConfig.setCondition(condition);
	}
	
	public String getCondition(){
		return extConfig.getCondition();
	}
	
	public void setQueryFields(String queryFields){
		extConfig.setQueryFields(queryFields);
	}
	
	public String getQueryFields(){
		return extConfig.getQueryFields();
	}

	public String toString() {
//		ToStringStyle style =new ManageLogToStringStyle();
//		return ReflectionToStringBuilder.toString(this, style);		
		StringBuffer buffer = new StringBuffer(32);
		buffer.append("[Code2Name Node:")
				.append("code=")
				.append(code)
				.append(",")
				.append("name=")
				.append(name)				
				.append(",")
				.append("condition=")
				.append(sql)				
				.append("]");
		return buffer.toString();
		
	}
	
	class ExtConfig {
		private String condition;
		private String queryFields;
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getQueryFields() {
			return queryFields;
		}
		public void setQueryFields(String queryFields) {
			this.queryFields = queryFields;
		}
	}
}

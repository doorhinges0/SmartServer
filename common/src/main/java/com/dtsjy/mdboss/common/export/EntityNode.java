package com.dtsjy.mdboss.common.export;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityNode {
	private String voName;
	private String exceloutbean;
	private String headtitle;
	private String endtitle;
	private String showCount;
	private String sheetName;
	private String beforewrite;
	private String afterwrite;
	private String tableorview;
	private Map definitionMap;
	private List<String> fieldsList;
	private List<String> titleList;
	private List<FieldInfo> fields;
	private Map covertValueMap;
	private DelegateInfo delegateInfo ;
	private Map varMap;
	
	public Map getVarMap() {
		return varMap;
	}
	public void setVarMap(String key,String var) {
		if (varMap == null){
			varMap = new HashMap();
		}
		varMap.put(key, var);
	}
	public EntityNode(){
		delegateInfo = new DelegateInfo();
	}
	public Map getCovertValueMap() {
		return covertValueMap;
	}
	public void setCovertValueMap(String key,String covertValue) {
		if (covertValueMap == null){
			covertValueMap = new HashMap();
		}
		covertValueMap.put(key, covertValue);
	}
	public Map getDefinitionMap() {
		return definitionMap;
	}
	public void setDefinitionMap(String field,Object definition) {
		if (definitionMap == null){
			definitionMap = new HashMap();
		}
		definitionMap.put(field, definition);
	}

	public List<String> getFieldsList() {
		return fieldsList;
	}
	public void setFieldsList(String field) {
		if (fieldsList == null){
			fieldsList = new ArrayList<String>();
		}
		fieldsList.add(field);
	}
	public String getVoName() {
		return voName;
	}
	public void setVoName(String voName) {
		this.voName = voName;
	}

	public String getExceloutbean() {
		return exceloutbean;
	}
	public void setExceloutbean(String exceloutbean) {
		this.exceloutbean = exceloutbean;
	}
	
	public class FieldInfo{
		private String name;
		private String format;
		private String formattype;
		private String covertvalue;
		private String titlename;
		private String style;
		private String dbname;
		public String getDbname() {
			return dbname;
		}
		public void setDbname(String dbname) {
			this.dbname = dbname;
		}
		public String getStyle() {
			return style;
		}
		public void setStyle(String style) {
			this.style = style;
		}
		public String getTitlename() {
			return titlename;
		}
		public void setTitlename(String titlename) {
			this.titlename = titlename;
		}
		public FieldInfo(String name,String format,String formattype,String covertvalue,String titlename,String style,String dbname){
			this.name = name;
			this.format = format;
			this.formattype = formattype;
			this.covertvalue = covertvalue;
			this.titlename = titlename;
			this.dbname = dbname;
			this.style = style;
		}
		public String getCovertvalue() {
			return covertvalue;
		}
		public void setCovertvalue(String covertvalue) {
			this.covertvalue = covertvalue;
		}
		public String getFormat() {
			return format;
		}
		public void setFormat(String format) {
			this.format = format;
		}
		public String getFormattype() {
			return formattype;
		}
		public void setFormattype(String formattype) {
			this.formattype = formattype;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	class DelegateInfo{
		private String delegateClass;
		private Map queryMap;
		
		private class QueryInfo{
			private String queryType;
			private String methodType;
			private String queryName;
			private String querySql;
			private String methodName;
			private String orderby;
			public String getOrderby() {
				return orderby;
			}
			public void setOrderby(String orderby) {
				this.orderby = orderby;
			}
			public QueryInfo(String queryType,String methodType,String queryName,String methodName,String querySql,String orderby){
				this.queryType = queryType;
				this.methodType = methodType;
				this.queryName = queryName;
				this.methodName = methodName;
				this.querySql = querySql;
				this.orderby = orderby;
			}
			public String getMethodName() {
				return methodName;
			}
			public void setMethodName(String methodName) {
				this.methodName = methodName;
			}
			public String getMethodType() {
				return methodType;
			}
			public void setMethodType(String methodType) {
				this.methodType = methodType;
			}
			public String getQueryName() {
				return queryName;
			}
			public void setQueryName(String queryName) {
				this.queryName = queryName;
			}
			public String getQuerySql() {
				return querySql;
			}
			public void setQuerySql(String querySql) {
				this.querySql = querySql;
			}
			public String getQueryType() {
				return queryType;
			}
			public void setQueryType(String queryType) {
				this.queryType = queryType;
			}
		}
		public String getDelegateClass() {
			return delegateClass;
		}
		public void setDelegateClass(String delegateClass) {
			this.delegateClass = delegateClass;
		}
		public void addDelegateInfo(String queryType,String methodType,String queryName,String methodName,String querySql,String orderby) {
			if (queryMap == null ){
				queryMap = new HashMap(4);
			}
			queryMap.put(methodType, new QueryInfo(queryType,methodType,queryName,methodName,querySql,orderby));
		}
		public String getCountMethodName() {
			QueryInfo qi = (QueryInfo)queryMap.get("count_query");
			return (qi != null)?qi.getMethodName():null;
		}
		public String getCountQueryName() {
			QueryInfo qi = (QueryInfo)queryMap.get("count_query");
			return (qi != null)?qi.getQueryName():null;
		}
		public String getCountQuerySql() {
			QueryInfo qi = (QueryInfo)queryMap.get("count_query");
			return (qi != null)?qi.getQuerySql():null;
		}
		public String getCountQueryType() {
			QueryInfo qi = (QueryInfo)queryMap.get("count_query");
			return (qi != null)?qi.getQueryType():null;
		}
		
		public String getCountOrderby(){
			QueryInfo qi = (QueryInfo)queryMap.get("count_query");
			return (qi != null)?qi.getOrderby():null;
		}
		
		public String getQueryMethodName() {
			QueryInfo qi = (QueryInfo)queryMap.get("data_query");
			return (qi != null)?qi.getMethodName():null;
		}
		public String getQueryQueryName() {
			QueryInfo qi = (QueryInfo)queryMap.get("data_query");
			return (qi != null)?qi.getQueryName():null;
		}
		public String getQueryQuerySql() {
			QueryInfo qi = (QueryInfo)queryMap.get("data_query");
			return (qi != null)?qi.getQuerySql():null;
		}
		public String getQueryQueryType() {
			QueryInfo qi = (QueryInfo)queryMap.get("data_query");
			return (qi != null)?qi.getQueryType():null;
		}
		
		public String getQueryOrderby(){
			QueryInfo qi = (QueryInfo)queryMap.get("data_query");
			return (qi != null)?qi.getOrderby():null;
		}
		
	}

	public List getFields() {
		return fields;
	}
	
	public void setFields(String name,String format,String formattype,String covertvalue,String titlename,String style,String dbname) {
		if (fields == null){
			fields = new ArrayList();
		}
		fields.add(this.new FieldInfo(name,format,formattype,covertvalue,titlename,style,dbname));
	}
	public String getEndtitle() {
		return endtitle;
	}
	public void setEndtitle(String endtitle) {
		this.endtitle = endtitle;
	}
	public String getHeadtitle() {
		return headtitle;
	}
	public void setHeadtitle(String headtitle) {
		this.headtitle = headtitle;
	}
	public DelegateInfo getDelegateInfo() {
		return delegateInfo;
	}
//	public void setDelegateInfo(String delegateClass,String methodType,String queryMethodName,String countMethodName,String queryType,String queryName,String querySql) {
//		this.delegateInfo = new DelegateInfo(delegateClass,methodType,queryMethodName,countMethodName,queryType,queryName,querySql);
//	}
	public String getShowCount() {
		return showCount;
	}
	public void setShowCount(String showCount) {
		this.showCount = showCount;
	}
	public List<String> getTitleList() {
		return titleList;
	}
	public void setTitleList(String titleName) {
		if (titleList == null){
			titleList = new ArrayList<String>();
		}
		titleList.add(titleName);
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public String getAfterwrite() {
		return afterwrite;
	}
	public void setAfterwrite(String afterwrite) {
		this.afterwrite = afterwrite;
	}
	public String getBeforewrite() {
		return beforewrite;
	}
	public void setBeforewrite(String beforewrite) {
		this.beforewrite = beforewrite;
	}
	public String getTableorview() {
		return tableorview;
	}
	public void setTableorview(String tableorview) {
		this.tableorview = tableorview;
	}
	
}

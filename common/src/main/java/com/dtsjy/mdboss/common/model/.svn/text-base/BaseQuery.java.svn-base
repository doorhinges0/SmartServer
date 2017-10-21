package com.dtsjy.mdboss.common.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;


public class BaseQuery {
	private Integer pageNo = 0; // 第一页
	private Integer pageSize = 0; // 每页n条记录
	private List<QueryCondition> queryCondition = new ArrayList<QueryCondition>();// 查询条件
	private String orderBy;// 排序
	private String keyword;//搜索关键字
	private List<String> keywordFields = new ArrayList<String>();//指定keyword模糊匹配哪些字段
	private String usercode;//用户编码，注意：不一定是登录用户
	private String type;//类型，冗余字段

	public BaseQuery addCondition(String key,String operate,Object v1,Object v2 ){
		queryCondition.add(new QueryCondition(key,operate,v1,v2));
		return this;
	}
	
	public  BaseQuery addCondition(String key,String operate,Object v1 ){
		return addCondition(key, operate, v1,null);
	}
	
	public BaseQuery addKeywordFields(String... fields){
		if (ArrayUtils.isNotEmpty(fields)){
			keywordFields.addAll(CollectionUtils.asList(fields));
		}
		
		return this;
	}
	
	public BaseQuery removeCondition(String key){
		List<QueryCondition> tmpList = new ArrayList<QueryCondition>();
		for (QueryCondition condition : queryCondition){
			if (condition.getKey().equals(key)){
				tmpList.add(condition);
			}
		}
		queryCondition.removeAll(tmpList);
		return this;
	}
	
	public BaseQuery removeCondition(String key,String operate){
		List<QueryCondition> tmpList = new ArrayList<QueryCondition>();
		for (QueryCondition condition : queryCondition){
			if (condition.getKey().equals(key) && condition.getOperate().equals(operate)){
				tmpList.add(condition);
			}
		}
		queryCondition.removeAll(tmpList);
		return this;
	}
	
	public BaseQuery removeCondition(String key,String operate,Object v1){
		List<QueryCondition> tmpList = new ArrayList<QueryCondition>();
		for (QueryCondition condition : queryCondition){
			if (condition.getKey().equals(key) && condition.getOperate().equals(operate) && condition.getV1().equals(v1)){
				tmpList.add(condition);
			}
		}
		queryCondition.removeAll(tmpList);
		return this;
	}
	
	public BaseQuery removeCondition(String key,String operate,Object v1,Object v2){
		List<QueryCondition> tmpList = new ArrayList<QueryCondition>();
		for (QueryCondition condition : queryCondition){
			if (condition.getKey().equals(key) && condition.getOperate().equals(operate) && condition.getV1().equals(v1) && condition.getV2().equals(v2)){
				tmpList.add(condition);
			}
		}
		queryCondition.removeAll(tmpList);
		return this;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<QueryCondition> getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(List<QueryCondition> queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<String> getKeywordFields() {
		return keywordFields;
	}
	public void setKeywordFields(List<String> keywordFields) {
		this.keywordFields = keywordFields;
	}
	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}

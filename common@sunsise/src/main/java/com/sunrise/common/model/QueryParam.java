package com.sunrise.common.model;

import java.util.ArrayList;
import java.util.List;

public class QueryParam {

	private int pageNo;
	private int pageSize;
	private String orderBy;
	private List<QueryCondition> queryCondition = new ArrayList<QueryCondition>();

	public int getPageNo() {
		return pageNo;
	}

	public List<QueryCondition> getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(List<QueryCondition> queryCondition) {
		this.queryCondition = queryCondition;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrederby() {
		return orderBy;
	}

	public void setOrederby(String orederby) {
		this.orderBy = orederby;
	}


	public void addCondition(String key,String operate,Object v1,Object v2 ){
		queryCondition.add(new QueryCondition(key,operate,v1,v2));
	}
	public  void addCondition(String key,String operate,Object v1 ){
		addCondition(key, operate, v1,null);
	}
	
	
	class QueryCondition{
		private String key;
		private String operate;
		private Object v1;
		private Object v2;
		
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
		
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orderBy == null) ? 0 : orderBy.hashCode());
		result = prime * result + pageNo;
		result = prime * result + pageSize;
		result = prime * result
				+ ((queryCondition == null) ? 0 : queryCondition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QueryParam other = (QueryParam) obj;
		if (orderBy == null) {
			if (other.orderBy != null)
				return false;
		} else if (!orderBy.equals(other.orderBy))
			return false;
		if (pageNo != other.pageNo)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (queryCondition == null) {
			if (other.queryCondition != null)
				return false;
		} else if (!queryCondition.equals(other.queryCondition))
			return false;
		return true;
	}
	
	
/*	public static void main(String[] args) {
		QueryParam param = new QueryParam();
		param.addCondition("a", QueryOperate.EQUAL_TO, 1,int.class);
		param.addCondition("b", QueryOperate.BETWEEN, 1, 2,int.class);
		param.addCondition("c", QueryOperate.LIKE, 1,int.class);
		param.setPageNo(2);
		param.setPageSize(10);
		
		System.out.println(JSON.toJSONString(param));
		
		String json = Message.getString("/jsondata.properties", "jsonString");
		System.out.println(json);
		
		QueryParam param2 = JSON.parseObject(json, param.getClass());
		System.out.println(param2.queryCondition.size());
		
		System.out.println(JSON.toJSONString(param2));
		
	}*/
}

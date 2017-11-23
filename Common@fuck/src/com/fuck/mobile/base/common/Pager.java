package com.fuck.mobile.base.common;

public class Pager {
	public static final int EXCEL_MAX_EXPORT_PAGESIZE = 100000;
	private int pageSize = 10;
	private int totalCount=0;
	private int currPageNo=0;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getCurrPageNo() {
		return currPageNo + "";
	}
	
	public int getCurrPageNoValue() {
		return currPageNo;
	}
	
	public void setCurrPageNo(String currPageNo) {
		try{
			this.currPageNo = Integer.parseInt(currPageNo.toString());
		}catch(Exception e){
			this.currPageNo = 0;
		}
	}
	
	public void setCheck(){
		int totalPages = getTotalCount()/ getPageSize() + (getTotalCount() % getPageSize() > 0 ? 1 : 0);

		if(getCurrPageNoValue()<0)
			setCurrPageNo("0") ;
		if(getCurrPageNoValue() >= totalPages)
			setCurrPageNo((totalPages-1) + "");
		
	}
}

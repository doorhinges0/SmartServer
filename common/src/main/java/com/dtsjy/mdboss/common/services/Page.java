package com.dtsjy.mdboss.common.services;

import org.apache.ibatis.session.RowBounds;

public class Page {

	public final static int DEFAULT_SIZE = 20;
	public final static int DEFAULT_NO = 1;

	private int pageNo;
	private int pageSize;

	public Page() {
		this.pageNo = DEFAULT_NO;
		this.pageSize = RowBounds.NO_ROW_LIMIT;
	}

	public Page(int pageNo, int pageSize) {
		if (pageNo > 0) {
			this.pageNo = pageNo;
		} else {
			this.pageNo = DEFAULT_NO;
		}
		if (pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = DEFAULT_SIZE;
		}
	}

	public int getPageNo() {
		return pageNo;
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

}

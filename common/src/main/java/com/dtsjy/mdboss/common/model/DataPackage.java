package com.dtsjy.mdboss.common.model;

import java.util.List;

public class DataPackage<VO> {
	private Integer pageSize;
	private Integer pageNo;
	private Long total;
	private List<VO> rows;

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<VO> getRows() {
		return rows;
	}

	public void setRows(List<VO> rows) {
		this.rows = rows;
	}

/*	public static void main(String[] args) {
		DataPackage<Date> dp = new DataPackage<Date>();
		dp.setPageNo(1);
		dp.setPageSize(0);
		dp.setTotal(0l);
		System.out.println(JSON.toJSONString(dp));
		JSONObject json = JsonResponseUtils.toJSONObject(dp);
		json.put("ext", 33);
		System.out.println(JsonResponseUtils.success(json));
	}*/
}

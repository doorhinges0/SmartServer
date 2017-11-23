package com.sunrise.common.model.config;

import java.util.List;

import com.sunrise.ucp.dal.gen.model.TableColumnConfigVO;

public interface TableConfigFacade {
//	public List<TableConfigVO> queryAllTableConfig();
//	public TableConfigVO queryOneTableConfig(String voName);
	public List<TableColumnConfigVO> queryTableConfigColumn(String voName, boolean setoncreate);
	public List<TableColumnConfigVO> queryTableConfigColumn(String voName,String cloumnType);
//	public List<TableColumnConfigVO> queryAllTableConfigColumn();
//	public TableColumnConfigVO queryOneTableConfigColumn(String voName,String voFieldName);
}

package com.dtsjy.mdboss.common.model.config;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dtsjy.mdboss.common.model.BaseQuery;
import com.dtsjy.mdboss.common.model.DataPackage;
import com.dtsjy.mdboss.common.model.SerialNoHolder;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.services.CommonService;
import com.dtsjy.mdboss.common.services.CommonServiceUtils;
import com.dtsjy.mdboss.common.services.QueryOperate;
import com.dtsjy.mdboss.common.utils.JsonResponseUtils;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.config.CommonConfig;
import com.dtsjy.mdboss.common.utils.dal.CommonDaoUtil;
import com.dtsjy.mdboss.ucp.dal.gen.dao.TableColumnConfigVOMapper;
import com.dtsjy.mdboss.ucp.dal.gen.dao.TableConfigVOMapper;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableColumnConfigVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableColumnConfigVOExample;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableConfigVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableConfigVOExample;

public class TableConfigFacadeImpl implements TableConfigFacade {

//	public List<TableConfigVO> queryAllTableConfig() {
//		TableConfigVOMapper dao = CommonDaoUtil.getDao(TableConfigVOMapper.class);
//		if (dao != null){
//			TableConfigVOExample example = new TableConfigVOExample();
//			return dao.selectByExample(example);
//		}else {
//			CommonService service = CommonServiceUtils.getUcpCommonService();
//			BaseQuery query = new BaseQuery();
//			String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), 
//					SerialNoHolder.userCode.get(), UcpModel.UCP_TABLE_CONFIG.value(), JSON.toJSONString(query));
//			DataPackage<TableConfigVO> dp = JsonResponseUtils.getPackageFormResponse(rsp, TableConfigVO.class);
//			return dp.getRows();
//		}
//	}

//	public TableConfigVO queryOneTableConfig(String voName) {
//		TableConfigVOMapper dao = CommonDaoUtil.getDao(TableConfigVOMapper.class);
//		if (dao != null){
//			TableConfigVOExample example = new TableConfigVOExample();
//			example.createCriteria().andVonameEqualTo(voName);
//			return CollectionUtils.getOneIfNoEmpty(dao.selectByExample(example));
//		}else {
//			CommonService service = CommonServiceUtils.getUcpCommonService();
//			BaseQuery query = new BaseQuery();
//			query.addCondition("voname", QueryOperate.EQUAL_TO, voName);
//			String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), 
//					SerialNoHolder.userCode.get(), UcpModel.UCP_TABLE_CONFIG.value(), JSON.toJSONString(query));
//			return JsonResponseUtils.getOneIfNotEmpty(rsp, TableConfigVO.class);
//		}
//	}
	
	public List<TableColumnConfigVO> queryTableConfigColumn(String voName,
			boolean setoncreate) {
		TableColumnConfigVOMapper dao = CommonDaoUtil.getDao(TableColumnConfigVOMapper.class);
		if (dao != null){
			TableColumnConfigVOExample example = new TableColumnConfigVOExample();
			example.createCriteria().andVonameEqualTo(voName).andSetoncreateEqualTo(setoncreate);
			return dao.selectByExample(example);
		}else {
			CommonService service = CommonServiceUtils.getUcpCommonService();
			BaseQuery query = new BaseQuery();
			query.addCondition("voname", QueryOperate.EQUAL_TO,voName)
				.addCondition("setoncreate", QueryOperate.EQUAL_TO, setoncreate);
			
			String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), 
					SerialNoHolder.userCode.get(), UcpModel.UCP_TABLE_COLUMN_CONFIG.value(), JSON.toJSONString(query));
			DataPackage<TableColumnConfigVO> dp = JsonResponseUtils.getPackageFormResponse(rsp, TableColumnConfigVO.class);
			return dp.getRows();
		}
	}

	public List<TableColumnConfigVO> queryTableConfigColumn(String voName,
			String columnType) {
		TableColumnConfigVOMapper dao = CommonDaoUtil.getDao(TableColumnConfigVOMapper.class);
		if (dao != null){
			TableColumnConfigVOExample example = new TableColumnConfigVOExample();
			example.createCriteria().andVonameEqualTo(voName).andColumntypeEqualTo(columnType);
			return dao.selectByExample(example);
		}else {
			CommonService service = CommonServiceUtils.getUcpCommonService();
			BaseQuery query = new BaseQuery();
			query.addCondition("voname", QueryOperate.EQUAL_TO,voName)
				.addCondition("columntype", QueryOperate.EQUAL_TO, columnType);
			
			String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), 
					SerialNoHolder.userCode.get(), UcpModel.UCP_TABLE_COLUMN_CONFIG.value(), JSON.toJSONString(query));
			DataPackage<TableColumnConfigVO> dp = JsonResponseUtils.getPackageFormResponse(rsp, TableColumnConfigVO.class);
			return dp.getRows();
		}
	}
	
	
//	public List<TableColumnConfigVO> queryAllTableConfigColumn() {
//		TableColumnConfigVOMapper dao = CommonDaoUtil.getDao(TableColumnConfigVOMapper.class);
//		if (dao != null){
//			TableColumnConfigVOExample example = new TableColumnConfigVOExample();
//			return dao.selectByExample(example);
//		}else {
//			CommonService service = CommonServiceUtils.getUcpCommonService();
//			BaseQuery query = new BaseQuery();
//			String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(), 
//					SerialNoHolder.userCode.get(), UcpModel.UCP_TABLE_COLUMN_CONFIG.value(), JSON.toJSONString(query));
//			DataPackage<TableColumnConfigVO> dp = JsonResponseUtils.getPackageFormResponse(rsp, TableColumnConfigVO.class);
//			return dp.getRows();
//		}
//	}
	
//	public TableColumnConfigVO queryOneTableConfigColumn(String voName,
//			String voFieldName) {
//		TableColumnConfigVOMapper dao = CommonDaoUtil.getDao(TableColumnConfigVOMapper.class);
//		if (dao != null){
//			TableColumnConfigVOExample example = new TableColumnConfigVOExample();
//			example.createCriteria().andVonameEqualTo(voName).andVofieldnameEqualTo(voFieldName);
//			return CollectionUtils.getOneIfNoEmpty( dao.selectByExample(example));
//		}else {
//			CommonService service = CommonServiceUtils.getUcpCommonService();
//			BaseQuery param = new BaseQuery();
//			param.addCondition("voname", QueryOperate.EQUAL_TO,voName);
//			param.addCondition("vofieldname", QueryOperate.EQUAL_TO,voFieldName);
//			String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(),
//					SerialNoHolder.userCode.get(), UcpModel.UCP_TABLE_COLUMN_CONFIG.value(), JSON.toJSONString(param));
//			
//			return JsonResponseUtils.getOneIfNotEmpty(rsp, TableColumnConfigVO.class);
//		}
//	}
}

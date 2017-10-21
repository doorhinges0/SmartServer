package com.dtsjy.mdboss.common.model.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.alibaba.fastjson.JSON;
import com.dtsjy.mdboss.common.dal.gen.model.SysParamVO;
import com.dtsjy.mdboss.common.model.BaseQuery;
import com.dtsjy.mdboss.common.model.DataPackage;
import com.dtsjy.mdboss.common.model.SerialNoHolder;
import com.dtsjy.mdboss.common.model.code2name.Code2NameUtil;
import com.dtsjy.mdboss.common.model.constants.CommonModel;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.services.CommonService;
import com.dtsjy.mdboss.common.services.CommonServiceUtils;
import com.dtsjy.mdboss.common.services.QueryOperate;
import com.dtsjy.mdboss.common.utils.JsonResponseUtils;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.config.CommonConfig;
import com.dtsjy.mdboss.common.utils.dal.CommonDaoUtil;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;
import com.dtsjy.mdboss.ucp.dal.gen.dao.DictItemVOMapper;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;

public class CommonConfigFacadeImpl implements CommonConfigFacade {

	public DictItemVO getDictItem(String definition, String dictCode) {
		DictItemVO item = null;
		DictItemVOMapper dao = CommonDaoUtil.getDao(DictItemVOMapper.class);
		if (dao != null){
			item = CommonDaoUtil.getDictItem(definition, dictCode);
		}else {
			CommonService service = CommonServiceUtils.getUcpCommonService();
			BaseQuery param = new BaseQuery();
			param.addCondition("groupcode", QueryOperate.EQUAL_TO, definition);
			param.addCondition("dictcode", QueryOperate.EQUAL_TO, dictCode);
			param.addCondition("dictstate", QueryOperate.EQUAL_TO,
					CommonModel.ENABLE);
			String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(),
					SerialNoHolder.userCode.get(), UcpModel.UCP_DICT_ITEM.value(), JSON.toJSONString(param));
			DataPackage<DictItemVO> dp = JsonResponseUtils.getPackageFormResponse(
					rsp, DictItemVO.class);
			if (JsonResponseUtils.isNotEmptyDP(dp)){
				item = dp.getRows().get(0);
			}
		}
		return item;
	}

	public List<DictItemVO> getDictItems(String definition, String keyword) {
		if (StringToolkit.isEmpty(definition)){
			return null;
		}
		DictItemVOMapper dao = CommonDaoUtil.getDao(DictItemVOMapper.class);
		if (dao != null){
			return CommonDaoUtil.getDictItems(definition, keyword);
		}else {
			CommonService service = CommonServiceUtils.getUcpCommonService();
			BaseQuery param = new BaseQuery();
			param.addCondition("groupcode", QueryOperate.EQUAL_TO, definition);
			param.addCondition("dictstate", QueryOperate.EQUAL_TO,
					CommonModel.ENABLE);
			if (StringToolkit.isNotEmpty(keyword)){
				param.addCondition("dictname", QueryOperate.LIKE, keyword);
			}
			param.setOrderBy("dictorder");
			String rsp = service.selectByExample(SerialNoHolder.appcode.get(), SerialNoHolder.serialNo.get(),
					SerialNoHolder.userCode.get(), UcpModel.UCP_DICT_ITEM.value(), JSON.toJSONString(param));
			DataPackage<DictItemVO> dp = JsonResponseUtils.getPackageFormResponse(
					rsp, DictItemVO.class);
			return dp.getRows();
		}
	}

	public List<DictItemVO> getAppDictItems(String definition, String appCode,
			String keyword) {
		if (StringToolkit.isEmpty(definition)){
			return null;
		}
		
		if (definition.startsWith("#")){
			List<DictItemVO> dictItems = new ArrayList<DictItemVO>();
			Map<String, String> map = CommonServiceUtils.appCode2NameValueListWithCondition(appCode, definition,keyword, CommonConfig.getEnvUserCode());
			if (MapUtils.isNotEmpty(map)){
				for (String code : map.keySet()) {
					DictItemVO vo = new DictItemVO();
					vo.setDictcode(code);
					vo.setDictname(map.get(code));
					dictItems.add(vo);
				}
			}
			return dictItems;
		}else {
			if (definition.startsWith("$")){
				definition = definition.substring(1);
			}
			return getDictItems(definition, keyword);
		}
	}

	public String getUCPParamValue(String paramCode, String appCode) {
		SysParamVO param = getUCPSysParam(paramCode, appCode);
		return null != param ? param.getValue() : null;
	}

	public SysParamVO getUCPSysParam(String paramCode, String appCode) {
		SysParamVO param = null;
		try {
			if (StringToolkit.isNotEmpty(paramCode) && StringToolkit.isNotEmpty(appCode)){
//				SysParamVOMapper dao  = CommonDaoUtil.getDao(SysParamVOMapper.class);
//				if (null != dao){
//					SysParamVOExample example = new SysParamVOExample();
//					example.createCriteria().andParamcodeEqualTo(paramCode).andAppcodeEqualTo(appCode);
//					param = CollectionUtils.getOneIfNoEmpty(dao.selectByExample(example));
//				}else {
					CommonService service = CommonServiceUtils.getUcpCommonService();
					
					BaseQuery query = new BaseQuery();
					query.addCondition("paramcode", QueryOperate.EQUAL_TO, paramCode);
					query.addCondition("appcode", QueryOperate.EQUAL_TO, appCode);
					String rsp = service.selectByExample(CommonConfig.getEnvAppCode(), CommonConfig.getEnvSerialNo(),
							CommonConfig.getEnvUserCode(), CommonModel.COMMON_SYS_PARAM.value(), JSON.toJSONString(query));
					param = JsonResponseUtils.getOneIfNotEmpty(rsp, SysParamVO.class);
//				}
			}
		} catch (Exception e) {
			//do nothing
		}
		
		return param;
	}
	
}

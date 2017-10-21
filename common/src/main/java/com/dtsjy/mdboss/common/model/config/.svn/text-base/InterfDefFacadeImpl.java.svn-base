package com.dtsjy.mdboss.common.model.config;

import java.util.List;

import com.dtsjy.mdboss.common.model.BaseQuery;
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
import com.dtsjy.mdboss.common.utils.json.JsonUtil;
import com.dtsjy.mdboss.ucp.dal.gen.dao.InterfdefVOMapper;
import com.dtsjy.mdboss.ucp.dal.gen.model.InterfdefVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.InterfdefVOExample;

public class InterfDefFacadeImpl implements InterfDefFacade {

	public InterfdefVO getInterDef(String appCode, String interClass,
			String methodName) {
		InterfdefVOMapper dao = CommonDaoUtil.getDao(InterfdefVOMapper.class);
		if (dao != null){
			InterfdefVOExample example = new InterfdefVOExample();
			example.createCriteria().andAppcodeEqualTo(appCode).andInterfclassEqualTo(interClass).andMethodnameEqualTo(methodName);
			return CollectionUtils.getOneIfNoEmpty(dao.selectByExample(example));
		}else {
			CommonService service = CommonServiceUtils.getUcpCommonService();
			BaseQuery query = new BaseQuery();
			query.addCondition("appcode", QueryOperate.EQUAL_TO, appCode);
			query.addCondition("interfclass", QueryOperate.EQUAL_TO, interClass);
			query.addCondition("methodname", QueryOperate.EQUAL_TO, methodName);
			String rsp = service.selectByExample(SerialNoHolder.appcode.get(),SerialNoHolder.serialNo.get(), 
					SerialNoHolder.userCode.get(), UcpModel.UCP_INTERFDEF.value(), JsonUtil.toJSonWithDate(query));
			
			return JsonResponseUtils.getOneIfNotEmpty(rsp, InterfdefVO.class);
		}
	}

	public void createInterDef(InterfdefVO interfDef) {
		if (null == interfDef){
			return ;
		}
		InterfdefVOMapper dao = CommonDaoUtil.getDao(InterfdefVOMapper.class);
		if (dao != null){
			dao.insert(interfDef);
		}else {
			CommonService service = CommonServiceUtils.getUcpCommonService();
			service.insertSelective(SerialNoHolder.appcode.get(),SerialNoHolder.serialNo.get(), 
					SerialNoHolder.userCode.get(), UcpModel.UCP_INTERFDEF.value(), JsonUtil.toJSonWithDate(interfDef));
		}
		
	}
	
}

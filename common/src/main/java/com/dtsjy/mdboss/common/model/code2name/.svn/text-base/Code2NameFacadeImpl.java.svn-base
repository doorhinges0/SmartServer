package com.dtsjy.mdboss.common.model.code2name;

import java.util.List;
import java.util.Map;

import com.dtsjy.mdboss.common.model.SerialNoHolder;
import com.dtsjy.mdboss.common.model.config.CommonConfigFacade;
import com.dtsjy.mdboss.common.model.constants.CmModel;
import com.dtsjy.mdboss.common.model.constants.FspModel;
import com.dtsjy.mdboss.common.model.constants.HRModel;
import com.dtsjy.mdboss.common.model.constants.OAModel;
import com.dtsjy.mdboss.common.model.constants.PMModel;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.model.constants.WfsModel;
import com.dtsjy.mdboss.common.services.CommonServiceUtils;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.config.CommonConfig;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;

public class Code2NameFacadeImpl implements Code2NameFacade {

	public String appCode2Name(String app, String definition, String codeValue,
			String userCode) {
		String name = null;
		if (UcpModel.APP_CODE.value().equalsIgnoreCase(app)) {
			name = ucpCode2Name(definition, codeValue, userCode);
		} else if (FspModel.APP_CODE.value().equalsIgnoreCase(app)) {
			name = fspCode2Name(definition, codeValue, userCode);
		} else if (WfsModel.APP_CODE.value().equalsIgnoreCase(app)) {
			name = wfsCode2Name(definition, codeValue, userCode);
		} else if (PMModel.APP_CODE.value().equalsIgnoreCase(app)) {
			name = pmCode2Name(definition, codeValue, userCode);
		} else if (CmModel.APP_CODE.value().equalsIgnoreCase(app)) {
			name = cmCode2Name(definition, codeValue, userCode);
		} else {
			name = ucpCode2Name(definition, codeValue, userCode);
		}

		return name;
	}

	public Map appCode2NameValueList(String app, String definition,
			String userCode) {
		Map<String, String> ret = null;
		if (UcpModel.APP_CODE.value().equalsIgnoreCase(app)) {
			ret = ucpCode2NameValueList(definition, userCode);
		} else if (FspModel.APP_CODE.value().equalsIgnoreCase(app)) {
			ret = fspCode2NameValueList(definition, userCode);
		} else if (WfsModel.APP_CODE.value().equalsIgnoreCase(app)) {
			ret = wfsCode2NameValueList(definition, userCode);
		} else if (PMModel.APP_CODE.value().equalsIgnoreCase(app)) {
			ret = pmCode2NameValueList(definition, userCode);
		} else if (HRModel.APP_CODE.value().equalsIgnoreCase(app)) {
			ret = hrCode2NameValueList(definition, userCode);
		} else if (OAModel.APP_CODE.value().equalsIgnoreCase(app)) {
			ret = oaCode2NameValueList(definition, userCode);
		} else if (CmModel.APP_CODE.value().equalsIgnoreCase(app)) {
			ret = cmCode2NameValueList(definition, userCode);
		} else {
			ret = ucpCode2NameValueList(definition, userCode);
		}

		return ret;
	}

	public Map appCode2NameValueListWithCondition(String app,
			String definition, String condition, String userCode) {
		if (UcpModel.APP_CODE.value().equalsIgnoreCase(app)) {
			return ucpCode2NameValueList(definition, condition, userCode);
		} else if (FspModel.APP_CODE.value().equalsIgnoreCase(app)) {
			return fspCode2NameValueList(definition, condition, userCode);
		} else if (WfsModel.APP_CODE.value().equalsIgnoreCase(app)) {
			return wfsCode2NameValueList(definition, condition, userCode);
		} else if (PMModel.APP_CODE.value().equalsIgnoreCase(app)) {
			return pmCode2NameValueList(definition, condition, userCode);
		} else if (HRModel.APP_CODE.value().equalsIgnoreCase(app)) {
			return hrCode2NameValueList(definition, condition, userCode);
		} else if (OAModel.APP_CODE.value().equalsIgnoreCase(app)) {
			return oaCode2NameValueList(definition, condition, userCode);
		} else if (CmModel.APP_CODE.value().equalsIgnoreCase(app)) {
			return cmCode2NameValueList(definition, condition, userCode);
		} else {
			return ucpCode2NameValueList(definition, condition, userCode);
		}
	}

	private String ucpCode2Name(String definition, String codeValue,
			String userCode) {
		return CommonServiceUtils.getUcpCommonService().code2Name("code2Name",
				SerialNoHolder.serialNo.get(), userCode, definition, codeValue,
				userCode);
	}

	private Map ucpCode2NameValueList(String definition, String userCode) {
		return CommonServiceUtils.getUcpCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, userCode);
	}

	private Map ucpCode2NameValueList(String definition, String condition,
			String userCode) {
		return CommonServiceUtils.getUcpCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, condition, userCode);
	}

	private String pmCode2Name(String definition, String codeValue,
			String userCode) {
		return CommonServiceUtils.getPMCommonService().code2Name("code2Name",
				SerialNoHolder.serialNo.get(), userCode, definition, codeValue,
				userCode);
	}

	private Map pmCode2NameValueList(String definition, String userCode) {
		return CommonServiceUtils.getPMCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, userCode);
	}

	private Map pmCode2NameValueList(String definition, String condition,
			String userCode) {
		return CommonServiceUtils.getPMCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, condition, userCode);
	}

	private String wfsCode2Name(String definition, String codeValue,
			String userCode) {
		return CommonServiceUtils.getWfsCommonService().code2Name("code2Name",
				SerialNoHolder.serialNo.get(), userCode, definition, codeValue,
				userCode);
	}

	private Map wfsCode2NameValueList(String definition, String userCode) {
		return CommonServiceUtils.getWfsCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, userCode);
	}

	private Map wfsCode2NameValueList(String definition, String condition,
			String userCode) {
		return CommonServiceUtils.getWfsCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, condition, userCode);
	}

	private String fspCode2Name(String definition, String codeValue,
			String userCode) {
		return CommonServiceUtils.getFspCommonService().code2Name("code2Name",
				SerialNoHolder.serialNo.get(), userCode, definition, codeValue,
				userCode);
	}

	private Map fspCode2NameValueList(String definition, String userCode) {
		return CommonServiceUtils.getFspCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, userCode);
	}

	private Map fspCode2NameValueList(String definition, String condition,
			String userCode) {
		return CommonServiceUtils.getFspCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, condition, userCode);
	}

	private String hrCode2Name(String definition, String codeValue,
			String userCode) {
		return CommonServiceUtils.getHrCommonService().code2Name("code2Name",
				SerialNoHolder.serialNo.get(), userCode, definition, codeValue,
				userCode);
	}

	private Map hrCode2NameValueList(String definition, String userCode) {
		return CommonServiceUtils.getHrCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, userCode);
	}

	private Map hrCode2NameValueList(String definition, String condition,
			String userCode) {
		return CommonServiceUtils.getHrCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, condition, userCode);
	}

	private String cmsCode2Name(String definition, String codeValue,
			String userCode) {
		return CommonServiceUtils.getCmsCommonService().code2Name("code2Name",
				SerialNoHolder.serialNo.get(), userCode, definition, codeValue,
				userCode);
	}

	private Map cmsCode2NameValueList(String definition, String userCode) {
		return CommonServiceUtils.getCmsCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, userCode);
	}

	private Map cmsCode2NameValueList(String definition, String condition,
			String userCode) {
		return CommonServiceUtils.getCmsCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, condition, userCode);
	}

	private String oaCode2Name(String definition, String codeValue,
			String userCode) {
		return CommonServiceUtils.getOACommonService().code2Name("code2Name",
				SerialNoHolder.serialNo.get(), userCode, definition, codeValue,
				userCode);
	}

	private Map oaCode2NameValueList(String definition, String userCode) {
		return CommonServiceUtils.getOACommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, userCode);
	}

	private Map oaCode2NameValueList(String definition, String condition,
			String userCode) {
		return CommonServiceUtils.getOACommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, condition, userCode);
	}
	
	private String cmCode2Name(String definition, String codeValue,
			String userCode) {
		return CommonServiceUtils.getCmCommonService().code2Name("code2Name",
				SerialNoHolder.serialNo.get(), userCode, definition, codeValue,
				userCode);
	}

	private Map cmCode2NameValueList(String definition, String userCode) {
		return CommonServiceUtils.getCmCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, userCode);
	}

	private Map cmCode2NameValueList(String definition, String condition,
			String userCode) {
		return CommonServiceUtils.getCmCommonService().getCode2NameValueList(
				"code2Name", SerialNoHolder.serialNo.get(), userCode,
				definition, condition, userCode);
	}
	
}

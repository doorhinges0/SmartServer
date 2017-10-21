package com.dtsjy.mdboss.common.model.config;

import java.util.List;

import com.dtsjy.mdboss.common.dal.gen.model.SysParamVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;

public interface CommonConfigFacade {
	DictItemVO getDictItem(String definition, String dictCode);
	List<DictItemVO> getDictItems(String definition,String keyword);
	List<DictItemVO> getAppDictItems(String definition,String appCode,String keyword);
	String getUCPParamValue(String paramCode,String appCode);
	SysParamVO getUCPSysParam(String paramCode,String appCode);
}

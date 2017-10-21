package com.dtsjy.mdboss.common.model.config;

import com.dtsjy.mdboss.ucp.dal.gen.model.InterfdefVO;

public interface InterfDefFacade {
	InterfdefVO getInterDef(String appCode,String interClass,String methodName);
	void createInterDef(InterfdefVO interfDef);
}

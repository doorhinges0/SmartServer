package com.sunrise.common.model.config;

import com.sunrise.ucp.dal.gen.model.InterfdefVO;

public interface InterfDefFacade {
	InterfdefVO getInterDef(String appCode,String interClass,String methodName);
	void createInterDef(InterfdefVO interfDef);
}

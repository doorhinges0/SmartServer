package com.sunrise.common.model.code2name;

import java.util.Map;
public interface Code2NameFacade{
	 String appCode2Name(String app,String definition,String codeValue,String userCode);
	 Map appCode2NameValueList(String app,String definition,String userCode);
	 Map appCode2NameValueListWithCondition(String app,String definition,String condition,String userCode);
}

package com.sunrise.common.export;

import java.util.Map;

public interface ExportParamConverter {
	public String convertParam(String paramName,String value);
	public String convertParamName(String paramName,String value);
	public Map<String,Object> adjustParams(Map<String,Object> params);
}

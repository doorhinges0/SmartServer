package com.dtsjy.mdboss.common.model.tableconfig;

import com.dtsjy.mdboss.common.utils.json.JsonUtil;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class TableExtColumnManager {
	public static Object getValue(Object vo,String ruleJson){
		if (StringToolkit.isEmpty(ruleJson)){
			return null;
		}
		
		String  type = JsonUtil.getPropertyOfJson(ruleJson, "valuesource.type", String.class);
		TableExtColumnHandler handler = getColumnHandler(type);
		
		return handler.getValue(vo, ruleJson);
	}
	
	private static TableExtColumnHandler getColumnHandler(String type){
		if (StringToolkit.isNotEmpty(type)){
			if (type.equals("code2name")){
				return new Code2NameTableExtColumnHandler();
			}else if (type.equals("literal")){
				return new LiteralTableExtColumnHandler();
			}
		}
		
		return new DefaultTableExtColumnHandler();
	}
}

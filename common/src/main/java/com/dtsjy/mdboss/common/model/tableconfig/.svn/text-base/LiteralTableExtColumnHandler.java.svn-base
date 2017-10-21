package com.dtsjy.mdboss.common.model.tableconfig;

import com.dtsjy.mdboss.common.utils.json.JsonUtil;

public class LiteralTableExtColumnHandler implements TableExtColumnHandler {

	public Object getValue(Object vo, String ruleJson) {
		return JsonUtil.getPropertyOfJson(ruleJson, "valuesource", String.class);
	}

}

package com.sunrise.common.model.tableconfig;

import com.sunrise.common.utils.json.JsonUtil;

public class LiteralTableExtColumnHandler implements TableExtColumnHandler {

	public Object getValue(Object vo, String ruleJson) {
		return JsonUtil.getPropertyOfJson(ruleJson, "valuesource", String.class);
	}

}

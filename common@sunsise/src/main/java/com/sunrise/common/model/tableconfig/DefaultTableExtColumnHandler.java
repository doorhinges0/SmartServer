package com.sunrise.common.model.tableconfig;

public class DefaultTableExtColumnHandler implements TableExtColumnHandler {

	public Object getValue(Object vo, String ruleJson) {
		return new LiteralTableExtColumnHandler().getValue(vo, ruleJson);
	}
}

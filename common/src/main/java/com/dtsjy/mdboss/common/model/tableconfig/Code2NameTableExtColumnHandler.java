package com.dtsjy.mdboss.common.model.tableconfig;

import com.dtsjy.mdboss.common.model.SerialNoHolder;
import com.dtsjy.mdboss.common.services.CommonServiceUtils;
import com.dtsjy.mdboss.common.utils.bean.BeanUtils;
import com.dtsjy.mdboss.common.utils.json.JsonUtil;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class Code2NameTableExtColumnHandler implements TableExtColumnHandler{
	public Object getValue(Object vo, String ruleJson) {
		String  definition = JsonUtil.getPropertyOfJson(ruleJson, "valuesource.context.definition", String.class);
		String basefield = JsonUtil.getPropertyOfJson(ruleJson, "valuesource.context.basefield", String.class);
		String appCode = JsonUtil.getPropertyOfJson(ruleJson, "valuesource.context.appcode", String.class);
		if (StringToolkit.isNotEmpty(definition) && StringToolkit.isNotEmpty(basefield)){
			String code = StringToolkit.getObjectString(BeanUtils.getProperty(vo, basefield));
			return CommonServiceUtils.appCode2Name(appCode, definition, code, SerialNoHolder.userCode.get());
		}
		
		return null;
	}
}

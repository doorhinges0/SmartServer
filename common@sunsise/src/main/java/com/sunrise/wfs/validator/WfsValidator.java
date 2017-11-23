package com.sunrise.wfs.validator;

import com.sunrise.common.validate.BaseValidator;
import hbm.jsonvalidate.ValidateRule;
import hbm.jsonvalidate.ValidateSet;

@ValidateSet(rules={
		@ValidateRule(attr = "usercode", methods = "notEmpty", message = "用户编码不能为空！"),
		@ValidateRule(attr = "processcode", methods = "notEmpty", message = "流程编码不能为空！")
	})
public class WfsValidator extends BaseValidator {

}

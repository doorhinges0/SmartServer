package com.sunrise.ucp.validator;

import com.sunrise.common.validate.BaseValidator;
import hbm.jsonvalidate.ValidateRule;
import hbm.jsonvalidate.ValidateSet;

@ValidateSet(rules={
		@ValidateRule(attr = "usercode", methods = "notEmpty", message = "用户编码不能为空！")
	})
public class UcpValidator extends BaseValidator {

}

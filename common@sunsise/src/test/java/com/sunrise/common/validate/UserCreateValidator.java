package com.sunrise.common.validate;

import hbm.jsonvalidate.ValidateRule;
import hbm.jsonvalidate.ValidateSet;


/**
 * 
    attr：   json的属性，可用'.'来代表层次关系。
    methods：多个校验方法（','分隔），返回值必须为Boolean。
    message：校验不通过时返回的信息。   TODO :后续做国际化处理
 * 
 *  
 *
 */

@ValidateSet(rules = {
		@ValidateRule(attr = "name.firstName", methods = "notNull", message = "名字不能为空"),
		@ValidateRule(attr = "name.lastName", methods = "notNull", message = "姓不能为空"),
		@ValidateRule(attr = "phone", methods = "notNull", message = "手机号码不能为空"),
		@ValidateRule(attr = "age", methods = "notNull,adultCheck", message = "你不是成年人") })
public class UserCreateValidator extends BaseValidator {

	// 基类里面没有的方法，自定义实现
	public boolean adultCheck(Integer value) {
		if (value != null && value >= 18) {
			return true;
		} else {
			return false;
		}
	}
}

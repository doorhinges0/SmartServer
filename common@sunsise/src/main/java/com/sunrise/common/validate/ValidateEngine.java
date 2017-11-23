package com.sunrise.common.validate;

import hbm.jsonvalidate.ValidateException;
import hbm.jsonvalidate.Validator;

public interface ValidateEngine {
	public void verify(Object content, Validator validator)
			throws ValidateException;
}

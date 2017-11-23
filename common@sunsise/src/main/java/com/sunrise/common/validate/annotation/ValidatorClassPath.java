package com.sunrise.common.validate.annotation;

import hbm.jsonvalidate.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface ValidatorClassPath {
	Class<? extends Validator> validator();
	int chkInputPath() default 3;
	String dataType() default "json";//指定把待校验的入参当作json字符串或直接对象；默认为json串，当入参为非json格式时，需指定为 literal.
}

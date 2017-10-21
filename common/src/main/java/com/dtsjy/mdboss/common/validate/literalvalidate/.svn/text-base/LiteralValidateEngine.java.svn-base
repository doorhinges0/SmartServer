package com.dtsjy.mdboss.common.validate.literalvalidate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hbm.jsonvalidate.ValidateException;
import hbm.jsonvalidate.ValidateRule;
import hbm.jsonvalidate.ValidateSet;
import hbm.jsonvalidate.Validator;

import com.dtsjy.mdboss.common.utils.bean.BeanUtils;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;
import com.dtsjy.mdboss.common.validate.ValidateEngine;

public class LiteralValidateEngine implements ValidateEngine {

	public void verify(Object content, Validator validator)
			throws ValidateException {

		ValidateSet validateSet = findAnnotation(validator.getClass(),ValidateSet.class);
		
		ValidateRule[] rules = new ValidateRule[]{};
		if (null != validateSet){
			rules = validateSet.rules();
		}
			

		/* 生成方法Map */
		Method[] ms = validator.getClass().getMethods();
		HashMap<String, Method> map = new HashMap<String, Method>();
		for (Method m : ms) {
			map.put(m.getName(), m);
		}

		// 用于保存校验失败信息
		List<String> errorList = new ArrayList<String>();
		for (ValidateRule rule : rules) {
			String context = rule.context();
			String[] validateMethodNames = getValidateMethods(rule.methods());
			for (String vMethod : validateMethodNames) {
				String message = null;
				try {

					Method method = map.get(vMethod);
					if (method == null) {
						message = "can't find validate method:"
								+ rule.methods();
					} else {

						Object value = getValueByAttr(rule.attr(), content);
						Boolean pass = (Boolean) method
								.invoke(validator, value,context);
						if (!pass) {
							message = rule.message();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					message = rule.message();
				}
				if (message != null) {
					errorList.add(message);
				}
			}
		}

		if (errorList.size() > 0) {
			throw new ValidateException(errorList);
		}

	}

		private static String[] getValidateMethods(String methodsStr) {
			if (methodsStr.contains(",")) {
				return methodsStr.split(",");
			} else {
				return new String[] { methodsStr };
			}
		}

		// 根据表达式获取具体值
		private static Object getValueByAttr(String expression, Object obj) {
			if (StringToolkit.isEmpty(expression)){
				return obj;
			}
			try {
				if (expression.contains(".")) {// 处理多层嵌套
					String[] keys = expression.split("\\.");
					Object tmp = obj;
					int length = keys.length;
					for (int i = 0; i < length; i++) {
						if (i == length - 1) {
							return BeanUtils.getProperty(tmp, keys[i]);
						} else {
							tmp = BeanUtils.getProperty(tmp, keys[i]);
						}
					}
					return null;// 出现这个情况说明有问题
				} else {
					return BeanUtils.getProperty(obj,expression);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} 
			
		}

		/**
		 * 从查找指定类的注解，如果不存在，则搜索其父类的注解，直至第一次找到
		 * @param clz
		 * @param annotationClass
		 * @author livan.c
		 * @return
		 */
		private static <A extends Annotation> A findAnnotation(Class<?> clz,Class<A> annotationClass){
			A annotation =  clz.getAnnotation(annotationClass);
			return annotation != null ? annotation : findAnnotation(clz.getSuperclass(), annotationClass);
		}

}

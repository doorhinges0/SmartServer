package com.sunrise.common.validate;

import hbm.jsonvalidate.JsonValidateEngine;
import hbm.jsonvalidate.ValidateException;
import hbm.jsonvalidate.Validator;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class TestValidate {
	public static void main(String[] args) {
		// 可以从spring容器里面get bean出来。
		UserCreateValidator validator = new UserCreateValidator();

		examplePass(validator);

		exampleNotPass(validator);
	}

	// 验证通过示例
	public static void examplePass(Validator validator) {
		JSONObject name = new JSONObject();
		name.put("firstName", "baiming");
		name.put("lastName", "huang");
		
		JSONObject json = new JSONObject();
		json.put("age", 34);
		json.put("name", name);
		json.put("phone", "13751838588");

		warp(validator, json);
	}

	// 验证不通过示例
	public static void exampleNotPass(Validator validator) {
		JSONObject name = new JSONObject();
		name.put("firstName", "yijun");
		
		JSONObject json = new JSONObject();
		json.put("age", 2);
		json.put("name", name);

		warp(validator, json);
	}

	private static void warp(Validator validator, JSONObject json) {
		try {
			JsonValidateEngine.verify(json, validator);
		} catch (ValidateException e) {
			List<String> errors = e.getErrorList();
			System.out.println(json + " 校验不通过：");
			for (String err : errors) {
				System.out.println(err);
			}
			System.out.println("--------------");
			return;
		}
		System.out.println(json + " 校验通过.");
		System.out.println("--------------");
	}
}

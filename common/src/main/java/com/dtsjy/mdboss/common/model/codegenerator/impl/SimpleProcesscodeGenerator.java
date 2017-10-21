package com.dtsjy.mdboss.common.model.codegenerator.impl;

import java.util.UUID;

import com.dtsjy.mdboss.common.model.codegenerator.ProcesscodeGenerator;

public class SimpleProcesscodeGenerator implements ProcesscodeGenerator {
	
	public String genCode() {
		return UUID.randomUUID().toString();
	}
	
	public String genCode(String appcode, String tenant, String usercode,
			String jsonData) {
		return UUID.randomUUID().toString();
	}
}

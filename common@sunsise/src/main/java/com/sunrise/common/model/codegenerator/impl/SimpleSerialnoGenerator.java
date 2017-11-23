package com.sunrise.common.model.codegenerator.impl;

import java.util.UUID;

import com.sunrise.common.model.codegenerator.SerialnoGenerator;

public class SimpleSerialnoGenerator implements SerialnoGenerator {

	public String genCode(String appcode, String tenant, String usercode,
			String jsonData) {
		return UUID.randomUUID().toString();
	}

	public String genCode() {
		return UUID.randomUUID().toString();
	}

}

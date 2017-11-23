package com.sunrise.common.model.codegenerator;

public interface CodeGenerator {

	public String genCode(String appcode,String tenant,String usercode,String jsonData);
	
	public String genCode();
}

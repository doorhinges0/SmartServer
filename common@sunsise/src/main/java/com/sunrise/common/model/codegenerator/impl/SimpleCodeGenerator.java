package com.sunrise.common.model.codegenerator.impl;

import java.util.UUID;

import com.sunrise.common.model.codegenerator.CodeGenerator;
import com.sunrise.common.model.codegenerator.ObjectType;
import com.sunrise.common.model.constants.CommonModel;

public class SimpleCodeGenerator implements CodeGenerator {

	public String genCode(String appcode, String tenant, String usercode,
			String jsonData) {
		return UUID.randomUUID().toString();
	}

	public String genCode() {
		return UUID.randomUUID().toString();
	}
	
	public String genCode(ObjectType type) {
		String code = UUID.randomUUID().toString();
		if (type.equals(ObjectType.USERGROUP)){
			code = CommonModel.PREFIX_GROUPCODE.value() + code;
		}else if (type.equals(ObjectType.PROJECT)){
			code = CommonModel.PREFIX_PROJECTCODE.value() + code;
		}else if (type.equals(ObjectType.ORG)){
			code = CommonModel.PREFIX_ORGCODE.value() + code;
		}else if (type.equals(ObjectType.ROLE)){
			code = CommonModel.PREFIX_ROLECODE.value() + code;
		}else if (type.equals(ObjectType.USER)){
			code = CommonModel.PREFIX_USRCODE.value() + code;
		}else if (type.equals(ObjectType.FORM)){
			code = CommonModel.PREFIX_FORMCODE.value() + code;
		}else if (type.equals(ObjectType.TASK)){
			code = CommonModel.PREFIX_TASKCODE.value() + code;
		}else if (type.equals(ObjectType.PROJECTROLE)){
			code = CommonModel.PREFIX_PROJECTROLE.value() + code;
		}else if (type.equals(ObjectType.SPECIALTYTEMPLATE)){
			code = CommonModel.PREFIX_SPECIALTYTEMPLATE.value() + code;
		}else if (type.equals(ObjectType.QRCODE)){
			code = CommonModel.PREFIX_QRCODE.value() + code;
		}else if (type.equals(ObjectType.PROJECTPHASE)){
			code = CommonModel.PREFIX_PROJECTPHASECODE.value() + code;
		}else if (type.equals(ObjectType.RMISSUE)){
			code = CommonModel.PREFIX_RMISSUECODE.value() + code;
		}else if (type.equals(ObjectType.PORJECTTEMPLATE)){
			code = CommonModel.PREFIX_PROJECTTEMPLATE.value() + code;
		}else if (type.equals(ObjectType.VOTE)) {
			code = CommonModel.PREFIX_VOTE.value() + code;
		}else if (type.equals(ObjectType.SENDGROUP)) {
			code = CommonModel.PREFIX_SENDGROUPCODE.value() + code;
		}else if (type.equals(ObjectType.VORG)) {
			code = CommonModel.PREFIX_VIRTUALORG.value() + code;
		}
		
		return code;
	}

}

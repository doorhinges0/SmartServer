package com.dtsjy.mdboss.common.utils.dal;

import org.apache.commons.lang.ArrayUtils;

import com.dtsjy.mdboss.common.model.constants.CommonModel;

public class DalNameUtil {
	final static String FIRST_PART = "com.dtsjy.mdboss.";
	final static String SECOND_PART = ".dal.gen.dao.";
	final static String THIRD_PART_MAPPER = "VOMapper";

	final static String SECOND_PART_EXAMPLE = ".dal.gen.model.";
	final static String THIRD_PART_EXAMPLE = "VOExample";

	public final static String SECOND_PART_VALIDATOR = ".validator.";
	public final static String THIRD_PART_CREATE_V = "CreateValidator";
	public final static String THIRD_PART_UPDATE_V = "UpdateValidator";
	
	final static String[] COMMON_TABLES = new String[]{CommonModel.COMMON_EXCEPTIONLOG.value(),CommonModel.COMMON_SERVICELOG.value(),
		CommonModel.COMMON_SYS_PARAM.value()};
	
	
	public static String getMapperNameByShortVOName(String module,String voName){
		
		String moduleName = module;
		if (ArrayUtils.contains(COMMON_TABLES, voName)){
			moduleName = "common";
		}
		
		return FIRST_PART + moduleName + SECOND_PART + voName
		+ THIRD_PART_MAPPER;
	}
	
	public static String getExampleNameByShortVOName(String module,String voName){
		String moduleName = module;
		if (ArrayUtils.contains(COMMON_TABLES, voName)){
			moduleName = "common";
		}
		
		return FIRST_PART + moduleName + SECOND_PART_EXAMPLE + voName
				+ THIRD_PART_EXAMPLE;
	}
	
	public static String getFullVOName(String module,String voName){
		String moduleName = module;
		if (ArrayUtils.contains(COMMON_TABLES, voName)){
			moduleName = "common";
		}
		
		return FIRST_PART + moduleName + SECOND_PART_EXAMPLE + voName
				+ "VO";
	}
	
	public static String getValidatorName(String module,String voName,String type){
		return FIRST_PART + module + SECOND_PART_VALIDATOR
				+ voName + type;
	}
	
	public static String getVoNameByExampleName(String exampleName){
		return exampleName.replace("VOExample", "VO");
	}
	
	public static String getVoNameByMapperName(String mapperName){
		return mapperName.replace("\\.dao\\.", "\\.model\\.").replace("VOMapper", "VO");
	}
}

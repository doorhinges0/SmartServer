package com.sunrise.common.model.codegenerator;

import com.sunrise.common.model.codegenerator.impl.SimpleCodeGenerator;
import com.sunrise.common.model.codegenerator.impl.SimpleProcesscodeGenerator;
import com.sunrise.common.model.codegenerator.impl.SimpleSerialnoGenerator;
import com.sunrise.common.utils.string.StringToolkit;

public class CodeGenratorTool {
	private static final String CODE_PREFIX_SEPERATOR = "-";
	
	public static String genProcesscode(){
		ProcesscodeGenerator gen = new SimpleProcesscodeGenerator();
		
		return gen.genCode();
	}
	
	
	public static String genSerialno(){
		SerialnoGenerator gen = new SimpleSerialnoGenerator();
		
		return gen.genCode();
	}
	
	/**
	 * 根据对象类型，生成对象的编码
	 * @TODO:根据单位编码要求，执行逻辑处理
	 * @param objTYpe
	 * @return
	 */
	public static String genObjectCode(ObjectType objTYpe){
		return new SimpleCodeGenerator().genCode(objTYpe);
	}
	
	/**
	 * 根据对象编码前缀，生成对象的编码
	 * @TODO:根据单位编码要求，执行逻辑处理
	 * @param code
	 * @return
	 */
	public static String genObjectCode(String code){
		return new SimpleCodeGenerator().genCode(getObjTypeByCode(code));
	}
	
	/**
	 * 获取编码前缀，有分隔符
	 * @param code
	 * @return
	 */
	public static String getCodePrefix(String code){
		if (StringToolkit.isNotEmpty(code)){
			return code.split(CODE_PREFIX_SEPERATOR)[0] + CODE_PREFIX_SEPERATOR;
		}
		
		return null;
	}
	
	/**
	 * 获取编码前缀，有分隔符
	 * @param code
	 * @return
	 */
	public static String getCodePrefixWithouSeperator(String code){
		if (StringToolkit.isNotEmpty(code)){
			return code.split(CODE_PREFIX_SEPERATOR)[0];
		}
		
		return null;
	}
	
	public static ObjectType getObjTypeByCode(String code){
		if (ObjectType.ORG.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.ORG;
		}else if (ObjectType.PROJECT.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.PROJECT;
		}else if (ObjectType.ROLE.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.ROLE;
		}else if (ObjectType.USERGROUP.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.USERGROUP;
		}else if (ObjectType.USER.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.USER;
		}else if (ObjectType.PROJECTROLE.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.PROJECTROLE;
		}else if (ObjectType.PROJECTPHASE.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.PROJECTPHASE;	
		}else if (ObjectType.RMISSUE.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.RMISSUE;	
		}else if (ObjectType.SENDGROUP.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.SENDGROUP;	
		}else if (ObjectType.VORG.name().equalsIgnoreCase(getCodePrefixWithouSeperator(code))){
			return ObjectType.VORG;	
		}
		
		return ObjectType.UNDEFINED;
	}
}

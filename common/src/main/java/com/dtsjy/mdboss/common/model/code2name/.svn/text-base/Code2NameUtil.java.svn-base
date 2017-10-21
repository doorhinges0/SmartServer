package com.dtsjy.mdboss.common.model.code2name;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import com.dtsjy.mdboss.common.model.constants.CmModel;
import com.dtsjy.mdboss.common.model.constants.FspModel;
import com.dtsjy.mdboss.common.model.constants.OAModel;
import com.dtsjy.mdboss.common.model.constants.PMModel;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.model.constants.WfsModel;
import com.dtsjy.mdboss.common.services.CommonService;
import com.dtsjy.mdboss.common.services.CommonServiceUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.date.DateToolkit;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class Code2NameUtil {
	public static CommonService getService(String voClsName){
		if (UcpModel.APP_CODE.value().equals(getApp(voClsName))){
			return CommonServiceUtils.getUcpCommonService();
		}else if (FspModel.APP_CODE.value().equals(getApp(voClsName))){
			return CommonServiceUtils.getFspCommonService();
		}else if (PMModel.APP_CODE.value().equals(getApp(voClsName))){
			return CommonServiceUtils.getPMCommonService();
		}else if (WfsModel.APP_CODE.value().equals(getApp(voClsName))){
			return CommonServiceUtils.getWfsCommonService();
		}else if (OAModel.APP_CODE.value().equals(getApp(voClsName))){
			return CommonServiceUtils.getOACommonService();
		}else if (CmModel.APP_CODE.value().equals(getApp(voClsName))){
			return CommonServiceUtils.getCmCommonService();
		}
		
		return null;
	}
	
	
	public static String geVoNameFromVoClsName(String voClsName){
		if (StringToolkit.isEmpty(voClsName)){
			return null;
		}
		String[] arr = voClsName.split("\\.");
		String name = arr[arr.length-1];
		if (name.endsWith("VO")){
			return name.substring(0,name.length() -2);
		}
		
		return name;
	}
	
	public static String getApp(String voClsName){
		if (StringToolkit.isEmpty(voClsName)){
			return null;
		}
		
		return voClsName.split("\\.")[3].toUpperCase();//com.dtsjy.mdboss.ucp,返回UCP
	}
	
	public static Object convertValueAsPropertyType(Class voClass,String field, String codeValue) throws Exception {
		Object obj = voClass.newInstance();
		PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(obj, field);
		Class pType = descriptor.getPropertyType();
		
		if(pType == String.class)
			return codeValue;
		else if( Long.class.isAssignableFrom(pType)) {
			return Long.valueOf(codeValue);
			
		}else if( Integer.class.isAssignableFrom(pType)) {
			return Integer.valueOf(codeValue);
			
		}else if( Short.class.isAssignableFrom(pType)) {
			return Short.valueOf(codeValue);
			
		}else if( Byte.class.isAssignableFrom(pType)) {
			return Byte.valueOf(codeValue);
		}else if( Date.class.isAssignableFrom(pType)) {
			return DateToolkit.normalDate(codeValue);
		}else if( new ArrayList<Date>().getClass().isAssignableFrom(pType)) {
			String[] tmpAtt = codeValue.split(",");
			//TODO:对泛型的reflection
			return CollectionUtils.arrayToList(tmpAtt);
		}else if (List.class.isAssignableFrom(pType)){
			String[] tmpAtt = codeValue.split(",");
			
			return CollectionUtils.arrayToList(tmpAtt);
		}
		
		throw new IllegalArgumentException("Unsupported type of condition field " + field + ".Require String, Long, Integer,Short,Byte type."  );
	}
	
	public static String surmiseAppCode(String appCode,String definition){
		if (StringToolkit.isEmpty(appCode) && StringToolkit.isNotEmpty(definition)){
			if (definition.startsWith("$") || definition.startsWith("#")){
				definition = definition.substring(1);
			}
			appCode = definition.split("\\_")[0];
		}
		return StringToolkit.getObjectString(appCode).toUpperCase();
	}
}

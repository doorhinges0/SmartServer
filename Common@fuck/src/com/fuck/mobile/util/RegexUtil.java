package com.fuck.mobile.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RegexUtil {
	
	public final static String MOBILE_REGEX = "^((1[0-9]))\\d{9}$";
	
	
	public static boolean isMobile(String mobile) {
		if(StringUtils.isEmpty(mobile)){
			return false;
		}
		String regex = MOBILE_REGEX;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
	
	/**
	 * 判断身份证规则校验
	 * @param idCardNo
	 * @return
	 */
	public static boolean isIdCardNo(String idCardNo){
		if(StringUtils.isEmpty(idCardNo)){
			return false;
		}
		Pattern p15 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
		Matcher idNum15Matcher = p15.matcher(idCardNo);  
		boolean p15flag = idNum15Matcher.matches(); //判断是否为15位身份证
		
		Pattern p18 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$");
		Matcher idNum18Matcher = p18.matcher(idCardNo);  
		boolean p18flag = idNum18Matcher.matches(); //判断是否为18位身份证
		if(p15flag || p18flag){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isMobile("12345678900"));
		System.out.println(isMobile(""));
		System.out.println(isMobile(null));
	}
}

package com.fuck.mobile.base.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class SysToolUtils {

	public final static String MOBILE_REGEX = "^((1[0-9]))\\d{9}$";
	
	
	public static boolean isPhone(String mobile) {
		String regex = MOBILE_REGEX;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
	
	public static String getInvitortype(String referee) {
		if(StringUtils.isEmpty(referee)){
			return "";
		}
		if(isPhone(referee)){
			return "phone";
		}
		return "username";
	}
	
	
	public static void executeUpdateFailedToThrowSQLException(int result,
			int expectedParam) throws SQLException {
		if (result != expectedParam) {
			throw new SQLException("执行结果失败！");
		}
	}
	
	
	public static String maskRealName(String realName){
		if(StringUtils.isNotEmpty(realName) && realName.length()>0){
			realName = realName.substring(0, 1)+"**";
		}
		return realName;
	}
	
	
	public static String maskNickName(String nickName){
		if(StringUtils.isNotEmpty(nickName)){
			if(nickName.length()>10){
				nickName = nickName.substring(0, 10);
			}
		}
		return nickName;
	}
	
	/**
	 * 
	 * @param phone
	 * @return  132****3456
	 */
	public static String maskPhoneNumber(String phone){
		if(StringUtils.isEmpty(phone)){
			return "";
		}
		if(phone.length()<4){
			return "";
		}
		String s = phone.substring(0,3);
		String e = phone.substring(phone.length()-4,phone.length());
		
		return s+"****"+e;
	}
	
	public static  BigDecimal getInterest(BigDecimal amount,BigDecimal rate,int period){
		if(amount==null || rate==null){
			return BigDecimal.ZERO;
		}
		return amount.multiply(rate).multiply(new BigDecimal(period));
		
	}
	
	public static  BigDecimal getExtInterest(BigDecimal amount,BigDecimal interest,BigDecimal outerdaterate,int outday){
		
		return (amount.add(interest)).multiply((outerdaterate.add(BigDecimal.ONE)).pow((int)outday)).subtract(amount).subtract(interest);
		
	}
	
	
	public static void responseSuccess(HttpServletResponse response,Long useTime) throws IOException{
		PrintWriter writer = response.getWriter();
		writer.print("success");
		if(useTime != null){
			writer.print(",use time = " + useTime);
		}
		writer.flush();
	}
	
	
	public static void main(String[] args) {
		System.out.println(isPhone("12345678900"));
	}
	
	
}

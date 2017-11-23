package com.fuck.mobile.util;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class StringFilter {
	
	public static String formartMobile(String mobile){
		if(StringUtils.isEmpty(mobile)){
			return null;
		}
		mobile = mobile.replaceAll("\\-", "");
		mobile = mobile.replaceAll("\\.", "");
		if(mobile.startsWith("+86")){
			mobile = mobile.replaceAll("\\+86", "");
		}
		if(mobile.startsWith("0086")){
			mobile = mobile.replaceFirst("0086", "");
		}
		return mobile.trim();
	}
	
	public static String hideMobile(String mobile){
		if(StringUtils.isEmpty(mobile)){
			return null;
		}
		try {
			mobile=formartMobile(mobile);
			mobile=mobile.substring(0, 3)+"****"+mobile.substring(7);
		} catch (Exception e) {
			return null;
		}
		return mobile;
		
	}
	
	public static String hideRealname(String realname){
		if(StringUtils.isEmpty(realname)){
			return "";
		}
		try {
			int len = realname.length();
			if(len==1){
				realname = realname+"*";
			}
			if(len==2){
				realname = realname.substring(0, 1)+"*";
			}
			
			if(len>2){
				String first = realname.substring(0, 1);
				String last = realname.substring(len-1, len);
				realname = first;
				for(int i=0;i<len-2;i++){
					realname +="*";
				}
				realname += last;
				return realname;
			}
		} catch (Exception e) {
			return "";
		}
		return realname;
		
	}
	
	public static String hideBankCardNumber(String bankcardNumber){
		if(StringUtils.isEmpty(bankcardNumber)){
			return null;
		}
		if(bankcardNumber.length()<4){
			return bankcardNumber;
		}
		return  bankcardNumber.substring(0, 4)+"****"+StringUtils.substring(bankcardNumber, -4);
	}
	
	
	 public static String hideIdCardNo(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return null;
        } else {
            return replaceAction(idCard, "(?<=\\d{4})\\d(?=\\d{4})");
        }
	 }
 
    private static String replaceAction(String username, String regular) {
        return username.replaceAll(regular, "*");
    }
	    
	public static String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }  
	
	
	public static void main(String[] args) {
		System.out.println(formartMobile("+86 186-0123-3456"));
		System.out.println(formartMobile("-0086 186-0123-3456"));
		System.out.println(formartMobile("-0086 186-0123-3456"));
		
		
		System.out.println(hideMobile("18664872695"));
		System.out.println(hideBankCardNumber("124"));
		System.out.println(hideBankCardNumber("6225757516416338"));
		for(int i=0;i<10;i++){
			System.out.println(getRandomString(8));
		}
		
		System.out.println(hideRealname("李文彬"));
		System.out.println(hideRealname("李四"));
		System.out.println(hideRealname("李文彬等等"));
		
		System.out.println(hideIdCardNo("431103198908106916"));
	}
	
	
}

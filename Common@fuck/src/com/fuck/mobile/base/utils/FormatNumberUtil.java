package com.fuck.mobile.base.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class FormatNumberUtil {
	public static String amountToString(Long amount) {
		if (null == amount || amount <= 0) {
			return "0.00";
		}
		BigDecimal a = new BigDecimal(amount);
		a = a.divide(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_DOWN);
		return a.toString();
	}

	public static BigDecimal amountToBigDecimal(Long amount) {
		if (null == amount || amount <= 0) {
			return BigDecimal.ZERO;
		}
		BigDecimal a = new BigDecimal(amount);
		a = a.divide(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_DOWN);
		return a;
	}
	
	
	public static BigDecimal amountToMillionBigDecimal(Long amount) {
		if (null == amount || amount <= 0) {
			return BigDecimal.ZERO;
		}
		BigDecimal a = new BigDecimal(amount);
		a = a.divide(BigDecimal.valueOf(1000000)).setScale(2,BigDecimal.ROUND_DOWN);
		return a;
	}
	
	public static String amountToMillionString(Long amount) {
		if (null == amount || amount <= 0) {
			return "0.00";
		}
		BigDecimal a = new BigDecimal(amount);
		a = a.divide(BigDecimal.valueOf(1000000)).setScale(2,BigDecimal.ROUND_DOWN);
		return a.toString();
	}
	
	public static long amountToLong(String amount) {
		Double d = Double.parseDouble(amount) * 100;
		return d.longValue();
	}

	public static BigDecimal rateToBigDecimal(Long rate) {
		if (null == rate || rate <= 0) {
			return BigDecimal.ZERO;
		}
		BigDecimal a = new BigDecimal(rate);
		BigDecimal b = a.divide(BigDecimal.valueOf(100));
		if(isNumeric(b.toString())){
			return b;
		}
		a = a.divide(BigDecimal.valueOf(100)).setScale(1,BigDecimal.ROUND_DOWN);
		return a;
	}
	
	public static boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){  
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
	}
	
	public static String rateToString(Long rate) {
		if (rate <= 0) {
			return "0.0";
		}
		/*DecimalFormat df = new DecimalFormat("0.00");
		
		return df.format((double) rate / 100);*/
		BigDecimal a = new BigDecimal(rate);
		BigDecimal b = a.divide(BigDecimal.valueOf(100));
		if(isNumeric(b.toString())){
			return b.toString();
		}
		a = a.divide(BigDecimal.valueOf(100)).setScale(1,BigDecimal.ROUND_DOWN);
		return a.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(rateToString(10l));;
	}
}

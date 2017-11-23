package com.fuck.mobile.util;

import java.util.zip.CRC32;

import org.apache.commons.lang3.StringUtils;

public class GetTableUtils {

	public static final int tableTotal = 200;
	
	public static String getTableNameByMobile(String tableName, String mobile,int total) {
		long cc = 0;
		if(StringUtils.isEmpty(mobile)){
			cc = 0;
		}
		CRC32 crc = new CRC32();
		crc.update(mobile.getBytes());
		cc = crc.getValue();
		return  getTableNameByUserId(tableName,cc,total);
	}
	
	public static String getTableNameByUserId(String tableName, long userId,int total) {
		return tableName + getTableNamePrefix(userId,total);
	}

	private static String getTableNamePrefix(long userId,int total) {
		long md = userId % total;
		return String.format("%03d", md);
	}
	
	public static String getTableNamePrefix(long userId) {
		long md = userId % tableTotal;
		return String.format("%03d", md);
	}
	
	public static String getTableName(String tableName, long userId) {
		return tableName + getTableNamePrefix(userId,tableTotal);
	}
	
	public static void main(String[] args) {
		System.out.println(getTableNameByUserId("user", 1l, 5 ));
		System.out.println(getTableNameByMobile("t_user_verifycode_", "18558666541", 200 ));
	}
}

package com.fuck.mobile.base;

import java.nio.charset.Charset;

public final class CharsetUtil {

	public static final Charset UTF8 = Charset.forName("utf-8");
	public static final Charset GBK = Charset.forName("GBK");
	public static final Charset ISO8859_1 = Charset.forName("iso8859-1");
	public static final Charset DefaultCharset = Charset.defaultCharset();
	
	
	public static String toutf8(String str) {
		if (str == null)
			return null;
		String retStr = str;
		byte b[];
		
		b = str.getBytes(ISO8859_1);
		for (int i = 0; i < b.length; i++) {
			byte b1 = b[i];
			if (b1 == 63)
				break; // 1
			else if (b1 > 0)
				continue;// 2
			else if (b1 < 0) { // 不可能为0，0为字符串结束符
				retStr = new String(b,UTF8);
				break;
			}
		}
		
		return retStr;
	}
	
}

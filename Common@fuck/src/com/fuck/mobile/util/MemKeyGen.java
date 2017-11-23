package com.fuck.mobile.util;

public class MemKeyGen {

	public static String GenKey(Object ... objs)
	{
		StringBuilder sb = new StringBuilder();
		if(objs != null)
		{
			for (Object o : objs) {
				
				sb.append(o).append("_");
			}
		}
	
		return MD5Util.getMd5String(sb.toString());
	}
}

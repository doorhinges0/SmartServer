package com.fuck.mobile.base.utils;

import com.fuck.mobile.base.constant.Ostype;
import org.apache.commons.lang3.StringUtils;

public class DictUtil {

	public static int getOstype(String ostypeStr){
		int ostype = -1;
		if(StringUtils.equalsIgnoreCase(Ostype.ALL.getDesc(), ostypeStr)){
			ostype = Ostype.ALL.getValue();
		}else if(StringUtils.equalsIgnoreCase(Ostype.ANDROID.getDesc(), ostypeStr)){
			ostype = Ostype.ANDROID.getValue();
		}else if(StringUtils.equalsIgnoreCase(Ostype.IOS.getDesc(), ostypeStr)){
			ostype = Ostype.IOS.getValue();
		}else if(StringUtils.equalsIgnoreCase(Ostype.PC.getDesc(), ostypeStr)){
			ostype = Ostype.PC.getValue();
		}else if(StringUtils.equalsIgnoreCase(Ostype.WEIXIN.getDesc(), ostypeStr)){
			ostype = Ostype.WEIXIN.getValue();
		}else if(StringUtils.equalsIgnoreCase(Ostype.WAP.getDesc(), ostypeStr)){
			ostype = Ostype.WAP.getValue();
		}
		
		return ostype;
	}
	
	
}

package com.dtsjy.mdboss.common.utils.validate;

import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

public class ValidateUtils {

	/** 
     * 手机号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  
    /** 
     * 电话号码验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isPhone(String str) {   
        Pattern p1 = null,p2 = null;  
        Matcher m = null;  
        boolean b = false;    
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的  
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的  
        if(str.length() >9)  
        {   m = p1.matcher(str);  
            b = m.matches();    
        }else{  
            m = p2.matcher(str);  
            b = m.matches();   
        }    
        return b;  
    } 
    
    public static String[] getValidateMethods(String methodsStr) {
		if (methodsStr.contains(",")) {
			return methodsStr.split(",");
		} else {
			return new String[] { methodsStr };
		}
	}

	// 根据表达式获取具体值
    public static Object getValueByAttr(String expression, JSONObject json) {
		if (expression.contains(".")) {// 处理多层嵌套
			String[] keys = expression.split("\\.");
			JSONObject tmp = json;
			int length = keys.length;
			for (int i = 0; i < length; i++) {
				if (i == length - 1) {
					return tmp.get(keys[i]);
				} else {
					tmp = tmp.getJSONObject(keys[i]);
				}
			}
			return null;// 出现这个情况说明有问题
		} else {
			return json.get(expression);
		}

	}

	/**
	 * 从查找指定类的注解，如果不存在，则搜索其父类的注解，直至第一次找到
	 * @param clz
	 * @param annotationClass
	 * @author livan.c
	 * @return
	 */
    public static <A extends Annotation> A findAnnotation(Class<?> clz,Class<A> annotationClass){
		A annotation =  clz.getAnnotation(annotationClass);
		return annotation != null ? annotation : findAnnotation(clz.getSuperclass(), annotationClass);
	}
	
}

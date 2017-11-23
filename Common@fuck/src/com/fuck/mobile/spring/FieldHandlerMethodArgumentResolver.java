package com.fuck.mobile.spring;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;

import com.fuck.mobile.spring.annotation.FieldSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class FieldHandlerMethodArgumentResolver implements
		HandlerMethodArgumentResolver {

	static Log log = LogFactory.getLog(FieldHandlerMethodArgumentResolver.class);
	
	@Override
	public boolean supportsParameter(MethodParameter paramMethodParameter) {
		return	paramMethodParameter.hasParameterAnnotation(FieldSupport.class);
	}

	@Override
	public Object resolveArgument(MethodParameter paramMethodParameter,
			ModelAndViewContainer paramModelAndViewContainer,
			NativeWebRequest paramNativeWebRequest,
			WebDataBinderFactory paramWebDataBinderFactory) throws Exception {
		
		Class<?> c = paramMethodParameter.getParameterType();
		Object o =	BeanUtils.instantiate(c);	
		Field[] fs = c.getFields();
		for(Field f : fs)
		{
			String s =	paramNativeWebRequest.getParameter(f.getName());
			Class<?> fccc = f.getType();
			if(fccc.equals(String.class))
			{
				f.set(o, toutf8(s));
			}else{
				
				if(StringUtils.isEmpty(s))
				{
					continue;
				}
				
				if(fccc.equals(Byte.class) || fccc.equals(byte.class))
				{
					f.set(o, Byte.parseByte(s));	
				}else if(fccc.equals(Boolean.class) || fccc.equals(boolean.class))
				{
					boolean bol = "1".equals(s) || "true".equalsIgnoreCase(s);
					f.set(o,bol);	
				}
				else if(fccc.equals(Short.class) || fccc.equals(short.class))
				{
					f.set(o, Short.parseShort(s));	
				}else if(fccc.equals(Integer.class) || fccc.equals(int.class))
				{
					f.set(o, Integer.parseInt(s));	
				}else if(fccc.equals(Long.class) || fccc.equals(long.class))
				{
					f.set(o, Long.parseLong(s));	
				}else if(fccc.equals(Float.class) || fccc.equals(float.class))
				{
					f.set(o, Float.parseFloat(s));	
				}else if(fccc.equals(Double.class) || fccc.equals(double.class))
				{
					f.set(o, Double.parseDouble(s));	
				}else if(fccc.equals(BigInteger.class) )
				{
					f.set(o,new BigInteger(s));	
				}else if(fccc.equals(BigDecimal.class) )
				{
					f.set(o,new BigDecimal(s));	
				}else
				{
					throw new Exception("data -> " + s + " ,is not support");
					
				}
			}
			
			
		}
		
		
		return o;
	}

	private  static  String  toutf8(String  str)  {   
        if  (str  ==  null)  return  null;   
        String  retStr  =  str;   
        byte  b[];   
        try  {   
                b  =  str.getBytes("ISO8859_1");  
                for  (int  i  =  0;  i  <  b.length;  i++)  {   
                        byte  b1  =  b[i];   
                        if  (b1  ==  63)   
                                break;    //1   
                        else  if  (b1  >  0)   
                                continue;//2   
                        else  if  (b1  <  0)  {        //不可能为0，0为字符串结束符  
                                retStr  =  new  String(b,  "UTF-8");   
                                break;   
                        }   
                }   
        }  catch  (UnsupportedEncodingException  e)  {   
               log.error(e, e);
        }   
        return  retStr;   
	}   
}

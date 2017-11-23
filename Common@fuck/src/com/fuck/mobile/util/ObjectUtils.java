package com.fuck.mobile.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.experimental.UtilityClass;

//@CommonsLog
@UtilityClass
public class ObjectUtils {

	private static Log log = LogFactory.getLog(ObjectUtils.class);
	
	public static <T> T castObject(T obj,Class<T> c)
	{
		try
		{
			if(obj.getClass().equals(Object.class))
			{
				return obj;
			}
			
			Constructor<T> cct = c.getDeclaredConstructor();
			cct.setAccessible(true);
			T ret = cct.newInstance();
			
			Class<?> cl = c;
			while(!cl.equals(Object.class))
			{
				Field[] fs = cl.getDeclaredFields();
				for(Field f : fs)
				{
					if(Modifier.isStatic(f.getModifiers()))
					{
						continue;
					}
					f.setAccessible(true);
					Object val = f.get(obj);
					f.set(ret, val);
				}
				cl = cl.getSuperclass();
			}
			
			return ret;
		}catch(Exception e)
		{
			log.debug("",e);
		}
		return null;

	}

	
	
}

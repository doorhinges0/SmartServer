package com.fuck.mobile.base.jstl;

import java.beans.FeatureDescriptor;
import java.lang.reflect.Field;
import java.util.Iterator;

import javax.el.ELContext;
import javax.el.ELException;
import javax.el.ELResolver;
import javax.el.PropertyNotFoundException;
import javax.el.PropertyNotWritableException;


public class FieldELResolver extends ELResolver {

	@Override
	public Class<?> getCommonPropertyType(ELContext arg0, Object arg1) {
		System.out.println(arg0 + ":" + arg1);
		
		return null;
	}

	@Override
	public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext arg0,
			Object arg1) {
		System.out.println(arg0 + ":" + arg1);
		return null;
	}

	@Override
	public Class<?> getType(ELContext arg0, Object arg1, Object arg2)
			throws NullPointerException, PropertyNotFoundException, ELException {
		System.out.println(arg0 + ":" + arg1 + ":" + arg2);
		return null;
	}

	@Override
	public Object getValue(ELContext context, Object base, Object property)
			throws NullPointerException, PropertyNotFoundException, ELException {
		if (context == null) {
			throw new NullPointerException();
		}
		if ((base == null) || (property == null)) {
			return null;
		}
		
		String prop = property.toString();
		Class<?> type = base.getClass();
		
		
			Field f;
			try {
				f = type.getField(prop);
				Object obj = f.get(base);
				context.setPropertyResolved(true);
				return obj;
			}catch (NoSuchFieldException e) {
				//不处理
			} catch (Exception e) {
				throw new ELException(e);
			} 
			
		
		 return null;
	
	}

	@Override
	public boolean isReadOnly(ELContext arg0, Object arg1, Object arg2)
			throws NullPointerException, PropertyNotFoundException, ELException {

		return false;
	}
	
	@Override
	public void setValue(ELContext context, Object base, Object property, Object value)
			throws NullPointerException, PropertyNotFoundException,
			PropertyNotWritableException, ELException {

		if (context == null) {
			throw new NullPointerException();
		}
		if ((base == null) || (property == null)) {
			return;
		}
		
		String prop = property.toString();
		Class<?> type = base.getClass();
		
		try {
			Field f = type.getField(prop);
			f.set(base, value);
			context.setPropertyResolved(true);
			
		} catch (NoSuchFieldException e) {
			//不处理
		} catch (Exception e) {
			throw new ELException(e);
		}
		
	}

}

package com.fuck.mobile.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ReflectUtil {

	public static void main(String[] args) {
		Object s = new Object();
		System.out.println(s.getClass().getSuperclass());
	}
	
	public static List<Method> getAllMethods(Class<?> c)
	{
		ArrayList<Method> ms = new ArrayList<>();
		Class<?> s = c;
		
		while(!s.equals(Object.class))
		{
			Method[] mmmm = s.getMethods();
			for(Method m : mmmm)
			{
				if(!ms.contains(m))
					ms.add(m);
			}
			s = s.getSuperclass();
		}
		return ms;
	}
	
	public static List<Method> getAllDeclaredMethods(Class<?> c)
	{
		ArrayList<Method> ms = new ArrayList<>();
		Class<?> s = c;
		while(!s.equals(Object.class))
		{
			Method[] mmmm = s.getDeclaredMethods();
			for(Method m : mmmm)
			{
				if(!ms.contains(m))
					ms.add(m);
			}
			s = s.getSuperclass();
		}
		return ms;
	}
	
	public static List<Field> getAllFields(Class<?> c)
	{
		ArrayList<Field> ms = new ArrayList<>();
		Class<?> s = c;
		while(!s.equals(Object.class))
		{
			Field[] mmmm = s.getFields();
			for(Field m : mmmm)
			{
				if(!ms.contains(m))
					ms.add(m);
			}
			s = s.getSuperclass();
		}
		return ms;
	}
	
	public static List<Field> getAllDeclaredFields(Class<?> c)
	{
		ArrayList<Field> ms = new ArrayList<>();
		Class<?> s = c;
		while(!s.equals(Object.class))
		{
			Field[] mmmm = s.getDeclaredFields();
			for(Field m : mmmm)
			{
				if(!ms.contains(m))
					ms.add(m);
			}
			s = s.getSuperclass();
		}
		return ms;
	}
	
	
	
	public static void setStaticField(Class<?> c, String FieldName,Object obj) throws IllegalArgumentException, IllegalAccessException
	{


		while (true) {
			Field[] fs = c.getDeclaredFields();
			if (fs != null) {
				for (Field f : fs) {
					if (StringUtils.equals(f.getName(), FieldName)) {
						f.setAccessible(true);
						f.set(null, obj);
						return;
					}
				}
			}

			c = c.getSuperclass();
			if (c == null) {
				throw new NoSuchFieldError(FieldName);
			}
		}
	}
	
	public static void setField(Object self, String FieldName,Object obj) throws IllegalArgumentException, IllegalAccessException
	{
		Class<?> c = self.getClass();

		while (true) {
			Field[] fs = c.getDeclaredFields();
			if (fs != null) {
				for (Field f : fs) {
					if (StringUtils.equals(f.getName(), FieldName)) {
						f.setAccessible(true);
						f.set(self, obj);
						return;
					}
				}
			}

			c = c.getSuperclass();
			if (c == null) {
				throw new NoSuchFieldError(FieldName);
			}
		}
	}
	
	public static Object getStaticField(Class<?> c, String FieldName)
			throws IllegalArgumentException, IllegalAccessException {
		while (true) {
			Field[] fs = c.getDeclaredFields();
			if (fs != null) {
				for (Field f : fs) {
					if (StringUtils.equals(f.getName(), FieldName)) {
						f.setAccessible(true);
						return f.get(null);
					}
				}
			}

			c = c.getSuperclass();
			if (c == null) {
				throw new NoSuchFieldError(FieldName);
			}
		}

	}

	public static Object getField(Object self, String FieldName)
			throws IllegalArgumentException, IllegalAccessException {
		Class<?> c = self.getClass();

		while (true) {
			Field[] fs = c.getDeclaredFields();
			if (fs != null) {
				for (Field f : fs) {
					if (StringUtils.equals(f.getName(), FieldName)) {
						f.setAccessible(true);
						return f.get(self);
					}
				}
			}

			c = c.getSuperclass();
			if (c == null) {
				throw new NoSuchFieldError(FieldName);
			}
		}

	}
	
	public static Object callStaticMethod(Class<?> c, String methodName,
			Object... objs) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		int plen = objs == null ? 0 : objs.length;
		while (true) {

			Method[] ms = c.getDeclaredMethods();
			if (ms != null) {
				for (Method m : ms) {
					m.getParameterTypes();
					if (StringUtils.equals(methodName, m.getName())
							&& m.getParameterTypes().length == plen) {
						m.setAccessible(true);
						return m.invoke(null, objs);
					}
				}
			}
			c = c.getSuperclass();
			if (c == null) {
				throw new NoSuchMethodException(methodName);
			}

		}

	}
	
	

	public static Object callMethod(Object self, String methodName,
			Object... objs) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		int plen = objs == null ? 0 : objs.length;
		Class<?> c = self.getClass();
		while (true) {

			Method[] ms = c.getDeclaredMethods();
			if (ms != null) {
				for (Method m : ms) {
					m.getParameterTypes();
					if (StringUtils.equals(methodName, m.getName())
							&& m.getParameterTypes().length == plen) {
						m.setAccessible(true);
						return m.invoke(self, objs);
					}
				}
			}
			c = c.getSuperclass();
			if (c == null) {
				throw new NoSuchMethodException(methodName);
			}

		}

	}

}

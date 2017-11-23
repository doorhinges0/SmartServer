package com.fuck.mobile.spring.dubbo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.fuck.mobile.base.utils.ReflectUtil;

public class AnnotationBeanEx extends AnnotationBean {

	private static final long serialVersionUID = 1083525661397634444L;
	private Method method_isMatchPackage = null;
	private Method method_refer = null;

	private Object refer(Reference reference, Class<?> referenceClass) {
		if (method_refer == null) {
			try {
				method_refer = AnnotationBean.class.getDeclaredMethod("refer", Reference.class,Class.class);
				method_refer.setAccessible(true);
			} catch (Exception e) {
			}
		}
		try {
			return method_refer.invoke(this, reference,referenceClass);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	private boolean isMatchPackage(Object bean) {
		if (method_isMatchPackage == null) {
			try {
				method_isMatchPackage = AnnotationBean.class.getDeclaredMethod("isMatchPackage", Object.class);
				method_isMatchPackage.setAccessible(true);
			} catch (Exception e) {
			}
		}
		try {
			return (boolean) method_isMatchPackage.invoke(this, bean);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	private boolean isProxyBean(Object bean) {
		return AopUtils.isAopProxy(bean);
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (!isMatchPackage(bean)) {
			return bean;
		}
		Class<?> clazz = bean.getClass();
		if (isProxyBean(bean)) {
			clazz = AopUtils.getTargetClass(bean);
		}
		List<Method> methods =  ReflectUtil.getAllMethods(clazz);// clazz.getMethods();
		for (Method method : methods) {
			String name = method.getName();
			if (name.length() > 3 && name.startsWith("set") && method.getParameterTypes().length == 1
					&& Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers())) {
				try {
					Reference reference = method.getAnnotation(Reference.class);
					if (reference != null) {
						Object value = refer(reference, method.getParameterTypes()[0]);
						if (value != null) {
							method.invoke(bean, new Object[] { value });
						}
					}
				} catch (Exception e) {
					// modified by lishen
					throw new BeanInitializationException("Failed to init remote service reference at method " + name
							+ " in class " + bean.getClass().getName(), e);
					// logger.error("Failed to init remote service reference at
					// method " + name + " in class " +
					// bean.getClass().getName() + ", cause: " + e.getMessage(),
					// e);
				}
			}
		}
		List<Field> fields = ReflectUtil.getAllDeclaredFields(clazz);// clazz.getDeclaredFields();
		for (Field field : fields) {
			try {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				Reference reference = field.getAnnotation(Reference.class);
				if (reference != null) {
					Object value = refer(reference, field.getType());
					if (value != null) {
						field.set(bean, value);
					}
				}
			} catch (Exception e) {
				// modified by lishen
				throw new BeanInitializationException("Failed to init remote service reference at filed "
						+ field.getName() + " in class " + bean.getClass().getName(), e);
				// logger.error("Failed to init remote service reference at
				// filed " + field.getName() + " in class " +
				// bean.getClass().getName() + ", cause: " + e.getMessage(), e);
			}
		}
		return bean;
	}

}

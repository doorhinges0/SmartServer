package com.fuck.mobile.spring;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @category 手动添加需要注入的对象
 * @author MegaX
 *
 */
@Component
public class SpringManualInject implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private AutowiredAnnotationBeanPostProcessor autoProcessor;
	private static ThreadLocal<List<Object>> manualObject = new ThreadLocal<List<Object>>() {
		@Override
		protected List<Object> initialValue() {
			return new ArrayList<>();
		}
	};
	
	public static void addManualInjectObject(Object obj)
	{
		manualObject.get().add(obj);
	}
	
	@PostConstruct
	private void doManualInject()
	{
		List<Object> objs = manualObject.get();
		for(Object obj : objs)
		{
			autoProcessor.processInjection(obj);
		}
		manualObject.remove();
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event == null) return;
		List<Object> objs = manualObject.get();
		for(Object obj : objs)
		{
			autoProcessor.processInjection(obj);
		}
		manualObject.remove();
	}

}

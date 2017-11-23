package com.xnew;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


public class RequestMappingHandlerMappingEx extends
		RequestMappingHandlerMapping {

	private static class RequestMappingEx implements RequestMapping
	{
		String values;
		RequestMapping parent;
		public RequestMappingEx(RequestMapping parent,Method m)
		{
			this.parent = parent;
			values = m.getName();
		}
		

		@Override
		public Class<? extends Annotation> annotationType() {
	
			return parent.annotationType();
		}

		@Override
		public String[] value() {
			if(parent.value() == null || parent.value().length == 0)
			{
				return new String[]{values};
			}
			return parent.value();
		}

		@Override
		public RequestMethod[] method() {
			return parent.method();
		}

		@Override
		public String[] params() {

			return parent.params();
		}

		@Override
		public String[] headers() {
			return parent.headers();
		}

		@Override
		public String[] consumes() {

			return parent.consumes();
		}

		@Override
		public String[] produces() {
			return parent.produces();
		}


		@Override
		public String name() {
	
			return parent.name();
		}


		@Override
		public String[] path() {

			return parent.path();
		}
		
	}
	
	@Override
	protected RequestMappingInfo getMappingForMethod(java.lang.reflect.Method method, Class<?> handlerType)
	{
	
		RequestMappingInfo info = null;
	    RequestMapping methodAnnotation = (RequestMapping)AnnotationUtils.findAnnotation(method, RequestMapping.class);
	    if(methodAnnotation != null && (methodAnnotation.value() == null || methodAnnotation.value().length == 0))
	    {
	    	methodAnnotation = new RequestMappingEx(methodAnnotation,method);
	    }
	    if (methodAnnotation != null) { 
	    	RequestCondition<?> methodCondition = getCustomMethodCondition(method);
		   
	    	info = createRequestMappingInfo(methodAnnotation, methodCondition);
		      
	    	RequestMapping typeAnnotation = (RequestMapping)AnnotationUtils.findAnnotation(handlerType, RequestMapping.class);
	       if (typeAnnotation != null) {
		        RequestCondition<?> typeCondition = getCustomTypeCondition(handlerType);
		         info = createRequestMappingInfo(typeAnnotation, typeCondition).combine(info);
		       }
		   
		    
	    }
		     
	    return info;

	}
	

	
}

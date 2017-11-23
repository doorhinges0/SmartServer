package com.fuck.mobile.spring.json;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.google.gson.Gson;
import com.fuck.mobile.spring.annotation.JsonSupport;

public class JsonHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return	parameter.hasParameterAnnotation(JsonSupport.class);
	}

	static Gson gs = new Gson();
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		Class<?> c = parameter.getParameterType();
		
		Object o = webRequest.getNativeRequest();
		if(o instanceof HttpServletRequest)
		{
			HttpServletRequest req = (HttpServletRequest) o;
			byte[] data = StreamUtils.copyToByteArray(req.getInputStream());
			String json = new String(data,"utf-8");
//			System.out.println(json);
			return gs.fromJson(json, c);
		}
		return null;
	}

}

package com.fuck.mobile.base.spring;

import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.LongSerializationPolicy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonModelAndView extends ModelAndView {

	static Log log = LogFactory.getLog(JsonModelAndView.class);
	private Object objectjson;

	private static Gson defaultgs = new Gson();
	private static Gson long2Sting = new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING)
			.serializeNulls().create();;
	private Gson gs;

	public JsonModelAndView(Object objectJson) {
		super();
		this.objectjson = objectJson;
		this.gs = defaultgs;
	}

	public JsonModelAndView(Object objectJson, boolean isUselong2Sting) {
		super();
		this.objectjson = objectJson;
		if (isUselong2Sting) {
			gs = long2Sting;
		} else
			this.gs = defaultgs;
	}

	public JsonModelAndView(Object objectJson, Gson gs) {
		super();
		this.objectjson = objectJson;

		if (gs != null) {
			this.gs = gs;
		} else
			this.gs = defaultgs;
	}

	public boolean hasView() {
		return true;
	}

	public boolean isEmpty() {
		return false;
	}

	@Override
	public View getView() {

		return new View() {

			@Override
			public void render(Map<String, ?> paramMap, HttpServletRequest paramHttpServletRequest,
					HttpServletResponse paramHttpServletResponse) throws Exception {

				paramHttpServletResponse.setContentType(getContentType());

				ServletOutputStream out = paramHttpServletResponse.getOutputStream();
				try {
					if (objectjson != null) {
						String json = gs.toJson(objectjson);
						// log.debug(json);
						byte[] b = json.getBytes("utf-8");
						out.write(b);
						out.flush();

					}

				} finally {
					if (out != null) {
						out.close();
					}
				}

			}

			@Override
			public String getContentType() {

				return "application/json;charset=utf-8";
			}
		};

	}

}

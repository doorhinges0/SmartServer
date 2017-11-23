package com.sunrise.common.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.sunrise.common.model.DataPackage;
import com.sunrise.common.model.ResponseObject;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.date.DateToolkit;
import com.sunrise.common.utils.json.JsonUtil;
import com.sunrise.common.utils.json.TableConfigAfterPropertyFilter;
import com.sunrise.common.utils.string.StringToolkit;

public class JsonResponseUtils {
	// 返回值（成功为正整数，失败为负整数）
	public static Integer SUCCESS = 1;
	public static Integer ERROR = -1;

	// response标准属性
	public static String RETURN_CODE = "rc";
	public static String MESSAGE = "msg";
	public static String DATA = "data";

	// data为DataPackage时的标准属性
	public static String PAGE_SIZE = "pageSize";
	public static String PAGE_NO = "pageNo";
	public static String ROWS = "rows";
	public static String TOTAL = "total";

	private static final SerializeConfig defaultSerializeConfig;
	public static final SerializeFilter defaultSerializeFilter = new TableConfigAfterPropertyFilter();
	
	
	static {
		defaultSerializeConfig =  new SerializeConfig();
		defaultSerializeConfig.put(Date.class, new SimpleDateFormatSerializer(DateToolkit.DEFAULT_DATEFORMAT));
	}
	
	/**
	 * 返回json的通用描述 {"rc":-1,"msg":"错误信息"，"data": 数据}
	 * 
	 * 成功是1，错误是-1
	 * 
	 */
	public static String success(Object result) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		return JSON.toJSONString(json,defaultSerializeConfig,SerializerFeature.WriteMapNullValue);
	}
	
	public static String successAndTotal(Object result,Integer total) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);
		json.put(TOTAL, total);

		return JSON.toJSONString(json,defaultSerializeConfig,SerializerFeature.WriteMapNullValue);
	}

	public static String successExclude(Object result, String excludes) {
//		Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		SerializeFilter filter = JsonUtil.makeFilter(null, excludes,
				null);
		return JSON.toJSONString(json, defaultSerializeConfig, filter,
				SerializerFeature.WriteMapNullValue);
	}

	public static String successInclude(Object result, String includes) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		SerializeFilter filter = JsonUtil.makeFilter(null, null,
				includes);
		return JSON.toJSONString(json, defaultSerializeConfig, filter,
				SerializerFeature.WriteMapNullValue);
	}

	public static String successExclude(Object result, String excludes,
			String dateFormat) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		SerializeConfig config = new SerializeConfig();
		if (StringToolkit.isNotEmpty(dateFormat)) {
			config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
		}
		SerializeFilter filter = JsonUtil.makeFilter(null, excludes,
				null);
		return JSON.toJSONString(json, config, filter,
				SerializerFeature.WriteMapNullValue);
	}

	public static String successInclude(Object result, String includes,
			String dateFormat) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		SerializeConfig config = new SerializeConfig();
		if (StringToolkit.isNotEmpty(dateFormat)) {
			config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
		}
		SerializeFilter filter = JsonUtil.makeFilter(null, null,
				includes);
		return JSON.toJSONString(json, config, filter,
				SerializerFeature.WriteMapNullValue);
	}
	
	
	public static String successExclude(Object result, String excludes,
			Class<?> type) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		
		SerializeFilter filter = JsonUtil.makeFilter(type, excludes,
				null);
		return JSON.toJSONString(json, defaultSerializeConfig, filter,
				SerializerFeature.WriteMapNullValue);
	}
	
	public static String successInclude(Object result, String includes,
			Class<?> type) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		
		SerializeFilter filter = JsonUtil.makeFilter(type, null,
				includes);
		return JSON.toJSONString(json, defaultSerializeConfig, filter,
				SerializerFeature.WriteMapNullValue);
	}
	

	public static String success(Object result, SerializeFilter filter) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		return JSON.toJSONString(json, defaultSerializeConfig, filter,
				SerializerFeature.WriteMapNullValue);
	}

	public static String success(Object result, SerializeFilter[] filters) {
		return success(result, DateToolkit.DEFAULT_DATEFORMAT, filters);
	}
	
	public static String success(Object result, String dateFormat) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		SerializeConfig config = new SerializeConfig();
		if (StringToolkit.isNotEmpty(dateFormat)) {
			config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
		}

		return JSON.toJSONString(json, config,
				SerializerFeature.WriteMapNullValue);
	}

	public static String success(Object result, String dateFormat,
			SerializeFilter filter) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		SerializeConfig config = new SerializeConfig();
		if (StringToolkit.isNotEmpty(dateFormat)) {
			config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
		}

		return JSON.toJSONString(json, config, filter,
				SerializerFeature.WriteMapNullValue);
	}
	
	public static String success(Object result, String dateFormat,
			SerializeFilter[] filters) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		SerializeConfig config = new SerializeConfig();
		if (StringToolkit.isNotEmpty(dateFormat)) {
			config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
		}

		return JSON.toJSONString(json, config, filters,
				SerializerFeature.WriteMapNullValue);
	}
	

	public static String success(Object result, SerializeConfig config,
			SerializeFilter filter) {
		//Object body = JSONObject.toJSON(result);
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, SUCCESS);
		json.put(MESSAGE, "success");
		json.put(DATA, result);

		return JSON.toJSONString(json, config, filter,
				SerializerFeature.WriteMapNullValue);
	}

	public static String error(String message) {
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, ERROR);
		json.put(MESSAGE, message);

		return json.toJSONString();
	}

	public static String error(JSONObject data) {
		JSONObject json = new JSONObject();
		json.put(RETURN_CODE, ERROR);
		json.put(MESSAGE, "");
		json.put(DATA, data);

		return json.toJSONString();
	}

	public static String errorUndefined() {
		return error("发生未知异常！");
	}
	
	public static boolean isSucces(String rsp){
		return !isError(rsp);
	}
	
	public static boolean isError(String rsp){
		if (StringToolkit.isEmpty(rsp)){
			throw new RuntimeException("param rsp for method JsonResponseUtils.isError can not be null!");
		}
		int rc = JsonUtil.getPropertyOfJson(rsp, RETURN_CODE, Integer.class);
		return -1 == rc;
	}

	public static <T> T getData(String rsp,Class<T> voClss){
		Object data = JSONObject.parseObject(rsp).get(DATA);
		if (data != null) {
			if (data instanceof JSONObject){
				return JSON.toJavaObject((JSONObject)data, voClss);
			}else {
				if (data.getClass().isAssignableFrom(voClss)){
					return (T)data;
				}
				return JSON.toJavaObject(JSONObject.parseObject(data.toString()), voClss);
			}
		}
		return null;
	}
	
	public static JSONObject getData(String rsp){
		return JSONObject.parseObject(rsp).getJSONObject(DATA);
	}
	// 获取rows
	public static JSONArray getRowsFormResponse(String rsp) {
		try {
			JSONObject rspJson = (JSONObject) JSONObject.parse(rsp);
			JSONObject data = (JSONObject) rspJson.get(DATA);
			return (JSONArray) data.get(ROWS);
		} catch (Exception e) {
			return new JSONArray();
		}
	}
	
	public static JSONObject getOneIfNotEmpty(String rsp){
		JSONArray rows = getRowsFormResponse(rsp);
		if (CollectionUtils.isNotEmpty(rows)){
			return rows.getJSONObject(0);
		}
		return null;
	}
	
	public static <T>T getOneIfNotEmpty(String rsp,Class<T> clazz){
		JSONArray rows = getRowsFormResponse(rsp);
		if (CollectionUtils.isNotEmpty(rows)){
			return rows.getObject(0, clazz);
		}
		return null;
	}
	
	public static boolean isNotEmpty(String rsp){
		return CollectionUtils.isNotEmpty(getRowsFormResponse(rsp));
	}

	// 获取datapackage
	public static <T> DataPackage<T> getPackageFormResponse(String rsp,
			Class<T> voClass) {
		ResponseObject<T> rspObj = getResponeObject(rsp, voClass);
		return rspObj.getData();
	}

	public static <VO> ResponseObject<VO> getResponeObject(String rsp,
			Class<VO> voClass) {
		JSONObject json = (JSONObject) JSONObject.parse(rsp);
		Integer rc = json.getInteger(RETURN_CODE);
		String msg = json.getString(MESSAGE);

		DataPackage<VO> dp = new DataPackage<VO>();
		JSONObject data = null;
		try {
			data = (JSONObject) json.get(DATA);
		} catch (Exception e) {
			//do nothing
		}

		if (null != data) {
			JSONArray rows = data.getJSONArray(ROWS);
			List<VO> list = new ArrayList<VO>();
			for (int i = 0; i < rows.size(); i++) {
				JSONObject row = (JSONObject) rows.get(i);
				VO vo = JSON.toJavaObject(row, voClass);
				list.add(vo);
			}

			dp.setPageNo(data.getInteger(PAGE_NO));
			dp.setPageSize(data.getInteger(PAGE_SIZE));
			dp.setTotal(data.getLong(TOTAL));
			dp.setRows(list);
		}

		ResponseObject<VO> rspObj = new ResponseObject<VO>();
		rspObj.setData(dp);
		rspObj.setRc(rc);
		rspObj.setMsg(msg);

		return rspObj;
	}

	public static <VO> DataPackage<VO> createDP(List<VO> rows,
			Integer pageSize, Integer pageNo, Long total) {
		DataPackage<VO> dp = new DataPackage<VO>();
		dp.setPageNo(pageNo);
		dp.setPageSize(pageSize);
		dp.setTotal(total);
		dp.setRows(rows);

		return dp;
	}

	public static <VO> DataPackage<VO> createDP(List<VO> rows) {
		return createDP(rows, 20, 1, null);
	}

	public static <VO> DataPackage<VO> emptyDP() {
		DataPackage<VO> dp = new DataPackage<VO>();
		dp.setRows(new ArrayList<VO>());
		return dp;
	}

	public static <VO> ResponseObject<VO> emptyResponseObject() {
		ResponseObject<VO> rspObject = new ResponseObject<VO>();
		DataPackage<VO> dp = new DataPackage<VO>();
		dp.setRows(new ArrayList<VO>());
		rspObject.setData(dp);
		return rspObject;
	}
	
	public static String emptyRsp(){
		return JSONObject.toJSONString(emptyResponseObject());
	}
	
	public static JSONObject toJSONObjectWithDate(Object javaObject, String dateformat) {
		return JSONObject.parseObject(JsonUtil.toJSonWithDate(javaObject, dateformat));
	}

	public static JSONObject toJSONObject(Object javaObject) {
		return JSONObject.parseObject(JsonUtil.toJSonWithDate(javaObject));
	}
	
	public static JSONObject toJSONObject(Object javaObject,SerializeFilter filter) {
		return JSONObject.parseObject(JsonUtil.toJSon(javaObject, DateToolkit.DEFAULT_DATEFORMAT, filter));
	}

	public static <VO> boolean isNotEmptyDP(DataPackage<VO> dp) {
		return null != dp && CollectionUtils.isNotEmpty(dp.getRows());
	}

	public static <VO> boolean isEmptyDP(DataPackage<VO> dp) {
		return !isNotEmptyDP(dp);
	}
}

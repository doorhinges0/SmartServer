package com.dtsjy.mdboss.common.utils.json;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.dtsjy.mdboss.common.utils.bean.BeanUtils;
import com.dtsjy.mdboss.common.utils.bean.ParserUtil;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.date.DateToolkit;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

/**
 * 1.针对日期格式，对fastJson作特殊处理。 2.
 * 
 * @author livan.c
 *
 */
public class JsonUtil {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
	public final static JSONObject EMPTY_OBJ = new JSONObject();
	
	public final static JSONArray EMPTY_ARRAY = new JSONArray();

	public static void main(String[] args) throws Exception {
		/*
		 * UserVO user = new UserVO(); user.setAddress("地址1");
		 * user.setLeader("ddd"); user.setPassword("dddd");
		 * 
		 * UserVO user2 = new UserVO(); user2.setAddress("地址2");
		 * user2.setLeader("ddd1"); user2.setPassword("dddd1");
		 * 
		 * List<UserVO> users = new ArrayList<UserVO>(); users.add(user);
		 * users.add(user2); ValueUsingPropertyFilter filter = new
		 * ValueUsingPropertyFilter(); filter.include("leader", "ddd");
		 * filter.getIncludes().add("address");
		 */
		// filter.exclude("password", "dddd");
		/*
		 * System.out.println(toJSon(users, new ValueFilter() {
		 * 
		 * public Object process(Object object, String name, Object value) { if
		 * ("leader".equals(name)){ return "蔡万里"; } return value; } }));
		 * 
		 * System.out.println(toJSon(users, new NameFilter() {
		 * 
		 * public String process(Object object, String name, Object value) { if
		 * ("leader".equals(name)){ return "王建"; } return name; } }));
		 */
		/*
		 * System.out.println(toJSon(users, new BeforeFilter() {
		 * 
		 * @Override public void writeBefore(Object object) { UserVO user =
		 * (UserVO)object; System.out.println(user.getUsername());
		 * System.out.println(user.getUsercode()); JSONObject obj = new
		 * JSONObject(); obj.put("aa", "asdfdsafds"); object = obj; } }));
		 * 
		 * JSON.toJavaObject( JSON.parseArray(json), List.class);
    	    List<User> dates = JSON.parseObject(json, new com.alibaba.fastjson.TypeReference<List<User>>(){});
		 */

		String json = "{'a':3,'t':[1,2,3],'b':{'c':[{'usercode':'dddd','username':'ddddd','f':{'sf':3}}],'t':5}}";
		// System.out.println(getPropertyOfJson(json, "b.c", List.class));
		// List<String> nameList = new ArrayList<String>();
		// List<Integer> idxList = new ArrayList<Integer>();
		// List<String> keyList = new ArrayList<String>();
		// ParserUtil.analyzeName("a.b[0](a).d.r(f)", nameList, idxList,
		// keyList);
		// System.err.println(1);

//		JSONObject j = JSONObject.parseObject(json);
//		DictItemVO tVo = new DictItemVO();
//		tVo.setDictcode("dd");
//		setPropertyOfJson(j.getJSONArray("t"), "[0]", tVo);
//		System.out.println(getPropertyOfJson(j.getJSONArray("t"), "[0]",
//				Integer.class));
		
		// System.out.println(getPropertyOfJson(j, "b.c[0].dictcode",
		// DictItemVO.class));

		// JSONArray s = JsonUtil.getPropertyOfJson(j, "b.c", JSONArray.class);
		// s.remove(0);
		//
		// BeanUtils.getProperty(j, "b.c");
		// System.out.println(JsonUtil.getPropertyOfJson(j, "b.c",
		// String[].class.getComponentType()));//数组class
		
		
		System.out.println(Integer.MAX_VALUE);
	}

	public static String toJsonExcludeAndDate(Object object, String excludes,
			String dateFormat) {
		SimplePropertyPreFilter filter = makeFilter(null, excludes, null);
		return toJSon(object, dateFormat, filter);
	}

	public static String toJsonExclude(Object object, String excludes) {
		SimplePropertyPreFilter filter = makeFilter(null, excludes, null);
		return toJSon(object, filter);
	}

	public static String toJsonExclude(Object object, Class<?> filterType,
			String excludes) {
		SimplePropertyPreFilter filter = makeFilter(filterType, excludes, null);
		return toJSon(object, filter);
	}

	public static String toJsonIncludeAndDate(Object object, String includes,
			String dateFormat) {
		SimplePropertyPreFilter filter = makeFilter(null, null, includes);
		return toJSon(object, dateFormat, filter);
	}

	public static String toJsonInclude(Object object, String includes) {
		SimplePropertyPreFilter filter = makeFilter(null, null, includes);
		return toJSon(object, filter);
	}

	public static String toJsonInclude(Object object, Class<?> filterType,
			String includes) {
		SimplePropertyPreFilter filter = makeFilter(filterType, null, includes);
		return toJSon(object, filter);
	}

	public static String toJson(Object object, String excludes, String includes) {
		SimplePropertyPreFilter filter = makeFilter(null, excludes, includes);
		return toJSon(object, filter);
	}

	public static String toJson(Object object, Class<?> filterType,
			String excludes, String includes) {
		SimplePropertyPreFilter filter = makeFilter(filterType, excludes,
				includes);
		return toJSon(object, filter);
	}

	public static String toJSon(Object object, SerializeFilter filter) {
		return toJSon(object, null, filter);
	}

	public static String toJSon(Object object, SerializeFilter[] filters) {
		return toJSon(object, null, filters);
	}

	/**
	 * 同时支持日期处理与字段过滤
	 * 
	 * @param object
	 * @param dateFormt
	 * @param filter
	 * @return
	 */
	public static String toJSon(Object object, String dateFormt,
			SerializeFilter filter) {
		return toJSon(object, dateFormt, new SerializeFilter[] { filter });
	}

	/**
	 * 同时支持日期处理与字段过滤,多个字段过滤处理器
	 * 
	 * @param object
	 * @param dateFormt
	 * @param filter
	 * @return
	 */
	public static String toJSon(Object object, String dateFormat,
			SerializeFilter[] filters) {
		SerializeConfig config = new SerializeConfig();
		if (StringToolkit.isNotEmpty(dateFormat)) {
			config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
		}
		return JSON.toJSONString(object, config, filters,
				SerializerFeature.WriteMapNullValue);
	}

	// 自定义日期格式
	public static String toJSonWithDate(Object json, String dateFormat) {
		return JSON.toJSONStringWithDateFormat(json, dateFormat,
				SerializerFeature.WriteMapNullValue);
	}

	// 日期格式：yyyy-MM-dd HH:mm:ss
	public static String toJSonWithDate(Object json) {
		return JSON.toJSONStringWithDateFormat(json,
				DateToolkit.DEFAULT_DATEFORMAT,
				SerializerFeature.WriteMapNullValue);
	}

	// 日期格式：yyyy-MM-dd HH:mm:ss
	public static final <T> T parseObject(String input, TypeReference<T> type) {
		return parseObject(input, type.getType(),
				DateToolkit.DEFAULT_DATEFORMAT);
	}
	
	// 自定义日期格式
	public static final <T> T parseObjectWithDate(String input, Class clazz) {
		ParserConfig config = new ParserConfig();
		config.putDeserializer(Date.class, new CustomDateFormatDeserializer(DateToolkit.DEFAULT_DATEFORMAT));
		return JSON.parseObject(input, clazz, config, null,
				JSON.DEFAULT_PARSER_FEATURE);
	}

	// 日期格式：yyyy-MM-dd HH:mm:ss
	public static final <T> T parseObject(String input, Type clazz) {
		return parseObject(input, clazz, DateToolkit.DEFAULT_DATEFORMAT);
	}

	// 自定义日期格式
	public static final <T> T parseObject(String input, TypeReference<T> type,
			String dateFormat) {
		return parseObject(input, type.getType(), dateFormat);
	}

	// 自定义日期格式
	public static final <T> T parseObject(String input, Type clazz,
			String dateFormat) {

		ParserConfig config = new ParserConfig();
		config.putDeserializer(Date.class, new CustomDateFormatDeserializer(
				dateFormat));
		return JSON.parseObject(input, clazz, config, null,
				JSON.DEFAULT_PARSER_FEATURE);
	}

	/**
	 * 自动识别日期模式
	 * 
	 * @see DateToolkit#NORMAL_DATEFORMATS
	 * @param input
	 * @param type
	 * @return
	 */
	public static final <T> T parseObjectWithNormalDate(String input,
			TypeReference<T> type) {
		for (String dateFormat : DateToolkit.NORMAL_DATEFORMATS) {
			try {
				return parseObject(input, type.getType(), dateFormat);
			} catch (Exception e) {
				// do nothing
			}
		}

		return null;
	}

	/**
	 * 自动识别日期模式
	 * 
	 * @see DateToolkit#NORMAL_DATEFORMATS
	 * @param input
	 * @param type
	 * @return
	 */
	public static final <T> T parseObjectWithNormalDate(String input, Type clazz) {
		for (String dateFormat : DateToolkit.NORMAL_DATEFORMATS) {
			try {
				return parseObject(input, clazz, dateFormat);
			} catch (Exception e) {
				// do nothing
			}
		}

		return null;
	}

	/**
	 * 创建json序列化过滤器
	 * 
	 * @param filterType
	 * @param excludes
	 * @param includes
	 * @return
	 */
	public static ValueUsingPropertyFilter makeFilter(Class<?> filterType,
			String excludes, String includes) {
		ValueUsingPropertyFilter filter = new ValueUsingPropertyFilter(
				filterType);
		if (StringToolkit.isNotEmpty(excludes)) {
			filter.getExcludes().addAll(
					CollectionUtils.arrayToList(excludes.split(",")));
		}
		if (StringToolkit.isNotEmpty(includes)) {
			filter.getIncludes().addAll(
					CollectionUtils.arrayToList(includes.split(",")));
		}

		return filter;
	}
	
	/**
	 * 转换 JSONObject 报错不处理，返回 static 的空 JSONObject
	 * @param text
	 * @return
	 */
	public static JSONObject parseJSONObject(String text) {
		try {
			return JSONObject.parseObject(text);
		} catch (Exception e) {
			// don't have to hanlde
		}
		return EMPTY_OBJ;
	}
	
	/**
	 * 转换 JSONArray 报错不处理，返回 static 的空 JSONArray
	 * @param text
	 * @return
	 */
	public static JSONArray parseJSONArray(String text) {
		try {
			return JSONArray.parseArray(text);
		} catch (Exception e) {
			// don't have to hanlde
		}
		return EMPTY_ARRAY;
	}

	/**
	 * 把逗号分隔的字符串转换为JsonArray对象，如果str为空或null，返回空的JsonArray对象
	 * 
	 * @param str
	 * @return
	 */
	public static JSONArray parseArray(String str) {
		JSONArray codes = new JSONArray();
		if (StringToolkit.isNotEmpty(str)) {
			for (String groupcode : str.split(",")) {
				codes.add(groupcode);
			}
		}

		return codes;
	}

	/**
	 * Check if the Object is in JsonObject-compliant format.
	 * 
	 * @param value
	 *            Object to be checked.
	 * @return true or false
	 */
	public static boolean isJsonObject(Object value) {
		if (null == value) {
			return false;
		}
		if ("".equals(value.toString())){
			return false;
		}
		try {
			if (JSONObject.class.isAssignableFrom(value.getClass())) {
				return true;
			}

			JSONObject.parseObject(value.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check if the Object is in JSONArray-compliant format.
	 * 
	 * @param value
	 *            Object to be checked.
	 * @return true or false
	 */
	public static boolean isJSONArray(Object value) {
		if (StringToolkit.isEmpty(value)) {
			return false;
		}

		try {
			if (JSONArray.class.isAssignableFrom(value.getClass())) {
				return true;
			}

			JSONArray.parseArray(value.toString());
			return true;
		} catch (Exception e) {
			return false;// 发生异常，说明非JSONArray格式
		}
	}

	/**
	 * 从json对象中获取指定属性路径的值
	 * 
	 * @param jsonStr
	 *            json格式字符串
	 * @param propPath
	 *            属性路径，如:a.b[0].c
	 * @param clazz
	 *            返回对象类型
	 * @return 返回指定类型的对象
	 */
	public static <T> T getPropertyOfJson(String jsonStr, String propPath,
			Class<T> clazz) {
		if (StringToolkit.isEmpty(jsonStr) || StringToolkit.isEmpty(propPath)) {
			return null;
		}

		T ret = null;

		if (isJsonObject(jsonStr)) {
			Object object = BeanUtils.getProperty(
					JSONObject.parseObject(jsonStr), propPath);
			if (object instanceof JSONObject) {
				ret = JSONObject.toJavaObject((JSONObject) object, clazz);
			} else if (object instanceof JSONArray) {
				ret = JSONArray.toJavaObject((JSONArray) object, clazz);
			} else {
				ret = (T) object;
			}
		} else if (isJSONArray(jsonStr)) {
			Object object = BeanUtils.getProperty(
					JSONArray.parseArray(jsonStr), propPath);
			if (object instanceof JSONObject) {
				ret = JSONObject.toJavaObject((JSONObject) object, clazz);
			} else if (object instanceof JSONArray) {
				ret = JSONArray.toJavaObject((JSONArray) object, clazz);
			} else {
				ret = (T) object;
			}
		}

		return ret;
	}

	/**
	 * 从json对象中获取指定属性路径的值
	 * 
	 * @param json
	 *            JsonObject对象
	 * @param propPath
	 *            属性路径，如:a.b[0].c
	 * @param clazz
	 *            返回对象类型
	 * @return 返回指定类型的对象
	 */
	public static <T> T getPropertyOfJson(JSON json, String propPath,
			Class<T> clazz) {
		if (null == json) {
			return null;
		}
		T ret = null;
		Object object = BeanUtils.getProperty(json, propPath);
		if (object instanceof JSONObject) {
			ret = JSONObject.toJavaObject((JSONObject) object, clazz);
		} else if (object instanceof JSONArray) {
			ret = JSONArray.toJavaObject((JSONArray) object, clazz);
		} else {
			ret = (T) object;
		}

		// if (isJsonObject(json)) {
		// Object object = BeanUtils.getProperty(json, propPath);
		// if (object instanceof JSONObject) {
		// ret = JSONObject.toJavaObject((JSONObject) object, clazz);
		// } else if (object instanceof JSONArray) {
		// ret = JSONArray.toJavaObject((JSONArray) object, clazz);
		// } else {
		// ret = (T) object;
		// }
		// } else if (isJSONArray(json)) {
		// Object object = BeanUtils.getProperty(json, propPath);
		// if (object instanceof JSONObject) {
		// ret = JSONObject.toJavaObject((JSONObject) object, clazz);
		// } else if (object instanceof JSONArray) {
		// ret = JSONArray.toJavaObject((JSONArray) object, clazz);
		// } else {
		// ret = (T) object;
		// }
		//
		// ret = JSONObject.toJavaObject(
		// (JSONObject) BeanUtils.getProperty(json, propPath), clazz);
		// }

		return ret;
	}

	/**
	 * 
	 * @param jsonStr
	 * @param propPath
	 * @param val
	 * @return
	 */
	public static JSONObject setPropertyOfJson(String jsonStr, String propPath,
			Object val) {
		if (StringToolkit.isNotEmpty(jsonStr)
				&& StringToolkit.isNotEmpty(propPath)) {
			JSONObject json = JSONObject.parseObject(jsonStr);
			setPropertyOfJson(json, propPath, val);
			return json;
		}
		return null;
	}

//	public static boolean containsPropertyOfJson(JSON json, String propPath) {
//		
//	}

	/**
	 * 根据属性路径，设置json对象的属性值，如果路径中的某个属性不存在则新建对象
	 * 
	 * @param json
	 *            json对象
	 * @param propPath
	 *            属性路径 ,如:a.b[0].c
	 * @param val
	 *            属性值
	 */
	public static void setPropertyOfJson(JSON json, String propPath, Object val) {
		if (null != json && StringToolkit.isNotEmpty(propPath)) {

			List<String> nameList = new ArrayList<String>();
			List<Integer> idxList = new ArrayList<Integer>();
			List<String> keyList = new ArrayList<String>();
			try {
				ParserUtil.analyzeName(propPath, nameList, idxList, keyList);
				String tName = "";
				Object bean = json;
				int idxNum = 0;
				int keyNum = 0;
				for (int i = 0; i < nameList.size(); i++) {
					tName = nameList.get(i);
					if ((i + 1) == nameList.size()) {
						if (ParserUtil.IDX_MODEL.equals(tName)) {
							int index = idxList.get(idxNum++);
							JSONArray arr = (JSONArray) bean;
							//arr.set(index, val);
							arr.add(index, val);
						} else {
							BeanUtils.setProperty((Serializable) bean, tName,
									val);
						}
						break;
					}

					if (ParserUtil.IDX_MODEL.equals(tName)) {
						int index = idxList.get(idxNum++);
						bean = BeanUtils.getIdxProperty(bean, index);
					} else if (ParserUtil.MAP_MODEL.equals(tName)) {
						String key = keyList.get(keyNum++);
						bean = BeanUtils.getMapProperty(bean, key);
					} else if (ParserUtil.NESTED_MODEL.equals(tName)) {
						continue;
					} else {
						if (BeanUtils.containsProperty(bean, tName)) {
							Object tmpBean = BeanUtils.getProperty(bean, tName);
							if (ParserUtil.IDX_MODEL
									.equals(nameList.get(i + 1))) {
								if (!(tmpBean instanceof JSONArray)) {
									tmpBean = new JSONArray();
									BeanUtils.setProperty((Serializable) bean,
											tName, tmpBean);
								}
							} else if (ParserUtil.NESTED_MODEL.equals(nameList
									.get(i + 1))) {
								if (!(tmpBean instanceof JSONObject)) {
									tmpBean = new JSONObject();
									BeanUtils.setProperty((Serializable) bean,
											tName, tmpBean);
								}
							}
							bean = tmpBean;
						} else {
							Object tmpBean = null;
							if (ParserUtil.IDX_MODEL
									.equals(nameList.get(i + 1))) {
								tmpBean = new JSONArray();
							} else if (ParserUtil.NESTED_MODEL.equals(nameList
									.get(i + 1))) {
								tmpBean = new JSONObject();

							}
							BeanUtils.setProperty((Serializable) bean, tName,
									tmpBean);
							bean = tmpBean;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}

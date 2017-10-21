package com.dtsjy.mdboss.common.utils;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.dtsjy.mdboss.common.model.QueryCondition;
import com.dtsjy.mdboss.common.services.QueryOperate;
import com.dtsjy.mdboss.common.utils.date.DateToolkit;
import com.dtsjy.mdboss.common.utils.json.JsonUtil;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class TranslateUtils {
	
	public static final String[] V1_QUERYOPERATORS = new String[]{QueryOperate.D_IN,QueryOperate.D_NOT_IN,QueryOperate.EQUAL_TO,QueryOperate.GREATER_THAN,
			QueryOperate.GREATER_THAN_OR_EQUAL_TO,QueryOperate.IN,QueryOperate.LESS_THAN,QueryOperate.LESS_THAN_OR_EQUAL_TO,QueryOperate.LIKE,
			QueryOperate.NOT_EQUAL_TO,QueryOperate.NOT_IN,QueryOperate.NOT_LIKE,QueryOperate.START_WITH,QueryOperate.ENDS_WITH};
	
	public static final String[] V1_V2_QUERYOPERATORS = new String[]{QueryOperate.BETWEEN,QueryOperate.NOT_BETWEEN};
	
	
	/**
	 * 一般用法： Criteria criteria = xxxxVOExample.createCriteria();
	 * TranslateUtils.inject2Criteria(criteria, conditions);
	 * 
	 * 
	 * 
	 * TODO 整合CommonService里面类似的代码，减少重复逻辑
	 * 
	 * @param criteria
	 *            会被注入相应的数据
	 * @param conditions
	 */
	public static void inject2Criteria(Object criteria,
			final List<QueryCondition> conditions) throws Exception {

		HashMap<String, Method> mMap = new HashMap<String, Method>();
		Method[] ms = criteria.getClass().getMethods();
		for (Method m : ms) {
			mMap.put(m.getName(), m);
		}

		for (QueryCondition condition : conditions) {
			String key = condition.getKey();
			String operate = condition.getOperate();
			Object v1 = condition.getV1();
			Object v2 = condition.getV2();
			
			if (ArrayUtils.contains(V1_QUERYOPERATORS, operate)){
				if (StringToolkit.isEmpty(v1)){
					continue;//忽略空值，包括null,""
				}
			}else if (ArrayUtils.contains(V1_V2_QUERYOPERATORS, operate)){
				if (StringToolkit.isEmpty(v1) || StringToolkit.isEmpty(v2)){
					continue;
				}
			}

			
			if (QueryOperate.IS_NULL.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.IS_NULL);
				criteriaMethod.invoke(criteria, new Object[] {});
			} else if (QueryOperate.IS_NOT_NULL.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.IS_NOT_NULL);
				criteriaMethod.invoke(criteria, new Object[] {});
			} else if (QueryOperate.EQUAL_TO.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.EQUAL_TO);
				if (StringToolkit.isEmpty(v1)){
					continue;//忽略空值，包括null,""
				}
				v1 = transValue(criteriaMethod.getParameterTypes()[0], v1);
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.NOT_EQUAL_TO.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.NOT_EQUAL_TO);
				v1 = transValue(criteriaMethod.getParameterTypes()[0], v1);
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.GREATER_THAN.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.GREATER_THAN);
				v1 = transValue(criteriaMethod.getParameterTypes()[0], v1);
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.GREATER_THAN_OR_EQUAL_TO
					.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.GREATER_THAN_OR_EQUAL_TO);
				v1 = transValue(criteriaMethod.getParameterTypes()[0], v1);
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.LESS_THAN.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.LESS_THAN);
				v1 = transValue(criteriaMethod.getParameterTypes()[0], v1);
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.LESS_THAN_OR_EQUAL_TO
					.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.LESS_THAN_OR_EQUAL_TO);
				v1 = transValue(criteriaMethod.getParameterTypes()[0], v1);
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.LIKE.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.LIKE);
				criteriaMethod.invoke(criteria, StringToolkit.wrapString(v1, "%"));
			} else if (QueryOperate.NOT_LIKE.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.NOT_LIKE);
				criteriaMethod.invoke(criteria, StringToolkit.wrapString(v1, "%"));
			} else if (QueryOperate.START_WITH.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.LIKE);
				criteriaMethod.invoke(criteria, v1 + "%");
			}  else if (QueryOperate.ENDS_WITH.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.LIKE);
				criteriaMethod.invoke(criteria, "%" + v1);
			}  else if (QueryOperate.BETWEEN.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.BETWEEN);
				v1 = transValue(criteriaMethod.getParameterTypes()[0], v1);
				v2 = transValue(criteriaMethod.getParameterTypes()[1], v2);
				criteriaMethod.invoke(criteria, v1, v2);
			} else if (QueryOperate.NOT_BETWEEN.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.NOT_BETWEEN);
				v1 = transValue(criteriaMethod.getParameterTypes()[0], v1);
				v2 = transValue(criteriaMethod.getParameterTypes()[1], v2);
				criteriaMethod.invoke(criteria, v1, v2);
			} else if (QueryOperate.IN.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.IN);
				v1 = JSON.toJavaObject((JSONArray) v1, List.class);
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.NOT_IN.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.NOT_IN);
				v1 = JSON.toJavaObject((JSONArray) v1, List.class);
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.D_IN.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.IN);
				v1 = JsonUtil.parseObjectWithNormalDate(v1.toString(),
						new TypeReference<List<Date>>() {
						});
				criteriaMethod.invoke(criteria, v1);
			} else if (QueryOperate.D_NOT_IN.equalsIgnoreCase(operate)) {
				Method criteriaMethod = getCriteriaMethod(mMap, key,
						QueryOperate.NOT_IN);
				v1 = JsonUtil.parseObjectWithNormalDate(v1.toString(),
						new TypeReference<List<Date>>() {
						});
				criteriaMethod.invoke(criteria, v1);
			}
		}
	}

	static private Method getCriteriaMethod(HashMap<String, Method> mMap,
			String key, String operate) {
		String methodName = "and" + key.substring(0, 1).toUpperCase()
				+ key.substring(1) + operate;
		if (mMap.containsKey(methodName)) {
			return mMap.get(methodName);
		} else {
			throw new RuntimeException("error methodName:" + methodName);
		}
	}

	static private Object transValue(Class<?> paramClass, Object v1) {
		if (Date.class.equals(paramClass)) {
			if (v1 instanceof Long) {
				return new Date((Long) v1);
			} else if (v1 instanceof String) {
				Date date = DateToolkit.normalDate(v1.toString());
				return null != date ? date : v1;
			}
		} else {
			try {
				return ConvertUtils.convert(v1, paramClass);
			} catch (Exception e) {
				// no need to handle exception
			}
		}
		return v1;
	}

}

package com.dtsjy.mdboss.common.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;

import com.alibaba.fastjson.JSONObject;
import com.dtsjy.mdboss.common.dal.ext.model.DefaultVOParser;
import com.dtsjy.mdboss.common.dal.ext.model.VOParser;
import com.dtsjy.mdboss.common.model.SerialNoHolder4Rest;
import com.dtsjy.mdboss.common.model.config.TableConfigFacade;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.dal.DalNameUtil;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableColumnConfigVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.UserVO;

public class VOHandler {
	
	private static Logger logger = LoggerFactory.getLogger(VOHandler.class);

	private static VOParser getDefaultVoParser() {
		VOParser voParser = null;
		try {
			voParser = new DefaultVOParser();
		} catch (BeansException e) {
			// do nothing
		}

		return voParser;
	}

	private static VOParser getVOParser(String parserName) {
		VOParser voParser = null;
		try {
			voParser = SpringCtxUtils.getBean(parserName, VOParser.class);
		} catch (BeansException e) {
			// do nothing
		}
		if (null == voParser) {
			voParser = getDefaultVoParser();
		}

		return voParser;
	}

	public static void beforeCreate(Object vo, String voJson) {
		String parserName = vo.getClass().getName();
		VOParser voParser = getVOParser(parserName);
		if (null != voParser) {
			voParser.beforeCreate(vo, voJson);
		}

	}

	public static void afterCreate(Object vo, String voJson) {
		String parserName = vo.getClass().getName();
		VOParser voParser = getVOParser(parserName);
		if (null != voParser) {
			voParser.afterCreate(vo, voJson);
		}

	}

	public static void beforeVOUpdate(Object vo, String requestJson) {
		String parserName = vo.getClass().getName();
		VOParser voParser = getVOParser(parserName);
		if (null != voParser) {
			voParser.beforeVOUpdate(vo, requestJson);
		}
	}

	public static void afterVOUpdate(Object vo, String voJson, Object result) {
		String parserName = vo.getClass().getName();
		VOParser voParser = getVOParser(parserName);
		if (null != voParser) {
			voParser.afterVOUpdate(vo, voJson, result);
		}
	}

	public static void beforeSelect(String mapperName, Object example, String json) {
		String parserName = DalNameUtil.getVoNameByMapperName(mapperName);
		VOParser voParser = getVOParser(parserName);
		if (null != voParser) {
			voParser.beforeSelect(example, json);
		}
	}

	public static void afterSelect(Object results, int amount, String mapperName,
			Object example, String json) {
		String parserName = DalNameUtil.getVoNameByMapperName(mapperName);
		VOParser voParser = getVOParser(parserName);
		if (null != voParser) {
			voParser.afterSelect(results, amount, example, json);
		}
	}
	
	/**
	 * 将是否 tableColumnConfig 设置到线程
	 * 只执行一次 queryTableConfigColumn 查询, 而不是在 TableConfigAfterPropertyFilter 里处理。
	 * @param fullVOName
	 */
	public static void setTableConfigToThreadLocal(String fullVOName) {
		try {
			Map<String, List<TableColumnConfigVO>> configMap = SerialNoHolder4Rest.TableColumnConfig.get();
			Map<String, Boolean> booleanMap = SerialNoHolder4Rest.convertMap.get();
			if (configMap == null) {
				configMap = new HashMap<String, List<TableColumnConfigVO>>();
				booleanMap = new HashMap<String, Boolean>();
				SerialNoHolder4Rest.TableColumnConfig.set(configMap);
				SerialNoHolder4Rest.convertMap.set(booleanMap);
			}
			TableConfigFacade tableConfig = SpringCtxUtils.getBean(TableConfigFacade.class);
			List<TableColumnConfigVO> configs = tableConfig.queryTableConfigColumn(
					fullVOName, UcpModel.TABLE_COLUMNTYPE_EXT.value());
			
			booleanMap.put(fullVOName, CollectionUtils.isNotEmpty(configs));
			configMap.put(fullVOName, configs);
		} catch (Exception e) {
			logger.error("tableConfig.queryTableConfigColumn error", e);
			SerialNoHolder4Rest.convertMap.set(null);
		}
	}
	
	/**
	 * 在此处进行 code2name
	 * @param rows
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void tableConfigAfterPropertyFilter(Object rows) {
		boolean enable = false;
		if (enable && rows != null) {
			if (rows instanceof List) {
				List objs = (List) rows;
				if (!objs.isEmpty()) {
					String className = objs.get(0).getClass().getName();
				}
			}
		}

		
//		object.getClass().getName();
//		String parserName = DalNameUtil.getVoNameByMapperName(mapperName);
//		VOParser voParser = getVOParser(parserName);
//		if (null != voParser) {
//			voParser.afterSelect(results, amount, example, json);
//		}
		
		System.out.println(rows);
	}
	
	public static void main(String[] args) {
		UserVO vo = new UserVO();
		vo.setBirthday(new java.util.Date());
		vo.setUsercode("000000");
		vo.setUsername("Dylan");
		System.out.println(JSONObject.toJSONString(vo));
	}
}

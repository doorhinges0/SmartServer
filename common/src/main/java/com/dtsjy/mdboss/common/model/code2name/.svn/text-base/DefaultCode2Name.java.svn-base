package com.dtsjy.mdboss.common.model.code2name;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.dtsjy.mdboss.common.dal.ext.dao.Code2NameMapper;
import com.dtsjy.mdboss.common.model.BaseQuery;
import com.dtsjy.mdboss.common.model.DataPackage;
import com.dtsjy.mdboss.common.model.QueryCondition;
import com.dtsjy.mdboss.common.model.SerialNoHolder;
import com.dtsjy.mdboss.common.model.constants.UcpModel;
import com.dtsjy.mdboss.common.services.CommonService;
import com.dtsjy.mdboss.common.services.CommonServiceUtils;
import com.dtsjy.mdboss.common.services.QueryOperate;
import com.dtsjy.mdboss.common.utils.JsonResponseUtils;
import com.dtsjy.mdboss.common.utils.SpringCtxUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.dal.QueryParser;
import com.dtsjy.mdboss.common.utils.json.JsonUtil;
import com.dtsjy.mdboss.common.utils.log.LogUtils;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;

public class DefaultCode2Name implements Code2Name {
	private static Logger log = LoggerFactory.getLogger(DefaultCode2Name.class);

	public DefaultCode2Name() {
	}

	/**
	 * 编码转化为名称
	 * 
	 * @param definition
	 *            code2name.xml 中项目的名称
	 * @param codeValue
	 * @return 名称
	 */
	public String code2Name(String def, String codeValue, String userCode) {

		if (codeValue == null)
			return "";
		String definition = formateDefinition(def);
		String value = "";
		try {
			if (def.startsWith("#")) {
				// 动态数据，根据VO查询
				// //Code2NameConfiger.sysMap.containsKey(definition)
				// 如果是数据字典参数， 需要在 code2name.xml 中配置字典VO
				Node node = (Node) Code2NameConfiger.sysMap.get(definition);

				if (node == null)
					throw new NullPointerException(
							"Can't find code2name definition " + def);
				BaseQuery query = new BaseQuery();
				Class voClass = Class.forName(node.getValueObject());
				query.addCondition(node.getCode(), QueryOperate.EQUAL_TO,
						Code2NameUtil.convertValueAsPropertyType(voClass,
								node.getCode(), codeValue));
				//配置文件中配置了condition
				if (StringToolkit.isNotEmpty(node.getCondition())){
					convert2Param(query,voClass, node.getCondition(), definition); // 将condition中的条件添加到查询参数上
				}
				
				if (node.getSql() != null) {
					StringBuffer sql = new StringBuffer("select t.")
							.append(node.getCode()).append(",t.")
							.append(node.getName()).append(" from (")
							.append(node.getSql()).append(") t ");

					sql.append(new QueryParser().parseWhereClause(query,
							voClass));

					Code2NameMapper code2NameMapper = SpringCtxUtils
							.getBean(Code2NameMapper.class);
					List<Map<String, Object>> pairs = code2NameMapper
							.code2Name(sql.toString());
					if (CollectionUtils.isNotEmpty(pairs)) {
						Object nameValue = pairs.get(0).get(node.getName());
						if (nameValue != null)
							value = StringToolkit.getObjectString(nameValue);
					}
				} else {
					CommonService service = Code2NameUtil.getService(node
							.getValueObject());
					String voName = Code2NameUtil.geVoNameFromVoClsName(node
							.getValueObject());
					String rsp = service.selectByExample(
							Code2NameUtil.getApp(node.getValueObject()),
							SerialNoHolder.serialNo.get(), userCode, voName,
							JsonUtil.toJSonWithDate(query));
					JSONArray arr = JsonResponseUtils.getRowsFormResponse(rsp);
					if (CollectionUtils.isNotEmpty(arr)) {
						value = arr.getJSONObject(0).getString(node.getName());
					} else {
						value = codeValue;
					}
				}

				LogUtils.debug(log, "[code2name dictitem]#code:" + codeValue
						+ ",value:" + value + ",userCode:" + userCode);

			} else if (def.startsWith("$")) {

				Node node = (Node) Code2NameConfiger.sysMap.get("$");
				if (node == null)
					throw new NullPointerException(
							"Can't find code2name definition " + def);

				DictItemVO dict = CommonServiceUtils.getDictItem(definition,
						codeValue);
				value = StringToolkit.getObjectString(
						dict.getDictname(), codeValue);
				LogUtils.debug(log, "[code2name table]$code:" + codeValue
						+ ",value:" + value + ",userCode:" + userCode);

			} else if (Code2NameConfiger.localMap.containsKey(definition)) { // 配置的固定参数
				LocalNote localcode = (LocalNote) Code2NameConfiger.localMap
						.get(definition);

				if (localcode == null)
					throw new NullPointerException(
							"Can't find code2name definition " + def);

				value = localcode.getValue(codeValue.toString());
				LogUtils.debug(log, "[code2name configed]$code:" + codeValue
						+ ",value:" + value + ",userCode:" + userCode);

			} else {
				LogUtils.error(log, "未知的 code2name definition " + definition);
				return codeValue;
			}
			
//			if (StringToolkit.isEmpty(value)){
//				value = codeValue;
//			}
			
			return value;
		} catch (Exception e) {
			LogUtils.error(log, "编码转化时发生错误! " + e.getMessage());
			return codeValue;
		}
	}

	/**
	 * 获取某个字典项或数据的所有可用编码名称
	 * @param definition
	 * @param dbFlag
	 */
	public Map valueList(String definition, String userCode) {
		return valueList(definition, null, userCode);
	}

	public Map valueList(String def, String condition, String userCode) {
		return valueList(def, condition, null, userCode);
	}

	public Map valueList(String def, String condition, BaseQuery param,
			String userCode) {
		String definition = formateDefinition(def);
		Map values = null;
		try {
			if (def.startsWith("#") || def.startsWith("$")) {
				DataPackage dp = valueListPackage(def, condition, param,
						userCode);

				if (JsonResponseUtils.isNotEmptyDP(dp)){
					values = new LinkedHashMap(dp.getRows().size());
					// //将数据转换为 map
					for (int i = 0; i < dp.getRows().size(); i++) {
						Node node = (Node) dp.getRows().get(i);
						values.put(node.getCode(), node.getName());
					}
				}
			} else if (Code2NameConfiger.localMap.containsKey(definition)) { // 配置的固定参数
				LocalNote localcode = (LocalNote) Code2NameConfiger.localMap
						.get(definition);
				values = localcode.getItems();
			} else {
				LogUtils.error(log, "未知的 code2name definition " + definition);
			}
		} catch (Exception e) {
			LogUtils.error(log, "编码转化时发生错误! " + e.getMessage());

		}
		return values;
	}

	/**
	 * picker 需要DataPackage 型的数据，下拉框需要Map型的数据
	 */
	public DataPackage valueListPackage(String def, String condition,
			BaseQuery param, String userCode) {

		if (!(def.startsWith("#") || def.startsWith("$"))) {
			throw new IllegalArgumentException(
					"非单表型编码或数据字典查询，请使用 valueList 方法：" + def);
		}
		DataPackage dp = null;
		String definition = formateDefinition(def);
		try {
			// 动态数据，根据VO查询 //Code2NameConfiger.sysMap.containsKey(definition)
			// 如果是数据字典参数， 需要在 code2name.xml 中配置字典VO
			Node node = null;
			if (def.startsWith("$"))
				definition = "$"; // 数据字典

			node = (Node) Code2NameConfiger.sysMap.get(definition);
			if (node == null)
				throw new IllegalArgumentException(
						"Definition "
								+ def
								+ " not found in code2name.xml! Notice: if it's fixed param, use $"
								+ definition + "!");

			String voClassName = node.getValueObject();
			String codeProperty = node.getCode();
			String nameProperty = node.getName();

			Class voClass = Class.forName(voClassName);
			LogUtils.info(log,"options filter:" + condition);
			if (null == param){
				param = new BaseQuery();
			}
			convert2Param(param,voClass, condition, definition); // 将condition中的条件添加到查询参数上
			if (def.startsWith("#")){
				//配置文件中配置了condition
				if (StringToolkit.isNotEmpty(node.getCondition())){
					convert2Param(param,voClass, node.getCondition(), definition); // 将condition中的条件添加到查询参数上
				}
				
				String queryFields = "";
				if (StringToolkit.isNotEmpty(node.getQueryFields())){
					queryFields = "," + node.getQueryFields();
				}
				if (node.getSql() != null) {
					StringBuffer sql = new StringBuffer("select ")
							.append(node.getCode()).append(",")
							.append(node.getName()).append(queryFields).append(" from (")
							.append(node.getSql()).append(") t ");

					sql.append(new QueryParser().parseWhereClause(param,
							voClass));

					Code2NameMapper code2NameMapper = SpringCtxUtils
							.getBean(Code2NameMapper.class);
					List<Map<String, Object>> pairs = code2NameMapper
							.code2Name(sql.toString());
					dp = JsonResponseUtils.createDP(pairs);
				} else {
					CommonService service = Code2NameUtil.getService(node
							.getValueObject());
					String voName = Code2NameUtil.geVoNameFromVoClsName(node
							.getValueObject());
					String rsp = service.selectByExample(
							Code2NameUtil.getApp(node.getValueObject()),
							SerialNoHolder.serialNo.get(), userCode, voName,
							JsonUtil.toJSonWithDate(param));
					dp = JsonResponseUtils.getPackageFormResponse(rsp, voClass);
				}
				
			}else{//数据字典
				dp = JsonResponseUtils.createDP(CommonServiceUtils.getAppDictItems(formateDefinition(def),UcpModel.APP_CODE.value()));
			}

			if (dp.getRows().size() > 0) {
				Iterator iter = dp.getRows().iterator();
				List list = new ArrayList(dp.getRows().size());
				while (iter.hasNext()) {
					Object item = iter.next();
					Node thisnode = new Node();
					thisnode.setCode(String.valueOf(BeanUtils.getProperty(item,
							codeProperty)));
					thisnode.setName(String.valueOf(BeanUtils.getProperty(item,
							nameProperty)));
					list.add(thisnode);
				}
				dp.getRows().clear();
				dp.setRows(list);
			}

		} catch (Exception e) {
			LogUtils.error("valueListPackage 执行时发生错误! " + e.getMessage());
		}

		if (dp == null) {
			dp = new DataPackage();
			dp.setRows(new ArrayList(0));
			dp.setTotal(0L);
		}
		return dp;
	}

	private String formateDefinition(String definition) {
		if (definition.startsWith("$") || definition.startsWith("#")) {
			return definition.substring(1);
		}
		return definition;
	}

	private BaseQuery convert2Param(BaseQuery param,Class<?> voClass, String condition,
			String definition) {
		if (null == param){
			param = new BaseQuery();
		}
		
		if (StringUtils.isNotBlank(condition)) {
			try {
				String filters[] = condition.split(";");
				for (int i = 0; i < filters.length; i++) {
					String filterPairString = filters[i];
					String[] filterPairArray = filterPairString.split(":");

					String conditionName = filterPairArray[0];
					String conValue = null;
					if (filterPairArray.length > 1)
						conValue = filterPairArray[1];

					if ("CODE".equals(conditionName)) { // CODE要转换为 vo类对应的编码属性名
						conditionName = getCodeProperty(definition);
					}

					if ("NAME".equals(conditionName)) { // NAME要转换为 vo类对应的名称属性名
						conditionName = getNameProperty(definition);
					}

					QueryCondition queryCondition = getQueryCondition(voClass,
							conditionName, conValue);
					if (null != queryCondition){
						param.getQueryCondition().add(queryCondition);
					}
				}

			} catch (Exception e) {
				LogUtils.error(log,"Invalid filter param. ");
			}
		}
		return param;
	}

	private static QueryCondition getQueryCondition(Class<?> voClass,
			String field, String value) throws Exception {
		//code或name为空，不处理
		if (StringToolkit.isEmpty(value) || StringToolkit.isEmpty(field))
			return null;

		QueryCondition queryCondition = new QueryCondition();
		try {
			Object propertyValue = null;
			if (!field.startsWith("_")) {
				queryCondition.setKey(field);
				queryCondition.setOperate(QueryOperate.EQUAL_TO);
				propertyValue = Code2NameUtil.convertValueAsPropertyType(
						voClass, field, value);
				queryCondition.setV1(propertyValue);
			} else {
				String property = field.substring(field.indexOf('_', 1) + 1);
				queryCondition.setKey(property);
				propertyValue = Code2NameUtil.convertValueAsPropertyType(
						voClass, property, value);
				queryCondition.setV1(propertyValue);

				// null条件的处理
				if (field.startsWith("_sn_") || field.startsWith("_dn_")
						|| field.startsWith("_nn_")) {
					queryCondition.setOperate(QueryOperate.IS_NULL);
				} else if (field.startsWith("_snn_")
						|| field.startsWith("_dnn_")
						|| field.startsWith("_nnn_")) {
					queryCondition.setOperate(QueryOperate.IS_NOT_NULL);
				} else {
					if (field.startsWith("_sl_")
							|| field.startsWith("_dl_")
							|| field.startsWith("_nl_")) {
						queryCondition.setOperate(QueryOperate.LESS_THAN);
					} else if (field.startsWith("_snm_")
							|| field.startsWith("_dnm_")
							|| field.startsWith("_nnm_")) {
						queryCondition.setOperate(QueryOperate.LESS_THAN_OR_EQUAL_TO);
					} else if (field.startsWith("_se_")
							|| field.startsWith("_de_")
							|| field.startsWith("_ne_")) {
						queryCondition.setOperate(QueryOperate.EQUAL_TO);
					} else if (field.startsWith("_snl_")
							|| field.startsWith("_dnl_")
							|| field.startsWith("_nnl_")) {
						queryCondition.setOperate(QueryOperate.GREATER_THAN_OR_EQUAL_TO);
					} else if (field.startsWith("_sm_")
							|| field.startsWith("_dm_")
							|| field.startsWith("_nm_")) {
						queryCondition.setOperate(QueryOperate.GREATER_THAN);
					} else if (field.startsWith("_sne_")
							|| field.startsWith("_dne_")
							|| field.startsWith("_nne_")) {
						queryCondition.setOperate(QueryOperate.NOT_EQUAL_TO);
					} else if (field.startsWith("_sin_")
							|| field.startsWith("_din_")
							|| field.startsWith("_nin_")) {
						List<Object> pValue = (List<Object>)propertyValue;
						queryCondition.setV1(pValue.get(0));
						queryCondition.setV2(pValue.get(1));
						queryCondition.setOperate(QueryOperate.IN);
					} else if (field.startsWith("_snin_")
							|| field.startsWith("_dnin_")
							|| field.startsWith("_nnin_")) {
						List<Object> pValue = (List<Object>)propertyValue;
						queryCondition.setV1(pValue.get(0));
						queryCondition.setV2(pValue.get(1));
						queryCondition.setOperate(QueryOperate.NOT_IN);
						
					} else if (field.startsWith("_sk_")) {
						queryCondition.setOperate(QueryOperate.LIKE);
						queryCondition.setV1("%" + propertyValue + "%");
					} else if (field.startsWith("_ssw_")) {
						queryCondition.setOperate(QueryOperate.LIKE);
						queryCondition.setV1("%" + propertyValue);
					} else if (field.startsWith("_sew_")) {
						queryCondition.setOperate(QueryOperate.LIKE);
						queryCondition.setV1(propertyValue + "%");
					} else if (field.startsWith("_snk_")) {
						queryCondition.setOperate(QueryOperate.NOT_LIKE);
						queryCondition.setV1("%" + propertyValue + "%");
					} else if (field.startsWith("_sbw_")
							|| field.startsWith("_dbw_")
							|| field.startsWith("_nbw_")) {
						queryCondition.setOperate(QueryOperate.BETWEEN);
						List<Object> pValue = (List<Object>)propertyValue;
						queryCondition.setV1(pValue.get(0));
						queryCondition.setV2(pValue.get(1));
						
					} else if (field.startsWith("_snbw_")
							|| field.startsWith("_dnbw_")
							|| field.startsWith("_nnbw_")) {
						queryCondition.setOperate(QueryOperate.NOT_BETWEEN);
						List<Object> pValue = (List<Object>)propertyValue;
						queryCondition.setV1(pValue.get(0));
						queryCondition.setV2(pValue.get(1));
					}
				}
			}
		} catch (Exception e) {
			return null;
		}
		return queryCondition;
	}

	public static String getCodeProperty(String definition) throws Exception {
		Node node = (Node) Code2NameConfiger.sysMap.get(definition);
		return node.getCode();
	}

	public static String getNameProperty(String definition) throws Exception {
		Node node = (Node) Code2NameConfiger.sysMap.get(definition);
		return node.getName();
	}
}

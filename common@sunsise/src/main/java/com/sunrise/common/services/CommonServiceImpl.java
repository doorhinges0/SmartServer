package com.sunrise.common.services;

import com.sunrise.common.dal.ext.dao.GeneralMapper;
import com.sunrise.common.model.code2name.Code2Name;
import com.sunrise.common.model.impl.DefaultQueyGetter;
import com.sunrise.common.utils.JsonResponseUtils;
import com.sunrise.common.utils.bean.BeanUtils;
import com.sunrise.common.utils.dal.DalNameUtil;
import com.sunrise.common.utils.dal.QueryParser;
import com.sunrise.common.utils.date.DateToolkit;
import com.sunrise.common.utils.log.Log;
import hbm.jsonvalidate.JsonValidateEngine;
import hbm.jsonvalidate.ValidateException;
import hbm.jsonvalidate.Validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.sunrise.common.model.BaseQuery;
import com.sunrise.common.utils.SpringCtxUtils;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.json.JsonUtil;
import com.sunrise.common.utils.string.StringToolkit;

public class CommonServiceImpl implements CommonService {

	
	private Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
	
	// <bean id="commonService"
	// class="com.dtsjy.mdboss.common.services.CommonServiceImpl">
	// <property name="module" value="ucp"></property>
	// </bean>
	private String module;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * 返回json的通用描述 {"rc":-1,"msg":"错误信息"，"data": 数据}
	 * 
	 * 成功是1，错误是-1
	 * 
	 */
	@Transactional
	// 返回值为Integer，代表删除的记录数
	public String deleteByPrimaryKey(String appcode, String tenant, String oprcode,String voName, Integer id) {
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "deleteByPrimaryKey");
			Object result = method.invoke(mapper, new Object[] { id });

			return JsonResponseUtils.success(result);
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}
	
	/**
	 * 返回json的通用描述 {"rc":-1,"msg":"错误信息"，"data": 数据}
	 * 
	 * 成功是1，错误是-1
	 * 
	 */
	@Transactional
	// 返回值为Integer，代表删除的记录数
	public String deleteByPrimaryKey(String appcode, String tenant, String oprcode,String voName, String id) {
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "deleteByPrimaryKey");
			Object result = method.invoke(mapper, new Object[] { id });

			return JsonResponseUtils.success(result);
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}
	

	/**
	 * 返回json的通用描述 {"rc":-1,"msg":"错误信息"，"data": 数据}
	 * 
	 * 成功是1，错误是-1
	 * 
	 */
	@Transactional
	// 批量删除多条记录，返回值为Integer，代表删除的记录数
	public String deleteByPrimaryKeys(String appcode, String tenant, String oprcode,String voName, String idsJson) {
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method deleteMethod = getMethod(mapper, "deleteByExample");
			
			String exampleName = getExampleNameByVOName(voName);
			Class<?> exampleClazz = Class.forName(exampleName);
			Object example = exampleClazz.newInstance();
			Object criteria = MethodUtils.invokeMethod(example, "createCriteria", null);
			Method andIdInMethod = getMethod(criteria, "andIdIn");
			JSONArray tids = JSONObject.parseObject(idsJson).getJSONArray("tids");
			if (CollectionUtils.isNotEmpty(tids)){
				andIdInMethod.invoke(criteria, new Object[] { tids });
				Object result = deleteMethod.invoke(mapper, new Object[] { example });
				
				return JsonResponseUtils.success(result);
			}else {
				return JsonResponseUtils.error("tids 为空");
			}
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}
	
	@Transactional
	public String deleteByExample(String appcode, String tenant,
			String oprcode, String voName, String idsJson) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Transactional
	// 返回值为刚才新插入的记录
	public String insertSelectiveWithReturnVO(String appcode, String tenant, String oprcode,String voName, String voJson) {
		// 校验
		String verifyResult = verify(voName, voJson, DalNameUtil.THIRD_PART_CREATE_V);
		if (verifyResult != null) {
			return verifyResult;
		}
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "insertSelective");
			Class<?> voClass = method.getParameterTypes()[0];
			Object vo = JSONObject.parseObject(voJson, voClass);
			VOHandler.beforeCreate(vo,voJson);//自动设置唯一编码，如：用户编码、组织编码、角色编码，详见字典参数：ucp_vocodemapping
			
			Integer result = (Integer) method.invoke(mapper,
					new Object[] { vo });
			if (result > 0) {
				VOHandler.afterCreate(result, voJson);
				return JsonResponseUtils.success(vo);
			} else {
				return JsonResponseUtils.error("insert error");
			}
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}

	@Transactional
	// 批量新增记录，返回成功数量
	public String createBatch(String appcode, String tenant, String oprcode,String voName, String voJson) {
		// 校验
		String verifyResult = verify(voName, voJson, DalNameUtil.THIRD_PART_CREATE_V);
		if (verifyResult != null) {
			return verifyResult;
		}
		
		StringBuffer errBuf = new StringBuffer();
		int sucCount = 0;
		int errCount = 0;
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "insertSelective");
			Class<?> voClass = method.getParameterTypes()[0];
			JSONArray records = JSONObject.parseObject(voJson).getJSONArray("records");
			if (CollectionUtils.isNotEmpty(records)){
				for (int i = 0; i < records.size(); i++) {
					try {
						String input = records.getString(i);
						Object vo = JsonUtil.parseObjectWithDate(input, voClass);
						VOHandler.beforeCreate(vo,voJson);
						
						Integer result = (Integer) method.invoke(mapper,new Object[] { vo });
						if (result > 0) {
							sucCount++;
							VOHandler.afterCreate(vo, voJson);
						} else {
							errCount++;
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("createBatch error!", e);
						errCount++;
					}
				}
			}
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			errBuf.append("【" + msg + "】");
		} catch (Exception e) {
			errBuf.append("【" + e.getMessage() + "】");
		}
		
		if (StringToolkit.isNotEmpty(errBuf.toString())){
			return JsonResponseUtils.error(String.format("成功数量[%d],失败数量[%d]", sucCount,errCount) + errBuf.toString());
		}else {
			return JsonResponseUtils.success(sucCount);
		}
	}
	
	@Transactional
	// 返回值为Integer，代表?
	public String insertSelective(String appcode, String tenant, String oprcode,String voName, String voJson) {
		// 校验
		String verifyResult = verify(voName, voJson, DalNameUtil.THIRD_PART_CREATE_V);
		if (verifyResult != null) {
			return verifyResult;
		}

		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "insertSelective");
			Class<?> voClass = method.getParameterTypes()[0];
			Object vo = JSONObject.parseObject(voJson, voClass);
			VOHandler.beforeCreate(vo,voJson);//自动设置唯一编码，如：用户编码、组织编码、角色编码，详见字典参数：ucp_vocodemapping
			
			Object result = method.invoke(mapper, new Object[] { vo });
			VOHandler.afterCreate(vo, voJson);
			return JsonResponseUtils.success(result);
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}
	
	/**
	 * 返回记录数
	 * */
	@Override
	public int selectCountByExample(String appcode, String tenant, String oprcode,String voName, String json) {
	
		int recordCount = 0;
		
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method countMethod = getMethod(mapper, "countByExample");
			
			BaseQuery query = new DefaultQueyGetter().getQuery(json, BaseQuery.class);
			String fullVOName = getFullVOName(voName);
			QueryParser queryParser = new QueryParser();
			Class<?> voCls = Class.forName(fullVOName);
			Object example = queryParser.parseExampleByVoClass(query, voCls);
			
			recordCount = (int) countMethod.invoke(mapper, new Object[] { example });
			
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			String format = "selectCountByExample[appcode:%s],[tenant:%s],[oprcode:%s],[voName:%s][json:%s]";
			logger.debug(format,appcode, tenant, oprcode, voName, json);
			Log.debug(msg);
		} catch (Exception e) {
			//e.printStackTrace();
			String format = "selectCountByExample[appcode:%s],[tenant:%s],[oprcode:%s],[voName:%s][json:%s]";
			logger.debug(format,appcode, tenant, oprcode, voName, json);
			logger.debug(e.getMessage());
		}
		
		return recordCount;
	}

	
	/**
	 * 返回值为多条记录 
	 * TODO 较慢的实现，后续考虑提升效率
	 * */
	public String selectByExample(String appcode, String tenant, String oprcode,String voName, String json) {
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "selectByExampleWithRowbounds");
			Method countMethod = getMethod(mapper, "countByExample");

			BaseQuery query = new DefaultQueyGetter().getQuery(json, BaseQuery.class);
			String fullVOName = getFullVOName(voName);
			QueryParser queryParser = new QueryParser();
			Class<?> voCls = Class.forName(fullVOName);
			Object example = queryParser.parseExampleByVoClass(query, voCls);
			RowBounds rowBounds = queryParser.parseRowBounds(query);
			// 查询记录总数
			VOHandler.beforeSelect(mapperName,example, json);
			Object count = countMethod.invoke(mapper, new Object[] { example });
			Object rows = method.invoke(mapper, new Object[] { example,
					rowBounds });
			VOHandler.afterSelect(rows,(Integer)count,mapperName,example, json);
			
			// 将查询 TableColumnConfig 放在线程内, 只执行一次; 
			// 而不是在 JsonResponseUtils.defaultSerializeFilter 里面做
			VOHandler.setTableConfigToThreadLocal(fullVOName);
			JSONObject result = new JSONObject();
			result.put("rows", rows);
			result.put("total", count);
			result.put("pageNo", query.getPageNo());
			result.put("pageSize", query.getPageSize());
			
			
			return JsonResponseUtils.success(result, DateToolkit.DEFAULT_DATEFORMAT,
					new SerializeFilter[]{JsonResponseUtils.defaultSerializeFilter,JsonResponseUtils.defaultSerializeFilter} );
//			return JsonResponseUtils.success(result,JsonResponseUtils.defaultSerializeFilter);
//			return JsonResponseUtils.success(result);
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResponseUtils.error(e.getMessage());
		}
	}

	// 返回值为一条记录
	public String selectByPrimaryKey(String appcode, String tenant, String oprcode,String voName, Integer id) {
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "selectByPrimaryKey");
			
			Object result = method.invoke(mapper, new Object[] { id });
			VOHandler.afterSelect(result, -1,mapperName, null, null);
			
			// 将查询 TableColumnConfig 放在线程内, 只执行一次; 
			// 而不是在 JsonResponseUtils.defaultSerializeFilter 里面做
			String fullVOName = getFullVOName(voName);
			VOHandler.setTableConfigToThreadLocal(fullVOName);
			
			return JsonResponseUtils.success(result,DateToolkit.DEFAULT_DATEFORMAT,
					new SerializeFilter[]{JsonResponseUtils.defaultSerializeFilter,JsonResponseUtils.defaultSerializeFilter} );
//			return JsonResponseUtils.success(result,JsonResponseUtils.defaultSerializeFilter);
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}

	@Transactional
	// 返回值为Integer，代表更新的条数
	public String updateByPrimaryKeySelective(String appcode, String tenant, String oprcode,String voName, String voJson) {
		// 校验
		String verifyResult = verify(voName, voJson, DalNameUtil.THIRD_PART_CREATE_V);
		if (verifyResult != null) {
			return verifyResult;
		}

		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "updateByPrimaryKeySelective");
			Class<?> voClass = method.getParameterTypes()[0];
			Object vo = JSONObject.parseObject(voJson, voClass);
			VOHandler.beforeVOUpdate(vo, voJson);
			
			Object result = method.invoke(mapper, new Object[] { vo });
			VOHandler.afterVOUpdate(vo, voJson, result);
			return JsonResponseUtils.success(result);
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}

	@Transactional
	// 返回值为Integer，代表更新的条数
	public String updateByPrimaryKeyWithBLOBs(String appcode, String tenant, String oprcode,String voName, String voJson) {
		// 校验
		String verifyResult = verify(voName, voJson, DalNameUtil.THIRD_PART_CREATE_V);
		if (verifyResult != null) {
			return verifyResult;
		}
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "updateByPrimaryKeyWithBLOBs");
			Class<?> voClass = method.getParameterTypes()[0];
			Object vo = JSONObject.parseObject(voJson, voClass);
			VOHandler.beforeVOUpdate(vo, voJson);
			Object result = method.invoke(mapper, new Object[] { vo });
			VOHandler.afterVOUpdate(vo, voJson, result);
			return JsonResponseUtils.success(result);
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}
	
	@Transactional
	// 返回值为Integer，代表更新的条数
	public String updateByPrimaryKey(String appcode, String tenant, String oprcode,String voName, String voJson) {
		// 校验
		String verifyResult = verify(voName, voJson, DalNameUtil.THIRD_PART_CREATE_V);
		if (verifyResult != null) {
			return verifyResult;
		}
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method method = getMethod(mapper, "updateByPrimaryKey");
			Class<?> voClass = method.getParameterTypes()[0];
			Object vo = JSONObject.parseObject(voJson, voClass);
			VOHandler.beforeVOUpdate(vo, voJson);
			Object result = method.invoke(mapper, new Object[] { vo });
			VOHandler.afterVOUpdate(vo, voJson, result);
			
			return JsonResponseUtils.success(result);
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}
	
	@Transactional
	// 批量更新，不包括BLOB,返回值为Integer，代表更新的条数
	public String updateByPrimaryKeys(String appcode, String tenant, String oprcode,String voName, String vosJson) {
		// 校验
		String verifyResult = verify(voName, vosJson, DalNameUtil.THIRD_PART_CREATE_V);
		if (verifyResult != null) {
			return verifyResult;
		}
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method updateMethod = getMethod(mapper, "updateByExampleSelective");
			
			//example
			String exampleName = getExampleNameByVOName(voName);
			Class<?> exampleClazz = Class.forName(exampleName);
			Object example = exampleClazz.newInstance();
			
			//vo
			String fullVOName = getFullVOName(voName);
			Class<?> voCls = Class.forName(fullVOName);
			Object vo = voCls.newInstance();
			//
			Object criteria = MethodUtils.invokeMethod(example, "createCriteria", null);
			Method andIdInMethod = getMethod(criteria, "andIdIn");
			JSONObject param = JSONObject.parseObject(vosJson);
			JSONArray tids = param.getJSONArray("tids");
			if (CollectionUtils.isNotEmpty(tids)){
				andIdInMethod.invoke(criteria, new Object[] { tids });
				for (String key : param.keySet()){//修改属性
					if (BeanUtils.containsProperty(vo, key)){
						PropertyUtils.setProperty(vo, key, param.get(key));
					}
				}
				VOHandler.beforeVOUpdate(vo, vosJson);
				Object result = updateMethod.invoke(mapper, new Object[] { vo,example });
				VOHandler.afterVOUpdate(vo, vosJson, result);
				return JsonResponseUtils.success(result);
			}else {
				return JsonResponseUtils.error("tids 为空");
			}
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}
	
	@Transactional
	// 批量更新，包括BLOB,返回值为Integer，代表更新的条数
	public String updateByPrimaryKeysWihtBLOBs(String appcode, String tenant, String oprcode,String voName, String vosJson) {
		// 校验
		String verifyResult = verify(voName, vosJson, DalNameUtil.THIRD_PART_CREATE_V);
		if (verifyResult != null) {
			return verifyResult;
		}
		try {
			String mapperName = getMapperNameByVOName(voName);
			Object mapper = getMapper(mapperName);
			Method updateMethod = getMethod(mapper, "updateByExampleWithBLOBs");
			
			//example
			String exampleName = getExampleNameByVOName(voName);
			Class<?> exampleClazz = Class.forName(exampleName);
			Object example = exampleClazz.newInstance();
			
			//vo
			String fullVOName = getFullVOName(voName);
			Class<?> voCls = Class.forName(fullVOName);
			Object vo = voCls.newInstance();
			//
			Object criteria = MethodUtils.invokeMethod(example, "createCriteria", null);
			Method andIdInMethod = getMethod(criteria, "andIdIn");
			JSONObject param = JSONObject.parseObject(vosJson);
			JSONArray tids = param.getJSONArray("tids");
			if (CollectionUtils.isNotEmpty(tids)){
				andIdInMethod.invoke(criteria, new Object[] { tids });
				for (String key : param.keySet()){//修改属性
					if (BeanUtils.containsProperty(vo, key)){
						PropertyUtils.setProperty(vo, key, param.get(key));
					}
				}
				VOHandler.beforeVOUpdate(vo, vosJson);
				Object result = updateMethod.invoke(mapper, new Object[] { vo,example });
				VOHandler.afterVOUpdate(vo, vosJson, result);
				return JsonResponseUtils.success(result);
			}else {
				return JsonResponseUtils.error("tids 为空");
			}
		} catch (InvocationTargetException ite) {
			String msg = ite.getTargetException().getMessage();
			return JsonResponseUtils.error(msg);
		} catch (Exception e) {
			return JsonResponseUtils.error(e.getMessage());
		}
	}
	
	
	public String code2Name(String appcode, String tenant, String oprcode,
			String definition, String codeValue, String userCode) {
		Code2Name comm = SpringCtxUtils.getBean("code2Name", Code2Name.class);
		return comm.code2Name(definition, codeValue, userCode);
	}
	
	public Map getCode2NameValueList(String appcode, String tenant,
			String oprcode, String definition, String userCode) {
		Code2Name comm = SpringCtxUtils.getBean("code2Name", Code2Name.class);
		return comm.valueList(definition, userCode);
	}
	
	public Map getCode2NameValueList(String appcode, String tenant,
			String oprcode, String definition,String condition, String userCode) {
		Code2Name comm = SpringCtxUtils.getBean("code2Name", Code2Name.class);
		return comm.valueList(definition,condition, userCode);
	}

	// ----------------------------------------
	private Object getMapper(String mapperName) throws Exception {
		Class<?> clazz = Class.forName(mapperName);
		return SpringCtxUtils.getBean(clazz);
	}

	// 操作的前提:没有同名的方法
	private Method getMethod(Object instance, String methodName)
			throws Exception {
		Method[] methods = instance.getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				return method;
			}
		}
		throw new Exception("can't get method '" + methodName
				+ "' from class: " + instance.getClass());
	}

	// 统一校验方法
	private String verify(String voName, String voJson, String type) {
		try {
			
			//TODO voJson参数传递错误
			String validatorName = DalNameUtil.getValidatorName(voJson, voName, type);
			try {
				Class<?> clazz = Class.forName(validatorName);
				Validator validator;
				try {
					validator = (Validator) clazz.newInstance();
					JsonValidateEngine.verify(voJson, validator);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// 无校验类，不做校验
			}
		} catch (ValidateException e) {
			StringBuffer sb = new StringBuffer();
			List<String> list = e.getErrorList();
			for (String line : list) {
				sb.append(line).append(";");
			}

			return JsonResponseUtils.error(sb.toString());
		}
		return null;
	}

	private String getMapperNameByVOName(String voName){
		return DalNameUtil.getMapperNameByShortVOName(module, voName);
	}
	
	private String getExampleNameByVOName(String voName){
		return DalNameUtil.getExampleNameByShortVOName(module, voName);
	}
	
	private String getFullVOName(String voName){
		return DalNameUtil.getFullVOName(module, voName);
	}
	/**
	 * 执行自定义sql语句
	 */
	public List<Map<String, Object>> executeSql(String appcode, String tenant, String oprcode,
			String jsonData) {
		//参数解析
		JSONObject json = JSONObject.parseObject(jsonData);
		String sql = json.getString("sql");
		//String userCode = json.getString("usercode");
		GeneralMapper mapper = SpringCtxUtils.getBean(GeneralMapper.class);
		
		return mapper.executeSql(sql);
	}
}

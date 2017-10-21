package com.dtsjy.mdboss.common.utils.dal;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.dtsjy.mdboss.common.model.BaseQuery;
import com.dtsjy.mdboss.common.services.QueryOperate;
import com.dtsjy.mdboss.common.utils.TranslateUtils;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.dal.proxy.CriteriaProxy;
import com.dtsjy.mdboss.common.utils.dal.proxy.CriterionProxy;
import com.dtsjy.mdboss.common.utils.dal.proxy.ExampleProxy;
import com.dtsjy.mdboss.common.utils.date.DateToolkit;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

/**
 * @author livan.c
 */
public class QueryParser {
	
	final static String T_MAPPER = "Mapper";

	final static String T_EXAMPLE = "Example";
	
	private final static QueryParser instance = new QueryParser();
	
	public static QueryParser getInstance() {
		return instance;
	}

	private Class<?> getExampleClassByVOClass(Class<?> voClass) throws Exception{
		String exampleClassName = voClass.getName() + T_EXAMPLE;
		return  Class.forName(exampleClassName);
	}
	
	public Object getExampleInstanceByVOClass(Class<?> voClass) throws Exception{
		return getExampleClassByVOClass(voClass).newInstance();
	}
	/**
	 * 根据vo class生成mybatis查询对象(example对象）
	 * @param query
	 * @param voClass
	 * @return
	 * @throws Exception
	 */
	public <V extends BaseQuery> Object parseExampleByVoClass(V query, Class<?> voClass)
			throws Exception {
		Object example = getExampleInstanceByVOClass(voClass);
		return parseExample(query, example);
	}

	/**
	 * 填充example对象信息
	 * @param query
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public <T,V extends BaseQuery> T parseExample(V query, Class<T> exampleClass)
			throws Exception {
		T example = exampleClass.newInstance();
		return (T)parseExample(query,example);
	}
	
	/**
	 * 填充example对象信息
	 * @param query
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public <T,V extends BaseQuery> T parseExample(V query, T example)
			throws Exception {
		// 注入查询条件
		ExampleProxy exampleProxy = new ExampleProxy(example);
		
		String keyword = query.getKeyword();
		List<String> keywordFields = query.getKeywordFields();
		if (StringToolkit.isNotEmpty(keyword) && CollectionUtils.isNotEmpty(keywordFields)){
			for (int i = 0; i < keywordFields.size(); i++) {
				String field = keywordFields.get(i);
				query.addCondition(field, QueryOperate.LIKE, keyword);
				Object criteria = exampleProxy.or();
				TranslateUtils.inject2Criteria(criteria, query.getQueryCondition());
				query.removeCondition(field, QueryOperate.LIKE,keyword);
			}
		}else {
			Object criteria = exampleProxy.createCriteria();
			TranslateUtils.inject2Criteria(criteria, query.getQueryCondition());
		}
		
		// 设置排序
		if (StringToolkit.isValuedString(query.getOrderBy())) {
			exampleProxy.setOrderByClause(query.getOrderBy());
		}

		return (T)exampleProxy.getTarget();
	}

	/**
	 * 获取mybatis分页对象
	 * @param query
	 * @return
	 */
	public  RowBounds parseRowBounds(BaseQuery query) {
		int offset = (query.getPageNo() - 1) * query.getPageSize();
		return new RowBounds(offset >= 0 ? offset : RowBounds.NO_ROW_OFFSET,
				query.getPageSize() > 0 ? query.getPageSize()
						: RowBounds.NO_ROW_LIMIT);
	}
	
	public static RowBounds parseRowBounds(int pageNo, int pageSize) {
		int offset = (pageNo - 1) * pageSize;
		return new RowBounds(offset >= 0 ? offset : RowBounds.NO_ROW_OFFSET,
				pageSize > 0 ? pageSize : RowBounds.NO_ROW_LIMIT);
	}
	
	public <V extends BaseQuery> String parseWhereClause(V query,Class<?> voClass) throws Exception{
		Object example = parseExample(query, getExampleClassByVOClass(voClass));
		return parseWhereClause(example);
	}
	
	/**
	 * 根据example对象生成where语句
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public String parseWhereClause(Object example) throws Exception{
		StringBuffer whereClause = new StringBuffer();
		List<Object> oredCriterias = new ExampleProxy(example).getOredCriteria();
		
		boolean isFirst = true;
		for (Object criteria : oredCriterias){
			CriteriaProxy criteriaProxy = new CriteriaProxy(criteria);
			if (criteriaProxy.isValid()){
				if (isFirst){
					whereClause.append(" where (1=1 ");
				}else {
					whereClause.append(" or(1=1 ");
				}
				
				List<Object> criterionList = criteriaProxy.getAllCriteria();
				for (Object criterion : criterionList){
					CriterionProxy criterionProxy = new CriterionProxy(criterion);
					if (criterionProxy.isNoValue()){
						whereClause.append(" and ").append(criterionProxy.getCondition());
					}else if (criterionProxy.isSingleValue()){
						whereClause.append(" and ").append(criterionProxy.getCondition()).append(" ").append(sqlValue(criterionProxy.getValue()));
					}else if (criterionProxy.isBetweenValue()){
						whereClause.append(" and ").append(criterionProxy.getCondition()).append(" ").append(sqlValue(criterionProxy.getValue()))
							.append(" and ").append(sqlValue(criterionProxy.getSecondValue()));
					}else if (criterionProxy.isListValue()){
						whereClause.append(" and ").append(criterionProxy.getCondition()).append(" (");
						List<Object> itemList = (List<Object>)criterionProxy.getValue();
						for (Object item : itemList){
							whereClause.append(sqlValue(item)).append(",");
						}
						whereClause.deleteCharAt(whereClause.length()-1).append(")");
					}
				}
				
				whereClause.append(") ");
			}
			isFirst = false;
		}
		
		return whereClause.toString();
	}
	
	private Object sqlValue(Object value){
		if (value instanceof String){
			return "'" + value + "'";
		}else if (value instanceof Date){
			return "STR_TO_DATE('" + DateToolkit.utilDateToStr((Date)value) + "','%Y-%m-%d %H:%i:%s')";
		}
		return value;
	}
	
	/**
	 * 生成查询条件语句，包括where、order by 、分页语句
	 * @param query
	 * @param voClass
	 * @return
	 * @throws Exception
	 */
	public <V extends BaseQuery> String parseSelectClause(V query,Class<?> voClass) throws Exception{
		StringBuffer selectClause = new StringBuffer();
		selectClause.append(parseWhereClause(query,voClass)).append(" ");
		
		if (StringToolkit.isValuedString(query.getOrderBy())){
			selectClause.append(query.getOrderBy()).append(" ");
		}
		
		RowBounds rBounds = parseRowBounds(query);
		selectClause.append("limit ").append(rBounds.getLimit()).append(" offset ").append(rBounds.getOffset());
		
		return selectClause.toString();
	}
}
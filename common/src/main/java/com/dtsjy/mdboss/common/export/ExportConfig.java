package com.dtsjy.mdboss.common.export;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dtsjy.mdboss.common.export.EntityNode.FieldInfo;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;

public class ExportConfig {
	private static final Logger log = LoggerFactory.getLogger(ExportConfig.class);
	private static final String EXPORT_EXPORT_FILEPATH = "/com/sunrise/jop/common/config/export/export.xml";
	private static final String EXPORT_ENTITY_FILEPATH = "/com/sunrise/jop/common/config/export/entities.xml";
	public static final String Excelout_IMPLEMENT_PREFIX = "com.sunrise.jop.web.commons.export.impl.";
	public static Map<String, ExportNode> exceloutMap;
	private static Map<String,EntityNode> entityMap;
	private static Map<String,String> constMap;
	private static long lastModified_ent;
	private static long lastModified_ex;
	static {
		initEntity();
		initExport();
	}
//	 下面注释描述的层是export.xml文件里面嵌套的层次
	final static String EXCELOUT_CONFIG_0 = "excelout-config";// 第零层
	
	final static String EXCELOUT_1 = "excelout"; // 第一层
	
	final static String CONSTS_1 = "consts"; // 第一层
	
	final static String EXCELOUT_1_ID = "id";//第一层的id属性
	
	final static String CONST_2 = "const";
	
	final static String CONST_2_NAME = "name";

	final static String OUTFILENAME_2 = "outfilename";
	
	final static String PARAMCONVERTER_2 = "paramconverter"; // 
	
	final static String ENTITY_2 = "entity";
	
	final static String ENTITY_2_REF = "ref";
	
//	 下面注释描述的层是entities.xml文件里面嵌套的层次
	final static String ENTITY_CONFIG_0 = "entity-config";// 第零层
	
	final static String ENTITY_1 = "entity"; // 第一层
	
	final static String ENTITY_1_NAME = "name"; // 第一层的name属性
	
	final static String ENTITY_1_SHOWCOUNT = "showcount"; // 第一层的showcount属性
												
	final static String ENTITY_1_EXCELOUTBEAN = "exceloutbean"; // 第一层的exceloutbean属性
	
	final static String ENTITY_1_SHEETNAME = "sheetname"; // 第一层的sheetname属性
	
	final static String TABLEORVIEW_2 = "tableorview"; // 第二层
	
	final static String DELEGATE_2 = "delegate"; // 第二层
	
	final static String DELEGATE_2_CLASS = "class";//第二层的class属性
	
	final static String HEADTITLE_2 = "headtitle"; // 第二层
	
	final static String ENDTITLE_2 = "endtitle"; // 第二层
	
	final static String BEFOREWRITE_2 = "beforewrite"; // 第二层
	
	final static String AFTERWRITE_2 = "afterwrite"; // 第二层	

	final static String FIELDS_2 = "fields"; // 第二层
	
	final static String QUERY_3 = "query";//第三层
	
	final static String QUERY_3_METHODTYPE ="methodtype";//第三层的methodtype属性
	
	final static String QUERY_3_METHODNAME ="methodname";//第三层的methodname属性
	
	final static String QUERY_3_QUERYTYPE ="querytype";//第三层的querytype属性
	
	final static String QUERY_3_QUERYNAME ="queryname";//第三层的queryname属性
	
	final static String QUERY_3_ORDERBY ="orderby";//第三层的orderby属性

	final static String FIELD_3 = "field";//第三层
	
	final static String FIELD_3_NAME = "name";//第三层field的name属性
	
	final static String FIELD_3_COVERTVALUE = "covertvalue";//第三层field的covertvalue属性

	final static String FIELD_3_VAR = "var";//第三层field的var属性
	
	final static String FIELD_3_FORMAT = "format";//第三层field的format属性
	
	final static String FIELD_3_FORMATTYPE = "formattype";//第三层field的formattype属性
	
	final static String FIELD_3_TITLENAME = "titlename";//第三层field的titlename属性
	
	final static String FIELD_3_STYLE = "style";
	
	final static String FIELD_3_DBNAME = "dbname";
	
	final static String QUERYSQL_4 = "query_sql";//第四层
	
	final static String DEFINITION_4 = "definition";//第四层
	
	final static String DEFINITION_4_DEPENDENT = "dependent";//第四层definition的independent属性

	final static String CASE_5 = "case"; // 第五层
	
	final static String CASE_5_OPRTYPE = "oprtype";// 第五层case的oprtype属性
	
	final static String CASE_5_VALUE = "value";// 第五层case的value属性
	
	private static void initExport() {
		exceloutMap = new HashMap<String, ExportNode>();
		constMap = new HashMap<String, String>();

		SAXReader saxReader = new SAXReader();
		saxReader.setValidation(true);
		saxReader.setIncludeInternalDTDDeclarations(true);
		saxReader.setIgnoreComments(false);
		try {
			URL url = ExportConfig.class.getResource(EXPORT_EXPORT_FILEPATH);
			Document document = saxReader.read(url);
			lastModified_ex = new File(url.getFile()).lastModified();
			
			List<Element> constList = document.selectNodes(EXCELOUT_CONFIG_0 + "/" + CONSTS_1 + "/" + CONST_2);
			Iterator<Element> it = constList.iterator();
			while (it.hasNext()) {
				Element constElem = (Element) it.next();
				String name = constElem.attribute(CONST_2_NAME).getValue();
				String value = constElem.getTextTrim();
				constMap.put(name, value);
			}
			
			List<Element> exList = document.selectNodes(EXCELOUT_CONFIG_0 + "/" + EXCELOUT_1);
			Iterator<Element> iter = exList.iterator();
			while (iter.hasNext()) {
				ExportNode node = new ExportNode();
				Element exElem = iter.next();
				String id = exElem.attribute(EXCELOUT_1_ID).getValue();
				node.setId(id);
				
				Element outFileElem = exElem.element(OUTFILENAME_2);
				if (outFileElem != null){
					String outFileName = outFileElem.getTextTrim();
					node.setOutFileName(outFileName);
				}
				
				Element converterElem = exElem.element(PARAMCONVERTER_2);
				if (converterElem != null){
					String converter = converterElem.getTextTrim();
					node.setConverter(converter);
				}
				
				Iterator<Element> entIter =  exElem.elementIterator(ENTITY_2);
				List<String> entityRefs = new ArrayList<String>();
				while (entIter.hasNext()){
					String entityRef = entIter.next().attributeValue(ENTITY_2_REF);
					if (!entityMap.containsKey(entityRef)){
						throw new DocumentException("在excelout.xml文件中引用的名为[" + entityRef +"]的导出实体在entities.xml文件没有配置!");
					}
					entityRefs.add(entityRef);
				}
				node.setRefs(entityRefs);
			
				 exceloutMap.put(id, node);
			}
		} catch (DocumentException e) {
			log.error("excelout config init error", e);
			e.printStackTrace();
		}
	}
	
	private static void initEntity(){
		entityMap = new HashMap<String, EntityNode>();
		
		SAXReader saxReader = new SAXReader();
		saxReader.setValidation(true);
		saxReader.setIncludeInternalDTDDeclarations(true);
		saxReader.setIgnoreComments(false);
		try {
			URL url = ExportConfig.class.getResource(EXPORT_ENTITY_FILEPATH);
			Document document = saxReader.read(url);
			lastModified_ent = new File(url.getFile()).lastModified();
			
			List<Element> entList = document.selectNodes(ENTITY_CONFIG_0 + "/" + ENTITY_1);
			Iterator<Element> iter = entList.iterator();
			while (iter.hasNext()) {
				EntityNode node = new EntityNode();
				Element entityElem = iter.next();
				String voName = entityElem.attribute(ENTITY_1_NAME).getValue();
				node.setVoName(voName);
				String exceloutbean = entityElem.attributeValue(ENTITY_1_EXCELOUTBEAN);
				if (StringToolkit.isNotEmpty(exceloutbean)){
					node.setExceloutbean(exceloutbean);
				}
				
				if (entityElem.attribute(ENTITY_1_SHEETNAME) != null){
					String sheetName = entityElem.attribute(ENTITY_1_SHEETNAME).getValue();
					node.setSheetName(sheetName);
				}
				
				String showCount = entityElem.attribute(ENTITY_1_SHOWCOUNT).getValue();
				node.setShowCount(showCount);
				
				Element tableorviewElem = entityElem.element(TABLEORVIEW_2);
				if (tableorviewElem != null){
					String tableorview = tableorviewElem.getTextTrim();
					node.setTableorview(tableorview);
				}

				Element delegateElem = entityElem.element(DELEGATE_2);
				String delegateClass = delegateElem.attributeValue(DELEGATE_2_CLASS);
				node.getDelegateInfo().setDelegateClass(delegateClass);
				
				Iterator<Element> queryIter = delegateElem.elementIterator(QUERY_3);
				while (queryIter.hasNext()){
					Element queryElem = (Element)queryIter.next();
					String methodType = queryElem.attributeValue(QUERY_3_METHODTYPE);
					String methodName = queryElem.attributeValue(QUERY_3_METHODNAME);
					String queryType = queryElem.attributeValue(QUERY_3_QUERYTYPE);
					String queryName = queryElem.attributeValue(QUERY_3_QUERYNAME);
					String orderby = queryElem.attributeValue(QUERY_3_ORDERBY);
					String querySql = "";
					Element querySqlElem = queryElem.element(QUERYSQL_4);
					if (querySqlElem != null){
						querySql = querySqlElem.getTextTrim();
					}
					node.getDelegateInfo().addDelegateInfo(queryType, methodType, queryName, methodName, querySql,orderby);
				}
				
				Element headtitleElem = entityElem.element(HEADTITLE_2);
				if (headtitleElem != null){
					String headtitle = headtitleElem.getTextTrim();
					node.setHeadtitle(headtitle);
				}
				
				Element endtitleElem = entityElem.element(ENDTITLE_2);
				if (endtitleElem != null){
					String endtitle = endtitleElem.getTextTrim();
					node.setEndtitle(endtitle);
				}
				
				Element beforewriteElem = entityElem.element(BEFOREWRITE_2);
				if (beforewriteElem != null){
					String beforewrite = beforewriteElem.getTextTrim();
					node.setBeforewrite(beforewrite);
				}
				
				Element afterwriteElem = entityElem.element(AFTERWRITE_2);
				if (afterwriteElem != null){
					String afterwrite = afterwriteElem.getTextTrim();
					node.setAfterwrite(afterwrite);
				}
				
				 Iterator<Element> fieldIter =  entityElem.element(FIELDS_2).elementIterator(FIELD_3);
				 while (fieldIter.hasNext()){
					 Element fieldElem = fieldIter.next();
					 String field = fieldElem.attributeValue(FIELD_3_NAME);
					 String covertValue = fieldElem.attributeValue(FIELD_3_COVERTVALUE);
					 String var = fieldElem.attributeValue(FIELD_3_VAR);
					 String format = fieldElem.attributeValue(FIELD_3_FORMAT);
					 String formattype = fieldElem.attributeValue(FIELD_3_FORMATTYPE);
					 String titlename = fieldElem.attributeValue(FIELD_3_TITLENAME);
					 String style = fieldElem.attributeValue(FIELD_3_STYLE);
					 String dbname = fieldElem.attributeValue(FIELD_3_DBNAME);
					 node.setFields(field, format, formattype, covertValue,titlename,style,dbname);
					 if (!StringToolkit.isEmpty(covertValue)){
						 node.setCovertValueMap(field, covertValue);
					 }
					 if (!StringToolkit.isEmpty(var)){
						 node.setVarMap(field, var);
					 }
					 node.setFieldsList(field);
					 if (!StringToolkit.isEmpty(titlename)){
						 node.setTitleList(titlename);
					 }else {
						 node.setTitleList(field);
					 }
					 Element definitionElem = fieldElem.element(DEFINITION_4);
					 if (definitionElem != null){
						 String dependent = definitionElem.attributeValue(DEFINITION_4_DEPENDENT);
						//definition的dependent属性为空,此时definition的值为definition元素间的内容
						//否则为,definition的值取决于case子元素间的内容
						 if (StringToolkit.isEmpty(dependent)){
							 String definition = definitionElem.getTextTrim();
							 node.setDefinitionMap(field, definition);
						 }else {
							 Iterator caseIter = definitionElem	.elementIterator(CASE_5);
							 Map caseMap = new HashMap();
							 while (caseIter.hasNext()){
								 Element caseItem = (Element)caseIter.next();
								 String oprtype = caseItem.attributeValue(CASE_5_OPRTYPE);
								 String value = caseItem.attributeValue(CASE_5_VALUE);
								 String definition = caseItem.getTextTrim();
								 //expression为一比较表达式如:sheetrestype==0
								 //当expression的值为true时,取该case元素的内容作为definition的值
								 //注意取表达式时需去掉"_"
//								 String expression = dependent+"_"+oprtype+value;
								  String expression = dependent+"&"+oprtype+"&"+value;
								 caseMap.put(expression, definition);
							 }
							 node.setDefinitionMap(field, caseMap);
						 }
					 }
				 }
				 entityMap.put(voName, node);
			}
		} catch (DocumentException e) {
			log.error("entity config init error", e);
			e.printStackTrace();
		}
	}
	
	private static void checkModify() {
		try {
			long modify = new File(ExportConfig.class.getResource(
					EXPORT_ENTITY_FILEPATH).getFile()).lastModified();
			if (modify > lastModified_ent) {
				initEntity();
			}
			 modify = new File(ExportConfig.class.getResource(
					EXPORT_EXPORT_FILEPATH).getFile()).lastModified();
			if (modify > lastModified_ex) {
				initExport();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("The file named excelout.xml or entities.xml has been changed but can not be reloaded!!");
		}

	}
	
	public static Object getBO(String voName) throws Exception{
		checkModify();
		EntityNode node = (EntityNode )entityMap.get(voName);
		if (node != null){
			String delegateName = node.getDelegateInfo().getDelegateClass();
			return null;
//			return BOFactory.build(Class.forName(delegateName), DBAccessUser.getInnerUser());
		}else {
			throw new ClassNotFoundException("can not find Delegate's name");
		}
	}
	
	public static String getQueryMethodName(String voName){
		checkModify();
		EntityNode node = entityMap.get(voName);
		return node.getDelegateInfo().getQueryMethodName();
	}
	
	public static String getCountMethodName(String voName){
		checkModify();
		EntityNode node = entityMap.get(voName);
		return node.getDelegateInfo().getCountMethodName();
	}
	
	public static String getOutFileName(String id){
		checkModify();
		return ((ExportNode)exceloutMap.get(id)).getOutFileName();
	}
	
	public static List<Class<?>> getEntityClz(String id){
		checkModify();
		List<Class<?>> clz = new ArrayList<Class<?>>();
		String entityClassName = "";
		try {
			Iterator<String> iter = exceloutMap.get(id).getRefs().iterator();
			while (iter.hasNext()){
				entityClassName = iter.next();
				clz.add(Class.forName(entityClassName));
			}
			
		} catch (ClassNotFoundException e) {
			log.info("无法创建[" + entityClassName + "]Class对象");
			e.printStackTrace();
		}
		return clz;
	}
	
	public static String[] getVoNames(String id){
		List clz = getEntityClz(id);
		String [] voNames = new String[clz.size()];
		Iterator it = clz.iterator();
		int i = 0;
		while (it.hasNext()){
			voNames[i++] = ((Class)it.next()).getName();
		}
		return voNames;
	}
	
/*	public static String getbundleName(String voName){
		checkModify();
		return entityMap.get(voName).getBundleName();
	}*/
	
	public static List<String> getFieldList(String voName){
		checkModify();
		return entityMap.get(voName).getFieldsList();
	}
	
	public static List<String> getTitleList(String voName){
		checkModify();
		return entityMap.get(voName).getTitleList();
	}
	
	public static String[] getTitles(String voName){
		Object[]  title = getTitleList(voName).toArray();
		String[] titles = new String[title.length];
		System.arraycopy(title, 0, titles, 0,title.length);
		return titles;
	}
	
	public static String[] getSpecTitles(String voName,List fieldList){
		checkModify();
		List tList = new ArrayList();
		EntityNode node = entityMap.get(voName);
		Iterator it = node.getFields().iterator();
		while(it.hasNext()){
			FieldInfo fi = (FieldInfo)it.next();
			if (fieldList.contains(fi.getName())){
				tList.add(fi.getTitlename());
			}
		}
		
		Object[]  title = tList.toArray();
		String[] titles = new String[title.length];
		System.arraycopy(title, 0, titles, 0,title.length);
		return titles;
	}
	
	public static Map getCode2nameMap(String voName){
		checkModify();
		return entityMap.get(voName).getDefinitionMap();
	}
	
	public static Map getCovertMap(String voName){
		checkModify();
		return entityMap.get(voName).getCovertValueMap();
	}
	
	public static Map getVarMap(String voName){
		checkModify();
		return entityMap.get(voName).getVarMap();
	}
	
	public static String[] getFiledFormatAndType(String voName,String fieldName,int idx){
		checkModify();
		EntityNode node = entityMap.get(voName);
		List<FieldInfo> fieldList = node.getFields();
		if (idx < fieldList.size()){
			FieldInfo fi = fieldList.get(idx);
			if (fi.getName().equals(fieldName)){
				if (fi.getFormat().equals("none")){
					return null;
				}
				
				return new String[] {fi.getFormat(),fi.getFormattype()};
			}
		}
		return null;
	}
	
	public static String getFieldStyle(String voName,String fieldName,int idx){
		checkModify();
		EntityNode node = entityMap.get(voName);
		List<FieldInfo> fieldList = node.getFields();
		if (idx < fieldList.size()){
			FieldInfo fi = (FieldInfo)fieldList.get(idx);
			if (fi.getName().equals(fieldName)){
				fi.getStyle();
			}
		}
		return null;
	}
	
	public static String getFieldTitleName(String voName,String fieldName,int idx){
		checkModify();
		EntityNode node = entityMap.get(voName);
		List<FieldInfo> fieldList = node.getFields();
		if (idx < fieldList.size()){
			FieldInfo fi = (FieldInfo)fieldList.get(idx);
			if (fi.getName().equals(fieldName)){
				return fi.getTitlename();
			}
		}
		return null;
	}
	
	public static String getExceloutbean(String voName){
		checkModify();
		return entityMap.get(voName).getExceloutbean();
	}
	
	public static String getHeadTitle(String voName){
		checkModify();
		return entityMap.get(voName).getHeadtitle();
	}
	
	public static String getEndTitle(String voName){
		checkModify();
		return entityMap.get(voName).getEndtitle();
	}
	
	public static String getBeforeWriteData(String voName){
		checkModify();
		return entityMap.get(voName).getBeforewrite();
	}
	
	public static String getAfterWriteData(String voName){
		checkModify();
		return entityMap.get(voName).getAfterwrite();
	}
	
	public static String getShowCount(String voName){
		checkModify();
		return entityMap.get(voName).getShowCount();
	}
	
	public static String getSheetName(String voName){
		checkModify();
		return entityMap.get(voName).getSheetName();
	}
	
	public static String getCountQueryName(String voName){
		checkModify();
		return entityMap.get(voName).getDelegateInfo().getCountQueryName();
	}
	
	public static String getQueryQueryName(String voName){
		checkModify();
		return entityMap.get(voName).getDelegateInfo().getQueryQueryName();
	}
	
	public static String getCountQueryType(String voName){
		checkModify();
		return entityMap.get(voName).getDelegateInfo().getCountQueryType();
	}
	
	public static String getQueryQueryType(String voName){
		checkModify();
		return entityMap.get(voName).getDelegateInfo().getQueryQueryType();
	}

	public static String getCountOrderby(String voName){
		checkModify();
		return entityMap.get(voName).getDelegateInfo().getCountOrderby();
	}
	
	public static String getQueryOrderby(String voName){
		checkModify();
		return entityMap.get(voName).getDelegateInfo().getQueryOrderby();
	}
	
	public static String getTableorview(String voName){
		checkModify();
		return entityMap.get(voName).getTableorview();
	}
	
	public static String getPageSize(){
		checkModify();
		String pagesize = (String)constMap.get("pagesize");
		if (StringToolkit.isEmpty(pagesize)){
			pagesize = "1000";
		}
		return pagesize;
	}
	
	public static String getMaxPages(){
		checkModify();
		String maxPages = (String)constMap.get("maxpages");
		if (StringToolkit.isEmpty(maxPages)){
			maxPages = "100";
		}
		return maxPages;

	}
	
	public static String getDBName(String voName,String fieldName){
		checkModify();
		EntityNode node = entityMap.get(voName);
		Iterator<FieldInfo> it = node.getFields().iterator();
		while(it.hasNext()){
			FieldInfo fi = it.next();
			if (fi.getName().equals(fieldName)){
				return fi.getDbname();
			}
		}
		return null;
	}
	
	public static Object getConverter(String id){
		String converterCls = ((ExportNode)exceloutMap.get(id)).getConverter();
		if (StringToolkit.isEmpty(converterCls)){
			return null;
		}
		Object converter = null;
		try {
			converter = Class.forName(converterCls).newInstance();
			if (!ExportParamConverter.class.isAssignableFrom(converter.getClass())){
				log.info("this setted converter className [" + converterCls + "],is not a implemetation of the interface[" + ExportParamConverter.class.getName() + "]");
				return null;
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("cant not create the paramconverter object [" + converterCls + "]");
		}
		return converter;
	}
}

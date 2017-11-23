package com.sunrise.common.utils.dal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunrise.common.dal.ext.dao.GeneralMapper;
import com.sunrise.common.model.constants.CommonModel;
import com.sunrise.common.utils.SpringCtxUtils;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.string.StringToolkit;
import com.sunrise.ucp.dal.gen.dao.DictItemVOMapper;
import com.sunrise.ucp.dal.gen.model.DictItemVO;
import com.sunrise.ucp.dal.gen.model.DictItemVOExample;

public class CommonDaoUtil {

	/**
	 * 
	 * @param tableName 表名，如:ucp_org
	 * @param col 子字段名，如：orgcode
	 * @param pcol 父字段名，如：parentcode
	 * @param selfCodeValue 字段值，如：org-112
	 * @param type 1/查询父节点及本身 2/查询父节点不含本身 3/查询子节点及本身  4/查询子节点不含本身 5/查询父节点及子节点不含本身 
	 * @return 所有父节点编码，以逗号分隔,如：org-112,org-1
	 */
	public static String getParentCodes(String tableName,String col,String pcol,String selfCodeValue,int type){
		return getParentCodesAndChildCodes(tableName, col, pcol, selfCodeValue, type)[0];
	}
	
	/**
	 * 
	 * @param tableName 表名，如:ucp_org
	 * @param col 子字段名，如：orgcode
	 * @param pcol 父字段名，如：parentcode
	 * @param selfCodeValue 字段值，如：org-112
	 * @param type 1/查询父节点及本身 2/查询父节点不含本身 3/查询子节点及本身  4/查询子节点不含本身 5/查询父节点及子节点不含本身 
	 * @return 所有子节点编码，以逗号分隔,如：org-112,org-11200
	 */
	public static String getChildCodes(String tableName,String col,String pcol,String selfCodeValue,int type){
		return getParentCodesAndChildCodes(tableName, col, pcol, selfCodeValue, type)[1];
	}
	
	
	/**
	 * 
	 * @param tableName 表名，如:ucp_org
	 * @param col 子字段名，如：orgcode
	 * @param pcol 父字段名，如：parentcode
	 * @param selfCodeValue 字段值，如：org-112
	 * @param type 1/查询父节点及本身 2/查询父节点不含本身 3/查询子节点及本身  4/查询子节点不含本身 5/查询父节点及子节点不含本身 
	 * @return 字符串数据，第一元素为父元素编码，第二元素为子元素编码
	 */
	public static String[] getParentCodesAndChildCodes(String tableName,String col,String pcol,String selfCodeValue,int type){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tableName", tableName);
		params.put("col", col);
		params.put("pcol", pcol);
		params.put("parentCodes", "");
		params.put("selfCode", selfCodeValue);
		params.put("childCodes", "");
		params.put("type", type);
		
		GeneralMapper gDao = SpringCtxUtils.getBean(GeneralMapper.class);
		gDao.getParentsAndChilds(params);
		
		return new String[]{StringToolkit.getObjectString(params.get("parentCodes")),StringToolkit.getObjectString(params.get("childCodes"))};
	}
	
	/**
	 * 获取数据字典项
	 * @param definition
	 * @param dictCode
	 * @return
	 */
	public static DictItemVO getDictItem(String definition, String dictCode) {
		DictItemVOMapper dao = SpringCtxUtils.getBean(DictItemVOMapper.class);
		DictItemVOExample example = new DictItemVOExample();
		example.createCriteria().andGroupcodeEqualTo(definition).andDictcodeEqualTo(dictCode).andDictstateEqualTo(CommonModel.ENABLE.value());
		return CollectionUtils.getOneIfNoEmpty(dao.selectByExample(example));
	}
	
	/**
	 * 获取数据字典项
	 * @param definition
	 * @param dictCode
	 * @return
	 */
	public static List<DictItemVO> getDictItems(String definition,String keyword) {
		DictItemVOMapper dao = SpringCtxUtils.getBean(DictItemVOMapper.class);
		DictItemVOExample example = new DictItemVOExample();
		example.createCriteria().andGroupcodeEqualTo(definition).andDictstateEqualTo(CommonModel.ENABLE.value());
		if (StringToolkit.isNotEmpty(keyword)){
			example.getOredCriteria().get(0).andDictnameLike(String.format("%%s%", keyword));
		}
		example.setOrderByClause("dictorder");
		return dao.selectByExample(example);
	}
	
	public static <T>T getDao(Class<T> clazz) {
		T dao = null;
		try {
			dao = SpringCtxUtils.getBean(clazz);
		} catch (Exception e) {
			//do nothing
		}
		return dao;
	}
}

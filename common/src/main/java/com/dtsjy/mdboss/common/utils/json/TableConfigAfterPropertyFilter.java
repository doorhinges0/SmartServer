package com.dtsjy.mdboss.common.utils.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.serializer.AfterFilter;
import com.dtsjy.mdboss.common.model.SerialNoHolder4Rest;
import com.dtsjy.mdboss.common.model.tableconfig.TableExtColumnManager;
import com.dtsjy.mdboss.common.utils.collection.CollectionUtils;
import com.dtsjy.mdboss.common.utils.string.StringToolkit;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableColumnConfigVO;

public class TableConfigAfterPropertyFilter extends AfterFilter {
	
	private static final ThreadLocal<Map<Object, Map<String, Object>>> TMP_DATA = new ThreadLocal<Map<Object, Map<String, Object>>>();
	
	//CommonServiceImpl#selectByExample中
	//  return JsonResponseUtils.success(result,DateToolkit.DEFAULT_DATEFORMAT,new SerializeFilter[]{JsonResponseUtils.defaultSerializeFilter,JsonResponseUtils.defaultSerializeFilter} );
	@Override
	public void writeAfter(Object object) {
		if (null != TMP_DATA.get()){
			Map<String, Object> datas = TMP_DATA.get().get(object);
			if (null != datas){
				for (String code : datas.keySet()) {
					super.writeKeyValue(code, datas.get(code));
				}
			}
			TMP_DATA.set(null);
			return;
		}
		
		String fullVOName = object.getClass().getName();
		Map<String, Boolean> convertMap = SerialNoHolder4Rest.convertMap.get();
		if (convertMap != null && !convertMap.isEmpty()) {
			Boolean convert = convertMap.get(fullVOName);
			boolean convertFlag = (convert != null && convert);
			if (convertFlag) {
				Map<String, List<TableColumnConfigVO>> data = SerialNoHolder4Rest.TableColumnConfig.get();
				List<TableColumnConfigVO> cols = data.get(object.getClass().getName());
				// 此处可能做了重复工作, 不过为了避免异常, 暂时保留此处理。详细请查看 VOHandler.setTableConfigToThreadLocal
				if (CollectionUtils.isNotEmpty(cols)){
					Map<String, Object> tmpData = null;
					Map<Object, Map<String, Object>>  holdMap= null;
					for (TableColumnConfigVO tableColumnConfigVO : cols) {
						Object columnVal = StringToolkit.getObjectString(TableExtColumnManager.getValue(object, tableColumnConfigVO.getRulejson()));
						try {
							//当存在嵌套的json序列化时，此处将抛出异常,原因是JSONSerializer执行一次就被清除掉了，导致空指针
							//catch中的代码用于解决该问题，success方法设置两次后处理filter，第一个filter出错时保存待设置的key-value，第二个filte执行时直接设置key-value
							//return JsonResponseUtils.success(result,DateToolkit.DEFAULT_DATEFORMAT,
							//		new SerializeFilter[]{JsonResponseUtils.defaultSerializeFilter,JsonResponseUtils.defaultSerializeFilter} );
							super.writeKeyValue(tableColumnConfigVO.getVofieldname(), columnVal);
							TMP_DATA.set(new HashMap<Object, Map<String, Object>>());//第一个filter执行正常时给线程变量赋值，第二个filter不再执行后处理逻辑
						} catch (Exception e) {
							//e.printStackTrace();
							if (null ==  tmpData){
								holdMap = new HashMap<Object, Map<String, Object>>();
								tmpData = new HashMap<String, Object>();
								holdMap.put(object, tmpData);
								TMP_DATA.set(holdMap);
							}
							tmpData.put(tableColumnConfigVO.getVofieldname(), columnVal);
						} 
					}
				}
			}
		}
	}
}

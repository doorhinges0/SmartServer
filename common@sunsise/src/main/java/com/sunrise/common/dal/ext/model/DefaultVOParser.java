package com.sunrise.common.dal.ext.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import com.sunrise.common.model.codegenerator.CodeGenratorTool;
import com.sunrise.common.model.tableconfig.TableExtColumnManager;
import com.sunrise.common.utils.bean.BeanUtils;
import com.sunrise.common.utils.json.JsonUtil;
import com.sunrise.ucp.dal.gen.model.TableColumnConfigVO;
import com.sunrise.ucp.dal.gen.model.UserVO;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sunrise.common.model.SerialNoHolder;
import com.sunrise.common.model.config.TableConfigFacade;
import com.sunrise.common.utils.SpringCtxUtils;
import com.sunrise.common.utils.collection.CollectionUtils;
import com.sunrise.common.utils.string.StringToolkit;

public class DefaultVOParser implements VOParser {
	
	private Logger logger = LoggerFactory.getLogger(DefaultVOParser.class);
	
	public static final String[] COMMON_FIELDS = new String[]{"creator","createtime","updator","updatetime"};
	
	public static final String[] COMMON_FIELDS_UPDATE = new String[]{"updator","updatetime"};
	
	
	
	public void beforeCreate(Object vo, String voJson) {
		try {
			TableConfigFacade tableConfig = SpringCtxUtils.getBean(TableConfigFacade.class);
			List<TableColumnConfigVO> cols = tableConfig.queryTableConfigColumn(vo.getClass().getName(), true);
			if (CollectionUtils.isNotEmpty(cols)){
				for (TableColumnConfigVO col : cols) {
					String prop = col.getVofieldname();
					Object val = BeanUtils.getProperty(vo, prop);
					if (null == val){//如果存在值，则不作处理
						if (col.getIsuniqcode()){//唯一编码
							String preFix = JsonUtil.getPropertyOfJson(col.getRulejson(), "prefix", String.class);
							PropertyUtils.setProperty(vo, prop, CodeGenratorTool.genObjectCode(preFix));
						}else {
							PropertyUtils.setProperty(vo, prop, TableExtColumnManager.getValue(vo, col.getRulejson()));
						}
					}else {
						Boolean forceSet = JsonUtil.getPropertyOfJson(col.getRulejson(), "forceSet", Boolean.class);
						if (forceSet != null && forceSet){
							if (col.getIsuniqcode()){//唯一编码
								String preFix = JsonUtil.getPropertyOfJson(col.getRulejson(), "prefix", String.class);
								PropertyUtils.setProperty(vo, prop,CodeGenratorTool.genObjectCode(preFix));
							}else {
								PropertyUtils.setProperty(vo, prop, TableExtColumnManager.getValue(vo, col.getRulejson()));
							}
						}
					}
				}
			}
			
			for (String fieldName : COMMON_FIELDS) {
                if (BeanUtils.containsProperty(vo, fieldName)){
                     if (null == BeanUtils.getProperty(vo, fieldName)){
                    	 setCommonFieldVal(vo,fieldName);
                     }
                }
           }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void setCommonFieldVal(Object vo,String prop){
		try {
			if ("creator".equals(prop)){
				PropertyUtils.setProperty(vo, prop,SerialNoHolder.userCode.get());
			}else if ("createtime".equals(prop)){
				PropertyUtils.setProperty(vo, prop,new Date());
			}else if ("updator".equals(prop)){
				PropertyUtils.setProperty(vo, prop,SerialNoHolder.userCode.get());
			}else if ("updatetime".equals(prop)){
				PropertyUtils.setProperty(vo, prop,new Date());
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	public void afterCreate(Object vo, String voJson) {
	}

	//暂时硬件编码，后续优化
	public void beforeVOUpdate(Object vo, String requestJson) {
		if (vo instanceof UserVO) {// 更新用户信息时，指定用户编码放在targetusercode属性中
			String targetUsercode = JsonUtil.getPropertyOfJson(requestJson,
					"targetusercode", String.class);
			if (StringToolkit.isNotEmpty(targetUsercode)){
				((UserVO) vo).setUsercode(targetUsercode);
			}
			
		}
		
		//修改updator,updatertime
		for (String fieldName : COMMON_FIELDS_UPDATE) {
            if (BeanUtils.containsProperty(vo, fieldName)){
                setCommonFieldVal(vo,fieldName);
            }
       }
	}

	public void afterVOUpdate(Object vo, String voJson, Object result) {
		
	}

	public void beforeSelect(Object example, String json) {
		// TODO Auto-generated method stub
		
	}

	public void afterSelect(Object results, int amount, Object example,
			String json) {
		// TODO Auto-generated method stub
		
	}
	
}

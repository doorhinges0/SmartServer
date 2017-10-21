package com.dtsjy.mdboss.common.model;

import java.util.List;
import java.util.Map;

import com.dtsjy.mdboss.ucp.dal.gen.model.TableColumnConfigVO;

public class SerialNoHolder4Rest {
	public  static ThreadLocal<String> serialNo = new ThreadLocal<String>();//交易流程号
	public  static ThreadLocal<String> userCode = new ThreadLocal<String>();//用户编码
	
	// TODO 下面两个属性需要重构
	// 缓存是否需要进行 code2name
	public static ThreadLocal<Map<String, Boolean>> convertMap = new ThreadLocal<Map<String, Boolean>>();
	// 缓存 code2name 转换配置
	public static ThreadLocal<Map<String, List<TableColumnConfigVO>>> TableColumnConfig = new ThreadLocal<Map<String, List<TableColumnConfigVO>>>();
}

package com.sunrise.common.model.impl;

import com.alibaba.fastjson.JSONObject;
import com.sunrise.common.model.BaseQuery;
import com.sunrise.common.model.QueryGetter;

public class DefaultQueyGetter implements QueryGetter {
	public <T extends BaseQuery>T getQuery(String jsonData,Class<T> clz) {
		return JSONObject.parseObject(jsonData, clz);
	};
}

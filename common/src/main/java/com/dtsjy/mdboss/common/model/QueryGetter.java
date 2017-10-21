package com.dtsjy.mdboss.common.model;

import com.dtsjy.mdboss.common.model.BaseQuery;

public interface QueryGetter{
	public <T extends BaseQuery> T getQuery(String jsonData,Class<T> clz);
}

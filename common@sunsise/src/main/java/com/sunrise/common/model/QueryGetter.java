package com.sunrise.common.model;

public interface QueryGetter{
	public <T extends BaseQuery> T getQuery(String jsonData,Class<T> clz);
}

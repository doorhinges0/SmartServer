package com.sunrise.common.dal.ext.model;

public interface VOParser {
	public void beforeCreate(Object vo, String voJson);

	public void afterCreate(Object vo, String voJson);

	public void beforeVOUpdate(Object vo, String requestJson);

	public void afterVOUpdate(Object vo, String voJson, Object result);

	public void beforeSelect(Object example, String json);

	public void afterSelect(Object results, int amount, Object example,
			String json);
}

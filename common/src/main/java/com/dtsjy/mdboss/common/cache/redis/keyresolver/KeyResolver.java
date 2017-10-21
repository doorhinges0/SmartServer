package com.dtsjy.mdboss.common.cache.redis.keyresolver;

public interface KeyResolver {
	String getKey(Object[] args);
	String getField(Object[] args);
	void setGroup(String group);
	String getGroup();
}

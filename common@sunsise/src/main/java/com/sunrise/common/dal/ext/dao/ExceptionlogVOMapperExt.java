package com.sunrise.common.dal.ext.dao;

import org.apache.ibatis.annotations.Insert;

import com.sunrise.common.dal.gen.model.ExceptionlogVO;

public interface ExceptionlogVOMapperExt {
	@Insert("INSERT INTO common_exceptionlog (serialno,hostid,appcode,createtime,servicemethod,exceptionmsg) values (#{serialno},#{hostid},#{appcode},#{createtime},#{servicemethod},#{exceptionmsg})")
	public void save(ExceptionlogVO vo);
}
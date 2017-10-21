package com.dtsjy.mdboss.common.dal.ext.dao;

import org.apache.ibatis.annotations.Insert;

import com.dtsjy.mdboss.common.dal.gen.model.ExceptionlogVO;

public interface ExceptionlogVOMapperExt {
	@Insert("INSERT INTO common_exceptionlog (serialno,hostid,appcode,createtime,servicemethod,exceptionmsg) values (#{serialno},#{hostid},#{appcode},#{createtime},#{servicemethod},#{exceptionmsg})")
	public void save(ExceptionlogVO vo);
}
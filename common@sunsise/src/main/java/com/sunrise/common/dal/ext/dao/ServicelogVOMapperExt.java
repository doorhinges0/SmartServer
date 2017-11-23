package com.sunrise.common.dal.ext.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.sunrise.common.dal.gen.model.ServicelogVO;


public interface ServicelogVOMapperExt {
	@Insert("INSERT INTO common_servicelog (serialno,usercode,appcode,apiname,createtime,inputdata,outputdata) values (#{VO.serialno},#{VO.usercode},#{VO.appcode},#{VO.apiname},#{VO.createtime},#{VO.inputdata},#{VO.outputdata})")
	public void save(@Param("VO")ServicelogVO vo);
}
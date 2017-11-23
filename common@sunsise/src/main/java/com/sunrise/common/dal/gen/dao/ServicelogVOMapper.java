package com.sunrise.common.dal.gen.dao;

import com.sunrise.common.dal.gen.model.ServicelogVO;
import com.sunrise.common.dal.gen.model.ServicelogVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ServicelogVOMapper {
    int countByExample(ServicelogVOExample example);

    int deleteByExample(ServicelogVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServicelogVO record);

    int insertSelective(ServicelogVO record);

    List<ServicelogVO> selectByExampleWithRowbounds(ServicelogVOExample example, RowBounds rowBounds);

    List<ServicelogVO> selectByExample(ServicelogVOExample example);

    ServicelogVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServicelogVO record, @Param("example") ServicelogVOExample example);

    int updateByExample(@Param("record") ServicelogVO record, @Param("example") ServicelogVOExample example);

    int updateByPrimaryKeySelective(ServicelogVO record);

    int updateByPrimaryKey(ServicelogVO record);
}
package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.DistrictVO;
import com.sunrise.ucp.dal.gen.model.DistrictVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DistrictVOMapper {
    int countByExample(DistrictVOExample example);

    int deleteByExample(DistrictVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DistrictVO record);

    int insertSelective(DistrictVO record);

    List<DistrictVO> selectByExampleWithRowbounds(DistrictVOExample example, RowBounds rowBounds);

    List<DistrictVO> selectByExample(DistrictVOExample example);

    DistrictVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DistrictVO record, @Param("example") DistrictVOExample example);

    int updateByExample(@Param("record") DistrictVO record, @Param("example") DistrictVOExample example);

    int updateByPrimaryKeySelective(DistrictVO record);

    int updateByPrimaryKey(DistrictVO record);
}
package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.CityVO;
import com.sunrise.ucp.dal.gen.model.CityVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CityVOMapper {
    int countByExample(CityVOExample example);

    int deleteByExample(CityVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityVO record);

    int insertSelective(CityVO record);

    List<CityVO> selectByExampleWithRowbounds(CityVOExample example, RowBounds rowBounds);

    List<CityVO> selectByExample(CityVOExample example);

    CityVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityVO record, @Param("example") CityVOExample example);

    int updateByExample(@Param("record") CityVO record, @Param("example") CityVOExample example);

    int updateByPrimaryKeySelective(CityVO record);

    int updateByPrimaryKey(CityVO record);
}
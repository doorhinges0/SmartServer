package com.sunrise.fsp.dal.gen.dao;

import com.sunrise.fsp.dal.gen.model.CloudFileVO;
import com.sunrise.fsp.dal.gen.model.CloudFileVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CloudFileVOMapper {
    int countByExample(CloudFileVOExample example);

    int deleteByExample(CloudFileVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CloudFileVO record);

    int insertSelective(CloudFileVO record);

    List<CloudFileVO> selectByExampleWithRowbounds(CloudFileVOExample example, RowBounds rowBounds);

    List<CloudFileVO> selectByExample(CloudFileVOExample example);

    CloudFileVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CloudFileVO record, @Param("example") CloudFileVOExample example);

    int updateByExample(@Param("record") CloudFileVO record, @Param("example") CloudFileVOExample example);

    int updateByPrimaryKeySelective(CloudFileVO record);

    int updateByPrimaryKey(CloudFileVO record);
}
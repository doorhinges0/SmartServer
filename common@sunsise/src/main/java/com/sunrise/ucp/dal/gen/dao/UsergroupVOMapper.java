package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.UsergroupVO;
import com.sunrise.ucp.dal.gen.model.UsergroupVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UsergroupVOMapper {
    int countByExample(UsergroupVOExample example);

    int deleteByExample(UsergroupVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UsergroupVO record);

    int insertSelective(UsergroupVO record);

    List<UsergroupVO> selectByExampleWithRowbounds(UsergroupVOExample example, RowBounds rowBounds);

    List<UsergroupVO> selectByExample(UsergroupVOExample example);

    UsergroupVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UsergroupVO record, @Param("example") UsergroupVOExample example);

    int updateByExample(@Param("record") UsergroupVO record, @Param("example") UsergroupVOExample example);

    int updateByPrimaryKeySelective(UsergroupVO record);

    int updateByPrimaryKey(UsergroupVO record);
}
package com.sunrise.cms.dal.gen.dao;

import com.sunrise.cms.dal.gen.model.ViewNewsVO;
import com.sunrise.cms.dal.gen.model.ViewNewsVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ViewNewsVOMapper {
    int countByExample(ViewNewsVOExample example);

    int deleteByExample(ViewNewsVOExample example);

    int insert(ViewNewsVO record);

    int insertSelective(ViewNewsVO record);

    List<ViewNewsVO> selectByExampleWithBLOBsWithRowbounds(ViewNewsVOExample example, RowBounds rowBounds);

    List<ViewNewsVO> selectByExampleWithBLOBs(ViewNewsVOExample example);

    List<ViewNewsVO> selectByExampleWithRowbounds(ViewNewsVOExample example, RowBounds rowBounds);

    List<ViewNewsVO> selectByExample(ViewNewsVOExample example);

    int updateByExampleSelective(@Param("record") ViewNewsVO record, @Param("example") ViewNewsVOExample example);

    int updateByExampleWithBLOBs(@Param("record") ViewNewsVO record, @Param("example") ViewNewsVOExample example);

    int updateByExample(@Param("record") ViewNewsVO record, @Param("example") ViewNewsVOExample example);
}
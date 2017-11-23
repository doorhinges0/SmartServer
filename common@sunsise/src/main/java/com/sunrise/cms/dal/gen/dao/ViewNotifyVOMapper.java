package com.sunrise.cms.dal.gen.dao;

import com.sunrise.cms.dal.gen.model.ViewNotifyVO;
import com.sunrise.cms.dal.gen.model.ViewNotifyVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ViewNotifyVOMapper {
    int countByExample(ViewNotifyVOExample example);

    int deleteByExample(ViewNotifyVOExample example);

    int insert(ViewNotifyVO record);

    int insertSelective(ViewNotifyVO record);

    List<ViewNotifyVO> selectByExampleWithRowbounds(ViewNotifyVOExample example, RowBounds rowBounds);

    List<ViewNotifyVO> selectByExample(ViewNotifyVOExample example);

    int updateByExampleSelective(@Param("record") ViewNotifyVO record, @Param("example") ViewNotifyVOExample example);

    int updateByExample(@Param("record") ViewNotifyVO record, @Param("example") ViewNotifyVOExample example);
}
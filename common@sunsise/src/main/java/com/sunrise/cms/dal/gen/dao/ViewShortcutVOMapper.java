package com.sunrise.cms.dal.gen.dao;

import com.sunrise.cms.dal.gen.model.ViewShortcutVO;
import com.sunrise.cms.dal.gen.model.ViewShortcutVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ViewShortcutVOMapper {
    int countByExample(ViewShortcutVOExample example);

    int deleteByExample(ViewShortcutVOExample example);

    int insert(ViewShortcutVO record);

    int insertSelective(ViewShortcutVO record);

    List<ViewShortcutVO> selectByExampleWithRowbounds(ViewShortcutVOExample example, RowBounds rowBounds);

    List<ViewShortcutVO> selectByExample(ViewShortcutVOExample example);

    int updateByExampleSelective(@Param("record") ViewShortcutVO record, @Param("example") ViewShortcutVOExample example);

    int updateByExample(@Param("record") ViewShortcutVO record, @Param("example") ViewShortcutVOExample example);
}
package com.dtsjy.mdboss.hr.dal.gen.dao;

import com.dtsjy.mdboss.hr.dal.gen.model.CheckinoutVO;
import com.dtsjy.mdboss.hr.dal.gen.model.CheckinoutVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CheckinoutVOMapper {
    int countByExample(CheckinoutVOExample example);

    int deleteByExample(CheckinoutVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckinoutVO record);

    int insertSelective(CheckinoutVO record);

    List<CheckinoutVO> selectByExampleWithRowbounds(CheckinoutVOExample example, RowBounds rowBounds);

    List<CheckinoutVO> selectByExample(CheckinoutVOExample example);

    CheckinoutVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckinoutVO record, @Param("example") CheckinoutVOExample example);

    int updateByExample(@Param("record") CheckinoutVO record, @Param("example") CheckinoutVOExample example);

    int updateByPrimaryKeySelective(CheckinoutVO record);

    int updateByPrimaryKey(CheckinoutVO record);
}
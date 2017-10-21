package com.dtsjy.mdboss.hr.dal.gen.dao;

import com.dtsjy.mdboss.hr.dal.gen.model.AttendanceResigninVO;
import com.dtsjy.mdboss.hr.dal.gen.model.AttendanceResigninVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AttendanceResigninVOMapper {
    int countByExample(AttendanceResigninVOExample example);

    int deleteByExample(AttendanceResigninVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttendanceResigninVO record);

    int insertSelective(AttendanceResigninVO record);

    List<AttendanceResigninVO> selectByExampleWithRowbounds(AttendanceResigninVOExample example, RowBounds rowBounds);

    List<AttendanceResigninVO> selectByExample(AttendanceResigninVOExample example);

    AttendanceResigninVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttendanceResigninVO record, @Param("example") AttendanceResigninVOExample example);

    int updateByExample(@Param("record") AttendanceResigninVO record, @Param("example") AttendanceResigninVOExample example);

    int updateByPrimaryKeySelective(AttendanceResigninVO record);

    int updateByPrimaryKey(AttendanceResigninVO record);
}
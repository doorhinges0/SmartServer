package com.dtsjy.mdboss.hr.dal.gen.dao;

import com.dtsjy.mdboss.hr.dal.gen.model.AttendanceMonthsignincountVO;
import com.dtsjy.mdboss.hr.dal.gen.model.AttendanceMonthsignincountVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AttendanceMonthsignincountVOMapper {
    int countByExample(AttendanceMonthsignincountVOExample example);

    int deleteByExample(AttendanceMonthsignincountVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttendanceMonthsignincountVO record);

    int insertSelective(AttendanceMonthsignincountVO record);

    List<AttendanceMonthsignincountVO> selectByExampleWithRowbounds(AttendanceMonthsignincountVOExample example, RowBounds rowBounds);

    List<AttendanceMonthsignincountVO> selectByExample(AttendanceMonthsignincountVOExample example);

    AttendanceMonthsignincountVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttendanceMonthsignincountVO record, @Param("example") AttendanceMonthsignincountVOExample example);

    int updateByExample(@Param("record") AttendanceMonthsignincountVO record, @Param("example") AttendanceMonthsignincountVOExample example);

    int updateByPrimaryKeySelective(AttendanceMonthsignincountVO record);

    int updateByPrimaryKey(AttendanceMonthsignincountVO record);
}
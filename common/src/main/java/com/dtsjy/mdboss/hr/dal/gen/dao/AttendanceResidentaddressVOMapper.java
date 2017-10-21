package com.dtsjy.mdboss.hr.dal.gen.dao;

import com.dtsjy.mdboss.hr.dal.gen.model.AttendanceResidentaddressVO;
import com.dtsjy.mdboss.hr.dal.gen.model.AttendanceResidentaddressVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AttendanceResidentaddressVOMapper {
    int countByExample(AttendanceResidentaddressVOExample example);

    int deleteByExample(AttendanceResidentaddressVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttendanceResidentaddressVO record);

    int insertSelective(AttendanceResidentaddressVO record);

    List<AttendanceResidentaddressVO> selectByExampleWithRowbounds(AttendanceResidentaddressVOExample example, RowBounds rowBounds);

    List<AttendanceResidentaddressVO> selectByExample(AttendanceResidentaddressVOExample example);

    AttendanceResidentaddressVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttendanceResidentaddressVO record, @Param("example") AttendanceResidentaddressVOExample example);

    int updateByExample(@Param("record") AttendanceResidentaddressVO record, @Param("example") AttendanceResidentaddressVOExample example);

    int updateByPrimaryKeySelective(AttendanceResidentaddressVO record);

    int updateByPrimaryKey(AttendanceResidentaddressVO record);
}
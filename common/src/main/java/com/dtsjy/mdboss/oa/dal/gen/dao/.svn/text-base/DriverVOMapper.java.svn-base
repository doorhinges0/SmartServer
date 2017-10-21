package com.dtsjy.mdboss.oa.dal.gen.dao;

import com.dtsjy.mdboss.oa.dal.gen.model.DriverVO;
import com.dtsjy.mdboss.oa.dal.gen.model.DriverVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DriverVOMapper {
    int countByExample(DriverVOExample example);

    int deleteByExample(DriverVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DriverVO record);

    int insertSelective(DriverVO record);

    List<DriverVO> selectByExampleWithRowbounds(DriverVOExample example, RowBounds rowBounds);

    List<DriverVO> selectByExample(DriverVOExample example);

    DriverVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DriverVO record, @Param("example") DriverVOExample example);

    int updateByExample(@Param("record") DriverVO record, @Param("example") DriverVOExample example);

    int updateByPrimaryKeySelective(DriverVO record);

    int updateByPrimaryKey(DriverVO record);
}
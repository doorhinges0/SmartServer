package com.dtsjy.mdboss.common.dal.gen.dao;

import com.dtsjy.mdboss.common.dal.gen.model.SysParamVO;
import com.dtsjy.mdboss.common.dal.gen.model.SysParamVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysParamVOMapper {
    int countByExample(SysParamVOExample example);

    int deleteByExample(SysParamVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysParamVO record);

    int insertSelective(SysParamVO record);

    List<SysParamVO> selectByExampleWithRowbounds(SysParamVOExample example, RowBounds rowBounds);

    List<SysParamVO> selectByExample(SysParamVOExample example);

    SysParamVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysParamVO record, @Param("example") SysParamVOExample example);

    int updateByExample(@Param("record") SysParamVO record, @Param("example") SysParamVOExample example);

    int updateByPrimaryKeySelective(SysParamVO record);

    int updateByPrimaryKey(SysParamVO record);
}
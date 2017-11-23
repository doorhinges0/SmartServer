package com.sunrise.oa.dal.gen.dao;

import com.sunrise.oa.dal.gen.model.SealsVO;
import com.sunrise.oa.dal.gen.model.SealsVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SealsVOMapper {
    int countByExample(SealsVOExample example);

    int deleteByExample(SealsVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SealsVO record);

    int insertSelective(SealsVO record);

    List<SealsVO> selectByExampleWithBLOBsWithRowbounds(SealsVOExample example, RowBounds rowBounds);

    List<SealsVO> selectByExampleWithBLOBs(SealsVOExample example);

    List<SealsVO> selectByExampleWithRowbounds(SealsVOExample example, RowBounds rowBounds);

    List<SealsVO> selectByExample(SealsVOExample example);

    SealsVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SealsVO record, @Param("example") SealsVOExample example);

    int updateByExampleWithBLOBs(@Param("record") SealsVO record, @Param("example") SealsVOExample example);

    int updateByExample(@Param("record") SealsVO record, @Param("example") SealsVOExample example);

    int updateByPrimaryKeySelective(SealsVO record);

    int updateByPrimaryKeyWithBLOBs(SealsVO record);

    int updateByPrimaryKey(SealsVO record);
}
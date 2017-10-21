package com.dtsjy.mdboss.ucp.dal.gen.dao;

import com.dtsjy.mdboss.ucp.dal.gen.model.InterfdefVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.InterfdefVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InterfdefVOMapper {
    int countByExample(InterfdefVOExample example);

    int deleteByExample(InterfdefVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InterfdefVO record);

    int insertSelective(InterfdefVO record);

    List<InterfdefVO> selectByExampleWithRowbounds(InterfdefVOExample example, RowBounds rowBounds);

    List<InterfdefVO> selectByExample(InterfdefVOExample example);

    InterfdefVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InterfdefVO record, @Param("example") InterfdefVOExample example);

    int updateByExample(@Param("record") InterfdefVO record, @Param("example") InterfdefVOExample example);

    int updateByPrimaryKeySelective(InterfdefVO record);

    int updateByPrimaryKey(InterfdefVO record);
}
package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.DictGroupVO;
import com.sunrise.ucp.dal.gen.model.DictGroupVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DictGroupVOMapper {
    int countByExample(DictGroupVOExample example);

    int deleteByExample(DictGroupVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictGroupVO record);

    int insertSelective(DictGroupVO record);

    List<DictGroupVO> selectByExampleWithRowbounds(DictGroupVOExample example, RowBounds rowBounds);

    List<DictGroupVO> selectByExample(DictGroupVOExample example);

    DictGroupVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictGroupVO record, @Param("example") DictGroupVOExample example);

    int updateByExample(@Param("record") DictGroupVO record, @Param("example") DictGroupVOExample example);

    int updateByPrimaryKeySelective(DictGroupVO record);

    int updateByPrimaryKey(DictGroupVO record);
}
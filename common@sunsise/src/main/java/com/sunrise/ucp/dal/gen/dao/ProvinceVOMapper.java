package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.ProvinceVO;
import com.sunrise.ucp.dal.gen.model.ProvinceVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProvinceVOMapper {
    int countByExample(ProvinceVOExample example);

    int deleteByExample(ProvinceVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProvinceVO record);

    int insertSelective(ProvinceVO record);

    List<ProvinceVO> selectByExampleWithRowbounds(ProvinceVOExample example, RowBounds rowBounds);

    List<ProvinceVO> selectByExample(ProvinceVOExample example);

    ProvinceVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProvinceVO record, @Param("example") ProvinceVOExample example);

    int updateByExample(@Param("record") ProvinceVO record, @Param("example") ProvinceVOExample example);

    int updateByPrimaryKeySelective(ProvinceVO record);

    int updateByPrimaryKey(ProvinceVO record);
}
package com.sunrise.fsp.dal.gen.dao;

import com.sunrise.fsp.dal.gen.model.VirtualfileVO;
import com.sunrise.fsp.dal.gen.model.VirtualfileVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface VirtualfileVOMapper {
    int countByExample(VirtualfileVOExample example);

    int deleteByExample(VirtualfileVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VirtualfileVO record);

    int insertSelective(VirtualfileVO record);

    List<VirtualfileVO> selectByExampleWithRowbounds(VirtualfileVOExample example, RowBounds rowBounds);

    List<VirtualfileVO> selectByExample(VirtualfileVOExample example);

    VirtualfileVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VirtualfileVO record, @Param("example") VirtualfileVOExample example);

    int updateByExample(@Param("record") VirtualfileVO record, @Param("example") VirtualfileVOExample example);

    int updateByPrimaryKeySelective(VirtualfileVO record);

    int updateByPrimaryKey(VirtualfileVO record);
}
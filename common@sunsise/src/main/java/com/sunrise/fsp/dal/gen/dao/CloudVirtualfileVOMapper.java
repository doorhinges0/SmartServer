package com.sunrise.fsp.dal.gen.dao;

import com.sunrise.fsp.dal.gen.model.CloudVirtualfileVO;
import com.sunrise.fsp.dal.gen.model.CloudVirtualfileVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CloudVirtualfileVOMapper {
    int countByExample(CloudVirtualfileVOExample example);

    int deleteByExample(CloudVirtualfileVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CloudVirtualfileVO record);

    int insertSelective(CloudVirtualfileVO record);

    List<CloudVirtualfileVO> selectByExampleWithRowbounds(CloudVirtualfileVOExample example, RowBounds rowBounds);

    List<CloudVirtualfileVO> selectByExample(CloudVirtualfileVOExample example);

    CloudVirtualfileVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CloudVirtualfileVO record, @Param("example") CloudVirtualfileVOExample example);

    int updateByExample(@Param("record") CloudVirtualfileVO record, @Param("example") CloudVirtualfileVOExample example);

    int updateByPrimaryKeySelective(CloudVirtualfileVO record);

    int updateByPrimaryKey(CloudVirtualfileVO record);
}
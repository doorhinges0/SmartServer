package com.sunrise.wfs.dal.gen.dao;

import com.sunrise.wfs.dal.gen.model.ViewDelegationVO;
import com.sunrise.wfs.dal.gen.model.ViewDelegationVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ViewDelegationVOMapper {
    int countByExample(ViewDelegationVOExample example);

    int deleteByExample(ViewDelegationVOExample example);

    int insert(ViewDelegationVO record);

    int insertSelective(ViewDelegationVO record);

    List<ViewDelegationVO> selectByExampleWithRowbounds(ViewDelegationVOExample example, RowBounds rowBounds);

    List<ViewDelegationVO> selectByExample(ViewDelegationVOExample example);

    int updateByExampleSelective(@Param("record") ViewDelegationVO record, @Param("example") ViewDelegationVOExample example);

    int updateByExample(@Param("record") ViewDelegationVO record, @Param("example") ViewDelegationVOExample example);
}
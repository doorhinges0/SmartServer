package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.OrgVO;
import com.sunrise.ucp.dal.gen.model.OrgVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrgVOMapper {
    int countByExample(OrgVOExample example);

    int deleteByExample(OrgVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrgVO record);

    int insertSelective(OrgVO record);

    List<OrgVO> selectByExampleWithRowbounds(OrgVOExample example, RowBounds rowBounds);

    List<OrgVO> selectByExample(OrgVOExample example);

    OrgVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrgVO record, @Param("example") OrgVOExample example);

    int updateByExample(@Param("record") OrgVO record, @Param("example") OrgVOExample example);

    int updateByPrimaryKeySelective(OrgVO record);

    int updateByPrimaryKey(OrgVO record);
}
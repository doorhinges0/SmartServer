package com.dtsjy.mdboss.ucp.dal.gen.dao;

import com.dtsjy.mdboss.ucp.dal.gen.model.RoleVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.RoleVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RoleVOMapper {
    int countByExample(RoleVOExample example);

    int deleteByExample(RoleVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleVO record);

    int insertSelective(RoleVO record);

    List<RoleVO> selectByExampleWithRowbounds(RoleVOExample example, RowBounds rowBounds);

    List<RoleVO> selectByExample(RoleVOExample example);

    RoleVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleVO record, @Param("example") RoleVOExample example);

    int updateByExample(@Param("record") RoleVO record, @Param("example") RoleVOExample example);

    int updateByPrimaryKeySelective(RoleVO record);

    int updateByPrimaryKey(RoleVO record);
}
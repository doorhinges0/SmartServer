package com.dtsjy.mdboss.ucp.dal.gen.dao;

import com.dtsjy.mdboss.ucp.dal.gen.model.UserRoleVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.UserRoleVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserRoleVOMapper {
    int countByExample(UserRoleVOExample example);

    int deleteByExample(UserRoleVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleVO record);

    int insertSelective(UserRoleVO record);

    List<UserRoleVO> selectByExampleWithRowbounds(UserRoleVOExample example, RowBounds rowBounds);

    List<UserRoleVO> selectByExample(UserRoleVOExample example);

    UserRoleVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRoleVO record, @Param("example") UserRoleVOExample example);

    int updateByExample(@Param("record") UserRoleVO record, @Param("example") UserRoleVOExample example);

    int updateByPrimaryKeySelective(UserRoleVO record);

    int updateByPrimaryKey(UserRoleVO record);
}
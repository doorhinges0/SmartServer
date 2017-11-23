package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.UsergroupMemberVO;
import com.sunrise.ucp.dal.gen.model.UsergroupMemberVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UsergroupMemberVOMapper {
    int countByExample(UsergroupMemberVOExample example);

    int deleteByExample(UsergroupMemberVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UsergroupMemberVO record);

    int insertSelective(UsergroupMemberVO record);

    List<UsergroupMemberVO> selectByExampleWithRowbounds(UsergroupMemberVOExample example, RowBounds rowBounds);

    List<UsergroupMemberVO> selectByExample(UsergroupMemberVOExample example);

    UsergroupMemberVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UsergroupMemberVO record, @Param("example") UsergroupMemberVOExample example);

    int updateByExample(@Param("record") UsergroupMemberVO record, @Param("example") UsergroupMemberVOExample example);

    int updateByPrimaryKeySelective(UsergroupMemberVO record);

    int updateByPrimaryKey(UsergroupMemberVO record);
}
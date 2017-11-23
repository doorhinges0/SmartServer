package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.ViewUsergroupMemberVO;
import com.sunrise.ucp.dal.gen.model.ViewUsergroupMemberVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ViewUsergroupMemberVOMapper {
    int countByExample(ViewUsergroupMemberVOExample example);

    int deleteByExample(ViewUsergroupMemberVOExample example);

    int insert(ViewUsergroupMemberVO record);

    int insertSelective(ViewUsergroupMemberVO record);

    List<ViewUsergroupMemberVO> selectByExampleWithBLOBsWithRowbounds(ViewUsergroupMemberVOExample example, RowBounds rowBounds);

    List<ViewUsergroupMemberVO> selectByExampleWithBLOBs(ViewUsergroupMemberVOExample example);

    List<ViewUsergroupMemberVO> selectByExampleWithRowbounds(ViewUsergroupMemberVOExample example, RowBounds rowBounds);

    List<ViewUsergroupMemberVO> selectByExample(ViewUsergroupMemberVOExample example);

    int updateByExampleSelective(@Param("record") ViewUsergroupMemberVO record, @Param("example") ViewUsergroupMemberVOExample example);

    int updateByExampleWithBLOBs(@Param("record") ViewUsergroupMemberVO record, @Param("example") ViewUsergroupMemberVOExample example);

    int updateByExample(@Param("record") ViewUsergroupMemberVO record, @Param("example") ViewUsergroupMemberVOExample example);
}
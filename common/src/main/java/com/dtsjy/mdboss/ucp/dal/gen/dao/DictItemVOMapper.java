package com.dtsjy.mdboss.ucp.dal.gen.dao;

import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.DictItemVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DictItemVOMapper {
    int countByExample(DictItemVOExample example);

    int deleteByExample(DictItemVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictItemVO record);

    int insertSelective(DictItemVO record);

    List<DictItemVO> selectByExampleWithRowbounds(DictItemVOExample example, RowBounds rowBounds);

    List<DictItemVO> selectByExample(DictItemVOExample example);

    DictItemVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictItemVO record, @Param("example") DictItemVOExample example);

    int updateByExample(@Param("record") DictItemVO record, @Param("example") DictItemVOExample example);

    int updateByPrimaryKeySelective(DictItemVO record);

    int updateByPrimaryKey(DictItemVO record);
}
package com.dtsjy.mdboss.ucp.dal.gen.dao;

import com.dtsjy.mdboss.ucp.dal.gen.model.TableConfigVO;
import com.dtsjy.mdboss.ucp.dal.gen.model.TableConfigVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TableConfigVOMapper {
    int countByExample(TableConfigVOExample example);

    int deleteByExample(TableConfigVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TableConfigVO record);

    int insertSelective(TableConfigVO record);

    List<TableConfigVO> selectByExampleWithRowbounds(TableConfigVOExample example, RowBounds rowBounds);

    List<TableConfigVO> selectByExample(TableConfigVOExample example);

    TableConfigVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TableConfigVO record, @Param("example") TableConfigVOExample example);

    int updateByExample(@Param("record") TableConfigVO record, @Param("example") TableConfigVOExample example);

    int updateByPrimaryKeySelective(TableConfigVO record);

    int updateByPrimaryKey(TableConfigVO record);
}
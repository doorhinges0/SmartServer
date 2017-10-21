package com.dtsjy.mdboss.common.dal.gen.dao;

import com.dtsjy.mdboss.common.dal.gen.model.ExceptionlogVO;
import com.dtsjy.mdboss.common.dal.gen.model.ExceptionlogVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ExceptionlogVOMapper {
    int countByExample(ExceptionlogVOExample example);

    int deleteByExample(ExceptionlogVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExceptionlogVO record);

    int insertSelective(ExceptionlogVO record);

    List<ExceptionlogVO> selectByExampleWithRowbounds(ExceptionlogVOExample example, RowBounds rowBounds);

    List<ExceptionlogVO> selectByExample(ExceptionlogVOExample example);

    ExceptionlogVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExceptionlogVO record, @Param("example") ExceptionlogVOExample example);

    int updateByExample(@Param("record") ExceptionlogVO record, @Param("example") ExceptionlogVOExample example);

    int updateByPrimaryKeySelective(ExceptionlogVO record);

    int updateByPrimaryKey(ExceptionlogVO record);
}
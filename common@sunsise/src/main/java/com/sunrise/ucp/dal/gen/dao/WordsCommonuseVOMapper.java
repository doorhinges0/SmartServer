package com.sunrise.ucp.dal.gen.dao;

import com.sunrise.ucp.dal.gen.model.WordsCommonuseVO;
import com.sunrise.ucp.dal.gen.model.WordsCommonuseVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface WordsCommonuseVOMapper {
    int countByExample(WordsCommonuseVOExample example);

    int deleteByExample(WordsCommonuseVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WordsCommonuseVO record);

    int insertSelective(WordsCommonuseVO record);

    List<WordsCommonuseVO> selectByExampleWithRowbounds(WordsCommonuseVOExample example, RowBounds rowBounds);

    List<WordsCommonuseVO> selectByExample(WordsCommonuseVOExample example);

    WordsCommonuseVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WordsCommonuseVO record, @Param("example") WordsCommonuseVOExample example);

    int updateByExample(@Param("record") WordsCommonuseVO record, @Param("example") WordsCommonuseVOExample example);

    int updateByPrimaryKeySelective(WordsCommonuseVO record);

    int updateByPrimaryKey(WordsCommonuseVO record);
}
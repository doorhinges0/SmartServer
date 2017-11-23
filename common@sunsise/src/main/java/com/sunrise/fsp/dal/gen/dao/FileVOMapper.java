package com.sunrise.fsp.dal.gen.dao;

import com.sunrise.fsp.dal.gen.model.FileVO;
import com.sunrise.fsp.dal.gen.model.FileVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FileVOMapper {
    int countByExample(FileVOExample example);

    int deleteByExample(FileVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileVO record);

    int insertSelective(FileVO record);

    List<FileVO> selectByExampleWithRowbounds(FileVOExample example, RowBounds rowBounds);

    List<FileVO> selectByExample(FileVOExample example);

    FileVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileVO record, @Param("example") FileVOExample example);

    int updateByExample(@Param("record") FileVO record, @Param("example") FileVOExample example);

    int updateByPrimaryKeySelective(FileVO record);

    int updateByPrimaryKey(FileVO record);
}
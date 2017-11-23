package com.sunrise.tm.dal.gen.dao;

import com.sunrise.tm.dal.gen.model.TaskFileVO;
import com.sunrise.tm.dal.gen.model.TaskFileVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskFileVOMapper {
    int countByExample(TaskFileVOExample example);

    int deleteByExample(TaskFileVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskFileVO record);

    int insertSelective(TaskFileVO record);

    List<TaskFileVO> selectByExampleWithRowbounds(TaskFileVOExample example, RowBounds rowBounds);

    List<TaskFileVO> selectByExample(TaskFileVOExample example);

    TaskFileVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskFileVO record, @Param("example") TaskFileVOExample example);

    int updateByExample(@Param("record") TaskFileVO record, @Param("example") TaskFileVOExample example);

    int updateByPrimaryKeySelective(TaskFileVO record);

    int updateByPrimaryKey(TaskFileVO record);
}
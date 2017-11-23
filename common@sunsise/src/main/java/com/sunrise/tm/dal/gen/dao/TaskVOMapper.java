package com.sunrise.tm.dal.gen.dao;

import com.sunrise.tm.dal.gen.model.TaskVO;
import com.sunrise.tm.dal.gen.model.TaskVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskVOMapper {
    int countByExample(TaskVOExample example);

    int deleteByExample(TaskVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskVO record);

    int insertSelective(TaskVO record);

    List<TaskVO> selectByExampleWithRowbounds(TaskVOExample example, RowBounds rowBounds);

    List<TaskVO> selectByExample(TaskVOExample example);

    TaskVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskVO record, @Param("example") TaskVOExample example);

    int updateByExample(@Param("record") TaskVO record, @Param("example") TaskVOExample example);

    int updateByPrimaryKeySelective(TaskVO record);

    int updateByPrimaryKey(TaskVO record);
}
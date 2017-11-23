package com.sunrise.tm.dal.gen.dao;

import com.sunrise.tm.dal.gen.model.TaskAttachmentVO;
import com.sunrise.tm.dal.gen.model.TaskAttachmentVOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TaskAttachmentVOMapper {
    int countByExample(TaskAttachmentVOExample example);

    int deleteByExample(TaskAttachmentVOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskAttachmentVO record);

    int insertSelective(TaskAttachmentVO record);

    List<TaskAttachmentVO> selectByExampleWithRowbounds(TaskAttachmentVOExample example, RowBounds rowBounds);

    List<TaskAttachmentVO> selectByExample(TaskAttachmentVOExample example);

    TaskAttachmentVO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskAttachmentVO record, @Param("example") TaskAttachmentVOExample example);

    int updateByExample(@Param("record") TaskAttachmentVO record, @Param("example") TaskAttachmentVOExample example);

    int updateByPrimaryKeySelective(TaskAttachmentVO record);

    int updateByPrimaryKey(TaskAttachmentVO record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.TaskAttach;
import com.zrt.mybatis.domain.TaskAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskAttachMapper {
    int countByExample(TaskAttachExample example);

    int deleteByExample(TaskAttachExample example);

    int deleteByPrimaryKey(String taskAttackId);

    int insert(TaskAttach record);

    int insertSelective(TaskAttach record);

    List<TaskAttach> selectByExample(TaskAttachExample example);

    TaskAttach selectByPrimaryKey(String taskAttackId);

    int updateByExampleSelective(@Param("record") TaskAttach record, @Param("example") TaskAttachExample example);

    int updateByExample(@Param("record") TaskAttach record, @Param("example") TaskAttachExample example);

    int updateByPrimaryKeySelective(TaskAttach record);

    int updateByPrimaryKey(TaskAttach record);
}
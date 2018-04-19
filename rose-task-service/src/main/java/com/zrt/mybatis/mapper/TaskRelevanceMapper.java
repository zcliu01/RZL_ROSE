package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.TaskRelevance;
import com.zrt.mybatis.domain.TaskRelevanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskRelevanceMapper {
    int countByExample(TaskRelevanceExample example);

    int deleteByExample(TaskRelevanceExample example);

    int deleteByPrimaryKey(String relTaskId);

    int insert(TaskRelevance record);

    int insertSelective(TaskRelevance record);

    List<TaskRelevance> selectByExample(TaskRelevanceExample example);

    TaskRelevance selectByPrimaryKey(String relTaskId);

    int updateByExampleSelective(@Param("record") TaskRelevance record, @Param("example") TaskRelevanceExample example);

    int updateByExample(@Param("record") TaskRelevance record, @Param("example") TaskRelevanceExample example);

    int updateByPrimaryKeySelective(TaskRelevance record);

    int updateByPrimaryKey(TaskRelevance record);
}
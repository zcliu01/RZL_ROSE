package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.TaskEcexutor;
import com.zrt.mybatis.domain.TaskEcexutorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskEcexutorMapper {
    int countByExample(TaskEcexutorExample example);

    int deleteByExample(TaskEcexutorExample example);

    int deleteByPrimaryKey(String taskEmpId);

    int insert(TaskEcexutor record);

    int insertSelective(TaskEcexutor record);

    List<TaskEcexutor> selectByExample(TaskEcexutorExample example);

    TaskEcexutor selectByPrimaryKey(String taskEmpId);

    int updateByExampleSelective(@Param("record") TaskEcexutor record, @Param("example") TaskEcexutorExample example);

    int updateByExample(@Param("record") TaskEcexutor record, @Param("example") TaskEcexutorExample example);

    int updateByPrimaryKeySelective(TaskEcexutor record);

    int updateByPrimaryKey(TaskEcexutor record);
}
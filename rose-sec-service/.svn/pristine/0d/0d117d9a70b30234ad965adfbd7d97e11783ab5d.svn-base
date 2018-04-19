package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.EmpLoginRecord;
import com.zrt.mybatis.domain.EmpLoginRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpLoginRecordMapper {
    int countByExample(EmpLoginRecordExample example);

    int deleteByExample(EmpLoginRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmpLoginRecord record);

    int insertSelective(EmpLoginRecord record);

    List<EmpLoginRecord> selectByExample(EmpLoginRecordExample example);

    EmpLoginRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmpLoginRecord record, @Param("example") EmpLoginRecordExample example);

    int updateByExample(@Param("record") EmpLoginRecord record, @Param("example") EmpLoginRecordExample example);

    int updateByPrimaryKeySelective(EmpLoginRecord record);

    int updateByPrimaryKey(EmpLoginRecord record);
}
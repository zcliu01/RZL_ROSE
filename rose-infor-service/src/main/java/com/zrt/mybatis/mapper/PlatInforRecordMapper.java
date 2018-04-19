package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.PlatInforRecord;
import com.zrt.mybatis.domain.PlatInforRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatInforRecordMapper {
    int countByExample(PlatInforRecordExample example);

    int deleteByExample(PlatInforRecordExample example);

    int deleteByPrimaryKey(String inforId);

    int insert(PlatInforRecord record);

    int insertSelective(PlatInforRecord record);

    List<PlatInforRecord> selectByExampleWithBLOBs(PlatInforRecordExample example);

    List<PlatInforRecord> selectByExample(PlatInforRecordExample example);

    PlatInforRecord selectByPrimaryKey(String inforId);

    int updateByExampleSelective(@Param("record") PlatInforRecord record, @Param("example") PlatInforRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") PlatInforRecord record, @Param("example") PlatInforRecordExample example);

    int updateByExample(@Param("record") PlatInforRecord record, @Param("example") PlatInforRecordExample example);

    int updateByPrimaryKeySelective(PlatInforRecord record);

    int updateByPrimaryKeyWithBLOBs(PlatInforRecord record);

    int updateByPrimaryKey(PlatInforRecord record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.VmBusRecord;
import com.zrt.mybatis.domain.VmBusRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmBusRecordMapper {
    int countByExample(VmBusRecordExample example);

    int deleteByExample(VmBusRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(VmBusRecord record);

    int insertSelective(VmBusRecord record);

    List<VmBusRecord> selectByExample(VmBusRecordExample example);

    VmBusRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VmBusRecord record, @Param("example") VmBusRecordExample example);

    int updateByExample(@Param("record") VmBusRecord record, @Param("example") VmBusRecordExample example);

    int updateByPrimaryKeySelective(VmBusRecord record);

    int updateByPrimaryKey(VmBusRecord record);
}
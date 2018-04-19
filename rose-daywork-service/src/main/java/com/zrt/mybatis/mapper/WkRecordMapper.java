package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.WkRecord;
import com.zrt.mybatis.domain.WkRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WkRecordMapper {
    int countByExample(WkRecordExample example);

    int deleteByExample(WkRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(WkRecord record);

    int insertSelective(WkRecord record);

    List<WkRecord> selectByExample(WkRecordExample example);

    WkRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WkRecord record, @Param("example") WkRecordExample example);

    int updateByExample(@Param("record") WkRecord record, @Param("example") WkRecordExample example);

    int updateByPrimaryKeySelective(WkRecord record);

    int updateByPrimaryKey(WkRecord record);
}
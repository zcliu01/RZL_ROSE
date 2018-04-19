package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusEntrust;
import com.zrt.mybatis.domain.FbBusEntrustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusEntrustMapper {
    int countByExample(FbBusEntrustExample example);

    int deleteByExample(FbBusEntrustExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusEntrust record);

    int insertSelective(FbBusEntrust record);

    List<FbBusEntrust> selectByExample(FbBusEntrustExample example);

    FbBusEntrust selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusEntrust record, @Param("example") FbBusEntrustExample example);

    int updateByExample(@Param("record") FbBusEntrust record, @Param("example") FbBusEntrustExample example);

    int updateByPrimaryKeySelective(FbBusEntrust record);

    int updateByPrimaryKey(FbBusEntrust record);
}
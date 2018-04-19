package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusInstNotify;
import com.zrt.mybatis.domain.FbBusInstNotifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusInstNotifyMapper {
    int countByExample(FbBusInstNotifyExample example);

    int deleteByExample(FbBusInstNotifyExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusInstNotify record);

    int insertSelective(FbBusInstNotify record);

    List<FbBusInstNotify> selectByExample(FbBusInstNotifyExample example);

    FbBusInstNotify selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusInstNotify record, @Param("example") FbBusInstNotifyExample example);

    int updateByExample(@Param("record") FbBusInstNotify record, @Param("example") FbBusInstNotifyExample example);

    int updateByPrimaryKeySelective(FbBusInstNotify record);

    int updateByPrimaryKey(FbBusInstNotify record);
}
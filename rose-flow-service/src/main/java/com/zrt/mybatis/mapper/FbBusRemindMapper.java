package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusRemind;
import com.zrt.mybatis.domain.FbBusRemindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusRemindMapper {
    int countByExample(FbBusRemindExample example);

    int deleteByExample(FbBusRemindExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusRemind record);

    int insertSelective(FbBusRemind record);

    List<FbBusRemind> selectByExample(FbBusRemindExample example);

    FbBusRemind selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusRemind record, @Param("example") FbBusRemindExample example);

    int updateByExample(@Param("record") FbBusRemind record, @Param("example") FbBusRemindExample example);

    int updateByPrimaryKeySelective(FbBusRemind record);

    int updateByPrimaryKey(FbBusRemind record);
}
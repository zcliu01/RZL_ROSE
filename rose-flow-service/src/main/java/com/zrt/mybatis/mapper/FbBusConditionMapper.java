package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusCondition;
import com.zrt.mybatis.domain.FbBusConditionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusConditionMapper {
    int countByExample(FbBusConditionExample example);

    int deleteByExample(FbBusConditionExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusCondition record);

    int insertSelective(FbBusCondition record);

    List<FbBusCondition> selectByExample(FbBusConditionExample example);

    FbBusCondition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusCondition record, @Param("example") FbBusConditionExample example);

    int updateByExample(@Param("record") FbBusCondition record, @Param("example") FbBusConditionExample example);

    int updateByPrimaryKeySelective(FbBusCondition record);

    int updateByPrimaryKey(FbBusCondition record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusRule;
import com.zrt.mybatis.domain.FbBusRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusRuleMapper {
    int countByExample(FbBusRuleExample example);

    int deleteByExample(FbBusRuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusRule record);

    int insertSelective(FbBusRule record);

    List<FbBusRule> selectByExample(FbBusRuleExample example);

    FbBusRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusRule record, @Param("example") FbBusRuleExample example);

    int updateByExample(@Param("record") FbBusRule record, @Param("example") FbBusRuleExample example);

    int updateByPrimaryKeySelective(FbBusRule record);

    int updateByPrimaryKey(FbBusRule record);
}
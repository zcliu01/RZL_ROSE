package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusRejectRule;
import com.zrt.mybatis.domain.FbBusRejectRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusRejectRuleMapper {
    int countByExample(FbBusRejectRuleExample example);

    int deleteByExample(FbBusRejectRuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusRejectRule record);

    int insertSelective(FbBusRejectRule record);

    List<FbBusRejectRule> selectByExample(FbBusRejectRuleExample example);

    FbBusRejectRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusRejectRule record, @Param("example") FbBusRejectRuleExample example);

    int updateByExample(@Param("record") FbBusRejectRule record, @Param("example") FbBusRejectRuleExample example);

    int updateByPrimaryKeySelective(FbBusRejectRule record);

    int updateByPrimaryKey(FbBusRejectRule record);
}
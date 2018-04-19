package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusJoinSignRelevance;
import com.zrt.mybatis.domain.FbBusJoinSignRelevanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusJoinSignRelevanceMapper {
    int countByExample(FbBusJoinSignRelevanceExample example);

    int deleteByExample(FbBusJoinSignRelevanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusJoinSignRelevance record);

    int insertSelective(FbBusJoinSignRelevance record);

    List<FbBusJoinSignRelevance> selectByExample(FbBusJoinSignRelevanceExample example);

    FbBusJoinSignRelevance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusJoinSignRelevance record, @Param("example") FbBusJoinSignRelevanceExample example);

    int updateByExample(@Param("record") FbBusJoinSignRelevance record, @Param("example") FbBusJoinSignRelevanceExample example);

    int updateByPrimaryKeySelective(FbBusJoinSignRelevance record);

    int updateByPrimaryKey(FbBusJoinSignRelevance record);
}
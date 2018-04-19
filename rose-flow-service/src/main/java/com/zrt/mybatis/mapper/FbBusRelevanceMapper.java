package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusRelevance;
import com.zrt.mybatis.domain.FbBusRelevanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusRelevanceMapper {
    int countByExample(FbBusRelevanceExample example);

    int deleteByExample(FbBusRelevanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusRelevance record);

    int insertSelective(FbBusRelevance record);

    List<FbBusRelevance> selectByExample(FbBusRelevanceExample example);

    FbBusRelevance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusRelevance record, @Param("example") FbBusRelevanceExample example);

    int updateByExample(@Param("record") FbBusRelevance record, @Param("example") FbBusRelevanceExample example);

    int updateByPrimaryKeySelective(FbBusRelevance record);

    int updateByPrimaryKey(FbBusRelevance record);
}
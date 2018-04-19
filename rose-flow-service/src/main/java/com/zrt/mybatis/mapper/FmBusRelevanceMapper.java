package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FmBusRelevance;
import com.zrt.mybatis.domain.FmBusRelevanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmBusRelevanceMapper {
    int countByExample(FmBusRelevanceExample example);

    int deleteByExample(FmBusRelevanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(FmBusRelevance record);

    int insertSelective(FmBusRelevance record);

    List<FmBusRelevance> selectByExample(FmBusRelevanceExample example);

    FmBusRelevance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FmBusRelevance record, @Param("example") FmBusRelevanceExample example);

    int updateByExample(@Param("record") FmBusRelevance record, @Param("example") FmBusRelevanceExample example);

    int updateByPrimaryKeySelective(FmBusRelevance record);

    int updateByPrimaryKey(FmBusRelevance record);
}
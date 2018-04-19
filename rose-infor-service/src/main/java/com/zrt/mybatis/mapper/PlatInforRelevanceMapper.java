package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.PlatInforRelevance;
import com.zrt.mybatis.domain.PlatInforRelevanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatInforRelevanceMapper {
    int countByExample(PlatInforRelevanceExample example);

    int deleteByExample(PlatInforRelevanceExample example);

    int deleteByPrimaryKey(String relInforId);

    int insert(PlatInforRelevance record);

    int insertSelective(PlatInforRelevance record);

    List<PlatInforRelevance> selectByExample(PlatInforRelevanceExample example);

    PlatInforRelevance selectByPrimaryKey(String relInforId);

    int updateByExampleSelective(@Param("record") PlatInforRelevance record, @Param("example") PlatInforRelevanceExample example);

    int updateByExample(@Param("record") PlatInforRelevance record, @Param("example") PlatInforRelevanceExample example);

    int updateByPrimaryKeySelective(PlatInforRelevance record);

    int updateByPrimaryKey(PlatInforRelevance record);
}
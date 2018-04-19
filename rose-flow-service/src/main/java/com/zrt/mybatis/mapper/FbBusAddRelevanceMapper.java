package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusAddRelevance;
import com.zrt.mybatis.domain.FbBusAddRelevanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusAddRelevanceMapper {
    int countByExample(FbBusAddRelevanceExample example);

    int deleteByExample(FbBusAddRelevanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusAddRelevance record);

    int insertSelective(FbBusAddRelevance record);

    List<FbBusAddRelevance> selectByExample(FbBusAddRelevanceExample example);

    FbBusAddRelevance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusAddRelevance record, @Param("example") FbBusAddRelevanceExample example);

    int updateByExample(@Param("record") FbBusAddRelevance record, @Param("example") FbBusAddRelevanceExample example);

    int updateByPrimaryKeySelective(FbBusAddRelevance record);

    int updateByPrimaryKey(FbBusAddRelevance record);
}
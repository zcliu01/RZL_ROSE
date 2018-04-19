package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusCare;
import com.zrt.mybatis.domain.FbBusCareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusCareMapper {
    int countByExample(FbBusCareExample example);

    int deleteByExample(FbBusCareExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusCare record);

    int insertSelective(FbBusCare record);

    List<FbBusCare> selectByExample(FbBusCareExample example);

    FbBusCare selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusCare record, @Param("example") FbBusCareExample example);

    int updateByExample(@Param("record") FbBusCare record, @Param("example") FbBusCareExample example);

    int updateByPrimaryKeySelective(FbBusCare record);

    int updateByPrimaryKey(FbBusCare record);
}
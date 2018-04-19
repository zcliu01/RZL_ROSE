package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusFm;
import com.zrt.mybatis.domain.FbBusFmExample;
import com.zrt.mybatis.domain.FbBusFmKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusFmMapper {
    int countByExample(FbBusFmExample example);

    int deleteByExample(FbBusFmExample example);

    int deleteByPrimaryKey(FbBusFmKey key);

    int insert(FbBusFm record);

    int insertSelective(FbBusFm record);

    List<FbBusFm> selectByExample(FbBusFmExample example);

    FbBusFm selectByPrimaryKey(FbBusFmKey key);

    int updateByExampleSelective(@Param("record") FbBusFm record, @Param("example") FbBusFmExample example);

    int updateByExample(@Param("record") FbBusFm record, @Param("example") FbBusFmExample example);

    int updateByPrimaryKeySelective(FbBusFm record);

    int updateByPrimaryKey(FbBusFm record);
}
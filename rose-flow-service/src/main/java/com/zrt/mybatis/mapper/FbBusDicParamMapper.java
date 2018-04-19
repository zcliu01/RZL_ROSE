package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusDicParam;
import com.zrt.mybatis.domain.FbBusDicParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusDicParamMapper {
    int countByExample(FbBusDicParamExample example);

    int deleteByExample(FbBusDicParamExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusDicParam record);

    int insertSelective(FbBusDicParam record);

    List<FbBusDicParam> selectByExample(FbBusDicParamExample example);

    FbBusDicParam selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusDicParam record, @Param("example") FbBusDicParamExample example);

    int updateByExample(@Param("record") FbBusDicParam record, @Param("example") FbBusDicParamExample example);

    int updateByPrimaryKeySelective(FbBusDicParam record);

    int updateByPrimaryKey(FbBusDicParam record);
}
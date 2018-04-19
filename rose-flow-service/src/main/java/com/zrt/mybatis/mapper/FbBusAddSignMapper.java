package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusAddSign;
import com.zrt.mybatis.domain.FbBusAddSignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusAddSignMapper {
    int countByExample(FbBusAddSignExample example);

    int deleteByExample(FbBusAddSignExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusAddSign record);

    int insertSelective(FbBusAddSign record);

    List<FbBusAddSign> selectByExample(FbBusAddSignExample example);

    FbBusAddSign selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusAddSign record, @Param("example") FbBusAddSignExample example);

    int updateByExample(@Param("record") FbBusAddSign record, @Param("example") FbBusAddSignExample example);

    int updateByPrimaryKeySelective(FbBusAddSign record);

    int updateByPrimaryKey(FbBusAddSign record);
}
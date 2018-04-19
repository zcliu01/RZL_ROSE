package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusType;
import com.zrt.mybatis.domain.FbBusTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusTypeMapper {
    int countByExample(FbBusTypeExample example);

    int deleteByExample(FbBusTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusType record);

    int insertSelective(FbBusType record);

    List<FbBusType> selectByExample(FbBusTypeExample example);

    FbBusType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusType record, @Param("example") FbBusTypeExample example);

    int updateByExample(@Param("record") FbBusType record, @Param("example") FbBusTypeExample example);

    int updateByPrimaryKeySelective(FbBusType record);

    int updateByPrimaryKey(FbBusType record);
}
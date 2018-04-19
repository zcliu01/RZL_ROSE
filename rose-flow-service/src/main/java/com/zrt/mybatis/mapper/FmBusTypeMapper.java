package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FmBusType;
import com.zrt.mybatis.domain.FmBusTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmBusTypeMapper {
    int countByExample(FmBusTypeExample example);

    int deleteByExample(FmBusTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(FmBusType record);

    int insertSelective(FmBusType record);

    List<FmBusType> selectByExample(FmBusTypeExample example);

    FmBusType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FmBusType record, @Param("example") FmBusTypeExample example);

    int updateByExample(@Param("record") FmBusType record, @Param("example") FmBusTypeExample example);

    int updateByPrimaryKeySelective(FmBusType record);

    int updateByPrimaryKey(FmBusType record);
}
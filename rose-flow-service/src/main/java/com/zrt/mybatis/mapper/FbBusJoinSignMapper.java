package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusJoinSign;
import com.zrt.mybatis.domain.FbBusJoinSignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusJoinSignMapper {
    int countByExample(FbBusJoinSignExample example);

    int deleteByExample(FbBusJoinSignExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusJoinSign record);

    int insertSelective(FbBusJoinSign record);

    List<FbBusJoinSign> selectByExample(FbBusJoinSignExample example);

    FbBusJoinSign selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusJoinSign record, @Param("example") FbBusJoinSignExample example);

    int updateByExample(@Param("record") FbBusJoinSign record, @Param("example") FbBusJoinSignExample example);

    int updateByPrimaryKeySelective(FbBusJoinSign record);

    int updateByPrimaryKey(FbBusJoinSign record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusJoinSignFile;
import com.zrt.mybatis.domain.FbBusJoinSignFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusJoinSignFileMapper {
    int countByExample(FbBusJoinSignFileExample example);

    int deleteByExample(FbBusJoinSignFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusJoinSignFile record);

    int insertSelective(FbBusJoinSignFile record);

    List<FbBusJoinSignFile> selectByExample(FbBusJoinSignFileExample example);

    FbBusJoinSignFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusJoinSignFile record, @Param("example") FbBusJoinSignFileExample example);

    int updateByExample(@Param("record") FbBusJoinSignFile record, @Param("example") FbBusJoinSignFileExample example);

    int updateByPrimaryKeySelective(FbBusJoinSignFile record);

    int updateByPrimaryKey(FbBusJoinSignFile record);
}
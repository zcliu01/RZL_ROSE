package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusData;
import com.zrt.mybatis.domain.FbBusDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusDataMapper {
    int countByExample(FbBusDataExample example);

    int deleteByExample(FbBusDataExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusData record);

    int insertSelective(FbBusData record);

    List<FbBusData> selectByExampleWithBLOBs(FbBusDataExample example);

    List<FbBusData> selectByExample(FbBusDataExample example);

    FbBusData selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusData record, @Param("example") FbBusDataExample example);

    int updateByExampleWithBLOBs(@Param("record") FbBusData record, @Param("example") FbBusDataExample example);

    int updateByExample(@Param("record") FbBusData record, @Param("example") FbBusDataExample example);

    int updateByPrimaryKeySelective(FbBusData record);

    int updateByPrimaryKeyWithBLOBs(FbBusData record);

    int updateByPrimaryKey(FbBusData record);
}
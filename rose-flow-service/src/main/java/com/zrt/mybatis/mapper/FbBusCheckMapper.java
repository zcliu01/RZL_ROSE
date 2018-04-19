package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusCheck;
import com.zrt.mybatis.domain.FbBusCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusCheckMapper {
    int countByExample(FbBusCheckExample example);

    int deleteByExample(FbBusCheckExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusCheck record);

    int insertSelective(FbBusCheck record);

    List<FbBusCheck> selectByExample(FbBusCheckExample example);

    FbBusCheck selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusCheck record, @Param("example") FbBusCheckExample example);

    int updateByExample(@Param("record") FbBusCheck record, @Param("example") FbBusCheckExample example);

    int updateByPrimaryKeySelective(FbBusCheck record);

    int updateByPrimaryKey(FbBusCheck record);
}
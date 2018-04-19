package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.domain.FbBusInstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusInstMapper {
    int countByExample(FbBusInstExample example);

    int deleteByExample(FbBusInstExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusInst record);

    int insertSelective(FbBusInst record);

    List<FbBusInst> selectByExample(FbBusInstExample example);

    FbBusInst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusInst record, @Param("example") FbBusInstExample example);

    int updateByExample(@Param("record") FbBusInst record, @Param("example") FbBusInstExample example);

    int updateByPrimaryKeySelective(FbBusInst record);

    int updateByPrimaryKey(FbBusInst record);
}
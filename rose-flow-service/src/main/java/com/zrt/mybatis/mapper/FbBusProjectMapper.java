package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusProject;
import com.zrt.mybatis.domain.FbBusProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusProjectMapper {
    int countByExample(FbBusProjectExample example);

    int deleteByExample(FbBusProjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusProject record);

    int insertSelective(FbBusProject record);

    List<FbBusProject> selectByExample(FbBusProjectExample example);

    FbBusProject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusProject record, @Param("example") FbBusProjectExample example);

    int updateByExample(@Param("record") FbBusProject record, @Param("example") FbBusProjectExample example);

    int updateByPrimaryKeySelective(FbBusProject record);

    int updateByPrimaryKey(FbBusProject record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusHandle;
import com.zrt.mybatis.domain.FbBusHandleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusHandleMapper {
    int countByExample(FbBusHandleExample example);

    int deleteByExample(FbBusHandleExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusHandle record);

    int insertSelective(FbBusHandle record);

    List<FbBusHandle> selectByExample(FbBusHandleExample example);

    FbBusHandle selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusHandle record, @Param("example") FbBusHandleExample example);

    int updateByExample(@Param("record") FbBusHandle record, @Param("example") FbBusHandleExample example);

    int updateByPrimaryKeySelective(FbBusHandle record);

    int updateByPrimaryKey(FbBusHandle record);
}
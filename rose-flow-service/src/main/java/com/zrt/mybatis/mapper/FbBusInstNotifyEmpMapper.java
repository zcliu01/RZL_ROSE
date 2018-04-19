package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusInstNotifyEmp;
import com.zrt.mybatis.domain.FbBusInstNotifyEmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusInstNotifyEmpMapper {
    int countByExample(FbBusInstNotifyEmpExample example);

    int deleteByExample(FbBusInstNotifyEmpExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusInstNotifyEmp record);

    int insertSelective(FbBusInstNotifyEmp record);

    List<FbBusInstNotifyEmp> selectByExample(FbBusInstNotifyEmpExample example);

    FbBusInstNotifyEmp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusInstNotifyEmp record, @Param("example") FbBusInstNotifyEmpExample example);

    int updateByExample(@Param("record") FbBusInstNotifyEmp record, @Param("example") FbBusInstNotifyEmpExample example);

    int updateByPrimaryKeySelective(FbBusInstNotifyEmp record);

    int updateByPrimaryKey(FbBusInstNotifyEmp record);
}
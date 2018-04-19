package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.VmBusPerson;
import com.zrt.mybatis.domain.VmBusPersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmBusPersonMapper {
    int countByExample(VmBusPersonExample example);

    int deleteByExample(VmBusPersonExample example);

    int deleteByPrimaryKey(String id);

    int insert(VmBusPerson record);

    int insertSelective(VmBusPerson record);

    List<VmBusPerson> selectByExample(VmBusPersonExample example);

    VmBusPerson selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VmBusPerson record, @Param("example") VmBusPersonExample example);

    int updateByExample(@Param("record") VmBusPerson record, @Param("example") VmBusPersonExample example);

    int updateByPrimaryKeySelective(VmBusPerson record);

    int updateByPrimaryKey(VmBusPerson record);
}
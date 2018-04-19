package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.VmBusPartin;
import com.zrt.mybatis.domain.VmBusPartinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmBusPartinMapper {
    int countByExample(VmBusPartinExample example);

    int deleteByExample(VmBusPartinExample example);

    int deleteByPrimaryKey(String id);

    int insert(VmBusPartin record);

    int insertSelective(VmBusPartin record);

    List<VmBusPartin> selectByExample(VmBusPartinExample example);

    VmBusPartin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VmBusPartin record, @Param("example") VmBusPartinExample example);

    int updateByExample(@Param("record") VmBusPartin record, @Param("example") VmBusPartinExample example);

    int updateByPrimaryKeySelective(VmBusPartin record);

    int updateByPrimaryKey(VmBusPartin record);
}
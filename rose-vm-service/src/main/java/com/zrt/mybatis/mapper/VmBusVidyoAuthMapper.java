package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.VmBusVidyoAuth;
import com.zrt.mybatis.domain.VmBusVidyoAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmBusVidyoAuthMapper {
    int countByExample(VmBusVidyoAuthExample example);

    int deleteByExample(VmBusVidyoAuthExample example);

    int deleteByPrimaryKey(String id);

    int insert(VmBusVidyoAuth record);

    int insertSelective(VmBusVidyoAuth record);

    List<VmBusVidyoAuth> selectByExample(VmBusVidyoAuthExample example);

    VmBusVidyoAuth selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VmBusVidyoAuth record, @Param("example") VmBusVidyoAuthExample example);

    int updateByExample(@Param("record") VmBusVidyoAuth record, @Param("example") VmBusVidyoAuthExample example);

    int updateByPrimaryKeySelective(VmBusVidyoAuth record);

    int updateByPrimaryKey(VmBusVidyoAuth record);
}
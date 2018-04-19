package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecRoleResource;
import com.zrt.mybatis.domain.SysSecRoleResourceExample;
import com.zrt.mybatis.domain.SysSecRoleResourceKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecRoleResourceMapper {
    int countByExample(SysSecRoleResourceExample example);

    int deleteByExample(SysSecRoleResourceExample example);

    int deleteByPrimaryKey(SysSecRoleResourceKey key);

    int insert(SysSecRoleResource record);

    int insertSelective(SysSecRoleResource record);

    List<SysSecRoleResource> selectByExample(SysSecRoleResourceExample example);

    SysSecRoleResource selectByPrimaryKey(SysSecRoleResourceKey key);

    int updateByExampleSelective(@Param("record") SysSecRoleResource record, @Param("example") SysSecRoleResourceExample example);

    int updateByExample(@Param("record") SysSecRoleResource record, @Param("example") SysSecRoleResourceExample example);

    int updateByPrimaryKeySelective(SysSecRoleResource record);

    int updateByPrimaryKey(SysSecRoleResource record);
}
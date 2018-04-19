package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecRoleMenu;
import com.zrt.mybatis.domain.SysSecRoleMenuExample;
import com.zrt.mybatis.domain.SysSecRoleMenuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecRoleMenuMapper {
    int countByExample(SysSecRoleMenuExample example);

    int deleteByExample(SysSecRoleMenuExample example);

    int deleteByPrimaryKey(SysSecRoleMenuKey key);

    int insert(SysSecRoleMenu record);

    int insertSelective(SysSecRoleMenu record);

    List<SysSecRoleMenu> selectByExample(SysSecRoleMenuExample example);

    SysSecRoleMenu selectByPrimaryKey(SysSecRoleMenuKey key);

    int updateByExampleSelective(@Param("record") SysSecRoleMenu record, @Param("example") SysSecRoleMenuExample example);

    int updateByExample(@Param("record") SysSecRoleMenu record, @Param("example") SysSecRoleMenuExample example);

    int updateByPrimaryKeySelective(SysSecRoleMenu record);

    int updateByPrimaryKey(SysSecRoleMenu record);
}
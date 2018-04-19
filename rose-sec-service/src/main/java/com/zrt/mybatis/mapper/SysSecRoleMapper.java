package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecRole;
import com.zrt.mybatis.domain.SysSecRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecRoleMapper {
    int countByExample(SysSecRoleExample example);

    int deleteByExample(SysSecRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(SysSecRole record);

    int insertSelective(SysSecRole record);

    List<SysSecRole> selectByExample(SysSecRoleExample example);

    SysSecRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") SysSecRole record, @Param("example") SysSecRoleExample example);

    int updateByExample(@Param("record") SysSecRole record, @Param("example") SysSecRoleExample example);

    int updateByPrimaryKeySelective(SysSecRole record);

    int updateByPrimaryKey(SysSecRole record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecUserRole;
import com.zrt.mybatis.domain.SysSecUserRoleExample;
import com.zrt.mybatis.domain.SysSecUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecUserRoleMapper {
    int countByExample(SysSecUserRoleExample example);

    int deleteByExample(SysSecUserRoleExample example);

    int deleteByPrimaryKey(SysSecUserRoleKey key);

    int insert(SysSecUserRole record);

    int insertSelective(SysSecUserRole record);

    List<SysSecUserRole> selectByExample(SysSecUserRoleExample example);

    SysSecUserRole selectByPrimaryKey(SysSecUserRoleKey key);

    int updateByExampleSelective(@Param("record") SysSecUserRole record, @Param("example") SysSecUserRoleExample example);

    int updateByExample(@Param("record") SysSecUserRole record, @Param("example") SysSecUserRoleExample example);

    int updateByPrimaryKeySelective(SysSecUserRole record);

    int updateByPrimaryKey(SysSecUserRole record);
}
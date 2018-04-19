package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecOrg;
import com.zrt.mybatis.domain.SysSecOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecOrgMapper {
    int countByExample(SysSecOrgExample example);

    int deleteByExample(SysSecOrgExample example);

    int deleteByPrimaryKey(String orgId);

    int insert(SysSecOrg record);

    int insertSelective(SysSecOrg record);

    List<SysSecOrg> selectByExample(SysSecOrgExample example);

    SysSecOrg selectByPrimaryKey(String orgId);

    int updateByExampleSelective(@Param("record") SysSecOrg record, @Param("example") SysSecOrgExample example);

    int updateByExample(@Param("record") SysSecOrg record, @Param("example") SysSecOrgExample example);

    int updateByPrimaryKeySelective(SysSecOrg record);

    int updateByPrimaryKey(SysSecOrg record);
}
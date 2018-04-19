package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecAuditLog;
import com.zrt.mybatis.domain.SysSecAuditLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecAuditLogMapper {
    int countByExample(SysSecAuditLogExample example);

    int deleteByExample(SysSecAuditLogExample example);

    int deleteByPrimaryKey(String auditLogId);

    int insert(SysSecAuditLog record);

    int insertSelective(SysSecAuditLog record);

    List<SysSecAuditLog> selectByExample(SysSecAuditLogExample example);

    SysSecAuditLog selectByPrimaryKey(String auditLogId);

    int updateByExampleSelective(@Param("record") SysSecAuditLog record, @Param("example") SysSecAuditLogExample example);

    int updateByExample(@Param("record") SysSecAuditLog record, @Param("example") SysSecAuditLogExample example);

    int updateByPrimaryKeySelective(SysSecAuditLog record);

    int updateByPrimaryKey(SysSecAuditLog record);
}
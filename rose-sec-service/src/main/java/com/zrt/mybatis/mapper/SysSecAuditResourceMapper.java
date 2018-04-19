package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecAuditResource;
import com.zrt.mybatis.domain.SysSecAuditResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecAuditResourceMapper {
    int countByExample(SysSecAuditResourceExample example);

    int deleteByExample(SysSecAuditResourceExample example);

    int deleteByPrimaryKey(String resourceId);

    int insert(SysSecAuditResource record);

    int insertSelective(SysSecAuditResource record);

    List<SysSecAuditResource> selectByExample(SysSecAuditResourceExample example);

    int updateByExampleSelective(@Param("record") SysSecAuditResource record, @Param("example") SysSecAuditResourceExample example);

    int updateByExample(@Param("record") SysSecAuditResource record, @Param("example") SysSecAuditResourceExample example);
}
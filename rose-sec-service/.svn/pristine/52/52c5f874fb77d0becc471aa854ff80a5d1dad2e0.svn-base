package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecResource;
import com.zrt.mybatis.domain.SysSecResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecResourceMapper {
    int countByExample(SysSecResourceExample example);

    int deleteByExample(SysSecResourceExample example);

    int deleteByPrimaryKey(String resourceId);

    int insert(SysSecResource record);

    int insertSelective(SysSecResource record);

    List<SysSecResource> selectByExample(SysSecResourceExample example);

    SysSecResource selectByPrimaryKey(String resourceId);

    int updateByExampleSelective(@Param("record") SysSecResource record, @Param("example") SysSecResourceExample example);

    int updateByExample(@Param("record") SysSecResource record, @Param("example") SysSecResourceExample example);

    int updateByPrimaryKeySelective(SysSecResource record);

    int updateByPrimaryKey(SysSecResource record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysInfoNotify;
import com.zrt.mybatis.domain.SysInfoNotifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysInfoNotifyMapper {
    int countByExample(SysInfoNotifyExample example);

    int deleteByExample(SysInfoNotifyExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysInfoNotify record);

    int insertSelective(SysInfoNotify record);

    List<SysInfoNotify> selectByExample(SysInfoNotifyExample example);

    SysInfoNotify selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysInfoNotify record, @Param("example") SysInfoNotifyExample example);

    int updateByExample(@Param("record") SysInfoNotify record, @Param("example") SysInfoNotifyExample example);

    int updateByPrimaryKeySelective(SysInfoNotify record);

    int updateByPrimaryKey(SysInfoNotify record);
}
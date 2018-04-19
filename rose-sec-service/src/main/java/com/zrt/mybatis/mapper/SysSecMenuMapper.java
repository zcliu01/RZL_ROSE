package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecMenu;
import com.zrt.mybatis.domain.SysSecMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecMenuMapper {
    int countByExample(SysSecMenuExample example);

    int deleteByExample(SysSecMenuExample example);

    int deleteByPrimaryKey(String menuCode);

    int insert(SysSecMenu record);

    int insertSelective(SysSecMenu record);

    List<SysSecMenu> selectByExample(SysSecMenuExample example);

    SysSecMenu selectByPrimaryKey(String menuCode);

    int updateByExampleSelective(@Param("record") SysSecMenu record, @Param("example") SysSecMenuExample example);

    int updateByExample(@Param("record") SysSecMenu record, @Param("example") SysSecMenuExample example);

    int updateByPrimaryKeySelective(SysSecMenu record);

    int updateByPrimaryKey(SysSecMenu record);
}
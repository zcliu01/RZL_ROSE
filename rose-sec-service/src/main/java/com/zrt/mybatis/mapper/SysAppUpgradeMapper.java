package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysAppUpgrade;
import com.zrt.mybatis.domain.SysAppUpgradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAppUpgradeMapper {
    int countByExample(SysAppUpgradeExample example);

    int deleteByExample(SysAppUpgradeExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysAppUpgrade record);

    int insertSelective(SysAppUpgrade record);

    List<SysAppUpgrade> selectByExample(SysAppUpgradeExample example);

    SysAppUpgrade selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysAppUpgrade record, @Param("example") SysAppUpgradeExample example);

    int updateByExample(@Param("record") SysAppUpgrade record, @Param("example") SysAppUpgradeExample example);

    int updateByPrimaryKeySelective(SysAppUpgrade record);

    int updateByPrimaryKey(SysAppUpgrade record);
}
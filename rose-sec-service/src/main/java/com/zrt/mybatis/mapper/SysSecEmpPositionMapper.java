package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecEmpPosition;
import com.zrt.mybatis.domain.SysSecEmpPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecEmpPositionMapper {
    int countByExample(SysSecEmpPositionExample example);

    int deleteByExample(SysSecEmpPositionExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysSecEmpPosition record);

    int insertSelective(SysSecEmpPosition record);

    List<SysSecEmpPosition> selectByExample(SysSecEmpPositionExample example);

    SysSecEmpPosition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysSecEmpPosition record, @Param("example") SysSecEmpPositionExample example);

    int updateByExample(@Param("record") SysSecEmpPosition record, @Param("example") SysSecEmpPositionExample example);

    int updateByPrimaryKeySelective(SysSecEmpPosition record);

    int updateByPrimaryKey(SysSecEmpPosition record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecEmp;
import com.zrt.mybatis.domain.SysSecEmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecEmpMapper {
    int countByExample(SysSecEmpExample example);

    int deleteByExample(SysSecEmpExample example);

    int deleteByPrimaryKey(String empId);

    int insert(SysSecEmp record);

    int insertSelective(SysSecEmp record);

    List<SysSecEmp> selectByExample(SysSecEmpExample example);

    SysSecEmp selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") SysSecEmp record, @Param("example") SysSecEmpExample example);

    int updateByExample(@Param("record") SysSecEmp record, @Param("example") SysSecEmpExample example);

    int updateByPrimaryKeySelective(SysSecEmp record);

    int updateByPrimaryKey(SysSecEmp record);
}
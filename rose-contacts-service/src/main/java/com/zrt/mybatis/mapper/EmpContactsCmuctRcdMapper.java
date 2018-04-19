package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.EmpContactsCmuctRcd;
import com.zrt.mybatis.domain.EmpContactsCmuctRcdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpContactsCmuctRcdMapper {
    int countByExample(EmpContactsCmuctRcdExample example);

    int deleteByExample(EmpContactsCmuctRcdExample example);

    int deleteByPrimaryKey(String cmuctRcdId);

    int insert(EmpContactsCmuctRcd record);

    int insertSelective(EmpContactsCmuctRcd record);

    List<EmpContactsCmuctRcd> selectByExample(EmpContactsCmuctRcdExample example);

    EmpContactsCmuctRcd selectByPrimaryKey(String cmuctRcdId);

    int updateByExampleSelective(@Param("record") EmpContactsCmuctRcd record, @Param("example") EmpContactsCmuctRcdExample example);

    int updateByExample(@Param("record") EmpContactsCmuctRcd record, @Param("example") EmpContactsCmuctRcdExample example);

    int updateByPrimaryKeySelective(EmpContactsCmuctRcd record);

    int updateByPrimaryKey(EmpContactsCmuctRcd record);
}
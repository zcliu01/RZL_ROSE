package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysBizSerial;
import com.zrt.mybatis.domain.SysBizSerialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBizSerialMapper {
    int countByExample(SysBizSerialExample example);

    int deleteByExample(SysBizSerialExample example);

    int deleteByPrimaryKey(String bizKey);

    int insert(SysBizSerial record);

    int insertSelective(SysBizSerial record);

    List<SysBizSerial> selectByExample(SysBizSerialExample example);

    SysBizSerial selectByPrimaryKey(String bizKey);

    int updateByExampleSelective(@Param("record") SysBizSerial record, @Param("example") SysBizSerialExample example);

    int updateByExample(@Param("record") SysBizSerial record, @Param("example") SysBizSerialExample example);

    int updateByPrimaryKeySelective(SysBizSerial record);

    int updateByPrimaryKey(SysBizSerial record);
}
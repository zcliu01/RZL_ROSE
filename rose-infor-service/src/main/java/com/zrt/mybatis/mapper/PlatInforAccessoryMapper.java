package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.PlatInforAccessory;
import com.zrt.mybatis.domain.PlatInforAccessoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatInforAccessoryMapper {
    int countByExample(PlatInforAccessoryExample example);

    int deleteByExample(PlatInforAccessoryExample example);

    int deleteByPrimaryKey(String accId);

    int insert(PlatInforAccessory record);

    int insertSelective(PlatInforAccessory record);

    List<PlatInforAccessory> selectByExample(PlatInforAccessoryExample example);

    PlatInforAccessory selectByPrimaryKey(String accId);

    int updateByExampleSelective(@Param("record") PlatInforAccessory record, @Param("example") PlatInforAccessoryExample example);

    int updateByExample(@Param("record") PlatInforAccessory record, @Param("example") PlatInforAccessoryExample example);

    int updateByPrimaryKeySelective(PlatInforAccessory record);

    int updateByPrimaryKey(PlatInforAccessory record);
}
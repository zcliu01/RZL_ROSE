package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.PlatInforConcern;
import com.zrt.mybatis.domain.PlatInforConcernExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatInforConcernMapper {
    int countByExample(PlatInforConcernExample example);

    int deleteByExample(PlatInforConcernExample example);

    int deleteByPrimaryKey(String concernId);

    int insert(PlatInforConcern record);

    int insertSelective(PlatInforConcern record);

    List<PlatInforConcern> selectByExample(PlatInforConcernExample example);

    PlatInforConcern selectByPrimaryKey(String concernId);

    int updateByExampleSelective(@Param("record") PlatInforConcern record, @Param("example") PlatInforConcernExample example);

    int updateByExample(@Param("record") PlatInforConcern record, @Param("example") PlatInforConcernExample example);

    int updateByPrimaryKeySelective(PlatInforConcern record);

    int updateByPrimaryKey(PlatInforConcern record);
}
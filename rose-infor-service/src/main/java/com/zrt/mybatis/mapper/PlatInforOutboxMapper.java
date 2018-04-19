package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.PlatInforOutbox;
import com.zrt.mybatis.domain.PlatInforOutboxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatInforOutboxMapper {
    int countByExample(PlatInforOutboxExample example);

    int deleteByExample(PlatInforOutboxExample example);

    int deleteByPrimaryKey(Integer outId);

    int insert(PlatInforOutbox record);

    int insertSelective(PlatInforOutbox record);

    List<PlatInforOutbox> selectByExample(PlatInforOutboxExample example);

    PlatInforOutbox selectByPrimaryKey(Integer outId);

    int updateByExampleSelective(@Param("record") PlatInforOutbox record, @Param("example") PlatInforOutboxExample example);

    int updateByExample(@Param("record") PlatInforOutbox record, @Param("example") PlatInforOutboxExample example);

    int updateByPrimaryKeySelective(PlatInforOutbox record);

    int updateByPrimaryKey(PlatInforOutbox record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysPlatPosition;
import com.zrt.mybatis.domain.SysPlatPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPlatPositionMapper {
    int countByExample(SysPlatPositionExample example);

    int deleteByExample(SysPlatPositionExample example);

    int deleteByPrimaryKey(String pSPId);

    int insert(SysPlatPosition record);

    int insertSelective(SysPlatPosition record);

    List<SysPlatPosition> selectByExample(SysPlatPositionExample example);

    SysPlatPosition selectByPrimaryKey(String pSPId);

    int updateByExampleSelective(@Param("record") SysPlatPosition record, @Param("example") SysPlatPositionExample example);

    int updateByExample(@Param("record") SysPlatPosition record, @Param("example") SysPlatPositionExample example);

    int updateByPrimaryKeySelective(SysPlatPosition record);

    int updateByPrimaryKey(SysPlatPosition record);
}
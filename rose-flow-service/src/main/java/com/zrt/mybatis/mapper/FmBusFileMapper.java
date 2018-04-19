package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FmBusFile;
import com.zrt.mybatis.domain.FmBusFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmBusFileMapper {
    int countByExample(FmBusFileExample example);

    int deleteByExample(FmBusFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(FmBusFile record);

    int insertSelective(FmBusFile record);

    List<FmBusFile> selectByExample(FmBusFileExample example);

    FmBusFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FmBusFile record, @Param("example") FmBusFileExample example);

    int updateByExample(@Param("record") FmBusFile record, @Param("example") FmBusFileExample example);

    int updateByPrimaryKeySelective(FmBusFile record);

    int updateByPrimaryKey(FmBusFile record);
}
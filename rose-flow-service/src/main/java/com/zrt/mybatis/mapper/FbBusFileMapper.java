package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusFile;
import com.zrt.mybatis.domain.FbBusFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusFileMapper {
    int countByExample(FbBusFileExample example);

    int deleteByExample(FbBusFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusFile record);

    int insertSelective(FbBusFile record);

    List<FbBusFile> selectByExample(FbBusFileExample example);

    FbBusFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusFile record, @Param("example") FbBusFileExample example);

    int updateByExample(@Param("record") FbBusFile record, @Param("example") FbBusFileExample example);

    int updateByPrimaryKeySelective(FbBusFile record);

    int updateByPrimaryKey(FbBusFile record);
}
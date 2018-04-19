package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusAddFile;
import com.zrt.mybatis.domain.FbBusAddFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusAddFileMapper {
    int countByExample(FbBusAddFileExample example);

    int deleteByExample(FbBusAddFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusAddFile record);

    int insertSelective(FbBusAddFile record);

    List<FbBusAddFile> selectByExample(FbBusAddFileExample example);

    FbBusAddFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusAddFile record, @Param("example") FbBusAddFileExample example);

    int updateByExample(@Param("record") FbBusAddFile record, @Param("example") FbBusAddFileExample example);

    int updateByPrimaryKeySelective(FbBusAddFile record);

    int updateByPrimaryKey(FbBusAddFile record);
}
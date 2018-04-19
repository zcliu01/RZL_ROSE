package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FmBusDic;
import com.zrt.mybatis.domain.FmBusDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmBusDicMapper {
    int countByExample(FmBusDicExample example);

    int deleteByExample(FmBusDicExample example);

    int deleteByPrimaryKey(String colCode);

    int insert(FmBusDic record);

    int insertSelective(FmBusDic record);

    List<FmBusDic> selectByExampleWithBLOBs(FmBusDicExample example);

    List<FmBusDic> selectByExample(FmBusDicExample example);

    FmBusDic selectByPrimaryKey(String colCode);

    int updateByExampleSelective(@Param("record") FmBusDic record, @Param("example") FmBusDicExample example);

    int updateByExampleWithBLOBs(@Param("record") FmBusDic record, @Param("example") FmBusDicExample example);

    int updateByExample(@Param("record") FmBusDic record, @Param("example") FmBusDicExample example);

    int updateByPrimaryKeySelective(FmBusDic record);

    int updateByPrimaryKeyWithBLOBs(FmBusDic record);

    int updateByPrimaryKey(FmBusDic record);
}
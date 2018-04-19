package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.PlatInforDic;
import com.zrt.mybatis.domain.PlatInforDicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatInforDicMapper {
    int countByExample(PlatInforDicExample example);

    int deleteByExample(PlatInforDicExample example);

    int deleteByPrimaryKey(String dicId);

    int insert(PlatInforDic record);

    int insertSelective(PlatInforDic record);

    List<PlatInforDic> selectByExample(PlatInforDicExample example);

    PlatInforDic selectByPrimaryKey(String dicId);

    int updateByExampleSelective(@Param("record") PlatInforDic record, @Param("example") PlatInforDicExample example);

    int updateByExample(@Param("record") PlatInforDic record, @Param("example") PlatInforDicExample example);

    int updateByPrimaryKeySelective(PlatInforDic record);

    int updateByPrimaryKey(PlatInforDic record);
}
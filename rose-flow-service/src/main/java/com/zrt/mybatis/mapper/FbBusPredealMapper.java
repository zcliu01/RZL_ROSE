package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusPredeal;
import com.zrt.mybatis.domain.FbBusPredealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusPredealMapper {
    int countByExample(FbBusPredealExample example);

    int deleteByExample(FbBusPredealExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusPredeal record);

    int insertSelective(FbBusPredeal record);

    List<FbBusPredeal> selectByExample(FbBusPredealExample example);

    FbBusPredeal selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusPredeal record, @Param("example") FbBusPredealExample example);

    int updateByExample(@Param("record") FbBusPredeal record, @Param("example") FbBusPredealExample example);

    int updateByPrimaryKeySelective(FbBusPredeal record);

    int updateByPrimaryKey(FbBusPredeal record);
}
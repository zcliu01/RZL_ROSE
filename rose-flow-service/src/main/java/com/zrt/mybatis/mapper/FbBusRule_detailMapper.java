package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusRule_detail;
import com.zrt.mybatis.domain.FbBusRule_detailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusRule_detailMapper {
    int countByExample(FbBusRule_detailExample example);

    int deleteByExample(FbBusRule_detailExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusRule_detail record);

    int insertSelective(FbBusRule_detail record);

    List<FbBusRule_detail> selectByExample(FbBusRule_detailExample example);

    FbBusRule_detail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusRule_detail record, @Param("example") FbBusRule_detailExample example);

    int updateByExample(@Param("record") FbBusRule_detail record, @Param("example") FbBusRule_detailExample example);

    int updateByPrimaryKeySelective(FbBusRule_detail record);

    int updateByPrimaryKey(FbBusRule_detail record);
}
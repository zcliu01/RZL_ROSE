package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FmBusTemplate;
import com.zrt.mybatis.domain.FmBusTemplateExample;
import com.zrt.mybatis.domain.FmBusTemplateWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FmBusTemplateMapper {
    int countByExample(FmBusTemplateExample example);

    int deleteByExample(FmBusTemplateExample example);

    int deleteByPrimaryKey(String id);

    int insert(FmBusTemplateWithBLOBs record);

    int insertSelective(FmBusTemplateWithBLOBs record);

    List<FmBusTemplateWithBLOBs> selectByExampleWithBLOBs(FmBusTemplateExample example);

    List<FmBusTemplate> selectByExample(FmBusTemplateExample example);

    FmBusTemplateWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FmBusTemplateWithBLOBs record, @Param("example") FmBusTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") FmBusTemplateWithBLOBs record, @Param("example") FmBusTemplateExample example);

    int updateByExample(@Param("record") FmBusTemplate record, @Param("example") FmBusTemplateExample example);

    int updateByPrimaryKeySelective(FmBusTemplateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FmBusTemplateWithBLOBs record);

    int updateByPrimaryKey(FmBusTemplate record);
}
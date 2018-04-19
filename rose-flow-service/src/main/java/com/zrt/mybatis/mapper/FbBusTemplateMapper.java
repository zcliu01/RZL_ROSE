package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusTemplate;
import com.zrt.mybatis.domain.FbBusTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusTemplateMapper {
    int countByExample(FbBusTemplateExample example);

    int deleteByExample(FbBusTemplateExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusTemplate record);

    int insertSelective(FbBusTemplate record);

    List<FbBusTemplate> selectByExample(FbBusTemplateExample example);

    FbBusTemplate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusTemplate record, @Param("example") FbBusTemplateExample example);

    int updateByExample(@Param("record") FbBusTemplate record, @Param("example") FbBusTemplateExample example);

    int updateByPrimaryKeySelective(FbBusTemplate record);

    int updateByPrimaryKey(FbBusTemplate record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusTemplateNotify;
import com.zrt.mybatis.domain.FbBusTemplateNotifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusTemplateNotifyMapper {
    int countByExample(FbBusTemplateNotifyExample example);

    int deleteByExample(FbBusTemplateNotifyExample example);

    int deleteByPrimaryKey(String id);

    int insert(FbBusTemplateNotify record);

    int insertSelective(FbBusTemplateNotify record);

    List<FbBusTemplateNotify> selectByExample(FbBusTemplateNotifyExample example);

    FbBusTemplateNotify selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FbBusTemplateNotify record, @Param("example") FbBusTemplateNotifyExample example);

    int updateByExample(@Param("record") FbBusTemplateNotify record, @Param("example") FbBusTemplateNotifyExample example);

    int updateByPrimaryKeySelective(FbBusTemplateNotify record);

    int updateByPrimaryKey(FbBusTemplateNotify record);
}
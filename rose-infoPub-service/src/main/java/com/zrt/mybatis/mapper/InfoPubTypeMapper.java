package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.InfoPubType;
import com.zrt.mybatis.domain.InfoPubTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoPubTypeMapper {
    int countByExample(InfoPubTypeExample example);

    int deleteByExample(InfoPubTypeExample example);

    int deleteByPrimaryKey(String infoTypeCode);

    int insert(InfoPubType record);

    int insertSelective(InfoPubType record);

    List<InfoPubType> selectByExample(InfoPubTypeExample example);

    InfoPubType selectByPrimaryKey(String infoTypeCode);

    int updateByExampleSelective(@Param("record") InfoPubType record, @Param("example") InfoPubTypeExample example);

    int updateByExample(@Param("record") InfoPubType record, @Param("example") InfoPubTypeExample example);

    int updateByPrimaryKeySelective(InfoPubType record);

    int updateByPrimaryKey(InfoPubType record);
}
package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.InfoPubAttach;
import com.zrt.mybatis.domain.InfoPubAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoPubAttachMapper {
    int countByExample(InfoPubAttachExample example);

    int deleteByExample(InfoPubAttachExample example);

    int deleteByPrimaryKey(String infoAttackId);

    int insert(InfoPubAttach record);

    int insertSelective(InfoPubAttach record);

    List<InfoPubAttach> selectByExample(InfoPubAttachExample example);

    InfoPubAttach selectByPrimaryKey(String infoAttackId);

    int updateByExampleSelective(@Param("record") InfoPubAttach record, @Param("example") InfoPubAttachExample example);

    int updateByExample(@Param("record") InfoPubAttach record, @Param("example") InfoPubAttachExample example);

    int updateByPrimaryKeySelective(InfoPubAttach record);

    int updateByPrimaryKey(InfoPubAttach record);
}
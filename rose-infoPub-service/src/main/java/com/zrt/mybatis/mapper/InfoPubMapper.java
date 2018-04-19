package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.InfoPub;
import com.zrt.mybatis.domain.InfoPubExample;
import com.zrt.mybatis.domain.InfoPubWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoPubMapper {
    int countByExample(InfoPubExample example);

    int deleteByExample(InfoPubExample example);

    int deleteByPrimaryKey(String infoId);

    int insert(InfoPubWithBLOBs record);

    int insertSelective(InfoPubWithBLOBs record);

    List<InfoPubWithBLOBs> selectByExampleWithBLOBs(InfoPubExample example);

    List<InfoPub> selectByExample(InfoPubExample example);

    InfoPubWithBLOBs selectByPrimaryKey(String infoId);

    int updateByExampleSelective(@Param("record") InfoPubWithBLOBs record, @Param("example") InfoPubExample example);

    int updateByExampleWithBLOBs(@Param("record") InfoPubWithBLOBs record, @Param("example") InfoPubExample example);

    int updateByExample(@Param("record") InfoPub record, @Param("example") InfoPubExample example);

    int updateByPrimaryKeySelective(InfoPubWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(InfoPubWithBLOBs record);

    int updateByPrimaryKey(InfoPub record);
}
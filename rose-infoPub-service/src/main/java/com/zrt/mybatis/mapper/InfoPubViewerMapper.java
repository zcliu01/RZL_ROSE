package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.InfoPubViewer;
import com.zrt.mybatis.domain.InfoPubViewerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoPubViewerMapper {
    int countByExample(InfoPubViewerExample example);

    int deleteByExample(InfoPubViewerExample example);

    int deleteByPrimaryKey(Integer infoViewId);

    int insert(InfoPubViewer record);

    int insertSelective(InfoPubViewer record);

    List<InfoPubViewer> selectByExample(InfoPubViewerExample example);

    InfoPubViewer selectByPrimaryKey(Integer infoViewId);

    int updateByExampleSelective(@Param("record") InfoPubViewer record, @Param("example") InfoPubViewerExample example);

    int updateByExample(@Param("record") InfoPubViewer record, @Param("example") InfoPubViewerExample example);

    int updateByPrimaryKeySelective(InfoPubViewer record);

    int updateByPrimaryKey(InfoPubViewer record);
}
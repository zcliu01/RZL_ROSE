package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.PlatInforDetail;
import com.zrt.mybatis.domain.PlatInforDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatInforDetailMapper {
    int countByExample(PlatInforDetailExample example);

    int deleteByExample(PlatInforDetailExample example);

    int deleteByPrimaryKey(Integer detailId);

    int insert(PlatInforDetail record);

    int insertSelective(PlatInforDetail record);

    List<PlatInforDetail> selectByExample(PlatInforDetailExample example);

    PlatInforDetail selectByPrimaryKey(Integer detailId);

    int updateByExampleSelective(@Param("record") PlatInforDetail record, @Param("example") PlatInforDetailExample example);

    int updateByExample(@Param("record") PlatInforDetail record, @Param("example") PlatInforDetailExample example);

    int updateByPrimaryKeySelective(PlatInforDetail record);

    int updateByPrimaryKey(PlatInforDetail record);
}
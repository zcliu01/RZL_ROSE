package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.TprojectInfo;
import com.zrt.mybatis.domain.TprojectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TprojectInfoMapper {
    int countByExample(TprojectInfoExample example);

    int deleteByExample(TprojectInfoExample example);

    int insert(TprojectInfo record);

    int insertSelective(TprojectInfo record);

    List<TprojectInfo> selectByExample(TprojectInfoExample example);

    int updateByExampleSelective(@Param("record") TprojectInfo record, @Param("example") TprojectInfoExample example);

    int updateByExample(@Param("record") TprojectInfo record, @Param("example") TprojectInfoExample example);
}
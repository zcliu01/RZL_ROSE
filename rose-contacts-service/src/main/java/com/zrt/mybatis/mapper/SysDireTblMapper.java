package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysDireTbl;
import com.zrt.mybatis.domain.SysDireTblExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDireTblMapper {
    int countByExample(SysDireTblExample example);

    int deleteByExample(SysDireTblExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysDireTbl record);

    int insertSelective(SysDireTbl record);

    List<SysDireTbl> selectByExample(SysDireTblExample example);

    SysDireTbl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDireTbl record, @Param("example") SysDireTblExample example);

    int updateByExample(@Param("record") SysDireTbl record, @Param("example") SysDireTblExample example);

    int updateByPrimaryKeySelective(SysDireTbl record);

    int updateByPrimaryKey(SysDireTbl record);
}
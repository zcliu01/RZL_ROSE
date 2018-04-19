package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.DocHander;
import com.zrt.mybatis.domain.DocHanderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocHanderMapper {
    int countByExample(DocHanderExample example);

    int deleteByExample(DocHanderExample example);

    int deleteByPrimaryKey(Integer docHanderId);

    int insert(DocHander record);

    int insertSelective(DocHander record);

    List<DocHander> selectByExample(DocHanderExample example);

    DocHander selectByPrimaryKey(Integer docHanderId);

    int updateByExampleSelective(@Param("record") DocHander record, @Param("example") DocHanderExample example);

    int updateByExample(@Param("record") DocHander record, @Param("example") DocHanderExample example);

    int updateByPrimaryKeySelective(DocHander record);

    int updateByPrimaryKey(DocHander record);
}
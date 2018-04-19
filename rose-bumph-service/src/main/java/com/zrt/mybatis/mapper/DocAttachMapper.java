package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.DocAttach;
import com.zrt.mybatis.domain.DocAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocAttachMapper {
    int countByExample(DocAttachExample example);

    int deleteByExample(DocAttachExample example);

    int deleteByPrimaryKey(String docAttackId);

    int insert(DocAttach record);

    int insertSelective(DocAttach record);

    List<DocAttach> selectByExample(DocAttachExample example);

    DocAttach selectByPrimaryKey(String docAttackId);

    int updateByExampleSelective(@Param("record") DocAttach record, @Param("example") DocAttachExample example);

    int updateByExample(@Param("record") DocAttach record, @Param("example") DocAttachExample example);

    int updateByPrimaryKeySelective(DocAttach record);

    int updateByPrimaryKey(DocAttach record);
}
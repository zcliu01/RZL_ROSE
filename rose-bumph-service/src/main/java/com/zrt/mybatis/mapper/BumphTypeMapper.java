package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.BumphType;
import com.zrt.mybatis.domain.BumphTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BumphTypeMapper {
    int countByExample(BumphTypeExample example);

    int deleteByExample(BumphTypeExample example);

    int deleteByPrimaryKey(String bumphTypeCode);

    int insert(BumphType record);

    int insertSelective(BumphType record);

    List<BumphType> selectByExample(BumphTypeExample example);

    BumphType selectByPrimaryKey(String bumphTypeCode);

    int updateByExampleSelective(@Param("record") BumphType record, @Param("example") BumphTypeExample example);

    int updateByExample(@Param("record") BumphType record, @Param("example") BumphTypeExample example);

    int updateByPrimaryKeySelective(BumphType record);

    int updateByPrimaryKey(BumphType record);
}
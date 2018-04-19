package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.EmpContactsFriend;
import com.zrt.mybatis.domain.EmpContactsFriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpContactsFriendMapper {
    int countByExample(EmpContactsFriendExample example);

    int deleteByExample(EmpContactsFriendExample example);

    int deleteByPrimaryKey(String friendId);

    int insert(EmpContactsFriend record);

    int insertSelective(EmpContactsFriend record);

    List<EmpContactsFriend> selectByExample(EmpContactsFriendExample example);

    EmpContactsFriend selectByPrimaryKey(String friendId);

    int updateByExampleSelective(@Param("record") EmpContactsFriend record, @Param("example") EmpContactsFriendExample example);

    int updateByExample(@Param("record") EmpContactsFriend record, @Param("example") EmpContactsFriendExample example);

    int updateByPrimaryKeySelective(EmpContactsFriend record);

    int updateByPrimaryKey(EmpContactsFriend record);
}
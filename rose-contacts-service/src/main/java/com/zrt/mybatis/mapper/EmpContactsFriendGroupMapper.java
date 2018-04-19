package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.EmpContactsFriendGroup;
import com.zrt.mybatis.domain.EmpContactsFriendGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpContactsFriendGroupMapper {
    int countByExample(EmpContactsFriendGroupExample example);

    int deleteByExample(EmpContactsFriendGroupExample example);

    int deleteByPrimaryKey(String friendGroupId);

    int insert(EmpContactsFriendGroup record);

    int insertSelective(EmpContactsFriendGroup record);

    List<EmpContactsFriendGroup> selectByExampleWithBLOBs(EmpContactsFriendGroupExample example);

    List<EmpContactsFriendGroup> selectByExample(EmpContactsFriendGroupExample example);

    EmpContactsFriendGroup selectByPrimaryKey(String friendGroupId);

    int updateByExampleSelective(@Param("record") EmpContactsFriendGroup record, @Param("example") EmpContactsFriendGroupExample example);

    int updateByExampleWithBLOBs(@Param("record") EmpContactsFriendGroup record, @Param("example") EmpContactsFriendGroupExample example);

    int updateByExample(@Param("record") EmpContactsFriendGroup record, @Param("example") EmpContactsFriendGroupExample example);

    int updateByPrimaryKeySelective(EmpContactsFriendGroup record);

    int updateByPrimaryKeyWithBLOBs(EmpContactsFriendGroup record);

    int updateByPrimaryKey(EmpContactsFriendGroup record);
}
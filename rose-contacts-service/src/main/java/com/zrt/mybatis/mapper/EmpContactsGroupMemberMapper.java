package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.EmpContactsGroupMember;
import com.zrt.mybatis.domain.EmpContactsGroupMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpContactsGroupMemberMapper {
    int countByExample(EmpContactsGroupMemberExample example);

    int deleteByExample(EmpContactsGroupMemberExample example);

    int deleteByPrimaryKey(Integer groupMemberId);

    int insert(EmpContactsGroupMember record);

    int insertSelective(EmpContactsGroupMember record);

    List<EmpContactsGroupMember> selectByExample(EmpContactsGroupMemberExample example);

    EmpContactsGroupMember selectByPrimaryKey(Integer groupMemberId);

    int updateByExampleSelective(@Param("record") EmpContactsGroupMember record, @Param("example") EmpContactsGroupMemberExample example);

    int updateByExample(@Param("record") EmpContactsGroupMember record, @Param("example") EmpContactsGroupMemberExample example);

    int updateByPrimaryKeySelective(EmpContactsGroupMember record);

    int updateByPrimaryKey(EmpContactsGroupMember record);
}
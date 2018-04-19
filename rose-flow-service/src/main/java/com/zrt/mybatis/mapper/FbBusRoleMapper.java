package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusRole;
import com.zrt.mybatis.domain.FbBusRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusRoleMapper {
    int countByExample(FbBusRoleExample example);

    int deleteByExample(FbBusRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(FbBusRole record);

    int insertSelective(FbBusRole record);

    List<FbBusRole> selectByExample(FbBusRoleExample example);

    FbBusRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") FbBusRole record, @Param("example") FbBusRoleExample example);

    int updateByExample(@Param("record") FbBusRole record, @Param("example") FbBusRoleExample example);

    int updateByPrimaryKeySelective(FbBusRole record);

    int updateByPrimaryKey(FbBusRole record);
}
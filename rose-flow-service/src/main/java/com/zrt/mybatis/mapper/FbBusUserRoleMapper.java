package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.FbBusUserRole;
import com.zrt.mybatis.domain.FbBusUserRoleExample;
import com.zrt.mybatis.domain.FbBusUserRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbBusUserRoleMapper {
    int countByExample(FbBusUserRoleExample example);

    int deleteByExample(FbBusUserRoleExample example);

    int deleteByPrimaryKey(FbBusUserRoleKey key);

    int insert(FbBusUserRole record);

    int insertSelective(FbBusUserRole record);

    List<FbBusUserRole> selectByExample(FbBusUserRoleExample example);

    FbBusUserRole selectByPrimaryKey(FbBusUserRoleKey key);

    int updateByExampleSelective(@Param("record") FbBusUserRole record, @Param("example") FbBusUserRoleExample example);

    int updateByExample(@Param("record") FbBusUserRole record, @Param("example") FbBusUserRoleExample example);

    int updateByPrimaryKeySelective(FbBusUserRole record);

    int updateByPrimaryKey(FbBusUserRole record);
}
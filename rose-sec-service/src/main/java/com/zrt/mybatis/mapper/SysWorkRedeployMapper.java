package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysWorkRedeploy;
import com.zrt.mybatis.domain.SysWorkRedeployExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysWorkRedeployMapper {
    int countByExample(SysWorkRedeployExample example);

    int deleteByExample(SysWorkRedeployExample example);

    int deleteByPrimaryKey(String workRedeployId);

    int insert(SysWorkRedeploy record);

    int insertSelective(SysWorkRedeploy record);

    List<SysWorkRedeploy> selectByExampleWithBLOBs(SysWorkRedeployExample example);

    List<SysWorkRedeploy> selectByExample(SysWorkRedeployExample example);

    SysWorkRedeploy selectByPrimaryKey(String workRedeployId);

    int updateByExampleSelective(@Param("record") SysWorkRedeploy record, @Param("example") SysWorkRedeployExample example);

    int updateByExampleWithBLOBs(@Param("record") SysWorkRedeploy record, @Param("example") SysWorkRedeployExample example);

    int updateByExample(@Param("record") SysWorkRedeploy record, @Param("example") SysWorkRedeployExample example);

    int updateByPrimaryKeySelective(SysWorkRedeploy record);

    int updateByPrimaryKeyWithBLOBs(SysWorkRedeploy record);

    int updateByPrimaryKey(SysWorkRedeploy record);
}
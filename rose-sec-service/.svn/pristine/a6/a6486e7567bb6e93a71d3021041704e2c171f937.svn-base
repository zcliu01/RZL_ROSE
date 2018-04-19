package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysRewardPsmt;
import com.zrt.mybatis.domain.SysRewardPsmtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRewardPsmtMapper {
    int countByExample(SysRewardPsmtExample example);

    int deleteByExample(SysRewardPsmtExample example);

    int deleteByPrimaryKey(String rewPsmtId);

    int insert(SysRewardPsmt record);

    int insertSelective(SysRewardPsmt record);

    List<SysRewardPsmt> selectByExampleWithBLOBs(SysRewardPsmtExample example);

    List<SysRewardPsmt> selectByExample(SysRewardPsmtExample example);

    SysRewardPsmt selectByPrimaryKey(String rewPsmtId);

    int updateByExampleSelective(@Param("record") SysRewardPsmt record, @Param("example") SysRewardPsmtExample example);

    int updateByExampleWithBLOBs(@Param("record") SysRewardPsmt record, @Param("example") SysRewardPsmtExample example);

    int updateByExample(@Param("record") SysRewardPsmt record, @Param("example") SysRewardPsmtExample example);

    int updateByPrimaryKeySelective(SysRewardPsmt record);

    int updateByPrimaryKeyWithBLOBs(SysRewardPsmt record);

    int updateByPrimaryKey(SysRewardPsmt record);
}
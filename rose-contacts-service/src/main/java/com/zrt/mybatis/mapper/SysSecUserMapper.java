package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysSecUser;
import com.zrt.mybatis.domain.SysSecUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecUserMapper {
    int countByExample(SysSecUserExample example);

    int deleteByExample(SysSecUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SysSecUser record);

    int insertSelective(SysSecUser record);

    List<SysSecUser> selectByExample(SysSecUserExample example);

    SysSecUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SysSecUser record, @Param("example") SysSecUserExample example);

    int updateByExample(@Param("record") SysSecUser record, @Param("example") SysSecUserExample example);

    int updateByPrimaryKeySelective(SysSecUser record);

    int updateByPrimaryKey(SysSecUser record);
}
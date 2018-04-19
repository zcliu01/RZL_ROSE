package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.PlatInforInbox;
import com.zrt.mybatis.domain.PlatInforInboxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatInforInboxMapper {
    int countByExample(PlatInforInboxExample example);

    int deleteByExample(PlatInforInboxExample example);

    int deleteByPrimaryKey(Integer inId);

    int insert(PlatInforInbox record);

    int insertSelective(PlatInforInbox record);

    List<PlatInforInbox> selectByExample(PlatInforInboxExample example);

    PlatInforInbox selectByPrimaryKey(Integer inId);

    int updateByExampleSelective(@Param("record") PlatInforInbox record, @Param("example") PlatInforInboxExample example);

    int updateByExample(@Param("record") PlatInforInbox record, @Param("example") PlatInforInboxExample example);

    int updateByPrimaryKeySelective(PlatInforInbox record);

    int updateByPrimaryKey(PlatInforInbox record);
}
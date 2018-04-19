package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.VmBusVidyoRoom;
import com.zrt.mybatis.domain.VmBusVidyoRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmBusVidyoRoomMapper {
    int countByExample(VmBusVidyoRoomExample example);

    int deleteByExample(VmBusVidyoRoomExample example);

    int deleteByPrimaryKey(String id);

    int insert(VmBusVidyoRoom record);

    int insertSelective(VmBusVidyoRoom record);

    List<VmBusVidyoRoom> selectByExample(VmBusVidyoRoomExample example);

    VmBusVidyoRoom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VmBusVidyoRoom record, @Param("example") VmBusVidyoRoomExample example);

    int updateByExample(@Param("record") VmBusVidyoRoom record, @Param("example") VmBusVidyoRoomExample example);

    int updateByPrimaryKeySelective(VmBusVidyoRoom record);

    int updateByPrimaryKey(VmBusVidyoRoom record);
}
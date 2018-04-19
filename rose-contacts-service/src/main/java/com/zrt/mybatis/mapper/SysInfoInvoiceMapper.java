package com.zrt.mybatis.mapper;

import com.zrt.mybatis.domain.SysInfoInvoice;
import com.zrt.mybatis.domain.SysInfoInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysInfoInvoiceMapper {
    int countByExample(SysInfoInvoiceExample example);

    int deleteByExample(SysInfoInvoiceExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysInfoInvoice record);

    int insertSelective(SysInfoInvoice record);

    List<SysInfoInvoice> selectByExample(SysInfoInvoiceExample example);

    SysInfoInvoice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysInfoInvoice record, @Param("example") SysInfoInvoiceExample example);

    int updateByExample(@Param("record") SysInfoInvoice record, @Param("example") SysInfoInvoiceExample example);

    int updateByPrimaryKeySelective(SysInfoInvoice record);

    int updateByPrimaryKey(SysInfoInvoice record);
}
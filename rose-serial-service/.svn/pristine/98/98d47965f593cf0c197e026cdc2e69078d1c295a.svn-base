package com.zrt.serial.service.serial;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.date.SearchDateUtils;
import com.zrt.serial.mapper.serial.SerialMapper;

@Service
public class SysBusinessSerialService {
  private final transient Logger a = LoggerFactory.getLogger(SysBusinessSerialService.class);

  @Autowired
  private SerialMapper serialMapper;
  private final BigDecimal b = new BigDecimal(1);
/**
 * 
 * @param bizKey 序列主键标识 
 * @param paramBoolean 是否有前缀
 * @param paramInt 序列长度
 * @return
 */
  @Transactional(rollbackFor={Throwable.class}, propagation=Propagation.REQUIRES_NEW)
  public String getSerialNumber(String bizKey, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = null;
    int i = 0;
    try
    {
      //根据key查询序列
      Map<String, Object> serialMapParam=new HashMap<String, Object>();
      serialMapParam.put("biz_key", bizKey);
      Map<String, Object> serialMap=serialMapper.serialSearch(serialMapParam);
      if (serialMap == null) {
    	  //如果不存在该key的序列号
        this.a.warn("no record bizkey {} in {}", bizKey, "sys_biz_serial");

        i = 1;
        serialMap = new HashMap();
        (serialMap).put("biz_key", bizKey);
        (serialMap).put("biz_serial_no", new BigDecimal(0));

        (serialMap).put("is_append", paramBoolean ? "1" : "0");
        (serialMap).put("serial_num", new BigDecimal(paramInt));
      }
      String str1 = (String)serialMap.get("is_append");

      String str2 = (String)serialMap.get("biz_prefix");

      str2 = str2 != null ? str2 : "";

      localStringBuilder = new StringBuilder(str2);

      BigDecimal localBigDecimal1 = new BigDecimal(serialMap.get("biz_serial_no").toString());

      localBigDecimal1 = localBigDecimal1 != null ? localBigDecimal1 : new BigDecimal(0);

      localBigDecimal1 = localBigDecimal1.add(this.b);

      BigDecimal localBigDecimal2 = new BigDecimal(serialMap.get("serial_num").toString());

      localBigDecimal2 = localBigDecimal2 != null ? localBigDecimal2 : new BigDecimal(-1);

      int j = localBigDecimal2.intValue();

      String str3 = String.valueOf(localBigDecimal1);
      String str4 = "";

      Object localObject2;
      //是否追加日期
      if ("1".equals(str1)) {
        localObject2 = SearchDateUtils.getToday();
        localStringBuilder.append((String)localObject2);
      }
      if (j > 0) {
          for (int k = 0; k < j - str3.length(); k++) {
            localStringBuilder.append("0");
          }
        }

        localStringBuilder.append(str3);
      if (i == 0) {
        localObject2 = new HashMap();
        ((Map)localObject2).put("biz_key", bizKey);
        ((Map)localObject2).put("biz_serial_no", localBigDecimal1);

        serialMapper.serialNextUpdate((Map)localObject2);
      }
      else {
        ((Map)serialMap).put("biz_serial_no", localBigDecimal1);

        serialMapper.serialSave(serialMap);
      }
    }
    catch (Exception localException) {
      this.a.error("", localException);
      return null;
    }

    return localStringBuilder.toString();
  }
}
package com.zrt.serial.service.serial;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.commons.IdWorker;

@Service
public class SerialService
{
  public static final int DEFAULT_SERIAL_NUM = -1;

  private final Map<String, IdWorker> a = new HashMap();

  @Autowired
  private SysBusinessSerialService sysBusinessSerialService;

  public String getSerialNumber(String paramString)
  {
    return String.valueOf(a(paramString).nextId());
  }

  public String getSerialNumber(String paramString, boolean paramBoolean)
  {
    return a(paramString).nextID();
  }

  public String getSerialNumber(String paramString, boolean paramBoolean, int paramInt)
  {
    return a(paramString).nextID();
  }

  private IdWorker a(String paramString) {
    IdWorker localIdWorker = (IdWorker)this.a.get(paramString);
    if (null == localIdWorker) {
      synchronized (paramString) {
        long l1 = 0L;
        long l2 = 0L;
        localIdWorker = new IdWorker(l1, l2);
        this.a.put(paramString, localIdWorker);
      }
    }

    return localIdWorker;
  }

  public String getSerialNumberFromDB(String paramString)
  {
    synchronized (this) {
      return this.sysBusinessSerialService.getSerialNumber(paramString, false, -1);
    }
  }

  public String getSerialNumberFromDB(String paramString, boolean paramBoolean)
  {
    synchronized (this) {
      return this.sysBusinessSerialService.getSerialNumber(paramString, paramBoolean, -1);
    }
  }

  public String getSerialNumberFromDB(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (this) {
      return this.sysBusinessSerialService.getSerialNumber(paramString, paramBoolean, paramInt);
    }
  }
}
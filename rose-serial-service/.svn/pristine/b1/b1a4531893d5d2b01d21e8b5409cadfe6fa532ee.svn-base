package com.zrt.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zrt.commons.date.SearchDateUtils;

public class IdWorker
{
  protected static final Logger LOG = LoggerFactory.getLogger(IdWorker.class);
  private long a;
  private long b;
  private long c = 0L;

  private long d = 1288834974657L;

  private long e = 5L;
  private long f = 5L;
  private long g = 0xFFFFFFFF ^ -1L << (int)this.e;
  private long h = 0xFFFFFFFF ^ -1L << (int)this.f;
  private long i = 12L;

  private long j = this.i;
  private long k = this.i + this.e;
  private long l = this.i + this.e + this.f;

  private long m = 0xFFFFFFFF ^ -1L << (int)this.i;

  private long n = -1L;

  public IdWorker(long paramLong1, long paramLong2)
  {
    if ((paramLong1 > this.g) || (paramLong1 < 0L)) {
      throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", new Object[] { Long.valueOf(this.g) }));
    }

    if ((paramLong2 > this.h) || (paramLong2 < 0L)) {
      throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", new Object[] { Long.valueOf(this.h) }));
    }

    this.a = paramLong1;
    this.b = paramLong2;
    LOG.info(String.format("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d", new Object[] { Long.valueOf(this.l), Long.valueOf(this.f), Long.valueOf(this.e), Long.valueOf(this.i), Long.valueOf(paramLong1) }));
  }

  public synchronized long nextId()
  {
    long l1 = timeGen();

    if (l1 < this.n) {
      LOG.error(String.format("clock is moving backwards.  Rejecting requests until %d.", new Object[] { Long.valueOf(this.n) }));

      throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", new Object[] { Long.valueOf(this.n - l1) }));
    }

    if (this.n == l1) {
      this.c = (this.c + 1L & this.m);
      if (this.c == 0L)
        l1 = tilNextMillis(this.n);
    }
    else {
      this.c = 0L;
    }

    this.n = l1;

    return l1 - this.d << (int)this.l | this.b << (int)this.k | this.a << (int)this.j | this.c;
  }

  public synchronized String nextID()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(SearchDateUtils.getToday());
    localStringBuffer.append(nextId());
    return localStringBuffer.toString();
  }

  protected long tilNextMillis(long paramLong) {
    long l1 = timeGen();
    while (l1 <= paramLong) {
      l1 = timeGen();
    }
    return l1;
  }

  protected long timeGen() {
    return System.currentTimeMillis();
  }

//  public static void main(String[] paramArrayOfString)
//  {
//    IdWorker localIdWorker = new IdWorker(0L, 0L);
//    long l1 = localIdWorker.nextId();
//    System.out.println(l1);
//    String str = localIdWorker.nextID();
//    System.out.println(str);
//  }
}
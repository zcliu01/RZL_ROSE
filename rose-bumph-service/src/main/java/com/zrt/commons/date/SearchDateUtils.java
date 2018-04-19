package com.zrt.commons.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SearchDateUtils {

	// 计算当月最后一天,返回字符串
	public static Date getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime())+" 23:59:59";
		Date date = null;
		try {
			 date = sdf.parse(str);
		} catch (ParseException e) {
		}
		
		return date;
	}

	// 上month月第一天
	public static Date getMonthFirst(int month) {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, month);// 减一个月，变为下月的1号
		// lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天

		str = sdf.format(lastDate.getTime())+" 00:00:00";
		Date date = null;
		try {
			 date = sdf.parse(str);
		} catch (ParseException e) {
		}
		
		return date;
	}
	
	//获取当周第一天时间
	 public static Date getFirstDayOfWeek() {
    	 String str = "";   
         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");       
         Calendar lastDate = Calendar.getInstance();   
         //lastDate.set(Calendar.DATE,1);//设为当前月的1号   
         //lastDate.add(Calendar.MONTH,-2);//减一个月，变为下月的1号   
         //lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天   
            lastDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
         str=sdf.format(lastDate.getTime())+" 00:00:00";   
     	Date date = null;
		try {
			 date = sdf.parse(str);
		} catch (ParseException e) {
		}
		return date;   
    	
    	
      
    }
	 /**
	  * 获取前天日期
	  * @return
	  */
	 public static String getBeforDay(){
		 Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
	     calendar.add(Calendar.DATE, -2);    //得到前一天
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
	     return sdf.format(calendar.getTime());
	 }
	 /**
	  * 获取昨天日期
	  * @return
	  */
	 public static String getYesterDay(){
		 Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
	     calendar.add(Calendar.DATE, -1);    //得到天昨天日期
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
	     return sdf.format(calendar.getTime());
	 }
	 /**
	  * 获取当天日期
	  * @return
	  */
	 public static String getToday(){
		 Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
	     calendar.add(Calendar.DATE, 0);    //得到天昨天日期
	     SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");   
	     return sdf.format(calendar.getTime());
	 }
	
}

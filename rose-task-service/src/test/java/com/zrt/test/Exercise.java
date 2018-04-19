package com.zrt.test;


import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.util.TextUtils;
import org.junit.Test;

import com.github.pagehelper.StringUtil;
import com.zrt.commons.date.DateUtil;



public class Exercise {

	@Test
	public void test() {
		Random random = new Random();
		System.out.println(random.nextInt(11));
	}
	
	
	public String getresult(String str){
		
		if (str.substring(0,str.lastIndexOf("-")+3).contains(".")) {
			return str.substring(0,str.lastIndexOf("-")+2);
		}
		
		return str.substring(0,str.lastIndexOf("-")+3);
	}
	
	
	

	@Test
	public void test2(){
		List<Map<String, Object>> list1  = new ArrayList<>();
		List<Map<String, Object>> list2  = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		Map<String, Object> map3 = new HashMap<>();
		Map<String, Object> map4 = new HashMap<>();
		map.put("A", "a");
		map2.put("B", "b");
		map3.put("C", "c");
		map4.put("D", "d");
		list1.add(map);
		list1.add(map2);
		list1.add(map3);
		list1.add(map4);
		list2.addAll(list1);
		System.out.println(list2);
	}
	
	@Test
	public void test3(){
		String taskEndTime = "20170920000000";
		String temp = taskEndTime.substring(0, 4)+"-"+taskEndTime.substring(4,6)+"-"+taskEndTime.substring(6, 8)+" "+taskEndTime.substring(8,10)+":"+taskEndTime.substring(10,12)+":"+taskEndTime.substring(12,14);

		
		System.out.println(temp);
	}
	
	
	
	@Test
	public void test4(){
		String a = "2017-11-16 09:37:00";
		System.out.println(DateUtil.getDateFormat(a));
	
	}
	
	
	@Test
	public void test5(){
		Integer a = 17;
		Integer b = 100;
		double aa = a;
		double bb = b ;
	        NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例
	        format.setMinimumFractionDigits(0);// 设置小数位
	        System.out.println(format.format(aa / bb));// 打印计算结果
		
	}
	
	
	@Test
	public void test8(){
		String a = "20170819101200";
		 a = a.substring(0, 4)+"-"+a.substring(4, 6)+"-"+a.substring(6, 8)+" "+a.substring(8, 10)+":"+a.substring(10, 12);
		System.out.println(a);
		
	}
	
	
	@Test
	public void test6(){
		long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    String end = "2017-10-23 17:48:30";
	    String begin = "2017-10-23 14:48:30";
	    Date endDate = DateUtil.getDateFormat(end);
	    Date nowDate = DateUtil.getDateFormat(begin);
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - nowDate.getTime();
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	   System.out.println(day + "天" + hour + "小时" + min + "分钟"); 
		
	}
	
	
	
	@Test
	public void test7(){
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		  String str = "20171024181200";
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		  String dateTime = DateUtil.getCurrentDateTime();
		  System.out.println(dateTime);
		  long a = 0;
		  long b = 0;
		  long aa = 0 ;
		try {
			a = sdf.parse(str).getTime();
			b = sdf.parse(dateTime).getTime();
			aa = b - a ;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}//毫秒
		  System.out.println(aa); 
		// 计算差多少天
	    long day = aa / nd;
	    // 计算差多少小时
	    long hour = aa % nd / nh;
	    System.out.println(day + "天" + hour + "小时");
		
	}
	@Test
	public void test9(){
		String end = "2017-11-01 13:00";
		end = end.replaceAll("-", "").replace(" ", "").replace(":", "")+"00";
		System.out.println(end);
		
	}
	@Test
	public void test10(){
		String start = "2018-01-22 14:30";
		String end = "2018-01-22 19:30";
		start = start.replace(" ", "").replace("-", "").replace(":", "") + "00";
		end = end.replace(" ", "").replace("-", "").replace(":", "") + "00";
		long a = Long.parseLong(start);
		long b = Long.parseLong(end);
		System.out.println(a>b);
		
	}
	
}

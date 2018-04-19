package WkRecordMapper;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.zrt.commons.date.DateUtil;


public class A {

	@Test
	public void test() {
		List<String> betweenDates = DateUtil.getBetweenDates(DateUtil.getDateString("2017-09-29"), DateUtil.getDateString("2017-10-29"));
		System.out.println(betweenDates);
	}
	
	
	@Test
	public void test1() {
		String a = "2017-09-29";
		String b = "2017-10-01";
		Date begin = DateUtil.getDateFormat(a);
		Date end = DateUtil.getDateFormat(b);
		 List<String> result = new ArrayList<String>();
         Calendar tempStart = Calendar.getInstance();
         tempStart.setTime(begin);
      while(begin.getTime()<=end.getTime()){
    	  String string = DateUtil.getDateFormat(tempStart.getTime()).replaceAll("-", "");
          result.add(string);
          tempStart.add(Calendar.DAY_OF_YEAR, 1);
          begin = tempStart.getTime();
      }
         System.out.println(result);
	}
	
	
	@Test
	public void test2() {
		String a = "20170929000000";
		String b = "20171001000000";
		 a = DateUtil.getDateString(a);
		 b = DateUtil.getDateString(b);
		List<String> result = DateUtil.getBetweenDates(a, b);
		System.out.println(result);
	}

}

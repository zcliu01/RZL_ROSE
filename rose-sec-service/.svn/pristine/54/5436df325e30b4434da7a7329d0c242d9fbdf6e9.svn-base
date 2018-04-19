package com.zrt.commons.utils;


/**
 * 获取特定位数的字符串
 * @author admin
 *
 */
public class SubStr {

	public static String getString(String str,String str1){
		String substring1 = str.substring(str.indexOf(str1)+1);
		String substring2 = substring1.substring(substring1.indexOf(str1)+1);
		if (substring2.indexOf(str1)==-1) {
			return substring2;
		}
		int indexOf = substring2.indexOf(str1);
		String substring4 = substring2.substring(0,indexOf);
		return substring4;
	}
	
	public static String getStringByGrade(String str,String str1){
		String substring1 = str.substring(str.indexOf(str1)+1);
		String substring2 = substring1.substring(substring1.indexOf(str1)+1);
		return substring2 ;
	}
}

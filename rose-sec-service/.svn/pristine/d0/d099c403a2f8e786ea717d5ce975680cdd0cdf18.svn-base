package com.zrt.commons.number;

import com.zrt.commons.AppException;

public class NumberUtils {
	
	/**
	 * 自动加1，并补足前面的空位，自动补0
	 * 
	 * @param number	要加1的数字字符串
	 * @param place		补齐空位后的字符串长度
	 * @return
	 * @throws AppException
	 */
	public static String increaseNumber(String number,Integer place) throws AppException{
		try{
			return increaseNumber(Integer.valueOf(number),place);
		}catch(Exception e){
			throw new AppException();
		}
	}
	
	/**
	 * 自动加1，并补足前面的空位，自动补0
	 * 
	 * @param number	要加1的数字
	 * @param place		补齐空位后的字符串长度
	 * @return
	 * @throws AppException
	 */
	public static String increaseNumber(Integer number,Integer place) throws AppException{
		try{
			StringBuffer sb = new StringBuffer("%0");
			sb.append(place).append("d");
			
			return String.format(sb.toString(), ++number);
		}catch(Exception e){
			throw new AppException();
		}
	}
	
//	public static void main(String[] args) {
//		try {
//			System.out.println(NumberUtils.increaseNumber("4", 4));
//		} catch (AppException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

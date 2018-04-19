package com.zrt.commons.sign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 实现MD5加密
 *
 */
public class MD5 {

 /**
  * 获取加密后的字符串
  * @param input
  * @return
  */
 public static String encode(String pw) {
  try {  

        // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）  
        MessageDigest messageDigest =MessageDigest.getInstance("MD5");  
        // 输入的字符串转换成字节数组  
        byte[] inputByteArray = pw.getBytes();  
        // inputByteArray是输入字符串转换得到的字节数组  
        messageDigest.update(inputByteArray);  
        // 转换并返回结果，也是字节数组，包含16个元素  
        byte[] resultByteArray = messageDigest.digest();  
        // 字符数组转换成字符串返回  
        return byteArrayToHex(resultByteArray);  
     } catch (NoSuchAlgorithmException e) {  
        return null;  
     }  
 }

    public static String byteArrayToHex(byte[] byteArray) {  

        // 首先初始化一个字符数组，用来存放每个16进制字符  
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f' };  
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））  
        char[] resultCharArray =new char[byteArray.length * 2];  
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去  
        int index = 0; 
        for (byte b : byteArray) {  
           resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];  
           resultCharArray[index++] = hexDigits[b& 0xf];  
        }
        // 字符数组组合成字符串返回  
        return new String(resultCharArray);  
    }
    
    /**
    public static void main(String[] args) {
    	
    	String str2 = "u_20150513598374740930854912";
    	String str = "20150513598374740930854912";

		MD5 m = new MD5();
		String ss=m.encode(str);
		String ss2=m.encode(str2);
		if("08ccb4d432ca4aefcf5e9541e7870d94".equals(ss)){
			//"u_08ccb4d432ca4aefcf5e9541e7870d94;
			System.out.println("aaa");
		}
	System.out.println(ss+":"+ss.length());	
	System.out.println(ss2+":"+ss2.length());	
	
	}
    **/
}

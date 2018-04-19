package com.zrt.commons.utils;

import java.util.UUID;

/**
 * 
 * @description 自动生成32位的UUid，对应数据库的主键id进行插入用。  
 * @author ajzhou
 *
 */
public class UUIDUtils {

	public static String getUUID() {  
	   
	    return UUID.randomUUID().toString().replace("-", "");  
	}  

}

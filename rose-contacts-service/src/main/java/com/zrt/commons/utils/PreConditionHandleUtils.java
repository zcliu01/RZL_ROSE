package com.zrt.commons.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 此工具类主要是用于前期条件判断或者默认设置
 * 
 * @author ronglian
 *
 */
public class PreConditionHandleUtils {
	/**
	 * 默认查询在职员工---APP端添加在职/离职选择按钮
	 * 
	 * @param map
	 */
	public static void setDefaultStatus(Map<String, Object> map) {
		// 判断查询1在职员工还是0离职员工
		if (map.get("status") == null || StringUtils.isBlank(map.get("status").toString())) {
			map.put("status", "1");// 默认选择查询在职员工
		}
	}

	/**
	 * 搜索条件预处理
	 * 
	 * @param map
	 */
	public static void searchConditionHandle(Map<String, Object> map) {
		if (map.get("search") != null && StringUtils.isNotBlank(map.get("search").toString())) {
			// 判断搜索条件首字母是汉字还是字母
			String searchString = map.get("search").toString().trim();
			char[] firstChar = searchString.substring(0, 1).toCharArray();
			// 判断第一个字符是否是字母，如果是字母，将字符串全部转成小写字母
			if (firstChar[0] >= 'a' && firstChar[0] <= 'z' || firstChar[0] >= 'A' && firstChar[0] <= 'Z') {
				String lowerString = searchString.toLowerCase();
				map.put("search", lowerString);
			} else {
				map.put("search", searchString);
			}

		} else {
			map.put("search", "");
		}
	}

}

package com.zrt.commons.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * 实体与Map转换
 * @author msKui
 *
 */
public class MapEntityConverter {
	
	/**
	 * 将Map中的key和value转换为实体的属性和值。
	 * 
	 * key必须满足多个字母用下划线分隔，或者驼峰命名法。
	 * 实体属性名称必须满足驼峰命名法。
	 * 实体中的属性类型必须是类类型不能是基本类型。
	 * 
	 * @param appMap		要转为实体属性的键值对
	 * @param cls			实体类类型
	 * @return
	 * @throws ReflectiveOperationException
	 */
	public static Object getEntityFromMap(Map<String,Object> appMap,Class<?> cls) throws ReflectiveOperationException{
		//log.info("开始为实体："+cls+"属性赋值");
		Object obj = cls.newInstance();
		Method[] methods = cls.getMethods();
		
		for(String key : appMap.keySet()){
			StringBuffer memberProperty = humpShape(key);
			
			if(null == memberProperty)
				break;
			
			memberProperty = memberProperty.insert(0, "set");
			
			Object propertyValue = appMap.get(key);
			if(null == propertyValue)
				break;
			
			if(isMethodExist(methods,memberProperty.toString()))
				setPropertyValue(obj,cls,memberProperty.toString(),propertyValue);
			
		}
		
		//log.info("为实体赋值结束。" + JSON.toJSONString(obj));
		return obj;
	}
	
	/**
	 * 将一个实体中属性和值获取到Map中
	 * @param propertys			要转换的属性名称
	 * @param obj				实体对象，属性必须有值，否则无法转换
	 * @return
	 * @throws ReflectiveOperationException
	 */
	public static Map<String,Object> getMapFromEntity(String[] propertys,Object obj) throws ReflectiveOperationException{
		Class<?> cls = obj.getClass();
		Method[] methods = cls.getMethods();
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		mapKeyValue(map,propertys,obj,cls,methods);
		
		return map;
	}
	
	/**
	 * 从list中的每个实体属性值，转换到每个map中再存入list中
	 * @param propertys			要转换的属性名称
	 * @param list				存储所有实体的集合
	 * @return
	 * @throws ReflectiveOperationException
	 */
	public static List<Map<String,Object>> getMapFromList(String[] propertys,List<?> list,Class<?> cls) throws ReflectiveOperationException{
		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
		if(null == list || list.size() == 0)
			return listMap;
		
		Method[] methods = cls.getMethods();
		
		Map<String,Object> map ;
		for(Object objVal : list){
			map = new HashMap<String,Object>();
			mapKeyValue(map,propertys,objVal,cls,methods);
			listMap.add(map);
		}
		
		return listMap;
	}
	
	/**
	 * 组装Map的key和value
	 * @param map				要返回map
	 * @param propertys			要转换的属性名称
	 * @param obj 				必须是有值的对象
	 * @param cls 				对象的类类型
	 * @param methods
	 */
	public static void mapKeyValue(Map<String,Object> map,String[] propertys,Object obj,Class<?> cls,Method[] methods){
		if(propertys.length == 0)
			return ;
		
		for(String property : propertys){
			StringBuffer memberProperty = humpShape(property);
			
			if(null == memberProperty)
				break;
			
			memberProperty = memberProperty.insert(0, "get");
			
			if(isMethodExist(methods,memberProperty.toString()))
				map.put(property, getMapValue(obj,cls,memberProperty.toString()));
		}
	}
	
	/**
	 * 根据传入的参数，获取遵循驼峰命名规则的对应值。
	 * 首字母也大写
	 * @return
	 */
	public static StringBuffer humpShape(String key){
		if(null == key)
			return null;
		
		String[] keyArr = new String[1];
		if(key.contains("_")){
			keyArr = StringUtils.split(key, "_");
		}else{
			keyArr[0] = key;
		}
		
		if(keyArr.length == 0)
			return null;
		
		//首字母不用改大写
		StringBuffer sb = new StringBuffer();
		
		for(int i=0,l=keyArr.length;i<l;i++){
			sb.append(keyArr[i].trim().substring(0, 1).toUpperCase());
			
			if(keyArr[i].length()>1){
				sb.append(keyArr[i].trim().substring(1, keyArr[i].length()));
			}
		}
		return sb;
	}
	
	/**
	 * 查看key是否是一个方法名
	 * @param methods		方法数组
	 * @param key			要校验的字符串
	 * @return
	 */
	public static boolean isMethodExist(Method[] methods,String key){
		for(Method m : methods){
			if(m.getName().equals(key))
				return true;
		}
		return false;
	}
	
	/**
	 * 为对象的属性赋值。
	 * 形式参数value的编译类型为Object，但运行时类型为实际的类类型（一定不能是基本类型，基本类型不能转为Object）。
	 * @param obj
	 * @param cls
	 * @param memberProperty
	 * @param value
	 */
	public static void setPropertyValue(Object obj,Class<?> cls,String memberProperty,Object value){
		try {
			Method m = cls.getMethod(memberProperty,value.getClass());
			m.invoke(obj, value);
		} catch (Exception e) {
			//log.error("为实体"+cls+"赋值时，执行"+memberProperty+"方法出现错误");
			e.printStackTrace();
		} 
	}
	
	/**
	 * 通过反射手段获取属性值
	 * @param obj
	 * @param cls
	 * @param memberProperty
	 * @return
	 */
	public static Object getMapValue(Object obj,Class<?> cls,String memberProperty){
		Object mapVal = null;
		try {
			Method m = cls.getMethod(memberProperty);
			mapVal = m.invoke(obj);
		} catch (Exception e) {
			//log.error("执行"+cls+"的"+memberProperty+"方法出现错误");
			e.printStackTrace();
		} 
		
		return mapVal;
	}

	/**
	 * 将Map中属性过滤strArr中的属性。
	 * @param listSecMap
	 * @param strArr
	 * @return
	 */
	public List<Map<String,Object>> getMapFromListMap(List<Map<String,Object>> listSecMap,String[] strArr){
		List<Map<String,Object>> listMap = new ArrayList<>();
		Map<String,Object> returnMap ;
		for(Map<String,Object> map : listSecMap){
			returnMap = new HashMap<>();
			for(String property : strArr){
				returnMap.put(property,map.get(property));
			}
			listMap.add(returnMap);
		}
		return listMap;
	}

//	public static void main(String[] args) {
//		test3();
//	}
	
	private static void test1(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", "aaaaaaa");
		map.put("user_age", 27);
		map.put("now_date", new Date());
		map.put("pass_word", "asdf");
		try {
			Test t = (Test) MapEntityConverter.getEntityFromMap(map, Test.class);
			System.out.println(JSON.toJSONString(t));
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test2(){
		Test test = new Test("bbbbbbbbb",27,new Date());
		try {
			Map<String,Object> map = MapEntityConverter.getMapFromEntity(new String[]{"user_name"}, test);
			System.out.println(JSON.toJSONString(map));
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test3(){
		Test test = new Test("bbbbbbbbb",27,new Date());
		Test test2 = new Test("ccccccccc",23,new Date());
		Test test3 = new Test("dddddddddddd",29,new Date());
		Test test4 = new Test("eeeeeeeeee",26,new Date());
		List<Test> list = new ArrayList<Test>();
		list.add(test);
		list.add(test2);
		list.add(test3);
		list.add(test4);
		try {
			List<Map<String,Object>> listMap = MapEntityConverter.getMapFromList(new String[]{"user_name","user_age"},list, Test.class);
			System.out.println(JSON.toJSONString(listMap));
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
}

class Test {
	private String userName;
	private Integer userAge;
	private Date nowDate;
	
	public Test(){}
	
	public Test(String userName, Integer userAge, Date nowDate) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.nowDate = nowDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public Date getNowDate() {
		return nowDate;
	}
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
}

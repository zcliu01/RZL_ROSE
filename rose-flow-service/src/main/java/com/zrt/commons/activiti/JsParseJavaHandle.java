package com.zrt.commons.activiti;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

/**
 * 该类是解析js脚本的
 * @author wwfu
 *
 */
public class JsParseJavaHandle {

	/**
	 * js脚本解析
	 * @param jsStr javascript脚本串
	 * @param param Javascript调用的参数
	 */
	public static void parse(String jsStr,Map<String, Object> param){
		try{
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");  
	        Compilable compilable = (Compilable) engine;  
	        Bindings bindings = engine.createBindings(); // Local级别的Binding  
	        CompiledScript JSFunction = compilable.compile(jsStr); // 解析编译脚本函数  
	        bindings.putAll(param);
	        Object result = JSFunction.eval(bindings);  
	        
	        System.out.println(result); //调用缓存着的脚本函数对象，Bindings作为参数容器传入  
		}catch(Exception e){
			
		}
		
	}
	
	/**
	 * ScriptContext的概念，这个用的少，它是用来连接ScriptEngine和Bindings的工具。
	 * 按照JDK的解释：该接口的实现类被用来连接ScriptEngine和宿主应用程序中的对象（如有范围的Bindings）
	 */
	public static void  contex(){
		try{
			ScriptEngineManager manager = new ScriptEngineManager();  
	        ScriptEngine engine = manager.getEngineByName("js");  
	        SimpleBindings simpleBindings = new SimpleBindings();  
	        String jsCript = "for(var i=0; i<test.length; i++){test[i] = test[i].replaceAll(',' , '')} ; test";  
	        simpleBindings.put("test", Arrays.asList("1,2,37", "1,223", "3,932"));  
	        Object result = engine.eval(jsCript, simpleBindings);  
	        System.out.println(result);  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	/**
	public static void main(String[] args) {
		Map<String, Object> param=new HashMap<>();
		param.put("a", 1);
		param.put("c", 2);
		//String script = "function add(op1,op2){return op1+op2} add(a, c)"; // 定义函数并调用  
		String script = "var i=9,j=1;i+j"; // 定义函数并调用  
		parse(script,param);
		//contex();
	}**/
}

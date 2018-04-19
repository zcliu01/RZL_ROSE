package com.zrt.commons;

import java.util.HashMap;
import java.util.Map;

public class PageInfo {

	public void setPage(Map<String, Object> map) throws Exception{
		//获取查询的页数
		Object pageNo=map.get("pageNo");
		//获取每页显示的条数
		Object maxResult=map.get("maxResult");
		//起始条数
		int firstResult=0;
		//每页显示的条数
		int pageCount=10;
		//第几页
		int pageNum=0;
		if(pageNo!=null && !"".equals(pageNo)){
			pageNum=Integer.parseInt(pageNo.toString());
		}
		if(maxResult!=null && !"".equals(maxResult)){
			pageCount=Integer.parseInt(maxResult.toString());
		}
		if(pageNum>0){
			firstResult = (pageNum - 1) * pageCount;
		}
		map.put("firstresult",firstResult);
		map.put("pageNo",pageNum);
		map.put("maxResult",pageCount);
	}
}

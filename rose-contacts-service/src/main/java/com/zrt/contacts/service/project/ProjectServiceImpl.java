package com.zrt.contacts.service.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zrt.commons.AppException;
import com.zrt.commons.PageInit;
import com.zrt.mybatis.domain.TprojectInfo;
import com.zrt.mybatis.domain.TprojectInfoExample;
import com.zrt.mybatis.domain.TprojectInfoExample.Criteria;
import com.zrt.mybatis.mapper.TprojectInfoMapper;

@Service
public class ProjectServiceImpl  implements ProjectService{
	
	@Autowired
    private TprojectInfoMapper tprojectInfoMapper;
	/**
     * 查询所有的项目列表
     * @param map
     * @return
	 * @throws AppException 
     */
	@Override
	public Map<String, Object> projectList(Map<String, Object> map) throws AppException {
		
		PageInit.setPage(map);
		PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),
				Integer.parseInt(map.get("maxResult").toString()));
		TprojectInfoExample example=new TprojectInfoExample();
		String project_code=(String)map.get("project_code");
		String project_name=(String)map.get("project_name");
		String fund_code=(String)map.get("fund_code");
		Criteria criteria=example.createCriteria();
		if(StringUtils.isNotBlank(project_code)){
			criteria.andCProjectcodeEqualTo(project_code);
		}
		if(StringUtils.isNotBlank(project_name)){
			criteria.andCProjectnameLike("%"+project_name+"%");
		}
		if(StringUtils.isNotBlank(fund_code)){
			criteria.andCFundcodeEqualTo(fund_code);
		}
		List<TprojectInfo> resList=tprojectInfoMapper.selectByExample(example);
		List<Map<String, Object>> dataList=new ArrayList<>();
		for(TprojectInfo pro:resList){
			Map<String, Object> dataMap=new HashMap<String, Object>();
			dataMap.put("project_code", pro.getcProjectcode());
			dataMap.put("project_name", pro.getcProjectname());
			dataMap.put("fund_code", pro.getcFundcode());
			dataList.add(dataMap);
		}
		PageInfo<TprojectInfo> pageInfo = new PageInfo<>(resList);
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap.put("list", dataList);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", listMap);
		resMap.put("count", pageInfo.getTotal());
		return resMap;
	}
      
	  
}

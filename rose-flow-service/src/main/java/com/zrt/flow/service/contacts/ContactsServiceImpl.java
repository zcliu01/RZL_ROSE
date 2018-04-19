package com.zrt.flow.service.contacts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.contacts.IContactsClient;

/**
 * Created by msKui on 2017/3/23.
 */
@Service
public class ContactsServiceImpl implements ContactsService{
    private final transient Logger logger = LoggerFactory.getLogger(ContactsServiceImpl.class);

    @Resource(name="HystrixContactsClient")
    private IContactsClient iContactsClient;

    @Override
    public Map<String, Object> commonEmpSearch(Map<String, Object> map) {
        logger.info("从contacts服务中获取员工的员工姓名、组织机构id和组织机构名称,emp_id="+map.get("search"));
        Map<String, Object> result = iContactsClient.commonEmpSearch(map);
        logger.info("从contacts服务中获取员工的员工姓名、组织机构id和组织机构名称,result="+result.toString());

        return result;
    }
    
    @Override
    public List<Map<String, Object>> empOrgInfo(Map<String, Object> map) {
        logger.info("从contacts服务中获取员工所有部门");
        Map<String, Object> result = iContactsClient.empOrgInfo(map);
        List<Map<String, Object>> dataList=(List<Map<String, Object>>)((Map<String, Object>)result.get("data")).get("list");
        
        if(dataList!=null && dataList.size()>0){
        	for(Map<String, Object> data:dataList){
        		data.put("org_name", data.get("org_name_view"));
        	}
        }
        return dataList;
    }

	@Override
	public Map<String, Object> commonEmpSearchDetail(String empId) {
		// TODO Auto-generated method stub
        logger.info("从contacts服务中获取员工的员工姓名、组织机构id和组织机构名称,emp_id="+empId);
		 Map<String, Object> map=new HashMap<>();
		 map.put("search", empId);
	     Map<String, Object> result = iContactsClient.commonEmpSearch(map);
	     Boolean resultFlag=(Boolean)result.get("result");
	     Map<String, Object> empData = null;
	 	if(resultFlag){
	 		List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
			if (null != li && li.size() > 0) {
				empData = li.get(0);
			}
	 	}
        logger.info("从contacts服务中获取员工的员工姓名、组织机构id和组织机构名称,result="+result.toString());
		return empData;
	}
}

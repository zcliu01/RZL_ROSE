package com.zrt.flow.service.sec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.sec.ISecClient;

/**
 * Created by wwfu on 2017/11/1.
 */
@Service
public class SecService{
    private final transient Logger logger = LoggerFactory.getLogger(SecService.class);

    @Resource(name="HystrixSecClient")
    private ISecClient iSecClient;

    public List<Map<String, Object>> upManageSearch(Map<String, Object> map) {
        logger.info("从sec服务中获取员工的主分管领导");
        Map<String, Object> result = iSecClient.upManageSearch(map);
        Boolean res=(Boolean)result.get("result");
        List<Map<String, Object>> dataResult =new ArrayList<Map<String, Object>>();
        if(res){//说明查询正常
        	dataResult=(List<Map<String, Object>>)result.get("data");
        }
        return dataResult;
    }
    
    /***
     * 根据员工id，查询主分管领导
     * @param map
     * @return
     */
    public List<Map<String, Object>> manageSearch(Map<String, Object> map) {
        logger.info("从sec服务中获取员工的主分管领导");
        Map<String, Object> result = iSecClient.manageSearch(map);
        Boolean res=(Boolean)result.get("result");
        List<Map<String, Object>> dataResult =new ArrayList<Map<String, Object>>();
        if(res){//说明查询正常
        	dataResult=(List<Map<String, Object>>)result.get("data");
        }
        return dataResult;
    }
    
}

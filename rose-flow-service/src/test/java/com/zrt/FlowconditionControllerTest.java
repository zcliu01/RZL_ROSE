package com.zrt;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dwliu on 2017/9/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlowconditionControllerTest.class)
public class FlowconditionControllerTest {


    private URL base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:9008");
        this.template = new TestRestTemplate();
    }
    @Test
    public void applyCheckWithFile() {
        Map<String, Object> appMap = new HashedMap();
        appMap.put("inst_id","123");
        Map<String, Object> conMap = new HashedMap();
        conMap.put("rev_content","复审内容");
        List<Map<String,Object>> conList = new ArrayList<>();
        List<Map<String,Object>> listFile = new ArrayList<>();
        Map<String, Object> fileMap = new HashedMap();
        Map<String, Object> fileMap2 = new HashedMap();
        fileMap.put("file_url","D:/txt.txt");
        fileMap.put("file_name","文件1");
        fileMap.put("file_type","1");
        listFile.add(fileMap);
        fileMap2.put("file_url","http://local/text.txt");
        fileMap2.put("file_name","文件2");
        fileMap2.put("file_type","0");
        listFile.add(fileMap2);
        List<Map<String,Object>> listRelevance = new ArrayList<>();
        Map<String, Object> relevanceMap = new HashedMap();
        Map<String, Object> relevanceMap2 = new HashedMap();
        relevanceMap.put("rel_id","12312321");
        relevanceMap.put("rel_name","讯息名称");
        relevanceMap.put("rel_type","1");
        listRelevance.add(relevanceMap);
        relevanceMap2.put("rel_id","123123123");
        relevanceMap2.put("rel_name","流程名称");
        relevanceMap2.put("rel_type","0");
        listRelevance.add(relevanceMap2);
        conMap.put("file",listFile);
        conMap.put("rel",listRelevance);
        conList.add(conMap);
        appMap.put("con",conList);
        try {
            String result = template.postForObject(base.toString()+"/v1.0/flow/applyCheckWithFile", buildEntity(appMap), String.class);
            System.out.println("-----询列表返回："+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private HttpEntity<String> buildEntity(Map<String,Object> params){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return new HttpEntity<String>(JSON.toJSONString(params), headers);
    }
}

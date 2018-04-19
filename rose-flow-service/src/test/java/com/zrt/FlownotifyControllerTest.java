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
import java.util.Map;

/**
 * Created by dwliu on 2017/9/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FlownotifyControllerTest.class)
public class FlownotifyControllerTest {


    private URL base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:9008");
        this.template = new TestRestTemplate();
    }
    @Test
    public void notifyList() {
        Map<String, Object> appMap = new HashedMap();

        try {
            String result = template.postForObject(base.toString()+"/v1.0/flownotify/notifyList", buildEntity(appMap), String.class);
            System.out.println("-----询列表返回："+result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void selfList() {
        Map<String, Object> appMap = new HashedMap();

        try {
            String result = template.postForObject(base.toString()+"/v1.0/flownotify/selfList", buildEntity(appMap), String.class);
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

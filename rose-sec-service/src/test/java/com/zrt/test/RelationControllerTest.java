package com.zrt.test;

import com.alibaba.fastjson.JSON;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dwliu on 2017/9/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RelationControllerTest.class)
public class RelationControllerTest {


    private URL base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:9000");
        this.template = new TestRestTemplate();
    }

    /**
     * 更新
     *
     * @throws Exception
     *
     *
     */
    @Test
    public void relationUpdate() throws Exception {
        Map<String, Object> messageMap = new HashMap<String, Object>();
        messageMap.put("emp_id", "000012");
//        messageMap.put("manage_emp_id", "000020");
//        messageMap.put("manage_emp_name", "马镇2");
        messageMap.put("charge_emp_id", "000021");
        messageMap.put("charge_emp_name", "柴杨");
        String result = template.postForObject(base.toString() + "/v1.0/sec/relationUpdate", buildEntity(messageMap),
                String.class);
        System.out.println("-----信息更新返回：" + result);

    }

    @Test
    public void relationSearch() throws Exception {
        Map<String, Object> messageMap = new HashMap<String, Object>();
        messageMap.put("emp_id", "000012");

        String result = template.postForObject(base.toString() + "/v1.0/sec/relationSearch", buildEntity(messageMap),
                String.class);
        System.out.println("-----精确检索：" + result);

    }
    private HttpEntity<String> buildEntity(Map<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return new HttpEntity<String>(JSON.toJSONString(params), headers);
    }

}

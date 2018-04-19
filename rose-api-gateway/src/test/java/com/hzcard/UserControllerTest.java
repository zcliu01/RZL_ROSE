package com.hzcard;


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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserControllerTest.class)
public class UserControllerTest {

    private URL base;
    private RestTemplate template;


//	@Resource(name = "ribbonWrappedUserClient")
//	private UserClient userClient;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:9005");
        this.template = new TestRestTemplate();
    }

    @Test
    public void userList() throws Exception {
        Map<String, Object> messageMap = new HashMap<String, Object>();
        messageMap.put("pageNo", "0");
        messageMap.put("maxResult", "10");
        System.out.println(base.toString() + "/v1.0/sec/userList");
        System.out.println("--req json=" + buildEntity(messageMap));
        String result = template.postForObject(base.toString() + "/v1.0/sec/userList", buildEntity(messageMap), String.class);
        System.out.println("-----调用返回：" + result);


    }
    @Test
    public void file_upload() throws Exception {
    	Map<String, Object> messageMap = new HashMap<String, Object>();
    	messageMap.put("file_upload", "0");
    	messageMap.put("file_name", "10");
    	System.out.println(base.toString() + "/v1.0/file/uploadSingleFile");
    	System.out.println("--req json=" + buildEntity(messageMap));
    	String result = template.postForObject(base.toString() + "/v1.0/file/uploadSingleFile", buildEntity(messageMap), String.class);
    	System.out.println("-----调用返回：" + result);
    	
    	
    }

    @Test
    public void relationSearch() throws Exception {
        Map<String, Object> messageMap = new HashMap<String, Object>();
        messageMap.put("emp_id", "000014");
        System.out.println(base.toString() + "/v1.0/sec/relationSearch");
        System.out.println("--req json=" + buildEntity(messageMap));
        String result = template.postForObject(base.toString() + "/v1.0/sec/relationSearch", buildEntity(messageMap), String.class);
        System.out.println("-----调用返回：" + result);


    }


    private HttpEntity<String> buildEntity(Map<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return new HttpEntity<String>(JSON.toJSONString(params), headers);
    }

    @Test
    public void login() throws Exception {
        String result = template.postForObject("http://172.30.142.170/ucdisk/api/2.0/user/login?userName=admin&passWord=admin123&clientKey=0", null, String.class);
        System.out.println("-----调用返回：" + result);
        //{"code":0,"msg":null,"clientId":null,"notes":null,"body":{"pageNumber":0,"pageSize":0,"total":0,"bean":{"token":"743fbd34d1c98d3299aa3c840306e39f","userRootNodeId":"ff8080815c9e7f7a015ca04180cd0000","userId":"29bc1bd8-0bf6-4a64-943f-721fff065abf","userSafeNodeId":"ff8080815c9e7f7a015ca04180db0001"},"rows":[],"custom":{}}}
    }

    @Test
    public void websearch() throws Exception {
        String forObject = template.postForObject("http://172.30.142.170/ucdisk/api/2.0/solr/websearch?searchType=all&pageNumber=1&pageSize=10&token=743fbd34d1c98d3299aa3c840306e39f&keywords=ab", null, String.class);
        Map<String, Object> map = (Map<String, Object>) JSON.parse(forObject);
        System.out.println("-----调用返回：" + map.get("body"));
    }

}

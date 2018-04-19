package com.zrt.test;


import com.alibaba.fastjson.JSON;
import com.ronglian.ucsdk.model.ClientType;
import com.ronglian.ucsdk.model.LoginBean;
import com.ronglian.ucsdk.model.MessageBean;
import com.ronglian.ucsdk.service.SDKUserService;
import com.ronglian.ucsdk.util.SDKConfigUtil;
import org.apache.commons.lang3.StringUtils;
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
@SpringApplicationConfiguration(classes = FileControllerTest.class)
public class FileControllerTest {

    private URL base;
    private RestTemplate template;


//	@Resource(name = "ribbonWrappedUserClient")
//	private UserClient userClient;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://172.30.142.170/ucdisk/api/2.0");
        this.template = new TestRestTemplate();
    }

    private HttpEntity<String> buildEntity(Map<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return new HttpEntity<String>(JSON.toJSONString(params), headers);
    }

    @Test
    public void login() throws Exception {
        String result = template.postForObject(base.toString() + "/user/login?userName=admin&passWord=admin123&clientKey=0", null, String.class);
        System.out.println("-----调用返回：" + result);
        //{"code":0,"msg":null,"clientId":null,"notes":null,"body":{"pageNumber":0,"pageSize":0,"total":0,"bean":{"token":"743fbd34d1c98d3299aa3c840306e39f","userRootNodeId":"ff8080815c9e7f7a015ca04180cd0000","userId":"29bc1bd8-0bf6-4a64-943f-721fff065abf","userSafeNodeId":"ff8080815c9e7f7a015ca04180db0001"},"rows":[],"custom":{}}}
    }

    @Test
    public void websearch() throws Exception {
        String forObject = template.postForObject(base.toString() + "/solr/websearch?searchType=all&pageNumber=1&pageSize=10&token=743fbd34d1c98d3299aa3c840306e39f&keywords=ab", null, String.class);
        Map<String, Object> map = (Map<String, Object>) JSON.parse(forObject);
        System.out.println("-----调用返回：" + map.get("body"));
    }

    @Test
    public void nodeList() throws Exception {
        MessageBean<LoginBean> loginBean = login("");
        String token = loginBean.getBody().getBean().getToken();
        String userRootNodeId = loginBean.getBody().getBean().getUserRootNodeId();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> listMap = new HashMap<String, Object>();
        Map<String, Object> messageMap = new HashMap<String, Object>();
//        messageMap.put("nodeId", userRootNodeId);
//        messageMap.put("token", token);
//        messageMap.put("pageNumber", 1);
//        messageMap.put("pageSize", 50);
//        messageMap.put("subonly", true);
//        messageMap.put("type", "all");
//        messageMap.put("keyword", "");
//        System.out.println(JSON.toJSON(messageMap));
        String forObject = template.postForObject(base.toString() + "/node/list?nodeId="+userRootNodeId+"&token="+token+"&pageNumber=1&pageSize=50"+
                "&subonly=true&type=all", null, String.class);
		Map<String, Object> map =(Map<String, Object>) JSON.parse(forObject);
//        Object body =  map.get("body");
//		System.out.println("-----调用返回："+body);
        Map<String, Object> bodyMap = (Map<String, Object>) map.get("body");//JSON.parseObject(body, Map.class);
        resultMap.put("result",true);
        resultMap.put("count",bodyMap.get("total"));
        listMap.put("list",bodyMap.get("rows"));
        resultMap.put("data",listMap);
        System.out.println(JSON.toJSON(resultMap));
    }

    @Test
    public void deleteFile() throws Exception {
        MessageBean<LoginBean> loginBean = login("");
        String token = loginBean.getBody().getBean().getToken();
        String forObject = template.postForObject(base.toString() + "/node/delete?nodeId=ff8080815ec14524015ec1c96ec70002&token="+token, null, String.class);
//        Map<String, Object> map = (Map<String, Object>) JSON.parse(forObject);
        System.out.println("-----调用返回：" + forObject);
    }
    @Test
    public void downloadFile() throws Exception {
        MessageBean<LoginBean> loginBean = login("012631");
        String token = loginBean.getBody().getBean().getToken();
        byte[] forObject = template.getForObject(base.toString() + "/file/download?pos=0&nodeId=ff8080815ec14524015f0408cf350014&token="+token,  byte[].class);
//        Map<String, Object> map = (Map<String, Object>) JSON.parse(forObject);
        System.out.println("-----调用返回：" +new String(forObject));
    }

    public MessageBean<LoginBean> login(String account) throws Exception {
        SDKUserService userService = new SDKUserService();
        if (StringUtils.isEmpty(account)) {
            account = SDKConfigUtil.VIRTUAL_USER;
        }
        return userService.oaLogin(account, ClientType.WEB_APP, true);
    }

    public static void main(String[] args) {
        String fileName ="asdf.txt";
        System.out.println(fileName.lastIndexOf("."));
        System.out.println(fileName.substring(0,fileName.lastIndexOf("."))+"    "+fileName.substring(fileName.lastIndexOf(".")));
    }
}

//package com.hzcard.gateway.crm.web.label;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.TestRestTemplate;
//import org.springframework.boot.test.WebIntegrationTest;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.client.RestTemplate;
//
//import com.hzcard.gateway.ClientApplication;
//import com.hzcard.gateway.crm.client.label.LabelClient;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(value=ClientApplication.class)
//@WebIntegrationTest(randomPort=true)
//@DirtiesContext
//public class LabelTest {
//
//	Logger logger = LoggerFactory.getLogger(LabelTest.class);
//	@Value("${local.server.port}")
//    int port;
//	@Value("${spring.application.name}")
//    String applicationName;
//	@Resource
//	LoadBalancerClient loadBalancerClient;
////	@Resource
////	RestTemplate restTemplate;
//	@Resource
//	LabelClient labelClient;
//	
//	//@Test
//	public void testSearch(){
//		Map<String, Object> mapper = labelClient.search();
//		logger.debug("查询到的标签信息：{}", mapper);
//	}
//	
//	//@Test
//	public void testSearch2(){
//		HttpHeaders headers = new HttpHeaders();
////		headers.set("Accept-Encoding", "gzip");
//		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_UTF8_VALUE);
//        HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
//        
////        ServiceInstance si = loadBalancerClient.choose(applicationName);
////        logger.debug("找到一个服务：{}", si.getUri().toString());
//        
//        RestTemplate restTemplate = new TestRestTemplate();
//        ResponseEntity<Object> entity = restTemplate.exchange("http://localhost:" + this.port + "/v1.0/labels/search", 
//        		HttpMethod.GET, requestEntity, Object.class);
//        
//        assertEquals(HttpStatus.OK, entity.getStatusCode());
//        logger.debug("查询到的标签信息：{}", entity.getBody());
//	}
//}

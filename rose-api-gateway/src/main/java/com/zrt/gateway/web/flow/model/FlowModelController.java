package com.zrt.gateway.web.flow.model;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.flow.IFlowClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * 流程管理
 * 
 * @author:
 * @date:
 * @description TODO
 */

@RestController
public class FlowModelController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FlowModelController.class);
	@Resource(name = "HystrixFlowClient")
	private IFlowClient flowClient;

	/**
	 * 
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/model/{modelId}/json", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getEditorJson(@PathVariable String modelId) throws Exception {
 
        log.info("Server端的FlowModelController中getEditorJson方法");
        Map<String, Object> resultMap= flowClient.getEditorJson(modelId);
        
        return response(resultMap);
    }
    @RequestMapping(value = "/model/{modelId}/save", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveModel(@PathVariable String modelId,@RequestBody MultiValueMap<String, String> requestMap) throws Exception {
 
        log.info("Server端的FlowModelController中saveModel方法");
        Map<String, Object> resultMap= flowClient.saveModel(modelId,requestMap);
        
        return response(resultMap);
    }
    
    @RequestMapping(value = "/v1.0/model/new", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
    public ResponseEntity<String> newModel(@RequestBody Map<String, Object> requestMap) throws Exception {
 
        log.info("Server端的FlowModelController中newModel方法");
        Map<String, Object> resultMap= flowClient.newModel(requestMap);
        
        return response(resultMap);
    }
}

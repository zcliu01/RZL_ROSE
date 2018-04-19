package com.zrt.client.flow;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(FlowConstant.FLOW_INSTANCE)
public interface IFlowClient extends FlowConstant {

	@RequestMapping(value = FB_BUS_ROLE_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleSave(Map<String, Object> requestMap);
	
	@RequestMapping(value = FB_BUS_ROLE_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleUpdate(Map<String, Object> requestMap);
	
	@RequestMapping(value = FB_BUS_ROLE_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleDelete(Map<String, Object> requestMap);
	
	@RequestMapping(value = FB_BUS_USER_ROLE_SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleEmpAdd(Map<String, Object> requestMap);
	
	@RequestMapping(value = FB_BUS_USER_ROLE_DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleEmpDelete(Map<String, Object> requestMap);
	
	@RequestMapping(value = FB_ROLE_TEMPLATE_SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleFlowList(Map<String, Object> requestMap);
	
	@RequestMapping(value = FB_ROLE_TEMPLATE_SET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> roleFlowSet(Map<String, Object> requestMap);
	

}

package com.zrt.gateway.web.sec.relation;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.sec.ISecUserClient;
import com.zrt.gateway.web.base.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 员工领导关系
 * 
 * @author:dwliu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */
@RestController
@RequestMapping(value="/v1.0/sec", produces = { "application/json;charset=UTF-8" })
public class SecRelationController extends BaseController{

	@Resource(name = "HystrixSecUserClient")
	private ISecUserClient secUserClient;
	

	/**
	 * 员工领导关系查询
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/relationSearch",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> relationSearch(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.relationSearch(requestMap);
		return response(resultMap);
	}


	/**
	 * 员工领导关系修改
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/relationUpdate",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> relationUpdate(@RequestBody Map<String, Object> requestMap) throws Exception {
		Map<String,Object>  resultMap = secUserClient.relationUpdate(requestMap);
		return response(resultMap);
	}

}

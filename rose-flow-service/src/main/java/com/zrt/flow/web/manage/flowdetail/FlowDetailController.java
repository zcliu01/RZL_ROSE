package com.zrt.flow.web.manage.flowdetail;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.flow.service.flowdeatil.FlowDetailService;

@RestController
@RequestMapping("/v1.0/flowDetail")
public class FlowDetailController {
	private static final Logger log = LoggerFactory.getLogger(FlowDetailController.class);

	@Autowired
	private FlowDetailService flowDetailService;

	/**
	 * 审批详情
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/inst", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> inst(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowDetailController中inst方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = flowDetailService.getFlowDetail(map);
			resultMap.data(resMap);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			return resultMap.failure().errmsg(e.getMessage()).errcode(301).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("审批详情查询失败!").map();
		}
	}

	/**
	 * 预处理详情
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/preInst", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> preInst(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FlowDetailController中preInst方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = flowDetailService.preInstDetail(map);
			resultMap.data(resMap);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("审批详情查询失败!").map();
		}
	}

}

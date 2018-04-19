package com.zrt.flow.web.manage.flowAction;

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
import com.zrt.flow.service.flowAction.FlowActionService;

@RestController
@RequestMapping("/v1.0/flowAction")
public class FlowActionController {
	private static final Logger log = LoggerFactory.getLogger(FlowActionController.class);

	@Autowired
	private FlowActionService flowActionService;

	/**
	 * 流程删除
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的FlowActionController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {

			flowActionService.delete(appMap);
			resultMap.success().sucmsg("流程删除成功！");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程删除失败!").map();
		}
	}
	/**
	 * 流程删除
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/end", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> end(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的FlowActionController中end方法");
		ResultMap resultMap = new ResultMap();
		try {
			
			flowActionService.end(appMap);
			resultMap.success().sucmsg("流程终止成功！");
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程终止失败!").map();
		}
	}

}

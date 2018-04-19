package com.zrt.flow.web.manage.flowoper;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.commons.date.DateUtil;
import com.zrt.flow.service.flowoper.FlowoperService;

@RestController
@RequestMapping("/v1.0/flowoper")
public class FlowoperController {
	private static final Logger log = LoggerFactory.getLogger(FlowoperController.class);

	@Resource(name="flowoperServiceImp")
	private FlowoperService flowoperService;
	/**
	 * 管理员查看所有的流程实例
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/flowList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> flowList(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的FlowoperController中flowList方法");
		ResultMap resultMap=new ResultMap();
		try {
			//格式化查询时间
			//appMap.put("begin_start_date_time", DateUtil.getFormatFormat((String)appMap.get("begin_start_date_time")));
			//appMap.put("end_start_date_time", DateUtil.getFormatFormat((String)appMap.get("begin_start_date_time")));
			Map<String, Object> resMap=flowoperService.flowList(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		}catch(AppException e){
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch(Exception e){
			log.error(" error", e);
			return resultMap.failure().errmsg("流程列表查询失败!").map();
		}
	}
    
    
	/**
	 * 管理员查看流程委托查询列表
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/entList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> entList(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的FlowoperController中entList方法");
		ResultMap resultMap=new ResultMap();
		try {
			//格式化查询时间
			if (StringUtils.isNotBlank((String)appMap.get("begin_start_date_time"))) {
	  			appMap.put("begin_start_date_time", ((String)appMap.get("begin_start_date_time")).replace("-", "")+"000000");
			}
	  		if (StringUtils.isNotBlank((String)appMap.get("end_start_date_time"))) {
	  			appMap.put("end_start_date_time", ((String)appMap.get("end_start_date_time")).replace("-", "")+"235959");
	  		}
			Map<String, Object> resMap=flowoperService.entrustList(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		}catch(AppException e){
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch(Exception e){
			log.error(" error", e);
			return resultMap.failure().errmsg("流程委托查询失败!").map();
		}
	}
    
    
	/**
	 * 管理员查看所有的流程实例
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
    @RequestMapping(value="/operPreList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> operPreList(@RequestBody Map<String, Object> appMap) throws Exception{
		log.info("Server端的FlowoperController中operPreList方法");
		ResultMap resultMap=new ResultMap();
		try {
			//格式化查询时间
		//	appMap.put("begin_start_date_time", DateUtil.getFormatFormat((String)appMap.get("begin_start_date_time")));
		//	appMap.put("end_start_date_time", DateUtil.getFormatFormat((String)appMap.get("begin_start_date_time")));
			Map<String, Object> resMap=flowoperService.preList(appMap);
			resultMap.data(resMap.get("data"));
			resultMap.success().map().put("count", resMap.get("count"));
			return resultMap.map();
		}catch(AppException e){
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		}catch(Exception e){
			log.error(" error", e);
			return resultMap.failure().errmsg("流程预处理失败!").map();
		}
	}
    
   
}

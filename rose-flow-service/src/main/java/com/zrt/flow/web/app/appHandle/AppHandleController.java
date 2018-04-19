package com.zrt.flow.web.app.appHandle;

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
import com.zrt.flow.service.handle.HandleService;

@RestController
@RequestMapping("/v1.0/appHandle")
public class AppHandleController {
	private static final Logger log = LoggerFactory.getLogger(AppHandleController.class);

	@Autowired
	private HandleService handleService;

	/**
	 * 签报类流程发起
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/handleApply", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> handleApply(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的HandleController中handleApply方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resData = handleService.handleApply(appMap);
			resultMap.success().sucmsg("该申请已发起");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("流程发起失败!").map();
		}
	}

	/**
	 * 签报类流程审批
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/handleCheck", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> handleCheck(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的HandleController中handleCheck方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resData = handleService.handleCheck(appMap);
			resultMap.success().sucmsg("审批成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("审批失败!").map();
		}
	}

	/**
	 * 签报类流程审批
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> detail(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的HandleController中detail方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resData = handleService.detail(appMap);
			resultMap.success().sucmsg("签报详情查询成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).errcode(301).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("签报详情查询失败!").map();
		}
	}

	/**
	 * 签报类流程终结
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/handleEnd", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> handleEnd(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的HandleController中handleEnd方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resData = handleService.handleEnd(appMap);
			resultMap.success().sucmsg("签报办结成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("签报办结失败!").map();
		}
	}

	/**
	 * 签报类流程草稿保存
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/draftSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> draftSave(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的HandleController中draftSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resData = handleService.draftSave(appMap);
			resultMap.success().sucmsg("保存成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("保存失败!").map();
		}
	}

	/**
	 * 签报类流程草稿更新
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/draftUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> draftUpdate(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的HandleController中draftUpdate方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resData = handleService.draftUpdate(appMap);
			resultMap.success().sucmsg("更新成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("更新失败!").map();
		}
	}

	/**
	 * 签报类流程草稿提交
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/draftApply", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> draftApply(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的HandleController中draftApply方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resData = handleService.draftApply(appMap);
			resultMap.success().sucmsg("提交成功");
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("提交失败!").map();
		}
	}

	/**
	 * 是否已签报
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/isHandle", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> isHandle(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("Server端的HandleController中isHandle方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> resData = handleService.isHandle(appMap);
			resultMap.success().data(resData);
			return resultMap.map();
		} catch (AppException e) {
			log.error(" error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error(" error", e);
			return resultMap.failure().errmsg("查询是否签报失败!").map();
		}
	}

}

package com.zrt.flow.web.manage.fbtemp;

import java.util.List;
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
import com.zrt.flow.service.fbTemp.FbTempService;

@RestController
@RequestMapping("/v1.0/fbtemp")
public class FbTempController {
	private static final Logger log = LoggerFactory.getLogger(FbTempController.class);

	@Autowired
	private FbTempService fbTempService;

	/**
	 * 流程列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中list方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = fbTempService.getFormList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程列表查询失败!").map();
		}
	}

	/**
	 * 流程新增
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> dicAdd(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中save方法");
		ResultMap resultMap = new ResultMap();
		try {
			fbTempService.save(map);
			resultMap.success().sucmsg("流程新增成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程新增失败!").map();
		}
	}

	/**
	 * 流程明细
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中search方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> data = fbTempService.getFormDetail(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程明细查询失败!").map();
		}
	}

	/**
	 * 表单更新
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> update(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中update方法");
		ResultMap resultMap = new ResultMap();
		try {
			fbTempService.update(map);
			resultMap.success().sucmsg("流程更新成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程更新失败!").map();
		}
	}

	/**
	 * 流程删除
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> idMap : list) {
					fbTempService.delete(idMap);
				}
			}
			resultMap.success().sucmsg("流程删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程删除失败!").map();
		}
	}

	/**
	 * 流程启用
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/open", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> open(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中open方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> idMap : list) {
					idMap.put("t_enabled", "1");
					fbTempService.openOrClose(idMap);
				}
			}
			resultMap.success().sucmsg("流程启用成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程启用失败!").map();
		}
	}

	/**
	 * 表单关闭
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/close", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> close(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中close方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> idMap : list) {
					idMap.put("t_enabled", "0");
					fbTempService.openOrClose(idMap);
				}
			}

			resultMap.success().sucmsg("流程关闭成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程关闭失败!").map();
		}
	}

	/**
	 * 流程绑定表单查询
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/formList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> formList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中formList方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> data = fbTempService.getFbFmList(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程绑定表单查询失败!").map();
		}
	}

	/**
	 * 流程绑定表单
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/formSave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> formSave(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中formSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			fbTempService.formSave(map);
			resultMap.success().sucmsg("流程绑定成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程绑定失败!").map();
		}
	}
	
	/**
	 * 流程提醒人查询
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/notifyList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> notifyList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中notifyList方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> data = fbTempService.notifyList(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程查询提醒人失败!").map();
		}
	}
	
	/**
	 * 流程设置提醒人
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/notify", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> notify(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTempController中notify方法");
		ResultMap resultMap = new ResultMap();
		try {
			fbTempService.notify(map);
			resultMap.success().sucmsg("设置成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("设置失败!").map();
		}
	}

}

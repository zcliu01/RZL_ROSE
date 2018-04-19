package com.zrt.flow.web.manage.fbType;

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
import com.zrt.flow.service.fbType.FbTypeService;

@RestController
@RequestMapping("/v1.0/fbtype")
public class FbTypeController {
	private static final Logger log = LoggerFactory.getLogger(FbTypeController.class);

	@Autowired
	private FbTypeService fbTypeService;

	/**
	 * 流程分类列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTypeController中list方法");
		ResultMap resultMap = new ResultMap();
		try {

			List<Map<String, Object>> data = fbTypeService.getFmTypeList(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程分类列表查询失败!").map();
		}
	}

	/**
	 * 流程分类新增
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> dicAdd(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTypeController中save方法");
		ResultMap resultMap = new ResultMap();
		try {
			fbTypeService.save(map);
			resultMap.success().sucmsg("流程分类新增成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程分类新增失败!").map();
		}
	}

	/**
	 * 流程分类明细
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTypeController中search方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> data = fbTypeService.getFmTypeDetail(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程分类明细查询失败!").map();
		}
	}

	/**
	 * 流程分类更新
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> update(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTypeController中update方法");
		ResultMap resultMap = new ResultMap();
		try {
			fbTypeService.update(map);
			resultMap.success().sucmsg("表单分类更新成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程分类更新失败!").map();
		}
	}

	/**
	 * 流程分类删除
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FbTypeController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			fbTypeService.delete(map);
			resultMap.success().sucmsg("流程分类删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("流程分类删除失败!").map();
		}
	}

}

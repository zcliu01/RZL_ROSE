package com.zrt.flow.web.manage.fmDic;

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
import com.zrt.flow.service.fmDic.FmDicService;

@RestController
@RequestMapping("/v1.0/fmdic")
public class FmDicController {
	private static final Logger log = LoggerFactory.getLogger(FmDicController.class);

	@Autowired
	private FmDicService fmDicService;

	/**
	 * 字典列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FmDicController中list方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> resMap = fmDicService.getFmDicList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("字典列表查询失败!").map();
		}
	}

	/**
	 * 字典新增
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> dicAdd(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FmDicController中save方法");
		ResultMap resultMap = new ResultMap();
		try {
			fmDicService.save(map);
			resultMap.success().sucmsg("字典新增成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("字典新增失败!").map();
		}
	}

	/**
	 * 字典明细查询
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FmDicController中search方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> data = fmDicService.getFormDetail(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("字典明细查询失败!").map();
		}
	}

	/**
	 * 字典更新
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> update(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FmDicController中update方法");
		ResultMap resultMap = new ResultMap();
		try {
			fmDicService.update(map);
			resultMap.success().sucmsg("字典更新成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("字典更新失败!").map();
		}
	}

	/**
	 * 字典删除
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FmDicController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			fmDicService.delete(map);
			resultMap.success().sucmsg("字典删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("字典删除失败!").map();
		}
	}

}

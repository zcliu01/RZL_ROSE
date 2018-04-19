package com.zrt.flow.web.manage.form;

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
import com.zrt.flow.service.form.FormService;

@RestController
@RequestMapping("/v1.0/fmform")
public class FormController {
	private static final Logger log = LoggerFactory.getLogger(FormController.class);

	@Autowired
	private FormService formService;

	/**
	 * 表单列表
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中list方法");
		ResultMap resultMap = new ResultMap();
		try {
            //获取t_enabled
			String enebled=(String)map.get("t_enabled");
			if(enebled==null || "".equals(enebled)){
				//如果为空就默认查0,1状态的
				map.put("t_enabled", new String[]{"0","1"});
			}else{
				
				map.put("t_enabled", new String[]{enebled});
			}
			Map<String, Object> resMap = formService.getFormList(map);
			resultMap.success().map().put("count", resMap.get("count"));
			resultMap.data(resMap.get("data"));
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单列表查询失败!").map();
		}
	}

	/**
	 * 表单新增
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> dicAdd(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中save方法");
		ResultMap resultMap = new ResultMap();
		try {
			formService.save(map);
			resultMap.success().sucmsg("表单新增成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单新增失败!").map();
		}
	}

	/**
	 * 表单明细
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中search方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> data = formService.getFormDetail(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单明细查询失败!").map();
		}
	}

	/**
	 * 表单更新
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> update(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中update方法");
		ResultMap resultMap = new ResultMap();
		try {
			formService.update(map);
			resultMap.success().sucmsg("表单更新成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单更新失败!").map();
		}
	}

	/**
	 * 表单删除
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			formService.delete(map);
			resultMap.success().sucmsg("表单删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单删除失败!").map();
		}
	}

	/**
	 * 表单启用
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/openform", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> openform(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中openform方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> idMap : list) {
					idMap.put("t_enabled", "1");
					formService.openOrCloseform(idMap);
				}
			}
			resultMap.success().sucmsg("表单启用成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单启用失败!").map();
		}
	}

	/**
	 * 表单关闭
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/closeform", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> closeform(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中closeform方法");
		ResultMap resultMap = new ResultMap();
		try {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("param");
			if (list != null && list.size() > 0) {
				for (Map<String, Object> idMap : list) {
					idMap.put("t_enabled", "0");
					formService.openOrCloseform(idMap);
				}
			}

			resultMap.success().sucmsg("表单关闭成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单关闭失败!").map();
		}
	}
	/**
	 * 表单元素详情
	 * 
	 * @param jsonMap
	 * @return
	 * @throws AppException
	 */
	@RequestMapping(value = "/formdeail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> formdeail(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中formdeail方法");
		ResultMap resultMap = new ResultMap();
		try {

			Map<String, Object> data = formService.getFormElementDetail(map);
			resultMap.data(data);
			resultMap.success();
			return resultMap.map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单元素详情查询失败!").map();
		}
	}
	/**
	 * 表单元素保存
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/formsave", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> formsave(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的FormController中formsave方法");
		ResultMap resultMap = new ResultMap();
		try {
			formService.formsave(map);
			resultMap.success().sucmsg("表单元素保存成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("表单元素保存失败!").map();
		}
	}

	
}

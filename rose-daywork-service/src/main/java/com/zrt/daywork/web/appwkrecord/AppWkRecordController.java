package com.zrt.daywork.web.appwkrecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.daywork.service.wkrecord.WkRecordService;

@RestController
@RequestMapping("/v1.0/appdaywork")
public class AppWkRecordController {
	private static final Logger log = LoggerFactory.getLogger(AppWkRecordController.class);
	@Resource(name = "wkRecordServiceImpl")
	private WkRecordService wkRecordService;

	// 新建日程
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> save(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的WkRecordController中userSave方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 日程新增
			int save = wkRecordService.save(map);
			if (save==120) {
				return resultMap.failure().errmsg("日程名称不能为空!").map();
			}
			if (save==130) {
				return resultMap.failure().errmsg("日程日期输入有误,开始时间须小于结束时间!").map();
			}
			resultMap.success().sucmsg("新建成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("日程新建失败!").map();

		}
	}

	// 删除日程
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的WkRecordController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 日程删除
			wkRecordService.delete(map);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("日程删除失败!").map();

		}
	}
	// 删除日程
	@RequestMapping(value = "/deleteList", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> deleteList(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的WkRecordController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 日程删除
			wkRecordService.deleteList(map);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("日程删除失败!").map();
			
		}
	}

	// 查询日程详情
	@RequestMapping(value = "/detail", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> detail(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的WkRecordController中detail方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 日程详情查询
			Map<String, Object> data = wkRecordService.detail(map);
			resultMap.data(data);
			resultMap.success().sucmsg("查询成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("日程查询失败!").map();

		}
	}

	// 更新日程
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> update(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的WkRecordController中update方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 日程更新
			wkRecordService.update(map);
			resultMap.success().sucmsg("更新成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("日程更新失败!").map();

		}
	}

	// 查询日程列表
	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的WkRecordController中list方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 日程列表查询
			List<Map<String, Object>> dataList = wkRecordService.list(map);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("list", dataList);
			resultMap.data(dataMap);
			resultMap.success().sucmsg("查询成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("日程列表查询失败!").map();

		}
	}
	
	
	//查询全部日程
			@RequestMapping(value = "/checkAll", method = RequestMethod.POST, headers = "Accept=application/json")
			public Map<String, Object> checkAll(@RequestBody Map<String, Object> map) throws Exception {
				log.info("Server端的WkRecordController中checkAll方法");
				ResultMap resultMap = new ResultMap();
				try {
					// 日程列表查询
					 Map<String, Object> checkAll = wkRecordService.checkAll(map);
					resultMap.data(checkAll);
					resultMap.success().sucmsg("全部日程查询成功!");
					return resultMap.map();
				} catch (AppException e) {
					log.error("json error", e);
					return resultMap.failure().errmsg(e.getMessage()).map();
				} catch (Exception e) {
					log.error("json error", e);
					return resultMap.failure().errmsg("日程列表查询失败!").map();

				}
			}
			
			
		//查询所有日期
		@RequestMapping(value = "/searchDate", method = RequestMethod.POST, headers = "Accept=application/json")
		public Map<String, Object> searchDate(@RequestBody Map<String, Object> map) throws Exception {
			log.info("Server端的WkRecordController中searchDate方法");
			ResultMap resultMap = new ResultMap();
			try {
				// 日程列表查询
				Set<String> searchDate = wkRecordService.searchDate(map);
				resultMap.data(searchDate);
				resultMap.success().sucmsg("所有日期查询成功!");
				return resultMap.map();
			} catch (AppException e) {
				log.error("json error", e);
				return resultMap.failure().errmsg(e.getMessage()).map();
			} catch (Exception e) {
				log.error("json error", e);
				return resultMap.failure().errmsg("所有日期查询失败!").map();
				
			}
		}

}

package com.zrt.task.web.manage;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.task.service.task.TaskService;


@RestController
@RequestMapping("/v1.0/task")
public class TaskController {
	private static final Logger log = LoggerFactory.getLogger(TaskController.class);
	@Resource(name="taskServiceImpl")
	private TaskService taskService;
	
	
	/**
	 * 新建任务
	 * 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> add(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中add方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 新建任务
			int add = taskService.add(map);
			if (add == 2) {
				return resultMap.failure().errmsg("任务新建失败,任务名称不能为空!").map();
			}
			if (add == 3) {
				return resultMap.failure().errmsg("任务新建失败,任务开始时间未填!").map();
			}
			if (add == 4) {
				return resultMap.failure().errmsg("任务新建失败,任务结束时间不能为空!").map();
			}
			if (add == 5) {
				return resultMap.failure().errmsg("任务新建失败,任务执行人不能为空").map();
			}
			resultMap.success().sucmsg("新建成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("任务新建失败!").map();

		}
	}
	
	
	/**
	 * 删除任务
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> delete(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中delete方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 新建任务
			taskService.delete(map);
			resultMap.success().sucmsg("删除成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("任务删除失败!").map();
			
		}
	}
	
	
	
	/**
	 * 修改任务
	 * 
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> change(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中change方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 新建任务
			int change = taskService.change(map);
			if (change==2) {
				return resultMap.failure().errmsg("任务修改失败,请核对执行人列表!").map();
			}
			if (change == 6) {
				return resultMap.failure().errmsg("任务修改失败,任务名称不能为空!").map();
			}
			if (change == 3) {
				return resultMap.failure().errmsg("任务修改失败,任务开始时间未填!").map();
			}
			if (change == 4) {
				return resultMap.failure().errmsg("任务修改失败,任务结束时间不能为空!").map();
			}
			if (change == 5) {
				return resultMap.failure().errmsg("任务修改失败,任务执行人不能为空").map();
			}
			resultMap.success().sucmsg("修改成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("任务修改失败!").map();
			
		}
	} 
	
	
	/**
	 * 分配任务
	 * 
	 */
	@RequestMapping(value = "/callChild", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> callChild(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中callChild方法");
		ResultMap resultMap = new ResultMap();
		try {
			// 新建任务
			taskService.callChild(map);
			resultMap.success().sucmsg("分配成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("任务分配失败!").map();

		}
	} 
	
	
	/**
	 * 任务列表查询
	 * @param map
	 * @param emp_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/webSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> search(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中webSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> search = taskService.webSearch(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("webSearch任务列表查询成功!");
			System.out.println(resultMap.map());
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("webSearch任务列表查询失败!").map();

		}
	}
	
	
	/**
	 * 
	 * 查看任务详情
	 *
	 */
	@RequestMapping(value = "/searchInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> searchInfo(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中searchInfo方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> searchInfo = taskService.searchInfo(map);
			resultMap.data(searchInfo);
			resultMap.success().sucmsg("查询任务详情成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("任务详情查询失败!").map();

		}
	}
	
	
	
	/**
	 * 
	 * 任务终止
	 *
	 */
	@RequestMapping(value = "/stop", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> stop(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中stop方法");
		ResultMap resultMap = new ResultMap();
		try {
			int stopStart = taskService.stop(map);
			if(stopStart==2){
				return	resultMap.failure().errmsg("该任务已终止!").map();
			}
			if(stopStart==3){
				return	resultMap.failure().errmsg("该任务已完成!").map();
			}
			/*if(stopStart==4){
				return	resultMap.failure().errmsg("该任务为分配任务,不能进行终止!").map();
			}*/
			resultMap.success().sucmsg("任务结束!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("任务终止或完成失败!").map();
			
		}
	}
	
	
	
	/**
	 * 
	 * 任务反馈
	 *
	 */
	@RequestMapping(value = "/backInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> backInfo(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中backInfo方法");
		ResultMap resultMap = new ResultMap();
		try {
			int backInfo = taskService.backInfo(map);
			if (backInfo==1) {
				resultMap.success().sucmsg("任务反馈成功!");
			}else{
				resultMap.failure().errmsg("任务反馈百分比书写不正确!");
			}
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("任务反馈失败!").map();
			
		}
	}
	
	
	/**
	 * 待办任务查询
	 * @param map
	 * @param emp_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/todoSearch", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> todoSearch(@RequestBody Map<String, Object> map) throws Exception {
		log.info("Server端的TaskController中todoSearch方法");
		ResultMap resultMap = new ResultMap();
		try {
			Map<String, Object> search = taskService.todoSearch(map);
			resultMap.success().map().put("count", search.get("count"));
			resultMap.data(search.get("data"));
			resultMap.success().sucmsg("待办任务列表查询成功!");
			return resultMap.map();
		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("待办任务列表查询失败!").map();

		}
	}

}

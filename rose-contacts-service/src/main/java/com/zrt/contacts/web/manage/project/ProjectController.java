package com.zrt.contacts.web.manage.project;

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
import com.zrt.contacts.service.project.ProjectService;

/**
 * 
 * @description 项目列表服务
 * @author wwfu
 *
 */
@RestController
@RequestMapping("/v1.0/project")
public class ProjectController {
	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
		log.info("ProjectController中list方法");
		ResultMap resultMap = new ResultMap();

		try {

			Map<String, Object> resMap=projectService.projectList(map);
			resultMap.map().put("count", resMap.get("count"));
			resultMap.success().data(resMap.get("data"));
			return resultMap.map();

		} catch (AppException e) {
			log.error("json error", e);
			return resultMap.failure().errmsg(e.getMessage()).map();
		} catch (Exception e) {
			log.error("json error", e);
			return resultMap.failure().errmsg("添加常用联系人页面初始化失败!").map();
		}
	}

}

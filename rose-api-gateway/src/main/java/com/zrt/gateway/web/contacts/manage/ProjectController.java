package com.zrt.gateway.web.contacts.manage;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.contacts.IContactsClient;
import com.zrt.gateway.web.base.BaseController;

	@RestController
	@RequestMapping(value = "/v1.0/project", produces = { "application/json;charset=UTF-8" })
	public class ProjectController extends BaseController {
		private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
		@Resource(name = "HystrixContactsClient")
		private IContactsClient ContactsClient;

		/**
		 * 项目列表列表
		 * 
		 * @param requestMap
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
		@ResponseBody
		public ResponseEntity<String> list(@RequestBody Map<String, Object> requestMap)
				throws Exception {
			log.info("Server端的ProjectController中list方法");
			Map<String, Object> resultMap = ContactsClient.projectList(requestMap);
			return response(resultMap);
		}

}

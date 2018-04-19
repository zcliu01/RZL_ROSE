package com.zrt.vif.service.orgLIst;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.client.contacts.IContactsClient;

@Service
public class OrgListService {
	private final transient Logger logger = LoggerFactory.getLogger(OrgListService.class);

	@Autowired
	private IContactsClient iContactsClient;

	public Map<String, Object> orgAllList(Map<String, Object> map) throws Exception {
		logger.info("vif服务调用Contacts服务orgAllList接口！");
		Map<String, Object> result = iContactsClient.orgAllList(map);
		return result;
	}

	public Map<String, Object> ypEmpList(Map<String, Object> map) throws Exception {
		logger.info("vif服务调用Contacts服务ypEmpList接口！");
		Map<String, Object> result = iContactsClient.ypEmpList(map);
		return result;
	}

}

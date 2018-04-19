package com.zrt.vif.service.contacts;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.contacts.IContactsClient;

@Service
public class ContactsServiceImpl implements ContactsService {
	private final transient Logger logger = LoggerFactory.getLogger(ContactsServiceImpl.class);

	@Resource(name = "HystrixContactsClient")
	private IContactsClient iContactsClient;

	@Override
	public Map<String, Object> searchAll(Map<String, Object> map) {
		logger.info("从contacts服务中获取所有员工的id");
		Map<String, Object> result = iContactsClient.searchAll(map);
		return result;
	}
}

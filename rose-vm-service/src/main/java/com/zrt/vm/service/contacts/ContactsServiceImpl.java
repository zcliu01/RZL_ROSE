package com.zrt.vm.service.contacts;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.contacts.IContactsClient;
import com.zrt.vm.service.serial.SerialService;

@Service
public class ContactsServiceImpl implements ContactsService {
	private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);

	@Resource(name = "HystrixContactsClient")
	private IContactsClient iContactsClient;

	@Override
	public Map<String, Object> commonEmpSearch(Map<String, Object> map) {
		logger.info("从contacts服务中获取员工的员工姓名、组织机构id和组织机构名称");
		Map<String, Object> result = iContactsClient.commonEmpSearch(map);
		return result;
	}

	@Override
	public Map<String, Object> meetEmpInfo(Map<String, Object> map) {
		logger.info("从contacts服务中获取参加会议中的员工姓名、组织机构id和组织机构名称");
		Map<String, Object> result = iContactsClient.meetEmpInfo(map);
		return result;
	}

	@Override
	public Map<String, Object> getRedis(Map<String, Object> map) {
		logger.info("从contacts服务中获取redis的员工信息");
		Map<String, Object> result = iContactsClient.getRedis(map);
		return result;
	}
}

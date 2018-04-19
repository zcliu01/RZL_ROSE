package com.zrt.contacts.service.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.zrt.commons.AppException;
import com.zrt.contacts.mapper.empsearchwindow.EmpSearchWindowCustomMapper;
import com.zrt.contacts.service.redis.RedisService;

/**
 * Created by msKui on 2017/3/3.
 */
@Service
public class SetRedis {

	private static final Logger log = LoggerFactory.getLogger(SetRedis.class);

	@Autowired
	private EmpSearchWindowCustomMapper empSearchWindowCustomMapper;
	@Autowired
	private RedisService redisService;

	@Scheduled(cron = "${contacts.setRedis.time}") // 每天1点执行一次
	public void setRedis() throws AppException {

		Map<String, Object> resMap = new HashMap<String, Object>();

		List<Map<String, Object>> empList = empSearchWindowCustomMapper.setRedis();

		List<Map<String, Object>> redisList = new ArrayList<Map<String, Object>>();
		if (empList != null && empList.size() > 0) {
			for (Map<String, Object> empMap : empList) {
				Map<String, Object> redisMap = new HashMap<String, Object>();
				Map<String, Object> infoMap = new HashMap<String, Object>();
				infoMap.put("emp_code", empMap.get("emp_code"));
				infoMap.put("emp_head_photo", empMap.get("emp_head_photo"));
				infoMap.put("org_id", empMap.get("org_id"));
				infoMap.put("emp_name", empMap.get("emp_name"));
				infoMap.put("emp_order", empMap.get("emp_order"));
				infoMap.put("org_name", empMap.get("org_name"));
				infoMap.put("org_name_all", empMap.get("org_name_all"));
				infoMap.put("org_name_owner", empMap.get("org_name_owner"));
				infoMap.put("emp_sl", empMap.get("emp_sl"));
				infoMap.put("emp_py", empMap.get("emp_py"));
				infoMap.put("emp_active", empMap.get("emp_active"));
				redisMap.put((String) empMap.get("emp_id"), infoMap);
				redisList.add(redisMap);
			}

		}

		resMap.put("empInfoList", redisList);

		redisService.setInfo("contacts:empInfoList", "empInfoList", resMap);
		log.info("员工信息setRedis成功！");
	}

	public Map<String, Object> getRedis() {
		Map<String, Object> resMap = redisService.getInfo("contacts:empInfoList", "empInfoList");

		return resMap;
	}

}

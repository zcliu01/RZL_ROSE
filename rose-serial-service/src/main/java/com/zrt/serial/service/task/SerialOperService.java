package com.zrt.serial.service.task;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.serial.mapper.serial.SerialMapper;

/**
 * 每天凌晨0:00更新序列号
 * @author wwfu
 *
 */
@Service
public class SerialOperService {
	private static final Logger log = LoggerFactory.getLogger(SerialOperService.class);
	@Autowired
	private SerialMapper serialMapper;
	
	@Scheduled(cron = "${serial.reset.timer}") // 每天0点执行一次
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void serialUpdate() throws Exception{
		log.info("开始更新流程实例编号归0");
		//更新流程实例编号为0
		Map serialMap = new HashMap();
		serialMap.put("biz_key", "flow_inst_code");
		serialMap.put("biz_serial_no", 0);
		serialMapper.serialUpdate(serialMap);
	}
}

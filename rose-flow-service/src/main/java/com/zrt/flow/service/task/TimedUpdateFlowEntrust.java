package com.zrt.flow.service.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.date.DateUtil;
import com.zrt.mybatis.domain.FbBusEntrust;
import com.zrt.mybatis.domain.FbBusEntrustExample;
import com.zrt.mybatis.mapper.FbBusEntrustMapper;

@Service
public class TimedUpdateFlowEntrust {

	private static final Logger log = LoggerFactory.getLogger(TimedUpdateFlowEntrust.class);
	@Autowired
	private FbBusEntrustMapper fbBusEntrustMapper;

	@Scheduled(cron = "${flow.updateEntrust.time}") // 每天0点执行一次
	@Transactional(rollbackFor = { Throwable.class }, propagation = Propagation.REQUIRED)
	public void updateEntrust() throws InterruptedException {

		log.info("修改委托状态定时任务开始执行！");
		FbBusEntrustExample entExample = new FbBusEntrustExample();
		entExample.createCriteria().andEntEnabledEqualTo("1");
		List<FbBusEntrust> entList = fbBusEntrustMapper.selectByExample(entExample);
		if (null != entList && !entList.isEmpty()) {
			FbBusEntrustExample example = new FbBusEntrustExample();
			String curDate = DateUtil.getCurrentDateTime();
			example.createCriteria().andEndDateTimeLessThanOrEqualTo(curDate);

			FbBusEntrust fbBusEntrust = new FbBusEntrust();
			fbBusEntrust.setEntEnabled("0");// 0：禁用
			fbBusEntrustMapper.updateByExampleSelective(fbBusEntrust, example);
		}

		log.info("修改委托状态定时任务执行结束！");

	}
}

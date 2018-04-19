package com.zrt.flow.service.flowdeatil;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zrt.commons.AppException;
import com.zrt.flow.service.handle.HandleService;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.domain.FbBusTemplate;
import com.zrt.mybatis.mapper.FbBusInstMapper;
import com.zrt.mybatis.mapper.FbBusTemplateMapper;

@Service
public class FlowDetailServiceImpl implements FlowDetailService {

	@Autowired
	private CommonDetailService commonDetailService;
	@Autowired
	private FbBusTemplateMapper fbBusTemplateMapper;
	@Autowired
	private FbBusInstMapper fbBusInstMapper;
	@Autowired
	private HandleService handleService;

	/**
	 * 我发起的详情
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getFlowDetail(Map<String, Object> map) throws Exception {

		Map<String, Object> resMap = new HashMap<String, Object>();
		String instId = (String) map.get("inst_id");
		if (StringUtils.isBlank(instId)) {
			throw new AppException("该流程已撤销！");
		}
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		String instStatus = fbBusInst.getInstStatus();
		if ("0".equals(instStatus)) {
			throw new AppException("该流程已撤销！");
		}
		// 判断该信息详情是否是签报类
		FbBusTemplate fbBusTemplate = fbBusTemplateMapper.selectByPrimaryKey(fbBusInst.getFbId());

		// 获取是否签报类
		String handleFlag = fbBusTemplate.getHandleFlag();

		if ("1".equals(handleFlag)) {
			resMap = handleService.detail(map);
		} else {
			Map<String, Object> detailMap = commonDetailService.flowDetail(map);
			Map<String, Object> doDetailMap = commonDetailService.doDetailList(map);
			resMap.putAll(detailMap);
			resMap.putAll(doDetailMap);
		}

		return resMap;
	}

	/**
	 * 预处理详情
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> preInstDetail(Map<String, Object> map) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		Map<String, Object> detailMap = commonDetailService.flowDetail(map);
		Map<String, Object> doDetailMap = commonDetailService.doDetailList(map);
		resMap.putAll(detailMap);
		resMap.putAll(doDetailMap);
		return resMap;
	}

}

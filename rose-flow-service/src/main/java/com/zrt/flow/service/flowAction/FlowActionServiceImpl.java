package com.zrt.flow.service.flowAction;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.mapper.FbBusInstMapper;

@Service
public class FlowActionServiceImpl implements FlowActionService {
	@Autowired
	private FbBusInstMapper fbBusInstMapper;

	@Override
	public void delete(Map<String, Object> map) throws Exception {
		String instId = (String) map.get("inst_id");

		if (StringUtils.isNotBlank(instId)) {
			fbBusInstMapper.deleteByPrimaryKey(instId);
		}

	}

	@Override
	public void end(Map<String, Object> map) throws Exception {
		String instId=(String)map.get("inst_id");
		FbBusInst inst=new FbBusInst();
		if(StringUtils.isNotBlank(instId)){
			inst=fbBusInstMapper.selectByPrimaryKey(instId);
			inst.setInstStatus("2");
			fbBusInstMapper.updateByPrimaryKeySelective(inst);
		}
		
		
			
	}

}

package com.zrt.vif.service.tcmp;

import java.net.URL;
import java.util.Map;

import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service
public class TcmpServiceImpl implements TcmpService {

	private static final Logger log = LoggerFactory.getLogger(TcmpServiceImpl.class);

	@Value("${tcmp.URL}")
	private String tcmpURL;

	@Override
	public Map<String, Object> getCount(Map<String, Object> map) throws Exception {
		Client client = new Client(new URL(tcmpURL));
		Object[] results = client.invoke("loadTodoTaskCount", new Object[] { JSON.toJSONString(map) });
		String result = results[0].toString();
		@SuppressWarnings("unchecked")
		Map<String, Object> resMap = JSONObject.parseObject(result, Map.class);
		return resMap;
	}

}

package com.zrt.infoPub.service.infor;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zrt.client.infor.IInforClient;
import com.zrt.infoPub.service.serial.SerialService;


@Service
public class InforServiceImpl implements InforService{
    private final transient Logger logger = LoggerFactory.getLogger(SerialService.class);

    @Resource(name="HystrixInforClient")
    private IInforClient iInforClient;

    @Override
    public Map<String, Object> sendUpdateInfor(Map<String, Object> map) {
        logger.info("调用infor服务向指定人员发送讯息！");
        Map<String, Object> result = iInforClient.sendUpdateInfor(map);
        return result;
    }
    
    
    @Override
    public Map<String, Object> flowInforRead(Map<String, Object> map) {
    	logger.info("调用infor服务修改内部讯息状态！");
    	Map<String, Object> result = iInforClient.flowInforRead(map);
    	return result;
    }
}

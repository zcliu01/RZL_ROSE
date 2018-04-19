package com.zrt.flow.web.manage.flowdraft;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.flow.service.flowdraft.FlowdraftService;

/**
 * Created by dwliu on 2017/9/19.
 */

@RestController
@RequestMapping("/v1.0/flowdraft")
public class FlowdraftController {

    private static final Logger log = LoggerFactory.getLogger(FlowdraftController.class);

    @Autowired
    private FlowdraftService flowdraftService;

    /**
     * 我的草稿
     *
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> list(@RequestBody Map<String, Object> map) throws Exception {
        log.info("Server端的FlowdraftController中list方法");
        ResultMap resultMap = new ResultMap();
        try {

            Map<String, Object> resMap = flowdraftService.flowdraftList(map);
            resultMap.success().map().put("count", resMap.get("count"));
            resultMap.data(resMap.get("data"));
            return resultMap.map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("运行我的草稿列表查询失败!").map();
        }
    }
    
    
    

}

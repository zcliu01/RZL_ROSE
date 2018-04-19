package com.zrt.flow.web.manage.flowcondition;

import com.zrt.commons.AppException;
import com.zrt.commons.ResultMap;
import com.zrt.flow.service.flowcondition.FlowconditionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by dwliu on 2017/9/22.
 */
@RestController
@RequestMapping("/v1.0/flow")
public class FlowConditionController {
    private static final Logger log = LoggerFactory.getLogger(FlowConditionController.class);

    @Autowired
    private FlowconditionService flowconditionService;
    /**
     * 审批新增（附条件同意）
     *
     * @throws Exception
     */
    @RequestMapping(value = "/applyCheckWithFile", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> applyCheckWithFile(@RequestBody Map<String, Object> map) throws Exception {
        log.info("Server端的FlowConditionController中applyCheckWithFile方法");
        ResultMap resultMap = new ResultMap();
        try {
            flowconditionService.applyCheckWithFile(map);
            resultMap.success().sucmsg("审批新增（附条件同意）新增成功!");
            return resultMap.map();
        } catch (AppException e) {
            log.error("json error", e);
            return resultMap.failure().errmsg(e.getMessage()).map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("审批新增（附条件同意）新增失败!").map();
        }
    }

}

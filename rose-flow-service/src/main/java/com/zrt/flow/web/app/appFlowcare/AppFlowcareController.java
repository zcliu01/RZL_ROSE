package com.zrt.flow.web.app.appFlowcare;

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
import com.zrt.flow.service.flowcare.FlowcareService;

/**
 * 我的关注
 * Created by dwliu on 2017/9/19.
 */

@RestController
@RequestMapping("/v1.0/appFlowself")
public class AppFlowcareController {

    private static final Logger log = LoggerFactory.getLogger(AppFlowcareController.class);

    @Autowired
    private FlowcareService flowcareService;

    /**
     * 我的关注
     *
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value = "/careList", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> careList(@RequestBody Map<String, Object> map) throws Exception {
        log.info("Server端的AppFlowcareController中careList方法");
        ResultMap resultMap = new ResultMap();
        try {

            Map<String, Object> resMap = flowcareService.appFlowcareList(map);
            resultMap.success().map().put("count", resMap.get("count"));
            resultMap.data(resMap.get("data"));
            return resultMap.map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("运行我的关注列表查询失败!").map();
        }
    }
    
    /**
     * 我的关注保存
     *
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value = "/careSave", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> careSave(@RequestBody Map<String, Object> map) throws Exception {
        log.info("Server端的FlowcareController中careSave方法");
        ResultMap resultMap = new ResultMap();
        try {

            Map<String, Object> resMap = flowcareService.careSave(map);
            resultMap.success().sucmsg("关注成功");
            return resultMap.map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("关注失败!").map();
        }
    }

    /**
     * 我的取消关注
     *
     * @param map
     * @return
     * @throws AppException
     */
    @RequestMapping(value = "/careCancle", method = RequestMethod.POST, headers = "Accept=application/json")
    public Map<String, Object> careCancle(@RequestBody Map<String, Object> map) throws Exception {
        log.info("Server端的FlowcareController中careCancle方法");
        ResultMap resultMap = new ResultMap();
        try {

            Map<String, Object> resMap = flowcareService.careCancle(map);
            resultMap.success().sucmsg("取消成功");
            return resultMap.map();
        } catch (Exception e) {
            log.error("json error", e);
            return resultMap.failure().errmsg("取消失败!").map();
        }
    }

}

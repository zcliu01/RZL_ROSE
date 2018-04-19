package com.zrt.gateway.api.client.vif;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zrt.gateway.api.AbstactHystrixClient;
import com.zrt.gateway.api.ExceptionDeal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("HystrixVifClient")
public class HystrixVifClient extends AbstactHystrixClient implements IVifClient {

    @Autowired
    private IVifClient vifClient;

    private Logger logger = LoggerFactory.getLogger(IVifClient.class);

    public Map<String, Object> fallback(Map<String, Object> requestJson, Throwable e) {
        logger.error("FAILED SERVICE CALL!" + e.getMessage(), e);
        return ExceptionDeal.fallback(VifConstant.VIF_INSTANCE, requestJson, e);
    }


    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
    public Map<String, Object> uploadSingleFile(Map<String, Object> requestMap) {
        return vifClient.uploadSingleFile(requestMap);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
    public Map<String, Object> uploadAndShare(Map<String, Object> requestMap) {
        return vifClient.uploadAndShare(requestMap);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
    public Map<String, Object> login(Map<String, Object> requestMap) {
        return vifClient.login(requestMap);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
    public Map<String, Object> fileList(Map<String, Object> requestMap) {
        return vifClient.fileList(requestMap);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
    public Map<String, Object> deleteFile(Map<String, Object> requestMap) {
        return vifClient.deleteFile(requestMap);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
    public Map<String, Object> downloadFile(Map<String, Object> requestMap) {
        return vifClient.downloadFile(requestMap);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HYSTRIX_TIMEOUT)})
    public Map<String, Object> copyFile(Map<String, Object> requestMap) {
        return vifClient.copyFile(requestMap);
    }
}

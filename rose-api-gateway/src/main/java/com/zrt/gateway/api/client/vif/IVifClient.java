package com.zrt.gateway.api.client.vif;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(VifConstant.VIF_INSTANCE)
public interface IVifClient extends VifConstant {

	@RequestMapping(value = UPLOAD_SINGLE_FILE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> uploadSingleFile(Map<String, Object> requestMap);

	@RequestMapping(value = UPLOAD_AND_SHARE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> uploadAndShare(Map<String, Object> requestMap);

	@RequestMapping(value = LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> login(Map<String, Object> requestMap);

	@RequestMapping(value = FILE_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> fileList(Map<String, Object> requestMap);

	@RequestMapping(value = DELETE_FILE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> deleteFile(Map<String, Object> requestMap);

	@RequestMapping(value = DOWNLOAD_FILE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> downloadFile(Map<String, Object> requestMap);

	@RequestMapping(value = COPY_FILE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> copyFile(Map<String, Object> requestMap);
	
	@RequestMapping(value = INDEX_COUNT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> indexCount(Map<String, Object> requestMap);
	
	
	@RequestMapping(value = SHARE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> share(Map<String, Object> requestMap);
	
	
	@RequestMapping(value = TCMP_WAITDEAL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> waitDeal(Map<String, Object> requestMap);
	
	@RequestMapping(value = TCMP_DEALCOMPLETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> dealComplete(Map<String, Object> requestMap);
	
	@RequestMapping(value = TCMP_FLOWEND, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> flowEnd(Map<String, Object> requestMap);
}

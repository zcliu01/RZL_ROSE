package com.zrt.gateway.web.file;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.vif.IVifClient;
import com.zrt.gateway.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by dwliu on 2017/9/27.
 */
@RestController
@RequestMapping(value = "v1.0/filemanager", produces = { "application/json;charset=UTF-8" })
public class FileController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(FileController.class);

	@Resource(name = "HystrixVifClient")
	private IVifClient iVifClient;

	/**
	 * 上传文件
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadSingleFile", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> uploadSingleFile(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("FileController中uploadSingleFile方法");
		Map<String, Object> resultMap = iVifClient.uploadSingleFile(appMap);
		return response(resultMap);
	}

	/**
	 * 上传文件并分享
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadAndShare", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> uploadAndShare(@RequestBody Map<String, Object> appMap) throws Exception {
		log.info("FileController中uploadAndShare方法");
		Map<String, Object> resultMap = iVifClient.uploadAndShare(appMap);
		return response(resultMap);
	}

	/**
	 * 查询云盘文件
	 *
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value = "/searchFile", method = RequestMethod.POST,
	 * consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	 * 
	 * @ResponseBody public ResponseEntity<String> searchFile(@RequestBody
	 * Map<String, Object> appMap, @CookieValue String emp_id) throws Exception
	 * { log.info("FileController中searchFile方法"); appMap.put("emp_id",emp_id);
	 * Map<String, Object> resultMap = iVifClient.uploadSingleFile(appMap);
	 * return response(resultMap); }
	 */

	/**
	 * 查询云盘文件(在个人文档中获取某个节点下的节点列表)
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/fileList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> fileList(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("FileController中fileList方法");
		appMap.put("emp_id", emp_id);
		Map<String, Object> resultMap = iVifClient.fileList(appMap);
		return response(resultMap);
	}

	/**
	 * 删除云盘文件
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> deleteFile(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("FileController中deleteFile方法");
		appMap.put("emp_id", emp_id);
		Map<String, Object> resultMap = iVifClient.deleteFile(appMap);
		return response(resultMap);
	}

	/**
	 * 下载云盘文件
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/downloadFile", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> downloadFile(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("FileController中downloadFile方法");
		appMap.put("emp_id", emp_id);
		Map<String, Object> resultMap = iVifClient.downloadFile(appMap);
		return response(resultMap);
	}

	/**
	 * 拷贝云盘文件到公共区域
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/copyFile", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> copyFile(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("FileController中copyFile方法");
		appMap.put("emp_id", emp_id);
		Map<String, Object> resultMap = iVifClient.copyFile(appMap);
		return response(resultMap);
	}

	/**
	 * 云盘登录
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Map<String, Object> appMap, @CookieValue String emp_id)
			throws Exception {
		log.info("FileController中login方法");
		appMap.put("emp_id", emp_id);
		Map<String, Object> resultMap = iVifClient.login(appMap);
		return response(resultMap);
	}
}

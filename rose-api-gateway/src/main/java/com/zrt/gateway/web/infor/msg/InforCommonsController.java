package com.zrt.gateway.web.infor.msg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.infor.IInforClient;
import com.zrt.gateway.web.base.BaseController;

/**
 * Created by msKui on 2017/3/21.
 */
@RestController
@RequestMapping("/v1.0/inforCommons")
public class InforCommonsController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(InforCommonsController.class);

	@Resource(name = "HystrixInforClient")
	private IInforClient inforClient;

	/**
	 * 讯息办结（只能针对接收人）
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeInforDeal", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeInforDeal(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的InforCommonsController中changeInforDeal方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeInforDeal(requestMap);
		return response(resultMap);
	}

	/**
	 * 讯息已阅（只能针对接收人）
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/changeInforRead", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> changeInforRead(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的InforCommonsController中changeInforRead方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.changeInforRead(requestMap);
		return response(resultMap);
	}

	/**
	 * 讯息详情
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforDetail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforCommonsController中inforDetail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.infordetail(requestMap);
		return response(resultMap);
	}

	/**
	 * 关注讯息详情
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCareDetail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforCareDetail(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("Server端的InforCommonsController中inforCareDetail方法");
		Map<String, Object> resultMap = inforClient.inforCareDetail(requestMap);
		return response(resultMap);
	}

	/**
	 * 隐藏讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforHidden", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforHidden(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforCommonsController中inforHidden方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforHidden(requestMap);
		return response(resultMap);
	}

	/**
	 * 批量隐藏讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforHiddenBatch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforHiddenBatch(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的InforCommonsController中inforHiddenBatch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforHiddenBatch(requestMap);
		return response(resultMap);
	}
	/**
	 * 批量隐藏讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCancelHiddenBatch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforCancelHiddenBatch(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的InforCommonsController中inforCancelHiddenBatch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforCancelHiddenBatch(requestMap);
		return response(resultMap);
	}

	/**
	 * 添加关注讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/concernInfor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> concernInfor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforCommonsController中concernInfor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.concernInfor(requestMap);
		return response(resultMap);
	}

	/**
	 * 取消关注讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/concernInforCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> concernInforCancel(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("Server端的InforCommonsController中concernInforCancel方法");
		Map<String, Object> resultMap = inforClient.concernInforCancel(requestMap);
		return response(resultMap);
	}

	/**
	 * 批量取消关注讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/concernInforBatchCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> concernInforBatchCancel(@RequestBody Map<String, Object> requestMap)
			throws Exception {
		log.info("Server端的InforCommonsController中concernInforBatchCancel方法");
		Map<String, Object> resultMap = inforClient.concernInforBatchCancel(requestMap);
		return response(resultMap);
	}

	/**
	 * 新增关注讯息分类
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicAdd", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> dicAdd(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforCommonsController中dicAdd方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.dicAdd(requestMap);
		return response(resultMap);
	}

	/**
	 * 关注讯息分类查询
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> dicList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforCommonsController中dicList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.dicList(requestMap);
		return response(resultMap);
	}

	/**
	 * 撤销讯息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/inforCancel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforCancel(@RequestBody Map<String, Object> requestMap) throws Exception {
		log.info("Server端的InforCommonsController中inforCancel方法");
		Map<String, Object> resultMap = inforClient.inforCancel(requestMap);
		return response(resultMap);
	}

	/**
	 * 首页讯息未阅数量
	 */
	@RequestMapping(value = "/inforCount", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> inforCount(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的InforCommonsController中inforCount方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = inforClient.inforCount(requestMap);
		return response(resultMap);
	}
}

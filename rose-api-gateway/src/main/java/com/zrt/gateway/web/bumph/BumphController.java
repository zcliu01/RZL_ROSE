package com.zrt.gateway.web.bumph;

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
import com.zrt.gateway.api.client.bumph.IBumphClient;
import com.zrt.gateway.web.base.BaseController;

@RestController
@RequestMapping(value="/v1.0/docPro", produces = { "application/json;charset=UTF-8" })
public class BumphController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(BumphController.class);
	@Resource(name="HystrixBumphClient")
	private IBumphClient bumphClient;
	
	
	
	
	/**
	 * 管理审核人
	 */
	@RequestMapping(value = "/execute",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> execute(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphController中execute方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.execute(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 批量添加审核人
	 */
	@RequestMapping(value = "/addExecutes",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> addExecutes(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphController中addExecutes方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.addExecutes(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 管理审核人
	 */
	@RequestMapping(value = "/regis",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> regis(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphController中regis方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.regis(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文类型维护
	 */
	@RequestMapping(value = "/state_save",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> state_save(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphController中state_save方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.state_save(requestMap);
		return response(resultMap);
	}
	/**
	 * 公文类型查询
	 */
	@RequestMapping(value = "/state_search",method = RequestMethod.POST,consumes=ApiConstant.CONSUMES,headers = ApiConstant.HEADERS)
	@ResponseBody   
	public ResponseEntity<String> state_search(@RequestBody Map<String, Object> requestMap,@CookieValue String emp_id) throws Exception {
		log.info("Server端的BumphController中state_search方法");
		setEmpId(emp_id, requestMap);
		Map<String,Object>  resultMap = bumphClient.state_search(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 待发布公文详情
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> detail(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中detail方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.detail(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 新建公文
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> add(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中add方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.add(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 * 待办公文
	 */
	@RequestMapping(value = "/detailSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> detailSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中detailSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.detailSearch(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 
	 *公文审核查看
	 */
	@RequestMapping(value = "/auditView", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> auditView(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中auditView方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.auditView(requestMap);
		return response(resultMap);
	}
	
	/**
	 * 公文审核办理
	 * 
	 */
	@RequestMapping(value = "/auditAttend", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> auditAttend(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中auditAttend方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.auditAttend(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文监控
	 * 
	 */
	@RequestMapping(value = "/Monitor", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> Monitor(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中Monitor方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.Monitor(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文查询
	 * 
	 */
	@RequestMapping(value = "/documentSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> documentSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中documentSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.documentSearch(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文详情
	 * 
	 */
	@RequestMapping(value = "/detailView", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> detailView(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中detailView方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.detailView(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文修改
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> update(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中update方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.update(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文删除
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> delete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中delete方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.delete(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 公文发布或撤销
	 * 
	 */
	@RequestMapping(value = "/backout", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> backout(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的BumphController中backout方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = bumphClient.backout(requestMap);
		return response(resultMap);
	}
	
	
	
}

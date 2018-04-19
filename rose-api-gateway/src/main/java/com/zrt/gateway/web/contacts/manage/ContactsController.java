package com.zrt.gateway.web.contacts.manage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrt.gateway.api.ApiConstant;
import com.zrt.gateway.api.client.contacts.IContactsClient;
import com.zrt.gateway.commons.dto.EmpBaseMessage;
import com.zrt.gateway.commons.dto.EmpPositionMessage;
import com.zrt.gateway.commons.dto.EmpWorkMessage;
import com.zrt.gateway.commons.dto.WebDto;
import com.zrt.gateway.commons.utils.MapEntityConverter;
import com.zrt.gateway.web.base.BaseController;

/**
 * 联系人用户管理模块接口请求类
 * 
 * @author:wwfu
 * @date:2017年3月22日下午8:14:02
 * @description TODO
 */

@RestController
@RequestMapping(value = "/v1.0/friend", produces = { "application/json;charset=UTF-8" })
public class ContactsController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(ContactsController.class);
	@Resource(name = "HystrixContactsClient")
	private IContactsClient ContactsClient;

	/**
	 * 用户列表查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgAllList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> orgAllList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中orgAllList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.orgAllList(requestMap);
		return response(resultMap);
	}

	/**
	 * 待撤销部门列表查询
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/preCancelOrgList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> preCancelOrgList(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的ContactsController中preCancelOrgList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.preCancelOrgList(requestMap);
		return response(resultMap);
	}

	/**
	 * 常用联系人 查询列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/empList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> empList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中empList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.empList(requestMap);
		return response(resultMap);
	}

	/**
	 * 机构员工列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgEmpList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> orgEmpList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中orgEmpList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.orgEmpList(requestMap);
		return response(resultMap);
	}

	/**
	 * 添加常用联系人
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendSave", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> friendSave(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中friendSave方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.friendSave(requestMap);
		return response(resultMap);
	}

	/**
	 * 解除常用联系人
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendDelete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> friendDelete(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中friendDelete方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.friendDelete(requestMap);
		return response(resultMap);
	}

	/**
	 * 查找联系人
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendSearch", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> friendSearch(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中friendSearch方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.friendSearch(requestMap);
		return response(resultMap);
	}

	/**
	 * 查找员工部门和职称
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getOrgPosition", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> getOrgPosition(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的ContactsController中getOrgPosition方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.getOrgPosition(requestMap);
		return response(resultMap);
	}

	/**
	 * 获取员工履历信息
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getWorkRedeploy", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> getWorkRedeploy(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的ContactsController中getWorkRedeploy方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.getWorkRedeploy(requestMap);
		return response(resultMap);
	}

	/**
	 * 根据员工ID获取员工姓名、部门id、部门名称
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getEmpName", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> getEmpName(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中getEmpName方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.getEmpName(requestMap);
		return response(resultMap);
	}


	/**
	 * 获取员工个人详情(基本信息+职位信息+履历信息)
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectEmpDetails", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> selectEmpDetails(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中selectEmpDetails方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.selectEmpDetails(requestMap);
		return response(resultMap);
	}


	/**
	 * 修改员工个人详情
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateEmpDetails", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> updateEmpDetails(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中updateEmpDetails方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.updateEmpDetails(requestMap);
		return response(resultMap);
	}

	/**
	 *打印组织通讯录列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/orgEmpPrint", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> orgEmpPrint(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中orgEmpPrint方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.orgEmpPrint(requestMap);
		return response(resultMap);
	}
	

	/**
	 *打印常用联系人列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/friendPrint", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> friendPrint(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中friendPrint方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.friendPrint(requestMap);
		return response(resultMap);
	}
	
	/**
	 *打印个人信息列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/empDetailsPrint", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> empDetailsPrint(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中empDetailsPrint方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.empDetailsPrint(requestMap);
		return response(resultMap);
	}
	
	
	/**
	 * 导出员工个人详情(基本信息+职位信息+履历信息)
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportEmpDetailsToExcel",method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<InputStreamResource> exportEmpDetailsToExcel(@RequestBody Map<String, Object> requestMap)
			throws Exception {
		log.info("Server端的ContactsController中exportEmpDetailsToExcel方法");
		Map<String, Object> resultMap = ContactsClient.exportEmpDetailsToExcel(requestMap);
		List<Map<String, Object>> returnlist = (List<Map<String, Object>>) resultMap.get("data");
		Map<String, Object> dataMap=new HashMap<>();
		if(returnlist!= null && returnlist.size()>0){
			dataMap=returnlist.get(0);
		}else{
			return null;
		}
		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		
		Map<String,Object> baseMap =(Map<String,Object>) dataMap.get("baseMessage");//基本信息

		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet1 = wb.createSheet("个人基本信息");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row1 = sheet1.createRow((int) 0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style1 = wb.createCellStyle();
		// 居中格式
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row1.createCell(0);
		cell.setCellValue("员工编号");
		cell.setCellStyle(style1);

		cell = row1.createCell(1);
		cell.setCellValue("员工姓名");
		cell.setCellStyle(style1);

		cell = row1.createCell(2);
		cell.setCellValue("直接上级名称");
		cell.setCellStyle(style1);

		cell = row1.createCell(3);
		cell.setCellValue("生日");
		cell.setCellStyle(style1);
		
		cell = row1.createCell(4);
		cell.setCellValue("性别");
		cell.setCellStyle(style1);
		
		cell = row1.createCell(5);
		cell.setCellValue("固定电话");
		cell.setCellStyle(style1);
		
		cell = row1.createCell(6);
		cell.setCellValue("移动电话");
		cell.setCellStyle(style1);
		
		cell = row1.createCell(7);
		cell.setCellValue("传真");
		cell.setCellStyle(style1);
		
		cell = row1.createCell(8);
		cell.setCellValue("电子邮箱");
		cell.setCellStyle(style1);
		
		cell = row1.createCell(9);
		cell.setCellValue("邮编");
		cell.setCellStyle(style1);
		
		cell = row1.createCell(10);
		cell.setCellValue("联系地址");
		cell.setCellStyle(style1);

		cell = row1.createCell(11);
		cell.setCellValue("工作地址");
		cell.setCellStyle(style1);

		cell = row1.createCell(12);
		cell.setCellValue("首次入职时间");
		cell.setCellStyle(style1);

		cell = row1.createCell(13);
		cell.setCellValue("入职时间");
		cell.setCellStyle(style1);

		HSSFRow rowData = sheet1.createRow(1);
		
		EmpBaseMessage baseMessage = (EmpBaseMessage) MapEntityConverter.getEntityFromMap(baseMap, EmpBaseMessage.class);
		// 创建单元格，设置值
		rowData.createCell(0).setCellValue(baseMessage.getEmpCode());
		rowData.createCell(1).setCellValue(baseMessage.getEmpName());
		rowData.createCell(2).setCellValue(baseMessage.getUpEmpName());
		rowData.createCell(3).setCellValue(baseMessage.getEmpBirthday());
		rowData.createCell(4).setCellValue(baseMessage.getEmpSex());
		rowData.createCell(5).setCellValue(baseMessage.getEmpPhone());
		rowData.createCell(6).setCellValue(baseMessage.getEmpMobilePhone());
		rowData.createCell(7).setCellValue(baseMessage.getEmpFax());
		rowData.createCell(8).setCellValue(baseMessage.getEmpEmail());
		rowData.createCell(9).setCellValue(baseMessage.getEmpPostcode());
		rowData.createCell(10).setCellValue(baseMessage.getEmpAddress());
		rowData.createCell(11).setCellValue(baseMessage.getEmpWorkAddress());
		rowData.createCell(12).setCellValue(baseMessage.getCreateDateTime());
		rowData.createCell(13).setCellValue(baseMessage.getEntryTime());
		
		//职位信息表
		List<Map<String, Object>> positionList = (List<Map<String, Object>>) dataMap.get("positionMessage");//职位信息

		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet2 = wb.createSheet("职位信息");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row2 = sheet2.createRow((int) 0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style2 = wb.createCellStyle();
		// 居中格式
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell2 = row2.createCell(0);
		cell2.setCellValue("部门名称");
		cell2.setCellStyle(style2);
		
	    cell2 = row2.createCell(1);
		cell2.setCellValue("职位");
		cell2.setCellStyle(style2);
		
	    cell2 = row2.createCell(2);
		cell2.setCellValue("直接上级名称");
		cell2.setCellStyle(style2);

		if (positionList != null && positionList.size() > 0) {
			for (int i = 0; i < positionList.size(); i++) {
				HSSFRow rowData2 = sheet2.createRow((int) i + 1);
				Map<String, Object> listMap = positionList.get(i);
				EmpPositionMessage positionMessage = (EmpPositionMessage) MapEntityConverter.getEntityFromMap(listMap, EmpPositionMessage.class);
				// 创建单元格，设置值
				rowData2.createCell(0).setCellValue(positionMessage.getOrgName());
				rowData2.createCell(1).setCellValue(positionMessage.getPName());
				rowData2.createCell(2).setCellValue(positionMessage.getUpEmpName());
			
			}
		}
		
		//履历信息表
				List<Map<String, Object>> workList = (List<Map<String, Object>>) dataMap.get("workMessage");//职位信息

				// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
				HSSFSheet sheet3 = wb.createSheet("履历信息");
				// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
				HSSFRow row3 = sheet3.createRow((int) 0);
				// 4.创建单元格，设置值表头，设置表头居中
				HSSFCellStyle style3 = wb.createCellStyle();
				// 居中格式
				style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);

				// 设置表头
				HSSFCell cell3 = row3.createCell(0);
				cell3.setCellValue("任职开始时间");
				cell3.setCellStyle(style3);
				
			    cell3 = row3.createCell(1);
				cell3.setCellValue("任职结束时间");
				cell3.setCellStyle(style3);
				
			    cell3 = row3.createCell(2);
				cell3.setCellValue("职位");
				cell3.setCellStyle(style3);
				
				cell3 = row3.createCell(3);
				cell3.setCellValue("部门名称");
				cell3.setCellStyle(style3);
				
				cell3 = row3.createCell(4);
				cell3.setCellValue("工作变更详情");
				cell3.setCellStyle(style3);
				
				
				if (workList != null && workList.size() > 0) {
					for (int i = 0; i < workList.size(); i++) {
						HSSFRow rowData3 = sheet3.createRow((int) i + 1);
						Map<String, Object> workMap = workList.get(i);
						EmpWorkMessage workMessage = (EmpWorkMessage) MapEntityConverter.getEntityFromMap(workMap, EmpWorkMessage.class);
						// 创建单元格，设置值
						rowData3.createCell(0).setCellValue(workMessage.getCreateDateTime());
						rowData3.createCell(1).setCellValue(workMessage.getEndDateTime());
						rowData3.createCell(2).setCellValue(workMessage.getPName());
						rowData3.createCell(3).setCellValue(workMessage.getOrgName());
						rowData3.createCell(4).setCellValue(workMessage.getRedeployContent());
					}
				}
		
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		wb.write(os);
		byte[] content = os.toByteArray();

		String downloadFileName = "个人资料表.xls";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.set("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downloadFileName, "utf-8"));

		return ResponseEntity.ok().headers(headers)
				// .contentLength(pdfFile.contentLength())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(new InputStreamResource(new ByteArrayInputStream(content)));
	}
	
	
	
	/**
	 * 常用联系人导出
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportFriendToExcel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<InputStreamResource> exportFriendToExcel(@RequestBody Map<String, Object> requestMap)
			throws Exception {
		log.info("Server端的ContactsController中exportFriendToExcel方法");

		Map<String, Object> resultMap = ContactsClient.exportFriendToExcel(requestMap);
		List<Map<String, Object>> list = (List<Map<String, Object>>) resultMap.get("data");
		/**
		 * List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
		 * Map<String,Object> dataMap=new HashMap<String,Object>();
		 * dataMap.put("emp_name", "小明"); list.add(dataMap);
		 **/

		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("常用联系人信息表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("员工编号");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("员工姓名");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("部门名称");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("职位");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("入职时间");
		cell.setCellStyle(style);

		cell = row.createCell(5);
		cell.setCellValue("首次入职时间");
		cell.setCellStyle(style);

		cell = row.createCell(6);
		cell.setCellValue("工作地点");
		cell.setCellStyle(style);

		cell = row.createCell(7);
		cell.setCellValue("邮箱");
		cell.setCellStyle(style);

		cell = row.createCell(8);
		cell.setCellValue("性别");
		cell.setCellStyle(style);

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				HSSFRow rowData = sheet.createRow((int) i + 1);
				Map<String, Object> listMap = list.get(i);
				WebDto webDto = (WebDto) MapEntityConverter.getEntityFromMap(listMap, WebDto.class);
				// 创建单元格，设置值
				rowData.createCell(0).setCellValue(webDto.getEmpCode());
				rowData.createCell(1).setCellValue(webDto.getEmpName());
				rowData.createCell(2).setCellValue(webDto.getOrgName());
				rowData.createCell(3).setCellValue(webDto.getPName());
				rowData.createCell(4).setCellValue(webDto.getEntryTime());
				rowData.createCell(5).setCellValue(webDto.getCreateDateTime());
				rowData.createCell(6).setCellValue(webDto.getEmpWorkAddress());
				rowData.createCell(7).setCellValue(webDto.getEmpEmail());
				rowData.createCell(8).setCellValue(webDto.getEmpSex());
			}
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		wb.write(os);
		byte[] content = os.toByteArray();

		String downloadFileName = "常用联系人通讯录.xls";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.set("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downloadFileName, "utf-8"));

		return ResponseEntity.ok().headers(headers)
				// .contentLength(pdfFile.contentLength())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(new InputStreamResource(new ByteArrayInputStream(content)));
	}

	/**
	 * 组织通讯录员工导出
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportEmpToExcel", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<InputStreamResource> exportEmpToExcel(@RequestBody Map<String, Object> requestMap)
			throws Exception {
		log.info("Server端的ContactsController中exportEmpToExcel方法");

		Map<String, Object> resultMap = ContactsClient.exportEmpToExcel(requestMap);
		List<Map<String, Object>> list = (List<Map<String, Object>>) resultMap.get("data");

		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("员工通讯录表");
		// 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 4.创建单元格，设置值表头，设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 设置表头
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("员工编号");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("员工姓名");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("部门名称");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("职位");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("入职时间");
		cell.setCellStyle(style);

		cell = row.createCell(5);
		cell.setCellValue("首次入职时间");
		cell.setCellStyle(style);

		cell = row.createCell(6);
		cell.setCellValue("工作地点");
		cell.setCellStyle(style);

		cell = row.createCell(7);
		cell.setCellValue("邮箱");
		cell.setCellStyle(style);

		cell = row.createCell(8);
		cell.setCellValue("性别");
		cell.setCellStyle(style);

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				HSSFRow rowData = sheet.createRow((int) i + 1);
				Map<String, Object> listMap = list.get(i);
				WebDto webDto = (WebDto) MapEntityConverter.getEntityFromMap(listMap, WebDto.class);
				// 创建单元格，设置值
				rowData.createCell(0).setCellValue(webDto.getEmpCode());
				rowData.createCell(1).setCellValue(webDto.getEmpName());
				rowData.createCell(2).setCellValue(webDto.getOrgName());
				rowData.createCell(3).setCellValue(webDto.getPName());
				rowData.createCell(4).setCellValue(webDto.getEntryTime());
				rowData.createCell(5).setCellValue(webDto.getCreateDateTime());
				rowData.createCell(6).setCellValue(webDto.getEmpWorkAddress());
				rowData.createCell(7).setCellValue(webDto.getEmpEmail());
				rowData.createCell(8).setCellValue(webDto.getEmpSex());
			}
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		wb.write(os);
		byte[] content = os.toByteArray();

		String downloadFileName = "组织通讯录.xls";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		headers.set("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downloadFileName, "utf-8"));

		return ResponseEntity.ok().headers(headers)
				// .contentLength(pdfFile.contentLength())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(new InputStreamResource(new ByteArrayInputStream(content)));
	}
	
	
	/**
	 * 查询所有员工的id
	 * @param requestMap
	 * @param emp_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchAll", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> searchAll(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的ContactsController中searchAll方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.searchAll(requestMap);
		return response(resultMap);
	}
}

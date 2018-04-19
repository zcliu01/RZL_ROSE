package com.zrt.gateway.web.contacts.manage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
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
import com.zrt.gateway.commons.dto.WebDto;
import com.zrt.gateway.commons.utils.MapEntityConverter;
import com.zrt.gateway.web.base.BaseController;

/**
 * 组织通讯录 群组成员 模块接口请求类
 * 
 * @author:ajzhou
 * @date:2017年6月07日15:14
 * @description TODO
 */
@RestController
@RequestMapping(value = "/v1.0/groupMember", produces = { "application/json;charset=UTF-8" })
public class GroupMemberController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(GroupMemberController.class);
	@Resource(name = "HystrixContactsClient")
	private IContactsClient ContactsClient;

	/**
	 * 群组成员列表
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupMemList", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> groupMemList(@RequestBody Map<String, Object> requestMap, @CookieValue String emp_id)
			throws Exception {
		log.info("Server端的GroupMemberController中groupMemList方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.groupMemList(requestMap);
		return response(resultMap);
	}

	/**
	 * 添加群组成员
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupMemberSave", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> groupMemberSave(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的GroupMemberController中groupMemberSave方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.groupMemberSave(requestMap);
		return response(resultMap);
	}

	/**
	 * 删除群组成员
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupMemberDelete", method = RequestMethod.POST, consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<String> groupMemberDelete(@RequestBody Map<String, Object> requestMap,
			@CookieValue String emp_id) throws Exception {
		log.info("Server端的GroupMemberController中groupMemberDelete方法");
		setEmpId(emp_id, requestMap);
		Map<String, Object> resultMap = ContactsClient.groupMemberDelete(requestMap);
		return response(resultMap);
	}

	/**
	 * 群组成员导出
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportGroupMemToExcel",  consumes = ApiConstant.CONSUMES, headers = ApiConstant.HEADERS)
	@ResponseBody
	public ResponseEntity<InputStreamResource> exportGroupMemToExcel(@RequestBody Map<String, Object> requestMap)
			throws Exception {
		log.info("Server端的ContactsController中exportGroupMemToExcel方法");

		Map<String, Object> resultMap = ContactsClient.exportGroupMemToExcel(requestMap);
		List<Map<String, Object>> list = (List<Map<String, Object>>) resultMap.get("data");
		/**
		 * List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
		 * Map<String,Object> dataMap=new HashMap<String,Object>();
		 * dataMap.put("emp_name", "小明"); list.add(dataMap);
		 **/

		// 1.创建一个workbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 2.在workbook中添加一个sheet，对应Excel中的一个sheet
		HSSFSheet sheet = wb.createSheet("群组成员通讯录表");
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

		String downloadFileName = "群组成员通讯录.xls";
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
}

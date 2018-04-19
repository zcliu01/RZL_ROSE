package com.zrt.flow.service.handle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zrt.commons.AppException;
import com.zrt.flow.domain.CheckDomain;
import com.zrt.flow.domain.FbBusTemplateDomain;
import com.zrt.flow.domain.FileDomain;
import com.zrt.flow.domain.FmBusTemplateDomain;
import com.zrt.flow.domain.InstDomain;
import com.zrt.flow.domain.RelevanceDomain;
import com.zrt.flow.mapper.handle.HandleMapper;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.process.ProcessCommonService;
import com.zrt.mybatis.domain.FbBusHandle;
import com.zrt.mybatis.domain.FbBusHandleExample;
import com.zrt.mybatis.domain.FmBusTemplateWithBLOBs;
import com.zrt.mybatis.mapper.FbBusHandleMapper;
import com.zrt.mybatis.mapper.FmBusTemplateMapper;

@Service
public class HandleCommonService {

	@Autowired
	private ProcessCommonService processCommonService;
	@Autowired
	@Value("${im.notify.sender_id}")
	private String systemEmpId;
	@Autowired
	private HandleMapper handleMapper;
	@Autowired
	private FmBusTemplateMapper fmBusTemplateMapper;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private FbBusHandleMapper fbBusHandleMapper;

	/**
	 * 签报类详情
	 */
	public Map<String, Object> detail(Map<String, Object> appMap) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String instId = (String) appMap.get("inst_id");
		if (StringUtils.isBlank(instId)) {
			throw new AppException("该流程已撤销！");
		}
		InstDomain inst = handleMapper.getFlowDetail(appMap);
		if ("0".equals(inst.getInstStatus())) {
			throw new AppException("该流程已撤销！");
		}

		if (inst != null) {

			resMap.put("inst_id", inst.getId());
			resMap.put("inst_status", inst.getInstStatus());
			// 获取发起的流程模板
			FbBusTemplateDomain fb = inst.getFbDomain();
			resMap.put("fb_id", fb.getId());
			resMap.put("fb_title", inst.getFbTitle());
			resMap.put("fb_content", inst.getFbContent());
			resMap.put("t_code", fb.gettCode());
			resMap.put("t_name", fb.gettName());
			resMap.put("t_desc", fb.gettDesc());
			resMap.put("apply_id", inst.getApplyId());
			resMap.put("apply_name", inst.getApplyName());
			resMap.put("org_id", inst.getOrgId());
			resMap.put("org_name", inst.getOrgName());
			resMap.put("start_date_time", inst.getStartDateTime());
			// 获取发起的流程模板绑定的表单
			FmBusTemplateDomain fm = fb.getBm().getFmDomain();
			resMap.put("fm_id", fm.getId());
			resMap.put("fm_name", fm.gettName());

			// 根据申请id，查询表单提交的数据

			// 根据formid查询form 模版
			FmBusTemplateWithBLOBs fmBusTemplateWithBLOBs = fmBusTemplateMapper.selectByPrimaryKey(fm.getId());
			resMap.put("t_html", fmBusTemplateWithBLOBs.gettHtml());
			resMap.put("fm_data", processCommonService.instDataList(instId));
			// 查询关联的项目信息
			resMap.put("project", processCommonService.projectList(instId));
			// 签报标识
			resMap.put("handle_flag", fb.getHandleFlag());
			// 项目标识标识
			resMap.put("project_flag", fb.getProjectFlag());

			// 获取发起人头像
			Map<String, Object> applymap = new HashMap<>();
			applymap.put("search", inst.getApplyId());
			Map<String, Object> applyresult = contactsService.commonEmpSearch(applymap);
			List<Map<String, Object>> applyList = (List<Map<String, Object>>) applyresult.get("data");
			Map<String, Object> applyEmpData = null;
			if (null != applyList && applyList.size() > 0) {
				applyEmpData = applyList.get(0);
				resMap.put("apply_emp_head_photo", applyEmpData.get("emp_head_photo"));
			}
			// 获取发起的流程关联的信息
			List<RelevanceDomain> relList = inst.getRelList();
			List<Map<String, Object>> instInforRelList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> instFlowRelList = new ArrayList<Map<String, Object>>();

			if (relList != null && relList.size() > 0) {
				for (RelevanceDomain rel : relList) {
					if ("0".equals(rel.getFbType())) {// 发起关联的信息
						if ("0".equals(rel.getRelType())) {// 讯息
							Map<String, Object> relMap = new HashMap<String, Object>();
							relMap.put("rel_id", rel.getRelId());
							relMap.put("rel_name", rel.getRelName());
							relMap.put("rel_type", rel.getRelType());
							instInforRelList.add(relMap);
						} else if ("1".equals(rel.getRelType())) {
							Map<String, Object> relMap = new HashMap<String, Object>();
							relMap.put("rel_id", rel.getRelId());
							relMap.put("rel_name", rel.getRelName());
							relMap.put("rel_type", rel.getRelType());
							instFlowRelList.add(relMap);
						}

					}
				}
			}
			resMap.put("inst_infor_rel", instInforRelList);
			resMap.put("inst_flow_rel", instFlowRelList);
			// 获取发起的流程关联的附件
			List<FileDomain> fileList = inst.getFileList();
			List<Map<String, Object>> instLocalFileList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> instCloudFileList = new ArrayList<Map<String, Object>>();
			if (fileList != null && fileList.size() > 0) {
				for (FileDomain file : fileList) {
					if ("0".equals(file.getFbType())) {
						if ("0".equals(file.getFileType())) {
							Map<String, Object> fileMap = new HashMap<String, Object>();
							fileMap.put("file_url", file.getFileUrl());
							fileMap.put("file_name", file.getFileName());
							fileMap.put("file_type", file.getFileType());
							fileMap.put("node_id", file.getNodeId());
							instLocalFileList.add(fileMap);
						} else if ("1".equals(file.getFileType())) {
							Map<String, Object> fileMap = new HashMap<String, Object>();
							fileMap.put("file_url", file.getFileUrl());
							fileMap.put("file_name", file.getFileName());
							fileMap.put("file_type", file.getFileType());
							fileMap.put("node_id", file.getNodeId());
							instCloudFileList.add(fileMap);
						}

					}
				}
			}
			resMap.put("inst_local_file", instLocalFileList);
			resMap.put("inst_cloud_file", instCloudFileList);
			// 获取发起的流程已经审核的list
			List<CheckDomain> checkList = inst.getCheckList();
			List<Map<String, Object>> instCheckList = new ArrayList<Map<String, Object>>();
			if (checkList != null && checkList.size() > 0) {
				for (CheckDomain check : checkList) {
					Map<String, Object> checkMap = new HashMap<String, Object>();
					checkMap.put("check_id", check.getId());
					checkMap.put("check_emp_id", check.getCheckEmpId());
					checkMap.put("check_emp_name", check.getCheckEmpName());
					checkMap.put("org_id", check.getOrgId());
					checkMap.put("org_name", check.getOrgName());
					checkMap.put("check_status", check.getCheckStatus());
					checkMap.put("check_type", check.getCheckType());
					checkMap.put("check_comment", check.getCheckComment());
					checkMap.put("arrive_date_time", check.getArriveDateTime());
					checkMap.put("read_date_time", check.getReadDateTime());
					checkMap.put("create_date_time", check.getCreateDateTime());
					// checkMap.put("inst_tag", check.getInstTag());
					// checkMap.put("inst_tag_name", check.getInstTagName());
					checkMap.put("check_date_time", check.getCheckDateTime());
					checkMap.put("care_flag", "0");// 未关注
					checkMap.put("ented_emp_id", check.getEntedEmpId());// 受委托人
					checkMap.put("ented_emp_name", check.getEntedEmpName());
					// 获取审核部门
					Map<String, Object> empData = getEmpInfo(check.getCheckEmpId());
					if (!empData.isEmpty() && null != empData) {
						checkMap.put("p_name", empData.get("p_name"));// 审批部门
						checkMap.put("check_emp_head_photo", empData.get("emp_head_photo"));
					}
					// 获取审核关联的信息
					List<Map<String, Object>> checkInforRelList = new ArrayList<Map<String, Object>>();
					List<Map<String, Object>> checkFlowRelList = new ArrayList<Map<String, Object>>();
					if (relList != null && relList.size() > 0) {
						for (RelevanceDomain rel : relList) {
							if ("1".equals(rel.getFbType()) && rel.getCheckId().equals(check.getId())) {
								if ("0".equals(rel.getRelType())) {// 讯息
									Map<String, Object> relMap = new HashMap<String, Object>();
									relMap.put("rel_id", rel.getRelId());
									relMap.put("rel_name", rel.getRelName());
									relMap.put("rel_type", rel.getRelType());
									checkInforRelList.add(relMap);
								} else if ("1".equals(rel.getRelType())) {
									Map<String, Object> relMap = new HashMap<String, Object>();
									relMap.put("rel_id", rel.getRelId());
									relMap.put("rel_name", rel.getRelName());
									relMap.put("rel_type", rel.getRelType());
									checkFlowRelList.add(relMap);
								}

							}
						}
					}
					checkMap.put("check_infor_rel", checkInforRelList);
					checkMap.put("check_flow_rel", checkFlowRelList);
					// 获取审核关联的附件
					List<Map<String, Object>> checkLocalFileList = new ArrayList<Map<String, Object>>();
					List<Map<String, Object>> checkCloudFileList = new ArrayList<Map<String, Object>>();
					if (fileList != null && fileList.size() > 0) {
						for (FileDomain file : fileList) {
							if ("1".equals(file.getFbType()) && file.getCheckId().equals(check.getId())) {
								if ("0".equals(file.getFileType())) {
									Map<String, Object> fileMap = new HashMap<String, Object>();
									fileMap.put("file_url", file.getFileUrl());
									fileMap.put("file_name", file.getFileName());
									fileMap.put("file_type", file.getFileType());
									fileMap.put("node_id", file.getNodeId());
									checkLocalFileList.add(fileMap);
								} else if ("1".equals(file.getFileType())) {
									Map<String, Object> fileMap = new HashMap<String, Object>();
									fileMap.put("file_url", file.getFileUrl());
									fileMap.put("file_name", file.getFileName());
									fileMap.put("file_type", file.getFileType());
									fileMap.put("node_id", file.getNodeId());
									checkCloudFileList.add(fileMap);
								}
							}
						}
					}
					checkMap.put("check_local_file", checkLocalFileList);
					checkMap.put("check_cloud_file", checkCloudFileList);

					String checkId = check.getId();
					FbBusHandleExample example = new FbBusHandleExample();
					example.createCriteria().andCheckIdEqualTo(checkId);
					List<FbBusHandle> handleList = fbBusHandleMapper.selectByExample(example);
					String sendEmpId = "";// 签报发送人id
					String sendEmpName = "";
					if (null != handleList && !handleList.isEmpty()) {
						sendEmpId = handleList.get(0).getSendEmpId();
						sendEmpName = handleList.get(0).getSendEmpName();
					}
					checkMap.put("send_emp_id", sendEmpId);
					checkMap.put("send_emp_name", sendEmpName);

					instCheckList.add(checkMap);
				}

			}
			resMap.put("check_list", instCheckList);

		}
		return resMap;
	}

	/**
	 * 签报类待办详情
	 */
	public Map<String, Object> doDetail(Map<String, Object> appMap) throws Exception {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String instId = (String) appMap.get("inst_id");
		if (StringUtils.isBlank(instId)) {
			throw new AppException("该流程已撤销！");
		}
		InstDomain inst = handleMapper.doList(appMap);
		if ("0".equals(inst.getInstStatus())) {
			throw new AppException("该流程已撤销！");
		}
		if (inst != null) {
			// 获取发起的流程已经审核的list
			List<CheckDomain> checkList = inst.getCheckList();
			List<Map<String, Object>> instCheckList = new ArrayList<Map<String, Object>>();
			if (checkList != null && checkList.size() > 0) {
				for (CheckDomain check : checkList) {
					Map<String, Object> checkMap = new HashMap<String, Object>();
					checkMap.put("check_id", check.getId());
					checkMap.put("check_emp_id", check.getCheckEmpId());
					checkMap.put("check_emp_name", check.getCheckEmpName());
					checkMap.put("org_id", check.getOrgId());
					checkMap.put("org_name", check.getOrgName());
					checkMap.put("check_status", check.getCheckStatus());
					checkMap.put("check_type", check.getCheckType());
					checkMap.put("check_comment", check.getCheckComment());
					checkMap.put("arrive_date_time", check.getArriveDateTime());
					checkMap.put("read_date_time", check.getReadDateTime());
					checkMap.put("create_date_time", check.getCreateDateTime());
					// checkMap.put("inst_tag", check.getInstTag());
					// checkMap.put("inst_tag_name", check.getInstTagName());
					checkMap.put("check_date_time", check.getCheckDateTime());
					checkMap.put("task_id", check.getTaskId());// 任务id
					checkMap.put("handle_id", check.getTaskId());// 任务id
					checkMap.put("ented_emp_id", check.getEntedEmpId());// 受委托人
					checkMap.put("ented_emp_name", check.getEntedEmpName());
					// 获取审核部门
					Map<String, Object> empData = getEmpInfo(check.getCheckEmpId());
					checkMap.put("p_name", empData.get("p_name"));// 审批部门
					checkMap.put("care_flag", "0");// 未关注
					checkMap.put("check_emp_head_photo", empData.get("emp_head_photo"));

					String checkId = check.getId();
					FbBusHandleExample example = new FbBusHandleExample();
					example.createCriteria().andCheckIdEqualTo(checkId);
					List<FbBusHandle> handleList = fbBusHandleMapper.selectByExample(example);
					String sendEmpId = "";// 签报发送人id
					String sendEmpName = "";
					if (null != handleList && !handleList.isEmpty()) {
						sendEmpId = handleList.get(0).getSendEmpId();
						sendEmpName = handleList.get(0).getSendEmpName();
					}
					checkMap.put("send_emp_id", sendEmpId);
					checkMap.put("send_emp_name", sendEmpName);

					instCheckList.add(checkMap);
				}

			}
			resMap.put("do_list", instCheckList);

		}
		return resMap;
	}

	public Map<String, Object> getEmpInfo(String emp_id) {
		Map<String, Object> conmap = new HashMap<>();
		conmap.put("search", emp_id);
		Map<String, Object> result = contactsService.commonEmpSearch(conmap);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
		Map<String, Object> data = new HashMap<String, Object>();
		if (null != li && li.size() > 0) {
			data = li.get(0);
		}
		return data;
	}
}

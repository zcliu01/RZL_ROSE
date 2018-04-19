package com.zrt.flow.service.flowdeatil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrt.flow.domain.AddFileDomain;
import com.zrt.flow.domain.AddRelevanceDomain;
import com.zrt.flow.domain.CheckDomain;
import com.zrt.flow.domain.FbBusConditionDomain;
import com.zrt.flow.domain.FbBusTemplateDomain;
import com.zrt.flow.domain.FileDomain;
import com.zrt.flow.domain.FmBusTemplateDomain;
import com.zrt.flow.domain.InstDomain;
import com.zrt.flow.domain.JoinSignDomain;
import com.zrt.flow.domain.JoinSignFileDomain;
import com.zrt.flow.domain.JoinSignRelevanceDomain;
import com.zrt.flow.domain.RelevanceDomain;
import com.zrt.flow.mapper.flowEntrust.FlowEntrustCustomMapper;
import com.zrt.flow.mapper.flowdetail.FlowDetailCustomMapper;
import com.zrt.flow.service.act.ActProcessService;
import com.zrt.flow.service.contacts.ContactsService;
import com.zrt.flow.service.process.ProcessCommonService;
import com.zrt.mybatis.domain.FbBusAddSign;
import com.zrt.mybatis.domain.FbBusCare;
import com.zrt.mybatis.domain.FbBusCareExample;
import com.zrt.mybatis.domain.FbBusFile;
import com.zrt.mybatis.domain.FbBusFileExample;
import com.zrt.mybatis.domain.FbBusInst;
import com.zrt.mybatis.domain.FbBusPredeal;
import com.zrt.mybatis.domain.FbBusPredealExample;
import com.zrt.mybatis.domain.FbBusPredealExample.Criteria;
import com.zrt.mybatis.domain.FbBusRejectRule;
import com.zrt.mybatis.domain.FbBusRelevance;
import com.zrt.mybatis.domain.FbBusRelevanceExample;
import com.zrt.mybatis.domain.FmBusTemplateWithBLOBs;
import com.zrt.mybatis.mapper.FbBusCareMapper;
import com.zrt.mybatis.mapper.FbBusDataMapper;
import com.zrt.mybatis.mapper.FbBusFileMapper;
import com.zrt.mybatis.mapper.FbBusInstMapper;
import com.zrt.mybatis.mapper.FbBusPredealMapper;
import com.zrt.mybatis.mapper.FbBusRelevanceMapper;
import com.zrt.mybatis.mapper.FmBusTemplateMapper;

@Service
public class CommonDetailService {

	@Autowired
	private FlowDetailCustomMapper flowDetailMapper;

	@Autowired
	private FbBusDataMapper fbBusDataMapper;
	@Autowired
	private FmBusTemplateMapper fmBusTemplateMapper;

	@Autowired
	private ProcessCommonService processCommonService;
	@Autowired
	private ActProcessService actProcessService;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private FbBusPredealMapper fbBusPredealMapper;
	@Autowired
	private FbBusCareMapper fbBusCareMapper;
	@Autowired
	private FbBusInstMapper fbBusInstMapper;
	@Autowired
	private FbBusFileMapper fbBusFileMapper;
	@Autowired
	private FbBusRelevanceMapper fbBusRelevanceMapper;
	@Autowired
	private FlowEntrustCustomMapper flowEntrustCustomMapper;

	public Map<String, Object> flowDetail(Map<String, Object> map) throws Exception {

		Map<String, Object> resMap = new HashMap<String, Object>();
		InstDomain inst = flowDetailMapper.getFlowDetail(map);

		if (inst != null) {
			String instId = (String) map.get("inst_id");
			// 查询该实例被关注过的节点
			FbBusCareExample careExample = new FbBusCareExample();
			com.zrt.mybatis.domain.FbBusCareExample.Criteria careCriteria = careExample.createCriteria();
			careCriteria.andInstIdEqualTo(instId);
			List<FbBusCare> careList = fbBusCareMapper.selectByExample(careExample);

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
			// 根据申请id，查询表单提交的数据

			// 根据formid查询form 模版
			FmBusTemplateWithBLOBs fmBusTemplateWithBLOBs = fmBusTemplateMapper.selectByPrimaryKey(fm.getId());
			resMap.put("t_html", fmBusTemplateWithBLOBs.gettHtml());
			String detailType = (String) map.get("detail_type");
			if ("app".equals(detailType)) {
				resMap.put("fm_data", processCommonService.instDataListApp(instId));
			} else {
				resMap.put("fm_data", processCommonService.instDataListWeb(instId));
			}
			// 查询关联的项目信息
			resMap.put("project", processCommonService.projectList(instId));
			// 签报标识
			resMap.put("handle_flag", fb.getHandleFlag());
			// 项目标识标识
			resMap.put("project_flag", fb.getProjectFlag());
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
					checkMap.put("inst_tag", check.getInstTag());
					checkMap.put("inst_tag_name", check.getInstTagName());
					checkMap.put("check_date_time", check.getCheckDateTime());
					checkMap.put("care_flag", careFlag(careList, check.getInstTag(), (String) map.get("emp_id")));// 是否关注
					checkMap.put("ented_emp_id", check.getEntedEmpId());// 受委托人
					checkMap.put("ented_emp_name", check.getEntedEmpName());
					Map<String, Object> conmap = new HashMap<>();
					conmap.put("search", check.getCheckEmpId());
					Map<String, Object> result = contactsService.commonEmpSearch(conmap);
					List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
					Map<String, Object> empData = null;
					if (null != li && li.size() > 0) {
						empData = li.get(0);
						checkMap.put("check_emp_head_photo", empData.get("emp_head_photo"));
					}
					// 获取加签人员
					List<FbBusAddSign> addSignList = check.getAddSignList();
					List<Map<String, Object>> addList = new ArrayList<Map<String, Object>>();
					if (addSignList != null && addSignList.size() > 0) {
						for (FbBusAddSign addSign : addSignList) {
							Map<String, Object> signMap = new HashMap<String, Object>();
							signMap.put("add_emp_id", addSign.getAddEmpId());
							signMap.put("add_emp_name", addSign.getAddEmpName());
							addList.add(signMap);
						}
					}
					checkMap.put("addSign_list", addList);

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

					// 获取会签加人的时候添加的附件和关联的信息
					List<Map<String, Object>> checkSignInforRelList = new ArrayList<Map<String, Object>>();
					List<Map<String, Object>> checkSignFlowRelList = new ArrayList<Map<String, Object>>();
					if (relList != null && relList.size() > 0) {
						for (RelevanceDomain rel : relList) {
							if ("2".equals(rel.getFbType()) && rel.getCheckId().equals(check.getId())) {
								if ("0".equals(rel.getRelType())) {// 讯息
									Map<String, Object> relMap = new HashMap<String, Object>();
									relMap.put("rel_id", rel.getRelId());
									relMap.put("rel_name", rel.getRelName());
									relMap.put("rel_type", rel.getRelType());
									checkSignInforRelList.add(relMap);
								} else if ("1".equals(rel.getRelType())) {
									Map<String, Object> relMap = new HashMap<String, Object>();
									relMap.put("rel_id", rel.getRelId());
									relMap.put("rel_name", rel.getRelName());
									relMap.put("rel_type", rel.getRelType());
									checkSignFlowRelList.add(relMap);
								}

							}
						}
					}
					checkMap.put("check_sign_infor_rel", checkSignInforRelList);
					checkMap.put("check_sign_flow_rel", checkSignFlowRelList);
					
					List<Map<String, Object>> checkSignLocalFileList = new ArrayList<Map<String, Object>>();
					List<Map<String, Object>> checkSignCloudFileList = new ArrayList<Map<String, Object>>();
					if (fileList != null && fileList.size() > 0) {
						for (FileDomain file : fileList) {
							if ("2".equals(file.getFbType()) && file.getCheckId().equals(check.getId())) {
								if ("0".equals(file.getFileType())) {
									Map<String, Object> fileMap = new HashMap<String, Object>();
									fileMap.put("file_url", file.getFileUrl());
									fileMap.put("file_name", file.getFileName());
									fileMap.put("file_type", file.getFileType());
									fileMap.put("node_id", file.getNodeId());
									checkSignLocalFileList.add(fileMap);
								} else if ("1".equals(file.getFileType())) {
									Map<String, Object> fileMap = new HashMap<String, Object>();
									fileMap.put("file_url", file.getFileUrl());
									fileMap.put("file_name", file.getFileName());
									fileMap.put("file_type", file.getFileType());
									fileMap.put("node_id", file.getNodeId());
									checkSignCloudFileList.add(fileMap);
								}
							}
						}
					}
					checkMap.put("check_sign_local_file", checkSignLocalFileList);
					checkMap.put("check_sign_cloud_file", checkSignCloudFileList);

					// 获取会签list
					List<JoinSignDomain> signList = check.getSignList();
					List<Map<String, Object>> checkSignList = new ArrayList<Map<String, Object>>();
					if (signList != null && signList.size() > 0) {
						for (JoinSignDomain sign : signList) {
							Map<String, Object> signMap = new HashMap<String, Object>();
							signMap.put("sign_id", sign.getId());
							signMap.put("sign_emp_id", sign.getSignEmpId());
							signMap.put("sign_emp_name", sign.getSignEmpName());
							signMap.put("check_status", sign.getCheckStatus());
							signMap.put("org_id", sign.getOrgId());
							signMap.put("org_name", sign.getOrgName());
							signMap.put("sign_status", sign.getSignStatus());
							signMap.put("check_comment", sign.getCheckComment());
							signMap.put("sign_desc", sign.getSignDesc());
							Map<String, Object> empMap = new HashMap<>();
							empMap.put("search", sign.getSignEmpId());
							Map<String, Object> empMapResult = contactsService.commonEmpSearch(empMap);
							List<Map<String, Object>> empMapList = (List<Map<String, Object>>) empMapResult.get("data");
							Map<String, Object> empMapData = null;
							if (null != empMapList && empMapList.size() > 0) {
								empMapData = empMapList.get(0);
								signMap.put("sign_emp_head_photo", empMapData.get("emp_head_photo"));
							}
							// 获取会签关联信息
							List<JoinSignRelevanceDomain> signRelList = sign.getSignRelList();
							List<Map<String, Object>> relInforMapList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> relFlowMapList = new ArrayList<Map<String, Object>>();

							if (signRelList != null && signRelList.size() > 0) {
								for (JoinSignRelevanceDomain rel : signRelList) {
									if ("0".equals(rel.getRelType())) {// 讯息
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relInforMapList.add(relMap);
									} else if ("1".equals(rel.getRelType())) {
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relFlowMapList.add(relMap);
									}
								}
							}
							signMap.put("sign_infor_rel", relInforMapList);
							signMap.put("sign_flow_rel", relFlowMapList);
							// 获取会签附件
							List<JoinSignFileDomain> signFlieList = sign.getSignFlieList();
							List<Map<String, Object>> fileLocalMapList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> fileCloudMapList = new ArrayList<Map<String, Object>>();

							if (signFlieList != null && signFlieList.size() > 0) {
								for (JoinSignFileDomain file : signFlieList) {
									if ("0".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("node_id", file.getNodeId());
										fileLocalMapList.add(fileMap);
									} else if ("1".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("node_id", file.getNodeId());
										fileCloudMapList.add(fileMap);
									}
								}
							}
							signMap.put("sign_local_file", fileLocalMapList);
							signMap.put("sign_cloud_file", fileCloudMapList);
							checkSignList.add(signMap);
						}
					}

					checkMap.put("sign_list", checkSignList);

					// 获取驳回至信息
					// 根据审核id，查询驳回至的节点信息和审核人信息
					// List<Map<String, Object>> rejList =
					// processCommonService.queryRejectTagInfo(instId,
					// check.getId());

					List<Map<String, Object>> rejList = new ArrayList<Map<String, Object>>();
					FbBusRejectRule rej = check.getFbBusRejectRule();
					if (rej != null) {
						Map<String, Object> rejMap = new HashMap<String, Object>();
						rejMap.put("reject_tag_id", rej.getOldInstTag());
						rejMap.put("reject_tag_name", rej.getOldInstTagName());
						rejMap.put("reject_tag_assignee", check.getCheckEmpId());
						rejMap.put("reject_tag_assignee_name", check.getCheckEmpName());
						rejList.add(rejMap);
					}
					checkMap.put("reject_rule", rejList);
					// 获取审核附条件
					List<FbBusConditionDomain> conList = check.getConList();
					List<Map<String, Object>> checkConList = new ArrayList<Map<String, Object>>();
					if (conList != null && conList.size() > 0) {
						for (FbBusConditionDomain con : conList) {
							Map<String, Object> conMap = new HashMap<String, Object>();
							conMap.put("con_id", con.getId());
							conMap.put("rev_content", con.getRevContent());
							conMap.put("res_content", con.getResContent());
							conMap.put("con_status", con.getConStatus());
							// 获取附条件关联信息
							List<AddRelevanceDomain> addRelList = con.getAddRelList();
							List<Map<String, Object>> conInforRelList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> conFlowRelList = new ArrayList<Map<String, Object>>();
							if (addRelList != null && addRelList.size() > 0) {
								for (AddRelevanceDomain rel : addRelList) {
									if ("0".equals(rel.getRelType())) {// 讯息
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relMap.put("con_type", rel.getConType());
										conInforRelList.add(relMap);
									} else if ("1".equals(rel.getRelType())) {
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relMap.put("con_type", rel.getConType());
										conFlowRelList.add(relMap);
									}
								}
							}
							conMap.put("con_infor_rel", conInforRelList);
							conMap.put("con_flow_rel", conFlowRelList);
							// 获取附条件附件
							List<AddFileDomain> addFlieList = con.getAddFlieList();
							List<Map<String, Object>> conLocalFileList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> conCloudFileList = new ArrayList<Map<String, Object>>();

							if (addFlieList != null && addFlieList.size() > 0) {
								for (AddFileDomain file : addFlieList) {
									if ("0".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("con_type", file.getConType());
										fileMap.put("node_id", file.getNodeId());
										conLocalFileList.add(fileMap);
									} else if ("1".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("con_type", file.getConType());
										fileMap.put("node_id", file.getNodeId());
										conCloudFileList.add(fileMap);
									}
								}
							}
							conMap.put("con_local_file", conLocalFileList);
							conMap.put("con_cloud_file", conCloudFileList);

							checkConList.add(conMap);
						}
					}

					checkMap.put("con_list", checkConList);

					instCheckList.add(checkMap);
				}

			}
			resMap.put("check_list", instCheckList);

		}

		return resMap;
	}

	public Map<String, Object> doDetailList(Map<String, Object> map) throws Exception {
		String instId = (String) map.get("inst_id");
		// 查询该实例被关注过的节点
		FbBusCareExample careExample = new FbBusCareExample();
		com.zrt.mybatis.domain.FbBusCareExample.Criteria careCriteria = careExample.createCriteria();
		careCriteria.andInstIdEqualTo(instId);
		List<FbBusCare> careList = fbBusCareMapper.selectByExample(careExample);

		// 查询流程实例的发起人信息
		FbBusInst fbBusInst = fbBusInstMapper.selectByPrimaryKey(instId);
		Map<String, Object> resMap = new HashMap<String, Object>();
		// 待处理列表
		List<Map<String, Object>> doList = actProcessService.queryDoDeal(instId);
		for (Map<String, Object> doMap : doList) {
			Map<String, Object> conmap = new HashMap<>();
			String assignee = (String) doMap.get("check_emp_id");
			String checkOwner = (String) doMap.get("check_owner");//
			// 原审批人，委托情况下有值
			if (StringUtils.isNotBlank(checkOwner)) {// 待办节点的check_emp_id为被委托人，要去查他的委托人
				String entedEmpId = assignee;// 被委托人是实际审批人
				assignee = checkOwner;// 返回审批人是原审批人
				doMap.put("ented_emp_id", entedEmpId);
				Map<String, Object> entedMap = new HashMap<>();
				entedMap.put("search", entedEmpId);
				Map<String, Object> entedResult = contactsService.commonEmpSearch(entedMap);
				List<Map<String, Object>> entedLi = (List<Map<String, Object>>) entedResult.get("data");
				Map<String, Object> entedEmpData = null;
				if (null != entedLi && entedLi.size() > 0) {
					entedEmpData = entedLi.get(0);
					doMap.put("ented_emp_name", entedEmpData.get("emp_name"));
				}

			} else {// 待办以后的节点查出的check_emp_id为原委托人，要去查他是不是委托出去了
				// 根据发起id找原审核人信息
				List<Map<String, Object>> oldResList = flowEntrustCustomMapper.getOldEmp(instId);
				if (null != oldResList && !oldResList.isEmpty()) {
					for (Map<String, Object> oldResMap : oldResList) {
						if (assignee.equals(oldResMap.get("check_emp_id"))) {

							String checkEmpId = (String) oldResMap.get("check_emp_id");// 委托人id
							assignee = checkEmpId;

							String entEmpId = (String) oldResMap.get("ent_emp_id");// 受托人id
							String entEmpName = (String) oldResMap.get("ent_emp_name");// 受托人name

							doMap.put("ented_emp_id", entEmpId);
							doMap.put("ented_emp_name", entEmpName);
						}
					}
				}
			}
			if ((assignee != null && !"".equals(assignee)) || assignee.startsWith("${")) {
				if (assignee.startsWith("${apply_id}")) {// 代表发起人
					assignee = fbBusInst.getApplyId();
					break;
				}
			}
			conmap.put("search", assignee);
			Map<String, Object> result = contactsService.commonEmpSearch(conmap);

			List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
			Map<String, Object> empData = null;
			if (null != li && li.size() > 0) {
				empData = li.get(0);
				doMap.put("check_emp_name", empData.get("emp_name"));
				doMap.put("org_id", empData.get("org_id"));
				doMap.put("org_name", empData.get("org_name"));
				doMap.put("check_emp_head_photo", empData.get("emp_head_photo"));

			}
			doMap.put("care_flag", careFlag(careList, (String) doMap.get("inst_tag"), (String) map.get("emp_id")));// 是否关注
			doMap.put("sign_list", null);// 默认没有会签信息
			doMap.put("con_list", null);// 默认没有附条件信息

			// 审核id
			String checkId = (String) doMap.get("check_id");
			
			if (checkId != null && !"".equals(checkId)) {
				// 如果存在checkId,说明是当前待办，查询看是否有会签任务
				// 查询当前待办已经会签的信息
				
				FbBusFileExample fileExample=new FbBusFileExample();
				fileExample.createCriteria().andCheckIdEqualTo(checkId);
				List<FbBusFile> fileList=fbBusFileMapper.selectByExample(fileExample);
				
				List<Map<String, Object>> checkSignLocalFileList = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> checkSignCloudFileList = new ArrayList<Map<String, Object>>();
				if (fileList != null && fileList.size() > 0) {
					for (FbBusFile file : fileList) {
						if ("2".equals(file.getFbType()) && file.getCheckId().equals(checkId)) {
							if ("0".equals(file.getFileType())) {
								Map<String, Object> fileMap = new HashMap<String, Object>();
								fileMap.put("file_url", file.getFileUrl());
								fileMap.put("file_name", file.getFileName());
								fileMap.put("file_type", file.getFileType());
								fileMap.put("node_id", file.getNodeId());
								checkSignLocalFileList.add(fileMap);
							} else if ("1".equals(file.getFileType())) {
								Map<String, Object> fileMap = new HashMap<String, Object>();
								fileMap.put("file_url", file.getFileUrl());
								fileMap.put("file_name", file.getFileName());
								fileMap.put("file_type", file.getFileType());
								fileMap.put("node_id", file.getNodeId());
								checkSignCloudFileList.add(fileMap);
							}
						}
					}
				}
				doMap.put("check_sign_local_file", checkSignLocalFileList);
				doMap.put("check_sign_cloud_file", checkSignCloudFileList);
				
				FbBusRelevanceExample relevanceExample=new FbBusRelevanceExample();
				relevanceExample.createCriteria().andCheckIdEqualTo(checkId);
				List<FbBusRelevance> relList=fbBusRelevanceMapper.selectByExample(relevanceExample);

				List<Map<String, Object>> checkSignInforRelList = new ArrayList<Map<String, Object>>();
				List<Map<String, Object>> checkSignFlowRelList = new ArrayList<Map<String, Object>>();
				if (relList != null && relList.size() > 0) {
					for (FbBusRelevance rel : relList) {
						if ("2".equals(rel.getFbType()) && rel.getCheckId().equals(checkId)) {
							if ("0".equals(rel.getRelType())) {// 讯息
								Map<String, Object> relMap = new HashMap<String, Object>();
								relMap.put("rel_id", rel.getRelId());
								relMap.put("rel_name", rel.getRelName());
								relMap.put("rel_type", rel.getRelType());
								checkSignInforRelList.add(relMap);
							} else if ("1".equals(rel.getRelType())) {
								Map<String, Object> relMap = new HashMap<String, Object>();
								relMap.put("rel_id", rel.getRelId());
								relMap.put("rel_name", rel.getRelName());
								relMap.put("rel_type", rel.getRelType());
								checkSignFlowRelList.add(relMap);
							}

						}
					}
				}
				doMap.put("check_sign_infor_rel", checkSignInforRelList);
				doMap.put("check_sign_flow_rel", checkSignFlowRelList);
				
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("check_id", checkId);
				List<CheckDomain> checkList = flowDetailMapper.joinSignDetail(paramMap);
				if (!checkList.isEmpty()) {
					CheckDomain checkDomain = checkList.get(0);
					// 获取会签list
					List<JoinSignDomain> signList = checkDomain.getSignList();
					List<Map<String, Object>> checkSignList = new ArrayList<Map<String, Object>>();
					if (signList != null && signList.size() > 0) {
						for (JoinSignDomain sign : signList) {
							Map<String, Object> signMap = new HashMap<String, Object>();
							signMap.put("sign_id", sign.getId());
							signMap.put("sign_emp_id", sign.getSignEmpId());
							signMap.put("sign_emp_name", sign.getSignEmpName());
							signMap.put("check_status", sign.getCheckStatus());
							signMap.put("org_id", sign.getOrgId());
							signMap.put("org_name", sign.getOrgName());
							signMap.put("sign_status", sign.getSignStatus());
							signMap.put("check_comment", sign.getCheckComment());
							signMap.put("sign_desc", sign.getSignDesc());
							Map<String, Object> empMap = new HashMap<>();
							empMap.put("search", sign.getSignEmpId());
							Map<String, Object> empMapResult = contactsService.commonEmpSearch(empMap);
							List<Map<String, Object>> empMapList = (List<Map<String, Object>>) empMapResult.get("data");
							Map<String, Object> empMapData = null;
							if (null != empMapList && empMapList.size() > 0) {
								empMapData = empMapList.get(0);
								signMap.put("sign_emp_head_photo", empMapData.get("emp_head_photo"));
							}
							// 获取会签关联信息
							List<JoinSignRelevanceDomain> signRelList = sign.getSignRelList();
							List<Map<String, Object>> relInforMapList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> relFlowMapList = new ArrayList<Map<String, Object>>();

							if (signRelList != null && signRelList.size() > 0) {
								for (JoinSignRelevanceDomain rel : signRelList) {
									if ("0".equals(rel.getRelType())) {// 讯息
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relInforMapList.add(relMap);
									} else if ("1".equals(rel.getRelType())) {
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relFlowMapList.add(relMap);
									}
								}
							}
							signMap.put("sign_infor_rel", relInforMapList);
							signMap.put("sign_flow_rel", relFlowMapList);
							// 获取会签附件
							List<JoinSignFileDomain> signFlieList = sign.getSignFlieList();
							List<Map<String, Object>> fileLocalMapList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> fileCloudMapList = new ArrayList<Map<String, Object>>();

							if (signFlieList != null && signFlieList.size() > 0) {
								for (JoinSignFileDomain file : signFlieList) {
									if ("0".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("node_id", file.getNodeId());
										fileLocalMapList.add(fileMap);
									} else if ("1".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("node_id", file.getNodeId());
										fileCloudMapList.add(fileMap);
									}
								}
							}
							signMap.put("sign_local_file", fileLocalMapList);
							signMap.put("sign_cloud_file", fileCloudMapList);
							checkSignList.add(signMap);
						}
					}

					doMap.put("sign_list", checkSignList);

					//
					// 获取审核附条件
					List<FbBusConditionDomain> conList = checkDomain.getConList();
					List<Map<String, Object>> checkConList = new ArrayList<Map<String, Object>>();
					if (conList != null && conList.size() > 0) {
						for (FbBusConditionDomain con : conList) {
							Map<String, Object> conMap = new HashMap<String, Object>();
							conMap.put("con_id", con.getId());
							conMap.put("rev_content", con.getRevContent());
							conMap.put("res_content", con.getResContent());
							conMap.put("con_status", con.getConStatus());
							// 获取附条件关联信息
							List<AddRelevanceDomain> addRelList = con.getAddRelList();
							List<Map<String, Object>> conInforRelList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> conFlowRelList = new ArrayList<Map<String, Object>>();
							if (addRelList != null && addRelList.size() > 0) {
								for (AddRelevanceDomain rel : addRelList) {
									if ("0".equals(rel.getRelType())) {// 讯息
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relMap.put("con_type", rel.getConType());
										conInforRelList.add(relMap);
									} else if ("1".equals(rel.getRelType())) {
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relMap.put("con_type", rel.getConType());
										conFlowRelList.add(relMap);
									}
								}
							}
							conMap.put("con_infor_rel", conInforRelList);
							conMap.put("con_flow_rel", conFlowRelList);
							// 获取附条件附件
							List<AddFileDomain> addFlieList = con.getAddFlieList();
							List<Map<String, Object>> conLocalFileList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> conCloudFileList = new ArrayList<Map<String, Object>>();

							if (addFlieList != null && addFlieList.size() > 0) {
								for (AddFileDomain file : addFlieList) {
									if ("0".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("con_type", file.getConType());
										conLocalFileList.add(fileMap);
									} else if ("1".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("con_type", file.getConType());
										conCloudFileList.add(fileMap);
									}
								}
							}
							conMap.put("con_local_file", conLocalFileList);
							conMap.put("con_cloud_file", conCloudFileList);

							checkConList.add(conMap);
						}
					}

					doMap.put("con_list", checkConList);// 附条件信息
				}
			}

		}
		resMap.put("do_list", doList);
		return resMap;
	}

	public Map<String, Object> doPreDetailList(Map<String, Object> map) throws Exception {
		String instId = (String) map.get("inst_id");
		// 登录人id
		String empId = (String) map.get("emp_id");
		Map<String, Object> resMap = new HashMap<String, Object>();
		// 待处理列表
		List<Map<String, Object>> doList = actProcessService.queryDoDeal(instId);

		// 查询该流程实例已经预处理过的信息
		FbBusPredealExample preExample = new FbBusPredealExample();
		Criteria preCriteria = preExample.createCriteria();
		preCriteria.andInstIdEqualTo(instId);
		// preCriteria.andPreStatusEqualTo("0");// 该预处理未经过
		List<FbBusPredeal> preList = fbBusPredealMapper.selectByExample(preExample);

		for (Map<String, Object> doMap : doList) {
			Map<String, Object> conmap = new HashMap<>();
			conmap.put("search", doMap.get("check_emp_id"));
			Map<String, Object> result = contactsService.commonEmpSearch(conmap);

			List<Map<String, Object>> li = (List<Map<String, Object>>) result.get("data");
			Map<String, Object> empData = null;
			if (null != li && li.size() > 0) {
				empData = li.get(0);
				doMap.put("check_emp_name", empData.get("emp_name"));
				doMap.put("org_id", empData.get("org_id"));
				doMap.put("org_name", empData.get("org_name"));
				doMap.put("check_emp_head_photo", empData.get("emp_head_photo"));

			}

			// 预处理id
			doMap.put("pre_id", null);
			// 预处理结果
			doMap.put("pre_check_status", null);
			for (FbBusPredeal pre : preList) {
				String pre_check_emp_id = pre.getCheckEmpId();
				String pre_check_status = pre.getCheckStatus();// 预处理结果
				if (pre_check_emp_id.equals(empId)) {
					// 如果预处理人和未审批的信息相同就加上预处理信息
					doMap.put("pre_id", pre.getId());
					doMap.put("pre_check_status", pre_check_status);
					break;
				}
			}

			doMap.put("sign_list", null);// 默认没有会签信息
			// 审核id
			String checkId = (String) doMap.get("check_id");
			if (checkId != null && !"".equals(checkId)) {
				// 如果存在checkId,说明是当前待办，查询看是否有会签任务
				// 查询当前待办已经会签的信息
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("check_id", checkId);
				List<CheckDomain> checkList = flowDetailMapper.joinSignDetail(paramMap);
				if (!checkList.isEmpty()) {
					CheckDomain checkDomain = checkList.get(0);
					// 获取会签list
					List<JoinSignDomain> signList = checkDomain.getSignList();
					List<Map<String, Object>> checkSignList = new ArrayList<Map<String, Object>>();
					if (signList != null && signList.size() > 0) {
						for (JoinSignDomain sign : signList) {
							Map<String, Object> signMap = new HashMap<String, Object>();
							signMap.put("sign_id", sign.getId());
							signMap.put("sign_emp_id", sign.getSignEmpId());
							signMap.put("sign_emp_name", sign.getSignEmpName());
							signMap.put("check_status", sign.getCheckStatus());
							signMap.put("org_id", sign.getOrgId());
							signMap.put("org_name", sign.getOrgName());
							signMap.put("sign_status", sign.getSignStatus());
							signMap.put("check_comment", sign.getCheckComment());
							// 获取会签关联信息
							List<JoinSignRelevanceDomain> signRelList = sign.getSignRelList();
							List<Map<String, Object>> relInforMapList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> relFlowMapList = new ArrayList<Map<String, Object>>();

							if (signRelList != null && signRelList.size() > 0) {
								for (JoinSignRelevanceDomain rel : signRelList) {
									if ("0".equals(rel.getRelType())) {// 讯息
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relInforMapList.add(relMap);
									} else if ("1".equals(rel.getRelType())) {
										Map<String, Object> relMap = new HashMap<String, Object>();
										relMap.put("rel_id", rel.getRelId());
										relMap.put("rel_name", rel.getRelName());
										relMap.put("rel_type", rel.getRelType());
										relFlowMapList.add(relMap);
									}
								}
							}
							signMap.put("sign_infor_rel", relInforMapList);
							signMap.put("sign_flow_rel", relFlowMapList);
							// 获取会签附件
							List<JoinSignFileDomain> signFlieList = sign.getSignFlieList();
							List<Map<String, Object>> fileLocalMapList = new ArrayList<Map<String, Object>>();
							List<Map<String, Object>> fileCloudMapList = new ArrayList<Map<String, Object>>();

							if (signFlieList != null && signFlieList.size() > 0) {
								for (JoinSignFileDomain file : signFlieList) {
									if ("0".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("node_id", file.getNodeId());
										fileLocalMapList.add(fileMap);
									} else if ("1".equals(file.getFileType())) {
										Map<String, Object> fileMap = new HashMap<String, Object>();
										fileMap.put("file_url", file.getFileUrl());
										fileMap.put("file_name", file.getFileName());
										fileMap.put("file_type", file.getFileType());
										fileMap.put("node_id", file.getNodeId());
										fileCloudMapList.add(fileMap);
									}
								}
							}
							signMap.put("sign_local_file", fileLocalMapList);
							signMap.put("sign_cloud_file", fileCloudMapList);
							checkSignList.add(signMap);
						}
					}

					doMap.put("sign_list", checkSignList);
				}
			}
		}
		resMap.put("do_list", doList);
		return resMap;
	}

	/**
	 * 判断是否关注过该节点
	 */
	public String careFlag(List<FbBusCare> careList, String tagId, String empId) {
		String careTag = "0";
		for (FbBusCare care : careList) {
			String instTag = care.getInstTag();// 节点id
			String careEmpId = care.getEmpId();// 关注人id
			if (instTag.equals(tagId) && careEmpId.equals(empId)) {
				careTag = "1";
				break;
			}
		}
		return careTag;
	}
}

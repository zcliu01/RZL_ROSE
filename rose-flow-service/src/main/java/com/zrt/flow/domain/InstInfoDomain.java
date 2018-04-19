package com.zrt.flow.domain;

import java.util.List;

import com.zrt.mybatis.domain.FbBusEntrust;
import com.zrt.mybatis.domain.FbBusProject;

public class InstInfoDomain {
	

	private String instId;
	
	private String applyId;
	private String applyName;
	private String orgId;
	private String orgName;
	private String fbTitle;
	private String fbContent;
	private String startDateTime;
	private String instStatus;
	private String fbId;
	private String tName;
	private String tCode;
	private String projectFlag;
	private String handleFlag;
	private String tTypeId;
	private String tTypeName;
	private String parentTTypeId;
	private String parentTTypeName;
	//预处理人id
	private String predealId;
	//预处理人名称
	private String predealName;
	//预处理id
	private String preId;
	//预处理节点id
    private String preTagId;
    //预处理节点名称
	private String preTagName;
	//预处理状态
	private String preStatus;
	
	
    //会签id审批类型（0：普通，1：会签）
	private String checkType;
	//会签id审批类型（0：普通，1：会签）
    private String signId;
    
    //签报id
    private String handleId;
    
    private String notifyId;
    //
    private String telEmpId;
    //
    private String telEmpName;
    //
    private String telOrgId;
    //
    private String telOrgName;
    //
    private String notifyEmpId;
    //
    private String notifyEmpName;
    //
    private String notifyOrgId;
    //
    private String notifyOrgName;
    
  //一对多任务
  	private List<TaskDomain> taskList;
    //一对多
  	private List<NotifyEmpDomain> notifyEmpList;
    
  	/***一对多委托列表**/
	private List<FbBusEntrust> entList;
  	
	private List<FbBusProject> projectList;
  	
  	
	public String getHandleId() {
		return handleId;
	}
	public void setHandleId(String handleId) {
		this.handleId = handleId;
	}
	public String getPreStatus() {
		return preStatus;
	}
	public void setPreStatus(String preStatus) {
		this.preStatus = preStatus;
	}
	public String getPreTagId() {
		return preTagId;
	}
	public void setPreTagId(String preTagId) {
		this.preTagId = preTagId;
	}
	public String getPreTagName() {
		return preTagName;
	}
	public void setPreTagName(String preTagName) {
		this.preTagName = preTagName;
	}
	public String getNotifyId() {
		return notifyId;
	}
	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}
	public List<NotifyEmpDomain> getNotifyEmpList() {
		return notifyEmpList;
	}
	public void setNotifyEmpList(List<NotifyEmpDomain> notifyEmpList) {
		this.notifyEmpList = notifyEmpList;
	}
	public String getTelEmpId() {
		return telEmpId;
	}
	public void setTelEmpId(String telEmpId) {
		this.telEmpId = telEmpId;
	}
	public String getTelEmpName() {
		return telEmpName;
	}
	public void setTelEmpName(String telEmpName) {
		this.telEmpName = telEmpName;
	}
	public String getTelOrgId() {
		return telOrgId;
	}
	public void setTelOrgId(String telOrgId) {
		this.telOrgId = telOrgId;
	}
	public String getTelOrgName() {
		return telOrgName;
	}
	public void setTelOrgName(String telOrgName) {
		this.telOrgName = telOrgName;
	}
	public String getNotifyEmpId() {
		return notifyEmpId;
	}
	public void setNotifyEmpId(String notifyEmpId) {
		this.notifyEmpId = notifyEmpId;
	}
	public String getNotifyEmpName() {
		return notifyEmpName;
	}
	public void setNotifyEmpName(String notifyEmpName) {
		this.notifyEmpName = notifyEmpName;
	}
	public String getNotifyOrgId() {
		return notifyOrgId;
	}
	public void setNotifyOrgId(String notifyOrgId) {
		this.notifyOrgId = notifyOrgId;
	}
	public String getNotifyOrgName() {
		return notifyOrgName;
	}
	public void setNotifyOrgName(String notifyOrgName) {
		this.notifyOrgName = notifyOrgName;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getSignId() {
		return signId;
	}
	public void setSignId(String signId) {
		this.signId = signId;
	}
	
	
	
	
	
	
	
	public String getPredealId() {
		return predealId;
	}
	public void setPredealId(String predealId) {
		this.predealId = predealId;
	}
	public String getPredealName() {
		return predealName;
	}
	public void setPredealName(String predealName) {
		this.predealName = predealName;
	}
	public String getPreId() {
		return preId;
	}
	public void setPreId(String preId) {
		this.preId = preId;
	}
	public List<TaskDomain> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<TaskDomain> taskList) {
		this.taskList = taskList;
	}
	public String getInstId() {
		return instId;
	}
	public void setInstId(String instId) {
		this.instId = instId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getFbTitle() {
		return fbTitle;
	}
	public void setFbTitle(String fbTitle) {
		this.fbTitle = fbTitle;
	}
	public String getFbContent() {
		return fbContent;
	}
	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getInstStatus() {
		return instStatus;
	}
	public void setInstStatus(String instStatus) {
		this.instStatus = instStatus;
	}
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettCode() {
		return tCode;
	}
	public void settCode(String tCode) {
		this.tCode = tCode;
	}
	public String gettTypeId() {
		return tTypeId;
	}
	public void settTypeId(String tTypeId) {
		this.tTypeId = tTypeId;
	}
	public String gettTypeName() {
		return tTypeName;
	}
	public void settTypeName(String tTypeName) {
		this.tTypeName = tTypeName;
	}
	public String getParentTTypeId() {
		return parentTTypeId;
	}
	public void setParentTTypeId(String parentTTypeId) {
		this.parentTTypeId = parentTTypeId;
	}
	public String getParentTTypeName() {
		return parentTTypeName;
	}
	public void setParentTTypeName(String parentTTypeName) {
		this.parentTTypeName = parentTTypeName;
	}
	public List<FbBusEntrust> getEntList() {
		return entList;
	}
	public void setEntList(List<FbBusEntrust> entList) {
		this.entList = entList;
	}
	public String getProjectFlag() {
		return projectFlag;
	}
	public void setProjectFlag(String projectFlag) {
		this.projectFlag = projectFlag;
	}
	public String getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(String handleFlag) {
		this.handleFlag = handleFlag;
	}
	public List<FbBusProject> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<FbBusProject> projectList) {
		this.projectList = projectList;
	}
	
	
	
	
	
}

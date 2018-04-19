package com.zrt.flow.domain;

public class TaskDomain {

	  
	  private String taskId;
	  private String procInstId;
	  private String curTagId;
	  private String curTagName;
	  private String curTagAssignee;
	  private String deleteReason;
	  private String endTime;
	  private String duration;
	  private String roleEmpId;
	  private String groupUserId;
	  
	  
	 
	public String getRoleEmpId() {
		return roleEmpId;
	}
	public void setRoleEmpId(String roleEmpId) {
		this.roleEmpId = roleEmpId;
	}
	public String getGroupUserId() {
		return groupUserId;
	}
	public void setGroupUserId(String groupUserId) {
		this.groupUserId = groupUserId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getProcInstId() {
		return procInstId;
	}
	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}
	public String getCurTagId() {
		return curTagId;
	}
	public void setCurTagId(String curTagId) {
		this.curTagId = curTagId;
	}
	public String getCurTagName() {
		return curTagName;
	}
	public void setCurTagName(String curTagName) {
		this.curTagName = curTagName;
	}
	public String getCurTagAssignee() {
		return curTagAssignee;
	}
	public void setCurTagAssignee(String curTagAssignee) {
		this.curTagAssignee = curTagAssignee;
	}
	public String getDeleteReason() {
		return deleteReason;
	}
	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	  
	  
	  
	  
}

package com.zrt.flow.domain;

import java.util.List;

import com.zrt.mybatis.domain.FbBusEntrust;
import com.zrt.mybatis.domain.FbBusPredeal;

public class InstDomain {

	private String id;

	private String applyId;

	private String applyName;

	private String orgId;

	private String orgName;

	private String fbId;

	private String fbTitle;

	private String createDateTime;

	private String startDateTime;

	private String updateDateTime;

	private String instStatus;

	private String tenantId;

	private String instTag;

	private String instTagName;

	private String fbContent;

	/** 一对一 **/
	private FbBusTemplateDomain fbDomain;

	/** 一对多 **/
	private List<CheckDomain> checkList;
	/***一对多附件**/
	private List<FileDomain> fileList;
	private List<RelevanceDomain> relList;
	/***一对多项目**/
	private List<ProjectDomain> projectList;
	/***一对多委托列表**/
	private List<FbBusEntrust> entList;
	/***一对受托托列表**/
	private List<FbBusEntrust> entedList;
	/***一对多流程预处理**/
	private List<FbBusPredeal> preList;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public String getFbTitle() {
		return fbTitle;
	}

	public void setFbTitle(String fbTitle) {
		this.fbTitle = fbTitle;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getInstStatus() {
		return instStatus;
	}

	public void setInstStatus(String instStatus) {
		this.instStatus = instStatus;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getInstTag() {
		return instTag;
	}

	public void setInstTag(String instTag) {
		this.instTag = instTag;
	}

	public String getInstTagName() {
		return instTagName;
	}

	public void setInstTagName(String instTagName) {
		this.instTagName = instTagName;
	}

	public String getFbContent() {
		return fbContent;
	}

	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}

	public FbBusTemplateDomain getFbDomain() {
		return fbDomain;
	}

	public void setFbDomain(FbBusTemplateDomain fbDomain) {
		this.fbDomain = fbDomain;
	}

	public List<CheckDomain> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<CheckDomain> checkList) {
		this.checkList = checkList;
	}

	public List<FileDomain> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileDomain> fileList) {
		this.fileList = fileList;
	}

	public List<RelevanceDomain> getRelList() {
		return relList;
	}

	public void setRelList(List<RelevanceDomain> relList) {
		this.relList = relList;
	}

	public List<ProjectDomain> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectDomain> projectList) {
		this.projectList = projectList;
	}

	public List<FbBusEntrust> getEntList() {
		return entList;
	}

	public void setEntList(List<FbBusEntrust> entList) {
		this.entList = entList;
	}

	public List<FbBusPredeal> getPreList() {
		return preList;
	}

	public void setPreList(List<FbBusPredeal> preList) {
		this.preList = preList;
	}

	public List<FbBusEntrust> getEntedList() {
		return entedList;
	}

	public void setEntedList(List<FbBusEntrust> entedList) {
		this.entedList = entedList;
	}

}

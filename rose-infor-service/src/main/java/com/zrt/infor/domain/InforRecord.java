package com.zrt.infor.domain;

import java.util.List;

/**
 * Created by msKui on 2017/3/22.
 */
public class InforRecord {
	private String inforId;

	private String tenantId;

	private String inforNo;

	private String parentNo;

	private String inforCode;

	private String title;

	private String category;

	private String type;

	private String createEmpId;

	private String createEmpName;

	private String createDateTime;

	private String updateEmpId;

	private String updateEmpName;

	private String updateDateTime;

	private String inforVersion;

	private String content;

	private String busId;

	private String busType;

	private String busDomain;

	public String getInforId() {
		return inforId;
	}

	public void setInforId(String inforId) {
		this.inforId = inforId == null ? null : inforId.trim();
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId == null ? null : tenantId.trim();
	}

	public String getInforNo() {
		return inforNo;
	}

	public void setInforNo(String inforNo) {
		this.inforNo = inforNo == null ? null : inforNo.trim();
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo == null ? null : parentNo.trim();
	}

	public String getInforCode() {
		return inforCode;
	}

	public void setInforCode(String inforCode) {
		this.inforCode = inforCode == null ? null : inforCode.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category == null ? null : category.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getCreateEmpId() {
		return createEmpId;
	}

	public void setCreateEmpId(String createEmpId) {
		this.createEmpId = createEmpId == null ? null : createEmpId.trim();
	}

	public String getCreateEmpName() {
		return createEmpName;
	}

	public void setCreateEmpName(String createEmpName) {
		this.createEmpName = createEmpName == null ? null : createEmpName.trim();
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime == null ? null : createDateTime.trim();
	}

	public String getUpdateEmpId() {
		return updateEmpId;
	}

	public void setUpdateEmpId(String updateEmpId) {
		this.updateEmpId = updateEmpId == null ? null : updateEmpId.trim();
	}

	public String getUpdateEmpName() {
		return updateEmpName;
	}

	public void setUpdateEmpName(String updateEmpName) {
		this.updateEmpName = updateEmpName == null ? null : updateEmpName.trim();
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime == null ? null : updateDateTime.trim();
	}

	public String getInforVersion() {
		return inforVersion;
	}

	public void setInforVersion(String inforVersion) {
		this.inforVersion = inforVersion == null ? null : inforVersion.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusDomain() {
		return busDomain;
	}

	public void setBusDomain(String busDomain) {
		this.busDomain = busDomain;
	}
}

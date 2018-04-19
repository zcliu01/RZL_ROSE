package com.zrt.mybatis.domain;

public class SysSecOrg {
    private String orgId;

    private String rootOrgId;

    private String parentOrgId;

    private String rootBrOrgId;

    private String orgName;

    private String orgCode;

    private String orgDesc;

    private Integer orgLevel;

    private String orgType;

    private Integer secOrder;

    private String secEnabled;

    private String secSysFlag;

    private String secReadonlyFlag;

    private String secDeleteFlag;

    private Integer version;

    private String createDateTime;

    private String updateDateTime;

    private String tenantId;

    private String groupType;

    private String manageEmpId;

    private String manageEmpName;

    private String chargeEmpId;

    private String chargeEmpName;

    private String headEmpId;

    private String headEmpName;

    private String seniorEmpId;

    private String seniorEmpName;

    private String leaderEmpId;

    private String leaderEmpName;

    private String orgCodeView;

    private String orgNameView;

    private String orgNameOwner;

    private String orgNameAll;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getRootOrgId() {
        return rootOrgId;
    }

    public void setRootOrgId(String rootOrgId) {
        this.rootOrgId = rootOrgId == null ? null : rootOrgId.trim();
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId == null ? null : parentOrgId.trim();
    }

    public String getRootBrOrgId() {
        return rootBrOrgId;
    }

    public void setRootBrOrgId(String rootBrOrgId) {
        this.rootBrOrgId = rootBrOrgId == null ? null : rootBrOrgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc == null ? null : orgDesc.trim();
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public Integer getSecOrder() {
        return secOrder;
    }

    public void setSecOrder(Integer secOrder) {
        this.secOrder = secOrder;
    }

    public String getSecEnabled() {
        return secEnabled;
    }

    public void setSecEnabled(String secEnabled) {
        this.secEnabled = secEnabled == null ? null : secEnabled.trim();
    }

    public String getSecSysFlag() {
        return secSysFlag;
    }

    public void setSecSysFlag(String secSysFlag) {
        this.secSysFlag = secSysFlag == null ? null : secSysFlag.trim();
    }

    public String getSecReadonlyFlag() {
        return secReadonlyFlag;
    }

    public void setSecReadonlyFlag(String secReadonlyFlag) {
        this.secReadonlyFlag = secReadonlyFlag == null ? null : secReadonlyFlag.trim();
    }

    public String getSecDeleteFlag() {
        return secDeleteFlag;
    }

    public void setSecDeleteFlag(String secDeleteFlag) {
        this.secDeleteFlag = secDeleteFlag == null ? null : secDeleteFlag.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime == null ? null : updateDateTime.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType == null ? null : groupType.trim();
    }

    public String getManageEmpId() {
        return manageEmpId;
    }

    public void setManageEmpId(String manageEmpId) {
        this.manageEmpId = manageEmpId == null ? null : manageEmpId.trim();
    }

    public String getManageEmpName() {
        return manageEmpName;
    }

    public void setManageEmpName(String manageEmpName) {
        this.manageEmpName = manageEmpName == null ? null : manageEmpName.trim();
    }

    public String getChargeEmpId() {
        return chargeEmpId;
    }

    public void setChargeEmpId(String chargeEmpId) {
        this.chargeEmpId = chargeEmpId == null ? null : chargeEmpId.trim();
    }

    public String getChargeEmpName() {
        return chargeEmpName;
    }

    public void setChargeEmpName(String chargeEmpName) {
        this.chargeEmpName = chargeEmpName == null ? null : chargeEmpName.trim();
    }

    public String getHeadEmpId() {
        return headEmpId;
    }

    public void setHeadEmpId(String headEmpId) {
        this.headEmpId = headEmpId == null ? null : headEmpId.trim();
    }

    public String getHeadEmpName() {
        return headEmpName;
    }

    public void setHeadEmpName(String headEmpName) {
        this.headEmpName = headEmpName == null ? null : headEmpName.trim();
    }

    public String getSeniorEmpId() {
        return seniorEmpId;
    }

    public void setSeniorEmpId(String seniorEmpId) {
        this.seniorEmpId = seniorEmpId == null ? null : seniorEmpId.trim();
    }

    public String getSeniorEmpName() {
        return seniorEmpName;
    }

    public void setSeniorEmpName(String seniorEmpName) {
        this.seniorEmpName = seniorEmpName == null ? null : seniorEmpName.trim();
    }

    public String getLeaderEmpId() {
        return leaderEmpId;
    }

    public void setLeaderEmpId(String leaderEmpId) {
        this.leaderEmpId = leaderEmpId == null ? null : leaderEmpId.trim();
    }

    public String getLeaderEmpName() {
        return leaderEmpName;
    }

    public void setLeaderEmpName(String leaderEmpName) {
        this.leaderEmpName = leaderEmpName == null ? null : leaderEmpName.trim();
    }

    public String getOrgCodeView() {
        return orgCodeView;
    }

    public void setOrgCodeView(String orgCodeView) {
        this.orgCodeView = orgCodeView == null ? null : orgCodeView.trim();
    }

    public String getOrgNameView() {
        return orgNameView;
    }

    public void setOrgNameView(String orgNameView) {
        this.orgNameView = orgNameView == null ? null : orgNameView.trim();
    }

    public String getOrgNameOwner() {
        return orgNameOwner;
    }

    public void setOrgNameOwner(String orgNameOwner) {
        this.orgNameOwner = orgNameOwner == null ? null : orgNameOwner.trim();
    }

    public String getOrgNameAll() {
        return orgNameAll;
    }

    public void setOrgNameAll(String orgNameAll) {
        this.orgNameAll = orgNameAll == null ? null : orgNameAll.trim();
    }
}
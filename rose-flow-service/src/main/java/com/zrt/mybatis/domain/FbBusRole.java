package com.zrt.mybatis.domain;

public class FbBusRole {
    private String roleId;

    private String roleCode;

    private String orgId;

    private String orgLevelType;

    private String roleName;

    private String roleDesc;

    private Integer secOrder;

    private String secEnabled;

    private String secSysFlag;

    private String secReadonlyFlag;

    private String secDeleteFlag;

    private String createDateTime;

    private String updateDateTime;

    private Integer version;

    private String groupCode;

    private String tenantId;

    private String roleType;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgLevelType() {
        return orgLevelType;
    }

    public void setOrgLevelType(String orgLevelType) {
        this.orgLevelType = orgLevelType == null ? null : orgLevelType.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }
}
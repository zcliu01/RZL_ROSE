package com.zrt.mybatis.domain;

public class SysSecUser {
    private String userId;

    private String userAccount;

    private String userPassword;

    private String userDesc;

    private Integer secOrder;

    private String secEnabled;

    private String secSysFlag;

    private String secReadonlyFlag;

    private String secDeleteFlag;

    private Integer version;

    private String createDateTime;

    private String updateDateTime;

    private String tenantId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc == null ? null : userDesc.trim();
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
}
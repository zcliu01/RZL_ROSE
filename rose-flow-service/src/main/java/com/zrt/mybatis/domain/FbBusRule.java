package com.zrt.mybatis.domain;

public class FbBusRule {
    private String id;

    private String fbId;

    private String instTag;

    private String instTagName;

    private String checkEmpId;

    private String checkEmpName;

    private String orgId;

    private String orgName;

    private Integer ruleOrder;

    private String beginDateTime;

    private String endDateTime;

    private String createDateTime;

    private String updateDateTime;

    private String ruleEnabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId == null ? null : fbId.trim();
    }

    public String getInstTag() {
        return instTag;
    }

    public void setInstTag(String instTag) {
        this.instTag = instTag == null ? null : instTag.trim();
    }

    public String getInstTagName() {
        return instTagName;
    }

    public void setInstTagName(String instTagName) {
        this.instTagName = instTagName == null ? null : instTagName.trim();
    }

    public String getCheckEmpId() {
        return checkEmpId;
    }

    public void setCheckEmpId(String checkEmpId) {
        this.checkEmpId = checkEmpId == null ? null : checkEmpId.trim();
    }

    public String getCheckEmpName() {
        return checkEmpName;
    }

    public void setCheckEmpName(String checkEmpName) {
        this.checkEmpName = checkEmpName == null ? null : checkEmpName.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Integer getRuleOrder() {
        return ruleOrder;
    }

    public void setRuleOrder(Integer ruleOrder) {
        this.ruleOrder = ruleOrder;
    }

    public String getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(String beginDateTime) {
        this.beginDateTime = beginDateTime == null ? null : beginDateTime.trim();
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime == null ? null : endDateTime.trim();
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

    public String getRuleEnabled() {
        return ruleEnabled;
    }

    public void setRuleEnabled(String ruleEnabled) {
        this.ruleEnabled = ruleEnabled == null ? null : ruleEnabled.trim();
    }
}
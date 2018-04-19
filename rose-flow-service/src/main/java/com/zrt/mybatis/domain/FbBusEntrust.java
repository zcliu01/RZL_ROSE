package com.zrt.mybatis.domain;

public class FbBusEntrust {
    private String id;

    private String fbId;

    private String checkEmpId;

    private String checkEmpName;

    private String entEmpId;

    private String entEmpName;

    private String instTag;

    private String instTagName;

    private String beginDateTime;

    private String endDateTime;

    private String createDateTime;

    private String entEnabled;

    private String fbCode;

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

    public String getEntEmpId() {
        return entEmpId;
    }

    public void setEntEmpId(String entEmpId) {
        this.entEmpId = entEmpId == null ? null : entEmpId.trim();
    }

    public String getEntEmpName() {
        return entEmpName;
    }

    public void setEntEmpName(String entEmpName) {
        this.entEmpName = entEmpName == null ? null : entEmpName.trim();
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

    public String getEntEnabled() {
        return entEnabled;
    }

    public void setEntEnabled(String entEnabled) {
        this.entEnabled = entEnabled == null ? null : entEnabled.trim();
    }

    public String getFbCode() {
        return fbCode;
    }

    public void setFbCode(String fbCode) {
        this.fbCode = fbCode == null ? null : fbCode.trim();
    }
}
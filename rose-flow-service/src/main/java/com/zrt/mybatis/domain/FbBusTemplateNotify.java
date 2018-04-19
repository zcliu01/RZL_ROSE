package com.zrt.mybatis.domain;

public class FbBusTemplateNotify {
    private String id;

    private String tCode;

    private String notifyEmpId;

    private String notifyEmpName;

    private String createDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode == null ? null : tCode.trim();
    }

    public String getNotifyEmpId() {
        return notifyEmpId;
    }

    public void setNotifyEmpId(String notifyEmpId) {
        this.notifyEmpId = notifyEmpId == null ? null : notifyEmpId.trim();
    }

    public String getNotifyEmpName() {
        return notifyEmpName;
    }

    public void setNotifyEmpName(String notifyEmpName) {
        this.notifyEmpName = notifyEmpName == null ? null : notifyEmpName.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }
}
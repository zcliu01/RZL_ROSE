package com.zrt.mybatis.domain;

public class FbBusRule_detail {
    private String id;

    private String ruleId;

    private String colCode;

    private String colFlag;

    private String colValue;

    private String createDateTime;

    private String updateDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public String getColCode() {
        return colCode;
    }

    public void setColCode(String colCode) {
        this.colCode = colCode == null ? null : colCode.trim();
    }

    public String getColFlag() {
        return colFlag;
    }

    public void setColFlag(String colFlag) {
        this.colFlag = colFlag == null ? null : colFlag.trim();
    }

    public String getColValue() {
        return colValue;
    }

    public void setColValue(String colValue) {
        this.colValue = colValue == null ? null : colValue.trim();
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
}
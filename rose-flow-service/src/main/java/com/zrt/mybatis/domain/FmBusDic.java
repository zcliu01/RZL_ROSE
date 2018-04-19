package com.zrt.mybatis.domain;

public class FmBusDic {
    private String colCode;

    private String colName;

    private String colEnabled;

    private String colType;

    private String colGroup;

    private String colValue;

    private String cueValue;

    private String reqFlag;

    private Integer maxLen;

    private Integer minLen;

    private String colDesc;

    private String createDateTime;

    private String keyValue;

    public String getColCode() {
        return colCode;
    }

    public void setColCode(String colCode) {
        this.colCode = colCode == null ? null : colCode.trim();
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName == null ? null : colName.trim();
    }

    public String getColEnabled() {
        return colEnabled;
    }

    public void setColEnabled(String colEnabled) {
        this.colEnabled = colEnabled == null ? null : colEnabled.trim();
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType == null ? null : colType.trim();
    }

    public String getColGroup() {
        return colGroup;
    }

    public void setColGroup(String colGroup) {
        this.colGroup = colGroup == null ? null : colGroup.trim();
    }

    public String getColValue() {
        return colValue;
    }

    public void setColValue(String colValue) {
        this.colValue = colValue == null ? null : colValue.trim();
    }

    public String getCueValue() {
        return cueValue;
    }

    public void setCueValue(String cueValue) {
        this.cueValue = cueValue == null ? null : cueValue.trim();
    }

    public String getReqFlag() {
        return reqFlag;
    }

    public void setReqFlag(String reqFlag) {
        this.reqFlag = reqFlag == null ? null : reqFlag.trim();
    }

    public Integer getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(Integer maxLen) {
        this.maxLen = maxLen;
    }

    public Integer getMinLen() {
        return minLen;
    }

    public void setMinLen(Integer minLen) {
        this.minLen = minLen;
    }

    public String getColDesc() {
        return colDesc;
    }

    public void setColDesc(String colDesc) {
        this.colDesc = colDesc == null ? null : colDesc.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue == null ? null : keyValue.trim();
    }
}
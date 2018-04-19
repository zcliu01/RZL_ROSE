package com.zrt.mybatis.domain;

public class FbBusData {
    private String id;

    private String colText;

    private String instId;

    private String colCode;

    private String colTitle;

    private String colType;

    private Integer version;

    private String instTag;

    private String instTagName;

    private String colValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getColText() {
        return colText;
    }

    public void setColText(String colText) {
        this.colText = colText == null ? null : colText.trim();
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public String getColCode() {
        return colCode;
    }

    public void setColCode(String colCode) {
        this.colCode = colCode == null ? null : colCode.trim();
    }

    public String getColTitle() {
        return colTitle;
    }

    public void setColTitle(String colTitle) {
        this.colTitle = colTitle == null ? null : colTitle.trim();
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType == null ? null : colType.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public String getColValue() {
        return colValue;
    }

    public void setColValue(String colValue) {
        this.colValue = colValue == null ? null : colValue.trim();
    }
}
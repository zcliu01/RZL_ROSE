package com.zrt.mybatis.domain;

public class FbBusDicParam {
    private String id;

    private String colCode;

    private String paramCode;

    private String paramEnabled;

    private String createDateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getColCode() {
        return colCode;
    }

    public void setColCode(String colCode) {
        this.colCode = colCode == null ? null : colCode.trim();
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode == null ? null : paramCode.trim();
    }

    public String getParamEnabled() {
        return paramEnabled;
    }

    public void setParamEnabled(String paramEnabled) {
        this.paramEnabled = paramEnabled == null ? null : paramEnabled.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }
}
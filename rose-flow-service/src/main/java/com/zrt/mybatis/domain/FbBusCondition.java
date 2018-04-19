package com.zrt.mybatis.domain;

public class FbBusCondition {
    private String id;

    private String instId;

    private String checkId;

    private String createDateTime;

    private String resDateTime;

    private String revDateTime;

    private String resContent;

    private String revContent;

    private String conStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime == null ? null : createDateTime.trim();
    }

    public String getResDateTime() {
        return resDateTime;
    }

    public void setResDateTime(String resDateTime) {
        this.resDateTime = resDateTime == null ? null : resDateTime.trim();
    }

    public String getRevDateTime() {
        return revDateTime;
    }

    public void setRevDateTime(String revDateTime) {
        this.revDateTime = revDateTime == null ? null : revDateTime.trim();
    }

    public String getResContent() {
        return resContent;
    }

    public void setResContent(String resContent) {
        this.resContent = resContent == null ? null : resContent.trim();
    }

    public String getRevContent() {
        return revContent;
    }

    public void setRevContent(String revContent) {
        this.revContent = revContent == null ? null : revContent.trim();
    }

    public String getConStatus() {
        return conStatus;
    }

    public void setConStatus(String conStatus) {
        this.conStatus = conStatus == null ? null : conStatus.trim();
    }
}
package com.zrt.mybatis.domain;

public class PlatInforRelevance {
    private String relInforId;

    private String inforNo;

    private String relId;

    private String relName;

    private String relType;

    public String getRelInforId() {
        return relInforId;
    }

    public void setRelInforId(String relInforId) {
        this.relInforId = relInforId == null ? null : relInforId.trim();
    }

    public String getInforNo() {
        return inforNo;
    }

    public void setInforNo(String inforNo) {
        this.inforNo = inforNo == null ? null : inforNo.trim();
    }

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId == null ? null : relId.trim();
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName == null ? null : relName.trim();
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType == null ? null : relType.trim();
    }
}
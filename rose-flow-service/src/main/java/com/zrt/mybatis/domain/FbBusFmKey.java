package com.zrt.mybatis.domain;

public class FbBusFmKey {
    private String fbId;

    private String fmId;

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId == null ? null : fbId.trim();
    }

    public String getFmId() {
        return fmId;
    }

    public void setFmId(String fmId) {
        this.fmId = fmId == null ? null : fmId.trim();
    }
}
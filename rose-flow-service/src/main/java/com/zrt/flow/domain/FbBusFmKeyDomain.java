package com.zrt.flow.domain;

public class FbBusFmKeyDomain {
    private String fbId;

    private String fmId;
    
    private FmBusTemplateDomain fmDomain;

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

	public FmBusTemplateDomain getFmDomain() {
		return fmDomain;
	}

	public void setFmDomain(FmBusTemplateDomain fmDomain) {
		this.fmDomain = fmDomain;
	}
}
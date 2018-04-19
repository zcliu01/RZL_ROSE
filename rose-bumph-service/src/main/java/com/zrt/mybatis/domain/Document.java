package com.zrt.mybatis.domain;

public class Document {
    private String docId;

    private String docName;

    private String docNumber;

    private String docDate;

    private String docClasses;

    private String docType;

    private String docUrg;

    private String docSrc;

    private String docOwnerId;

    private String docOwner;

    private String docPhone;

    private String docOrg;

    private String docDispunit;

    private String remark;

    private String docState;

    private String relTime;

    private String sendim;

    private String sendinfo;

    private String tenantId;

    private String createDateTime;

    private String updateDateTime;

    private Integer docVersion;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber == null ? null : docNumber.trim();
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate == null ? null : docDate.trim();
    }

    public String getDocClasses() {
        return docClasses;
    }

    public void setDocClasses(String docClasses) {
        this.docClasses = docClasses == null ? null : docClasses.trim();
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }

    public String getDocUrg() {
        return docUrg;
    }

    public void setDocUrg(String docUrg) {
        this.docUrg = docUrg == null ? null : docUrg.trim();
    }

    public String getDocSrc() {
        return docSrc;
    }

    public void setDocSrc(String docSrc) {
        this.docSrc = docSrc == null ? null : docSrc.trim();
    }

    public String getDocOwnerId() {
        return docOwnerId;
    }

    public void setDocOwnerId(String docOwnerId) {
        this.docOwnerId = docOwnerId == null ? null : docOwnerId.trim();
    }

    public String getDocOwner() {
        return docOwner;
    }

    public void setDocOwner(String docOwner) {
        this.docOwner = docOwner == null ? null : docOwner.trim();
    }

    public String getDocPhone() {
        return docPhone;
    }

    public void setDocPhone(String docPhone) {
        this.docPhone = docPhone == null ? null : docPhone.trim();
    }

    public String getDocOrg() {
        return docOrg;
    }

    public void setDocOrg(String docOrg) {
        this.docOrg = docOrg == null ? null : docOrg.trim();
    }

    public String getDocDispunit() {
        return docDispunit;
    }

    public void setDocDispunit(String docDispunit) {
        this.docDispunit = docDispunit == null ? null : docDispunit.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDocState() {
        return docState;
    }

    public void setDocState(String docState) {
        this.docState = docState == null ? null : docState.trim();
    }

    public String getRelTime() {
        return relTime;
    }

    public void setRelTime(String relTime) {
        this.relTime = relTime == null ? null : relTime.trim();
    }

    public String getSendim() {
        return sendim;
    }

    public void setSendim(String sendim) {
        this.sendim = sendim == null ? null : sendim.trim();
    }

    public String getSendinfo() {
        return sendinfo;
    }

    public void setSendinfo(String sendinfo) {
        this.sendinfo = sendinfo == null ? null : sendinfo.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
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

    public Integer getDocVersion() {
        return docVersion;
    }

    public void setDocVersion(Integer docVersion) {
        this.docVersion = docVersion;
    }
}
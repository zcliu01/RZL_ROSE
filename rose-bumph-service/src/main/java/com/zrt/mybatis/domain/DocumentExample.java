package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class DocumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDocIdIsNull() {
            addCriterion("doc_id is null");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNotNull() {
            addCriterion("doc_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocIdEqualTo(String value) {
            addCriterion("doc_id =", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotEqualTo(String value) {
            addCriterion("doc_id <>", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThan(String value) {
            addCriterion("doc_id >", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThanOrEqualTo(String value) {
            addCriterion("doc_id >=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThan(String value) {
            addCriterion("doc_id <", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThanOrEqualTo(String value) {
            addCriterion("doc_id <=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLike(String value) {
            addCriterion("doc_id like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotLike(String value) {
            addCriterion("doc_id not like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdIn(List<String> values) {
            addCriterion("doc_id in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotIn(List<String> values) {
            addCriterion("doc_id not in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdBetween(String value1, String value2) {
            addCriterion("doc_id between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotBetween(String value1, String value2) {
            addCriterion("doc_id not between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNull() {
            addCriterion("doc_name is null");
            return (Criteria) this;
        }

        public Criteria andDocNameIsNotNull() {
            addCriterion("doc_name is not null");
            return (Criteria) this;
        }

        public Criteria andDocNameEqualTo(String value) {
            addCriterion("doc_name =", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotEqualTo(String value) {
            addCriterion("doc_name <>", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThan(String value) {
            addCriterion("doc_name >", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameGreaterThanOrEqualTo(String value) {
            addCriterion("doc_name >=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThan(String value) {
            addCriterion("doc_name <", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLessThanOrEqualTo(String value) {
            addCriterion("doc_name <=", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameLike(String value) {
            addCriterion("doc_name like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotLike(String value) {
            addCriterion("doc_name not like", value, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameIn(List<String> values) {
            addCriterion("doc_name in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotIn(List<String> values) {
            addCriterion("doc_name not in", values, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameBetween(String value1, String value2) {
            addCriterion("doc_name between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNameNotBetween(String value1, String value2) {
            addCriterion("doc_name not between", value1, value2, "docName");
            return (Criteria) this;
        }

        public Criteria andDocNumberIsNull() {
            addCriterion("doc_number is null");
            return (Criteria) this;
        }

        public Criteria andDocNumberIsNotNull() {
            addCriterion("doc_number is not null");
            return (Criteria) this;
        }

        public Criteria andDocNumberEqualTo(String value) {
            addCriterion("doc_number =", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberNotEqualTo(String value) {
            addCriterion("doc_number <>", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberGreaterThan(String value) {
            addCriterion("doc_number >", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberGreaterThanOrEqualTo(String value) {
            addCriterion("doc_number >=", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberLessThan(String value) {
            addCriterion("doc_number <", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberLessThanOrEqualTo(String value) {
            addCriterion("doc_number <=", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberLike(String value) {
            addCriterion("doc_number like", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberNotLike(String value) {
            addCriterion("doc_number not like", value, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberIn(List<String> values) {
            addCriterion("doc_number in", values, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberNotIn(List<String> values) {
            addCriterion("doc_number not in", values, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberBetween(String value1, String value2) {
            addCriterion("doc_number between", value1, value2, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocNumberNotBetween(String value1, String value2) {
            addCriterion("doc_number not between", value1, value2, "docNumber");
            return (Criteria) this;
        }

        public Criteria andDocDateIsNull() {
            addCriterion("doc_date is null");
            return (Criteria) this;
        }

        public Criteria andDocDateIsNotNull() {
            addCriterion("doc_date is not null");
            return (Criteria) this;
        }

        public Criteria andDocDateEqualTo(String value) {
            addCriterion("doc_date =", value, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateNotEqualTo(String value) {
            addCriterion("doc_date <>", value, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateGreaterThan(String value) {
            addCriterion("doc_date >", value, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateGreaterThanOrEqualTo(String value) {
            addCriterion("doc_date >=", value, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateLessThan(String value) {
            addCriterion("doc_date <", value, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateLessThanOrEqualTo(String value) {
            addCriterion("doc_date <=", value, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateLike(String value) {
            addCriterion("doc_date like", value, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateNotLike(String value) {
            addCriterion("doc_date not like", value, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateIn(List<String> values) {
            addCriterion("doc_date in", values, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateNotIn(List<String> values) {
            addCriterion("doc_date not in", values, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateBetween(String value1, String value2) {
            addCriterion("doc_date between", value1, value2, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocDateNotBetween(String value1, String value2) {
            addCriterion("doc_date not between", value1, value2, "docDate");
            return (Criteria) this;
        }

        public Criteria andDocClassesIsNull() {
            addCriterion("doc_classes is null");
            return (Criteria) this;
        }

        public Criteria andDocClassesIsNotNull() {
            addCriterion("doc_classes is not null");
            return (Criteria) this;
        }

        public Criteria andDocClassesEqualTo(String value) {
            addCriterion("doc_classes =", value, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesNotEqualTo(String value) {
            addCriterion("doc_classes <>", value, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesGreaterThan(String value) {
            addCriterion("doc_classes >", value, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesGreaterThanOrEqualTo(String value) {
            addCriterion("doc_classes >=", value, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesLessThan(String value) {
            addCriterion("doc_classes <", value, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesLessThanOrEqualTo(String value) {
            addCriterion("doc_classes <=", value, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesLike(String value) {
            addCriterion("doc_classes like", value, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesNotLike(String value) {
            addCriterion("doc_classes not like", value, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesIn(List<String> values) {
            addCriterion("doc_classes in", values, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesNotIn(List<String> values) {
            addCriterion("doc_classes not in", values, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesBetween(String value1, String value2) {
            addCriterion("doc_classes between", value1, value2, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocClassesNotBetween(String value1, String value2) {
            addCriterion("doc_classes not between", value1, value2, "docClasses");
            return (Criteria) this;
        }

        public Criteria andDocTypeIsNull() {
            addCriterion("doc_type is null");
            return (Criteria) this;
        }

        public Criteria andDocTypeIsNotNull() {
            addCriterion("doc_type is not null");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("doc_type =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotEqualTo(String value) {
            addCriterion("doc_type <>", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeGreaterThan(String value) {
            addCriterion("doc_type >", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeGreaterThanOrEqualTo(String value) {
            addCriterion("doc_type >=", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLessThan(String value) {
            addCriterion("doc_type <", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLessThanOrEqualTo(String value) {
            addCriterion("doc_type <=", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLike(String value) {
            addCriterion("doc_type like", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotLike(String value) {
            addCriterion("doc_type not like", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeIn(List<String> values) {
            addCriterion("doc_type in", values, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotIn(List<String> values) {
            addCriterion("doc_type not in", values, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeBetween(String value1, String value2) {
            addCriterion("doc_type between", value1, value2, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotBetween(String value1, String value2) {
            addCriterion("doc_type not between", value1, value2, "docType");
            return (Criteria) this;
        }

        public Criteria andDocUrgIsNull() {
            addCriterion("doc_urg is null");
            return (Criteria) this;
        }

        public Criteria andDocUrgIsNotNull() {
            addCriterion("doc_urg is not null");
            return (Criteria) this;
        }

        public Criteria andDocUrgEqualTo(String value) {
            addCriterion("doc_urg =", value, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgNotEqualTo(String value) {
            addCriterion("doc_urg <>", value, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgGreaterThan(String value) {
            addCriterion("doc_urg >", value, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgGreaterThanOrEqualTo(String value) {
            addCriterion("doc_urg >=", value, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgLessThan(String value) {
            addCriterion("doc_urg <", value, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgLessThanOrEqualTo(String value) {
            addCriterion("doc_urg <=", value, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgLike(String value) {
            addCriterion("doc_urg like", value, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgNotLike(String value) {
            addCriterion("doc_urg not like", value, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgIn(List<String> values) {
            addCriterion("doc_urg in", values, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgNotIn(List<String> values) {
            addCriterion("doc_urg not in", values, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgBetween(String value1, String value2) {
            addCriterion("doc_urg between", value1, value2, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocUrgNotBetween(String value1, String value2) {
            addCriterion("doc_urg not between", value1, value2, "docUrg");
            return (Criteria) this;
        }

        public Criteria andDocSrcIsNull() {
            addCriterion("doc_src is null");
            return (Criteria) this;
        }

        public Criteria andDocSrcIsNotNull() {
            addCriterion("doc_src is not null");
            return (Criteria) this;
        }

        public Criteria andDocSrcEqualTo(String value) {
            addCriterion("doc_src =", value, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcNotEqualTo(String value) {
            addCriterion("doc_src <>", value, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcGreaterThan(String value) {
            addCriterion("doc_src >", value, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcGreaterThanOrEqualTo(String value) {
            addCriterion("doc_src >=", value, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcLessThan(String value) {
            addCriterion("doc_src <", value, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcLessThanOrEqualTo(String value) {
            addCriterion("doc_src <=", value, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcLike(String value) {
            addCriterion("doc_src like", value, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcNotLike(String value) {
            addCriterion("doc_src not like", value, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcIn(List<String> values) {
            addCriterion("doc_src in", values, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcNotIn(List<String> values) {
            addCriterion("doc_src not in", values, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcBetween(String value1, String value2) {
            addCriterion("doc_src between", value1, value2, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocSrcNotBetween(String value1, String value2) {
            addCriterion("doc_src not between", value1, value2, "docSrc");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdIsNull() {
            addCriterion("doc_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdIsNotNull() {
            addCriterion("doc_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdEqualTo(String value) {
            addCriterion("doc_owner_id =", value, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdNotEqualTo(String value) {
            addCriterion("doc_owner_id <>", value, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdGreaterThan(String value) {
            addCriterion("doc_owner_id >", value, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("doc_owner_id >=", value, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdLessThan(String value) {
            addCriterion("doc_owner_id <", value, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("doc_owner_id <=", value, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdLike(String value) {
            addCriterion("doc_owner_id like", value, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdNotLike(String value) {
            addCriterion("doc_owner_id not like", value, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdIn(List<String> values) {
            addCriterion("doc_owner_id in", values, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdNotIn(List<String> values) {
            addCriterion("doc_owner_id not in", values, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdBetween(String value1, String value2) {
            addCriterion("doc_owner_id between", value1, value2, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIdNotBetween(String value1, String value2) {
            addCriterion("doc_owner_id not between", value1, value2, "docOwnerId");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIsNull() {
            addCriterion("doc_owner is null");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIsNotNull() {
            addCriterion("doc_owner is not null");
            return (Criteria) this;
        }

        public Criteria andDocOwnerEqualTo(String value) {
            addCriterion("doc_owner =", value, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerNotEqualTo(String value) {
            addCriterion("doc_owner <>", value, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerGreaterThan(String value) {
            addCriterion("doc_owner >", value, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("doc_owner >=", value, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerLessThan(String value) {
            addCriterion("doc_owner <", value, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerLessThanOrEqualTo(String value) {
            addCriterion("doc_owner <=", value, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerLike(String value) {
            addCriterion("doc_owner like", value, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerNotLike(String value) {
            addCriterion("doc_owner not like", value, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerIn(List<String> values) {
            addCriterion("doc_owner in", values, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerNotIn(List<String> values) {
            addCriterion("doc_owner not in", values, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerBetween(String value1, String value2) {
            addCriterion("doc_owner between", value1, value2, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocOwnerNotBetween(String value1, String value2) {
            addCriterion("doc_owner not between", value1, value2, "docOwner");
            return (Criteria) this;
        }

        public Criteria andDocPhoneIsNull() {
            addCriterion("doc_phone is null");
            return (Criteria) this;
        }

        public Criteria andDocPhoneIsNotNull() {
            addCriterion("doc_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDocPhoneEqualTo(String value) {
            addCriterion("doc_phone =", value, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneNotEqualTo(String value) {
            addCriterion("doc_phone <>", value, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneGreaterThan(String value) {
            addCriterion("doc_phone >", value, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("doc_phone >=", value, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneLessThan(String value) {
            addCriterion("doc_phone <", value, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneLessThanOrEqualTo(String value) {
            addCriterion("doc_phone <=", value, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneLike(String value) {
            addCriterion("doc_phone like", value, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneNotLike(String value) {
            addCriterion("doc_phone not like", value, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneIn(List<String> values) {
            addCriterion("doc_phone in", values, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneNotIn(List<String> values) {
            addCriterion("doc_phone not in", values, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneBetween(String value1, String value2) {
            addCriterion("doc_phone between", value1, value2, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocPhoneNotBetween(String value1, String value2) {
            addCriterion("doc_phone not between", value1, value2, "docPhone");
            return (Criteria) this;
        }

        public Criteria andDocOrgIsNull() {
            addCriterion("doc_org is null");
            return (Criteria) this;
        }

        public Criteria andDocOrgIsNotNull() {
            addCriterion("doc_org is not null");
            return (Criteria) this;
        }

        public Criteria andDocOrgEqualTo(String value) {
            addCriterion("doc_org =", value, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgNotEqualTo(String value) {
            addCriterion("doc_org <>", value, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgGreaterThan(String value) {
            addCriterion("doc_org >", value, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgGreaterThanOrEqualTo(String value) {
            addCriterion("doc_org >=", value, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgLessThan(String value) {
            addCriterion("doc_org <", value, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgLessThanOrEqualTo(String value) {
            addCriterion("doc_org <=", value, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgLike(String value) {
            addCriterion("doc_org like", value, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgNotLike(String value) {
            addCriterion("doc_org not like", value, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgIn(List<String> values) {
            addCriterion("doc_org in", values, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgNotIn(List<String> values) {
            addCriterion("doc_org not in", values, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgBetween(String value1, String value2) {
            addCriterion("doc_org between", value1, value2, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocOrgNotBetween(String value1, String value2) {
            addCriterion("doc_org not between", value1, value2, "docOrg");
            return (Criteria) this;
        }

        public Criteria andDocDispunitIsNull() {
            addCriterion("doc_dispunit is null");
            return (Criteria) this;
        }

        public Criteria andDocDispunitIsNotNull() {
            addCriterion("doc_dispunit is not null");
            return (Criteria) this;
        }

        public Criteria andDocDispunitEqualTo(String value) {
            addCriterion("doc_dispunit =", value, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitNotEqualTo(String value) {
            addCriterion("doc_dispunit <>", value, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitGreaterThan(String value) {
            addCriterion("doc_dispunit >", value, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitGreaterThanOrEqualTo(String value) {
            addCriterion("doc_dispunit >=", value, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitLessThan(String value) {
            addCriterion("doc_dispunit <", value, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitLessThanOrEqualTo(String value) {
            addCriterion("doc_dispunit <=", value, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitLike(String value) {
            addCriterion("doc_dispunit like", value, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitNotLike(String value) {
            addCriterion("doc_dispunit not like", value, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitIn(List<String> values) {
            addCriterion("doc_dispunit in", values, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitNotIn(List<String> values) {
            addCriterion("doc_dispunit not in", values, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitBetween(String value1, String value2) {
            addCriterion("doc_dispunit between", value1, value2, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andDocDispunitNotBetween(String value1, String value2) {
            addCriterion("doc_dispunit not between", value1, value2, "docDispunit");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDocStateIsNull() {
            addCriterion("doc_state is null");
            return (Criteria) this;
        }

        public Criteria andDocStateIsNotNull() {
            addCriterion("doc_state is not null");
            return (Criteria) this;
        }

        public Criteria andDocStateEqualTo(String value) {
            addCriterion("doc_state =", value, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateNotEqualTo(String value) {
            addCriterion("doc_state <>", value, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateGreaterThan(String value) {
            addCriterion("doc_state >", value, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateGreaterThanOrEqualTo(String value) {
            addCriterion("doc_state >=", value, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateLessThan(String value) {
            addCriterion("doc_state <", value, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateLessThanOrEqualTo(String value) {
            addCriterion("doc_state <=", value, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateLike(String value) {
            addCriterion("doc_state like", value, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateNotLike(String value) {
            addCriterion("doc_state not like", value, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateIn(List<String> values) {
            addCriterion("doc_state in", values, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateNotIn(List<String> values) {
            addCriterion("doc_state not in", values, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateBetween(String value1, String value2) {
            addCriterion("doc_state between", value1, value2, "docState");
            return (Criteria) this;
        }

        public Criteria andDocStateNotBetween(String value1, String value2) {
            addCriterion("doc_state not between", value1, value2, "docState");
            return (Criteria) this;
        }

        public Criteria andRelTimeIsNull() {
            addCriterion("rel_time is null");
            return (Criteria) this;
        }

        public Criteria andRelTimeIsNotNull() {
            addCriterion("rel_time is not null");
            return (Criteria) this;
        }

        public Criteria andRelTimeEqualTo(String value) {
            addCriterion("rel_time =", value, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeNotEqualTo(String value) {
            addCriterion("rel_time <>", value, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeGreaterThan(String value) {
            addCriterion("rel_time >", value, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeGreaterThanOrEqualTo(String value) {
            addCriterion("rel_time >=", value, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeLessThan(String value) {
            addCriterion("rel_time <", value, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeLessThanOrEqualTo(String value) {
            addCriterion("rel_time <=", value, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeLike(String value) {
            addCriterion("rel_time like", value, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeNotLike(String value) {
            addCriterion("rel_time not like", value, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeIn(List<String> values) {
            addCriterion("rel_time in", values, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeNotIn(List<String> values) {
            addCriterion("rel_time not in", values, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeBetween(String value1, String value2) {
            addCriterion("rel_time between", value1, value2, "relTime");
            return (Criteria) this;
        }

        public Criteria andRelTimeNotBetween(String value1, String value2) {
            addCriterion("rel_time not between", value1, value2, "relTime");
            return (Criteria) this;
        }

        public Criteria andSendimIsNull() {
            addCriterion("sendim is null");
            return (Criteria) this;
        }

        public Criteria andSendimIsNotNull() {
            addCriterion("sendim is not null");
            return (Criteria) this;
        }

        public Criteria andSendimEqualTo(String value) {
            addCriterion("sendim =", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotEqualTo(String value) {
            addCriterion("sendim <>", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimGreaterThan(String value) {
            addCriterion("sendim >", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimGreaterThanOrEqualTo(String value) {
            addCriterion("sendim >=", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLessThan(String value) {
            addCriterion("sendim <", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLessThanOrEqualTo(String value) {
            addCriterion("sendim <=", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLike(String value) {
            addCriterion("sendim like", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotLike(String value) {
            addCriterion("sendim not like", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimIn(List<String> values) {
            addCriterion("sendim in", values, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotIn(List<String> values) {
            addCriterion("sendim not in", values, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimBetween(String value1, String value2) {
            addCriterion("sendim between", value1, value2, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotBetween(String value1, String value2) {
            addCriterion("sendim not between", value1, value2, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendinfoIsNull() {
            addCriterion("sendinfo is null");
            return (Criteria) this;
        }

        public Criteria andSendinfoIsNotNull() {
            addCriterion("sendinfo is not null");
            return (Criteria) this;
        }

        public Criteria andSendinfoEqualTo(String value) {
            addCriterion("sendinfo =", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotEqualTo(String value) {
            addCriterion("sendinfo <>", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoGreaterThan(String value) {
            addCriterion("sendinfo >", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoGreaterThanOrEqualTo(String value) {
            addCriterion("sendinfo >=", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLessThan(String value) {
            addCriterion("sendinfo <", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLessThanOrEqualTo(String value) {
            addCriterion("sendinfo <=", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLike(String value) {
            addCriterion("sendinfo like", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotLike(String value) {
            addCriterion("sendinfo not like", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoIn(List<String> values) {
            addCriterion("sendinfo in", values, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotIn(List<String> values) {
            addCriterion("sendinfo not in", values, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoBetween(String value1, String value2) {
            addCriterion("sendinfo between", value1, value2, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotBetween(String value1, String value2) {
            addCriterion("sendinfo not between", value1, value2, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNull() {
            addCriterion("create_date_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNotNull() {
            addCriterion("create_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeEqualTo(String value) {
            addCriterion("create_date_time =", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotEqualTo(String value) {
            addCriterion("create_date_time <>", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThan(String value) {
            addCriterion("create_date_time >", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_date_time >=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThan(String value) {
            addCriterion("create_date_time <", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_date_time <=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLike(String value) {
            addCriterion("create_date_time like", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotLike(String value) {
            addCriterion("create_date_time not like", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIn(List<String> values) {
            addCriterion("create_date_time in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotIn(List<String> values) {
            addCriterion("create_date_time not in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeBetween(String value1, String value2) {
            addCriterion("create_date_time between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotBetween(String value1, String value2) {
            addCriterion("create_date_time not between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIsNull() {
            addCriterion("update_date_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIsNotNull() {
            addCriterion("update_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeEqualTo(String value) {
            addCriterion("update_date_time =", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotEqualTo(String value) {
            addCriterion("update_date_time <>", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeGreaterThan(String value) {
            addCriterion("update_date_time >", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_date_time >=", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeLessThan(String value) {
            addCriterion("update_date_time <", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_date_time <=", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeLike(String value) {
            addCriterion("update_date_time like", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotLike(String value) {
            addCriterion("update_date_time not like", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIn(List<String> values) {
            addCriterion("update_date_time in", values, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotIn(List<String> values) {
            addCriterion("update_date_time not in", values, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeBetween(String value1, String value2) {
            addCriterion("update_date_time between", value1, value2, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotBetween(String value1, String value2) {
            addCriterion("update_date_time not between", value1, value2, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andDocVersionIsNull() {
            addCriterion("doc_version is null");
            return (Criteria) this;
        }

        public Criteria andDocVersionIsNotNull() {
            addCriterion("doc_version is not null");
            return (Criteria) this;
        }

        public Criteria andDocVersionEqualTo(Integer value) {
            addCriterion("doc_version =", value, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionNotEqualTo(Integer value) {
            addCriterion("doc_version <>", value, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionGreaterThan(Integer value) {
            addCriterion("doc_version >", value, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("doc_version >=", value, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionLessThan(Integer value) {
            addCriterion("doc_version <", value, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionLessThanOrEqualTo(Integer value) {
            addCriterion("doc_version <=", value, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionIn(List<Integer> values) {
            addCriterion("doc_version in", values, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionNotIn(List<Integer> values) {
            addCriterion("doc_version not in", values, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionBetween(Integer value1, Integer value2) {
            addCriterion("doc_version between", value1, value2, "docVersion");
            return (Criteria) this;
        }

        public Criteria andDocVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("doc_version not between", value1, value2, "docVersion");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
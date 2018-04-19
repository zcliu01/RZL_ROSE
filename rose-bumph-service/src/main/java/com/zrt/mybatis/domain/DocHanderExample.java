package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class DocHanderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocHanderExample() {
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

        public Criteria andDocHanderIdIsNull() {
            addCriterion("doc_hander_id is null");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdIsNotNull() {
            addCriterion("doc_hander_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdEqualTo(Integer value) {
            addCriterion("doc_hander_id =", value, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdNotEqualTo(Integer value) {
            addCriterion("doc_hander_id <>", value, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdGreaterThan(Integer value) {
            addCriterion("doc_hander_id >", value, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("doc_hander_id >=", value, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdLessThan(Integer value) {
            addCriterion("doc_hander_id <", value, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdLessThanOrEqualTo(Integer value) {
            addCriterion("doc_hander_id <=", value, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdIn(List<Integer> values) {
            addCriterion("doc_hander_id in", values, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdNotIn(List<Integer> values) {
            addCriterion("doc_hander_id not in", values, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdBetween(Integer value1, Integer value2) {
            addCriterion("doc_hander_id between", value1, value2, "docHanderId");
            return (Criteria) this;
        }

        public Criteria andDocHanderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("doc_hander_id not between", value1, value2, "docHanderId");
            return (Criteria) this;
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

        public Criteria andHanderidIsNull() {
            addCriterion("handerID is null");
            return (Criteria) this;
        }

        public Criteria andHanderidIsNotNull() {
            addCriterion("handerID is not null");
            return (Criteria) this;
        }

        public Criteria andHanderidEqualTo(String value) {
            addCriterion("handerID =", value, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidNotEqualTo(String value) {
            addCriterion("handerID <>", value, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidGreaterThan(String value) {
            addCriterion("handerID >", value, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidGreaterThanOrEqualTo(String value) {
            addCriterion("handerID >=", value, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidLessThan(String value) {
            addCriterion("handerID <", value, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidLessThanOrEqualTo(String value) {
            addCriterion("handerID <=", value, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidLike(String value) {
            addCriterion("handerID like", value, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidNotLike(String value) {
            addCriterion("handerID not like", value, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidIn(List<String> values) {
            addCriterion("handerID in", values, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidNotIn(List<String> values) {
            addCriterion("handerID not in", values, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidBetween(String value1, String value2) {
            addCriterion("handerID between", value1, value2, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderidNotBetween(String value1, String value2) {
            addCriterion("handerID not between", value1, value2, "handerid");
            return (Criteria) this;
        }

        public Criteria andHanderNameIsNull() {
            addCriterion("hander_name is null");
            return (Criteria) this;
        }

        public Criteria andHanderNameIsNotNull() {
            addCriterion("hander_name is not null");
            return (Criteria) this;
        }

        public Criteria andHanderNameEqualTo(String value) {
            addCriterion("hander_name =", value, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameNotEqualTo(String value) {
            addCriterion("hander_name <>", value, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameGreaterThan(String value) {
            addCriterion("hander_name >", value, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameGreaterThanOrEqualTo(String value) {
            addCriterion("hander_name >=", value, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameLessThan(String value) {
            addCriterion("hander_name <", value, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameLessThanOrEqualTo(String value) {
            addCriterion("hander_name <=", value, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameLike(String value) {
            addCriterion("hander_name like", value, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameNotLike(String value) {
            addCriterion("hander_name not like", value, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameIn(List<String> values) {
            addCriterion("hander_name in", values, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameNotIn(List<String> values) {
            addCriterion("hander_name not in", values, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameBetween(String value1, String value2) {
            addCriterion("hander_name between", value1, value2, "handerName");
            return (Criteria) this;
        }

        public Criteria andHanderNameNotBetween(String value1, String value2) {
            addCriterion("hander_name not between", value1, value2, "handerName");
            return (Criteria) this;
        }

        public Criteria andHandTypeIsNull() {
            addCriterion("hand_type is null");
            return (Criteria) this;
        }

        public Criteria andHandTypeIsNotNull() {
            addCriterion("hand_type is not null");
            return (Criteria) this;
        }

        public Criteria andHandTypeEqualTo(String value) {
            addCriterion("hand_type =", value, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeNotEqualTo(String value) {
            addCriterion("hand_type <>", value, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeGreaterThan(String value) {
            addCriterion("hand_type >", value, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hand_type >=", value, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeLessThan(String value) {
            addCriterion("hand_type <", value, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeLessThanOrEqualTo(String value) {
            addCriterion("hand_type <=", value, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeLike(String value) {
            addCriterion("hand_type like", value, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeNotLike(String value) {
            addCriterion("hand_type not like", value, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeIn(List<String> values) {
            addCriterion("hand_type in", values, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeNotIn(List<String> values) {
            addCriterion("hand_type not in", values, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeBetween(String value1, String value2) {
            addCriterion("hand_type between", value1, value2, "handType");
            return (Criteria) this;
        }

        public Criteria andHandTypeNotBetween(String value1, String value2) {
            addCriterion("hand_type not between", value1, value2, "handType");
            return (Criteria) this;
        }

        public Criteria andHandInfoIsNull() {
            addCriterion("hand_info is null");
            return (Criteria) this;
        }

        public Criteria andHandInfoIsNotNull() {
            addCriterion("hand_info is not null");
            return (Criteria) this;
        }

        public Criteria andHandInfoEqualTo(String value) {
            addCriterion("hand_info =", value, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoNotEqualTo(String value) {
            addCriterion("hand_info <>", value, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoGreaterThan(String value) {
            addCriterion("hand_info >", value, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoGreaterThanOrEqualTo(String value) {
            addCriterion("hand_info >=", value, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoLessThan(String value) {
            addCriterion("hand_info <", value, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoLessThanOrEqualTo(String value) {
            addCriterion("hand_info <=", value, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoLike(String value) {
            addCriterion("hand_info like", value, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoNotLike(String value) {
            addCriterion("hand_info not like", value, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoIn(List<String> values) {
            addCriterion("hand_info in", values, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoNotIn(List<String> values) {
            addCriterion("hand_info not in", values, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoBetween(String value1, String value2) {
            addCriterion("hand_info between", value1, value2, "handInfo");
            return (Criteria) this;
        }

        public Criteria andHandInfoNotBetween(String value1, String value2) {
            addCriterion("hand_info not between", value1, value2, "handInfo");
            return (Criteria) this;
        }

        public Criteria andDocReadIsNull() {
            addCriterion("doc_read is null");
            return (Criteria) this;
        }

        public Criteria andDocReadIsNotNull() {
            addCriterion("doc_read is not null");
            return (Criteria) this;
        }

        public Criteria andDocReadEqualTo(String value) {
            addCriterion("doc_read =", value, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadNotEqualTo(String value) {
            addCriterion("doc_read <>", value, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadGreaterThan(String value) {
            addCriterion("doc_read >", value, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadGreaterThanOrEqualTo(String value) {
            addCriterion("doc_read >=", value, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadLessThan(String value) {
            addCriterion("doc_read <", value, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadLessThanOrEqualTo(String value) {
            addCriterion("doc_read <=", value, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadLike(String value) {
            addCriterion("doc_read like", value, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadNotLike(String value) {
            addCriterion("doc_read not like", value, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadIn(List<String> values) {
            addCriterion("doc_read in", values, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadNotIn(List<String> values) {
            addCriterion("doc_read not in", values, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadBetween(String value1, String value2) {
            addCriterion("doc_read between", value1, value2, "docRead");
            return (Criteria) this;
        }

        public Criteria andDocReadNotBetween(String value1, String value2) {
            addCriterion("doc_read not between", value1, value2, "docRead");
            return (Criteria) this;
        }

        public Criteria andHandTimeIsNull() {
            addCriterion("hand_time is null");
            return (Criteria) this;
        }

        public Criteria andHandTimeIsNotNull() {
            addCriterion("hand_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandTimeEqualTo(String value) {
            addCriterion("hand_time =", value, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeNotEqualTo(String value) {
            addCriterion("hand_time <>", value, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeGreaterThan(String value) {
            addCriterion("hand_time >", value, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeGreaterThanOrEqualTo(String value) {
            addCriterion("hand_time >=", value, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeLessThan(String value) {
            addCriterion("hand_time <", value, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeLessThanOrEqualTo(String value) {
            addCriterion("hand_time <=", value, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeLike(String value) {
            addCriterion("hand_time like", value, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeNotLike(String value) {
            addCriterion("hand_time not like", value, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeIn(List<String> values) {
            addCriterion("hand_time in", values, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeNotIn(List<String> values) {
            addCriterion("hand_time not in", values, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeBetween(String value1, String value2) {
            addCriterion("hand_time between", value1, value2, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandTimeNotBetween(String value1, String value2) {
            addCriterion("hand_time not between", value1, value2, "handTime");
            return (Criteria) this;
        }

        public Criteria andHandStateIsNull() {
            addCriterion("hand_state is null");
            return (Criteria) this;
        }

        public Criteria andHandStateIsNotNull() {
            addCriterion("hand_state is not null");
            return (Criteria) this;
        }

        public Criteria andHandStateEqualTo(String value) {
            addCriterion("hand_state =", value, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateNotEqualTo(String value) {
            addCriterion("hand_state <>", value, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateGreaterThan(String value) {
            addCriterion("hand_state >", value, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateGreaterThanOrEqualTo(String value) {
            addCriterion("hand_state >=", value, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateLessThan(String value) {
            addCriterion("hand_state <", value, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateLessThanOrEqualTo(String value) {
            addCriterion("hand_state <=", value, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateLike(String value) {
            addCriterion("hand_state like", value, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateNotLike(String value) {
            addCriterion("hand_state not like", value, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateIn(List<String> values) {
            addCriterion("hand_state in", values, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateNotIn(List<String> values) {
            addCriterion("hand_state not in", values, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateBetween(String value1, String value2) {
            addCriterion("hand_state between", value1, value2, "handState");
            return (Criteria) this;
        }

        public Criteria andHandStateNotBetween(String value1, String value2) {
            addCriterion("hand_state not between", value1, value2, "handState");
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

        public Criteria andHanderOrderIsNull() {
            addCriterion("hander_order is null");
            return (Criteria) this;
        }

        public Criteria andHanderOrderIsNotNull() {
            addCriterion("hander_order is not null");
            return (Criteria) this;
        }

        public Criteria andHanderOrderEqualTo(Integer value) {
            addCriterion("hander_order =", value, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderNotEqualTo(Integer value) {
            addCriterion("hander_order <>", value, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderGreaterThan(Integer value) {
            addCriterion("hander_order >", value, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("hander_order >=", value, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderLessThan(Integer value) {
            addCriterion("hander_order <", value, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderLessThanOrEqualTo(Integer value) {
            addCriterion("hander_order <=", value, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderIn(List<Integer> values) {
            addCriterion("hander_order in", values, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderNotIn(List<Integer> values) {
            addCriterion("hander_order not in", values, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderBetween(Integer value1, Integer value2) {
            addCriterion("hander_order between", value1, value2, "handerOrder");
            return (Criteria) this;
        }

        public Criteria andHanderOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("hander_order not between", value1, value2, "handerOrder");
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
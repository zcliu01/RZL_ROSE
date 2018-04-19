package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class InfoPubExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoPubExample() {
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

        public Criteria andInfoIdIsNull() {
            addCriterion("info_ID is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("info_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(String value) {
            addCriterion("info_ID =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(String value) {
            addCriterion("info_ID <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(String value) {
            addCriterion("info_ID >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("info_ID >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(String value) {
            addCriterion("info_ID <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(String value) {
            addCriterion("info_ID <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLike(String value) {
            addCriterion("info_ID like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotLike(String value) {
            addCriterion("info_ID not like", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<String> values) {
            addCriterion("info_ID in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<String> values) {
            addCriterion("info_ID not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(String value1, String value2) {
            addCriterion("info_ID between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(String value1, String value2) {
            addCriterion("info_ID not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIsNull() {
            addCriterion("info_title is null");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIsNotNull() {
            addCriterion("info_title is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTitleEqualTo(String value) {
            addCriterion("info_title =", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotEqualTo(String value) {
            addCriterion("info_title <>", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleGreaterThan(String value) {
            addCriterion("info_title >", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("info_title >=", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLessThan(String value) {
            addCriterion("info_title <", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLessThanOrEqualTo(String value) {
            addCriterion("info_title <=", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleLike(String value) {
            addCriterion("info_title like", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotLike(String value) {
            addCriterion("info_title not like", value, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleIn(List<String> values) {
            addCriterion("info_title in", values, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotIn(List<String> values) {
            addCriterion("info_title not in", values, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleBetween(String value1, String value2) {
            addCriterion("info_title between", value1, value2, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoTitleNotBetween(String value1, String value2) {
            addCriterion("info_title not between", value1, value2, "infoTitle");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdIsNull() {
            addCriterion("info_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdIsNotNull() {
            addCriterion("info_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdEqualTo(String value) {
            addCriterion("info_owner_id =", value, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdNotEqualTo(String value) {
            addCriterion("info_owner_id <>", value, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdGreaterThan(String value) {
            addCriterion("info_owner_id >", value, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("info_owner_id >=", value, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdLessThan(String value) {
            addCriterion("info_owner_id <", value, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("info_owner_id <=", value, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdLike(String value) {
            addCriterion("info_owner_id like", value, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdNotLike(String value) {
            addCriterion("info_owner_id not like", value, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdIn(List<String> values) {
            addCriterion("info_owner_id in", values, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdNotIn(List<String> values) {
            addCriterion("info_owner_id not in", values, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdBetween(String value1, String value2) {
            addCriterion("info_owner_id between", value1, value2, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIdNotBetween(String value1, String value2) {
            addCriterion("info_owner_id not between", value1, value2, "infoOwnerId");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIsNull() {
            addCriterion("info_owner is null");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIsNotNull() {
            addCriterion("info_owner is not null");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerEqualTo(String value) {
            addCriterion("info_owner =", value, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerNotEqualTo(String value) {
            addCriterion("info_owner <>", value, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerGreaterThan(String value) {
            addCriterion("info_owner >", value, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("info_owner >=", value, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerLessThan(String value) {
            addCriterion("info_owner <", value, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerLessThanOrEqualTo(String value) {
            addCriterion("info_owner <=", value, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerLike(String value) {
            addCriterion("info_owner like", value, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerNotLike(String value) {
            addCriterion("info_owner not like", value, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerIn(List<String> values) {
            addCriterion("info_owner in", values, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerNotIn(List<String> values) {
            addCriterion("info_owner not in", values, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerBetween(String value1, String value2) {
            addCriterion("info_owner between", value1, value2, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoOwnerNotBetween(String value1, String value2) {
            addCriterion("info_owner not between", value1, value2, "infoOwner");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIsNull() {
            addCriterion("info_type is null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIsNotNull() {
            addCriterion("info_type is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeEqualTo(String value) {
            addCriterion("info_type =", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotEqualTo(String value) {
            addCriterion("info_type <>", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeGreaterThan(String value) {
            addCriterion("info_type >", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("info_type >=", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLessThan(String value) {
            addCriterion("info_type <", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLessThanOrEqualTo(String value) {
            addCriterion("info_type <=", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLike(String value) {
            addCriterion("info_type like", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotLike(String value) {
            addCriterion("info_type not like", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIn(List<String> values) {
            addCriterion("info_type in", values, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotIn(List<String> values) {
            addCriterion("info_type not in", values, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeBetween(String value1, String value2) {
            addCriterion("info_type between", value1, value2, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotBetween(String value1, String value2) {
            addCriterion("info_type not between", value1, value2, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoNumberIsNull() {
            addCriterion("info_number is null");
            return (Criteria) this;
        }

        public Criteria andInfoNumberIsNotNull() {
            addCriterion("info_number is not null");
            return (Criteria) this;
        }

        public Criteria andInfoNumberEqualTo(String value) {
            addCriterion("info_number =", value, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberNotEqualTo(String value) {
            addCriterion("info_number <>", value, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberGreaterThan(String value) {
            addCriterion("info_number >", value, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberGreaterThanOrEqualTo(String value) {
            addCriterion("info_number >=", value, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberLessThan(String value) {
            addCriterion("info_number <", value, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberLessThanOrEqualTo(String value) {
            addCriterion("info_number <=", value, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberLike(String value) {
            addCriterion("info_number like", value, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberNotLike(String value) {
            addCriterion("info_number not like", value, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberIn(List<String> values) {
            addCriterion("info_number in", values, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberNotIn(List<String> values) {
            addCriterion("info_number not in", values, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberBetween(String value1, String value2) {
            addCriterion("info_number between", value1, value2, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoNumberNotBetween(String value1, String value2) {
            addCriterion("info_number not between", value1, value2, "infoNumber");
            return (Criteria) this;
        }

        public Criteria andInfoOrderIsNull() {
            addCriterion("info_order is null");
            return (Criteria) this;
        }

        public Criteria andInfoOrderIsNotNull() {
            addCriterion("info_order is not null");
            return (Criteria) this;
        }

        public Criteria andInfoOrderEqualTo(String value) {
            addCriterion("info_order =", value, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderNotEqualTo(String value) {
            addCriterion("info_order <>", value, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderGreaterThan(String value) {
            addCriterion("info_order >", value, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderGreaterThanOrEqualTo(String value) {
            addCriterion("info_order >=", value, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderLessThan(String value) {
            addCriterion("info_order <", value, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderLessThanOrEqualTo(String value) {
            addCriterion("info_order <=", value, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderLike(String value) {
            addCriterion("info_order like", value, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderNotLike(String value) {
            addCriterion("info_order not like", value, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderIn(List<String> values) {
            addCriterion("info_order in", values, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderNotIn(List<String> values) {
            addCriterion("info_order not in", values, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderBetween(String value1, String value2) {
            addCriterion("info_order between", value1, value2, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoOrderNotBetween(String value1, String value2) {
            addCriterion("info_order not between", value1, value2, "infoOrder");
            return (Criteria) this;
        }

        public Criteria andInfoStateIsNull() {
            addCriterion("info_state is null");
            return (Criteria) this;
        }

        public Criteria andInfoStateIsNotNull() {
            addCriterion("info_state is not null");
            return (Criteria) this;
        }

        public Criteria andInfoStateEqualTo(String value) {
            addCriterion("info_state =", value, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateNotEqualTo(String value) {
            addCriterion("info_state <>", value, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateGreaterThan(String value) {
            addCriterion("info_state >", value, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateGreaterThanOrEqualTo(String value) {
            addCriterion("info_state >=", value, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateLessThan(String value) {
            addCriterion("info_state <", value, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateLessThanOrEqualTo(String value) {
            addCriterion("info_state <=", value, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateLike(String value) {
            addCriterion("info_state like", value, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateNotLike(String value) {
            addCriterion("info_state not like", value, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateIn(List<String> values) {
            addCriterion("info_state in", values, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateNotIn(List<String> values) {
            addCriterion("info_state not in", values, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateBetween(String value1, String value2) {
            addCriterion("info_state between", value1, value2, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoStateNotBetween(String value1, String value2) {
            addCriterion("info_state not between", value1, value2, "infoState");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateIsNull() {
            addCriterion("info_pubdate is null");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateIsNotNull() {
            addCriterion("info_pubdate is not null");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateEqualTo(String value) {
            addCriterion("info_pubdate =", value, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateNotEqualTo(String value) {
            addCriterion("info_pubdate <>", value, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateGreaterThan(String value) {
            addCriterion("info_pubdate >", value, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateGreaterThanOrEqualTo(String value) {
            addCriterion("info_pubdate >=", value, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateLessThan(String value) {
            addCriterion("info_pubdate <", value, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateLessThanOrEqualTo(String value) {
            addCriterion("info_pubdate <=", value, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateLike(String value) {
            addCriterion("info_pubdate like", value, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateNotLike(String value) {
            addCriterion("info_pubdate not like", value, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateIn(List<String> values) {
            addCriterion("info_pubdate in", values, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateNotIn(List<String> values) {
            addCriterion("info_pubdate not in", values, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateBetween(String value1, String value2) {
            addCriterion("info_pubdate between", value1, value2, "infoPubdate");
            return (Criteria) this;
        }

        public Criteria andInfoPubdateNotBetween(String value1, String value2) {
            addCriterion("info_pubdate not between", value1, value2, "infoPubdate");
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

        public Criteria andSendinfoIsNull() {
            addCriterion("sendInfo is null");
            return (Criteria) this;
        }

        public Criteria andSendinfoIsNotNull() {
            addCriterion("sendInfo is not null");
            return (Criteria) this;
        }

        public Criteria andSendinfoEqualTo(String value) {
            addCriterion("sendInfo =", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotEqualTo(String value) {
            addCriterion("sendInfo <>", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoGreaterThan(String value) {
            addCriterion("sendInfo >", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoGreaterThanOrEqualTo(String value) {
            addCriterion("sendInfo >=", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLessThan(String value) {
            addCriterion("sendInfo <", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLessThanOrEqualTo(String value) {
            addCriterion("sendInfo <=", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLike(String value) {
            addCriterion("sendInfo like", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotLike(String value) {
            addCriterion("sendInfo not like", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoIn(List<String> values) {
            addCriterion("sendInfo in", values, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotIn(List<String> values) {
            addCriterion("sendInfo not in", values, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoBetween(String value1, String value2) {
            addCriterion("sendInfo between", value1, value2, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotBetween(String value1, String value2) {
            addCriterion("sendInfo not between", value1, value2, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendimIsNull() {
            addCriterion("sendIM is null");
            return (Criteria) this;
        }

        public Criteria andSendimIsNotNull() {
            addCriterion("sendIM is not null");
            return (Criteria) this;
        }

        public Criteria andSendimEqualTo(String value) {
            addCriterion("sendIM =", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotEqualTo(String value) {
            addCriterion("sendIM <>", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimGreaterThan(String value) {
            addCriterion("sendIM >", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimGreaterThanOrEqualTo(String value) {
            addCriterion("sendIM >=", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLessThan(String value) {
            addCriterion("sendIM <", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLessThanOrEqualTo(String value) {
            addCriterion("sendIM <=", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLike(String value) {
            addCriterion("sendIM like", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotLike(String value) {
            addCriterion("sendIM not like", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimIn(List<String> values) {
            addCriterion("sendIM in", values, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotIn(List<String> values) {
            addCriterion("sendIM not in", values, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimBetween(String value1, String value2) {
            addCriterion("sendIM between", value1, value2, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotBetween(String value1, String value2) {
            addCriterion("sendIM not between", value1, value2, "sendim");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneIsNull() {
            addCriterion("info_isEveryOne is null");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneIsNotNull() {
            addCriterion("info_isEveryOne is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneEqualTo(String value) {
            addCriterion("info_isEveryOne =", value, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneNotEqualTo(String value) {
            addCriterion("info_isEveryOne <>", value, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneGreaterThan(String value) {
            addCriterion("info_isEveryOne >", value, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneGreaterThanOrEqualTo(String value) {
            addCriterion("info_isEveryOne >=", value, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneLessThan(String value) {
            addCriterion("info_isEveryOne <", value, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneLessThanOrEqualTo(String value) {
            addCriterion("info_isEveryOne <=", value, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneLike(String value) {
            addCriterion("info_isEveryOne like", value, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneNotLike(String value) {
            addCriterion("info_isEveryOne not like", value, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneIn(List<String> values) {
            addCriterion("info_isEveryOne in", values, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneNotIn(List<String> values) {
            addCriterion("info_isEveryOne not in", values, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneBetween(String value1, String value2) {
            addCriterion("info_isEveryOne between", value1, value2, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoIseveryoneNotBetween(String value1, String value2) {
            addCriterion("info_isEveryOne not between", value1, value2, "infoIseveryone");
            return (Criteria) this;
        }

        public Criteria andInfoVersionIsNull() {
            addCriterion("info_version is null");
            return (Criteria) this;
        }

        public Criteria andInfoVersionIsNotNull() {
            addCriterion("info_version is not null");
            return (Criteria) this;
        }

        public Criteria andInfoVersionEqualTo(Integer value) {
            addCriterion("info_version =", value, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionNotEqualTo(Integer value) {
            addCriterion("info_version <>", value, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionGreaterThan(Integer value) {
            addCriterion("info_version >", value, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_version >=", value, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionLessThan(Integer value) {
            addCriterion("info_version <", value, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionLessThanOrEqualTo(Integer value) {
            addCriterion("info_version <=", value, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionIn(List<Integer> values) {
            addCriterion("info_version in", values, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionNotIn(List<Integer> values) {
            addCriterion("info_version not in", values, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionBetween(Integer value1, Integer value2) {
            addCriterion("info_version between", value1, value2, "infoVersion");
            return (Criteria) this;
        }

        public Criteria andInfoVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("info_version not between", value1, value2, "infoVersion");
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
package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SysRewardPsmtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRewardPsmtExample() {
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

        public Criteria andRewPsmtIdIsNull() {
            addCriterion("rew_psmt_id is null");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdIsNotNull() {
            addCriterion("rew_psmt_id is not null");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdEqualTo(String value) {
            addCriterion("rew_psmt_id =", value, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdNotEqualTo(String value) {
            addCriterion("rew_psmt_id <>", value, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdGreaterThan(String value) {
            addCriterion("rew_psmt_id >", value, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdGreaterThanOrEqualTo(String value) {
            addCriterion("rew_psmt_id >=", value, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdLessThan(String value) {
            addCriterion("rew_psmt_id <", value, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdLessThanOrEqualTo(String value) {
            addCriterion("rew_psmt_id <=", value, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdLike(String value) {
            addCriterion("rew_psmt_id like", value, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdNotLike(String value) {
            addCriterion("rew_psmt_id not like", value, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdIn(List<String> values) {
            addCriterion("rew_psmt_id in", values, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdNotIn(List<String> values) {
            addCriterion("rew_psmt_id not in", values, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdBetween(String value1, String value2) {
            addCriterion("rew_psmt_id between", value1, value2, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtIdNotBetween(String value1, String value2) {
            addCriterion("rew_psmt_id not between", value1, value2, "rewPsmtId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(String value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(String value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(String value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(String value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(String value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLike(String value) {
            addCriterion("emp_id like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotLike(String value) {
            addCriterion("emp_id not like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<String> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<String> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(String value1, String value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(String value1, String value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeIsNull() {
            addCriterion("rew_psmt_type is null");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeIsNotNull() {
            addCriterion("rew_psmt_type is not null");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeEqualTo(String value) {
            addCriterion("rew_psmt_type =", value, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeNotEqualTo(String value) {
            addCriterion("rew_psmt_type <>", value, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeGreaterThan(String value) {
            addCriterion("rew_psmt_type >", value, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rew_psmt_type >=", value, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeLessThan(String value) {
            addCriterion("rew_psmt_type <", value, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeLessThanOrEqualTo(String value) {
            addCriterion("rew_psmt_type <=", value, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeLike(String value) {
            addCriterion("rew_psmt_type like", value, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeNotLike(String value) {
            addCriterion("rew_psmt_type not like", value, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeIn(List<String> values) {
            addCriterion("rew_psmt_type in", values, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeNotIn(List<String> values) {
            addCriterion("rew_psmt_type not in", values, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeBetween(String value1, String value2) {
            addCriterion("rew_psmt_type between", value1, value2, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andRewPsmtTypeNotBetween(String value1, String value2) {
            addCriterion("rew_psmt_type not between", value1, value2, "rewPsmtType");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(String value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(String value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(String value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(String value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(String value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLike(String value) {
            addCriterion("publish_time like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotLike(String value) {
            addCriterion("publish_time not like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<String> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<String> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(String value1, String value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(String value1, String value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoIsNull() {
            addCriterion("rew_psmt_photo is null");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoIsNotNull() {
            addCriterion("rew_psmt_photo is not null");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoEqualTo(String value) {
            addCriterion("rew_psmt_photo =", value, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoNotEqualTo(String value) {
            addCriterion("rew_psmt_photo <>", value, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoGreaterThan(String value) {
            addCriterion("rew_psmt_photo >", value, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("rew_psmt_photo >=", value, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoLessThan(String value) {
            addCriterion("rew_psmt_photo <", value, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoLessThanOrEqualTo(String value) {
            addCriterion("rew_psmt_photo <=", value, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoLike(String value) {
            addCriterion("rew_psmt_photo like", value, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoNotLike(String value) {
            addCriterion("rew_psmt_photo not like", value, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoIn(List<String> values) {
            addCriterion("rew_psmt_photo in", values, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoNotIn(List<String> values) {
            addCriterion("rew_psmt_photo not in", values, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoBetween(String value1, String value2) {
            addCriterion("rew_psmt_photo between", value1, value2, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andRewPsmtPhotoNotBetween(String value1, String value2) {
            addCriterion("rew_psmt_photo not between", value1, value2, "rewPsmtPhoto");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdIsNull() {
            addCriterion("create_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdIsNotNull() {
            addCriterion("create_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdEqualTo(String value) {
            addCriterion("create_emp_id =", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdNotEqualTo(String value) {
            addCriterion("create_emp_id <>", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdGreaterThan(String value) {
            addCriterion("create_emp_id >", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_emp_id >=", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdLessThan(String value) {
            addCriterion("create_emp_id <", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdLessThanOrEqualTo(String value) {
            addCriterion("create_emp_id <=", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdLike(String value) {
            addCriterion("create_emp_id like", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdNotLike(String value) {
            addCriterion("create_emp_id not like", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdIn(List<String> values) {
            addCriterion("create_emp_id in", values, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdNotIn(List<String> values) {
            addCriterion("create_emp_id not in", values, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdBetween(String value1, String value2) {
            addCriterion("create_emp_id between", value1, value2, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdNotBetween(String value1, String value2) {
            addCriterion("create_emp_id not between", value1, value2, "createEmpId");
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

        public Criteria andUpdateEmpIdIsNull() {
            addCriterion("update_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdIsNotNull() {
            addCriterion("update_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdEqualTo(String value) {
            addCriterion("update_emp_id =", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotEqualTo(String value) {
            addCriterion("update_emp_id <>", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdGreaterThan(String value) {
            addCriterion("update_emp_id >", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_emp_id >=", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLessThan(String value) {
            addCriterion("update_emp_id <", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLessThanOrEqualTo(String value) {
            addCriterion("update_emp_id <=", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLike(String value) {
            addCriterion("update_emp_id like", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotLike(String value) {
            addCriterion("update_emp_id not like", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdIn(List<String> values) {
            addCriterion("update_emp_id in", values, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotIn(List<String> values) {
            addCriterion("update_emp_id not in", values, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdBetween(String value1, String value2) {
            addCriterion("update_emp_id between", value1, value2, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotBetween(String value1, String value2) {
            addCriterion("update_emp_id not between", value1, value2, "updateEmpId");
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
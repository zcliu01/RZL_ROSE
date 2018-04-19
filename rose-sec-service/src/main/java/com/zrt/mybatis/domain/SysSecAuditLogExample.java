package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SysSecAuditLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSecAuditLogExample() {
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

        public Criteria andAuditLogIdIsNull() {
            addCriterion("audit_log_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdIsNotNull() {
            addCriterion("audit_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdEqualTo(String value) {
            addCriterion("audit_log_id =", value, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdNotEqualTo(String value) {
            addCriterion("audit_log_id <>", value, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdGreaterThan(String value) {
            addCriterion("audit_log_id >", value, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdGreaterThanOrEqualTo(String value) {
            addCriterion("audit_log_id >=", value, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdLessThan(String value) {
            addCriterion("audit_log_id <", value, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdLessThanOrEqualTo(String value) {
            addCriterion("audit_log_id <=", value, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdLike(String value) {
            addCriterion("audit_log_id like", value, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdNotLike(String value) {
            addCriterion("audit_log_id not like", value, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdIn(List<String> values) {
            addCriterion("audit_log_id in", values, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdNotIn(List<String> values) {
            addCriterion("audit_log_id not in", values, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdBetween(String value1, String value2) {
            addCriterion("audit_log_id between", value1, value2, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andAuditLogIdNotBetween(String value1, String value2) {
            addCriterion("audit_log_id not between", value1, value2, "auditLogId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNull() {
            addCriterion("ip_address is null");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNotNull() {
            addCriterion("ip_address is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddressEqualTo(String value) {
            addCriterion("ip_address =", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotEqualTo(String value) {
            addCriterion("ip_address <>", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThan(String value) {
            addCriterion("ip_address >", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ip_address >=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThan(String value) {
            addCriterion("ip_address <", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThanOrEqualTo(String value) {
            addCriterion("ip_address <=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLike(String value) {
            addCriterion("ip_address like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotLike(String value) {
            addCriterion("ip_address not like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressIn(List<String> values) {
            addCriterion("ip_address in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotIn(List<String> values) {
            addCriterion("ip_address not in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressBetween(String value1, String value2) {
            addCriterion("ip_address between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotBetween(String value1, String value2) {
            addCriterion("ip_address not between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(String value) {
            addCriterion("resource_id =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(String value) {
            addCriterion("resource_id <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(String value) {
            addCriterion("resource_id >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("resource_id >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(String value) {
            addCriterion("resource_id <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(String value) {
            addCriterion("resource_id <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLike(String value) {
            addCriterion("resource_id like", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotLike(String value) {
            addCriterion("resource_id not like", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<String> values) {
            addCriterion("resource_id in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<String> values) {
            addCriterion("resource_id not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(String value1, String value2) {
            addCriterion("resource_id between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(String value1, String value2) {
            addCriterion("resource_id not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resource_name =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resource_name <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resource_name like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resource_name not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resource_name in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNull() {
            addCriterion("resource_url is null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNotNull() {
            addCriterion("resource_url is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlEqualTo(String value) {
            addCriterion("resource_url =", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotEqualTo(String value) {
            addCriterion("resource_url <>", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThan(String value) {
            addCriterion("resource_url >", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("resource_url >=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThan(String value) {
            addCriterion("resource_url <", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThanOrEqualTo(String value) {
            addCriterion("resource_url <=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLike(String value) {
            addCriterion("resource_url like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotLike(String value) {
            addCriterion("resource_url not like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIn(List<String> values) {
            addCriterion("resource_url in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotIn(List<String> values) {
            addCriterion("resource_url not in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlBetween(String value1, String value2) {
            addCriterion("resource_url between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotBetween(String value1, String value2) {
            addCriterion("resource_url not between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andOperIsNull() {
            addCriterion("oper is null");
            return (Criteria) this;
        }

        public Criteria andOperIsNotNull() {
            addCriterion("oper is not null");
            return (Criteria) this;
        }

        public Criteria andOperEqualTo(String value) {
            addCriterion("oper =", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotEqualTo(String value) {
            addCriterion("oper <>", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperGreaterThan(String value) {
            addCriterion("oper >", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperGreaterThanOrEqualTo(String value) {
            addCriterion("oper >=", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLessThan(String value) {
            addCriterion("oper <", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLessThanOrEqualTo(String value) {
            addCriterion("oper <=", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLike(String value) {
            addCriterion("oper like", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotLike(String value) {
            addCriterion("oper not like", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperIn(List<String> values) {
            addCriterion("oper in", values, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotIn(List<String> values) {
            addCriterion("oper not in", values, "oper");
            return (Criteria) this;
        }

        public Criteria andOperBetween(String value1, String value2) {
            addCriterion("oper between", value1, value2, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotBetween(String value1, String value2) {
            addCriterion("oper not between", value1, value2, "oper");
            return (Criteria) this;
        }

        public Criteria andOperStatusIsNull() {
            addCriterion("oper_status is null");
            return (Criteria) this;
        }

        public Criteria andOperStatusIsNotNull() {
            addCriterion("oper_status is not null");
            return (Criteria) this;
        }

        public Criteria andOperStatusEqualTo(String value) {
            addCriterion("oper_status =", value, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusNotEqualTo(String value) {
            addCriterion("oper_status <>", value, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusGreaterThan(String value) {
            addCriterion("oper_status >", value, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusGreaterThanOrEqualTo(String value) {
            addCriterion("oper_status >=", value, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusLessThan(String value) {
            addCriterion("oper_status <", value, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusLessThanOrEqualTo(String value) {
            addCriterion("oper_status <=", value, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusLike(String value) {
            addCriterion("oper_status like", value, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusNotLike(String value) {
            addCriterion("oper_status not like", value, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusIn(List<String> values) {
            addCriterion("oper_status in", values, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusNotIn(List<String> values) {
            addCriterion("oper_status not in", values, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusBetween(String value1, String value2) {
            addCriterion("oper_status between", value1, value2, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperStatusNotBetween(String value1, String value2) {
            addCriterion("oper_status not between", value1, value2, "operStatus");
            return (Criteria) this;
        }

        public Criteria andOperRemarkIsNull() {
            addCriterion("oper_remark is null");
            return (Criteria) this;
        }

        public Criteria andOperRemarkIsNotNull() {
            addCriterion("oper_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOperRemarkEqualTo(String value) {
            addCriterion("oper_remark =", value, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkNotEqualTo(String value) {
            addCriterion("oper_remark <>", value, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkGreaterThan(String value) {
            addCriterion("oper_remark >", value, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("oper_remark >=", value, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkLessThan(String value) {
            addCriterion("oper_remark <", value, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkLessThanOrEqualTo(String value) {
            addCriterion("oper_remark <=", value, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkLike(String value) {
            addCriterion("oper_remark like", value, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkNotLike(String value) {
            addCriterion("oper_remark not like", value, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkIn(List<String> values) {
            addCriterion("oper_remark in", values, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkNotIn(List<String> values) {
            addCriterion("oper_remark not in", values, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkBetween(String value1, String value2) {
            addCriterion("oper_remark between", value1, value2, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperRemarkNotBetween(String value1, String value2) {
            addCriterion("oper_remark not between", value1, value2, "operRemark");
            return (Criteria) this;
        }

        public Criteria andOperDateIsNull() {
            addCriterion("oper_date is null");
            return (Criteria) this;
        }

        public Criteria andOperDateIsNotNull() {
            addCriterion("oper_date is not null");
            return (Criteria) this;
        }

        public Criteria andOperDateEqualTo(String value) {
            addCriterion("oper_date =", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotEqualTo(String value) {
            addCriterion("oper_date <>", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateGreaterThan(String value) {
            addCriterion("oper_date >", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateGreaterThanOrEqualTo(String value) {
            addCriterion("oper_date >=", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLessThan(String value) {
            addCriterion("oper_date <", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLessThanOrEqualTo(String value) {
            addCriterion("oper_date <=", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateLike(String value) {
            addCriterion("oper_date like", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotLike(String value) {
            addCriterion("oper_date not like", value, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateIn(List<String> values) {
            addCriterion("oper_date in", values, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotIn(List<String> values) {
            addCriterion("oper_date not in", values, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateBetween(String value1, String value2) {
            addCriterion("oper_date between", value1, value2, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperDateNotBetween(String value1, String value2) {
            addCriterion("oper_date not between", value1, value2, "operDate");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNull() {
            addCriterion("oper_time is null");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNotNull() {
            addCriterion("oper_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperTimeEqualTo(String value) {
            addCriterion("oper_time =", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotEqualTo(String value) {
            addCriterion("oper_time <>", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThan(String value) {
            addCriterion("oper_time >", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThanOrEqualTo(String value) {
            addCriterion("oper_time >=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThan(String value) {
            addCriterion("oper_time <", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThanOrEqualTo(String value) {
            addCriterion("oper_time <=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLike(String value) {
            addCriterion("oper_time like", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotLike(String value) {
            addCriterion("oper_time not like", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeIn(List<String> values) {
            addCriterion("oper_time in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotIn(List<String> values) {
            addCriterion("oper_time not in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeBetween(String value1, String value2) {
            addCriterion("oper_time between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotBetween(String value1, String value2) {
            addCriterion("oper_time not between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("service_id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("service_id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
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
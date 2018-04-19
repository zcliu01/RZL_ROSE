package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusRuleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFbIdIsNull() {
            addCriterion("fb_id is null");
            return (Criteria) this;
        }

        public Criteria andFbIdIsNotNull() {
            addCriterion("fb_id is not null");
            return (Criteria) this;
        }

        public Criteria andFbIdEqualTo(String value) {
            addCriterion("fb_id =", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotEqualTo(String value) {
            addCriterion("fb_id <>", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdGreaterThan(String value) {
            addCriterion("fb_id >", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdGreaterThanOrEqualTo(String value) {
            addCriterion("fb_id >=", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLessThan(String value) {
            addCriterion("fb_id <", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLessThanOrEqualTo(String value) {
            addCriterion("fb_id <=", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLike(String value) {
            addCriterion("fb_id like", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotLike(String value) {
            addCriterion("fb_id not like", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdIn(List<String> values) {
            addCriterion("fb_id in", values, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotIn(List<String> values) {
            addCriterion("fb_id not in", values, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdBetween(String value1, String value2) {
            addCriterion("fb_id between", value1, value2, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotBetween(String value1, String value2) {
            addCriterion("fb_id not between", value1, value2, "fbId");
            return (Criteria) this;
        }

        public Criteria andInstTagIsNull() {
            addCriterion("inst_tag is null");
            return (Criteria) this;
        }

        public Criteria andInstTagIsNotNull() {
            addCriterion("inst_tag is not null");
            return (Criteria) this;
        }

        public Criteria andInstTagEqualTo(String value) {
            addCriterion("inst_tag =", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNotEqualTo(String value) {
            addCriterion("inst_tag <>", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagGreaterThan(String value) {
            addCriterion("inst_tag >", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagGreaterThanOrEqualTo(String value) {
            addCriterion("inst_tag >=", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagLessThan(String value) {
            addCriterion("inst_tag <", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagLessThanOrEqualTo(String value) {
            addCriterion("inst_tag <=", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagLike(String value) {
            addCriterion("inst_tag like", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNotLike(String value) {
            addCriterion("inst_tag not like", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagIn(List<String> values) {
            addCriterion("inst_tag in", values, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNotIn(List<String> values) {
            addCriterion("inst_tag not in", values, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagBetween(String value1, String value2) {
            addCriterion("inst_tag between", value1, value2, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNotBetween(String value1, String value2) {
            addCriterion("inst_tag not between", value1, value2, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNameIsNull() {
            addCriterion("inst_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andInstTagNameIsNotNull() {
            addCriterion("inst_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstTagNameEqualTo(String value) {
            addCriterion("inst_tag_name =", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameNotEqualTo(String value) {
            addCriterion("inst_tag_name <>", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameGreaterThan(String value) {
            addCriterion("inst_tag_name >", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("inst_tag_name >=", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameLessThan(String value) {
            addCriterion("inst_tag_name <", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameLessThanOrEqualTo(String value) {
            addCriterion("inst_tag_name <=", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameLike(String value) {
            addCriterion("inst_tag_name like", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameNotLike(String value) {
            addCriterion("inst_tag_name not like", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameIn(List<String> values) {
            addCriterion("inst_tag_name in", values, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameNotIn(List<String> values) {
            addCriterion("inst_tag_name not in", values, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameBetween(String value1, String value2) {
            addCriterion("inst_tag_name between", value1, value2, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameNotBetween(String value1, String value2) {
            addCriterion("inst_tag_name not between", value1, value2, "instTagName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdIsNull() {
            addCriterion("check_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdIsNotNull() {
            addCriterion("check_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdEqualTo(String value) {
            addCriterion("check_emp_id =", value, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdNotEqualTo(String value) {
            addCriterion("check_emp_id <>", value, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdGreaterThan(String value) {
            addCriterion("check_emp_id >", value, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("check_emp_id >=", value, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdLessThan(String value) {
            addCriterion("check_emp_id <", value, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdLessThanOrEqualTo(String value) {
            addCriterion("check_emp_id <=", value, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdLike(String value) {
            addCriterion("check_emp_id like", value, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdNotLike(String value) {
            addCriterion("check_emp_id not like", value, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdIn(List<String> values) {
            addCriterion("check_emp_id in", values, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdNotIn(List<String> values) {
            addCriterion("check_emp_id not in", values, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdBetween(String value1, String value2) {
            addCriterion("check_emp_id between", value1, value2, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpIdNotBetween(String value1, String value2) {
            addCriterion("check_emp_id not between", value1, value2, "checkEmpId");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameIsNull() {
            addCriterion("check_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameIsNotNull() {
            addCriterion("check_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameEqualTo(String value) {
            addCriterion("check_emp_name =", value, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameNotEqualTo(String value) {
            addCriterion("check_emp_name <>", value, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameGreaterThan(String value) {
            addCriterion("check_emp_name >", value, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("check_emp_name >=", value, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameLessThan(String value) {
            addCriterion("check_emp_name <", value, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameLessThanOrEqualTo(String value) {
            addCriterion("check_emp_name <=", value, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameLike(String value) {
            addCriterion("check_emp_name like", value, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameNotLike(String value) {
            addCriterion("check_emp_name not like", value, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameIn(List<String> values) {
            addCriterion("check_emp_name in", values, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameNotIn(List<String> values) {
            addCriterion("check_emp_name not in", values, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameBetween(String value1, String value2) {
            addCriterion("check_emp_name between", value1, value2, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckEmpNameNotBetween(String value1, String value2) {
            addCriterion("check_emp_name not between", value1, value2, "checkEmpName");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andRuleOrderIsNull() {
            addCriterion("rule_order is null");
            return (Criteria) this;
        }

        public Criteria andRuleOrderIsNotNull() {
            addCriterion("rule_order is not null");
            return (Criteria) this;
        }

        public Criteria andRuleOrderEqualTo(Integer value) {
            addCriterion("rule_order =", value, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderNotEqualTo(Integer value) {
            addCriterion("rule_order <>", value, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderGreaterThan(Integer value) {
            addCriterion("rule_order >", value, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_order >=", value, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderLessThan(Integer value) {
            addCriterion("rule_order <", value, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderLessThanOrEqualTo(Integer value) {
            addCriterion("rule_order <=", value, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderIn(List<Integer> values) {
            addCriterion("rule_order in", values, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderNotIn(List<Integer> values) {
            addCriterion("rule_order not in", values, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderBetween(Integer value1, Integer value2) {
            addCriterion("rule_order between", value1, value2, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andRuleOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_order not between", value1, value2, "ruleOrder");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeIsNull() {
            addCriterion("begin_date_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeIsNotNull() {
            addCriterion("begin_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeEqualTo(String value) {
            addCriterion("begin_date_time =", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeNotEqualTo(String value) {
            addCriterion("begin_date_time <>", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeGreaterThan(String value) {
            addCriterion("begin_date_time >", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("begin_date_time >=", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeLessThan(String value) {
            addCriterion("begin_date_time <", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeLessThanOrEqualTo(String value) {
            addCriterion("begin_date_time <=", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeLike(String value) {
            addCriterion("begin_date_time like", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeNotLike(String value) {
            addCriterion("begin_date_time not like", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeIn(List<String> values) {
            addCriterion("begin_date_time in", values, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeNotIn(List<String> values) {
            addCriterion("begin_date_time not in", values, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeBetween(String value1, String value2) {
            addCriterion("begin_date_time between", value1, value2, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeNotBetween(String value1, String value2) {
            addCriterion("begin_date_time not between", value1, value2, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIsNull() {
            addCriterion("end_date_time is null");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIsNotNull() {
            addCriterion("end_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeEqualTo(String value) {
            addCriterion("end_date_time =", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotEqualTo(String value) {
            addCriterion("end_date_time <>", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeGreaterThan(String value) {
            addCriterion("end_date_time >", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_date_time >=", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLessThan(String value) {
            addCriterion("end_date_time <", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLessThanOrEqualTo(String value) {
            addCriterion("end_date_time <=", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLike(String value) {
            addCriterion("end_date_time like", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotLike(String value) {
            addCriterion("end_date_time not like", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIn(List<String> values) {
            addCriterion("end_date_time in", values, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotIn(List<String> values) {
            addCriterion("end_date_time not in", values, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeBetween(String value1, String value2) {
            addCriterion("end_date_time between", value1, value2, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotBetween(String value1, String value2) {
            addCriterion("end_date_time not between", value1, value2, "endDateTime");
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

        public Criteria andRuleEnabledIsNull() {
            addCriterion("rule_enabled is null");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledIsNotNull() {
            addCriterion("rule_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledEqualTo(String value) {
            addCriterion("rule_enabled =", value, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledNotEqualTo(String value) {
            addCriterion("rule_enabled <>", value, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledGreaterThan(String value) {
            addCriterion("rule_enabled >", value, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("rule_enabled >=", value, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledLessThan(String value) {
            addCriterion("rule_enabled <", value, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledLessThanOrEqualTo(String value) {
            addCriterion("rule_enabled <=", value, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledLike(String value) {
            addCriterion("rule_enabled like", value, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledNotLike(String value) {
            addCriterion("rule_enabled not like", value, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledIn(List<String> values) {
            addCriterion("rule_enabled in", values, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledNotIn(List<String> values) {
            addCriterion("rule_enabled not in", values, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledBetween(String value1, String value2) {
            addCriterion("rule_enabled between", value1, value2, "ruleEnabled");
            return (Criteria) this;
        }

        public Criteria andRuleEnabledNotBetween(String value1, String value2) {
            addCriterion("rule_enabled not between", value1, value2, "ruleEnabled");
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
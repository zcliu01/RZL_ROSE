package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusHandleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusHandleExample() {
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

        public Criteria andHandleEmpIdIsNull() {
            addCriterion("handle_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdIsNotNull() {
            addCriterion("handle_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdEqualTo(String value) {
            addCriterion("handle_emp_id =", value, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdNotEqualTo(String value) {
            addCriterion("handle_emp_id <>", value, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdGreaterThan(String value) {
            addCriterion("handle_emp_id >", value, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("handle_emp_id >=", value, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdLessThan(String value) {
            addCriterion("handle_emp_id <", value, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdLessThanOrEqualTo(String value) {
            addCriterion("handle_emp_id <=", value, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdLike(String value) {
            addCriterion("handle_emp_id like", value, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdNotLike(String value) {
            addCriterion("handle_emp_id not like", value, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdIn(List<String> values) {
            addCriterion("handle_emp_id in", values, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdNotIn(List<String> values) {
            addCriterion("handle_emp_id not in", values, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdBetween(String value1, String value2) {
            addCriterion("handle_emp_id between", value1, value2, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpIdNotBetween(String value1, String value2) {
            addCriterion("handle_emp_id not between", value1, value2, "handleEmpId");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameIsNull() {
            addCriterion("handle_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameIsNotNull() {
            addCriterion("handle_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameEqualTo(String value) {
            addCriterion("handle_emp_name =", value, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameNotEqualTo(String value) {
            addCriterion("handle_emp_name <>", value, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameGreaterThan(String value) {
            addCriterion("handle_emp_name >", value, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("handle_emp_name >=", value, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameLessThan(String value) {
            addCriterion("handle_emp_name <", value, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameLessThanOrEqualTo(String value) {
            addCriterion("handle_emp_name <=", value, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameLike(String value) {
            addCriterion("handle_emp_name like", value, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameNotLike(String value) {
            addCriterion("handle_emp_name not like", value, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameIn(List<String> values) {
            addCriterion("handle_emp_name in", values, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameNotIn(List<String> values) {
            addCriterion("handle_emp_name not in", values, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameBetween(String value1, String value2) {
            addCriterion("handle_emp_name between", value1, value2, "handleEmpName");
            return (Criteria) this;
        }

        public Criteria andHandleEmpNameNotBetween(String value1, String value2) {
            addCriterion("handle_emp_name not between", value1, value2, "handleEmpName");
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

        public Criteria andSendEmpIdIsNull() {
            addCriterion("send_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdIsNotNull() {
            addCriterion("send_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdEqualTo(String value) {
            addCriterion("send_emp_id =", value, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdNotEqualTo(String value) {
            addCriterion("send_emp_id <>", value, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdGreaterThan(String value) {
            addCriterion("send_emp_id >", value, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("send_emp_id >=", value, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdLessThan(String value) {
            addCriterion("send_emp_id <", value, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdLessThanOrEqualTo(String value) {
            addCriterion("send_emp_id <=", value, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdLike(String value) {
            addCriterion("send_emp_id like", value, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdNotLike(String value) {
            addCriterion("send_emp_id not like", value, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdIn(List<String> values) {
            addCriterion("send_emp_id in", values, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdNotIn(List<String> values) {
            addCriterion("send_emp_id not in", values, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdBetween(String value1, String value2) {
            addCriterion("send_emp_id between", value1, value2, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpIdNotBetween(String value1, String value2) {
            addCriterion("send_emp_id not between", value1, value2, "sendEmpId");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameIsNull() {
            addCriterion("send_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameIsNotNull() {
            addCriterion("send_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameEqualTo(String value) {
            addCriterion("send_emp_name =", value, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameNotEqualTo(String value) {
            addCriterion("send_emp_name <>", value, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameGreaterThan(String value) {
            addCriterion("send_emp_name >", value, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("send_emp_name >=", value, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameLessThan(String value) {
            addCriterion("send_emp_name <", value, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameLessThanOrEqualTo(String value) {
            addCriterion("send_emp_name <=", value, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameLike(String value) {
            addCriterion("send_emp_name like", value, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameNotLike(String value) {
            addCriterion("send_emp_name not like", value, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameIn(List<String> values) {
            addCriterion("send_emp_name in", values, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameNotIn(List<String> values) {
            addCriterion("send_emp_name not in", values, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameBetween(String value1, String value2) {
            addCriterion("send_emp_name between", value1, value2, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andSendEmpNameNotBetween(String value1, String value2) {
            addCriterion("send_emp_name not between", value1, value2, "sendEmpName");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(String value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(String value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(String value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(String value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLike(String value) {
            addCriterion("check_status like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotLike(String value) {
            addCriterion("check_status not like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<String> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<String> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(String value1, String value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(String value1, String value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andInstIdIsNull() {
            addCriterion("inst_id is null");
            return (Criteria) this;
        }

        public Criteria andInstIdIsNotNull() {
            addCriterion("inst_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstIdEqualTo(String value) {
            addCriterion("inst_id =", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotEqualTo(String value) {
            addCriterion("inst_id <>", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdGreaterThan(String value) {
            addCriterion("inst_id >", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdGreaterThanOrEqualTo(String value) {
            addCriterion("inst_id >=", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLessThan(String value) {
            addCriterion("inst_id <", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLessThanOrEqualTo(String value) {
            addCriterion("inst_id <=", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdLike(String value) {
            addCriterion("inst_id like", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotLike(String value) {
            addCriterion("inst_id not like", value, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdIn(List<String> values) {
            addCriterion("inst_id in", values, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotIn(List<String> values) {
            addCriterion("inst_id not in", values, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdBetween(String value1, String value2) {
            addCriterion("inst_id between", value1, value2, "instId");
            return (Criteria) this;
        }

        public Criteria andInstIdNotBetween(String value1, String value2) {
            addCriterion("inst_id not between", value1, value2, "instId");
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

        public Criteria andCheckDateTimeIsNull() {
            addCriterion("check_date_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeIsNotNull() {
            addCriterion("check_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeEqualTo(String value) {
            addCriterion("check_date_time =", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeNotEqualTo(String value) {
            addCriterion("check_date_time <>", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeGreaterThan(String value) {
            addCriterion("check_date_time >", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("check_date_time >=", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeLessThan(String value) {
            addCriterion("check_date_time <", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeLessThanOrEqualTo(String value) {
            addCriterion("check_date_time <=", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeLike(String value) {
            addCriterion("check_date_time like", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeNotLike(String value) {
            addCriterion("check_date_time not like", value, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeIn(List<String> values) {
            addCriterion("check_date_time in", values, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeNotIn(List<String> values) {
            addCriterion("check_date_time not in", values, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeBetween(String value1, String value2) {
            addCriterion("check_date_time between", value1, value2, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckDateTimeNotBetween(String value1, String value2) {
            addCriterion("check_date_time not between", value1, value2, "checkDateTime");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIsNull() {
            addCriterion("check_comment is null");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIsNotNull() {
            addCriterion("check_comment is not null");
            return (Criteria) this;
        }

        public Criteria andCheckCommentEqualTo(String value) {
            addCriterion("check_comment =", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotEqualTo(String value) {
            addCriterion("check_comment <>", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentGreaterThan(String value) {
            addCriterion("check_comment >", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentGreaterThanOrEqualTo(String value) {
            addCriterion("check_comment >=", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLessThan(String value) {
            addCriterion("check_comment <", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLessThanOrEqualTo(String value) {
            addCriterion("check_comment <=", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentLike(String value) {
            addCriterion("check_comment like", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotLike(String value) {
            addCriterion("check_comment not like", value, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentIn(List<String> values) {
            addCriterion("check_comment in", values, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotIn(List<String> values) {
            addCriterion("check_comment not in", values, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentBetween(String value1, String value2) {
            addCriterion("check_comment between", value1, value2, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckCommentNotBetween(String value1, String value2) {
            addCriterion("check_comment not between", value1, value2, "checkComment");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNull() {
            addCriterion("check_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(String value) {
            addCriterion("check_id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(String value) {
            addCriterion("check_id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(String value) {
            addCriterion("check_id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("check_id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(String value) {
            addCriterion("check_id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(String value) {
            addCriterion("check_id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLike(String value) {
            addCriterion("check_id like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotLike(String value) {
            addCriterion("check_id not like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<String> values) {
            addCriterion("check_id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<String> values) {
            addCriterion("check_id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(String value1, String value2) {
            addCriterion("check_id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(String value1, String value2) {
            addCriterion("check_id not between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNull() {
            addCriterion("handle_status is null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNotNull() {
            addCriterion("handle_status is not null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusEqualTo(String value) {
            addCriterion("handle_status =", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotEqualTo(String value) {
            addCriterion("handle_status <>", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThan(String value) {
            addCriterion("handle_status >", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("handle_status >=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThan(String value) {
            addCriterion("handle_status <", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThanOrEqualTo(String value) {
            addCriterion("handle_status <=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLike(String value) {
            addCriterion("handle_status like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotLike(String value) {
            addCriterion("handle_status not like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIn(List<String> values) {
            addCriterion("handle_status in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotIn(List<String> values) {
            addCriterion("handle_status not in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusBetween(String value1, String value2) {
            addCriterion("handle_status between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotBetween(String value1, String value2) {
            addCriterion("handle_status not between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andHandleDescIsNull() {
            addCriterion("handle_desc is null");
            return (Criteria) this;
        }

        public Criteria andHandleDescIsNotNull() {
            addCriterion("handle_desc is not null");
            return (Criteria) this;
        }

        public Criteria andHandleDescEqualTo(String value) {
            addCriterion("handle_desc =", value, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescNotEqualTo(String value) {
            addCriterion("handle_desc <>", value, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescGreaterThan(String value) {
            addCriterion("handle_desc >", value, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescGreaterThanOrEqualTo(String value) {
            addCriterion("handle_desc >=", value, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescLessThan(String value) {
            addCriterion("handle_desc <", value, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescLessThanOrEqualTo(String value) {
            addCriterion("handle_desc <=", value, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescLike(String value) {
            addCriterion("handle_desc like", value, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescNotLike(String value) {
            addCriterion("handle_desc not like", value, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescIn(List<String> values) {
            addCriterion("handle_desc in", values, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescNotIn(List<String> values) {
            addCriterion("handle_desc not in", values, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescBetween(String value1, String value2) {
            addCriterion("handle_desc between", value1, value2, "handleDesc");
            return (Criteria) this;
        }

        public Criteria andHandleDescNotBetween(String value1, String value2) {
            addCriterion("handle_desc not between", value1, value2, "handleDesc");
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
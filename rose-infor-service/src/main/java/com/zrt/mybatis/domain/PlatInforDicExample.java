package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class PlatInforDicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatInforDicExample() {
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

        public Criteria andDicIdIsNull() {
            addCriterion("dic_id is null");
            return (Criteria) this;
        }

        public Criteria andDicIdIsNotNull() {
            addCriterion("dic_id is not null");
            return (Criteria) this;
        }

        public Criteria andDicIdEqualTo(String value) {
            addCriterion("dic_id =", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotEqualTo(String value) {
            addCriterion("dic_id <>", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdGreaterThan(String value) {
            addCriterion("dic_id >", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdGreaterThanOrEqualTo(String value) {
            addCriterion("dic_id >=", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLessThan(String value) {
            addCriterion("dic_id <", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLessThanOrEqualTo(String value) {
            addCriterion("dic_id <=", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdLike(String value) {
            addCriterion("dic_id like", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotLike(String value) {
            addCriterion("dic_id not like", value, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdIn(List<String> values) {
            addCriterion("dic_id in", values, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotIn(List<String> values) {
            addCriterion("dic_id not in", values, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdBetween(String value1, String value2) {
            addCriterion("dic_id between", value1, value2, "dicId");
            return (Criteria) this;
        }

        public Criteria andDicIdNotBetween(String value1, String value2) {
            addCriterion("dic_id not between", value1, value2, "dicId");
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

        public Criteria andParentCodeIsNull() {
            addCriterion("parent_code is null");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNotNull() {
            addCriterion("parent_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentCodeEqualTo(String value) {
            addCriterion("parent_code =", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotEqualTo(String value) {
            addCriterion("parent_code <>", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThan(String value) {
            addCriterion("parent_code >", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_code >=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThan(String value) {
            addCriterion("parent_code <", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_code <=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLike(String value) {
            addCriterion("parent_code like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotLike(String value) {
            addCriterion("parent_code not like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIn(List<String> values) {
            addCriterion("parent_code in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotIn(List<String> values) {
            addCriterion("parent_code not in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeBetween(String value1, String value2) {
            addCriterion("parent_code between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotBetween(String value1, String value2) {
            addCriterion("parent_code not between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNull() {
            addCriterion("dic_code is null");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNotNull() {
            addCriterion("dic_code is not null");
            return (Criteria) this;
        }

        public Criteria andDicCodeEqualTo(String value) {
            addCriterion("dic_code =", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotEqualTo(String value) {
            addCriterion("dic_code <>", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThan(String value) {
            addCriterion("dic_code >", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dic_code >=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThan(String value) {
            addCriterion("dic_code <", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThanOrEqualTo(String value) {
            addCriterion("dic_code <=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLike(String value) {
            addCriterion("dic_code like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotLike(String value) {
            addCriterion("dic_code not like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeIn(List<String> values) {
            addCriterion("dic_code in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotIn(List<String> values) {
            addCriterion("dic_code not in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeBetween(String value1, String value2) {
            addCriterion("dic_code between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotBetween(String value1, String value2) {
            addCriterion("dic_code not between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicNameIsNull() {
            addCriterion("dic_name is null");
            return (Criteria) this;
        }

        public Criteria andDicNameIsNotNull() {
            addCriterion("dic_name is not null");
            return (Criteria) this;
        }

        public Criteria andDicNameEqualTo(String value) {
            addCriterion("dic_name =", value, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameNotEqualTo(String value) {
            addCriterion("dic_name <>", value, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameGreaterThan(String value) {
            addCriterion("dic_name >", value, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameGreaterThanOrEqualTo(String value) {
            addCriterion("dic_name >=", value, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameLessThan(String value) {
            addCriterion("dic_name <", value, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameLessThanOrEqualTo(String value) {
            addCriterion("dic_name <=", value, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameLike(String value) {
            addCriterion("dic_name like", value, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameNotLike(String value) {
            addCriterion("dic_name not like", value, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameIn(List<String> values) {
            addCriterion("dic_name in", values, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameNotIn(List<String> values) {
            addCriterion("dic_name not in", values, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameBetween(String value1, String value2) {
            addCriterion("dic_name between", value1, value2, "dicName");
            return (Criteria) this;
        }

        public Criteria andDicNameNotBetween(String value1, String value2) {
            addCriterion("dic_name not between", value1, value2, "dicName");
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

        public Criteria andCreateEmpNameIsNull() {
            addCriterion("create_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameIsNotNull() {
            addCriterion("create_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameEqualTo(String value) {
            addCriterion("create_emp_name =", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameNotEqualTo(String value) {
            addCriterion("create_emp_name <>", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameGreaterThan(String value) {
            addCriterion("create_emp_name >", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_emp_name >=", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameLessThan(String value) {
            addCriterion("create_emp_name <", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameLessThanOrEqualTo(String value) {
            addCriterion("create_emp_name <=", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameLike(String value) {
            addCriterion("create_emp_name like", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameNotLike(String value) {
            addCriterion("create_emp_name not like", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameIn(List<String> values) {
            addCriterion("create_emp_name in", values, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameNotIn(List<String> values) {
            addCriterion("create_emp_name not in", values, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameBetween(String value1, String value2) {
            addCriterion("create_emp_name between", value1, value2, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameNotBetween(String value1, String value2) {
            addCriterion("create_emp_name not between", value1, value2, "createEmpName");
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

        public Criteria andUpdateEmpNameIsNull() {
            addCriterion("update_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameIsNotNull() {
            addCriterion("update_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameEqualTo(String value) {
            addCriterion("update_emp_name =", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotEqualTo(String value) {
            addCriterion("update_emp_name <>", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameGreaterThan(String value) {
            addCriterion("update_emp_name >", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_emp_name >=", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLessThan(String value) {
            addCriterion("update_emp_name <", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLessThanOrEqualTo(String value) {
            addCriterion("update_emp_name <=", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLike(String value) {
            addCriterion("update_emp_name like", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotLike(String value) {
            addCriterion("update_emp_name not like", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameIn(List<String> values) {
            addCriterion("update_emp_name in", values, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotIn(List<String> values) {
            addCriterion("update_emp_name not in", values, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameBetween(String value1, String value2) {
            addCriterion("update_emp_name between", value1, value2, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotBetween(String value1, String value2) {
            addCriterion("update_emp_name not between", value1, value2, "updateEmpName");
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
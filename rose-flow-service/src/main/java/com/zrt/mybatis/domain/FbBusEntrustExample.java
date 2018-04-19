package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusEntrustExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusEntrustExample() {
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

        public Criteria andEntEmpIdIsNull() {
            addCriterion("ent_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdIsNotNull() {
            addCriterion("ent_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdEqualTo(String value) {
            addCriterion("ent_emp_id =", value, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdNotEqualTo(String value) {
            addCriterion("ent_emp_id <>", value, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdGreaterThan(String value) {
            addCriterion("ent_emp_id >", value, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("ent_emp_id >=", value, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdLessThan(String value) {
            addCriterion("ent_emp_id <", value, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdLessThanOrEqualTo(String value) {
            addCriterion("ent_emp_id <=", value, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdLike(String value) {
            addCriterion("ent_emp_id like", value, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdNotLike(String value) {
            addCriterion("ent_emp_id not like", value, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdIn(List<String> values) {
            addCriterion("ent_emp_id in", values, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdNotIn(List<String> values) {
            addCriterion("ent_emp_id not in", values, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdBetween(String value1, String value2) {
            addCriterion("ent_emp_id between", value1, value2, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpIdNotBetween(String value1, String value2) {
            addCriterion("ent_emp_id not between", value1, value2, "entEmpId");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameIsNull() {
            addCriterion("ent_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameIsNotNull() {
            addCriterion("ent_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameEqualTo(String value) {
            addCriterion("ent_emp_name =", value, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameNotEqualTo(String value) {
            addCriterion("ent_emp_name <>", value, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameGreaterThan(String value) {
            addCriterion("ent_emp_name >", value, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("ent_emp_name >=", value, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameLessThan(String value) {
            addCriterion("ent_emp_name <", value, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameLessThanOrEqualTo(String value) {
            addCriterion("ent_emp_name <=", value, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameLike(String value) {
            addCriterion("ent_emp_name like", value, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameNotLike(String value) {
            addCriterion("ent_emp_name not like", value, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameIn(List<String> values) {
            addCriterion("ent_emp_name in", values, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameNotIn(List<String> values) {
            addCriterion("ent_emp_name not in", values, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameBetween(String value1, String value2) {
            addCriterion("ent_emp_name between", value1, value2, "entEmpName");
            return (Criteria) this;
        }

        public Criteria andEntEmpNameNotBetween(String value1, String value2) {
            addCriterion("ent_emp_name not between", value1, value2, "entEmpName");
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

        public Criteria andEntEnabledIsNull() {
            addCriterion("ent_enabled is null");
            return (Criteria) this;
        }

        public Criteria andEntEnabledIsNotNull() {
            addCriterion("ent_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEntEnabledEqualTo(String value) {
            addCriterion("ent_enabled =", value, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledNotEqualTo(String value) {
            addCriterion("ent_enabled <>", value, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledGreaterThan(String value) {
            addCriterion("ent_enabled >", value, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("ent_enabled >=", value, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledLessThan(String value) {
            addCriterion("ent_enabled <", value, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledLessThanOrEqualTo(String value) {
            addCriterion("ent_enabled <=", value, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledLike(String value) {
            addCriterion("ent_enabled like", value, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledNotLike(String value) {
            addCriterion("ent_enabled not like", value, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledIn(List<String> values) {
            addCriterion("ent_enabled in", values, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledNotIn(List<String> values) {
            addCriterion("ent_enabled not in", values, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledBetween(String value1, String value2) {
            addCriterion("ent_enabled between", value1, value2, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andEntEnabledNotBetween(String value1, String value2) {
            addCriterion("ent_enabled not between", value1, value2, "entEnabled");
            return (Criteria) this;
        }

        public Criteria andFbCodeIsNull() {
            addCriterion("fb_code is null");
            return (Criteria) this;
        }

        public Criteria andFbCodeIsNotNull() {
            addCriterion("fb_code is not null");
            return (Criteria) this;
        }

        public Criteria andFbCodeEqualTo(String value) {
            addCriterion("fb_code =", value, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeNotEqualTo(String value) {
            addCriterion("fb_code <>", value, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeGreaterThan(String value) {
            addCriterion("fb_code >", value, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fb_code >=", value, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeLessThan(String value) {
            addCriterion("fb_code <", value, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeLessThanOrEqualTo(String value) {
            addCriterion("fb_code <=", value, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeLike(String value) {
            addCriterion("fb_code like", value, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeNotLike(String value) {
            addCriterion("fb_code not like", value, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeIn(List<String> values) {
            addCriterion("fb_code in", values, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeNotIn(List<String> values) {
            addCriterion("fb_code not in", values, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeBetween(String value1, String value2) {
            addCriterion("fb_code between", value1, value2, "fbCode");
            return (Criteria) this;
        }

        public Criteria andFbCodeNotBetween(String value1, String value2) {
            addCriterion("fb_code not between", value1, value2, "fbCode");
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
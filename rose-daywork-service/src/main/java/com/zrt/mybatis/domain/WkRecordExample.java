package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class WkRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WkRecordExample() {
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

        public Criteria andWkNameIsNull() {
            addCriterion("wk_name is null");
            return (Criteria) this;
        }

        public Criteria andWkNameIsNotNull() {
            addCriterion("wk_name is not null");
            return (Criteria) this;
        }

        public Criteria andWkNameEqualTo(String value) {
            addCriterion("wk_name =", value, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameNotEqualTo(String value) {
            addCriterion("wk_name <>", value, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameGreaterThan(String value) {
            addCriterion("wk_name >", value, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameGreaterThanOrEqualTo(String value) {
            addCriterion("wk_name >=", value, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameLessThan(String value) {
            addCriterion("wk_name <", value, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameLessThanOrEqualTo(String value) {
            addCriterion("wk_name <=", value, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameLike(String value) {
            addCriterion("wk_name like", value, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameNotLike(String value) {
            addCriterion("wk_name not like", value, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameIn(List<String> values) {
            addCriterion("wk_name in", values, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameNotIn(List<String> values) {
            addCriterion("wk_name not in", values, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameBetween(String value1, String value2) {
            addCriterion("wk_name between", value1, value2, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkNameNotBetween(String value1, String value2) {
            addCriterion("wk_name not between", value1, value2, "wkName");
            return (Criteria) this;
        }

        public Criteria andWkDescIsNull() {
            addCriterion("wk_desc is null");
            return (Criteria) this;
        }

        public Criteria andWkDescIsNotNull() {
            addCriterion("wk_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWkDescEqualTo(String value) {
            addCriterion("wk_desc =", value, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescNotEqualTo(String value) {
            addCriterion("wk_desc <>", value, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescGreaterThan(String value) {
            addCriterion("wk_desc >", value, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescGreaterThanOrEqualTo(String value) {
            addCriterion("wk_desc >=", value, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescLessThan(String value) {
            addCriterion("wk_desc <", value, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescLessThanOrEqualTo(String value) {
            addCriterion("wk_desc <=", value, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescLike(String value) {
            addCriterion("wk_desc like", value, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescNotLike(String value) {
            addCriterion("wk_desc not like", value, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescIn(List<String> values) {
            addCriterion("wk_desc in", values, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescNotIn(List<String> values) {
            addCriterion("wk_desc not in", values, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescBetween(String value1, String value2) {
            addCriterion("wk_desc between", value1, value2, "wkDesc");
            return (Criteria) this;
        }

        public Criteria andWkDescNotBetween(String value1, String value2) {
            addCriterion("wk_desc not between", value1, value2, "wkDesc");
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

        public Criteria andRelTypeIsNull() {
            addCriterion("rel_type is null");
            return (Criteria) this;
        }

        public Criteria andRelTypeIsNotNull() {
            addCriterion("rel_type is not null");
            return (Criteria) this;
        }

        public Criteria andRelTypeEqualTo(String value) {
            addCriterion("rel_type =", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotEqualTo(String value) {
            addCriterion("rel_type <>", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeGreaterThan(String value) {
            addCriterion("rel_type >", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rel_type >=", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLessThan(String value) {
            addCriterion("rel_type <", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLessThanOrEqualTo(String value) {
            addCriterion("rel_type <=", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeLike(String value) {
            addCriterion("rel_type like", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotLike(String value) {
            addCriterion("rel_type not like", value, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeIn(List<String> values) {
            addCriterion("rel_type in", values, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotIn(List<String> values) {
            addCriterion("rel_type not in", values, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeBetween(String value1, String value2) {
            addCriterion("rel_type between", value1, value2, "relType");
            return (Criteria) this;
        }

        public Criteria andRelTypeNotBetween(String value1, String value2) {
            addCriterion("rel_type not between", value1, value2, "relType");
            return (Criteria) this;
        }

        public Criteria andRelCodeIsNull() {
            addCriterion("rel_code is null");
            return (Criteria) this;
        }

        public Criteria andRelCodeIsNotNull() {
            addCriterion("rel_code is not null");
            return (Criteria) this;
        }

        public Criteria andRelCodeEqualTo(String value) {
            addCriterion("rel_code =", value, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeNotEqualTo(String value) {
            addCriterion("rel_code <>", value, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeGreaterThan(String value) {
            addCriterion("rel_code >", value, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rel_code >=", value, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeLessThan(String value) {
            addCriterion("rel_code <", value, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeLessThanOrEqualTo(String value) {
            addCriterion("rel_code <=", value, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeLike(String value) {
            addCriterion("rel_code like", value, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeNotLike(String value) {
            addCriterion("rel_code not like", value, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeIn(List<String> values) {
            addCriterion("rel_code in", values, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeNotIn(List<String> values) {
            addCriterion("rel_code not in", values, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeBetween(String value1, String value2) {
            addCriterion("rel_code between", value1, value2, "relCode");
            return (Criteria) this;
        }

        public Criteria andRelCodeNotBetween(String value1, String value2) {
            addCriterion("rel_code not between", value1, value2, "relCode");
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
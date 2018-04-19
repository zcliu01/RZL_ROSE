package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusInstNotifyEmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusInstNotifyEmpExample() {
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

        public Criteria andNotifyEmpIdIsNull() {
            addCriterion("notify_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdIsNotNull() {
            addCriterion("notify_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdEqualTo(String value) {
            addCriterion("notify_emp_id =", value, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdNotEqualTo(String value) {
            addCriterion("notify_emp_id <>", value, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdGreaterThan(String value) {
            addCriterion("notify_emp_id >", value, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("notify_emp_id >=", value, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdLessThan(String value) {
            addCriterion("notify_emp_id <", value, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdLessThanOrEqualTo(String value) {
            addCriterion("notify_emp_id <=", value, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdLike(String value) {
            addCriterion("notify_emp_id like", value, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdNotLike(String value) {
            addCriterion("notify_emp_id not like", value, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdIn(List<String> values) {
            addCriterion("notify_emp_id in", values, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdNotIn(List<String> values) {
            addCriterion("notify_emp_id not in", values, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdBetween(String value1, String value2) {
            addCriterion("notify_emp_id between", value1, value2, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpIdNotBetween(String value1, String value2) {
            addCriterion("notify_emp_id not between", value1, value2, "notifyEmpId");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameIsNull() {
            addCriterion("notify_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameIsNotNull() {
            addCriterion("notify_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameEqualTo(String value) {
            addCriterion("notify_emp_name =", value, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameNotEqualTo(String value) {
            addCriterion("notify_emp_name <>", value, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameGreaterThan(String value) {
            addCriterion("notify_emp_name >", value, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("notify_emp_name >=", value, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameLessThan(String value) {
            addCriterion("notify_emp_name <", value, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameLessThanOrEqualTo(String value) {
            addCriterion("notify_emp_name <=", value, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameLike(String value) {
            addCriterion("notify_emp_name like", value, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameNotLike(String value) {
            addCriterion("notify_emp_name not like", value, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameIn(List<String> values) {
            addCriterion("notify_emp_name in", values, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameNotIn(List<String> values) {
            addCriterion("notify_emp_name not in", values, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameBetween(String value1, String value2) {
            addCriterion("notify_emp_name between", value1, value2, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyEmpNameNotBetween(String value1, String value2) {
            addCriterion("notify_emp_name not between", value1, value2, "notifyEmpName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdIsNull() {
            addCriterion("notify_org_id is null");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdIsNotNull() {
            addCriterion("notify_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdEqualTo(String value) {
            addCriterion("notify_org_id =", value, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdNotEqualTo(String value) {
            addCriterion("notify_org_id <>", value, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdGreaterThan(String value) {
            addCriterion("notify_org_id >", value, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("notify_org_id >=", value, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdLessThan(String value) {
            addCriterion("notify_org_id <", value, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdLessThanOrEqualTo(String value) {
            addCriterion("notify_org_id <=", value, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdLike(String value) {
            addCriterion("notify_org_id like", value, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdNotLike(String value) {
            addCriterion("notify_org_id not like", value, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdIn(List<String> values) {
            addCriterion("notify_org_id in", values, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdNotIn(List<String> values) {
            addCriterion("notify_org_id not in", values, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdBetween(String value1, String value2) {
            addCriterion("notify_org_id between", value1, value2, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgIdNotBetween(String value1, String value2) {
            addCriterion("notify_org_id not between", value1, value2, "notifyOrgId");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameIsNull() {
            addCriterion("notify_org_name is null");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameIsNotNull() {
            addCriterion("notify_org_name is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameEqualTo(String value) {
            addCriterion("notify_org_name =", value, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameNotEqualTo(String value) {
            addCriterion("notify_org_name <>", value, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameGreaterThan(String value) {
            addCriterion("notify_org_name >", value, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("notify_org_name >=", value, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameLessThan(String value) {
            addCriterion("notify_org_name <", value, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameLessThanOrEqualTo(String value) {
            addCriterion("notify_org_name <=", value, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameLike(String value) {
            addCriterion("notify_org_name like", value, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameNotLike(String value) {
            addCriterion("notify_org_name not like", value, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameIn(List<String> values) {
            addCriterion("notify_org_name in", values, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameNotIn(List<String> values) {
            addCriterion("notify_org_name not in", values, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameBetween(String value1, String value2) {
            addCriterion("notify_org_name between", value1, value2, "notifyOrgName");
            return (Criteria) this;
        }

        public Criteria andNotifyOrgNameNotBetween(String value1, String value2) {
            addCriterion("notify_org_name not between", value1, value2, "notifyOrgName");
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

        public Criteria andNotifyIdIsNull() {
            addCriterion("notify_id is null");
            return (Criteria) this;
        }

        public Criteria andNotifyIdIsNotNull() {
            addCriterion("notify_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyIdEqualTo(String value) {
            addCriterion("notify_id =", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotEqualTo(String value) {
            addCriterion("notify_id <>", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdGreaterThan(String value) {
            addCriterion("notify_id >", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdGreaterThanOrEqualTo(String value) {
            addCriterion("notify_id >=", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdLessThan(String value) {
            addCriterion("notify_id <", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdLessThanOrEqualTo(String value) {
            addCriterion("notify_id <=", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdLike(String value) {
            addCriterion("notify_id like", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotLike(String value) {
            addCriterion("notify_id not like", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdIn(List<String> values) {
            addCriterion("notify_id in", values, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotIn(List<String> values) {
            addCriterion("notify_id not in", values, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdBetween(String value1, String value2) {
            addCriterion("notify_id between", value1, value2, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotBetween(String value1, String value2) {
            addCriterion("notify_id not between", value1, value2, "notifyId");
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
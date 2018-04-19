package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class BumphTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BumphTypeExample() {
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

        public Criteria andBumphTypeCodeIsNull() {
            addCriterion("bumph_type_code is null");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeIsNotNull() {
            addCriterion("bumph_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeEqualTo(String value) {
            addCriterion("bumph_type_code =", value, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeNotEqualTo(String value) {
            addCriterion("bumph_type_code <>", value, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeGreaterThan(String value) {
            addCriterion("bumph_type_code >", value, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bumph_type_code >=", value, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeLessThan(String value) {
            addCriterion("bumph_type_code <", value, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("bumph_type_code <=", value, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeLike(String value) {
            addCriterion("bumph_type_code like", value, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeNotLike(String value) {
            addCriterion("bumph_type_code not like", value, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeIn(List<String> values) {
            addCriterion("bumph_type_code in", values, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeNotIn(List<String> values) {
            addCriterion("bumph_type_code not in", values, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeBetween(String value1, String value2) {
            addCriterion("bumph_type_code between", value1, value2, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCodeNotBetween(String value1, String value2) {
            addCriterion("bumph_type_code not between", value1, value2, "bumphTypeCode");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameIsNull() {
            addCriterion("bumph_type_name is null");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameIsNotNull() {
            addCriterion("bumph_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameEqualTo(String value) {
            addCriterion("bumph_type_name =", value, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameNotEqualTo(String value) {
            addCriterion("bumph_type_name <>", value, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameGreaterThan(String value) {
            addCriterion("bumph_type_name >", value, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("bumph_type_name >=", value, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameLessThan(String value) {
            addCriterion("bumph_type_name <", value, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameLessThanOrEqualTo(String value) {
            addCriterion("bumph_type_name <=", value, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameLike(String value) {
            addCriterion("bumph_type_name like", value, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameNotLike(String value) {
            addCriterion("bumph_type_name not like", value, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameIn(List<String> values) {
            addCriterion("bumph_type_name in", values, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameNotIn(List<String> values) {
            addCriterion("bumph_type_name not in", values, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameBetween(String value1, String value2) {
            addCriterion("bumph_type_name between", value1, value2, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeNameNotBetween(String value1, String value2) {
            addCriterion("bumph_type_name not between", value1, value2, "bumphTypeName");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateIsNull() {
            addCriterion("bumph_type_state is null");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateIsNotNull() {
            addCriterion("bumph_type_state is not null");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateEqualTo(String value) {
            addCriterion("bumph_type_state =", value, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateNotEqualTo(String value) {
            addCriterion("bumph_type_state <>", value, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateGreaterThan(String value) {
            addCriterion("bumph_type_state >", value, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateGreaterThanOrEqualTo(String value) {
            addCriterion("bumph_type_state >=", value, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateLessThan(String value) {
            addCriterion("bumph_type_state <", value, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateLessThanOrEqualTo(String value) {
            addCriterion("bumph_type_state <=", value, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateLike(String value) {
            addCriterion("bumph_type_state like", value, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateNotLike(String value) {
            addCriterion("bumph_type_state not like", value, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateIn(List<String> values) {
            addCriterion("bumph_type_state in", values, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateNotIn(List<String> values) {
            addCriterion("bumph_type_state not in", values, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateBetween(String value1, String value2) {
            addCriterion("bumph_type_state between", value1, value2, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeStateNotBetween(String value1, String value2) {
            addCriterion("bumph_type_state not between", value1, value2, "bumphTypeState");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataIsNull() {
            addCriterion("bumph_type_createData is null");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataIsNotNull() {
            addCriterion("bumph_type_createData is not null");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataEqualTo(String value) {
            addCriterion("bumph_type_createData =", value, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataNotEqualTo(String value) {
            addCriterion("bumph_type_createData <>", value, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataGreaterThan(String value) {
            addCriterion("bumph_type_createData >", value, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataGreaterThanOrEqualTo(String value) {
            addCriterion("bumph_type_createData >=", value, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataLessThan(String value) {
            addCriterion("bumph_type_createData <", value, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataLessThanOrEqualTo(String value) {
            addCriterion("bumph_type_createData <=", value, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataLike(String value) {
            addCriterion("bumph_type_createData like", value, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataNotLike(String value) {
            addCriterion("bumph_type_createData not like", value, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataIn(List<String> values) {
            addCriterion("bumph_type_createData in", values, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataNotIn(List<String> values) {
            addCriterion("bumph_type_createData not in", values, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataBetween(String value1, String value2) {
            addCriterion("bumph_type_createData between", value1, value2, "bumphTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andBumphTypeCreatedataNotBetween(String value1, String value2) {
            addCriterion("bumph_type_createData not between", value1, value2, "bumphTypeCreatedata");
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
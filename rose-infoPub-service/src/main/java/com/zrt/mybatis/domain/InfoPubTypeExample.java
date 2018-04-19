package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class InfoPubTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoPubTypeExample() {
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

        public Criteria andInfoTypeCodeIsNull() {
            addCriterion("info_type_code is null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeIsNotNull() {
            addCriterion("info_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeEqualTo(String value) {
            addCriterion("info_type_code =", value, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeNotEqualTo(String value) {
            addCriterion("info_type_code <>", value, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeGreaterThan(String value) {
            addCriterion("info_type_code >", value, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("info_type_code >=", value, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeLessThan(String value) {
            addCriterion("info_type_code <", value, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("info_type_code <=", value, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeLike(String value) {
            addCriterion("info_type_code like", value, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeNotLike(String value) {
            addCriterion("info_type_code not like", value, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeIn(List<String> values) {
            addCriterion("info_type_code in", values, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeNotIn(List<String> values) {
            addCriterion("info_type_code not in", values, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeBetween(String value1, String value2) {
            addCriterion("info_type_code between", value1, value2, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCodeNotBetween(String value1, String value2) {
            addCriterion("info_type_code not between", value1, value2, "infoTypeCode");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameIsNull() {
            addCriterion("info_type_name is null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameIsNotNull() {
            addCriterion("info_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameEqualTo(String value) {
            addCriterion("info_type_name =", value, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameNotEqualTo(String value) {
            addCriterion("info_type_name <>", value, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameGreaterThan(String value) {
            addCriterion("info_type_name >", value, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("info_type_name >=", value, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameLessThan(String value) {
            addCriterion("info_type_name <", value, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameLessThanOrEqualTo(String value) {
            addCriterion("info_type_name <=", value, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameLike(String value) {
            addCriterion("info_type_name like", value, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameNotLike(String value) {
            addCriterion("info_type_name not like", value, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameIn(List<String> values) {
            addCriterion("info_type_name in", values, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameNotIn(List<String> values) {
            addCriterion("info_type_name not in", values, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameBetween(String value1, String value2) {
            addCriterion("info_type_name between", value1, value2, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNameNotBetween(String value1, String value2) {
            addCriterion("info_type_name not between", value1, value2, "infoTypeName");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateIsNull() {
            addCriterion("info_type_state is null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateIsNotNull() {
            addCriterion("info_type_state is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateEqualTo(String value) {
            addCriterion("info_type_state =", value, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateNotEqualTo(String value) {
            addCriterion("info_type_state <>", value, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateGreaterThan(String value) {
            addCriterion("info_type_state >", value, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateGreaterThanOrEqualTo(String value) {
            addCriterion("info_type_state >=", value, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateLessThan(String value) {
            addCriterion("info_type_state <", value, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateLessThanOrEqualTo(String value) {
            addCriterion("info_type_state <=", value, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateLike(String value) {
            addCriterion("info_type_state like", value, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateNotLike(String value) {
            addCriterion("info_type_state not like", value, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateIn(List<String> values) {
            addCriterion("info_type_state in", values, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateNotIn(List<String> values) {
            addCriterion("info_type_state not in", values, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateBetween(String value1, String value2) {
            addCriterion("info_type_state between", value1, value2, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeStateNotBetween(String value1, String value2) {
            addCriterion("info_type_state not between", value1, value2, "infoTypeState");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataIsNull() {
            addCriterion("info_type_createData is null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataIsNotNull() {
            addCriterion("info_type_createData is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataEqualTo(String value) {
            addCriterion("info_type_createData =", value, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataNotEqualTo(String value) {
            addCriterion("info_type_createData <>", value, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataGreaterThan(String value) {
            addCriterion("info_type_createData >", value, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataGreaterThanOrEqualTo(String value) {
            addCriterion("info_type_createData >=", value, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataLessThan(String value) {
            addCriterion("info_type_createData <", value, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataLessThanOrEqualTo(String value) {
            addCriterion("info_type_createData <=", value, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataLike(String value) {
            addCriterion("info_type_createData like", value, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataNotLike(String value) {
            addCriterion("info_type_createData not like", value, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataIn(List<String> values) {
            addCriterion("info_type_createData in", values, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataNotIn(List<String> values) {
            addCriterion("info_type_createData not in", values, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataBetween(String value1, String value2) {
            addCriterion("info_type_createData between", value1, value2, "infoTypeCreatedata");
            return (Criteria) this;
        }

        public Criteria andInfoTypeCreatedataNotBetween(String value1, String value2) {
            addCriterion("info_type_createData not between", value1, value2, "infoTypeCreatedata");
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
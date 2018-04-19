package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class TprojectInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TprojectInfoExample() {
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

        public Criteria andCProjectcodeIsNull() {
            addCriterion("C_PROJECTCODE is null");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeIsNotNull() {
            addCriterion("C_PROJECTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeEqualTo(String value) {
            addCriterion("C_PROJECTCODE =", value, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeNotEqualTo(String value) {
            addCriterion("C_PROJECTCODE <>", value, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeGreaterThan(String value) {
            addCriterion("C_PROJECTCODE >", value, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_PROJECTCODE >=", value, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeLessThan(String value) {
            addCriterion("C_PROJECTCODE <", value, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeLessThanOrEqualTo(String value) {
            addCriterion("C_PROJECTCODE <=", value, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeLike(String value) {
            addCriterion("C_PROJECTCODE like", value, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeNotLike(String value) {
            addCriterion("C_PROJECTCODE not like", value, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeIn(List<String> values) {
            addCriterion("C_PROJECTCODE in", values, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeNotIn(List<String> values) {
            addCriterion("C_PROJECTCODE not in", values, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeBetween(String value1, String value2) {
            addCriterion("C_PROJECTCODE between", value1, value2, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectcodeNotBetween(String value1, String value2) {
            addCriterion("C_PROJECTCODE not between", value1, value2, "cProjectcode");
            return (Criteria) this;
        }

        public Criteria andCProjectnameIsNull() {
            addCriterion("C_PROJECTNAME is null");
            return (Criteria) this;
        }

        public Criteria andCProjectnameIsNotNull() {
            addCriterion("C_PROJECTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCProjectnameEqualTo(String value) {
            addCriterion("C_PROJECTNAME =", value, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameNotEqualTo(String value) {
            addCriterion("C_PROJECTNAME <>", value, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameGreaterThan(String value) {
            addCriterion("C_PROJECTNAME >", value, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("C_PROJECTNAME >=", value, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameLessThan(String value) {
            addCriterion("C_PROJECTNAME <", value, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameLessThanOrEqualTo(String value) {
            addCriterion("C_PROJECTNAME <=", value, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameLike(String value) {
            addCriterion("C_PROJECTNAME like", value, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameNotLike(String value) {
            addCriterion("C_PROJECTNAME not like", value, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameIn(List<String> values) {
            addCriterion("C_PROJECTNAME in", values, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameNotIn(List<String> values) {
            addCriterion("C_PROJECTNAME not in", values, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameBetween(String value1, String value2) {
            addCriterion("C_PROJECTNAME between", value1, value2, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCProjectnameNotBetween(String value1, String value2) {
            addCriterion("C_PROJECTNAME not between", value1, value2, "cProjectname");
            return (Criteria) this;
        }

        public Criteria andCFundcodeIsNull() {
            addCriterion("C_FUNDCODE is null");
            return (Criteria) this;
        }

        public Criteria andCFundcodeIsNotNull() {
            addCriterion("C_FUNDCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCFundcodeEqualTo(String value) {
            addCriterion("C_FUNDCODE =", value, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeNotEqualTo(String value) {
            addCriterion("C_FUNDCODE <>", value, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeGreaterThan(String value) {
            addCriterion("C_FUNDCODE >", value, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeGreaterThanOrEqualTo(String value) {
            addCriterion("C_FUNDCODE >=", value, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeLessThan(String value) {
            addCriterion("C_FUNDCODE <", value, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeLessThanOrEqualTo(String value) {
            addCriterion("C_FUNDCODE <=", value, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeLike(String value) {
            addCriterion("C_FUNDCODE like", value, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeNotLike(String value) {
            addCriterion("C_FUNDCODE not like", value, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeIn(List<String> values) {
            addCriterion("C_FUNDCODE in", values, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeNotIn(List<String> values) {
            addCriterion("C_FUNDCODE not in", values, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeBetween(String value1, String value2) {
            addCriterion("C_FUNDCODE between", value1, value2, "cFundcode");
            return (Criteria) this;
        }

        public Criteria andCFundcodeNotBetween(String value1, String value2) {
            addCriterion("C_FUNDCODE not between", value1, value2, "cFundcode");
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
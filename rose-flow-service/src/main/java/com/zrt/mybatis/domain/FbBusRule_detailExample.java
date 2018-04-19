package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusRule_detailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusRule_detailExample() {
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

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(String value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(String value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(String value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(String value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(String value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLike(String value) {
            addCriterion("rule_id like", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotLike(String value) {
            addCriterion("rule_id not like", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<String> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<String> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(String value1, String value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(String value1, String value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andColCodeIsNull() {
            addCriterion("col_code is null");
            return (Criteria) this;
        }

        public Criteria andColCodeIsNotNull() {
            addCriterion("col_code is not null");
            return (Criteria) this;
        }

        public Criteria andColCodeEqualTo(String value) {
            addCriterion("col_code =", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeNotEqualTo(String value) {
            addCriterion("col_code <>", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeGreaterThan(String value) {
            addCriterion("col_code >", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeGreaterThanOrEqualTo(String value) {
            addCriterion("col_code >=", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeLessThan(String value) {
            addCriterion("col_code <", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeLessThanOrEqualTo(String value) {
            addCriterion("col_code <=", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeLike(String value) {
            addCriterion("col_code like", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeNotLike(String value) {
            addCriterion("col_code not like", value, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeIn(List<String> values) {
            addCriterion("col_code in", values, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeNotIn(List<String> values) {
            addCriterion("col_code not in", values, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeBetween(String value1, String value2) {
            addCriterion("col_code between", value1, value2, "colCode");
            return (Criteria) this;
        }

        public Criteria andColCodeNotBetween(String value1, String value2) {
            addCriterion("col_code not between", value1, value2, "colCode");
            return (Criteria) this;
        }

        public Criteria andColFlagIsNull() {
            addCriterion("col_flag is null");
            return (Criteria) this;
        }

        public Criteria andColFlagIsNotNull() {
            addCriterion("col_flag is not null");
            return (Criteria) this;
        }

        public Criteria andColFlagEqualTo(String value) {
            addCriterion("col_flag =", value, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagNotEqualTo(String value) {
            addCriterion("col_flag <>", value, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagGreaterThan(String value) {
            addCriterion("col_flag >", value, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagGreaterThanOrEqualTo(String value) {
            addCriterion("col_flag >=", value, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagLessThan(String value) {
            addCriterion("col_flag <", value, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagLessThanOrEqualTo(String value) {
            addCriterion("col_flag <=", value, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagLike(String value) {
            addCriterion("col_flag like", value, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagNotLike(String value) {
            addCriterion("col_flag not like", value, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagIn(List<String> values) {
            addCriterion("col_flag in", values, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagNotIn(List<String> values) {
            addCriterion("col_flag not in", values, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagBetween(String value1, String value2) {
            addCriterion("col_flag between", value1, value2, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColFlagNotBetween(String value1, String value2) {
            addCriterion("col_flag not between", value1, value2, "colFlag");
            return (Criteria) this;
        }

        public Criteria andColValueIsNull() {
            addCriterion("col_value is null");
            return (Criteria) this;
        }

        public Criteria andColValueIsNotNull() {
            addCriterion("col_value is not null");
            return (Criteria) this;
        }

        public Criteria andColValueEqualTo(String value) {
            addCriterion("col_value =", value, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueNotEqualTo(String value) {
            addCriterion("col_value <>", value, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueGreaterThan(String value) {
            addCriterion("col_value >", value, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueGreaterThanOrEqualTo(String value) {
            addCriterion("col_value >=", value, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueLessThan(String value) {
            addCriterion("col_value <", value, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueLessThanOrEqualTo(String value) {
            addCriterion("col_value <=", value, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueLike(String value) {
            addCriterion("col_value like", value, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueNotLike(String value) {
            addCriterion("col_value not like", value, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueIn(List<String> values) {
            addCriterion("col_value in", values, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueNotIn(List<String> values) {
            addCriterion("col_value not in", values, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueBetween(String value1, String value2) {
            addCriterion("col_value between", value1, value2, "colValue");
            return (Criteria) this;
        }

        public Criteria andColValueNotBetween(String value1, String value2) {
            addCriterion("col_value not between", value1, value2, "colValue");
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
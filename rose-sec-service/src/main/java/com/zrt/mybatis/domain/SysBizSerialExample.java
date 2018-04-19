package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SysBizSerialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysBizSerialExample() {
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

        public Criteria andBizKeyIsNull() {
            addCriterion("biz_key is null");
            return (Criteria) this;
        }

        public Criteria andBizKeyIsNotNull() {
            addCriterion("biz_key is not null");
            return (Criteria) this;
        }

        public Criteria andBizKeyEqualTo(String value) {
            addCriterion("biz_key =", value, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyNotEqualTo(String value) {
            addCriterion("biz_key <>", value, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyGreaterThan(String value) {
            addCriterion("biz_key >", value, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyGreaterThanOrEqualTo(String value) {
            addCriterion("biz_key >=", value, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyLessThan(String value) {
            addCriterion("biz_key <", value, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyLessThanOrEqualTo(String value) {
            addCriterion("biz_key <=", value, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyLike(String value) {
            addCriterion("biz_key like", value, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyNotLike(String value) {
            addCriterion("biz_key not like", value, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyIn(List<String> values) {
            addCriterion("biz_key in", values, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyNotIn(List<String> values) {
            addCriterion("biz_key not in", values, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyBetween(String value1, String value2) {
            addCriterion("biz_key between", value1, value2, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizKeyNotBetween(String value1, String value2) {
            addCriterion("biz_key not between", value1, value2, "bizKey");
            return (Criteria) this;
        }

        public Criteria andBizNameIsNull() {
            addCriterion("biz_name is null");
            return (Criteria) this;
        }

        public Criteria andBizNameIsNotNull() {
            addCriterion("biz_name is not null");
            return (Criteria) this;
        }

        public Criteria andBizNameEqualTo(String value) {
            addCriterion("biz_name =", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameNotEqualTo(String value) {
            addCriterion("biz_name <>", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameGreaterThan(String value) {
            addCriterion("biz_name >", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameGreaterThanOrEqualTo(String value) {
            addCriterion("biz_name >=", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameLessThan(String value) {
            addCriterion("biz_name <", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameLessThanOrEqualTo(String value) {
            addCriterion("biz_name <=", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameLike(String value) {
            addCriterion("biz_name like", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameNotLike(String value) {
            addCriterion("biz_name not like", value, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameIn(List<String> values) {
            addCriterion("biz_name in", values, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameNotIn(List<String> values) {
            addCriterion("biz_name not in", values, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameBetween(String value1, String value2) {
            addCriterion("biz_name between", value1, value2, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizNameNotBetween(String value1, String value2) {
            addCriterion("biz_name not between", value1, value2, "bizName");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoIsNull() {
            addCriterion("biz_serial_no is null");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoIsNotNull() {
            addCriterion("biz_serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoEqualTo(Integer value) {
            addCriterion("biz_serial_no =", value, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoNotEqualTo(Integer value) {
            addCriterion("biz_serial_no <>", value, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoGreaterThan(Integer value) {
            addCriterion("biz_serial_no >", value, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("biz_serial_no >=", value, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoLessThan(Integer value) {
            addCriterion("biz_serial_no <", value, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoLessThanOrEqualTo(Integer value) {
            addCriterion("biz_serial_no <=", value, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoIn(List<Integer> values) {
            addCriterion("biz_serial_no in", values, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoNotIn(List<Integer> values) {
            addCriterion("biz_serial_no not in", values, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoBetween(Integer value1, Integer value2) {
            addCriterion("biz_serial_no between", value1, value2, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizSerialNoNotBetween(Integer value1, Integer value2) {
            addCriterion("biz_serial_no not between", value1, value2, "bizSerialNo");
            return (Criteria) this;
        }

        public Criteria andBizPrefixIsNull() {
            addCriterion("biz_prefix is null");
            return (Criteria) this;
        }

        public Criteria andBizPrefixIsNotNull() {
            addCriterion("biz_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andBizPrefixEqualTo(String value) {
            addCriterion("biz_prefix =", value, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixNotEqualTo(String value) {
            addCriterion("biz_prefix <>", value, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixGreaterThan(String value) {
            addCriterion("biz_prefix >", value, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("biz_prefix >=", value, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixLessThan(String value) {
            addCriterion("biz_prefix <", value, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixLessThanOrEqualTo(String value) {
            addCriterion("biz_prefix <=", value, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixLike(String value) {
            addCriterion("biz_prefix like", value, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixNotLike(String value) {
            addCriterion("biz_prefix not like", value, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixIn(List<String> values) {
            addCriterion("biz_prefix in", values, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixNotIn(List<String> values) {
            addCriterion("biz_prefix not in", values, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixBetween(String value1, String value2) {
            addCriterion("biz_prefix between", value1, value2, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizPrefixNotBetween(String value1, String value2) {
            addCriterion("biz_prefix not between", value1, value2, "bizPrefix");
            return (Criteria) this;
        }

        public Criteria andBizDateIsNull() {
            addCriterion("biz_date is null");
            return (Criteria) this;
        }

        public Criteria andBizDateIsNotNull() {
            addCriterion("biz_date is not null");
            return (Criteria) this;
        }

        public Criteria andBizDateEqualTo(String value) {
            addCriterion("biz_date =", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateNotEqualTo(String value) {
            addCriterion("biz_date <>", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateGreaterThan(String value) {
            addCriterion("biz_date >", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateGreaterThanOrEqualTo(String value) {
            addCriterion("biz_date >=", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateLessThan(String value) {
            addCriterion("biz_date <", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateLessThanOrEqualTo(String value) {
            addCriterion("biz_date <=", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateLike(String value) {
            addCriterion("biz_date like", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateNotLike(String value) {
            addCriterion("biz_date not like", value, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateIn(List<String> values) {
            addCriterion("biz_date in", values, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateNotIn(List<String> values) {
            addCriterion("biz_date not in", values, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateBetween(String value1, String value2) {
            addCriterion("biz_date between", value1, value2, "bizDate");
            return (Criteria) this;
        }

        public Criteria andBizDateNotBetween(String value1, String value2) {
            addCriterion("biz_date not between", value1, value2, "bizDate");
            return (Criteria) this;
        }

        public Criteria andIsAppendIsNull() {
            addCriterion("is_append is null");
            return (Criteria) this;
        }

        public Criteria andIsAppendIsNotNull() {
            addCriterion("is_append is not null");
            return (Criteria) this;
        }

        public Criteria andIsAppendEqualTo(String value) {
            addCriterion("is_append =", value, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendNotEqualTo(String value) {
            addCriterion("is_append <>", value, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendGreaterThan(String value) {
            addCriterion("is_append >", value, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendGreaterThanOrEqualTo(String value) {
            addCriterion("is_append >=", value, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendLessThan(String value) {
            addCriterion("is_append <", value, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendLessThanOrEqualTo(String value) {
            addCriterion("is_append <=", value, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendLike(String value) {
            addCriterion("is_append like", value, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendNotLike(String value) {
            addCriterion("is_append not like", value, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendIn(List<String> values) {
            addCriterion("is_append in", values, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendNotIn(List<String> values) {
            addCriterion("is_append not in", values, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendBetween(String value1, String value2) {
            addCriterion("is_append between", value1, value2, "isAppend");
            return (Criteria) this;
        }

        public Criteria andIsAppendNotBetween(String value1, String value2) {
            addCriterion("is_append not between", value1, value2, "isAppend");
            return (Criteria) this;
        }

        public Criteria andSerialNumIsNull() {
            addCriterion("serial_num is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumIsNotNull() {
            addCriterion("serial_num is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumEqualTo(Integer value) {
            addCriterion("serial_num =", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotEqualTo(Integer value) {
            addCriterion("serial_num <>", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumGreaterThan(Integer value) {
            addCriterion("serial_num >", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("serial_num >=", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumLessThan(Integer value) {
            addCriterion("serial_num <", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumLessThanOrEqualTo(Integer value) {
            addCriterion("serial_num <=", value, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumIn(List<Integer> values) {
            addCriterion("serial_num in", values, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotIn(List<Integer> values) {
            addCriterion("serial_num not in", values, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumBetween(Integer value1, Integer value2) {
            addCriterion("serial_num between", value1, value2, "serialNum");
            return (Criteria) this;
        }

        public Criteria andSerialNumNotBetween(Integer value1, Integer value2) {
            addCriterion("serial_num not between", value1, value2, "serialNum");
            return (Criteria) this;
        }

        public Criteria andBizRemarkIsNull() {
            addCriterion("biz_remark is null");
            return (Criteria) this;
        }

        public Criteria andBizRemarkIsNotNull() {
            addCriterion("biz_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBizRemarkEqualTo(String value) {
            addCriterion("biz_remark =", value, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkNotEqualTo(String value) {
            addCriterion("biz_remark <>", value, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkGreaterThan(String value) {
            addCriterion("biz_remark >", value, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("biz_remark >=", value, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkLessThan(String value) {
            addCriterion("biz_remark <", value, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkLessThanOrEqualTo(String value) {
            addCriterion("biz_remark <=", value, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkLike(String value) {
            addCriterion("biz_remark like", value, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkNotLike(String value) {
            addCriterion("biz_remark not like", value, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkIn(List<String> values) {
            addCriterion("biz_remark in", values, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkNotIn(List<String> values) {
            addCriterion("biz_remark not in", values, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkBetween(String value1, String value2) {
            addCriterion("biz_remark between", value1, value2, "bizRemark");
            return (Criteria) this;
        }

        public Criteria andBizRemarkNotBetween(String value1, String value2) {
            addCriterion("biz_remark not between", value1, value2, "bizRemark");
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
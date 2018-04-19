package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusDataExample() {
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

        public Criteria andColTextIsNull() {
            addCriterion("col_text is null");
            return (Criteria) this;
        }

        public Criteria andColTextIsNotNull() {
            addCriterion("col_text is not null");
            return (Criteria) this;
        }

        public Criteria andColTextEqualTo(String value) {
            addCriterion("col_text =", value, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextNotEqualTo(String value) {
            addCriterion("col_text <>", value, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextGreaterThan(String value) {
            addCriterion("col_text >", value, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextGreaterThanOrEqualTo(String value) {
            addCriterion("col_text >=", value, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextLessThan(String value) {
            addCriterion("col_text <", value, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextLessThanOrEqualTo(String value) {
            addCriterion("col_text <=", value, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextLike(String value) {
            addCriterion("col_text like", value, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextNotLike(String value) {
            addCriterion("col_text not like", value, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextIn(List<String> values) {
            addCriterion("col_text in", values, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextNotIn(List<String> values) {
            addCriterion("col_text not in", values, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextBetween(String value1, String value2) {
            addCriterion("col_text between", value1, value2, "colText");
            return (Criteria) this;
        }

        public Criteria andColTextNotBetween(String value1, String value2) {
            addCriterion("col_text not between", value1, value2, "colText");
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

        public Criteria andColTitleIsNull() {
            addCriterion("col_title is null");
            return (Criteria) this;
        }

        public Criteria andColTitleIsNotNull() {
            addCriterion("col_title is not null");
            return (Criteria) this;
        }

        public Criteria andColTitleEqualTo(String value) {
            addCriterion("col_title =", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleNotEqualTo(String value) {
            addCriterion("col_title <>", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleGreaterThan(String value) {
            addCriterion("col_title >", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleGreaterThanOrEqualTo(String value) {
            addCriterion("col_title >=", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleLessThan(String value) {
            addCriterion("col_title <", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleLessThanOrEqualTo(String value) {
            addCriterion("col_title <=", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleLike(String value) {
            addCriterion("col_title like", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleNotLike(String value) {
            addCriterion("col_title not like", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleIn(List<String> values) {
            addCriterion("col_title in", values, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleNotIn(List<String> values) {
            addCriterion("col_title not in", values, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleBetween(String value1, String value2) {
            addCriterion("col_title between", value1, value2, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleNotBetween(String value1, String value2) {
            addCriterion("col_title not between", value1, value2, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTypeIsNull() {
            addCriterion("col_type is null");
            return (Criteria) this;
        }

        public Criteria andColTypeIsNotNull() {
            addCriterion("col_type is not null");
            return (Criteria) this;
        }

        public Criteria andColTypeEqualTo(String value) {
            addCriterion("col_type =", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeNotEqualTo(String value) {
            addCriterion("col_type <>", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeGreaterThan(String value) {
            addCriterion("col_type >", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeGreaterThanOrEqualTo(String value) {
            addCriterion("col_type >=", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeLessThan(String value) {
            addCriterion("col_type <", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeLessThanOrEqualTo(String value) {
            addCriterion("col_type <=", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeLike(String value) {
            addCriterion("col_type like", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeNotLike(String value) {
            addCriterion("col_type not like", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeIn(List<String> values) {
            addCriterion("col_type in", values, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeNotIn(List<String> values) {
            addCriterion("col_type not in", values, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeBetween(String value1, String value2) {
            addCriterion("col_type between", value1, value2, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeNotBetween(String value1, String value2) {
            addCriterion("col_type not between", value1, value2, "colType");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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
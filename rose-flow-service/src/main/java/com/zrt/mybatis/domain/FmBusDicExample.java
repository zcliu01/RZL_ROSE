package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FmBusDicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FmBusDicExample() {
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

        public Criteria andColNameIsNull() {
            addCriterion("col_name is null");
            return (Criteria) this;
        }

        public Criteria andColNameIsNotNull() {
            addCriterion("col_name is not null");
            return (Criteria) this;
        }

        public Criteria andColNameEqualTo(String value) {
            addCriterion("col_name =", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotEqualTo(String value) {
            addCriterion("col_name <>", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameGreaterThan(String value) {
            addCriterion("col_name >", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameGreaterThanOrEqualTo(String value) {
            addCriterion("col_name >=", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLessThan(String value) {
            addCriterion("col_name <", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLessThanOrEqualTo(String value) {
            addCriterion("col_name <=", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameLike(String value) {
            addCriterion("col_name like", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotLike(String value) {
            addCriterion("col_name not like", value, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameIn(List<String> values) {
            addCriterion("col_name in", values, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotIn(List<String> values) {
            addCriterion("col_name not in", values, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameBetween(String value1, String value2) {
            addCriterion("col_name between", value1, value2, "colName");
            return (Criteria) this;
        }

        public Criteria andColNameNotBetween(String value1, String value2) {
            addCriterion("col_name not between", value1, value2, "colName");
            return (Criteria) this;
        }

        public Criteria andColEnabledIsNull() {
            addCriterion("col_enabled is null");
            return (Criteria) this;
        }

        public Criteria andColEnabledIsNotNull() {
            addCriterion("col_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andColEnabledEqualTo(String value) {
            addCriterion("col_enabled =", value, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledNotEqualTo(String value) {
            addCriterion("col_enabled <>", value, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledGreaterThan(String value) {
            addCriterion("col_enabled >", value, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("col_enabled >=", value, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledLessThan(String value) {
            addCriterion("col_enabled <", value, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledLessThanOrEqualTo(String value) {
            addCriterion("col_enabled <=", value, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledLike(String value) {
            addCriterion("col_enabled like", value, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledNotLike(String value) {
            addCriterion("col_enabled not like", value, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledIn(List<String> values) {
            addCriterion("col_enabled in", values, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledNotIn(List<String> values) {
            addCriterion("col_enabled not in", values, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledBetween(String value1, String value2) {
            addCriterion("col_enabled between", value1, value2, "colEnabled");
            return (Criteria) this;
        }

        public Criteria andColEnabledNotBetween(String value1, String value2) {
            addCriterion("col_enabled not between", value1, value2, "colEnabled");
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

        public Criteria andColGroupIsNull() {
            addCriterion("col_group is null");
            return (Criteria) this;
        }

        public Criteria andColGroupIsNotNull() {
            addCriterion("col_group is not null");
            return (Criteria) this;
        }

        public Criteria andColGroupEqualTo(String value) {
            addCriterion("col_group =", value, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupNotEqualTo(String value) {
            addCriterion("col_group <>", value, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupGreaterThan(String value) {
            addCriterion("col_group >", value, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupGreaterThanOrEqualTo(String value) {
            addCriterion("col_group >=", value, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupLessThan(String value) {
            addCriterion("col_group <", value, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupLessThanOrEqualTo(String value) {
            addCriterion("col_group <=", value, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupLike(String value) {
            addCriterion("col_group like", value, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupNotLike(String value) {
            addCriterion("col_group not like", value, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupIn(List<String> values) {
            addCriterion("col_group in", values, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupNotIn(List<String> values) {
            addCriterion("col_group not in", values, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupBetween(String value1, String value2) {
            addCriterion("col_group between", value1, value2, "colGroup");
            return (Criteria) this;
        }

        public Criteria andColGroupNotBetween(String value1, String value2) {
            addCriterion("col_group not between", value1, value2, "colGroup");
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

        public Criteria andCueValueIsNull() {
            addCriterion("cue_value is null");
            return (Criteria) this;
        }

        public Criteria andCueValueIsNotNull() {
            addCriterion("cue_value is not null");
            return (Criteria) this;
        }

        public Criteria andCueValueEqualTo(String value) {
            addCriterion("cue_value =", value, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueNotEqualTo(String value) {
            addCriterion("cue_value <>", value, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueGreaterThan(String value) {
            addCriterion("cue_value >", value, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueGreaterThanOrEqualTo(String value) {
            addCriterion("cue_value >=", value, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueLessThan(String value) {
            addCriterion("cue_value <", value, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueLessThanOrEqualTo(String value) {
            addCriterion("cue_value <=", value, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueLike(String value) {
            addCriterion("cue_value like", value, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueNotLike(String value) {
            addCriterion("cue_value not like", value, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueIn(List<String> values) {
            addCriterion("cue_value in", values, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueNotIn(List<String> values) {
            addCriterion("cue_value not in", values, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueBetween(String value1, String value2) {
            addCriterion("cue_value between", value1, value2, "cueValue");
            return (Criteria) this;
        }

        public Criteria andCueValueNotBetween(String value1, String value2) {
            addCriterion("cue_value not between", value1, value2, "cueValue");
            return (Criteria) this;
        }

        public Criteria andReqFlagIsNull() {
            addCriterion("req_flag is null");
            return (Criteria) this;
        }

        public Criteria andReqFlagIsNotNull() {
            addCriterion("req_flag is not null");
            return (Criteria) this;
        }

        public Criteria andReqFlagEqualTo(String value) {
            addCriterion("req_flag =", value, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagNotEqualTo(String value) {
            addCriterion("req_flag <>", value, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagGreaterThan(String value) {
            addCriterion("req_flag >", value, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagGreaterThanOrEqualTo(String value) {
            addCriterion("req_flag >=", value, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagLessThan(String value) {
            addCriterion("req_flag <", value, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagLessThanOrEqualTo(String value) {
            addCriterion("req_flag <=", value, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagLike(String value) {
            addCriterion("req_flag like", value, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagNotLike(String value) {
            addCriterion("req_flag not like", value, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagIn(List<String> values) {
            addCriterion("req_flag in", values, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagNotIn(List<String> values) {
            addCriterion("req_flag not in", values, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagBetween(String value1, String value2) {
            addCriterion("req_flag between", value1, value2, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andReqFlagNotBetween(String value1, String value2) {
            addCriterion("req_flag not between", value1, value2, "reqFlag");
            return (Criteria) this;
        }

        public Criteria andMaxLenIsNull() {
            addCriterion("max_len is null");
            return (Criteria) this;
        }

        public Criteria andMaxLenIsNotNull() {
            addCriterion("max_len is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLenEqualTo(Integer value) {
            addCriterion("max_len =", value, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenNotEqualTo(Integer value) {
            addCriterion("max_len <>", value, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenGreaterThan(Integer value) {
            addCriterion("max_len >", value, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_len >=", value, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenLessThan(Integer value) {
            addCriterion("max_len <", value, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenLessThanOrEqualTo(Integer value) {
            addCriterion("max_len <=", value, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenIn(List<Integer> values) {
            addCriterion("max_len in", values, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenNotIn(List<Integer> values) {
            addCriterion("max_len not in", values, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenBetween(Integer value1, Integer value2) {
            addCriterion("max_len between", value1, value2, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMaxLenNotBetween(Integer value1, Integer value2) {
            addCriterion("max_len not between", value1, value2, "maxLen");
            return (Criteria) this;
        }

        public Criteria andMinLenIsNull() {
            addCriterion("min_len is null");
            return (Criteria) this;
        }

        public Criteria andMinLenIsNotNull() {
            addCriterion("min_len is not null");
            return (Criteria) this;
        }

        public Criteria andMinLenEqualTo(Integer value) {
            addCriterion("min_len =", value, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenNotEqualTo(Integer value) {
            addCriterion("min_len <>", value, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenGreaterThan(Integer value) {
            addCriterion("min_len >", value, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_len >=", value, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenLessThan(Integer value) {
            addCriterion("min_len <", value, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenLessThanOrEqualTo(Integer value) {
            addCriterion("min_len <=", value, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenIn(List<Integer> values) {
            addCriterion("min_len in", values, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenNotIn(List<Integer> values) {
            addCriterion("min_len not in", values, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenBetween(Integer value1, Integer value2) {
            addCriterion("min_len between", value1, value2, "minLen");
            return (Criteria) this;
        }

        public Criteria andMinLenNotBetween(Integer value1, Integer value2) {
            addCriterion("min_len not between", value1, value2, "minLen");
            return (Criteria) this;
        }

        public Criteria andColDescIsNull() {
            addCriterion("col_desc is null");
            return (Criteria) this;
        }

        public Criteria andColDescIsNotNull() {
            addCriterion("col_desc is not null");
            return (Criteria) this;
        }

        public Criteria andColDescEqualTo(String value) {
            addCriterion("col_desc =", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescNotEqualTo(String value) {
            addCriterion("col_desc <>", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescGreaterThan(String value) {
            addCriterion("col_desc >", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescGreaterThanOrEqualTo(String value) {
            addCriterion("col_desc >=", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescLessThan(String value) {
            addCriterion("col_desc <", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescLessThanOrEqualTo(String value) {
            addCriterion("col_desc <=", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescLike(String value) {
            addCriterion("col_desc like", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescNotLike(String value) {
            addCriterion("col_desc not like", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescIn(List<String> values) {
            addCriterion("col_desc in", values, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescNotIn(List<String> values) {
            addCriterion("col_desc not in", values, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescBetween(String value1, String value2) {
            addCriterion("col_desc between", value1, value2, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescNotBetween(String value1, String value2) {
            addCriterion("col_desc not between", value1, value2, "colDesc");
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
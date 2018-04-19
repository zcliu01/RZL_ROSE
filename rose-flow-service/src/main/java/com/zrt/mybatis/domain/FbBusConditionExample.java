package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusConditionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusConditionExample() {
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

        public Criteria andCheckIdIsNull() {
            addCriterion("check_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(String value) {
            addCriterion("check_id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(String value) {
            addCriterion("check_id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(String value) {
            addCriterion("check_id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("check_id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(String value) {
            addCriterion("check_id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(String value) {
            addCriterion("check_id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLike(String value) {
            addCriterion("check_id like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotLike(String value) {
            addCriterion("check_id not like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<String> values) {
            addCriterion("check_id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<String> values) {
            addCriterion("check_id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(String value1, String value2) {
            addCriterion("check_id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(String value1, String value2) {
            addCriterion("check_id not between", value1, value2, "checkId");
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

        public Criteria andResDateTimeIsNull() {
            addCriterion("res_date_time is null");
            return (Criteria) this;
        }

        public Criteria andResDateTimeIsNotNull() {
            addCriterion("res_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andResDateTimeEqualTo(String value) {
            addCriterion("res_date_time =", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeNotEqualTo(String value) {
            addCriterion("res_date_time <>", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeGreaterThan(String value) {
            addCriterion("res_date_time >", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("res_date_time >=", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeLessThan(String value) {
            addCriterion("res_date_time <", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeLessThanOrEqualTo(String value) {
            addCriterion("res_date_time <=", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeLike(String value) {
            addCriterion("res_date_time like", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeNotLike(String value) {
            addCriterion("res_date_time not like", value, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeIn(List<String> values) {
            addCriterion("res_date_time in", values, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeNotIn(List<String> values) {
            addCriterion("res_date_time not in", values, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeBetween(String value1, String value2) {
            addCriterion("res_date_time between", value1, value2, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andResDateTimeNotBetween(String value1, String value2) {
            addCriterion("res_date_time not between", value1, value2, "resDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeIsNull() {
            addCriterion("rev_date_time is null");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeIsNotNull() {
            addCriterion("rev_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeEqualTo(String value) {
            addCriterion("rev_date_time =", value, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeNotEqualTo(String value) {
            addCriterion("rev_date_time <>", value, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeGreaterThan(String value) {
            addCriterion("rev_date_time >", value, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("rev_date_time >=", value, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeLessThan(String value) {
            addCriterion("rev_date_time <", value, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeLessThanOrEqualTo(String value) {
            addCriterion("rev_date_time <=", value, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeLike(String value) {
            addCriterion("rev_date_time like", value, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeNotLike(String value) {
            addCriterion("rev_date_time not like", value, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeIn(List<String> values) {
            addCriterion("rev_date_time in", values, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeNotIn(List<String> values) {
            addCriterion("rev_date_time not in", values, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeBetween(String value1, String value2) {
            addCriterion("rev_date_time between", value1, value2, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andRevDateTimeNotBetween(String value1, String value2) {
            addCriterion("rev_date_time not between", value1, value2, "revDateTime");
            return (Criteria) this;
        }

        public Criteria andResContentIsNull() {
            addCriterion("res_content is null");
            return (Criteria) this;
        }

        public Criteria andResContentIsNotNull() {
            addCriterion("res_content is not null");
            return (Criteria) this;
        }

        public Criteria andResContentEqualTo(String value) {
            addCriterion("res_content =", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentNotEqualTo(String value) {
            addCriterion("res_content <>", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentGreaterThan(String value) {
            addCriterion("res_content >", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentGreaterThanOrEqualTo(String value) {
            addCriterion("res_content >=", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentLessThan(String value) {
            addCriterion("res_content <", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentLessThanOrEqualTo(String value) {
            addCriterion("res_content <=", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentLike(String value) {
            addCriterion("res_content like", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentNotLike(String value) {
            addCriterion("res_content not like", value, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentIn(List<String> values) {
            addCriterion("res_content in", values, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentNotIn(List<String> values) {
            addCriterion("res_content not in", values, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentBetween(String value1, String value2) {
            addCriterion("res_content between", value1, value2, "resContent");
            return (Criteria) this;
        }

        public Criteria andResContentNotBetween(String value1, String value2) {
            addCriterion("res_content not between", value1, value2, "resContent");
            return (Criteria) this;
        }

        public Criteria andRevContentIsNull() {
            addCriterion("rev_content is null");
            return (Criteria) this;
        }

        public Criteria andRevContentIsNotNull() {
            addCriterion("rev_content is not null");
            return (Criteria) this;
        }

        public Criteria andRevContentEqualTo(String value) {
            addCriterion("rev_content =", value, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentNotEqualTo(String value) {
            addCriterion("rev_content <>", value, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentGreaterThan(String value) {
            addCriterion("rev_content >", value, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentGreaterThanOrEqualTo(String value) {
            addCriterion("rev_content >=", value, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentLessThan(String value) {
            addCriterion("rev_content <", value, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentLessThanOrEqualTo(String value) {
            addCriterion("rev_content <=", value, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentLike(String value) {
            addCriterion("rev_content like", value, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentNotLike(String value) {
            addCriterion("rev_content not like", value, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentIn(List<String> values) {
            addCriterion("rev_content in", values, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentNotIn(List<String> values) {
            addCriterion("rev_content not in", values, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentBetween(String value1, String value2) {
            addCriterion("rev_content between", value1, value2, "revContent");
            return (Criteria) this;
        }

        public Criteria andRevContentNotBetween(String value1, String value2) {
            addCriterion("rev_content not between", value1, value2, "revContent");
            return (Criteria) this;
        }

        public Criteria andConStatusIsNull() {
            addCriterion("con_status is null");
            return (Criteria) this;
        }

        public Criteria andConStatusIsNotNull() {
            addCriterion("con_status is not null");
            return (Criteria) this;
        }

        public Criteria andConStatusEqualTo(String value) {
            addCriterion("con_status =", value, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusNotEqualTo(String value) {
            addCriterion("con_status <>", value, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusGreaterThan(String value) {
            addCriterion("con_status >", value, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusGreaterThanOrEqualTo(String value) {
            addCriterion("con_status >=", value, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusLessThan(String value) {
            addCriterion("con_status <", value, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusLessThanOrEqualTo(String value) {
            addCriterion("con_status <=", value, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusLike(String value) {
            addCriterion("con_status like", value, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusNotLike(String value) {
            addCriterion("con_status not like", value, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusIn(List<String> values) {
            addCriterion("con_status in", values, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusNotIn(List<String> values) {
            addCriterion("con_status not in", values, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusBetween(String value1, String value2) {
            addCriterion("con_status between", value1, value2, "conStatus");
            return (Criteria) this;
        }

        public Criteria andConStatusNotBetween(String value1, String value2) {
            addCriterion("con_status not between", value1, value2, "conStatus");
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
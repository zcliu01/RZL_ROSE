package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class PlatInforRelevanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatInforRelevanceExample() {
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

        public Criteria andRelInforIdIsNull() {
            addCriterion("rel_infor_id is null");
            return (Criteria) this;
        }

        public Criteria andRelInforIdIsNotNull() {
            addCriterion("rel_infor_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelInforIdEqualTo(String value) {
            addCriterion("rel_infor_id =", value, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdNotEqualTo(String value) {
            addCriterion("rel_infor_id <>", value, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdGreaterThan(String value) {
            addCriterion("rel_infor_id >", value, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdGreaterThanOrEqualTo(String value) {
            addCriterion("rel_infor_id >=", value, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdLessThan(String value) {
            addCriterion("rel_infor_id <", value, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdLessThanOrEqualTo(String value) {
            addCriterion("rel_infor_id <=", value, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdLike(String value) {
            addCriterion("rel_infor_id like", value, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdNotLike(String value) {
            addCriterion("rel_infor_id not like", value, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdIn(List<String> values) {
            addCriterion("rel_infor_id in", values, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdNotIn(List<String> values) {
            addCriterion("rel_infor_id not in", values, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdBetween(String value1, String value2) {
            addCriterion("rel_infor_id between", value1, value2, "relInforId");
            return (Criteria) this;
        }

        public Criteria andRelInforIdNotBetween(String value1, String value2) {
            addCriterion("rel_infor_id not between", value1, value2, "relInforId");
            return (Criteria) this;
        }

        public Criteria andInforNoIsNull() {
            addCriterion("infor_no is null");
            return (Criteria) this;
        }

        public Criteria andInforNoIsNotNull() {
            addCriterion("infor_no is not null");
            return (Criteria) this;
        }

        public Criteria andInforNoEqualTo(String value) {
            addCriterion("infor_no =", value, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoNotEqualTo(String value) {
            addCriterion("infor_no <>", value, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoGreaterThan(String value) {
            addCriterion("infor_no >", value, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoGreaterThanOrEqualTo(String value) {
            addCriterion("infor_no >=", value, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoLessThan(String value) {
            addCriterion("infor_no <", value, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoLessThanOrEqualTo(String value) {
            addCriterion("infor_no <=", value, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoLike(String value) {
            addCriterion("infor_no like", value, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoNotLike(String value) {
            addCriterion("infor_no not like", value, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoIn(List<String> values) {
            addCriterion("infor_no in", values, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoNotIn(List<String> values) {
            addCriterion("infor_no not in", values, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoBetween(String value1, String value2) {
            addCriterion("infor_no between", value1, value2, "inforNo");
            return (Criteria) this;
        }

        public Criteria andInforNoNotBetween(String value1, String value2) {
            addCriterion("infor_no not between", value1, value2, "inforNo");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNull() {
            addCriterion("rel_id is null");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNotNull() {
            addCriterion("rel_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelIdEqualTo(String value) {
            addCriterion("rel_id =", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotEqualTo(String value) {
            addCriterion("rel_id <>", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThan(String value) {
            addCriterion("rel_id >", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThanOrEqualTo(String value) {
            addCriterion("rel_id >=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThan(String value) {
            addCriterion("rel_id <", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThanOrEqualTo(String value) {
            addCriterion("rel_id <=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLike(String value) {
            addCriterion("rel_id like", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotLike(String value) {
            addCriterion("rel_id not like", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdIn(List<String> values) {
            addCriterion("rel_id in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotIn(List<String> values) {
            addCriterion("rel_id not in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdBetween(String value1, String value2) {
            addCriterion("rel_id between", value1, value2, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotBetween(String value1, String value2) {
            addCriterion("rel_id not between", value1, value2, "relId");
            return (Criteria) this;
        }

        public Criteria andRelNameIsNull() {
            addCriterion("rel_name is null");
            return (Criteria) this;
        }

        public Criteria andRelNameIsNotNull() {
            addCriterion("rel_name is not null");
            return (Criteria) this;
        }

        public Criteria andRelNameEqualTo(String value) {
            addCriterion("rel_name =", value, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameNotEqualTo(String value) {
            addCriterion("rel_name <>", value, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameGreaterThan(String value) {
            addCriterion("rel_name >", value, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameGreaterThanOrEqualTo(String value) {
            addCriterion("rel_name >=", value, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameLessThan(String value) {
            addCriterion("rel_name <", value, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameLessThanOrEqualTo(String value) {
            addCriterion("rel_name <=", value, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameLike(String value) {
            addCriterion("rel_name like", value, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameNotLike(String value) {
            addCriterion("rel_name not like", value, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameIn(List<String> values) {
            addCriterion("rel_name in", values, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameNotIn(List<String> values) {
            addCriterion("rel_name not in", values, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameBetween(String value1, String value2) {
            addCriterion("rel_name between", value1, value2, "relName");
            return (Criteria) this;
        }

        public Criteria andRelNameNotBetween(String value1, String value2) {
            addCriterion("rel_name not between", value1, value2, "relName");
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
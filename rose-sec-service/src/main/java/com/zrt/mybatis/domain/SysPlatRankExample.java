package com.zrt.mybatis.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SysPlatRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPlatRankExample() {
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

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(String value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(String value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(String value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(String value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(String value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(String value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLike(String value) {
            addCriterion("r_id like", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotLike(String value) {
            addCriterion("r_id not like", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<String> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<String> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(String value1, String value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(String value1, String value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRNameIsNull() {
            addCriterion("r_name is null");
            return (Criteria) this;
        }

        public Criteria andRNameIsNotNull() {
            addCriterion("r_name is not null");
            return (Criteria) this;
        }

        public Criteria andRNameEqualTo(String value) {
            addCriterion("r_name =", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotEqualTo(String value) {
            addCriterion("r_name <>", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThan(String value) {
            addCriterion("r_name >", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThanOrEqualTo(String value) {
            addCriterion("r_name >=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThan(String value) {
            addCriterion("r_name <", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThanOrEqualTo(String value) {
            addCriterion("r_name <=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLike(String value) {
            addCriterion("r_name like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotLike(String value) {
            addCriterion("r_name not like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameIn(List<String> values) {
            addCriterion("r_name in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotIn(List<String> values) {
            addCriterion("r_name not in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameBetween(String value1, String value2) {
            addCriterion("r_name between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotBetween(String value1, String value2) {
            addCriterion("r_name not between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andRWeightIsNull() {
            addCriterion("r_weight is null");
            return (Criteria) this;
        }

        public Criteria andRWeightIsNotNull() {
            addCriterion("r_weight is not null");
            return (Criteria) this;
        }

        public Criteria andRWeightEqualTo(BigDecimal value) {
            addCriterion("r_weight =", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightNotEqualTo(BigDecimal value) {
            addCriterion("r_weight <>", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightGreaterThan(BigDecimal value) {
            addCriterion("r_weight >", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("r_weight >=", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightLessThan(BigDecimal value) {
            addCriterion("r_weight <", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("r_weight <=", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightIn(List<BigDecimal> values) {
            addCriterion("r_weight in", values, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightNotIn(List<BigDecimal> values) {
            addCriterion("r_weight not in", values, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("r_weight between", value1, value2, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("r_weight not between", value1, value2, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRStatusIsNull() {
            addCriterion("r_status is null");
            return (Criteria) this;
        }

        public Criteria andRStatusIsNotNull() {
            addCriterion("r_status is not null");
            return (Criteria) this;
        }

        public Criteria andRStatusEqualTo(String value) {
            addCriterion("r_status =", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusNotEqualTo(String value) {
            addCriterion("r_status <>", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusGreaterThan(String value) {
            addCriterion("r_status >", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusGreaterThanOrEqualTo(String value) {
            addCriterion("r_status >=", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusLessThan(String value) {
            addCriterion("r_status <", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusLessThanOrEqualTo(String value) {
            addCriterion("r_status <=", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusLike(String value) {
            addCriterion("r_status like", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusNotLike(String value) {
            addCriterion("r_status not like", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusIn(List<String> values) {
            addCriterion("r_status in", values, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusNotIn(List<String> values) {
            addCriterion("r_status not in", values, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusBetween(String value1, String value2) {
            addCriterion("r_status between", value1, value2, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusNotBetween(String value1, String value2) {
            addCriterion("r_status not between", value1, value2, "rStatus");
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

        public Criteria andRDescIsNull() {
            addCriterion("r_desc is null");
            return (Criteria) this;
        }

        public Criteria andRDescIsNotNull() {
            addCriterion("r_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRDescEqualTo(String value) {
            addCriterion("r_desc =", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotEqualTo(String value) {
            addCriterion("r_desc <>", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescGreaterThan(String value) {
            addCriterion("r_desc >", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescGreaterThanOrEqualTo(String value) {
            addCriterion("r_desc >=", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLessThan(String value) {
            addCriterion("r_desc <", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLessThanOrEqualTo(String value) {
            addCriterion("r_desc <=", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescLike(String value) {
            addCriterion("r_desc like", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotLike(String value) {
            addCriterion("r_desc not like", value, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescIn(List<String> values) {
            addCriterion("r_desc in", values, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotIn(List<String> values) {
            addCriterion("r_desc not in", values, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescBetween(String value1, String value2) {
            addCriterion("r_desc between", value1, value2, "rDesc");
            return (Criteria) this;
        }

        public Criteria andRDescNotBetween(String value1, String value2) {
            addCriterion("r_desc not between", value1, value2, "rDesc");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andROrderIsNull() {
            addCriterion("r_order is null");
            return (Criteria) this;
        }

        public Criteria andROrderIsNotNull() {
            addCriterion("r_order is not null");
            return (Criteria) this;
        }

        public Criteria andROrderEqualTo(Integer value) {
            addCriterion("r_order =", value, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderNotEqualTo(Integer value) {
            addCriterion("r_order <>", value, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderGreaterThan(Integer value) {
            addCriterion("r_order >", value, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_order >=", value, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderLessThan(Integer value) {
            addCriterion("r_order <", value, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderLessThanOrEqualTo(Integer value) {
            addCriterion("r_order <=", value, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderIn(List<Integer> values) {
            addCriterion("r_order in", values, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderNotIn(List<Integer> values) {
            addCriterion("r_order not in", values, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderBetween(Integer value1, Integer value2) {
            addCriterion("r_order between", value1, value2, "rOrder");
            return (Criteria) this;
        }

        public Criteria andROrderNotBetween(Integer value1, Integer value2) {
            addCriterion("r_order not between", value1, value2, "rOrder");
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
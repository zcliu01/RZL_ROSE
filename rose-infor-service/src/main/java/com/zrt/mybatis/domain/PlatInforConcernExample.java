package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class PlatInforConcernExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatInforConcernExample() {
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

        public Criteria andConcernIdIsNull() {
            addCriterion("concern_id is null");
            return (Criteria) this;
        }

        public Criteria andConcernIdIsNotNull() {
            addCriterion("concern_id is not null");
            return (Criteria) this;
        }

        public Criteria andConcernIdEqualTo(String value) {
            addCriterion("concern_id =", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotEqualTo(String value) {
            addCriterion("concern_id <>", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdGreaterThan(String value) {
            addCriterion("concern_id >", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdGreaterThanOrEqualTo(String value) {
            addCriterion("concern_id >=", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdLessThan(String value) {
            addCriterion("concern_id <", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdLessThanOrEqualTo(String value) {
            addCriterion("concern_id <=", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdLike(String value) {
            addCriterion("concern_id like", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotLike(String value) {
            addCriterion("concern_id not like", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdIn(List<String> values) {
            addCriterion("concern_id in", values, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotIn(List<String> values) {
            addCriterion("concern_id not in", values, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdBetween(String value1, String value2) {
            addCriterion("concern_id between", value1, value2, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotBetween(String value1, String value2) {
            addCriterion("concern_id not between", value1, value2, "concernId");
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

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(String value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(String value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(String value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(String value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(String value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLike(String value) {
            addCriterion("emp_id like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotLike(String value) {
            addCriterion("emp_id not like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<String> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<String> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(String value1, String value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(String value1, String value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
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

        public Criteria andConcernTypeIsNull() {
            addCriterion("concern_type is null");
            return (Criteria) this;
        }

        public Criteria andConcernTypeIsNotNull() {
            addCriterion("concern_type is not null");
            return (Criteria) this;
        }

        public Criteria andConcernTypeEqualTo(String value) {
            addCriterion("concern_type =", value, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeNotEqualTo(String value) {
            addCriterion("concern_type <>", value, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeGreaterThan(String value) {
            addCriterion("concern_type >", value, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeGreaterThanOrEqualTo(String value) {
            addCriterion("concern_type >=", value, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeLessThan(String value) {
            addCriterion("concern_type <", value, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeLessThanOrEqualTo(String value) {
            addCriterion("concern_type <=", value, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeLike(String value) {
            addCriterion("concern_type like", value, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeNotLike(String value) {
            addCriterion("concern_type not like", value, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeIn(List<String> values) {
            addCriterion("concern_type in", values, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeNotIn(List<String> values) {
            addCriterion("concern_type not in", values, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeBetween(String value1, String value2) {
            addCriterion("concern_type between", value1, value2, "concernType");
            return (Criteria) this;
        }

        public Criteria andConcernTypeNotBetween(String value1, String value2) {
            addCriterion("concern_type not between", value1, value2, "concernType");
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
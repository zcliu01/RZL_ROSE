package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class EmpContactsCmuctRcdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmpContactsCmuctRcdExample() {
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

        public Criteria andCmuctRcdIdIsNull() {
            addCriterion("cmuct_rcd_id is null");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdIsNotNull() {
            addCriterion("cmuct_rcd_id is not null");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdEqualTo(String value) {
            addCriterion("cmuct_rcd_id =", value, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdNotEqualTo(String value) {
            addCriterion("cmuct_rcd_id <>", value, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdGreaterThan(String value) {
            addCriterion("cmuct_rcd_id >", value, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdGreaterThanOrEqualTo(String value) {
            addCriterion("cmuct_rcd_id >=", value, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdLessThan(String value) {
            addCriterion("cmuct_rcd_id <", value, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdLessThanOrEqualTo(String value) {
            addCriterion("cmuct_rcd_id <=", value, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdLike(String value) {
            addCriterion("cmuct_rcd_id like", value, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdNotLike(String value) {
            addCriterion("cmuct_rcd_id not like", value, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdIn(List<String> values) {
            addCriterion("cmuct_rcd_id in", values, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdNotIn(List<String> values) {
            addCriterion("cmuct_rcd_id not in", values, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdBetween(String value1, String value2) {
            addCriterion("cmuct_rcd_id between", value1, value2, "cmuctRcdId");
            return (Criteria) this;
        }

        public Criteria andCmuctRcdIdNotBetween(String value1, String value2) {
            addCriterion("cmuct_rcd_id not between", value1, value2, "cmuctRcdId");
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

        public Criteria andCmuctIdIsNull() {
            addCriterion("cmuct_id is null");
            return (Criteria) this;
        }

        public Criteria andCmuctIdIsNotNull() {
            addCriterion("cmuct_id is not null");
            return (Criteria) this;
        }

        public Criteria andCmuctIdEqualTo(String value) {
            addCriterion("cmuct_id =", value, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdNotEqualTo(String value) {
            addCriterion("cmuct_id <>", value, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdGreaterThan(String value) {
            addCriterion("cmuct_id >", value, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdGreaterThanOrEqualTo(String value) {
            addCriterion("cmuct_id >=", value, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdLessThan(String value) {
            addCriterion("cmuct_id <", value, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdLessThanOrEqualTo(String value) {
            addCriterion("cmuct_id <=", value, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdLike(String value) {
            addCriterion("cmuct_id like", value, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdNotLike(String value) {
            addCriterion("cmuct_id not like", value, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdIn(List<String> values) {
            addCriterion("cmuct_id in", values, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdNotIn(List<String> values) {
            addCriterion("cmuct_id not in", values, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdBetween(String value1, String value2) {
            addCriterion("cmuct_id between", value1, value2, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctIdNotBetween(String value1, String value2) {
            addCriterion("cmuct_id not between", value1, value2, "cmuctId");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeIsNull() {
            addCriterion("cmuct_type is null");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeIsNotNull() {
            addCriterion("cmuct_type is not null");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeEqualTo(String value) {
            addCriterion("cmuct_type =", value, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeNotEqualTo(String value) {
            addCriterion("cmuct_type <>", value, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeGreaterThan(String value) {
            addCriterion("cmuct_type >", value, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cmuct_type >=", value, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeLessThan(String value) {
            addCriterion("cmuct_type <", value, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeLessThanOrEqualTo(String value) {
            addCriterion("cmuct_type <=", value, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeLike(String value) {
            addCriterion("cmuct_type like", value, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeNotLike(String value) {
            addCriterion("cmuct_type not like", value, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeIn(List<String> values) {
            addCriterion("cmuct_type in", values, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeNotIn(List<String> values) {
            addCriterion("cmuct_type not in", values, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeBetween(String value1, String value2) {
            addCriterion("cmuct_type between", value1, value2, "cmuctType");
            return (Criteria) this;
        }

        public Criteria andCmuctTypeNotBetween(String value1, String value2) {
            addCriterion("cmuct_type not between", value1, value2, "cmuctType");
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

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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
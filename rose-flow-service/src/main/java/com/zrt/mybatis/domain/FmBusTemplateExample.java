package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FmBusTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FmBusTemplateExample() {
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

        public Criteria andTCodeIsNull() {
            addCriterion("t_code is null");
            return (Criteria) this;
        }

        public Criteria andTCodeIsNotNull() {
            addCriterion("t_code is not null");
            return (Criteria) this;
        }

        public Criteria andTCodeEqualTo(String value) {
            addCriterion("t_code =", value, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeNotEqualTo(String value) {
            addCriterion("t_code <>", value, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeGreaterThan(String value) {
            addCriterion("t_code >", value, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeGreaterThanOrEqualTo(String value) {
            addCriterion("t_code >=", value, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeLessThan(String value) {
            addCriterion("t_code <", value, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeLessThanOrEqualTo(String value) {
            addCriterion("t_code <=", value, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeLike(String value) {
            addCriterion("t_code like", value, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeNotLike(String value) {
            addCriterion("t_code not like", value, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeIn(List<String> values) {
            addCriterion("t_code in", values, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeNotIn(List<String> values) {
            addCriterion("t_code not in", values, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeBetween(String value1, String value2) {
            addCriterion("t_code between", value1, value2, "tCode");
            return (Criteria) this;
        }

        public Criteria andTCodeNotBetween(String value1, String value2) {
            addCriterion("t_code not between", value1, value2, "tCode");
            return (Criteria) this;
        }

        public Criteria andTNameIsNull() {
            addCriterion("t_name is null");
            return (Criteria) this;
        }

        public Criteria andTNameIsNotNull() {
            addCriterion("t_name is not null");
            return (Criteria) this;
        }

        public Criteria andTNameEqualTo(String value) {
            addCriterion("t_name =", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotEqualTo(String value) {
            addCriterion("t_name <>", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThan(String value) {
            addCriterion("t_name >", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameGreaterThanOrEqualTo(String value) {
            addCriterion("t_name >=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThan(String value) {
            addCriterion("t_name <", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLessThanOrEqualTo(String value) {
            addCriterion("t_name <=", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameLike(String value) {
            addCriterion("t_name like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotLike(String value) {
            addCriterion("t_name not like", value, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameIn(List<String> values) {
            addCriterion("t_name in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotIn(List<String> values) {
            addCriterion("t_name not in", values, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameBetween(String value1, String value2) {
            addCriterion("t_name between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTNameNotBetween(String value1, String value2) {
            addCriterion("t_name not between", value1, value2, "tName");
            return (Criteria) this;
        }

        public Criteria andTDescIsNull() {
            addCriterion("t_desc is null");
            return (Criteria) this;
        }

        public Criteria andTDescIsNotNull() {
            addCriterion("t_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTDescEqualTo(String value) {
            addCriterion("t_desc =", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescNotEqualTo(String value) {
            addCriterion("t_desc <>", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescGreaterThan(String value) {
            addCriterion("t_desc >", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescGreaterThanOrEqualTo(String value) {
            addCriterion("t_desc >=", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescLessThan(String value) {
            addCriterion("t_desc <", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescLessThanOrEqualTo(String value) {
            addCriterion("t_desc <=", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescLike(String value) {
            addCriterion("t_desc like", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescNotLike(String value) {
            addCriterion("t_desc not like", value, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescIn(List<String> values) {
            addCriterion("t_desc in", values, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescNotIn(List<String> values) {
            addCriterion("t_desc not in", values, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescBetween(String value1, String value2) {
            addCriterion("t_desc between", value1, value2, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTDescNotBetween(String value1, String value2) {
            addCriterion("t_desc not between", value1, value2, "tDesc");
            return (Criteria) this;
        }

        public Criteria andTEnabledIsNull() {
            addCriterion("t_enabled is null");
            return (Criteria) this;
        }

        public Criteria andTEnabledIsNotNull() {
            addCriterion("t_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andTEnabledEqualTo(String value) {
            addCriterion("t_enabled =", value, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledNotEqualTo(String value) {
            addCriterion("t_enabled <>", value, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledGreaterThan(String value) {
            addCriterion("t_enabled >", value, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("t_enabled >=", value, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledLessThan(String value) {
            addCriterion("t_enabled <", value, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledLessThanOrEqualTo(String value) {
            addCriterion("t_enabled <=", value, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledLike(String value) {
            addCriterion("t_enabled like", value, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledNotLike(String value) {
            addCriterion("t_enabled not like", value, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledIn(List<String> values) {
            addCriterion("t_enabled in", values, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledNotIn(List<String> values) {
            addCriterion("t_enabled not in", values, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledBetween(String value1, String value2) {
            addCriterion("t_enabled between", value1, value2, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andTEnabledNotBetween(String value1, String value2) {
            addCriterion("t_enabled not between", value1, value2, "tEnabled");
            return (Criteria) this;
        }

        public Criteria andFBTIdIsNull() {
            addCriterion("f_b_t_id is null");
            return (Criteria) this;
        }

        public Criteria andFBTIdIsNotNull() {
            addCriterion("f_b_t_id is not null");
            return (Criteria) this;
        }

        public Criteria andFBTIdEqualTo(String value) {
            addCriterion("f_b_t_id =", value, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdNotEqualTo(String value) {
            addCriterion("f_b_t_id <>", value, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdGreaterThan(String value) {
            addCriterion("f_b_t_id >", value, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_b_t_id >=", value, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdLessThan(String value) {
            addCriterion("f_b_t_id <", value, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdLessThanOrEqualTo(String value) {
            addCriterion("f_b_t_id <=", value, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdLike(String value) {
            addCriterion("f_b_t_id like", value, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdNotLike(String value) {
            addCriterion("f_b_t_id not like", value, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdIn(List<String> values) {
            addCriterion("f_b_t_id in", values, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdNotIn(List<String> values) {
            addCriterion("f_b_t_id not in", values, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdBetween(String value1, String value2) {
            addCriterion("f_b_t_id between", value1, value2, "fBTId");
            return (Criteria) this;
        }

        public Criteria andFBTIdNotBetween(String value1, String value2) {
            addCriterion("f_b_t_id not between", value1, value2, "fBTId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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

        public Criteria andCreateEmpIdIsNull() {
            addCriterion("create_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdIsNotNull() {
            addCriterion("create_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdEqualTo(String value) {
            addCriterion("create_emp_id =", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdNotEqualTo(String value) {
            addCriterion("create_emp_id <>", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdGreaterThan(String value) {
            addCriterion("create_emp_id >", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_emp_id >=", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdLessThan(String value) {
            addCriterion("create_emp_id <", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdLessThanOrEqualTo(String value) {
            addCriterion("create_emp_id <=", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdLike(String value) {
            addCriterion("create_emp_id like", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdNotLike(String value) {
            addCriterion("create_emp_id not like", value, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdIn(List<String> values) {
            addCriterion("create_emp_id in", values, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdNotIn(List<String> values) {
            addCriterion("create_emp_id not in", values, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdBetween(String value1, String value2) {
            addCriterion("create_emp_id between", value1, value2, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpIdNotBetween(String value1, String value2) {
            addCriterion("create_emp_id not between", value1, value2, "createEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdIsNull() {
            addCriterion("update_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdIsNotNull() {
            addCriterion("update_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdEqualTo(String value) {
            addCriterion("update_emp_id =", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotEqualTo(String value) {
            addCriterion("update_emp_id <>", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdGreaterThan(String value) {
            addCriterion("update_emp_id >", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_emp_id >=", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLessThan(String value) {
            addCriterion("update_emp_id <", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLessThanOrEqualTo(String value) {
            addCriterion("update_emp_id <=", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLike(String value) {
            addCriterion("update_emp_id like", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotLike(String value) {
            addCriterion("update_emp_id not like", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdIn(List<String> values) {
            addCriterion("update_emp_id in", values, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotIn(List<String> values) {
            addCriterion("update_emp_id not in", values, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdBetween(String value1, String value2) {
            addCriterion("update_emp_id between", value1, value2, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotBetween(String value1, String value2) {
            addCriterion("update_emp_id not between", value1, value2, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameIsNull() {
            addCriterion("create_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameIsNotNull() {
            addCriterion("create_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameEqualTo(String value) {
            addCriterion("create_emp_name =", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameNotEqualTo(String value) {
            addCriterion("create_emp_name <>", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameGreaterThan(String value) {
            addCriterion("create_emp_name >", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_emp_name >=", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameLessThan(String value) {
            addCriterion("create_emp_name <", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameLessThanOrEqualTo(String value) {
            addCriterion("create_emp_name <=", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameLike(String value) {
            addCriterion("create_emp_name like", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameNotLike(String value) {
            addCriterion("create_emp_name not like", value, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameIn(List<String> values) {
            addCriterion("create_emp_name in", values, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameNotIn(List<String> values) {
            addCriterion("create_emp_name not in", values, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameBetween(String value1, String value2) {
            addCriterion("create_emp_name between", value1, value2, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andCreateEmpNameNotBetween(String value1, String value2) {
            addCriterion("create_emp_name not between", value1, value2, "createEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameIsNull() {
            addCriterion("update_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameIsNotNull() {
            addCriterion("update_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameEqualTo(String value) {
            addCriterion("update_emp_name =", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotEqualTo(String value) {
            addCriterion("update_emp_name <>", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameGreaterThan(String value) {
            addCriterion("update_emp_name >", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_emp_name >=", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLessThan(String value) {
            addCriterion("update_emp_name <", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLessThanOrEqualTo(String value) {
            addCriterion("update_emp_name <=", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLike(String value) {
            addCriterion("update_emp_name like", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotLike(String value) {
            addCriterion("update_emp_name not like", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameIn(List<String> values) {
            addCriterion("update_emp_name in", values, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotIn(List<String> values) {
            addCriterion("update_emp_name not in", values, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameBetween(String value1, String value2) {
            addCriterion("update_emp_name between", value1, value2, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotBetween(String value1, String value2) {
            addCriterion("update_emp_name not between", value1, value2, "updateEmpName");
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
package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNull() {
            addCriterion("role_code is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("role_code is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(String value) {
            addCriterion("role_code =", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(String value) {
            addCriterion("role_code <>", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(String value) {
            addCriterion("role_code >", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("role_code >=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(String value) {
            addCriterion("role_code <", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(String value) {
            addCriterion("role_code <=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLike(String value) {
            addCriterion("role_code like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotLike(String value) {
            addCriterion("role_code not like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<String> values) {
            addCriterion("role_code in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<String> values) {
            addCriterion("role_code not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(String value1, String value2) {
            addCriterion("role_code between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(String value1, String value2) {
            addCriterion("role_code not between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeIsNull() {
            addCriterion("org_level_type is null");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeIsNotNull() {
            addCriterion("org_level_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeEqualTo(String value) {
            addCriterion("org_level_type =", value, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeNotEqualTo(String value) {
            addCriterion("org_level_type <>", value, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeGreaterThan(String value) {
            addCriterion("org_level_type >", value, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("org_level_type >=", value, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeLessThan(String value) {
            addCriterion("org_level_type <", value, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeLessThanOrEqualTo(String value) {
            addCriterion("org_level_type <=", value, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeLike(String value) {
            addCriterion("org_level_type like", value, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeNotLike(String value) {
            addCriterion("org_level_type not like", value, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeIn(List<String> values) {
            addCriterion("org_level_type in", values, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeNotIn(List<String> values) {
            addCriterion("org_level_type not in", values, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeBetween(String value1, String value2) {
            addCriterion("org_level_type between", value1, value2, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andOrgLevelTypeNotBetween(String value1, String value2) {
            addCriterion("org_level_type not between", value1, value2, "orgLevelType");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNull() {
            addCriterion("role_desc is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNotNull() {
            addCriterion("role_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescEqualTo(String value) {
            addCriterion("role_desc =", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotEqualTo(String value) {
            addCriterion("role_desc <>", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThan(String value) {
            addCriterion("role_desc >", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThanOrEqualTo(String value) {
            addCriterion("role_desc >=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThan(String value) {
            addCriterion("role_desc <", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThanOrEqualTo(String value) {
            addCriterion("role_desc <=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLike(String value) {
            addCriterion("role_desc like", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotLike(String value) {
            addCriterion("role_desc not like", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescIn(List<String> values) {
            addCriterion("role_desc in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotIn(List<String> values) {
            addCriterion("role_desc not in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescBetween(String value1, String value2) {
            addCriterion("role_desc between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotBetween(String value1, String value2) {
            addCriterion("role_desc not between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andSecOrderIsNull() {
            addCriterion("sec_order is null");
            return (Criteria) this;
        }

        public Criteria andSecOrderIsNotNull() {
            addCriterion("sec_order is not null");
            return (Criteria) this;
        }

        public Criteria andSecOrderEqualTo(Integer value) {
            addCriterion("sec_order =", value, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderNotEqualTo(Integer value) {
            addCriterion("sec_order <>", value, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderGreaterThan(Integer value) {
            addCriterion("sec_order >", value, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sec_order >=", value, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderLessThan(Integer value) {
            addCriterion("sec_order <", value, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderLessThanOrEqualTo(Integer value) {
            addCriterion("sec_order <=", value, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderIn(List<Integer> values) {
            addCriterion("sec_order in", values, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderNotIn(List<Integer> values) {
            addCriterion("sec_order not in", values, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderBetween(Integer value1, Integer value2) {
            addCriterion("sec_order between", value1, value2, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("sec_order not between", value1, value2, "secOrder");
            return (Criteria) this;
        }

        public Criteria andSecEnabledIsNull() {
            addCriterion("sec_enabled is null");
            return (Criteria) this;
        }

        public Criteria andSecEnabledIsNotNull() {
            addCriterion("sec_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andSecEnabledEqualTo(String value) {
            addCriterion("sec_enabled =", value, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledNotEqualTo(String value) {
            addCriterion("sec_enabled <>", value, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledGreaterThan(String value) {
            addCriterion("sec_enabled >", value, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("sec_enabled >=", value, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledLessThan(String value) {
            addCriterion("sec_enabled <", value, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledLessThanOrEqualTo(String value) {
            addCriterion("sec_enabled <=", value, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledLike(String value) {
            addCriterion("sec_enabled like", value, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledNotLike(String value) {
            addCriterion("sec_enabled not like", value, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledIn(List<String> values) {
            addCriterion("sec_enabled in", values, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledNotIn(List<String> values) {
            addCriterion("sec_enabled not in", values, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledBetween(String value1, String value2) {
            addCriterion("sec_enabled between", value1, value2, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecEnabledNotBetween(String value1, String value2) {
            addCriterion("sec_enabled not between", value1, value2, "secEnabled");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagIsNull() {
            addCriterion("sec_sys_flag is null");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagIsNotNull() {
            addCriterion("sec_sys_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagEqualTo(String value) {
            addCriterion("sec_sys_flag =", value, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagNotEqualTo(String value) {
            addCriterion("sec_sys_flag <>", value, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagGreaterThan(String value) {
            addCriterion("sec_sys_flag >", value, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagGreaterThanOrEqualTo(String value) {
            addCriterion("sec_sys_flag >=", value, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagLessThan(String value) {
            addCriterion("sec_sys_flag <", value, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagLessThanOrEqualTo(String value) {
            addCriterion("sec_sys_flag <=", value, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagLike(String value) {
            addCriterion("sec_sys_flag like", value, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagNotLike(String value) {
            addCriterion("sec_sys_flag not like", value, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagIn(List<String> values) {
            addCriterion("sec_sys_flag in", values, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagNotIn(List<String> values) {
            addCriterion("sec_sys_flag not in", values, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagBetween(String value1, String value2) {
            addCriterion("sec_sys_flag between", value1, value2, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecSysFlagNotBetween(String value1, String value2) {
            addCriterion("sec_sys_flag not between", value1, value2, "secSysFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagIsNull() {
            addCriterion("sec_readonly_flag is null");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagIsNotNull() {
            addCriterion("sec_readonly_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagEqualTo(String value) {
            addCriterion("sec_readonly_flag =", value, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagNotEqualTo(String value) {
            addCriterion("sec_readonly_flag <>", value, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagGreaterThan(String value) {
            addCriterion("sec_readonly_flag >", value, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("sec_readonly_flag >=", value, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagLessThan(String value) {
            addCriterion("sec_readonly_flag <", value, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagLessThanOrEqualTo(String value) {
            addCriterion("sec_readonly_flag <=", value, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagLike(String value) {
            addCriterion("sec_readonly_flag like", value, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagNotLike(String value) {
            addCriterion("sec_readonly_flag not like", value, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagIn(List<String> values) {
            addCriterion("sec_readonly_flag in", values, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagNotIn(List<String> values) {
            addCriterion("sec_readonly_flag not in", values, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagBetween(String value1, String value2) {
            addCriterion("sec_readonly_flag between", value1, value2, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecReadonlyFlagNotBetween(String value1, String value2) {
            addCriterion("sec_readonly_flag not between", value1, value2, "secReadonlyFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagIsNull() {
            addCriterion("sec_delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagIsNotNull() {
            addCriterion("sec_delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagEqualTo(String value) {
            addCriterion("sec_delete_flag =", value, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagNotEqualTo(String value) {
            addCriterion("sec_delete_flag <>", value, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagGreaterThan(String value) {
            addCriterion("sec_delete_flag >", value, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("sec_delete_flag >=", value, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagLessThan(String value) {
            addCriterion("sec_delete_flag <", value, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("sec_delete_flag <=", value, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagLike(String value) {
            addCriterion("sec_delete_flag like", value, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagNotLike(String value) {
            addCriterion("sec_delete_flag not like", value, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagIn(List<String> values) {
            addCriterion("sec_delete_flag in", values, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagNotIn(List<String> values) {
            addCriterion("sec_delete_flag not in", values, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagBetween(String value1, String value2) {
            addCriterion("sec_delete_flag between", value1, value2, "secDeleteFlag");
            return (Criteria) this;
        }

        public Criteria andSecDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("sec_delete_flag not between", value1, value2, "secDeleteFlag");
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

        public Criteria andVersionIsNull() {
            addCriterion("version_ is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version_ is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version_ =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version_ <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version_ >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version_ >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version_ <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version_ <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version_ in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version_ not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version_ between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version_ not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIsNull() {
            addCriterion("group_code is null");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIsNotNull() {
            addCriterion("group_code is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCodeEqualTo(String value) {
            addCriterion("group_code =", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotEqualTo(String value) {
            addCriterion("group_code <>", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeGreaterThan(String value) {
            addCriterion("group_code >", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("group_code >=", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLessThan(String value) {
            addCriterion("group_code <", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLessThanOrEqualTo(String value) {
            addCriterion("group_code <=", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLike(String value) {
            addCriterion("group_code like", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotLike(String value) {
            addCriterion("group_code not like", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIn(List<String> values) {
            addCriterion("group_code in", values, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotIn(List<String> values) {
            addCriterion("group_code not in", values, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeBetween(String value1, String value2) {
            addCriterion("group_code between", value1, value2, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotBetween(String value1, String value2) {
            addCriterion("group_code not between", value1, value2, "groupCode");
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

        public Criteria andRoleTypeIsNull() {
            addCriterion("role_type is null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIsNotNull() {
            addCriterion("role_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoleTypeEqualTo(String value) {
            addCriterion("role_type =", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotEqualTo(String value) {
            addCriterion("role_type <>", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThan(String value) {
            addCriterion("role_type >", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("role_type >=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThan(String value) {
            addCriterion("role_type <", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLessThanOrEqualTo(String value) {
            addCriterion("role_type <=", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeLike(String value) {
            addCriterion("role_type like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotLike(String value) {
            addCriterion("role_type not like", value, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeIn(List<String> values) {
            addCriterion("role_type in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotIn(List<String> values) {
            addCriterion("role_type not in", values, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeBetween(String value1, String value2) {
            addCriterion("role_type between", value1, value2, "roleType");
            return (Criteria) this;
        }

        public Criteria andRoleTypeNotBetween(String value1, String value2) {
            addCriterion("role_type not between", value1, value2, "roleType");
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
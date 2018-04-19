package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SysSecResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSecResourceExample() {
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

        public Criteria andResourceIdIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(String value) {
            addCriterion("resource_id =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(String value) {
            addCriterion("resource_id <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(String value) {
            addCriterion("resource_id >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("resource_id >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(String value) {
            addCriterion("resource_id <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(String value) {
            addCriterion("resource_id <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLike(String value) {
            addCriterion("resource_id like", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotLike(String value) {
            addCriterion("resource_id not like", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<String> values) {
            addCriterion("resource_id in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<String> values) {
            addCriterion("resource_id not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(String value1, String value2) {
            addCriterion("resource_id between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(String value1, String value2) {
            addCriterion("resource_id not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andMenuCodeIsNull() {
            addCriterion("menu_code is null");
            return (Criteria) this;
        }

        public Criteria andMenuCodeIsNotNull() {
            addCriterion("menu_code is not null");
            return (Criteria) this;
        }

        public Criteria andMenuCodeEqualTo(String value) {
            addCriterion("menu_code =", value, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeNotEqualTo(String value) {
            addCriterion("menu_code <>", value, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeGreaterThan(String value) {
            addCriterion("menu_code >", value, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeGreaterThanOrEqualTo(String value) {
            addCriterion("menu_code >=", value, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeLessThan(String value) {
            addCriterion("menu_code <", value, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeLessThanOrEqualTo(String value) {
            addCriterion("menu_code <=", value, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeLike(String value) {
            addCriterion("menu_code like", value, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeNotLike(String value) {
            addCriterion("menu_code not like", value, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeIn(List<String> values) {
            addCriterion("menu_code in", values, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeNotIn(List<String> values) {
            addCriterion("menu_code not in", values, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeBetween(String value1, String value2) {
            addCriterion("menu_code between", value1, value2, "menuCode");
            return (Criteria) this;
        }

        public Criteria andMenuCodeNotBetween(String value1, String value2) {
            addCriterion("menu_code not between", value1, value2, "menuCode");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resource_name =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resource_name <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resource_name like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resource_name not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resource_name in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNull() {
            addCriterion("resource_type is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("resource_type is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(String value) {
            addCriterion("resource_type =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(String value) {
            addCriterion("resource_type <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(String value) {
            addCriterion("resource_type >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("resource_type >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(String value) {
            addCriterion("resource_type <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(String value) {
            addCriterion("resource_type <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLike(String value) {
            addCriterion("resource_type like", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotLike(String value) {
            addCriterion("resource_type not like", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<String> values) {
            addCriterion("resource_type in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<String> values) {
            addCriterion("resource_type not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(String value1, String value2) {
            addCriterion("resource_type between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(String value1, String value2) {
            addCriterion("resource_type not between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNull() {
            addCriterion("resource_url is null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNotNull() {
            addCriterion("resource_url is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlEqualTo(String value) {
            addCriterion("resource_url =", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotEqualTo(String value) {
            addCriterion("resource_url <>", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThan(String value) {
            addCriterion("resource_url >", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("resource_url >=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThan(String value) {
            addCriterion("resource_url <", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThanOrEqualTo(String value) {
            addCriterion("resource_url <=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLike(String value) {
            addCriterion("resource_url like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotLike(String value) {
            addCriterion("resource_url not like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIn(List<String> values) {
            addCriterion("resource_url in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotIn(List<String> values) {
            addCriterion("resource_url not in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlBetween(String value1, String value2) {
            addCriterion("resource_url between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotBetween(String value1, String value2) {
            addCriterion("resource_url not between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceGroupIsNull() {
            addCriterion("resource_group is null");
            return (Criteria) this;
        }

        public Criteria andResourceGroupIsNotNull() {
            addCriterion("resource_group is not null");
            return (Criteria) this;
        }

        public Criteria andResourceGroupEqualTo(String value) {
            addCriterion("resource_group =", value, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupNotEqualTo(String value) {
            addCriterion("resource_group <>", value, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupGreaterThan(String value) {
            addCriterion("resource_group >", value, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupGreaterThanOrEqualTo(String value) {
            addCriterion("resource_group >=", value, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupLessThan(String value) {
            addCriterion("resource_group <", value, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupLessThanOrEqualTo(String value) {
            addCriterion("resource_group <=", value, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupLike(String value) {
            addCriterion("resource_group like", value, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupNotLike(String value) {
            addCriterion("resource_group not like", value, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupIn(List<String> values) {
            addCriterion("resource_group in", values, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupNotIn(List<String> values) {
            addCriterion("resource_group not in", values, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupBetween(String value1, String value2) {
            addCriterion("resource_group between", value1, value2, "resourceGroup");
            return (Criteria) this;
        }

        public Criteria andResourceGroupNotBetween(String value1, String value2) {
            addCriterion("resource_group not between", value1, value2, "resourceGroup");
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

        public Criteria andHasResourceTypeIsNull() {
            addCriterion("has_resource_type is null");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeIsNotNull() {
            addCriterion("has_resource_type is not null");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeEqualTo(String value) {
            addCriterion("has_resource_type =", value, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeNotEqualTo(String value) {
            addCriterion("has_resource_type <>", value, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeGreaterThan(String value) {
            addCriterion("has_resource_type >", value, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("has_resource_type >=", value, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeLessThan(String value) {
            addCriterion("has_resource_type <", value, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeLessThanOrEqualTo(String value) {
            addCriterion("has_resource_type <=", value, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeLike(String value) {
            addCriterion("has_resource_type like", value, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeNotLike(String value) {
            addCriterion("has_resource_type not like", value, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeIn(List<String> values) {
            addCriterion("has_resource_type in", values, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeNotIn(List<String> values) {
            addCriterion("has_resource_type not in", values, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeBetween(String value1, String value2) {
            addCriterion("has_resource_type between", value1, value2, "hasResourceType");
            return (Criteria) this;
        }

        public Criteria andHasResourceTypeNotBetween(String value1, String value2) {
            addCriterion("has_resource_type not between", value1, value2, "hasResourceType");
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
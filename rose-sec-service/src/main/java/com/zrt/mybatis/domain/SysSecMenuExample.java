package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SysSecMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSecMenuExample() {
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

        public Criteria andRootMenuCodeIsNull() {
            addCriterion("root_menu_code is null");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeIsNotNull() {
            addCriterion("root_menu_code is not null");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeEqualTo(String value) {
            addCriterion("root_menu_code =", value, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeNotEqualTo(String value) {
            addCriterion("root_menu_code <>", value, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeGreaterThan(String value) {
            addCriterion("root_menu_code >", value, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeGreaterThanOrEqualTo(String value) {
            addCriterion("root_menu_code >=", value, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeLessThan(String value) {
            addCriterion("root_menu_code <", value, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeLessThanOrEqualTo(String value) {
            addCriterion("root_menu_code <=", value, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeLike(String value) {
            addCriterion("root_menu_code like", value, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeNotLike(String value) {
            addCriterion("root_menu_code not like", value, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeIn(List<String> values) {
            addCriterion("root_menu_code in", values, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeNotIn(List<String> values) {
            addCriterion("root_menu_code not in", values, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeBetween(String value1, String value2) {
            addCriterion("root_menu_code between", value1, value2, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andRootMenuCodeNotBetween(String value1, String value2) {
            addCriterion("root_menu_code not between", value1, value2, "rootMenuCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNull() {
            addCriterion("parent_code is null");
            return (Criteria) this;
        }

        public Criteria andParentCodeIsNotNull() {
            addCriterion("parent_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentCodeEqualTo(String value) {
            addCriterion("parent_code =", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotEqualTo(String value) {
            addCriterion("parent_code <>", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThan(String value) {
            addCriterion("parent_code >", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_code >=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThan(String value) {
            addCriterion("parent_code <", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_code <=", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeLike(String value) {
            addCriterion("parent_code like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotLike(String value) {
            addCriterion("parent_code not like", value, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeIn(List<String> values) {
            addCriterion("parent_code in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotIn(List<String> values) {
            addCriterion("parent_code not in", values, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeBetween(String value1, String value2) {
            addCriterion("parent_code between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andParentCodeNotBetween(String value1, String value2) {
            addCriterion("parent_code not between", value1, value2, "parentCode");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNull() {
            addCriterion("menu_type is null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNotNull() {
            addCriterion("menu_type is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeEqualTo(String value) {
            addCriterion("menu_type =", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotEqualTo(String value) {
            addCriterion("menu_type <>", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThan(String value) {
            addCriterion("menu_type >", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("menu_type >=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThan(String value) {
            addCriterion("menu_type <", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThanOrEqualTo(String value) {
            addCriterion("menu_type <=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLike(String value) {
            addCriterion("menu_type like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotLike(String value) {
            addCriterion("menu_type not like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIn(List<String> values) {
            addCriterion("menu_type in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotIn(List<String> values) {
            addCriterion("menu_type not in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeBetween(String value1, String value2) {
            addCriterion("menu_type between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotBetween(String value1, String value2) {
            addCriterion("menu_type not between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIsNull() {
            addCriterion("menu_level is null");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIsNotNull() {
            addCriterion("menu_level is not null");
            return (Criteria) this;
        }

        public Criteria andMenuLevelEqualTo(Integer value) {
            addCriterion("menu_level =", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotEqualTo(Integer value) {
            addCriterion("menu_level <>", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelGreaterThan(Integer value) {
            addCriterion("menu_level >", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_level >=", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelLessThan(Integer value) {
            addCriterion("menu_level <", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelLessThanOrEqualTo(Integer value) {
            addCriterion("menu_level <=", value, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelIn(List<Integer> values) {
            addCriterion("menu_level in", values, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotIn(List<Integer> values) {
            addCriterion("menu_level not in", values, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelBetween(Integer value1, Integer value2) {
            addCriterion("menu_level between", value1, value2, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andMenuLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_level not between", value1, value2, "menuLevel");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIsNull() {
            addCriterion("resource_code is null");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIsNotNull() {
            addCriterion("resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andResourceCodeEqualTo(String value) {
            addCriterion("resource_code =", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotEqualTo(String value) {
            addCriterion("resource_code <>", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeGreaterThan(String value) {
            addCriterion("resource_code >", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("resource_code >=", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLessThan(String value) {
            addCriterion("resource_code <", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("resource_code <=", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLike(String value) {
            addCriterion("resource_code like", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotLike(String value) {
            addCriterion("resource_code not like", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIn(List<String> values) {
            addCriterion("resource_code in", values, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotIn(List<String> values) {
            addCriterion("resource_code not in", values, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeBetween(String value1, String value2) {
            addCriterion("resource_code between", value1, value2, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotBetween(String value1, String value2) {
            addCriterion("resource_code not between", value1, value2, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
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
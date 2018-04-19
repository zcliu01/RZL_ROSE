package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SysSecUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSecUserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserDescIsNull() {
            addCriterion("user_desc is null");
            return (Criteria) this;
        }

        public Criteria andUserDescIsNotNull() {
            addCriterion("user_desc is not null");
            return (Criteria) this;
        }

        public Criteria andUserDescEqualTo(String value) {
            addCriterion("user_desc =", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotEqualTo(String value) {
            addCriterion("user_desc <>", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescGreaterThan(String value) {
            addCriterion("user_desc >", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescGreaterThanOrEqualTo(String value) {
            addCriterion("user_desc >=", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLessThan(String value) {
            addCriterion("user_desc <", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLessThanOrEqualTo(String value) {
            addCriterion("user_desc <=", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescLike(String value) {
            addCriterion("user_desc like", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotLike(String value) {
            addCriterion("user_desc not like", value, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescIn(List<String> values) {
            addCriterion("user_desc in", values, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotIn(List<String> values) {
            addCriterion("user_desc not in", values, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescBetween(String value1, String value2) {
            addCriterion("user_desc between", value1, value2, "userDesc");
            return (Criteria) this;
        }

        public Criteria andUserDescNotBetween(String value1, String value2) {
            addCriterion("user_desc not between", value1, value2, "userDesc");
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
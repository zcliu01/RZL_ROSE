package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SysSecEmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSecEmpExample() {
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

        public Criteria andEmpCodeIsNull() {
            addCriterion("emp_code is null");
            return (Criteria) this;
        }

        public Criteria andEmpCodeIsNotNull() {
            addCriterion("emp_code is not null");
            return (Criteria) this;
        }

        public Criteria andEmpCodeEqualTo(String value) {
            addCriterion("emp_code =", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeNotEqualTo(String value) {
            addCriterion("emp_code <>", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeGreaterThan(String value) {
            addCriterion("emp_code >", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("emp_code >=", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeLessThan(String value) {
            addCriterion("emp_code <", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeLessThanOrEqualTo(String value) {
            addCriterion("emp_code <=", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeLike(String value) {
            addCriterion("emp_code like", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeNotLike(String value) {
            addCriterion("emp_code not like", value, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeIn(List<String> values) {
            addCriterion("emp_code in", values, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeNotIn(List<String> values) {
            addCriterion("emp_code not in", values, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeBetween(String value1, String value2) {
            addCriterion("emp_code between", value1, value2, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpCodeNotBetween(String value1, String value2) {
            addCriterion("emp_code not between", value1, value2, "empCode");
            return (Criteria) this;
        }

        public Criteria andEmpAccountIsNull() {
            addCriterion("emp_account is null");
            return (Criteria) this;
        }

        public Criteria andEmpAccountIsNotNull() {
            addCriterion("emp_account is not null");
            return (Criteria) this;
        }

        public Criteria andEmpAccountEqualTo(String value) {
            addCriterion("emp_account =", value, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountNotEqualTo(String value) {
            addCriterion("emp_account <>", value, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountGreaterThan(String value) {
            addCriterion("emp_account >", value, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountGreaterThanOrEqualTo(String value) {
            addCriterion("emp_account >=", value, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountLessThan(String value) {
            addCriterion("emp_account <", value, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountLessThanOrEqualTo(String value) {
            addCriterion("emp_account <=", value, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountLike(String value) {
            addCriterion("emp_account like", value, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountNotLike(String value) {
            addCriterion("emp_account not like", value, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountIn(List<String> values) {
            addCriterion("emp_account in", values, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountNotIn(List<String> values) {
            addCriterion("emp_account not in", values, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountBetween(String value1, String value2) {
            addCriterion("emp_account between", value1, value2, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpAccountNotBetween(String value1, String value2) {
            addCriterion("emp_account not between", value1, value2, "empAccount");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordIsNull() {
            addCriterion("emp_password is null");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordIsNotNull() {
            addCriterion("emp_password is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordEqualTo(String value) {
            addCriterion("emp_password =", value, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordNotEqualTo(String value) {
            addCriterion("emp_password <>", value, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordGreaterThan(String value) {
            addCriterion("emp_password >", value, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("emp_password >=", value, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordLessThan(String value) {
            addCriterion("emp_password <", value, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordLessThanOrEqualTo(String value) {
            addCriterion("emp_password <=", value, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordLike(String value) {
            addCriterion("emp_password like", value, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordNotLike(String value) {
            addCriterion("emp_password not like", value, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordIn(List<String> values) {
            addCriterion("emp_password in", values, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordNotIn(List<String> values) {
            addCriterion("emp_password not in", values, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordBetween(String value1, String value2) {
            addCriterion("emp_password between", value1, value2, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpPasswordNotBetween(String value1, String value2) {
            addCriterion("emp_password not between", value1, value2, "empPassword");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("emp_name like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("emp_name not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNull() {
            addCriterion("emp_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNotNull() {
            addCriterion("emp_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSexEqualTo(String value) {
            addCriterion("emp_sex =", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotEqualTo(String value) {
            addCriterion("emp_sex <>", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThan(String value) {
            addCriterion("emp_sex >", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThanOrEqualTo(String value) {
            addCriterion("emp_sex >=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThan(String value) {
            addCriterion("emp_sex <", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThanOrEqualTo(String value) {
            addCriterion("emp_sex <=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLike(String value) {
            addCriterion("emp_sex like", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotLike(String value) {
            addCriterion("emp_sex not like", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexIn(List<String> values) {
            addCriterion("emp_sex in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotIn(List<String> values) {
            addCriterion("emp_sex not in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexBetween(String value1, String value2) {
            addCriterion("emp_sex between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotBetween(String value1, String value2) {
            addCriterion("emp_sex not between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNull() {
            addCriterion("emp_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNotNull() {
            addCriterion("emp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneEqualTo(String value) {
            addCriterion("emp_phone =", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotEqualTo(String value) {
            addCriterion("emp_phone <>", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThan(String value) {
            addCriterion("emp_phone >", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("emp_phone >=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThan(String value) {
            addCriterion("emp_phone <", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThanOrEqualTo(String value) {
            addCriterion("emp_phone <=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLike(String value) {
            addCriterion("emp_phone like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotLike(String value) {
            addCriterion("emp_phone not like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIn(List<String> values) {
            addCriterion("emp_phone in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotIn(List<String> values) {
            addCriterion("emp_phone not in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneBetween(String value1, String value2) {
            addCriterion("emp_phone between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotBetween(String value1, String value2) {
            addCriterion("emp_phone not between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneIsNull() {
            addCriterion("emp_mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneIsNotNull() {
            addCriterion("emp_mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneEqualTo(String value) {
            addCriterion("emp_mobile_phone =", value, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneNotEqualTo(String value) {
            addCriterion("emp_mobile_phone <>", value, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneGreaterThan(String value) {
            addCriterion("emp_mobile_phone >", value, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("emp_mobile_phone >=", value, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneLessThan(String value) {
            addCriterion("emp_mobile_phone <", value, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("emp_mobile_phone <=", value, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneLike(String value) {
            addCriterion("emp_mobile_phone like", value, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneNotLike(String value) {
            addCriterion("emp_mobile_phone not like", value, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneIn(List<String> values) {
            addCriterion("emp_mobile_phone in", values, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneNotIn(List<String> values) {
            addCriterion("emp_mobile_phone not in", values, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneBetween(String value1, String value2) {
            addCriterion("emp_mobile_phone between", value1, value2, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("emp_mobile_phone not between", value1, value2, "empMobilePhone");
            return (Criteria) this;
        }

        public Criteria andEmpFaxIsNull() {
            addCriterion("emp_fax is null");
            return (Criteria) this;
        }

        public Criteria andEmpFaxIsNotNull() {
            addCriterion("emp_fax is not null");
            return (Criteria) this;
        }

        public Criteria andEmpFaxEqualTo(String value) {
            addCriterion("emp_fax =", value, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxNotEqualTo(String value) {
            addCriterion("emp_fax <>", value, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxGreaterThan(String value) {
            addCriterion("emp_fax >", value, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxGreaterThanOrEqualTo(String value) {
            addCriterion("emp_fax >=", value, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxLessThan(String value) {
            addCriterion("emp_fax <", value, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxLessThanOrEqualTo(String value) {
            addCriterion("emp_fax <=", value, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxLike(String value) {
            addCriterion("emp_fax like", value, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxNotLike(String value) {
            addCriterion("emp_fax not like", value, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxIn(List<String> values) {
            addCriterion("emp_fax in", values, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxNotIn(List<String> values) {
            addCriterion("emp_fax not in", values, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxBetween(String value1, String value2) {
            addCriterion("emp_fax between", value1, value2, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpFaxNotBetween(String value1, String value2) {
            addCriterion("emp_fax not between", value1, value2, "empFax");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIsNull() {
            addCriterion("emp_email is null");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIsNotNull() {
            addCriterion("emp_email is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEmailEqualTo(String value) {
            addCriterion("emp_email =", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotEqualTo(String value) {
            addCriterion("emp_email <>", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailGreaterThan(String value) {
            addCriterion("emp_email >", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailGreaterThanOrEqualTo(String value) {
            addCriterion("emp_email >=", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLessThan(String value) {
            addCriterion("emp_email <", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLessThanOrEqualTo(String value) {
            addCriterion("emp_email <=", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLike(String value) {
            addCriterion("emp_email like", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotLike(String value) {
            addCriterion("emp_email not like", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIn(List<String> values) {
            addCriterion("emp_email in", values, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotIn(List<String> values) {
            addCriterion("emp_email not in", values, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailBetween(String value1, String value2) {
            addCriterion("emp_email between", value1, value2, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotBetween(String value1, String value2) {
            addCriterion("emp_email not between", value1, value2, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIsNull() {
            addCriterion("emp_birthday is null");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIsNotNull() {
            addCriterion("emp_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayEqualTo(String value) {
            addCriterion("emp_birthday =", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotEqualTo(String value) {
            addCriterion("emp_birthday <>", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayGreaterThan(String value) {
            addCriterion("emp_birthday >", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("emp_birthday >=", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayLessThan(String value) {
            addCriterion("emp_birthday <", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayLessThanOrEqualTo(String value) {
            addCriterion("emp_birthday <=", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayLike(String value) {
            addCriterion("emp_birthday like", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotLike(String value) {
            addCriterion("emp_birthday not like", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIn(List<String> values) {
            addCriterion("emp_birthday in", values, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotIn(List<String> values) {
            addCriterion("emp_birthday not in", values, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayBetween(String value1, String value2) {
            addCriterion("emp_birthday between", value1, value2, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotBetween(String value1, String value2) {
            addCriterion("emp_birthday not between", value1, value2, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNull() {
            addCriterion("emp_address is null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNotNull() {
            addCriterion("emp_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressEqualTo(String value) {
            addCriterion("emp_address =", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotEqualTo(String value) {
            addCriterion("emp_address <>", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThan(String value) {
            addCriterion("emp_address >", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("emp_address >=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThan(String value) {
            addCriterion("emp_address <", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThanOrEqualTo(String value) {
            addCriterion("emp_address <=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLike(String value) {
            addCriterion("emp_address like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotLike(String value) {
            addCriterion("emp_address not like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIn(List<String> values) {
            addCriterion("emp_address in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotIn(List<String> values) {
            addCriterion("emp_address not in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressBetween(String value1, String value2) {
            addCriterion("emp_address between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotBetween(String value1, String value2) {
            addCriterion("emp_address not between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeIsNull() {
            addCriterion("emp_postcode is null");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeIsNotNull() {
            addCriterion("emp_postcode is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeEqualTo(String value) {
            addCriterion("emp_postcode =", value, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeNotEqualTo(String value) {
            addCriterion("emp_postcode <>", value, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeGreaterThan(String value) {
            addCriterion("emp_postcode >", value, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("emp_postcode >=", value, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeLessThan(String value) {
            addCriterion("emp_postcode <", value, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeLessThanOrEqualTo(String value) {
            addCriterion("emp_postcode <=", value, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeLike(String value) {
            addCriterion("emp_postcode like", value, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeNotLike(String value) {
            addCriterion("emp_postcode not like", value, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeIn(List<String> values) {
            addCriterion("emp_postcode in", values, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeNotIn(List<String> values) {
            addCriterion("emp_postcode not in", values, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeBetween(String value1, String value2) {
            addCriterion("emp_postcode between", value1, value2, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpPostcodeNotBetween(String value1, String value2) {
            addCriterion("emp_postcode not between", value1, value2, "empPostcode");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressIsNull() {
            addCriterion("emp_work_address is null");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressIsNotNull() {
            addCriterion("emp_work_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressEqualTo(String value) {
            addCriterion("emp_work_address =", value, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressNotEqualTo(String value) {
            addCriterion("emp_work_address <>", value, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressGreaterThan(String value) {
            addCriterion("emp_work_address >", value, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("emp_work_address >=", value, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressLessThan(String value) {
            addCriterion("emp_work_address <", value, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressLessThanOrEqualTo(String value) {
            addCriterion("emp_work_address <=", value, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressLike(String value) {
            addCriterion("emp_work_address like", value, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressNotLike(String value) {
            addCriterion("emp_work_address not like", value, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressIn(List<String> values) {
            addCriterion("emp_work_address in", values, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressNotIn(List<String> values) {
            addCriterion("emp_work_address not in", values, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressBetween(String value1, String value2) {
            addCriterion("emp_work_address between", value1, value2, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpWorkAddressNotBetween(String value1, String value2) {
            addCriterion("emp_work_address not between", value1, value2, "empWorkAddress");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoIsNull() {
            addCriterion("emp_head_photo is null");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoIsNotNull() {
            addCriterion("emp_head_photo is not null");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoEqualTo(String value) {
            addCriterion("emp_head_photo =", value, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoNotEqualTo(String value) {
            addCriterion("emp_head_photo <>", value, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoGreaterThan(String value) {
            addCriterion("emp_head_photo >", value, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("emp_head_photo >=", value, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoLessThan(String value) {
            addCriterion("emp_head_photo <", value, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoLessThanOrEqualTo(String value) {
            addCriterion("emp_head_photo <=", value, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoLike(String value) {
            addCriterion("emp_head_photo like", value, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoNotLike(String value) {
            addCriterion("emp_head_photo not like", value, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoIn(List<String> values) {
            addCriterion("emp_head_photo in", values, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoNotIn(List<String> values) {
            addCriterion("emp_head_photo not in", values, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoBetween(String value1, String value2) {
            addCriterion("emp_head_photo between", value1, value2, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpHeadPhotoNotBetween(String value1, String value2) {
            addCriterion("emp_head_photo not between", value1, value2, "empHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andEmpDescIsNull() {
            addCriterion("emp_desc is null");
            return (Criteria) this;
        }

        public Criteria andEmpDescIsNotNull() {
            addCriterion("emp_desc is not null");
            return (Criteria) this;
        }

        public Criteria andEmpDescEqualTo(String value) {
            addCriterion("emp_desc =", value, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescNotEqualTo(String value) {
            addCriterion("emp_desc <>", value, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescGreaterThan(String value) {
            addCriterion("emp_desc >", value, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescGreaterThanOrEqualTo(String value) {
            addCriterion("emp_desc >=", value, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescLessThan(String value) {
            addCriterion("emp_desc <", value, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescLessThanOrEqualTo(String value) {
            addCriterion("emp_desc <=", value, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescLike(String value) {
            addCriterion("emp_desc like", value, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescNotLike(String value) {
            addCriterion("emp_desc not like", value, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescIn(List<String> values) {
            addCriterion("emp_desc in", values, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescNotIn(List<String> values) {
            addCriterion("emp_desc not in", values, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescBetween(String value1, String value2) {
            addCriterion("emp_desc between", value1, value2, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpDescNotBetween(String value1, String value2) {
            addCriterion("emp_desc not between", value1, value2, "empDesc");
            return (Criteria) this;
        }

        public Criteria andEmpOrderIsNull() {
            addCriterion("emp_order is null");
            return (Criteria) this;
        }

        public Criteria andEmpOrderIsNotNull() {
            addCriterion("emp_order is not null");
            return (Criteria) this;
        }

        public Criteria andEmpOrderEqualTo(Integer value) {
            addCriterion("emp_order =", value, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderNotEqualTo(Integer value) {
            addCriterion("emp_order <>", value, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderGreaterThan(Integer value) {
            addCriterion("emp_order >", value, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_order >=", value, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderLessThan(Integer value) {
            addCriterion("emp_order <", value, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderLessThanOrEqualTo(Integer value) {
            addCriterion("emp_order <=", value, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderIn(List<Integer> values) {
            addCriterion("emp_order in", values, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderNotIn(List<Integer> values) {
            addCriterion("emp_order not in", values, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderBetween(Integer value1, Integer value2) {
            addCriterion("emp_order between", value1, value2, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_order not between", value1, value2, "empOrder");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledIsNull() {
            addCriterion("emp_enabled is null");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledIsNotNull() {
            addCriterion("emp_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledEqualTo(String value) {
            addCriterion("emp_enabled =", value, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledNotEqualTo(String value) {
            addCriterion("emp_enabled <>", value, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledGreaterThan(String value) {
            addCriterion("emp_enabled >", value, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("emp_enabled >=", value, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledLessThan(String value) {
            addCriterion("emp_enabled <", value, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledLessThanOrEqualTo(String value) {
            addCriterion("emp_enabled <=", value, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledLike(String value) {
            addCriterion("emp_enabled like", value, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledNotLike(String value) {
            addCriterion("emp_enabled not like", value, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledIn(List<String> values) {
            addCriterion("emp_enabled in", values, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledNotIn(List<String> values) {
            addCriterion("emp_enabled not in", values, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledBetween(String value1, String value2) {
            addCriterion("emp_enabled between", value1, value2, "empEnabled");
            return (Criteria) this;
        }

        public Criteria andEmpEnabledNotBetween(String value1, String value2) {
            addCriterion("emp_enabled not between", value1, value2, "empEnabled");
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

        public Criteria andEntryTimeIsNull() {
            addCriterion("entry_time is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNotNull() {
            addCriterion("entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeEqualTo(String value) {
            addCriterion("entry_time =", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotEqualTo(String value) {
            addCriterion("entry_time <>", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThan(String value) {
            addCriterion("entry_time >", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("entry_time >=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThan(String value) {
            addCriterion("entry_time <", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThanOrEqualTo(String value) {
            addCriterion("entry_time <=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLike(String value) {
            addCriterion("entry_time like", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotLike(String value) {
            addCriterion("entry_time not like", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIn(List<String> values) {
            addCriterion("entry_time in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotIn(List<String> values) {
            addCriterion("entry_time not in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeBetween(String value1, String value2) {
            addCriterion("entry_time between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotBetween(String value1, String value2) {
            addCriterion("entry_time not between", value1, value2, "entryTime");
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

        public Criteria andOperFlagIsNull() {
            addCriterion("oper_flag is null");
            return (Criteria) this;
        }

        public Criteria andOperFlagIsNotNull() {
            addCriterion("oper_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOperFlagEqualTo(String value) {
            addCriterion("oper_flag =", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagNotEqualTo(String value) {
            addCriterion("oper_flag <>", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagGreaterThan(String value) {
            addCriterion("oper_flag >", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagGreaterThanOrEqualTo(String value) {
            addCriterion("oper_flag >=", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagLessThan(String value) {
            addCriterion("oper_flag <", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagLessThanOrEqualTo(String value) {
            addCriterion("oper_flag <=", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagLike(String value) {
            addCriterion("oper_flag like", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagNotLike(String value) {
            addCriterion("oper_flag not like", value, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagIn(List<String> values) {
            addCriterion("oper_flag in", values, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagNotIn(List<String> values) {
            addCriterion("oper_flag not in", values, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagBetween(String value1, String value2) {
            addCriterion("oper_flag between", value1, value2, "operFlag");
            return (Criteria) this;
        }

        public Criteria andOperFlagNotBetween(String value1, String value2) {
            addCriterion("oper_flag not between", value1, value2, "operFlag");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVIsNull() {
            addCriterion("emp_mobile_v is null");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVIsNotNull() {
            addCriterion("emp_mobile_v is not null");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVEqualTo(String value) {
            addCriterion("emp_mobile_v =", value, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVNotEqualTo(String value) {
            addCriterion("emp_mobile_v <>", value, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVGreaterThan(String value) {
            addCriterion("emp_mobile_v >", value, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVGreaterThanOrEqualTo(String value) {
            addCriterion("emp_mobile_v >=", value, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVLessThan(String value) {
            addCriterion("emp_mobile_v <", value, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVLessThanOrEqualTo(String value) {
            addCriterion("emp_mobile_v <=", value, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVLike(String value) {
            addCriterion("emp_mobile_v like", value, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVNotLike(String value) {
            addCriterion("emp_mobile_v not like", value, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVIn(List<String> values) {
            addCriterion("emp_mobile_v in", values, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVNotIn(List<String> values) {
            addCriterion("emp_mobile_v not in", values, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVBetween(String value1, String value2) {
            addCriterion("emp_mobile_v between", value1, value2, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpMobileVNotBetween(String value1, String value2) {
            addCriterion("emp_mobile_v not between", value1, value2, "empMobileV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVIsNull() {
            addCriterion("emp_email_v is null");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVIsNotNull() {
            addCriterion("emp_email_v is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVEqualTo(String value) {
            addCriterion("emp_email_v =", value, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVNotEqualTo(String value) {
            addCriterion("emp_email_v <>", value, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVGreaterThan(String value) {
            addCriterion("emp_email_v >", value, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVGreaterThanOrEqualTo(String value) {
            addCriterion("emp_email_v >=", value, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVLessThan(String value) {
            addCriterion("emp_email_v <", value, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVLessThanOrEqualTo(String value) {
            addCriterion("emp_email_v <=", value, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVLike(String value) {
            addCriterion("emp_email_v like", value, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVNotLike(String value) {
            addCriterion("emp_email_v not like", value, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVIn(List<String> values) {
            addCriterion("emp_email_v in", values, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVNotIn(List<String> values) {
            addCriterion("emp_email_v not in", values, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVBetween(String value1, String value2) {
            addCriterion("emp_email_v between", value1, value2, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpEmailVNotBetween(String value1, String value2) {
            addCriterion("emp_email_v not between", value1, value2, "empEmailV");
            return (Criteria) this;
        }

        public Criteria andEmpActiveIsNull() {
            addCriterion("emp_active is null");
            return (Criteria) this;
        }

        public Criteria andEmpActiveIsNotNull() {
            addCriterion("emp_active is not null");
            return (Criteria) this;
        }

        public Criteria andEmpActiveEqualTo(String value) {
            addCriterion("emp_active =", value, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveNotEqualTo(String value) {
            addCriterion("emp_active <>", value, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveGreaterThan(String value) {
            addCriterion("emp_active >", value, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveGreaterThanOrEqualTo(String value) {
            addCriterion("emp_active >=", value, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveLessThan(String value) {
            addCriterion("emp_active <", value, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveLessThanOrEqualTo(String value) {
            addCriterion("emp_active <=", value, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveLike(String value) {
            addCriterion("emp_active like", value, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveNotLike(String value) {
            addCriterion("emp_active not like", value, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveIn(List<String> values) {
            addCriterion("emp_active in", values, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveNotIn(List<String> values) {
            addCriterion("emp_active not in", values, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveBetween(String value1, String value2) {
            addCriterion("emp_active between", value1, value2, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpActiveNotBetween(String value1, String value2) {
            addCriterion("emp_active not between", value1, value2, "empActive");
            return (Criteria) this;
        }

        public Criteria andEmpMessageIsNull() {
            addCriterion("emp_message is null");
            return (Criteria) this;
        }

        public Criteria andEmpMessageIsNotNull() {
            addCriterion("emp_message is not null");
            return (Criteria) this;
        }

        public Criteria andEmpMessageEqualTo(String value) {
            addCriterion("emp_message =", value, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageNotEqualTo(String value) {
            addCriterion("emp_message <>", value, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageGreaterThan(String value) {
            addCriterion("emp_message >", value, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageGreaterThanOrEqualTo(String value) {
            addCriterion("emp_message >=", value, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageLessThan(String value) {
            addCriterion("emp_message <", value, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageLessThanOrEqualTo(String value) {
            addCriterion("emp_message <=", value, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageLike(String value) {
            addCriterion("emp_message like", value, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageNotLike(String value) {
            addCriterion("emp_message not like", value, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageIn(List<String> values) {
            addCriterion("emp_message in", values, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageNotIn(List<String> values) {
            addCriterion("emp_message not in", values, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageBetween(String value1, String value2) {
            addCriterion("emp_message between", value1, value2, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpMessageNotBetween(String value1, String value2) {
            addCriterion("emp_message not between", value1, value2, "empMessage");
            return (Criteria) this;
        }

        public Criteria andEmpSlIsNull() {
            addCriterion("emp_sl is null");
            return (Criteria) this;
        }

        public Criteria andEmpSlIsNotNull() {
            addCriterion("emp_sl is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSlEqualTo(String value) {
            addCriterion("emp_sl =", value, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlNotEqualTo(String value) {
            addCriterion("emp_sl <>", value, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlGreaterThan(String value) {
            addCriterion("emp_sl >", value, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlGreaterThanOrEqualTo(String value) {
            addCriterion("emp_sl >=", value, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlLessThan(String value) {
            addCriterion("emp_sl <", value, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlLessThanOrEqualTo(String value) {
            addCriterion("emp_sl <=", value, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlLike(String value) {
            addCriterion("emp_sl like", value, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlNotLike(String value) {
            addCriterion("emp_sl not like", value, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlIn(List<String> values) {
            addCriterion("emp_sl in", values, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlNotIn(List<String> values) {
            addCriterion("emp_sl not in", values, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlBetween(String value1, String value2) {
            addCriterion("emp_sl between", value1, value2, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpSlNotBetween(String value1, String value2) {
            addCriterion("emp_sl not between", value1, value2, "empSl");
            return (Criteria) this;
        }

        public Criteria andEmpPyIsNull() {
            addCriterion("emp_py is null");
            return (Criteria) this;
        }

        public Criteria andEmpPyIsNotNull() {
            addCriterion("emp_py is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPyEqualTo(String value) {
            addCriterion("emp_py =", value, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyNotEqualTo(String value) {
            addCriterion("emp_py <>", value, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyGreaterThan(String value) {
            addCriterion("emp_py >", value, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyGreaterThanOrEqualTo(String value) {
            addCriterion("emp_py >=", value, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyLessThan(String value) {
            addCriterion("emp_py <", value, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyLessThanOrEqualTo(String value) {
            addCriterion("emp_py <=", value, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyLike(String value) {
            addCriterion("emp_py like", value, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyNotLike(String value) {
            addCriterion("emp_py not like", value, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyIn(List<String> values) {
            addCriterion("emp_py in", values, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyNotIn(List<String> values) {
            addCriterion("emp_py not in", values, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyBetween(String value1, String value2) {
            addCriterion("emp_py between", value1, value2, "empPy");
            return (Criteria) this;
        }

        public Criteria andEmpPyNotBetween(String value1, String value2) {
            addCriterion("emp_py not between", value1, value2, "empPy");
            return (Criteria) this;
        }

        public Criteria andCerTypeIsNull() {
            addCriterion("cer_type is null");
            return (Criteria) this;
        }

        public Criteria andCerTypeIsNotNull() {
            addCriterion("cer_type is not null");
            return (Criteria) this;
        }

        public Criteria andCerTypeEqualTo(String value) {
            addCriterion("cer_type =", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeNotEqualTo(String value) {
            addCriterion("cer_type <>", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeGreaterThan(String value) {
            addCriterion("cer_type >", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cer_type >=", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeLessThan(String value) {
            addCriterion("cer_type <", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeLessThanOrEqualTo(String value) {
            addCriterion("cer_type <=", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeLike(String value) {
            addCriterion("cer_type like", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeNotLike(String value) {
            addCriterion("cer_type not like", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeIn(List<String> values) {
            addCriterion("cer_type in", values, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeNotIn(List<String> values) {
            addCriterion("cer_type not in", values, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeBetween(String value1, String value2) {
            addCriterion("cer_type between", value1, value2, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeNotBetween(String value1, String value2) {
            addCriterion("cer_type not between", value1, value2, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerNoIsNull() {
            addCriterion("cer_no is null");
            return (Criteria) this;
        }

        public Criteria andCerNoIsNotNull() {
            addCriterion("cer_no is not null");
            return (Criteria) this;
        }

        public Criteria andCerNoEqualTo(String value) {
            addCriterion("cer_no =", value, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoNotEqualTo(String value) {
            addCriterion("cer_no <>", value, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoGreaterThan(String value) {
            addCriterion("cer_no >", value, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoGreaterThanOrEqualTo(String value) {
            addCriterion("cer_no >=", value, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoLessThan(String value) {
            addCriterion("cer_no <", value, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoLessThanOrEqualTo(String value) {
            addCriterion("cer_no <=", value, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoLike(String value) {
            addCriterion("cer_no like", value, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoNotLike(String value) {
            addCriterion("cer_no not like", value, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoIn(List<String> values) {
            addCriterion("cer_no in", values, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoNotIn(List<String> values) {
            addCriterion("cer_no not in", values, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoBetween(String value1, String value2) {
            addCriterion("cer_no between", value1, value2, "cerNo");
            return (Criteria) this;
        }

        public Criteria andCerNoNotBetween(String value1, String value2) {
            addCriterion("cer_no not between", value1, value2, "cerNo");
            return (Criteria) this;
        }

        public Criteria andSynFlagIsNull() {
            addCriterion("syn_flag is null");
            return (Criteria) this;
        }

        public Criteria andSynFlagIsNotNull() {
            addCriterion("syn_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSynFlagEqualTo(String value) {
            addCriterion("syn_flag =", value, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagNotEqualTo(String value) {
            addCriterion("syn_flag <>", value, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagGreaterThan(String value) {
            addCriterion("syn_flag >", value, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagGreaterThanOrEqualTo(String value) {
            addCriterion("syn_flag >=", value, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagLessThan(String value) {
            addCriterion("syn_flag <", value, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagLessThanOrEqualTo(String value) {
            addCriterion("syn_flag <=", value, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagLike(String value) {
            addCriterion("syn_flag like", value, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagNotLike(String value) {
            addCriterion("syn_flag not like", value, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagIn(List<String> values) {
            addCriterion("syn_flag in", values, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagNotIn(List<String> values) {
            addCriterion("syn_flag not in", values, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagBetween(String value1, String value2) {
            addCriterion("syn_flag between", value1, value2, "synFlag");
            return (Criteria) this;
        }

        public Criteria andSynFlagNotBetween(String value1, String value2) {
            addCriterion("syn_flag not between", value1, value2, "synFlag");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameIsNull() {
            addCriterion("alias_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameIsNotNull() {
            addCriterion("alias_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameEqualTo(String value) {
            addCriterion("alias_emp_name =", value, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameNotEqualTo(String value) {
            addCriterion("alias_emp_name <>", value, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameGreaterThan(String value) {
            addCriterion("alias_emp_name >", value, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("alias_emp_name >=", value, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameLessThan(String value) {
            addCriterion("alias_emp_name <", value, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameLessThanOrEqualTo(String value) {
            addCriterion("alias_emp_name <=", value, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameLike(String value) {
            addCriterion("alias_emp_name like", value, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameNotLike(String value) {
            addCriterion("alias_emp_name not like", value, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameIn(List<String> values) {
            addCriterion("alias_emp_name in", values, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameNotIn(List<String> values) {
            addCriterion("alias_emp_name not in", values, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameBetween(String value1, String value2) {
            addCriterion("alias_emp_name between", value1, value2, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andAliasEmpNameNotBetween(String value1, String value2) {
            addCriterion("alias_emp_name not between", value1, value2, "aliasEmpName");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailIsNull() {
            addCriterion("emp_order_mail is null");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailIsNotNull() {
            addCriterion("emp_order_mail is not null");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailEqualTo(Integer value) {
            addCriterion("emp_order_mail =", value, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailNotEqualTo(Integer value) {
            addCriterion("emp_order_mail <>", value, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailGreaterThan(Integer value) {
            addCriterion("emp_order_mail >", value, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_order_mail >=", value, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailLessThan(Integer value) {
            addCriterion("emp_order_mail <", value, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailLessThanOrEqualTo(Integer value) {
            addCriterion("emp_order_mail <=", value, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailIn(List<Integer> values) {
            addCriterion("emp_order_mail in", values, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailNotIn(List<Integer> values) {
            addCriterion("emp_order_mail not in", values, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailBetween(Integer value1, Integer value2) {
            addCriterion("emp_order_mail between", value1, value2, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andEmpOrderMailNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_order_mail not between", value1, value2, "empOrderMail");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeIsNull() {
            addCriterion("can_login_type is null");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeIsNotNull() {
            addCriterion("can_login_type is not null");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeEqualTo(Integer value) {
            addCriterion("can_login_type =", value, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeNotEqualTo(Integer value) {
            addCriterion("can_login_type <>", value, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeGreaterThan(Integer value) {
            addCriterion("can_login_type >", value, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_login_type >=", value, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeLessThan(Integer value) {
            addCriterion("can_login_type <", value, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeLessThanOrEqualTo(Integer value) {
            addCriterion("can_login_type <=", value, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeIn(List<Integer> values) {
            addCriterion("can_login_type in", values, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeNotIn(List<Integer> values) {
            addCriterion("can_login_type not in", values, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeBetween(Integer value1, Integer value2) {
            addCriterion("can_login_type between", value1, value2, "canLoginType");
            return (Criteria) this;
        }

        public Criteria andCanLoginTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("can_login_type not between", value1, value2, "canLoginType");
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
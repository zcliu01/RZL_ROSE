package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class SysInfoInvoiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysInfoInvoiceExample() {
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

        public Criteria andTitileNameIsNull() {
            addCriterion("titile_name is null");
            return (Criteria) this;
        }

        public Criteria andTitileNameIsNotNull() {
            addCriterion("titile_name is not null");
            return (Criteria) this;
        }

        public Criteria andTitileNameEqualTo(String value) {
            addCriterion("titile_name =", value, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameNotEqualTo(String value) {
            addCriterion("titile_name <>", value, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameGreaterThan(String value) {
            addCriterion("titile_name >", value, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameGreaterThanOrEqualTo(String value) {
            addCriterion("titile_name >=", value, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameLessThan(String value) {
            addCriterion("titile_name <", value, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameLessThanOrEqualTo(String value) {
            addCriterion("titile_name <=", value, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameLike(String value) {
            addCriterion("titile_name like", value, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameNotLike(String value) {
            addCriterion("titile_name not like", value, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameIn(List<String> values) {
            addCriterion("titile_name in", values, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameNotIn(List<String> values) {
            addCriterion("titile_name not in", values, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameBetween(String value1, String value2) {
            addCriterion("titile_name between", value1, value2, "titileName");
            return (Criteria) this;
        }

        public Criteria andTitileNameNotBetween(String value1, String value2) {
            addCriterion("titile_name not between", value1, value2, "titileName");
            return (Criteria) this;
        }

        public Criteria andInCodeIsNull() {
            addCriterion("in_code is null");
            return (Criteria) this;
        }

        public Criteria andInCodeIsNotNull() {
            addCriterion("in_code is not null");
            return (Criteria) this;
        }

        public Criteria andInCodeEqualTo(String value) {
            addCriterion("in_code =", value, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeNotEqualTo(String value) {
            addCriterion("in_code <>", value, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeGreaterThan(String value) {
            addCriterion("in_code >", value, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeGreaterThanOrEqualTo(String value) {
            addCriterion("in_code >=", value, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeLessThan(String value) {
            addCriterion("in_code <", value, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeLessThanOrEqualTo(String value) {
            addCriterion("in_code <=", value, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeLike(String value) {
            addCriterion("in_code like", value, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeNotLike(String value) {
            addCriterion("in_code not like", value, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeIn(List<String> values) {
            addCriterion("in_code in", values, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeNotIn(List<String> values) {
            addCriterion("in_code not in", values, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeBetween(String value1, String value2) {
            addCriterion("in_code between", value1, value2, "inCode");
            return (Criteria) this;
        }

        public Criteria andInCodeNotBetween(String value1, String value2) {
            addCriterion("in_code not between", value1, value2, "inCode");
            return (Criteria) this;
        }

        public Criteria andComAddressIsNull() {
            addCriterion("com_address is null");
            return (Criteria) this;
        }

        public Criteria andComAddressIsNotNull() {
            addCriterion("com_address is not null");
            return (Criteria) this;
        }

        public Criteria andComAddressEqualTo(String value) {
            addCriterion("com_address =", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotEqualTo(String value) {
            addCriterion("com_address <>", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressGreaterThan(String value) {
            addCriterion("com_address >", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressGreaterThanOrEqualTo(String value) {
            addCriterion("com_address >=", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLessThan(String value) {
            addCriterion("com_address <", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLessThanOrEqualTo(String value) {
            addCriterion("com_address <=", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLike(String value) {
            addCriterion("com_address like", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotLike(String value) {
            addCriterion("com_address not like", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressIn(List<String> values) {
            addCriterion("com_address in", values, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotIn(List<String> values) {
            addCriterion("com_address not in", values, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressBetween(String value1, String value2) {
            addCriterion("com_address between", value1, value2, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotBetween(String value1, String value2) {
            addCriterion("com_address not between", value1, value2, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNull() {
            addCriterion("com_phone is null");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNotNull() {
            addCriterion("com_phone is not null");
            return (Criteria) this;
        }

        public Criteria andComPhoneEqualTo(String value) {
            addCriterion("com_phone =", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotEqualTo(String value) {
            addCriterion("com_phone <>", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThan(String value) {
            addCriterion("com_phone >", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("com_phone >=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThan(String value) {
            addCriterion("com_phone <", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThanOrEqualTo(String value) {
            addCriterion("com_phone <=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLike(String value) {
            addCriterion("com_phone like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotLike(String value) {
            addCriterion("com_phone not like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneIn(List<String> values) {
            addCriterion("com_phone in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotIn(List<String> values) {
            addCriterion("com_phone not in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneBetween(String value1, String value2) {
            addCriterion("com_phone between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotBetween(String value1, String value2) {
            addCriterion("com_phone not between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andAccBankIsNull() {
            addCriterion("acc_bank is null");
            return (Criteria) this;
        }

        public Criteria andAccBankIsNotNull() {
            addCriterion("acc_bank is not null");
            return (Criteria) this;
        }

        public Criteria andAccBankEqualTo(String value) {
            addCriterion("acc_bank =", value, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankNotEqualTo(String value) {
            addCriterion("acc_bank <>", value, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankGreaterThan(String value) {
            addCriterion("acc_bank >", value, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankGreaterThanOrEqualTo(String value) {
            addCriterion("acc_bank >=", value, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankLessThan(String value) {
            addCriterion("acc_bank <", value, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankLessThanOrEqualTo(String value) {
            addCriterion("acc_bank <=", value, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankLike(String value) {
            addCriterion("acc_bank like", value, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankNotLike(String value) {
            addCriterion("acc_bank not like", value, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankIn(List<String> values) {
            addCriterion("acc_bank in", values, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankNotIn(List<String> values) {
            addCriterion("acc_bank not in", values, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankBetween(String value1, String value2) {
            addCriterion("acc_bank between", value1, value2, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccBankNotBetween(String value1, String value2) {
            addCriterion("acc_bank not between", value1, value2, "accBank");
            return (Criteria) this;
        }

        public Criteria andAccNoIsNull() {
            addCriterion("acc_no is null");
            return (Criteria) this;
        }

        public Criteria andAccNoIsNotNull() {
            addCriterion("acc_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccNoEqualTo(String value) {
            addCriterion("acc_no =", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoNotEqualTo(String value) {
            addCriterion("acc_no <>", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoGreaterThan(String value) {
            addCriterion("acc_no >", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoGreaterThanOrEqualTo(String value) {
            addCriterion("acc_no >=", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoLessThan(String value) {
            addCriterion("acc_no <", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoLessThanOrEqualTo(String value) {
            addCriterion("acc_no <=", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoLike(String value) {
            addCriterion("acc_no like", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoNotLike(String value) {
            addCriterion("acc_no not like", value, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoIn(List<String> values) {
            addCriterion("acc_no in", values, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoNotIn(List<String> values) {
            addCriterion("acc_no not in", values, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoBetween(String value1, String value2) {
            addCriterion("acc_no between", value1, value2, "accNo");
            return (Criteria) this;
        }

        public Criteria andAccNoNotBetween(String value1, String value2) {
            addCriterion("acc_no not between", value1, value2, "accNo");
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
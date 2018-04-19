package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class PlatInforAccessoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatInforAccessoryExample() {
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

        public Criteria andAccIdIsNull() {
            addCriterion("acc_id is null");
            return (Criteria) this;
        }

        public Criteria andAccIdIsNotNull() {
            addCriterion("acc_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccIdEqualTo(String value) {
            addCriterion("acc_id =", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotEqualTo(String value) {
            addCriterion("acc_id <>", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdGreaterThan(String value) {
            addCriterion("acc_id >", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdGreaterThanOrEqualTo(String value) {
            addCriterion("acc_id >=", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdLessThan(String value) {
            addCriterion("acc_id <", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdLessThanOrEqualTo(String value) {
            addCriterion("acc_id <=", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdLike(String value) {
            addCriterion("acc_id like", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotLike(String value) {
            addCriterion("acc_id not like", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdIn(List<String> values) {
            addCriterion("acc_id in", values, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotIn(List<String> values) {
            addCriterion("acc_id not in", values, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdBetween(String value1, String value2) {
            addCriterion("acc_id between", value1, value2, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotBetween(String value1, String value2) {
            addCriterion("acc_id not between", value1, value2, "accId");
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

        public Criteria andAccAddressIsNull() {
            addCriterion("acc_address is null");
            return (Criteria) this;
        }

        public Criteria andAccAddressIsNotNull() {
            addCriterion("acc_address is not null");
            return (Criteria) this;
        }

        public Criteria andAccAddressEqualTo(String value) {
            addCriterion("acc_address =", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressNotEqualTo(String value) {
            addCriterion("acc_address <>", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressGreaterThan(String value) {
            addCriterion("acc_address >", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressGreaterThanOrEqualTo(String value) {
            addCriterion("acc_address >=", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressLessThan(String value) {
            addCriterion("acc_address <", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressLessThanOrEqualTo(String value) {
            addCriterion("acc_address <=", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressLike(String value) {
            addCriterion("acc_address like", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressNotLike(String value) {
            addCriterion("acc_address not like", value, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressIn(List<String> values) {
            addCriterion("acc_address in", values, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressNotIn(List<String> values) {
            addCriterion("acc_address not in", values, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressBetween(String value1, String value2) {
            addCriterion("acc_address between", value1, value2, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccAddressNotBetween(String value1, String value2) {
            addCriterion("acc_address not between", value1, value2, "accAddress");
            return (Criteria) this;
        }

        public Criteria andAccNameIsNull() {
            addCriterion("acc_name is null");
            return (Criteria) this;
        }

        public Criteria andAccNameIsNotNull() {
            addCriterion("acc_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccNameEqualTo(String value) {
            addCriterion("acc_name =", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameNotEqualTo(String value) {
            addCriterion("acc_name <>", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameGreaterThan(String value) {
            addCriterion("acc_name >", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameGreaterThanOrEqualTo(String value) {
            addCriterion("acc_name >=", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameLessThan(String value) {
            addCriterion("acc_name <", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameLessThanOrEqualTo(String value) {
            addCriterion("acc_name <=", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameLike(String value) {
            addCriterion("acc_name like", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameNotLike(String value) {
            addCriterion("acc_name not like", value, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameIn(List<String> values) {
            addCriterion("acc_name in", values, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameNotIn(List<String> values) {
            addCriterion("acc_name not in", values, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameBetween(String value1, String value2) {
            addCriterion("acc_name between", value1, value2, "accName");
            return (Criteria) this;
        }

        public Criteria andAccNameNotBetween(String value1, String value2) {
            addCriterion("acc_name not between", value1, value2, "accName");
            return (Criteria) this;
        }

        public Criteria andAccTypeIsNull() {
            addCriterion("acc_type is null");
            return (Criteria) this;
        }

        public Criteria andAccTypeIsNotNull() {
            addCriterion("acc_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccTypeEqualTo(String value) {
            addCriterion("acc_type =", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotEqualTo(String value) {
            addCriterion("acc_type <>", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeGreaterThan(String value) {
            addCriterion("acc_type >", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeGreaterThanOrEqualTo(String value) {
            addCriterion("acc_type >=", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLessThan(String value) {
            addCriterion("acc_type <", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLessThanOrEqualTo(String value) {
            addCriterion("acc_type <=", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeLike(String value) {
            addCriterion("acc_type like", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotLike(String value) {
            addCriterion("acc_type not like", value, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeIn(List<String> values) {
            addCriterion("acc_type in", values, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotIn(List<String> values) {
            addCriterion("acc_type not in", values, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeBetween(String value1, String value2) {
            addCriterion("acc_type between", value1, value2, "accType");
            return (Criteria) this;
        }

        public Criteria andAccTypeNotBetween(String value1, String value2) {
            addCriterion("acc_type not between", value1, value2, "accType");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("node_id is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(String value) {
            addCriterion("node_id =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(String value) {
            addCriterion("node_id <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(String value) {
            addCriterion("node_id >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("node_id >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(String value) {
            addCriterion("node_id <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(String value) {
            addCriterion("node_id <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLike(String value) {
            addCriterion("node_id like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotLike(String value) {
            addCriterion("node_id not like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<String> values) {
            addCriterion("node_id in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<String> values) {
            addCriterion("node_id not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(String value1, String value2) {
            addCriterion("node_id between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(String value1, String value2) {
            addCriterion("node_id not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andFileOrderIsNull() {
            addCriterion("file_order is null");
            return (Criteria) this;
        }

        public Criteria andFileOrderIsNotNull() {
            addCriterion("file_order is not null");
            return (Criteria) this;
        }

        public Criteria andFileOrderEqualTo(Integer value) {
            addCriterion("file_order =", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderNotEqualTo(Integer value) {
            addCriterion("file_order <>", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderGreaterThan(Integer value) {
            addCriterion("file_order >", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_order >=", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderLessThan(Integer value) {
            addCriterion("file_order <", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderLessThanOrEqualTo(Integer value) {
            addCriterion("file_order <=", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderIn(List<Integer> values) {
            addCriterion("file_order in", values, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderNotIn(List<Integer> values) {
            addCriterion("file_order not in", values, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderBetween(Integer value1, Integer value2) {
            addCriterion("file_order between", value1, value2, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("file_order not between", value1, value2, "fileOrder");
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
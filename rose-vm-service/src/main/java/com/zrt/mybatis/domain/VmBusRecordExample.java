package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class VmBusRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VmBusRecordExample() {
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

        public Criteria andMtTitileIsNull() {
            addCriterion("mt_titile is null");
            return (Criteria) this;
        }

        public Criteria andMtTitileIsNotNull() {
            addCriterion("mt_titile is not null");
            return (Criteria) this;
        }

        public Criteria andMtTitileEqualTo(String value) {
            addCriterion("mt_titile =", value, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileNotEqualTo(String value) {
            addCriterion("mt_titile <>", value, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileGreaterThan(String value) {
            addCriterion("mt_titile >", value, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileGreaterThanOrEqualTo(String value) {
            addCriterion("mt_titile >=", value, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileLessThan(String value) {
            addCriterion("mt_titile <", value, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileLessThanOrEqualTo(String value) {
            addCriterion("mt_titile <=", value, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileLike(String value) {
            addCriterion("mt_titile like", value, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileNotLike(String value) {
            addCriterion("mt_titile not like", value, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileIn(List<String> values) {
            addCriterion("mt_titile in", values, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileNotIn(List<String> values) {
            addCriterion("mt_titile not in", values, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileBetween(String value1, String value2) {
            addCriterion("mt_titile between", value1, value2, "mtTitile");
            return (Criteria) this;
        }

        public Criteria andMtTitileNotBetween(String value1, String value2) {
            addCriterion("mt_titile not between", value1, value2, "mtTitile");
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

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andMtDescIsNull() {
            addCriterion("mt_desc is null");
            return (Criteria) this;
        }

        public Criteria andMtDescIsNotNull() {
            addCriterion("mt_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMtDescEqualTo(String value) {
            addCriterion("mt_desc =", value, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescNotEqualTo(String value) {
            addCriterion("mt_desc <>", value, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescGreaterThan(String value) {
            addCriterion("mt_desc >", value, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescGreaterThanOrEqualTo(String value) {
            addCriterion("mt_desc >=", value, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescLessThan(String value) {
            addCriterion("mt_desc <", value, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescLessThanOrEqualTo(String value) {
            addCriterion("mt_desc <=", value, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescLike(String value) {
            addCriterion("mt_desc like", value, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescNotLike(String value) {
            addCriterion("mt_desc not like", value, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescIn(List<String> values) {
            addCriterion("mt_desc in", values, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescNotIn(List<String> values) {
            addCriterion("mt_desc not in", values, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescBetween(String value1, String value2) {
            addCriterion("mt_desc between", value1, value2, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andMtDescNotBetween(String value1, String value2) {
            addCriterion("mt_desc not between", value1, value2, "mtDesc");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIsNull() {
            addCriterion("notify_type is null");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIsNotNull() {
            addCriterion("notify_type is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeEqualTo(String value) {
            addCriterion("notify_type =", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotEqualTo(String value) {
            addCriterion("notify_type <>", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeGreaterThan(String value) {
            addCriterion("notify_type >", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("notify_type >=", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeLessThan(String value) {
            addCriterion("notify_type <", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeLessThanOrEqualTo(String value) {
            addCriterion("notify_type <=", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeLike(String value) {
            addCriterion("notify_type like", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotLike(String value) {
            addCriterion("notify_type not like", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIn(List<String> values) {
            addCriterion("notify_type in", values, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotIn(List<String> values) {
            addCriterion("notify_type not in", values, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeBetween(String value1, String value2) {
            addCriterion("notify_type between", value1, value2, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotBetween(String value1, String value2) {
            addCriterion("notify_type not between", value1, value2, "notifyType");
            return (Criteria) this;
        }

        public Criteria andMtStatusIsNull() {
            addCriterion("mt_status is null");
            return (Criteria) this;
        }

        public Criteria andMtStatusIsNotNull() {
            addCriterion("mt_status is not null");
            return (Criteria) this;
        }

        public Criteria andMtStatusEqualTo(String value) {
            addCriterion("mt_status =", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusNotEqualTo(String value) {
            addCriterion("mt_status <>", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusGreaterThan(String value) {
            addCriterion("mt_status >", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mt_status >=", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusLessThan(String value) {
            addCriterion("mt_status <", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusLessThanOrEqualTo(String value) {
            addCriterion("mt_status <=", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusLike(String value) {
            addCriterion("mt_status like", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusNotLike(String value) {
            addCriterion("mt_status not like", value, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusIn(List<String> values) {
            addCriterion("mt_status in", values, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusNotIn(List<String> values) {
            addCriterion("mt_status not in", values, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusBetween(String value1, String value2) {
            addCriterion("mt_status between", value1, value2, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andMtStatusNotBetween(String value1, String value2) {
            addCriterion("mt_status not between", value1, value2, "mtStatus");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdIsNull() {
            addCriterion("host_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdIsNotNull() {
            addCriterion("host_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdEqualTo(String value) {
            addCriterion("host_emp_id =", value, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdNotEqualTo(String value) {
            addCriterion("host_emp_id <>", value, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdGreaterThan(String value) {
            addCriterion("host_emp_id >", value, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("host_emp_id >=", value, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdLessThan(String value) {
            addCriterion("host_emp_id <", value, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdLessThanOrEqualTo(String value) {
            addCriterion("host_emp_id <=", value, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdLike(String value) {
            addCriterion("host_emp_id like", value, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdNotLike(String value) {
            addCriterion("host_emp_id not like", value, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdIn(List<String> values) {
            addCriterion("host_emp_id in", values, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdNotIn(List<String> values) {
            addCriterion("host_emp_id not in", values, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdBetween(String value1, String value2) {
            addCriterion("host_emp_id between", value1, value2, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpIdNotBetween(String value1, String value2) {
            addCriterion("host_emp_id not between", value1, value2, "hostEmpId");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameIsNull() {
            addCriterion("host_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameIsNotNull() {
            addCriterion("host_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameEqualTo(String value) {
            addCriterion("host_emp_name =", value, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameNotEqualTo(String value) {
            addCriterion("host_emp_name <>", value, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameGreaterThan(String value) {
            addCriterion("host_emp_name >", value, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("host_emp_name >=", value, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameLessThan(String value) {
            addCriterion("host_emp_name <", value, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameLessThanOrEqualTo(String value) {
            addCriterion("host_emp_name <=", value, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameLike(String value) {
            addCriterion("host_emp_name like", value, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameNotLike(String value) {
            addCriterion("host_emp_name not like", value, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameIn(List<String> values) {
            addCriterion("host_emp_name in", values, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameNotIn(List<String> values) {
            addCriterion("host_emp_name not in", values, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameBetween(String value1, String value2) {
            addCriterion("host_emp_name between", value1, value2, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostEmpNameNotBetween(String value1, String value2) {
            addCriterion("host_emp_name not between", value1, value2, "hostEmpName");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdIsNull() {
            addCriterion("host_org_id is null");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdIsNotNull() {
            addCriterion("host_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdEqualTo(String value) {
            addCriterion("host_org_id =", value, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdNotEqualTo(String value) {
            addCriterion("host_org_id <>", value, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdGreaterThan(String value) {
            addCriterion("host_org_id >", value, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("host_org_id >=", value, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdLessThan(String value) {
            addCriterion("host_org_id <", value, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdLessThanOrEqualTo(String value) {
            addCriterion("host_org_id <=", value, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdLike(String value) {
            addCriterion("host_org_id like", value, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdNotLike(String value) {
            addCriterion("host_org_id not like", value, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdIn(List<String> values) {
            addCriterion("host_org_id in", values, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdNotIn(List<String> values) {
            addCriterion("host_org_id not in", values, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdBetween(String value1, String value2) {
            addCriterion("host_org_id between", value1, value2, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgIdNotBetween(String value1, String value2) {
            addCriterion("host_org_id not between", value1, value2, "hostOrgId");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameIsNull() {
            addCriterion("host_org_name is null");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameIsNotNull() {
            addCriterion("host_org_name is not null");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameEqualTo(String value) {
            addCriterion("host_org_name =", value, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameNotEqualTo(String value) {
            addCriterion("host_org_name <>", value, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameGreaterThan(String value) {
            addCriterion("host_org_name >", value, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("host_org_name >=", value, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameLessThan(String value) {
            addCriterion("host_org_name <", value, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameLessThanOrEqualTo(String value) {
            addCriterion("host_org_name <=", value, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameLike(String value) {
            addCriterion("host_org_name like", value, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameNotLike(String value) {
            addCriterion("host_org_name not like", value, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameIn(List<String> values) {
            addCriterion("host_org_name in", values, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameNotIn(List<String> values) {
            addCriterion("host_org_name not in", values, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameBetween(String value1, String value2) {
            addCriterion("host_org_name between", value1, value2, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andHostOrgNameNotBetween(String value1, String value2) {
            addCriterion("host_org_name not between", value1, value2, "hostOrgName");
            return (Criteria) this;
        }

        public Criteria andMtPwdIsNull() {
            addCriterion("mt_pwd is null");
            return (Criteria) this;
        }

        public Criteria andMtPwdIsNotNull() {
            addCriterion("mt_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andMtPwdEqualTo(String value) {
            addCriterion("mt_pwd =", value, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdNotEqualTo(String value) {
            addCriterion("mt_pwd <>", value, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdGreaterThan(String value) {
            addCriterion("mt_pwd >", value, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdGreaterThanOrEqualTo(String value) {
            addCriterion("mt_pwd >=", value, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdLessThan(String value) {
            addCriterion("mt_pwd <", value, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdLessThanOrEqualTo(String value) {
            addCriterion("mt_pwd <=", value, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdLike(String value) {
            addCriterion("mt_pwd like", value, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdNotLike(String value) {
            addCriterion("mt_pwd not like", value, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdIn(List<String> values) {
            addCriterion("mt_pwd in", values, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdNotIn(List<String> values) {
            addCriterion("mt_pwd not in", values, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdBetween(String value1, String value2) {
            addCriterion("mt_pwd between", value1, value2, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdNotBetween(String value1, String value2) {
            addCriterion("mt_pwd not between", value1, value2, "mtPwd");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagIsNull() {
            addCriterion("mt_pwd_flag is null");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagIsNotNull() {
            addCriterion("mt_pwd_flag is not null");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagEqualTo(String value) {
            addCriterion("mt_pwd_flag =", value, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagNotEqualTo(String value) {
            addCriterion("mt_pwd_flag <>", value, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagGreaterThan(String value) {
            addCriterion("mt_pwd_flag >", value, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagGreaterThanOrEqualTo(String value) {
            addCriterion("mt_pwd_flag >=", value, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagLessThan(String value) {
            addCriterion("mt_pwd_flag <", value, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagLessThanOrEqualTo(String value) {
            addCriterion("mt_pwd_flag <=", value, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagLike(String value) {
            addCriterion("mt_pwd_flag like", value, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagNotLike(String value) {
            addCriterion("mt_pwd_flag not like", value, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagIn(List<String> values) {
            addCriterion("mt_pwd_flag in", values, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagNotIn(List<String> values) {
            addCriterion("mt_pwd_flag not in", values, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagBetween(String value1, String value2) {
            addCriterion("mt_pwd_flag between", value1, value2, "mtPwdFlag");
            return (Criteria) this;
        }

        public Criteria andMtPwdFlagNotBetween(String value1, String value2) {
            addCriterion("mt_pwd_flag not between", value1, value2, "mtPwdFlag");
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

        public Criteria andBeginDateTimeIsNull() {
            addCriterion("begin_date_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeIsNotNull() {
            addCriterion("begin_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeEqualTo(String value) {
            addCriterion("begin_date_time =", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeNotEqualTo(String value) {
            addCriterion("begin_date_time <>", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeGreaterThan(String value) {
            addCriterion("begin_date_time >", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("begin_date_time >=", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeLessThan(String value) {
            addCriterion("begin_date_time <", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeLessThanOrEqualTo(String value) {
            addCriterion("begin_date_time <=", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeLike(String value) {
            addCriterion("begin_date_time like", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeNotLike(String value) {
            addCriterion("begin_date_time not like", value, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeIn(List<String> values) {
            addCriterion("begin_date_time in", values, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeNotIn(List<String> values) {
            addCriterion("begin_date_time not in", values, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeBetween(String value1, String value2) {
            addCriterion("begin_date_time between", value1, value2, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andBeginDateTimeNotBetween(String value1, String value2) {
            addCriterion("begin_date_time not between", value1, value2, "beginDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIsNull() {
            addCriterion("end_date_time is null");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIsNotNull() {
            addCriterion("end_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeEqualTo(String value) {
            addCriterion("end_date_time =", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotEqualTo(String value) {
            addCriterion("end_date_time <>", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeGreaterThan(String value) {
            addCriterion("end_date_time >", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_date_time >=", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLessThan(String value) {
            addCriterion("end_date_time <", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLessThanOrEqualTo(String value) {
            addCriterion("end_date_time <=", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeLike(String value) {
            addCriterion("end_date_time like", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotLike(String value) {
            addCriterion("end_date_time not like", value, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeIn(List<String> values) {
            addCriterion("end_date_time in", values, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotIn(List<String> values) {
            addCriterion("end_date_time not in", values, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeBetween(String value1, String value2) {
            addCriterion("end_date_time between", value1, value2, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andEndDateTimeNotBetween(String value1, String value2) {
            addCriterion("end_date_time not between", value1, value2, "endDateTime");
            return (Criteria) this;
        }

        public Criteria andMtAddressIsNull() {
            addCriterion("mt_address is null");
            return (Criteria) this;
        }

        public Criteria andMtAddressIsNotNull() {
            addCriterion("mt_address is not null");
            return (Criteria) this;
        }

        public Criteria andMtAddressEqualTo(String value) {
            addCriterion("mt_address =", value, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressNotEqualTo(String value) {
            addCriterion("mt_address <>", value, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressGreaterThan(String value) {
            addCriterion("mt_address >", value, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mt_address >=", value, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressLessThan(String value) {
            addCriterion("mt_address <", value, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressLessThanOrEqualTo(String value) {
            addCriterion("mt_address <=", value, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressLike(String value) {
            addCriterion("mt_address like", value, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressNotLike(String value) {
            addCriterion("mt_address not like", value, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressIn(List<String> values) {
            addCriterion("mt_address in", values, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressNotIn(List<String> values) {
            addCriterion("mt_address not in", values, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressBetween(String value1, String value2) {
            addCriterion("mt_address between", value1, value2, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andMtAddressNotBetween(String value1, String value2) {
            addCriterion("mt_address not between", value1, value2, "mtAddress");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeIsNull() {
            addCriterion("real_begin_date_time is null");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeIsNotNull() {
            addCriterion("real_begin_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeEqualTo(String value) {
            addCriterion("real_begin_date_time =", value, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeNotEqualTo(String value) {
            addCriterion("real_begin_date_time <>", value, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeGreaterThan(String value) {
            addCriterion("real_begin_date_time >", value, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("real_begin_date_time >=", value, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeLessThan(String value) {
            addCriterion("real_begin_date_time <", value, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeLessThanOrEqualTo(String value) {
            addCriterion("real_begin_date_time <=", value, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeLike(String value) {
            addCriterion("real_begin_date_time like", value, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeNotLike(String value) {
            addCriterion("real_begin_date_time not like", value, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeIn(List<String> values) {
            addCriterion("real_begin_date_time in", values, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeNotIn(List<String> values) {
            addCriterion("real_begin_date_time not in", values, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeBetween(String value1, String value2) {
            addCriterion("real_begin_date_time between", value1, value2, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealBeginDateTimeNotBetween(String value1, String value2) {
            addCriterion("real_begin_date_time not between", value1, value2, "realBeginDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeIsNull() {
            addCriterion("real_end_date_time is null");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeIsNotNull() {
            addCriterion("real_end_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeEqualTo(String value) {
            addCriterion("real_end_date_time =", value, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeNotEqualTo(String value) {
            addCriterion("real_end_date_time <>", value, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeGreaterThan(String value) {
            addCriterion("real_end_date_time >", value, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("real_end_date_time >=", value, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeLessThan(String value) {
            addCriterion("real_end_date_time <", value, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeLessThanOrEqualTo(String value) {
            addCriterion("real_end_date_time <=", value, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeLike(String value) {
            addCriterion("real_end_date_time like", value, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeNotLike(String value) {
            addCriterion("real_end_date_time not like", value, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeIn(List<String> values) {
            addCriterion("real_end_date_time in", values, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeNotIn(List<String> values) {
            addCriterion("real_end_date_time not in", values, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeBetween(String value1, String value2) {
            addCriterion("real_end_date_time between", value1, value2, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andRealEndDateTimeNotBetween(String value1, String value2) {
            addCriterion("real_end_date_time not between", value1, value2, "realEndDateTime");
            return (Criteria) this;
        }

        public Criteria andVideoFlagIsNull() {
            addCriterion("video_flag is null");
            return (Criteria) this;
        }

        public Criteria andVideoFlagIsNotNull() {
            addCriterion("video_flag is not null");
            return (Criteria) this;
        }

        public Criteria andVideoFlagEqualTo(String value) {
            addCriterion("video_flag =", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagNotEqualTo(String value) {
            addCriterion("video_flag <>", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagGreaterThan(String value) {
            addCriterion("video_flag >", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagGreaterThanOrEqualTo(String value) {
            addCriterion("video_flag >=", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagLessThan(String value) {
            addCriterion("video_flag <", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagLessThanOrEqualTo(String value) {
            addCriterion("video_flag <=", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagLike(String value) {
            addCriterion("video_flag like", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagNotLike(String value) {
            addCriterion("video_flag not like", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagIn(List<String> values) {
            addCriterion("video_flag in", values, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagNotIn(List<String> values) {
            addCriterion("video_flag not in", values, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagBetween(String value1, String value2) {
            addCriterion("video_flag between", value1, value2, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagNotBetween(String value1, String value2) {
            addCriterion("video_flag not between", value1, value2, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andCreateFlagIsNull() {
            addCriterion("create_flag is null");
            return (Criteria) this;
        }

        public Criteria andCreateFlagIsNotNull() {
            addCriterion("create_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCreateFlagEqualTo(String value) {
            addCriterion("create_flag =", value, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagNotEqualTo(String value) {
            addCriterion("create_flag <>", value, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagGreaterThan(String value) {
            addCriterion("create_flag >", value, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagGreaterThanOrEqualTo(String value) {
            addCriterion("create_flag >=", value, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagLessThan(String value) {
            addCriterion("create_flag <", value, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagLessThanOrEqualTo(String value) {
            addCriterion("create_flag <=", value, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagLike(String value) {
            addCriterion("create_flag like", value, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagNotLike(String value) {
            addCriterion("create_flag not like", value, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagIn(List<String> values) {
            addCriterion("create_flag in", values, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagNotIn(List<String> values) {
            addCriterion("create_flag not in", values, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagBetween(String value1, String value2) {
            addCriterion("create_flag between", value1, value2, "createFlag");
            return (Criteria) this;
        }

        public Criteria andCreateFlagNotBetween(String value1, String value2) {
            addCriterion("create_flag not between", value1, value2, "createFlag");
            return (Criteria) this;
        }

        public Criteria andMtTypeIsNull() {
            addCriterion("mt_type is null");
            return (Criteria) this;
        }

        public Criteria andMtTypeIsNotNull() {
            addCriterion("mt_type is not null");
            return (Criteria) this;
        }

        public Criteria andMtTypeEqualTo(String value) {
            addCriterion("mt_type =", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeNotEqualTo(String value) {
            addCriterion("mt_type <>", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeGreaterThan(String value) {
            addCriterion("mt_type >", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mt_type >=", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeLessThan(String value) {
            addCriterion("mt_type <", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeLessThanOrEqualTo(String value) {
            addCriterion("mt_type <=", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeLike(String value) {
            addCriterion("mt_type like", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeNotLike(String value) {
            addCriterion("mt_type not like", value, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeIn(List<String> values) {
            addCriterion("mt_type in", values, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeNotIn(List<String> values) {
            addCriterion("mt_type not in", values, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeBetween(String value1, String value2) {
            addCriterion("mt_type between", value1, value2, "mtType");
            return (Criteria) this;
        }

        public Criteria andMtTypeNotBetween(String value1, String value2) {
            addCriterion("mt_type not between", value1, value2, "mtType");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIsNull() {
            addCriterion("room_url is null");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIsNotNull() {
            addCriterion("room_url is not null");
            return (Criteria) this;
        }

        public Criteria andRoomUrlEqualTo(String value) {
            addCriterion("room_url =", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotEqualTo(String value) {
            addCriterion("room_url <>", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlGreaterThan(String value) {
            addCriterion("room_url >", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlGreaterThanOrEqualTo(String value) {
            addCriterion("room_url >=", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLessThan(String value) {
            addCriterion("room_url <", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLessThanOrEqualTo(String value) {
            addCriterion("room_url <=", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLike(String value) {
            addCriterion("room_url like", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotLike(String value) {
            addCriterion("room_url not like", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIn(List<String> values) {
            addCriterion("room_url in", values, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotIn(List<String> values) {
            addCriterion("room_url not in", values, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlBetween(String value1, String value2) {
            addCriterion("room_url between", value1, value2, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotBetween(String value1, String value2) {
            addCriterion("room_url not between", value1, value2, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andVideoStatusIsNull() {
            addCriterion("video_status is null");
            return (Criteria) this;
        }

        public Criteria andVideoStatusIsNotNull() {
            addCriterion("video_status is not null");
            return (Criteria) this;
        }

        public Criteria andVideoStatusEqualTo(String value) {
            addCriterion("video_status =", value, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusNotEqualTo(String value) {
            addCriterion("video_status <>", value, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusGreaterThan(String value) {
            addCriterion("video_status >", value, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusGreaterThanOrEqualTo(String value) {
            addCriterion("video_status >=", value, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusLessThan(String value) {
            addCriterion("video_status <", value, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusLessThanOrEqualTo(String value) {
            addCriterion("video_status <=", value, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusLike(String value) {
            addCriterion("video_status like", value, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusNotLike(String value) {
            addCriterion("video_status not like", value, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusIn(List<String> values) {
            addCriterion("video_status in", values, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusNotIn(List<String> values) {
            addCriterion("video_status not in", values, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusBetween(String value1, String value2) {
            addCriterion("video_status between", value1, value2, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andVideoStatusNotBetween(String value1, String value2) {
            addCriterion("video_status not between", value1, value2, "videoStatus");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNull() {
            addCriterion("auth_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthNameIsNotNull() {
            addCriterion("auth_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthNameEqualTo(String value) {
            addCriterion("auth_name =", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotEqualTo(String value) {
            addCriterion("auth_name <>", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThan(String value) {
            addCriterion("auth_name >", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameGreaterThanOrEqualTo(String value) {
            addCriterion("auth_name >=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThan(String value) {
            addCriterion("auth_name <", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLessThanOrEqualTo(String value) {
            addCriterion("auth_name <=", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameLike(String value) {
            addCriterion("auth_name like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotLike(String value) {
            addCriterion("auth_name not like", value, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameIn(List<String> values) {
            addCriterion("auth_name in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotIn(List<String> values) {
            addCriterion("auth_name not in", values, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameBetween(String value1, String value2) {
            addCriterion("auth_name between", value1, value2, "authName");
            return (Criteria) this;
        }

        public Criteria andAuthNameNotBetween(String value1, String value2) {
            addCriterion("auth_name not between", value1, value2, "authName");
            return (Criteria) this;
        }

        public Criteria andExtensionIsNull() {
            addCriterion("extension is null");
            return (Criteria) this;
        }

        public Criteria andExtensionIsNotNull() {
            addCriterion("extension is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionEqualTo(String value) {
            addCriterion("extension =", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotEqualTo(String value) {
            addCriterion("extension <>", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionGreaterThan(String value) {
            addCriterion("extension >", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionGreaterThanOrEqualTo(String value) {
            addCriterion("extension >=", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLessThan(String value) {
            addCriterion("extension <", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLessThanOrEqualTo(String value) {
            addCriterion("extension <=", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLike(String value) {
            addCriterion("extension like", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotLike(String value) {
            addCriterion("extension not like", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionIn(List<String> values) {
            addCriterion("extension in", values, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotIn(List<String> values) {
            addCriterion("extension not in", values, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionBetween(String value1, String value2) {
            addCriterion("extension between", value1, value2, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotBetween(String value1, String value2) {
            addCriterion("extension not between", value1, value2, "extension");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
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
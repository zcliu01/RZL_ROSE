package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class FbBusInstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FbBusInstExample() {
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("apply_id like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("apply_id not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyNameIsNull() {
            addCriterion("apply_name is null");
            return (Criteria) this;
        }

        public Criteria andApplyNameIsNotNull() {
            addCriterion("apply_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNameEqualTo(String value) {
            addCriterion("apply_name =", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotEqualTo(String value) {
            addCriterion("apply_name <>", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThan(String value) {
            addCriterion("apply_name >", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameGreaterThanOrEqualTo(String value) {
            addCriterion("apply_name >=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThan(String value) {
            addCriterion("apply_name <", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLessThanOrEqualTo(String value) {
            addCriterion("apply_name <=", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameLike(String value) {
            addCriterion("apply_name like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotLike(String value) {
            addCriterion("apply_name not like", value, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameIn(List<String> values) {
            addCriterion("apply_name in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotIn(List<String> values) {
            addCriterion("apply_name not in", values, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameBetween(String value1, String value2) {
            addCriterion("apply_name between", value1, value2, "applyName");
            return (Criteria) this;
        }

        public Criteria andApplyNameNotBetween(String value1, String value2) {
            addCriterion("apply_name not between", value1, value2, "applyName");
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

        public Criteria andFbIdIsNull() {
            addCriterion("fb_id is null");
            return (Criteria) this;
        }

        public Criteria andFbIdIsNotNull() {
            addCriterion("fb_id is not null");
            return (Criteria) this;
        }

        public Criteria andFbIdEqualTo(String value) {
            addCriterion("fb_id =", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotEqualTo(String value) {
            addCriterion("fb_id <>", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdGreaterThan(String value) {
            addCriterion("fb_id >", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdGreaterThanOrEqualTo(String value) {
            addCriterion("fb_id >=", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLessThan(String value) {
            addCriterion("fb_id <", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLessThanOrEqualTo(String value) {
            addCriterion("fb_id <=", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdLike(String value) {
            addCriterion("fb_id like", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotLike(String value) {
            addCriterion("fb_id not like", value, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdIn(List<String> values) {
            addCriterion("fb_id in", values, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotIn(List<String> values) {
            addCriterion("fb_id not in", values, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdBetween(String value1, String value2) {
            addCriterion("fb_id between", value1, value2, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbIdNotBetween(String value1, String value2) {
            addCriterion("fb_id not between", value1, value2, "fbId");
            return (Criteria) this;
        }

        public Criteria andFbTitleIsNull() {
            addCriterion("fb_title is null");
            return (Criteria) this;
        }

        public Criteria andFbTitleIsNotNull() {
            addCriterion("fb_title is not null");
            return (Criteria) this;
        }

        public Criteria andFbTitleEqualTo(String value) {
            addCriterion("fb_title =", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleNotEqualTo(String value) {
            addCriterion("fb_title <>", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleGreaterThan(String value) {
            addCriterion("fb_title >", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleGreaterThanOrEqualTo(String value) {
            addCriterion("fb_title >=", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleLessThan(String value) {
            addCriterion("fb_title <", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleLessThanOrEqualTo(String value) {
            addCriterion("fb_title <=", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleLike(String value) {
            addCriterion("fb_title like", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleNotLike(String value) {
            addCriterion("fb_title not like", value, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleIn(List<String> values) {
            addCriterion("fb_title in", values, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleNotIn(List<String> values) {
            addCriterion("fb_title not in", values, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleBetween(String value1, String value2) {
            addCriterion("fb_title between", value1, value2, "fbTitle");
            return (Criteria) this;
        }

        public Criteria andFbTitleNotBetween(String value1, String value2) {
            addCriterion("fb_title not between", value1, value2, "fbTitle");
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

        public Criteria andStartDateTimeIsNull() {
            addCriterion("start_date_time is null");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeIsNotNull() {
            addCriterion("start_date_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeEqualTo(String value) {
            addCriterion("start_date_time =", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotEqualTo(String value) {
            addCriterion("start_date_time <>", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeGreaterThan(String value) {
            addCriterion("start_date_time >", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_date_time >=", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeLessThan(String value) {
            addCriterion("start_date_time <", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeLessThanOrEqualTo(String value) {
            addCriterion("start_date_time <=", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeLike(String value) {
            addCriterion("start_date_time like", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotLike(String value) {
            addCriterion("start_date_time not like", value, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeIn(List<String> values) {
            addCriterion("start_date_time in", values, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotIn(List<String> values) {
            addCriterion("start_date_time not in", values, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeBetween(String value1, String value2) {
            addCriterion("start_date_time between", value1, value2, "startDateTime");
            return (Criteria) this;
        }

        public Criteria andStartDateTimeNotBetween(String value1, String value2) {
            addCriterion("start_date_time not between", value1, value2, "startDateTime");
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

        public Criteria andInstStatusIsNull() {
            addCriterion("inst_status is null");
            return (Criteria) this;
        }

        public Criteria andInstStatusIsNotNull() {
            addCriterion("inst_status is not null");
            return (Criteria) this;
        }

        public Criteria andInstStatusEqualTo(String value) {
            addCriterion("inst_status =", value, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusNotEqualTo(String value) {
            addCriterion("inst_status <>", value, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusGreaterThan(String value) {
            addCriterion("inst_status >", value, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusGreaterThanOrEqualTo(String value) {
            addCriterion("inst_status >=", value, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusLessThan(String value) {
            addCriterion("inst_status <", value, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusLessThanOrEqualTo(String value) {
            addCriterion("inst_status <=", value, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusLike(String value) {
            addCriterion("inst_status like", value, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusNotLike(String value) {
            addCriterion("inst_status not like", value, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusIn(List<String> values) {
            addCriterion("inst_status in", values, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusNotIn(List<String> values) {
            addCriterion("inst_status not in", values, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusBetween(String value1, String value2) {
            addCriterion("inst_status between", value1, value2, "instStatus");
            return (Criteria) this;
        }

        public Criteria andInstStatusNotBetween(String value1, String value2) {
            addCriterion("inst_status not between", value1, value2, "instStatus");
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

        public Criteria andInstTagIsNull() {
            addCriterion("inst_tag is null");
            return (Criteria) this;
        }

        public Criteria andInstTagIsNotNull() {
            addCriterion("inst_tag is not null");
            return (Criteria) this;
        }

        public Criteria andInstTagEqualTo(String value) {
            addCriterion("inst_tag =", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNotEqualTo(String value) {
            addCriterion("inst_tag <>", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagGreaterThan(String value) {
            addCriterion("inst_tag >", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagGreaterThanOrEqualTo(String value) {
            addCriterion("inst_tag >=", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagLessThan(String value) {
            addCriterion("inst_tag <", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagLessThanOrEqualTo(String value) {
            addCriterion("inst_tag <=", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagLike(String value) {
            addCriterion("inst_tag like", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNotLike(String value) {
            addCriterion("inst_tag not like", value, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagIn(List<String> values) {
            addCriterion("inst_tag in", values, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNotIn(List<String> values) {
            addCriterion("inst_tag not in", values, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagBetween(String value1, String value2) {
            addCriterion("inst_tag between", value1, value2, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNotBetween(String value1, String value2) {
            addCriterion("inst_tag not between", value1, value2, "instTag");
            return (Criteria) this;
        }

        public Criteria andInstTagNameIsNull() {
            addCriterion("inst_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andInstTagNameIsNotNull() {
            addCriterion("inst_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstTagNameEqualTo(String value) {
            addCriterion("inst_tag_name =", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameNotEqualTo(String value) {
            addCriterion("inst_tag_name <>", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameGreaterThan(String value) {
            addCriterion("inst_tag_name >", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("inst_tag_name >=", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameLessThan(String value) {
            addCriterion("inst_tag_name <", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameLessThanOrEqualTo(String value) {
            addCriterion("inst_tag_name <=", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameLike(String value) {
            addCriterion("inst_tag_name like", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameNotLike(String value) {
            addCriterion("inst_tag_name not like", value, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameIn(List<String> values) {
            addCriterion("inst_tag_name in", values, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameNotIn(List<String> values) {
            addCriterion("inst_tag_name not in", values, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameBetween(String value1, String value2) {
            addCriterion("inst_tag_name between", value1, value2, "instTagName");
            return (Criteria) this;
        }

        public Criteria andInstTagNameNotBetween(String value1, String value2) {
            addCriterion("inst_tag_name not between", value1, value2, "instTagName");
            return (Criteria) this;
        }

        public Criteria andFbContentIsNull() {
            addCriterion("fb_content is null");
            return (Criteria) this;
        }

        public Criteria andFbContentIsNotNull() {
            addCriterion("fb_content is not null");
            return (Criteria) this;
        }

        public Criteria andFbContentEqualTo(String value) {
            addCriterion("fb_content =", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentNotEqualTo(String value) {
            addCriterion("fb_content <>", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentGreaterThan(String value) {
            addCriterion("fb_content >", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentGreaterThanOrEqualTo(String value) {
            addCriterion("fb_content >=", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentLessThan(String value) {
            addCriterion("fb_content <", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentLessThanOrEqualTo(String value) {
            addCriterion("fb_content <=", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentLike(String value) {
            addCriterion("fb_content like", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentNotLike(String value) {
            addCriterion("fb_content not like", value, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentIn(List<String> values) {
            addCriterion("fb_content in", values, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentNotIn(List<String> values) {
            addCriterion("fb_content not in", values, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentBetween(String value1, String value2) {
            addCriterion("fb_content between", value1, value2, "fbContent");
            return (Criteria) this;
        }

        public Criteria andFbContentNotBetween(String value1, String value2) {
            addCriterion("fb_content not between", value1, value2, "fbContent");
            return (Criteria) this;
        }

        public Criteria andNextInstTagIsNull() {
            addCriterion("next_inst_tag is null");
            return (Criteria) this;
        }

        public Criteria andNextInstTagIsNotNull() {
            addCriterion("next_inst_tag is not null");
            return (Criteria) this;
        }

        public Criteria andNextInstTagEqualTo(String value) {
            addCriterion("next_inst_tag =", value, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNotEqualTo(String value) {
            addCriterion("next_inst_tag <>", value, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagGreaterThan(String value) {
            addCriterion("next_inst_tag >", value, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagGreaterThanOrEqualTo(String value) {
            addCriterion("next_inst_tag >=", value, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagLessThan(String value) {
            addCriterion("next_inst_tag <", value, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagLessThanOrEqualTo(String value) {
            addCriterion("next_inst_tag <=", value, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagLike(String value) {
            addCriterion("next_inst_tag like", value, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNotLike(String value) {
            addCriterion("next_inst_tag not like", value, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagIn(List<String> values) {
            addCriterion("next_inst_tag in", values, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNotIn(List<String> values) {
            addCriterion("next_inst_tag not in", values, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagBetween(String value1, String value2) {
            addCriterion("next_inst_tag between", value1, value2, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNotBetween(String value1, String value2) {
            addCriterion("next_inst_tag not between", value1, value2, "nextInstTag");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameIsNull() {
            addCriterion("next_inst_tag_name is null");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameIsNotNull() {
            addCriterion("next_inst_tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameEqualTo(String value) {
            addCriterion("next_inst_tag_name =", value, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameNotEqualTo(String value) {
            addCriterion("next_inst_tag_name <>", value, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameGreaterThan(String value) {
            addCriterion("next_inst_tag_name >", value, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("next_inst_tag_name >=", value, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameLessThan(String value) {
            addCriterion("next_inst_tag_name <", value, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameLessThanOrEqualTo(String value) {
            addCriterion("next_inst_tag_name <=", value, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameLike(String value) {
            addCriterion("next_inst_tag_name like", value, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameNotLike(String value) {
            addCriterion("next_inst_tag_name not like", value, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameIn(List<String> values) {
            addCriterion("next_inst_tag_name in", values, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameNotIn(List<String> values) {
            addCriterion("next_inst_tag_name not in", values, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameBetween(String value1, String value2) {
            addCriterion("next_inst_tag_name between", value1, value2, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextInstTagNameNotBetween(String value1, String value2) {
            addCriterion("next_inst_tag_name not between", value1, value2, "nextInstTagName");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeIsNull() {
            addCriterion("next_tag_assignee is null");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeIsNotNull() {
            addCriterion("next_tag_assignee is not null");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeEqualTo(String value) {
            addCriterion("next_tag_assignee =", value, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeNotEqualTo(String value) {
            addCriterion("next_tag_assignee <>", value, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeGreaterThan(String value) {
            addCriterion("next_tag_assignee >", value, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeGreaterThanOrEqualTo(String value) {
            addCriterion("next_tag_assignee >=", value, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeLessThan(String value) {
            addCriterion("next_tag_assignee <", value, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeLessThanOrEqualTo(String value) {
            addCriterion("next_tag_assignee <=", value, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeLike(String value) {
            addCriterion("next_tag_assignee like", value, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeNotLike(String value) {
            addCriterion("next_tag_assignee not like", value, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeIn(List<String> values) {
            addCriterion("next_tag_assignee in", values, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeNotIn(List<String> values) {
            addCriterion("next_tag_assignee not in", values, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeBetween(String value1, String value2) {
            addCriterion("next_tag_assignee between", value1, value2, "nextTagAssignee");
            return (Criteria) this;
        }

        public Criteria andNextTagAssigneeNotBetween(String value1, String value2) {
            addCriterion("next_tag_assignee not between", value1, value2, "nextTagAssignee");
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
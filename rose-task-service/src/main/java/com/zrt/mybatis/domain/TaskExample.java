package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNull() {
            addCriterion("parent_task_id is null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNotNull() {
            addCriterion("parent_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdEqualTo(String value) {
            addCriterion("parent_task_id =", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotEqualTo(String value) {
            addCriterion("parent_task_id <>", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThan(String value) {
            addCriterion("parent_task_id >", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_task_id >=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThan(String value) {
            addCriterion("parent_task_id <", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThanOrEqualTo(String value) {
            addCriterion("parent_task_id <=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLike(String value) {
            addCriterion("parent_task_id like", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotLike(String value) {
            addCriterion("parent_task_id not like", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIn(List<String> values) {
            addCriterion("parent_task_id in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotIn(List<String> values) {
            addCriterion("parent_task_id not in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdBetween(String value1, String value2) {
            addCriterion("parent_task_id between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotBetween(String value1, String value2) {
            addCriterion("parent_task_id not between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIsNull() {
            addCriterion("task_start_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIsNotNull() {
            addCriterion("task_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeEqualTo(String value) {
            addCriterion("task_start_time =", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotEqualTo(String value) {
            addCriterion("task_start_time <>", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeGreaterThan(String value) {
            addCriterion("task_start_time >", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("task_start_time >=", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLessThan(String value) {
            addCriterion("task_start_time <", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLessThanOrEqualTo(String value) {
            addCriterion("task_start_time <=", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeLike(String value) {
            addCriterion("task_start_time like", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotLike(String value) {
            addCriterion("task_start_time not like", value, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeIn(List<String> values) {
            addCriterion("task_start_time in", values, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotIn(List<String> values) {
            addCriterion("task_start_time not in", values, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeBetween(String value1, String value2) {
            addCriterion("task_start_time between", value1, value2, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskStartTimeNotBetween(String value1, String value2) {
            addCriterion("task_start_time not between", value1, value2, "taskStartTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIsNull() {
            addCriterion("task_end_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIsNotNull() {
            addCriterion("task_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeEqualTo(String value) {
            addCriterion("task_end_time =", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotEqualTo(String value) {
            addCriterion("task_end_time <>", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeGreaterThan(String value) {
            addCriterion("task_end_time >", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("task_end_time >=", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLessThan(String value) {
            addCriterion("task_end_time <", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLessThanOrEqualTo(String value) {
            addCriterion("task_end_time <=", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeLike(String value) {
            addCriterion("task_end_time like", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotLike(String value) {
            addCriterion("task_end_time not like", value, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeIn(List<String> values) {
            addCriterion("task_end_time in", values, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotIn(List<String> values) {
            addCriterion("task_end_time not in", values, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeBetween(String value1, String value2) {
            addCriterion("task_end_time between", value1, value2, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskEndTimeNotBetween(String value1, String value2) {
            addCriterion("task_end_time not between", value1, value2, "taskEndTime");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerIsNull() {
            addCriterion("task_owner is null");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerIsNotNull() {
            addCriterion("task_owner is not null");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerEqualTo(String value) {
            addCriterion("task_owner =", value, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNotEqualTo(String value) {
            addCriterion("task_owner <>", value, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerGreaterThan(String value) {
            addCriterion("task_owner >", value, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("task_owner >=", value, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerLessThan(String value) {
            addCriterion("task_owner <", value, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerLessThanOrEqualTo(String value) {
            addCriterion("task_owner <=", value, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerLike(String value) {
            addCriterion("task_owner like", value, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNotLike(String value) {
            addCriterion("task_owner not like", value, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerIn(List<String> values) {
            addCriterion("task_owner in", values, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNotIn(List<String> values) {
            addCriterion("task_owner not in", values, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerBetween(String value1, String value2) {
            addCriterion("task_owner between", value1, value2, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNotBetween(String value1, String value2) {
            addCriterion("task_owner not between", value1, value2, "taskOwner");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameIsNull() {
            addCriterion("task_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameIsNotNull() {
            addCriterion("task_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameEqualTo(String value) {
            addCriterion("task_owner_name =", value, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameNotEqualTo(String value) {
            addCriterion("task_owner_name <>", value, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameGreaterThan(String value) {
            addCriterion("task_owner_name >", value, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_owner_name >=", value, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameLessThan(String value) {
            addCriterion("task_owner_name <", value, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("task_owner_name <=", value, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameLike(String value) {
            addCriterion("task_owner_name like", value, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameNotLike(String value) {
            addCriterion("task_owner_name not like", value, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameIn(List<String> values) {
            addCriterion("task_owner_name in", values, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameNotIn(List<String> values) {
            addCriterion("task_owner_name not in", values, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameBetween(String value1, String value2) {
            addCriterion("task_owner_name between", value1, value2, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskOwnerNameNotBetween(String value1, String value2) {
            addCriterion("task_owner_name not between", value1, value2, "taskOwnerName");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNull() {
            addCriterion("task_state is null");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNotNull() {
            addCriterion("task_state is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStateEqualTo(String value) {
            addCriterion("task_state =", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotEqualTo(String value) {
            addCriterion("task_state <>", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThan(String value) {
            addCriterion("task_state >", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThanOrEqualTo(String value) {
            addCriterion("task_state >=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThan(String value) {
            addCriterion("task_state <", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThanOrEqualTo(String value) {
            addCriterion("task_state <=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLike(String value) {
            addCriterion("task_state like", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotLike(String value) {
            addCriterion("task_state not like", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateIn(List<String> values) {
            addCriterion("task_state in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotIn(List<String> values) {
            addCriterion("task_state not in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateBetween(String value1, String value2) {
            addCriterion("task_state between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotBetween(String value1, String value2) {
            addCriterion("task_state not between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIsNull() {
            addCriterion("task_remark is null");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIsNotNull() {
            addCriterion("task_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkEqualTo(String value) {
            addCriterion("task_remark =", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotEqualTo(String value) {
            addCriterion("task_remark <>", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkGreaterThan(String value) {
            addCriterion("task_remark >", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("task_remark >=", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkLessThan(String value) {
            addCriterion("task_remark <", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkLessThanOrEqualTo(String value) {
            addCriterion("task_remark <=", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkLike(String value) {
            addCriterion("task_remark like", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotLike(String value) {
            addCriterion("task_remark not like", value, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkIn(List<String> values) {
            addCriterion("task_remark in", values, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotIn(List<String> values) {
            addCriterion("task_remark not in", values, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkBetween(String value1, String value2) {
            addCriterion("task_remark between", value1, value2, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskRemarkNotBetween(String value1, String value2) {
            addCriterion("task_remark not between", value1, value2, "taskRemark");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
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

        public Criteria andSendimIsNull() {
            addCriterion("sendIM is null");
            return (Criteria) this;
        }

        public Criteria andSendimIsNotNull() {
            addCriterion("sendIM is not null");
            return (Criteria) this;
        }

        public Criteria andSendimEqualTo(String value) {
            addCriterion("sendIM =", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotEqualTo(String value) {
            addCriterion("sendIM <>", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimGreaterThan(String value) {
            addCriterion("sendIM >", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimGreaterThanOrEqualTo(String value) {
            addCriterion("sendIM >=", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLessThan(String value) {
            addCriterion("sendIM <", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLessThanOrEqualTo(String value) {
            addCriterion("sendIM <=", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimLike(String value) {
            addCriterion("sendIM like", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotLike(String value) {
            addCriterion("sendIM not like", value, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimIn(List<String> values) {
            addCriterion("sendIM in", values, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotIn(List<String> values) {
            addCriterion("sendIM not in", values, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimBetween(String value1, String value2) {
            addCriterion("sendIM between", value1, value2, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendimNotBetween(String value1, String value2) {
            addCriterion("sendIM not between", value1, value2, "sendim");
            return (Criteria) this;
        }

        public Criteria andSendinfoIsNull() {
            addCriterion("sendInfo is null");
            return (Criteria) this;
        }

        public Criteria andSendinfoIsNotNull() {
            addCriterion("sendInfo is not null");
            return (Criteria) this;
        }

        public Criteria andSendinfoEqualTo(String value) {
            addCriterion("sendInfo =", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotEqualTo(String value) {
            addCriterion("sendInfo <>", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoGreaterThan(String value) {
            addCriterion("sendInfo >", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoGreaterThanOrEqualTo(String value) {
            addCriterion("sendInfo >=", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLessThan(String value) {
            addCriterion("sendInfo <", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLessThanOrEqualTo(String value) {
            addCriterion("sendInfo <=", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoLike(String value) {
            addCriterion("sendInfo like", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotLike(String value) {
            addCriterion("sendInfo not like", value, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoIn(List<String> values) {
            addCriterion("sendInfo in", values, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotIn(List<String> values) {
            addCriterion("sendInfo not in", values, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoBetween(String value1, String value2) {
            addCriterion("sendInfo between", value1, value2, "sendinfo");
            return (Criteria) this;
        }

        public Criteria andSendinfoNotBetween(String value1, String value2) {
            addCriterion("sendInfo not between", value1, value2, "sendinfo");
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
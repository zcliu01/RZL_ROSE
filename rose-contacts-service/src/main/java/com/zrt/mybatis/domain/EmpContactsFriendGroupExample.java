package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class EmpContactsFriendGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmpContactsFriendGroupExample() {
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

        public Criteria andFriendGroupIdIsNull() {
            addCriterion("friend_group_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdIsNotNull() {
            addCriterion("friend_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdEqualTo(String value) {
            addCriterion("friend_group_id =", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdNotEqualTo(String value) {
            addCriterion("friend_group_id <>", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdGreaterThan(String value) {
            addCriterion("friend_group_id >", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("friend_group_id >=", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdLessThan(String value) {
            addCriterion("friend_group_id <", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdLessThanOrEqualTo(String value) {
            addCriterion("friend_group_id <=", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdLike(String value) {
            addCriterion("friend_group_id like", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdNotLike(String value) {
            addCriterion("friend_group_id not like", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdIn(List<String> values) {
            addCriterion("friend_group_id in", values, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdNotIn(List<String> values) {
            addCriterion("friend_group_id not in", values, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdBetween(String value1, String value2) {
            addCriterion("friend_group_id between", value1, value2, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdNotBetween(String value1, String value2) {
            addCriterion("friend_group_id not between", value1, value2, "friendGroupId");
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

        public Criteria andFriendGroupNameIsNull() {
            addCriterion("friend_group_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameIsNotNull() {
            addCriterion("friend_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameEqualTo(String value) {
            addCriterion("friend_group_name =", value, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameNotEqualTo(String value) {
            addCriterion("friend_group_name <>", value, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameGreaterThan(String value) {
            addCriterion("friend_group_name >", value, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("friend_group_name >=", value, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameLessThan(String value) {
            addCriterion("friend_group_name <", value, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameLessThanOrEqualTo(String value) {
            addCriterion("friend_group_name <=", value, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameLike(String value) {
            addCriterion("friend_group_name like", value, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameNotLike(String value) {
            addCriterion("friend_group_name not like", value, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameIn(List<String> values) {
            addCriterion("friend_group_name in", values, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameNotIn(List<String> values) {
            addCriterion("friend_group_name not in", values, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameBetween(String value1, String value2) {
            addCriterion("friend_group_name between", value1, value2, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupNameNotBetween(String value1, String value2) {
            addCriterion("friend_group_name not between", value1, value2, "friendGroupName");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeIsNull() {
            addCriterion("friend_group_type is null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeIsNotNull() {
            addCriterion("friend_group_type is not null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeEqualTo(String value) {
            addCriterion("friend_group_type =", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeNotEqualTo(String value) {
            addCriterion("friend_group_type <>", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeGreaterThan(String value) {
            addCriterion("friend_group_type >", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeGreaterThanOrEqualTo(String value) {
            addCriterion("friend_group_type >=", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeLessThan(String value) {
            addCriterion("friend_group_type <", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeLessThanOrEqualTo(String value) {
            addCriterion("friend_group_type <=", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeLike(String value) {
            addCriterion("friend_group_type like", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeNotLike(String value) {
            addCriterion("friend_group_type not like", value, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeIn(List<String> values) {
            addCriterion("friend_group_type in", values, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeNotIn(List<String> values) {
            addCriterion("friend_group_type not in", values, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeBetween(String value1, String value2) {
            addCriterion("friend_group_type between", value1, value2, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupTypeNotBetween(String value1, String value2) {
            addCriterion("friend_group_type not between", value1, value2, "friendGroupType");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityIsNull() {
            addCriterion("member_quantity is null");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityIsNotNull() {
            addCriterion("member_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityEqualTo(String value) {
            addCriterion("member_quantity =", value, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityNotEqualTo(String value) {
            addCriterion("member_quantity <>", value, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityGreaterThan(String value) {
            addCriterion("member_quantity >", value, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("member_quantity >=", value, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityLessThan(String value) {
            addCriterion("member_quantity <", value, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityLessThanOrEqualTo(String value) {
            addCriterion("member_quantity <=", value, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityLike(String value) {
            addCriterion("member_quantity like", value, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityNotLike(String value) {
            addCriterion("member_quantity not like", value, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityIn(List<String> values) {
            addCriterion("member_quantity in", values, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityNotIn(List<String> values) {
            addCriterion("member_quantity not in", values, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityBetween(String value1, String value2) {
            addCriterion("member_quantity between", value1, value2, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andMemberQuantityNotBetween(String value1, String value2) {
            addCriterion("member_quantity not between", value1, value2, "memberQuantity");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusIsNull() {
            addCriterion("friend_group_status is null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusIsNotNull() {
            addCriterion("friend_group_status is not null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusEqualTo(String value) {
            addCriterion("friend_group_status =", value, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusNotEqualTo(String value) {
            addCriterion("friend_group_status <>", value, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusGreaterThan(String value) {
            addCriterion("friend_group_status >", value, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusGreaterThanOrEqualTo(String value) {
            addCriterion("friend_group_status >=", value, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusLessThan(String value) {
            addCriterion("friend_group_status <", value, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusLessThanOrEqualTo(String value) {
            addCriterion("friend_group_status <=", value, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusLike(String value) {
            addCriterion("friend_group_status like", value, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusNotLike(String value) {
            addCriterion("friend_group_status not like", value, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusIn(List<String> values) {
            addCriterion("friend_group_status in", values, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusNotIn(List<String> values) {
            addCriterion("friend_group_status not in", values, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusBetween(String value1, String value2) {
            addCriterion("friend_group_status between", value1, value2, "friendGroupStatus");
            return (Criteria) this;
        }

        public Criteria andFriendGroupStatusNotBetween(String value1, String value2) {
            addCriterion("friend_group_status not between", value1, value2, "friendGroupStatus");
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

        public Criteria andFriendGroupHeadPhotoIsNull() {
            addCriterion("friend_group_head_photo is null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoIsNotNull() {
            addCriterion("friend_group_head_photo is not null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoEqualTo(String value) {
            addCriterion("friend_group_head_photo =", value, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoNotEqualTo(String value) {
            addCriterion("friend_group_head_photo <>", value, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoGreaterThan(String value) {
            addCriterion("friend_group_head_photo >", value, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("friend_group_head_photo >=", value, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoLessThan(String value) {
            addCriterion("friend_group_head_photo <", value, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoLessThanOrEqualTo(String value) {
            addCriterion("friend_group_head_photo <=", value, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoLike(String value) {
            addCriterion("friend_group_head_photo like", value, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoNotLike(String value) {
            addCriterion("friend_group_head_photo not like", value, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoIn(List<String> values) {
            addCriterion("friend_group_head_photo in", values, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoNotIn(List<String> values) {
            addCriterion("friend_group_head_photo not in", values, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoBetween(String value1, String value2) {
            addCriterion("friend_group_head_photo between", value1, value2, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupHeadPhotoNotBetween(String value1, String value2) {
            addCriterion("friend_group_head_photo not between", value1, value2, "friendGroupHeadPhoto");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescIsNull() {
            addCriterion("friend_group_desc is null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescIsNotNull() {
            addCriterion("friend_group_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescEqualTo(String value) {
            addCriterion("friend_group_desc =", value, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescNotEqualTo(String value) {
            addCriterion("friend_group_desc <>", value, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescGreaterThan(String value) {
            addCriterion("friend_group_desc >", value, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescGreaterThanOrEqualTo(String value) {
            addCriterion("friend_group_desc >=", value, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescLessThan(String value) {
            addCriterion("friend_group_desc <", value, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescLessThanOrEqualTo(String value) {
            addCriterion("friend_group_desc <=", value, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescLike(String value) {
            addCriterion("friend_group_desc like", value, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescNotLike(String value) {
            addCriterion("friend_group_desc not like", value, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescIn(List<String> values) {
            addCriterion("friend_group_desc in", values, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescNotIn(List<String> values) {
            addCriterion("friend_group_desc not in", values, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescBetween(String value1, String value2) {
            addCriterion("friend_group_desc between", value1, value2, "friendGroupDesc");
            return (Criteria) this;
        }

        public Criteria andFriendGroupDescNotBetween(String value1, String value2) {
            addCriterion("friend_group_desc not between", value1, value2, "friendGroupDesc");
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
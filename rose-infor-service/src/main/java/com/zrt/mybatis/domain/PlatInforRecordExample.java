package com.zrt.mybatis.domain;

import java.util.ArrayList;
import java.util.List;

public class PlatInforRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatInforRecordExample() {
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

        public Criteria andInforIdIsNull() {
            addCriterion("infor_id is null");
            return (Criteria) this;
        }

        public Criteria andInforIdIsNotNull() {
            addCriterion("infor_id is not null");
            return (Criteria) this;
        }

        public Criteria andInforIdEqualTo(String value) {
            addCriterion("infor_id =", value, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdNotEqualTo(String value) {
            addCriterion("infor_id <>", value, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdGreaterThan(String value) {
            addCriterion("infor_id >", value, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdGreaterThanOrEqualTo(String value) {
            addCriterion("infor_id >=", value, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdLessThan(String value) {
            addCriterion("infor_id <", value, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdLessThanOrEqualTo(String value) {
            addCriterion("infor_id <=", value, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdLike(String value) {
            addCriterion("infor_id like", value, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdNotLike(String value) {
            addCriterion("infor_id not like", value, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdIn(List<String> values) {
            addCriterion("infor_id in", values, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdNotIn(List<String> values) {
            addCriterion("infor_id not in", values, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdBetween(String value1, String value2) {
            addCriterion("infor_id between", value1, value2, "inforId");
            return (Criteria) this;
        }

        public Criteria andInforIdNotBetween(String value1, String value2) {
            addCriterion("infor_id not between", value1, value2, "inforId");
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

        public Criteria andParentNoIsNull() {
            addCriterion("parent_no is null");
            return (Criteria) this;
        }

        public Criteria andParentNoIsNotNull() {
            addCriterion("parent_no is not null");
            return (Criteria) this;
        }

        public Criteria andParentNoEqualTo(String value) {
            addCriterion("parent_no =", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotEqualTo(String value) {
            addCriterion("parent_no <>", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoGreaterThan(String value) {
            addCriterion("parent_no >", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoGreaterThanOrEqualTo(String value) {
            addCriterion("parent_no >=", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLessThan(String value) {
            addCriterion("parent_no <", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLessThanOrEqualTo(String value) {
            addCriterion("parent_no <=", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoLike(String value) {
            addCriterion("parent_no like", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotLike(String value) {
            addCriterion("parent_no not like", value, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoIn(List<String> values) {
            addCriterion("parent_no in", values, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotIn(List<String> values) {
            addCriterion("parent_no not in", values, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoBetween(String value1, String value2) {
            addCriterion("parent_no between", value1, value2, "parentNo");
            return (Criteria) this;
        }

        public Criteria andParentNoNotBetween(String value1, String value2) {
            addCriterion("parent_no not between", value1, value2, "parentNo");
            return (Criteria) this;
        }

        public Criteria andInforCodeIsNull() {
            addCriterion("infor_code is null");
            return (Criteria) this;
        }

        public Criteria andInforCodeIsNotNull() {
            addCriterion("infor_code is not null");
            return (Criteria) this;
        }

        public Criteria andInforCodeEqualTo(String value) {
            addCriterion("infor_code =", value, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeNotEqualTo(String value) {
            addCriterion("infor_code <>", value, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeGreaterThan(String value) {
            addCriterion("infor_code >", value, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeGreaterThanOrEqualTo(String value) {
            addCriterion("infor_code >=", value, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeLessThan(String value) {
            addCriterion("infor_code <", value, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeLessThanOrEqualTo(String value) {
            addCriterion("infor_code <=", value, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeLike(String value) {
            addCriterion("infor_code like", value, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeNotLike(String value) {
            addCriterion("infor_code not like", value, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeIn(List<String> values) {
            addCriterion("infor_code in", values, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeNotIn(List<String> values) {
            addCriterion("infor_code not in", values, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeBetween(String value1, String value2) {
            addCriterion("infor_code between", value1, value2, "inforCode");
            return (Criteria) this;
        }

        public Criteria andInforCodeNotBetween(String value1, String value2) {
            addCriterion("infor_code not between", value1, value2, "inforCode");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andUpdateEmpIdIsNull() {
            addCriterion("update_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdIsNotNull() {
            addCriterion("update_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdEqualTo(String value) {
            addCriterion("update_emp_id =", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotEqualTo(String value) {
            addCriterion("update_emp_id <>", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdGreaterThan(String value) {
            addCriterion("update_emp_id >", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_emp_id >=", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLessThan(String value) {
            addCriterion("update_emp_id <", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLessThanOrEqualTo(String value) {
            addCriterion("update_emp_id <=", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdLike(String value) {
            addCriterion("update_emp_id like", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotLike(String value) {
            addCriterion("update_emp_id not like", value, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdIn(List<String> values) {
            addCriterion("update_emp_id in", values, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotIn(List<String> values) {
            addCriterion("update_emp_id not in", values, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdBetween(String value1, String value2) {
            addCriterion("update_emp_id between", value1, value2, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpIdNotBetween(String value1, String value2) {
            addCriterion("update_emp_id not between", value1, value2, "updateEmpId");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameIsNull() {
            addCriterion("update_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameIsNotNull() {
            addCriterion("update_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameEqualTo(String value) {
            addCriterion("update_emp_name =", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotEqualTo(String value) {
            addCriterion("update_emp_name <>", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameGreaterThan(String value) {
            addCriterion("update_emp_name >", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_emp_name >=", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLessThan(String value) {
            addCriterion("update_emp_name <", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLessThanOrEqualTo(String value) {
            addCriterion("update_emp_name <=", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameLike(String value) {
            addCriterion("update_emp_name like", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotLike(String value) {
            addCriterion("update_emp_name not like", value, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameIn(List<String> values) {
            addCriterion("update_emp_name in", values, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotIn(List<String> values) {
            addCriterion("update_emp_name not in", values, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameBetween(String value1, String value2) {
            addCriterion("update_emp_name between", value1, value2, "updateEmpName");
            return (Criteria) this;
        }

        public Criteria andUpdateEmpNameNotBetween(String value1, String value2) {
            addCriterion("update_emp_name not between", value1, value2, "updateEmpName");
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

        public Criteria andInforVersionIsNull() {
            addCriterion("infor_version is null");
            return (Criteria) this;
        }

        public Criteria andInforVersionIsNotNull() {
            addCriterion("infor_version is not null");
            return (Criteria) this;
        }

        public Criteria andInforVersionEqualTo(String value) {
            addCriterion("infor_version =", value, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionNotEqualTo(String value) {
            addCriterion("infor_version <>", value, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionGreaterThan(String value) {
            addCriterion("infor_version >", value, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionGreaterThanOrEqualTo(String value) {
            addCriterion("infor_version >=", value, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionLessThan(String value) {
            addCriterion("infor_version <", value, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionLessThanOrEqualTo(String value) {
            addCriterion("infor_version <=", value, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionLike(String value) {
            addCriterion("infor_version like", value, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionNotLike(String value) {
            addCriterion("infor_version not like", value, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionIn(List<String> values) {
            addCriterion("infor_version in", values, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionNotIn(List<String> values) {
            addCriterion("infor_version not in", values, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionBetween(String value1, String value2) {
            addCriterion("infor_version between", value1, value2, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andInforVersionNotBetween(String value1, String value2) {
            addCriterion("infor_version not between", value1, value2, "inforVersion");
            return (Criteria) this;
        }

        public Criteria andBusIdIsNull() {
            addCriterion("bus_id is null");
            return (Criteria) this;
        }

        public Criteria andBusIdIsNotNull() {
            addCriterion("bus_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusIdEqualTo(String value) {
            addCriterion("bus_id =", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdNotEqualTo(String value) {
            addCriterion("bus_id <>", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdGreaterThan(String value) {
            addCriterion("bus_id >", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdGreaterThanOrEqualTo(String value) {
            addCriterion("bus_id >=", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdLessThan(String value) {
            addCriterion("bus_id <", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdLessThanOrEqualTo(String value) {
            addCriterion("bus_id <=", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdLike(String value) {
            addCriterion("bus_id like", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdNotLike(String value) {
            addCriterion("bus_id not like", value, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdIn(List<String> values) {
            addCriterion("bus_id in", values, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdNotIn(List<String> values) {
            addCriterion("bus_id not in", values, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdBetween(String value1, String value2) {
            addCriterion("bus_id between", value1, value2, "busId");
            return (Criteria) this;
        }

        public Criteria andBusIdNotBetween(String value1, String value2) {
            addCriterion("bus_id not between", value1, value2, "busId");
            return (Criteria) this;
        }

        public Criteria andBusTypeIsNull() {
            addCriterion("bus_type is null");
            return (Criteria) this;
        }

        public Criteria andBusTypeIsNotNull() {
            addCriterion("bus_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusTypeEqualTo(String value) {
            addCriterion("bus_type =", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotEqualTo(String value) {
            addCriterion("bus_type <>", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeGreaterThan(String value) {
            addCriterion("bus_type >", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bus_type >=", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLessThan(String value) {
            addCriterion("bus_type <", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLessThanOrEqualTo(String value) {
            addCriterion("bus_type <=", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeLike(String value) {
            addCriterion("bus_type like", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotLike(String value) {
            addCriterion("bus_type not like", value, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeIn(List<String> values) {
            addCriterion("bus_type in", values, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotIn(List<String> values) {
            addCriterion("bus_type not in", values, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeBetween(String value1, String value2) {
            addCriterion("bus_type between", value1, value2, "busType");
            return (Criteria) this;
        }

        public Criteria andBusTypeNotBetween(String value1, String value2) {
            addCriterion("bus_type not between", value1, value2, "busType");
            return (Criteria) this;
        }

        public Criteria andBusDomainIsNull() {
            addCriterion("bus_domain is null");
            return (Criteria) this;
        }

        public Criteria andBusDomainIsNotNull() {
            addCriterion("bus_domain is not null");
            return (Criteria) this;
        }

        public Criteria andBusDomainEqualTo(String value) {
            addCriterion("bus_domain =", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainNotEqualTo(String value) {
            addCriterion("bus_domain <>", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainGreaterThan(String value) {
            addCriterion("bus_domain >", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainGreaterThanOrEqualTo(String value) {
            addCriterion("bus_domain >=", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainLessThan(String value) {
            addCriterion("bus_domain <", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainLessThanOrEqualTo(String value) {
            addCriterion("bus_domain <=", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainLike(String value) {
            addCriterion("bus_domain like", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainNotLike(String value) {
            addCriterion("bus_domain not like", value, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainIn(List<String> values) {
            addCriterion("bus_domain in", values, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainNotIn(List<String> values) {
            addCriterion("bus_domain not in", values, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainBetween(String value1, String value2) {
            addCriterion("bus_domain between", value1, value2, "busDomain");
            return (Criteria) this;
        }

        public Criteria andBusDomainNotBetween(String value1, String value2) {
            addCriterion("bus_domain not between", value1, value2, "busDomain");
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
package com.sunrise.oa.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SealsVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SealsVOExample() {
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

    protected abstract static class GeneratedCriteria implements Serializable {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSealnameIsNull() {
            addCriterion("SealName is null");
            return (Criteria) this;
        }

        public Criteria andSealnameIsNotNull() {
            addCriterion("SealName is not null");
            return (Criteria) this;
        }

        public Criteria andSealnameEqualTo(String value) {
            addCriterion("SealName =", value, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameNotEqualTo(String value) {
            addCriterion("SealName <>", value, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameGreaterThan(String value) {
            addCriterion("SealName >", value, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameGreaterThanOrEqualTo(String value) {
            addCriterion("SealName >=", value, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameLessThan(String value) {
            addCriterion("SealName <", value, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameLessThanOrEqualTo(String value) {
            addCriterion("SealName <=", value, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameLike(String value) {
            addCriterion("SealName like", value, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameNotLike(String value) {
            addCriterion("SealName not like", value, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameIn(List<String> values) {
            addCriterion("SealName in", values, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameNotIn(List<String> values) {
            addCriterion("SealName not in", values, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameBetween(String value1, String value2) {
            addCriterion("SealName between", value1, value2, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealnameNotBetween(String value1, String value2) {
            addCriterion("SealName not between", value1, value2, "sealname");
            return (Criteria) this;
        }

        public Criteria andSealtypeIsNull() {
            addCriterion("SealType is null");
            return (Criteria) this;
        }

        public Criteria andSealtypeIsNotNull() {
            addCriterion("SealType is not null");
            return (Criteria) this;
        }

        public Criteria andSealtypeEqualTo(String value) {
            addCriterion("SealType =", value, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeNotEqualTo(String value) {
            addCriterion("SealType <>", value, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeGreaterThan(String value) {
            addCriterion("SealType >", value, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeGreaterThanOrEqualTo(String value) {
            addCriterion("SealType >=", value, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeLessThan(String value) {
            addCriterion("SealType <", value, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeLessThanOrEqualTo(String value) {
            addCriterion("SealType <=", value, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeLike(String value) {
            addCriterion("SealType like", value, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeNotLike(String value) {
            addCriterion("SealType not like", value, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeIn(List<String> values) {
            addCriterion("SealType in", values, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeNotIn(List<String> values) {
            addCriterion("SealType not in", values, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeBetween(String value1, String value2) {
            addCriterion("SealType between", value1, value2, "sealtype");
            return (Criteria) this;
        }

        public Criteria andSealtypeNotBetween(String value1, String value2) {
            addCriterion("SealType not between", value1, value2, "sealtype");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNull() {
            addCriterion("DeptID is null");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNotNull() {
            addCriterion("DeptID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptidEqualTo(Integer value) {
            addCriterion("DeptID =", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotEqualTo(Integer value) {
            addCriterion("DeptID <>", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThan(Integer value) {
            addCriterion("DeptID >", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DeptID >=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThan(Integer value) {
            addCriterion("DeptID <", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThanOrEqualTo(Integer value) {
            addCriterion("DeptID <=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidIn(List<Integer> values) {
            addCriterion("DeptID in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotIn(List<Integer> values) {
            addCriterion("DeptID not in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidBetween(Integer value1, Integer value2) {
            addCriterion("DeptID between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotBetween(Integer value1, Integer value2) {
            addCriterion("DeptID not between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("DeptName is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("DeptName is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(String value) {
            addCriterion("DeptName =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(String value) {
            addCriterion("DeptName <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(String value) {
            addCriterion("DeptName >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("DeptName >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(String value) {
            addCriterion("DeptName <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(String value) {
            addCriterion("DeptName <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLike(String value) {
            addCriterion("DeptName like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotLike(String value) {
            addCriterion("DeptName not like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<String> values) {
            addCriterion("DeptName in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<String> values) {
            addCriterion("DeptName not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(String value1, String value2) {
            addCriterion("DeptName between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(String value1, String value2) {
            addCriterion("DeptName not between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andSigneridIsNull() {
            addCriterion("SignerID is null");
            return (Criteria) this;
        }

        public Criteria andSigneridIsNotNull() {
            addCriterion("SignerID is not null");
            return (Criteria) this;
        }

        public Criteria andSigneridEqualTo(Integer value) {
            addCriterion("SignerID =", value, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridNotEqualTo(Integer value) {
            addCriterion("SignerID <>", value, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridGreaterThan(Integer value) {
            addCriterion("SignerID >", value, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridGreaterThanOrEqualTo(Integer value) {
            addCriterion("SignerID >=", value, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridLessThan(Integer value) {
            addCriterion("SignerID <", value, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridLessThanOrEqualTo(Integer value) {
            addCriterion("SignerID <=", value, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridIn(List<Integer> values) {
            addCriterion("SignerID in", values, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridNotIn(List<Integer> values) {
            addCriterion("SignerID not in", values, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridBetween(Integer value1, Integer value2) {
            addCriterion("SignerID between", value1, value2, "signerid");
            return (Criteria) this;
        }

        public Criteria andSigneridNotBetween(Integer value1, Integer value2) {
            addCriterion("SignerID not between", value1, value2, "signerid");
            return (Criteria) this;
        }

        public Criteria andSignernameIsNull() {
            addCriterion("SignerName is null");
            return (Criteria) this;
        }

        public Criteria andSignernameIsNotNull() {
            addCriterion("SignerName is not null");
            return (Criteria) this;
        }

        public Criteria andSignernameEqualTo(String value) {
            addCriterion("SignerName =", value, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameNotEqualTo(String value) {
            addCriterion("SignerName <>", value, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameGreaterThan(String value) {
            addCriterion("SignerName >", value, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameGreaterThanOrEqualTo(String value) {
            addCriterion("SignerName >=", value, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameLessThan(String value) {
            addCriterion("SignerName <", value, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameLessThanOrEqualTo(String value) {
            addCriterion("SignerName <=", value, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameLike(String value) {
            addCriterion("SignerName like", value, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameNotLike(String value) {
            addCriterion("SignerName not like", value, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameIn(List<String> values) {
            addCriterion("SignerName in", values, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameNotIn(List<String> values) {
            addCriterion("SignerName not in", values, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameBetween(String value1, String value2) {
            addCriterion("SignerName between", value1, value2, "signername");
            return (Criteria) this;
        }

        public Criteria andSignernameNotBetween(String value1, String value2) {
            addCriterion("SignerName not between", value1, value2, "signername");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("Status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("Status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("Description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("Description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("Description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("Description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("Description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("Description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("Description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("Description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("Description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("Description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("Description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("Description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("Description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andAuthtypeIsNull() {
            addCriterion("AuthType is null");
            return (Criteria) this;
        }

        public Criteria andAuthtypeIsNotNull() {
            addCriterion("AuthType is not null");
            return (Criteria) this;
        }

        public Criteria andAuthtypeEqualTo(String value) {
            addCriterion("AuthType =", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeNotEqualTo(String value) {
            addCriterion("AuthType <>", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeGreaterThan(String value) {
            addCriterion("AuthType >", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeGreaterThanOrEqualTo(String value) {
            addCriterion("AuthType >=", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeLessThan(String value) {
            addCriterion("AuthType <", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeLessThanOrEqualTo(String value) {
            addCriterion("AuthType <=", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeLike(String value) {
            addCriterion("AuthType like", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeNotLike(String value) {
            addCriterion("AuthType not like", value, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeIn(List<String> values) {
            addCriterion("AuthType in", values, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeNotIn(List<String> values) {
            addCriterion("AuthType not in", values, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeBetween(String value1, String value2) {
            addCriterion("AuthType between", value1, value2, "authtype");
            return (Criteria) this;
        }

        public Criteria andAuthtypeNotBetween(String value1, String value2) {
            addCriterion("AuthType not between", value1, value2, "authtype");
            return (Criteria) this;
        }

        public Criteria andCertserialnumIsNull() {
            addCriterion("CertSerialNum is null");
            return (Criteria) this;
        }

        public Criteria andCertserialnumIsNotNull() {
            addCriterion("CertSerialNum is not null");
            return (Criteria) this;
        }

        public Criteria andCertserialnumEqualTo(String value) {
            addCriterion("CertSerialNum =", value, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumNotEqualTo(String value) {
            addCriterion("CertSerialNum <>", value, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumGreaterThan(String value) {
            addCriterion("CertSerialNum >", value, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumGreaterThanOrEqualTo(String value) {
            addCriterion("CertSerialNum >=", value, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumLessThan(String value) {
            addCriterion("CertSerialNum <", value, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumLessThanOrEqualTo(String value) {
            addCriterion("CertSerialNum <=", value, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumLike(String value) {
            addCriterion("CertSerialNum like", value, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumNotLike(String value) {
            addCriterion("CertSerialNum not like", value, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumIn(List<String> values) {
            addCriterion("CertSerialNum in", values, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumNotIn(List<String> values) {
            addCriterion("CertSerialNum not in", values, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumBetween(String value1, String value2) {
            addCriterion("CertSerialNum between", value1, value2, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andCertserialnumNotBetween(String value1, String value2) {
            addCriterion("CertSerialNum not between", value1, value2, "certserialnum");
            return (Criteria) this;
        }

        public Criteria andIssuetoIsNull() {
            addCriterion("IssueTo is null");
            return (Criteria) this;
        }

        public Criteria andIssuetoIsNotNull() {
            addCriterion("IssueTo is not null");
            return (Criteria) this;
        }

        public Criteria andIssuetoEqualTo(String value) {
            addCriterion("IssueTo =", value, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoNotEqualTo(String value) {
            addCriterion("IssueTo <>", value, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoGreaterThan(String value) {
            addCriterion("IssueTo >", value, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoGreaterThanOrEqualTo(String value) {
            addCriterion("IssueTo >=", value, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoLessThan(String value) {
            addCriterion("IssueTo <", value, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoLessThanOrEqualTo(String value) {
            addCriterion("IssueTo <=", value, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoLike(String value) {
            addCriterion("IssueTo like", value, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoNotLike(String value) {
            addCriterion("IssueTo not like", value, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoIn(List<String> values) {
            addCriterion("IssueTo in", values, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoNotIn(List<String> values) {
            addCriterion("IssueTo not in", values, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoBetween(String value1, String value2) {
            addCriterion("IssueTo between", value1, value2, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuetoNotBetween(String value1, String value2) {
            addCriterion("IssueTo not between", value1, value2, "issueto");
            return (Criteria) this;
        }

        public Criteria andIssuebyIsNull() {
            addCriterion("IssueBy is null");
            return (Criteria) this;
        }

        public Criteria andIssuebyIsNotNull() {
            addCriterion("IssueBy is not null");
            return (Criteria) this;
        }

        public Criteria andIssuebyEqualTo(String value) {
            addCriterion("IssueBy =", value, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyNotEqualTo(String value) {
            addCriterion("IssueBy <>", value, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyGreaterThan(String value) {
            addCriterion("IssueBy >", value, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyGreaterThanOrEqualTo(String value) {
            addCriterion("IssueBy >=", value, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyLessThan(String value) {
            addCriterion("IssueBy <", value, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyLessThanOrEqualTo(String value) {
            addCriterion("IssueBy <=", value, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyLike(String value) {
            addCriterion("IssueBy like", value, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyNotLike(String value) {
            addCriterion("IssueBy not like", value, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyIn(List<String> values) {
            addCriterion("IssueBy in", values, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyNotIn(List<String> values) {
            addCriterion("IssueBy not in", values, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyBetween(String value1, String value2) {
            addCriterion("IssueBy between", value1, value2, "issueby");
            return (Criteria) this;
        }

        public Criteria andIssuebyNotBetween(String value1, String value2) {
            addCriterion("IssueBy not between", value1, value2, "issueby");
            return (Criteria) this;
        }

        public Criteria andValidfromIsNull() {
            addCriterion("ValidFrom is null");
            return (Criteria) this;
        }

        public Criteria andValidfromIsNotNull() {
            addCriterion("ValidFrom is not null");
            return (Criteria) this;
        }

        public Criteria andValidfromEqualTo(Date value) {
            addCriterionForJDBCDate("ValidFrom =", value, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromNotEqualTo(Date value) {
            addCriterionForJDBCDate("ValidFrom <>", value, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromGreaterThan(Date value) {
            addCriterionForJDBCDate("ValidFrom >", value, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ValidFrom >=", value, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromLessThan(Date value) {
            addCriterionForJDBCDate("ValidFrom <", value, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ValidFrom <=", value, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromIn(List<Date> values) {
            addCriterionForJDBCDate("ValidFrom in", values, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromNotIn(List<Date> values) {
            addCriterionForJDBCDate("ValidFrom not in", values, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ValidFrom between", value1, value2, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidfromNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ValidFrom not between", value1, value2, "validfrom");
            return (Criteria) this;
        }

        public Criteria andValidtoIsNull() {
            addCriterion("ValidTo is null");
            return (Criteria) this;
        }

        public Criteria andValidtoIsNotNull() {
            addCriterion("ValidTo is not null");
            return (Criteria) this;
        }

        public Criteria andValidtoEqualTo(Date value) {
            addCriterionForJDBCDate("ValidTo =", value, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoNotEqualTo(Date value) {
            addCriterionForJDBCDate("ValidTo <>", value, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoGreaterThan(Date value) {
            addCriterionForJDBCDate("ValidTo >", value, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ValidTo >=", value, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoLessThan(Date value) {
            addCriterionForJDBCDate("ValidTo <", value, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ValidTo <=", value, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoIn(List<Date> values) {
            addCriterionForJDBCDate("ValidTo in", values, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoNotIn(List<Date> values) {
            addCriterionForJDBCDate("ValidTo not in", values, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ValidTo between", value1, value2, "validto");
            return (Criteria) this;
        }

        public Criteria andValidtoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ValidTo not between", value1, value2, "validto");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeIsNull() {
            addCriterion("SealImageType is null");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeIsNotNull() {
            addCriterion("SealImageType is not null");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeEqualTo(String value) {
            addCriterion("SealImageType =", value, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeNotEqualTo(String value) {
            addCriterion("SealImageType <>", value, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeGreaterThan(String value) {
            addCriterion("SealImageType >", value, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeGreaterThanOrEqualTo(String value) {
            addCriterion("SealImageType >=", value, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeLessThan(String value) {
            addCriterion("SealImageType <", value, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeLessThanOrEqualTo(String value) {
            addCriterion("SealImageType <=", value, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeLike(String value) {
            addCriterion("SealImageType like", value, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeNotLike(String value) {
            addCriterion("SealImageType not like", value, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeIn(List<String> values) {
            addCriterion("SealImageType in", values, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeNotIn(List<String> values) {
            addCriterion("SealImageType not in", values, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeBetween(String value1, String value2) {
            addCriterion("SealImageType between", value1, value2, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andSealimagetypeNotBetween(String value1, String value2) {
            addCriterion("SealImageType not between", value1, value2, "sealimagetype");
            return (Criteria) this;
        }

        public Criteria andVcodeIsNull() {
            addCriterion("Vcode is null");
            return (Criteria) this;
        }

        public Criteria andVcodeIsNotNull() {
            addCriterion("Vcode is not null");
            return (Criteria) this;
        }

        public Criteria andVcodeEqualTo(String value) {
            addCriterion("Vcode =", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotEqualTo(String value) {
            addCriterion("Vcode <>", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThan(String value) {
            addCriterion("Vcode >", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeGreaterThanOrEqualTo(String value) {
            addCriterion("Vcode >=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThan(String value) {
            addCriterion("Vcode <", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLessThanOrEqualTo(String value) {
            addCriterion("Vcode <=", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeLike(String value) {
            addCriterion("Vcode like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotLike(String value) {
            addCriterion("Vcode not like", value, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeIn(List<String> values) {
            addCriterion("Vcode in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotIn(List<String> values) {
            addCriterion("Vcode not in", values, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeBetween(String value1, String value2) {
            addCriterion("Vcode between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andVcodeNotBetween(String value1, String value2) {
            addCriterion("Vcode not between", value1, value2, "vcode");
            return (Criteria) this;
        }

        public Criteria andFilecodeIsNull() {
            addCriterion("filecode is null");
            return (Criteria) this;
        }

        public Criteria andFilecodeIsNotNull() {
            addCriterion("filecode is not null");
            return (Criteria) this;
        }

        public Criteria andFilecodeEqualTo(String value) {
            addCriterion("filecode =", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotEqualTo(String value) {
            addCriterion("filecode <>", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeGreaterThan(String value) {
            addCriterion("filecode >", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeGreaterThanOrEqualTo(String value) {
            addCriterion("filecode >=", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLessThan(String value) {
            addCriterion("filecode <", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLessThanOrEqualTo(String value) {
            addCriterion("filecode <=", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLike(String value) {
            addCriterion("filecode like", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotLike(String value) {
            addCriterion("filecode not like", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeIn(List<String> values) {
            addCriterion("filecode in", values, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotIn(List<String> values) {
            addCriterion("filecode not in", values, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeBetween(String value1, String value2) {
            addCriterion("filecode between", value1, value2, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotBetween(String value1, String value2) {
            addCriterion("filecode not between", value1, value2, "filecode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeIsNull() {
            addCriterion("cachetcode is null");
            return (Criteria) this;
        }

        public Criteria andCachetcodeIsNotNull() {
            addCriterion("cachetcode is not null");
            return (Criteria) this;
        }

        public Criteria andCachetcodeEqualTo(String value) {
            addCriterion("cachetcode =", value, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeNotEqualTo(String value) {
            addCriterion("cachetcode <>", value, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeGreaterThan(String value) {
            addCriterion("cachetcode >", value, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cachetcode >=", value, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeLessThan(String value) {
            addCriterion("cachetcode <", value, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeLessThanOrEqualTo(String value) {
            addCriterion("cachetcode <=", value, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeLike(String value) {
            addCriterion("cachetcode like", value, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeNotLike(String value) {
            addCriterion("cachetcode not like", value, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeIn(List<String> values) {
            addCriterion("cachetcode in", values, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeNotIn(List<String> values) {
            addCriterion("cachetcode not in", values, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeBetween(String value1, String value2) {
            addCriterion("cachetcode between", value1, value2, "cachetcode");
            return (Criteria) this;
        }

        public Criteria andCachetcodeNotBetween(String value1, String value2) {
            addCriterion("cachetcode not between", value1, value2, "cachetcode");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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
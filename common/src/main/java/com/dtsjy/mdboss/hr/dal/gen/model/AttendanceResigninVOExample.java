package com.dtsjy.mdboss.hr.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceResigninVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendanceResigninVOExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorknoIsNull() {
            addCriterion("workno is null");
            return (Criteria) this;
        }

        public Criteria andWorknoIsNotNull() {
            addCriterion("workno is not null");
            return (Criteria) this;
        }

        public Criteria andWorknoEqualTo(String value) {
            addCriterion("workno =", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoNotEqualTo(String value) {
            addCriterion("workno <>", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoGreaterThan(String value) {
            addCriterion("workno >", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoGreaterThanOrEqualTo(String value) {
            addCriterion("workno >=", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoLessThan(String value) {
            addCriterion("workno <", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoLessThanOrEqualTo(String value) {
            addCriterion("workno <=", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoLike(String value) {
            addCriterion("workno like", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoNotLike(String value) {
            addCriterion("workno not like", value, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoIn(List<String> values) {
            addCriterion("workno in", values, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoNotIn(List<String> values) {
            addCriterion("workno not in", values, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoBetween(String value1, String value2) {
            addCriterion("workno between", value1, value2, "workno");
            return (Criteria) this;
        }

        public Criteria andWorknoNotBetween(String value1, String value2) {
            addCriterion("workno not between", value1, value2, "workno");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNull() {
            addCriterion("usercode is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("usercode is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(String value) {
            addCriterion("usercode =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(String value) {
            addCriterion("usercode <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(String value) {
            addCriterion("usercode >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(String value) {
            addCriterion("usercode >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(String value) {
            addCriterion("usercode <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(String value) {
            addCriterion("usercode <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLike(String value) {
            addCriterion("usercode like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotLike(String value) {
            addCriterion("usercode not like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<String> values) {
            addCriterion("usercode in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<String> values) {
            addCriterion("usercode not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(String value1, String value2) {
            addCriterion("usercode between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(String value1, String value2) {
            addCriterion("usercode not between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNull() {
            addCriterion("orgcode is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("orgcode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeEqualTo(String value) {
            addCriterion("orgcode =", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotEqualTo(String value) {
            addCriterion("orgcode <>", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThan(String value) {
            addCriterion("orgcode >", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgcode >=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThan(String value) {
            addCriterion("orgcode <", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("orgcode <=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLike(String value) {
            addCriterion("orgcode like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotLike(String value) {
            addCriterion("orgcode not like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIn(List<String> values) {
            addCriterion("orgcode in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotIn(List<String> values) {
            addCriterion("orgcode not in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeBetween(String value1, String value2) {
            addCriterion("orgcode between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotBetween(String value1, String value2) {
            addCriterion("orgcode not between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNull() {
            addCriterion("orgname is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("orgname is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("orgname =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("orgname <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("orgname >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("orgname >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("orgname <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("orgname <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("orgname like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("orgname not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(List<String> values) {
            addCriterion("orgname in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(List<String> values) {
            addCriterion("orgname not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("orgname between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("orgname not between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelIsNull() {
            addCriterion("positionlevel is null");
            return (Criteria) this;
        }

        public Criteria andPositionlevelIsNotNull() {
            addCriterion("positionlevel is not null");
            return (Criteria) this;
        }

        public Criteria andPositionlevelEqualTo(String value) {
            addCriterion("positionlevel =", value, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelNotEqualTo(String value) {
            addCriterion("positionlevel <>", value, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelGreaterThan(String value) {
            addCriterion("positionlevel >", value, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelGreaterThanOrEqualTo(String value) {
            addCriterion("positionlevel >=", value, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelLessThan(String value) {
            addCriterion("positionlevel <", value, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelLessThanOrEqualTo(String value) {
            addCriterion("positionlevel <=", value, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelLike(String value) {
            addCriterion("positionlevel like", value, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelNotLike(String value) {
            addCriterion("positionlevel not like", value, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelIn(List<String> values) {
            addCriterion("positionlevel in", values, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelNotIn(List<String> values) {
            addCriterion("positionlevel not in", values, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelBetween(String value1, String value2) {
            addCriterion("positionlevel between", value1, value2, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andPositionlevelNotBetween(String value1, String value2) {
            addCriterion("positionlevel not between", value1, value2, "positionlevel");
            return (Criteria) this;
        }

        public Criteria andResidentcodeIsNull() {
            addCriterion("residentcode is null");
            return (Criteria) this;
        }

        public Criteria andResidentcodeIsNotNull() {
            addCriterion("residentcode is not null");
            return (Criteria) this;
        }

        public Criteria andResidentcodeEqualTo(String value) {
            addCriterion("residentcode =", value, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeNotEqualTo(String value) {
            addCriterion("residentcode <>", value, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeGreaterThan(String value) {
            addCriterion("residentcode >", value, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("residentcode >=", value, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeLessThan(String value) {
            addCriterion("residentcode <", value, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeLessThanOrEqualTo(String value) {
            addCriterion("residentcode <=", value, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeLike(String value) {
            addCriterion("residentcode like", value, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeNotLike(String value) {
            addCriterion("residentcode not like", value, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeIn(List<String> values) {
            addCriterion("residentcode in", values, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeNotIn(List<String> values) {
            addCriterion("residentcode not in", values, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeBetween(String value1, String value2) {
            addCriterion("residentcode between", value1, value2, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentcodeNotBetween(String value1, String value2) {
            addCriterion("residentcode not between", value1, value2, "residentcode");
            return (Criteria) this;
        }

        public Criteria andResidentnameIsNull() {
            addCriterion("residentname is null");
            return (Criteria) this;
        }

        public Criteria andResidentnameIsNotNull() {
            addCriterion("residentname is not null");
            return (Criteria) this;
        }

        public Criteria andResidentnameEqualTo(String value) {
            addCriterion("residentname =", value, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameNotEqualTo(String value) {
            addCriterion("residentname <>", value, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameGreaterThan(String value) {
            addCriterion("residentname >", value, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameGreaterThanOrEqualTo(String value) {
            addCriterion("residentname >=", value, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameLessThan(String value) {
            addCriterion("residentname <", value, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameLessThanOrEqualTo(String value) {
            addCriterion("residentname <=", value, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameLike(String value) {
            addCriterion("residentname like", value, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameNotLike(String value) {
            addCriterion("residentname not like", value, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameIn(List<String> values) {
            addCriterion("residentname in", values, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameNotIn(List<String> values) {
            addCriterion("residentname not in", values, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameBetween(String value1, String value2) {
            addCriterion("residentname between", value1, value2, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentnameNotBetween(String value1, String value2) {
            addCriterion("residentname not between", value1, value2, "residentname");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceIsNull() {
            addCriterion("residentprovince is null");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceIsNotNull() {
            addCriterion("residentprovince is not null");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceEqualTo(String value) {
            addCriterion("residentprovince =", value, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceNotEqualTo(String value) {
            addCriterion("residentprovince <>", value, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceGreaterThan(String value) {
            addCriterion("residentprovince >", value, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("residentprovince >=", value, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceLessThan(String value) {
            addCriterion("residentprovince <", value, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceLessThanOrEqualTo(String value) {
            addCriterion("residentprovince <=", value, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceLike(String value) {
            addCriterion("residentprovince like", value, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceNotLike(String value) {
            addCriterion("residentprovince not like", value, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceIn(List<String> values) {
            addCriterion("residentprovince in", values, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceNotIn(List<String> values) {
            addCriterion("residentprovince not in", values, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceBetween(String value1, String value2) {
            addCriterion("residentprovince between", value1, value2, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentprovinceNotBetween(String value1, String value2) {
            addCriterion("residentprovince not between", value1, value2, "residentprovince");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeIsNull() {
            addCriterion("residentaddresscode is null");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeIsNotNull() {
            addCriterion("residentaddresscode is not null");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeEqualTo(String value) {
            addCriterion("residentaddresscode =", value, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeNotEqualTo(String value) {
            addCriterion("residentaddresscode <>", value, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeGreaterThan(String value) {
            addCriterion("residentaddresscode >", value, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeGreaterThanOrEqualTo(String value) {
            addCriterion("residentaddresscode >=", value, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeLessThan(String value) {
            addCriterion("residentaddresscode <", value, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeLessThanOrEqualTo(String value) {
            addCriterion("residentaddresscode <=", value, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeLike(String value) {
            addCriterion("residentaddresscode like", value, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeNotLike(String value) {
            addCriterion("residentaddresscode not like", value, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeIn(List<String> values) {
            addCriterion("residentaddresscode in", values, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeNotIn(List<String> values) {
            addCriterion("residentaddresscode not in", values, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeBetween(String value1, String value2) {
            addCriterion("residentaddresscode between", value1, value2, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddresscodeNotBetween(String value1, String value2) {
            addCriterion("residentaddresscode not between", value1, value2, "residentaddresscode");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameIsNull() {
            addCriterion("residentaddressname is null");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameIsNotNull() {
            addCriterion("residentaddressname is not null");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameEqualTo(String value) {
            addCriterion("residentaddressname =", value, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameNotEqualTo(String value) {
            addCriterion("residentaddressname <>", value, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameGreaterThan(String value) {
            addCriterion("residentaddressname >", value, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameGreaterThanOrEqualTo(String value) {
            addCriterion("residentaddressname >=", value, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameLessThan(String value) {
            addCriterion("residentaddressname <", value, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameLessThanOrEqualTo(String value) {
            addCriterion("residentaddressname <=", value, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameLike(String value) {
            addCriterion("residentaddressname like", value, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameNotLike(String value) {
            addCriterion("residentaddressname not like", value, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameIn(List<String> values) {
            addCriterion("residentaddressname in", values, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameNotIn(List<String> values) {
            addCriterion("residentaddressname not in", values, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameBetween(String value1, String value2) {
            addCriterion("residentaddressname between", value1, value2, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andResidentaddressnameNotBetween(String value1, String value2) {
            addCriterion("residentaddressname not between", value1, value2, "residentaddressname");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceIsNull() {
            addCriterion("belongprovince is null");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceIsNotNull() {
            addCriterion("belongprovince is not null");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceEqualTo(String value) {
            addCriterion("belongprovince =", value, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceNotEqualTo(String value) {
            addCriterion("belongprovince <>", value, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceGreaterThan(String value) {
            addCriterion("belongprovince >", value, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("belongprovince >=", value, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceLessThan(String value) {
            addCriterion("belongprovince <", value, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceLessThanOrEqualTo(String value) {
            addCriterion("belongprovince <=", value, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceLike(String value) {
            addCriterion("belongprovince like", value, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceNotLike(String value) {
            addCriterion("belongprovince not like", value, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceIn(List<String> values) {
            addCriterion("belongprovince in", values, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceNotIn(List<String> values) {
            addCriterion("belongprovince not in", values, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceBetween(String value1, String value2) {
            addCriterion("belongprovince between", value1, value2, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andBelongprovinceNotBetween(String value1, String value2) {
            addCriterion("belongprovince not between", value1, value2, "belongprovince");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneIsNull() {
            addCriterion("isspecialzone is null");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneIsNotNull() {
            addCriterion("isspecialzone is not null");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneEqualTo(String value) {
            addCriterion("isspecialzone =", value, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneNotEqualTo(String value) {
            addCriterion("isspecialzone <>", value, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneGreaterThan(String value) {
            addCriterion("isspecialzone >", value, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneGreaterThanOrEqualTo(String value) {
            addCriterion("isspecialzone >=", value, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneLessThan(String value) {
            addCriterion("isspecialzone <", value, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneLessThanOrEqualTo(String value) {
            addCriterion("isspecialzone <=", value, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneLike(String value) {
            addCriterion("isspecialzone like", value, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneNotLike(String value) {
            addCriterion("isspecialzone not like", value, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneIn(List<String> values) {
            addCriterion("isspecialzone in", values, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneNotIn(List<String> values) {
            addCriterion("isspecialzone not in", values, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneBetween(String value1, String value2) {
            addCriterion("isspecialzone between", value1, value2, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andIsspecialzoneNotBetween(String value1, String value2) {
            addCriterion("isspecialzone not between", value1, value2, "isspecialzone");
            return (Criteria) this;
        }

        public Criteria andResignintimeIsNull() {
            addCriterion("resignintime is null");
            return (Criteria) this;
        }

        public Criteria andResignintimeIsNotNull() {
            addCriterion("resignintime is not null");
            return (Criteria) this;
        }

        public Criteria andResignintimeEqualTo(Date value) {
            addCriterion("resignintime =", value, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeNotEqualTo(Date value) {
            addCriterion("resignintime <>", value, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeGreaterThan(Date value) {
            addCriterion("resignintime >", value, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resignintime >=", value, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeLessThan(Date value) {
            addCriterion("resignintime <", value, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeLessThanOrEqualTo(Date value) {
            addCriterion("resignintime <=", value, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeIn(List<Date> values) {
            addCriterion("resignintime in", values, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeNotIn(List<Date> values) {
            addCriterion("resignintime not in", values, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeBetween(Date value1, Date value2) {
            addCriterion("resignintime between", value1, value2, "resignintime");
            return (Criteria) this;
        }

        public Criteria andResignintimeNotBetween(Date value1, Date value2) {
            addCriterion("resignintime not between", value1, value2, "resignintime");
            return (Criteria) this;
        }

        public Criteria andAddresstypeIsNull() {
            addCriterion("addresstype is null");
            return (Criteria) this;
        }

        public Criteria andAddresstypeIsNotNull() {
            addCriterion("addresstype is not null");
            return (Criteria) this;
        }

        public Criteria andAddresstypeEqualTo(String value) {
            addCriterion("addresstype =", value, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeNotEqualTo(String value) {
            addCriterion("addresstype <>", value, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeGreaterThan(String value) {
            addCriterion("addresstype >", value, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeGreaterThanOrEqualTo(String value) {
            addCriterion("addresstype >=", value, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeLessThan(String value) {
            addCriterion("addresstype <", value, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeLessThanOrEqualTo(String value) {
            addCriterion("addresstype <=", value, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeLike(String value) {
            addCriterion("addresstype like", value, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeNotLike(String value) {
            addCriterion("addresstype not like", value, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeIn(List<String> values) {
            addCriterion("addresstype in", values, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeNotIn(List<String> values) {
            addCriterion("addresstype not in", values, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeBetween(String value1, String value2) {
            addCriterion("addresstype between", value1, value2, "addresstype");
            return (Criteria) this;
        }

        public Criteria andAddresstypeNotBetween(String value1, String value2) {
            addCriterion("addresstype not between", value1, value2, "addresstype");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeIsNull() {
            addCriterion("resignincitycode is null");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeIsNotNull() {
            addCriterion("resignincitycode is not null");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeEqualTo(String value) {
            addCriterion("resignincitycode =", value, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeNotEqualTo(String value) {
            addCriterion("resignincitycode <>", value, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeGreaterThan(String value) {
            addCriterion("resignincitycode >", value, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("resignincitycode >=", value, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeLessThan(String value) {
            addCriterion("resignincitycode <", value, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeLessThanOrEqualTo(String value) {
            addCriterion("resignincitycode <=", value, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeLike(String value) {
            addCriterion("resignincitycode like", value, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeNotLike(String value) {
            addCriterion("resignincitycode not like", value, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeIn(List<String> values) {
            addCriterion("resignincitycode in", values, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeNotIn(List<String> values) {
            addCriterion("resignincitycode not in", values, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeBetween(String value1, String value2) {
            addCriterion("resignincitycode between", value1, value2, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitycodeNotBetween(String value1, String value2) {
            addCriterion("resignincitycode not between", value1, value2, "resignincitycode");
            return (Criteria) this;
        }

        public Criteria andResignincitynameIsNull() {
            addCriterion("resignincityname is null");
            return (Criteria) this;
        }

        public Criteria andResignincitynameIsNotNull() {
            addCriterion("resignincityname is not null");
            return (Criteria) this;
        }

        public Criteria andResignincitynameEqualTo(String value) {
            addCriterion("resignincityname =", value, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameNotEqualTo(String value) {
            addCriterion("resignincityname <>", value, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameGreaterThan(String value) {
            addCriterion("resignincityname >", value, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameGreaterThanOrEqualTo(String value) {
            addCriterion("resignincityname >=", value, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameLessThan(String value) {
            addCriterion("resignincityname <", value, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameLessThanOrEqualTo(String value) {
            addCriterion("resignincityname <=", value, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameLike(String value) {
            addCriterion("resignincityname like", value, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameNotLike(String value) {
            addCriterion("resignincityname not like", value, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameIn(List<String> values) {
            addCriterion("resignincityname in", values, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameNotIn(List<String> values) {
            addCriterion("resignincityname not in", values, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameBetween(String value1, String value2) {
            addCriterion("resignincityname between", value1, value2, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andResignincitynameNotBetween(String value1, String value2) {
            addCriterion("resignincityname not between", value1, value2, "resignincityname");
            return (Criteria) this;
        }

        public Criteria andOtherplaceIsNull() {
            addCriterion("otherplace is null");
            return (Criteria) this;
        }

        public Criteria andOtherplaceIsNotNull() {
            addCriterion("otherplace is not null");
            return (Criteria) this;
        }

        public Criteria andOtherplaceEqualTo(String value) {
            addCriterion("otherplace =", value, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceNotEqualTo(String value) {
            addCriterion("otherplace <>", value, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceGreaterThan(String value) {
            addCriterion("otherplace >", value, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceGreaterThanOrEqualTo(String value) {
            addCriterion("otherplace >=", value, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceLessThan(String value) {
            addCriterion("otherplace <", value, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceLessThanOrEqualTo(String value) {
            addCriterion("otherplace <=", value, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceLike(String value) {
            addCriterion("otherplace like", value, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceNotLike(String value) {
            addCriterion("otherplace not like", value, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceIn(List<String> values) {
            addCriterion("otherplace in", values, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceNotIn(List<String> values) {
            addCriterion("otherplace not in", values, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceBetween(String value1, String value2) {
            addCriterion("otherplace between", value1, value2, "otherplace");
            return (Criteria) this;
        }

        public Criteria andOtherplaceNotBetween(String value1, String value2) {
            addCriterion("otherplace not between", value1, value2, "otherplace");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneIsNull() {
            addCriterion("specialzone is null");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneIsNotNull() {
            addCriterion("specialzone is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneEqualTo(String value) {
            addCriterion("specialzone =", value, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneNotEqualTo(String value) {
            addCriterion("specialzone <>", value, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneGreaterThan(String value) {
            addCriterion("specialzone >", value, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneGreaterThanOrEqualTo(String value) {
            addCriterion("specialzone >=", value, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneLessThan(String value) {
            addCriterion("specialzone <", value, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneLessThanOrEqualTo(String value) {
            addCriterion("specialzone <=", value, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneLike(String value) {
            addCriterion("specialzone like", value, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneNotLike(String value) {
            addCriterion("specialzone not like", value, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneIn(List<String> values) {
            addCriterion("specialzone in", values, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneNotIn(List<String> values) {
            addCriterion("specialzone not in", values, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneBetween(String value1, String value2) {
            addCriterion("specialzone between", value1, value2, "specialzone");
            return (Criteria) this;
        }

        public Criteria andSpecialzoneNotBetween(String value1, String value2) {
            addCriterion("specialzone not between", value1, value2, "specialzone");
            return (Criteria) this;
        }

        public Criteria andResignintypeIsNull() {
            addCriterion("resignintype is null");
            return (Criteria) this;
        }

        public Criteria andResignintypeIsNotNull() {
            addCriterion("resignintype is not null");
            return (Criteria) this;
        }

        public Criteria andResignintypeEqualTo(String value) {
            addCriterion("resignintype =", value, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeNotEqualTo(String value) {
            addCriterion("resignintype <>", value, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeGreaterThan(String value) {
            addCriterion("resignintype >", value, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeGreaterThanOrEqualTo(String value) {
            addCriterion("resignintype >=", value, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeLessThan(String value) {
            addCriterion("resignintype <", value, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeLessThanOrEqualTo(String value) {
            addCriterion("resignintype <=", value, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeLike(String value) {
            addCriterion("resignintype like", value, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeNotLike(String value) {
            addCriterion("resignintype not like", value, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeIn(List<String> values) {
            addCriterion("resignintype in", values, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeNotIn(List<String> values) {
            addCriterion("resignintype not in", values, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeBetween(String value1, String value2) {
            addCriterion("resignintype between", value1, value2, "resignintype");
            return (Criteria) this;
        }

        public Criteria andResignintypeNotBetween(String value1, String value2) {
            addCriterion("resignintype not between", value1, value2, "resignintype");
            return (Criteria) this;
        }

        public Criteria andSigninmonthIsNull() {
            addCriterion("signinmonth is null");
            return (Criteria) this;
        }

        public Criteria andSigninmonthIsNotNull() {
            addCriterion("signinmonth is not null");
            return (Criteria) this;
        }

        public Criteria andSigninmonthEqualTo(String value) {
            addCriterion("signinmonth =", value, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthNotEqualTo(String value) {
            addCriterion("signinmonth <>", value, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthGreaterThan(String value) {
            addCriterion("signinmonth >", value, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthGreaterThanOrEqualTo(String value) {
            addCriterion("signinmonth >=", value, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthLessThan(String value) {
            addCriterion("signinmonth <", value, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthLessThanOrEqualTo(String value) {
            addCriterion("signinmonth <=", value, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthLike(String value) {
            addCriterion("signinmonth like", value, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthNotLike(String value) {
            addCriterion("signinmonth not like", value, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthIn(List<String> values) {
            addCriterion("signinmonth in", values, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthNotIn(List<String> values) {
            addCriterion("signinmonth not in", values, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthBetween(String value1, String value2) {
            addCriterion("signinmonth between", value1, value2, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSigninmonthNotBetween(String value1, String value2) {
            addCriterion("signinmonth not between", value1, value2, "signinmonth");
            return (Criteria) this;
        }

        public Criteria andSignindateIsNull() {
            addCriterion("signindate is null");
            return (Criteria) this;
        }

        public Criteria andSignindateIsNotNull() {
            addCriterion("signindate is not null");
            return (Criteria) this;
        }

        public Criteria andSignindateEqualTo(String value) {
            addCriterion("signindate =", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateNotEqualTo(String value) {
            addCriterion("signindate <>", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateGreaterThan(String value) {
            addCriterion("signindate >", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateGreaterThanOrEqualTo(String value) {
            addCriterion("signindate >=", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateLessThan(String value) {
            addCriterion("signindate <", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateLessThanOrEqualTo(String value) {
            addCriterion("signindate <=", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateLike(String value) {
            addCriterion("signindate like", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateNotLike(String value) {
            addCriterion("signindate not like", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateIn(List<String> values) {
            addCriterion("signindate in", values, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateNotIn(List<String> values) {
            addCriterion("signindate not in", values, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateBetween(String value1, String value2) {
            addCriterion("signindate between", value1, value2, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateNotBetween(String value1, String value2) {
            addCriterion("signindate not between", value1, value2, "signindate");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("applytime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("applytime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Date value) {
            addCriterion("applytime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Date value) {
            addCriterion("applytime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Date value) {
            addCriterion("applytime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applytime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Date value) {
            addCriterion("applytime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
            addCriterion("applytime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Date> values) {
            addCriterion("applytime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Date> values) {
            addCriterion("applytime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Date value1, Date value2) {
            addCriterion("applytime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
            addCriterion("applytime not between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeIsNull() {
            addCriterion("resigninorgcode is null");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeIsNotNull() {
            addCriterion("resigninorgcode is not null");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeEqualTo(String value) {
            addCriterion("resigninorgcode =", value, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeNotEqualTo(String value) {
            addCriterion("resigninorgcode <>", value, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeGreaterThan(String value) {
            addCriterion("resigninorgcode >", value, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("resigninorgcode >=", value, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeLessThan(String value) {
            addCriterion("resigninorgcode <", value, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeLessThanOrEqualTo(String value) {
            addCriterion("resigninorgcode <=", value, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeLike(String value) {
            addCriterion("resigninorgcode like", value, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeNotLike(String value) {
            addCriterion("resigninorgcode not like", value, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeIn(List<String> values) {
            addCriterion("resigninorgcode in", values, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeNotIn(List<String> values) {
            addCriterion("resigninorgcode not in", values, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeBetween(String value1, String value2) {
            addCriterion("resigninorgcode between", value1, value2, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgcodeNotBetween(String value1, String value2) {
            addCriterion("resigninorgcode not between", value1, value2, "resigninorgcode");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameIsNull() {
            addCriterion("resigninorgname is null");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameIsNotNull() {
            addCriterion("resigninorgname is not null");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameEqualTo(String value) {
            addCriterion("resigninorgname =", value, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameNotEqualTo(String value) {
            addCriterion("resigninorgname <>", value, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameGreaterThan(String value) {
            addCriterion("resigninorgname >", value, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameGreaterThanOrEqualTo(String value) {
            addCriterion("resigninorgname >=", value, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameLessThan(String value) {
            addCriterion("resigninorgname <", value, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameLessThanOrEqualTo(String value) {
            addCriterion("resigninorgname <=", value, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameLike(String value) {
            addCriterion("resigninorgname like", value, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameNotLike(String value) {
            addCriterion("resigninorgname not like", value, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameIn(List<String> values) {
            addCriterion("resigninorgname in", values, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameNotIn(List<String> values) {
            addCriterion("resigninorgname not in", values, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameBetween(String value1, String value2) {
            addCriterion("resigninorgname between", value1, value2, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninorgnameNotBetween(String value1, String value2) {
            addCriterion("resigninorgname not between", value1, value2, "resigninorgname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeIsNull() {
            addCriterion("resigninresidentcode is null");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeIsNotNull() {
            addCriterion("resigninresidentcode is not null");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeEqualTo(String value) {
            addCriterion("resigninresidentcode =", value, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeNotEqualTo(String value) {
            addCriterion("resigninresidentcode <>", value, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeGreaterThan(String value) {
            addCriterion("resigninresidentcode >", value, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("resigninresidentcode >=", value, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeLessThan(String value) {
            addCriterion("resigninresidentcode <", value, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeLessThanOrEqualTo(String value) {
            addCriterion("resigninresidentcode <=", value, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeLike(String value) {
            addCriterion("resigninresidentcode like", value, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeNotLike(String value) {
            addCriterion("resigninresidentcode not like", value, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeIn(List<String> values) {
            addCriterion("resigninresidentcode in", values, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeNotIn(List<String> values) {
            addCriterion("resigninresidentcode not in", values, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeBetween(String value1, String value2) {
            addCriterion("resigninresidentcode between", value1, value2, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentcodeNotBetween(String value1, String value2) {
            addCriterion("resigninresidentcode not between", value1, value2, "resigninresidentcode");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameIsNull() {
            addCriterion("resigninresidentname is null");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameIsNotNull() {
            addCriterion("resigninresidentname is not null");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameEqualTo(String value) {
            addCriterion("resigninresidentname =", value, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameNotEqualTo(String value) {
            addCriterion("resigninresidentname <>", value, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameGreaterThan(String value) {
            addCriterion("resigninresidentname >", value, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameGreaterThanOrEqualTo(String value) {
            addCriterion("resigninresidentname >=", value, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameLessThan(String value) {
            addCriterion("resigninresidentname <", value, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameLessThanOrEqualTo(String value) {
            addCriterion("resigninresidentname <=", value, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameLike(String value) {
            addCriterion("resigninresidentname like", value, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameNotLike(String value) {
            addCriterion("resigninresidentname not like", value, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameIn(List<String> values) {
            addCriterion("resigninresidentname in", values, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameNotIn(List<String> values) {
            addCriterion("resigninresidentname not in", values, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameBetween(String value1, String value2) {
            addCriterion("resigninresidentname between", value1, value2, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninresidentnameNotBetween(String value1, String value2) {
            addCriterion("resigninresidentname not between", value1, value2, "resigninresidentname");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceIsNull() {
            addCriterion("resigninotherplace is null");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceIsNotNull() {
            addCriterion("resigninotherplace is not null");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceEqualTo(String value) {
            addCriterion("resigninotherplace =", value, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceNotEqualTo(String value) {
            addCriterion("resigninotherplace <>", value, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceGreaterThan(String value) {
            addCriterion("resigninotherplace >", value, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceGreaterThanOrEqualTo(String value) {
            addCriterion("resigninotherplace >=", value, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceLessThan(String value) {
            addCriterion("resigninotherplace <", value, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceLessThanOrEqualTo(String value) {
            addCriterion("resigninotherplace <=", value, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceLike(String value) {
            addCriterion("resigninotherplace like", value, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceNotLike(String value) {
            addCriterion("resigninotherplace not like", value, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceIn(List<String> values) {
            addCriterion("resigninotherplace in", values, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceNotIn(List<String> values) {
            addCriterion("resigninotherplace not in", values, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceBetween(String value1, String value2) {
            addCriterion("resigninotherplace between", value1, value2, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andResigninotherplaceNotBetween(String value1, String value2) {
            addCriterion("resigninotherplace not between", value1, value2, "resigninotherplace");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNull() {
            addCriterion("auditstatus is null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNotNull() {
            addCriterion("auditstatus is not null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusEqualTo(String value) {
            addCriterion("auditstatus =", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotEqualTo(String value) {
            addCriterion("auditstatus <>", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThan(String value) {
            addCriterion("auditstatus >", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThanOrEqualTo(String value) {
            addCriterion("auditstatus >=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThan(String value) {
            addCriterion("auditstatus <", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThanOrEqualTo(String value) {
            addCriterion("auditstatus <=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLike(String value) {
            addCriterion("auditstatus like", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotLike(String value) {
            addCriterion("auditstatus not like", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIn(List<String> values) {
            addCriterion("auditstatus in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotIn(List<String> values) {
            addCriterion("auditstatus not in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusBetween(String value1, String value2) {
            addCriterion("auditstatus between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotBetween(String value1, String value2) {
            addCriterion("auditstatus not between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNull() {
            addCriterion("opinion is null");
            return (Criteria) this;
        }

        public Criteria andOpinionIsNotNull() {
            addCriterion("opinion is not null");
            return (Criteria) this;
        }

        public Criteria andOpinionEqualTo(String value) {
            addCriterion("opinion =", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotEqualTo(String value) {
            addCriterion("opinion <>", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThan(String value) {
            addCriterion("opinion >", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("opinion >=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThan(String value) {
            addCriterion("opinion <", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLessThanOrEqualTo(String value) {
            addCriterion("opinion <=", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionLike(String value) {
            addCriterion("opinion like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotLike(String value) {
            addCriterion("opinion not like", value, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionIn(List<String> values) {
            addCriterion("opinion in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotIn(List<String> values) {
            addCriterion("opinion not in", values, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionBetween(String value1, String value2) {
            addCriterion("opinion between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andOpinionNotBetween(String value1, String value2) {
            addCriterion("opinion not between", value1, value2, "opinion");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeIsNull() {
            addCriterion("auditusercode is null");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeIsNotNull() {
            addCriterion("auditusercode is not null");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeEqualTo(String value) {
            addCriterion("auditusercode =", value, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeNotEqualTo(String value) {
            addCriterion("auditusercode <>", value, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeGreaterThan(String value) {
            addCriterion("auditusercode >", value, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeGreaterThanOrEqualTo(String value) {
            addCriterion("auditusercode >=", value, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeLessThan(String value) {
            addCriterion("auditusercode <", value, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeLessThanOrEqualTo(String value) {
            addCriterion("auditusercode <=", value, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeLike(String value) {
            addCriterion("auditusercode like", value, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeNotLike(String value) {
            addCriterion("auditusercode not like", value, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeIn(List<String> values) {
            addCriterion("auditusercode in", values, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeNotIn(List<String> values) {
            addCriterion("auditusercode not in", values, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeBetween(String value1, String value2) {
            addCriterion("auditusercode between", value1, value2, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAuditusercodeNotBetween(String value1, String value2) {
            addCriterion("auditusercode not between", value1, value2, "auditusercode");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNull() {
            addCriterion("audittime is null");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNotNull() {
            addCriterion("audittime is not null");
            return (Criteria) this;
        }

        public Criteria andAudittimeEqualTo(Date value) {
            addCriterion("audittime =", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotEqualTo(Date value) {
            addCriterion("audittime <>", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThan(Date value) {
            addCriterion("audittime >", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("audittime >=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThan(Date value) {
            addCriterion("audittime <", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThanOrEqualTo(Date value) {
            addCriterion("audittime <=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeIn(List<Date> values) {
            addCriterion("audittime in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotIn(List<Date> values) {
            addCriterion("audittime not in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeBetween(Date value1, Date value2) {
            addCriterion("audittime between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotBetween(Date value1, Date value2) {
            addCriterion("audittime not between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andIsgzIsNull() {
            addCriterion("isgz is null");
            return (Criteria) this;
        }

        public Criteria andIsgzIsNotNull() {
            addCriterion("isgz is not null");
            return (Criteria) this;
        }

        public Criteria andIsgzEqualTo(String value) {
            addCriterion("isgz =", value, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzNotEqualTo(String value) {
            addCriterion("isgz <>", value, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzGreaterThan(String value) {
            addCriterion("isgz >", value, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzGreaterThanOrEqualTo(String value) {
            addCriterion("isgz >=", value, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzLessThan(String value) {
            addCriterion("isgz <", value, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzLessThanOrEqualTo(String value) {
            addCriterion("isgz <=", value, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzLike(String value) {
            addCriterion("isgz like", value, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzNotLike(String value) {
            addCriterion("isgz not like", value, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzIn(List<String> values) {
            addCriterion("isgz in", values, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzNotIn(List<String> values) {
            addCriterion("isgz not in", values, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzBetween(String value1, String value2) {
            addCriterion("isgz between", value1, value2, "isgz");
            return (Criteria) this;
        }

        public Criteria andIsgzNotBetween(String value1, String value2) {
            addCriterion("isgz not between", value1, value2, "isgz");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameIsNull() {
            addCriterion("belongtoorgname is null");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameIsNotNull() {
            addCriterion("belongtoorgname is not null");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameEqualTo(String value) {
            addCriterion("belongtoorgname =", value, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameNotEqualTo(String value) {
            addCriterion("belongtoorgname <>", value, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameGreaterThan(String value) {
            addCriterion("belongtoorgname >", value, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameGreaterThanOrEqualTo(String value) {
            addCriterion("belongtoorgname >=", value, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameLessThan(String value) {
            addCriterion("belongtoorgname <", value, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameLessThanOrEqualTo(String value) {
            addCriterion("belongtoorgname <=", value, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameLike(String value) {
            addCriterion("belongtoorgname like", value, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameNotLike(String value) {
            addCriterion("belongtoorgname not like", value, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameIn(List<String> values) {
            addCriterion("belongtoorgname in", values, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameNotIn(List<String> values) {
            addCriterion("belongtoorgname not in", values, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameBetween(String value1, String value2) {
            addCriterion("belongtoorgname between", value1, value2, "belongtoorgname");
            return (Criteria) this;
        }

        public Criteria andBelongtoorgnameNotBetween(String value1, String value2) {
            addCriterion("belongtoorgname not between", value1, value2, "belongtoorgname");
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
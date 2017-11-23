package com.sunrise.hr.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AttendanceMonthsignincountVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendanceMonthsignincountVOExample() {
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

        public Criteria andPositionlevelnameIsNull() {
            addCriterion("positionlevelname is null");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameIsNotNull() {
            addCriterion("positionlevelname is not null");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameEqualTo(String value) {
            addCriterion("positionlevelname =", value, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameNotEqualTo(String value) {
            addCriterion("positionlevelname <>", value, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameGreaterThan(String value) {
            addCriterion("positionlevelname >", value, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameGreaterThanOrEqualTo(String value) {
            addCriterion("positionlevelname >=", value, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameLessThan(String value) {
            addCriterion("positionlevelname <", value, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameLessThanOrEqualTo(String value) {
            addCriterion("positionlevelname <=", value, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameLike(String value) {
            addCriterion("positionlevelname like", value, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameNotLike(String value) {
            addCriterion("positionlevelname not like", value, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameIn(List<String> values) {
            addCriterion("positionlevelname in", values, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameNotIn(List<String> values) {
            addCriterion("positionlevelname not in", values, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameBetween(String value1, String value2) {
            addCriterion("positionlevelname between", value1, value2, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andPositionlevelnameNotBetween(String value1, String value2) {
            addCriterion("positionlevelname not between", value1, value2, "positionlevelname");
            return (Criteria) this;
        }

        public Criteria andSigninnumIsNull() {
            addCriterion("signinnum is null");
            return (Criteria) this;
        }

        public Criteria andSigninnumIsNotNull() {
            addCriterion("signinnum is not null");
            return (Criteria) this;
        }

        public Criteria andSigninnumEqualTo(Integer value) {
            addCriterion("signinnum =", value, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumNotEqualTo(Integer value) {
            addCriterion("signinnum <>", value, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumGreaterThan(Integer value) {
            addCriterion("signinnum >", value, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("signinnum >=", value, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumLessThan(Integer value) {
            addCriterion("signinnum <", value, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumLessThanOrEqualTo(Integer value) {
            addCriterion("signinnum <=", value, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumIn(List<Integer> values) {
            addCriterion("signinnum in", values, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumNotIn(List<Integer> values) {
            addCriterion("signinnum not in", values, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumBetween(Integer value1, Integer value2) {
            addCriterion("signinnum between", value1, value2, "signinnum");
            return (Criteria) this;
        }

        public Criteria andSigninnumNotBetween(Integer value1, Integer value2) {
            addCriterion("signinnum not between", value1, value2, "signinnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumIsNull() {
            addCriterion("notsigninnum is null");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumIsNotNull() {
            addCriterion("notsigninnum is not null");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumEqualTo(Integer value) {
            addCriterion("notsigninnum =", value, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumNotEqualTo(Integer value) {
            addCriterion("notsigninnum <>", value, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumGreaterThan(Integer value) {
            addCriterion("notsigninnum >", value, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("notsigninnum >=", value, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumLessThan(Integer value) {
            addCriterion("notsigninnum <", value, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumLessThanOrEqualTo(Integer value) {
            addCriterion("notsigninnum <=", value, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumIn(List<Integer> values) {
            addCriterion("notsigninnum in", values, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumNotIn(List<Integer> values) {
            addCriterion("notsigninnum not in", values, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumBetween(Integer value1, Integer value2) {
            addCriterion("notsigninnum between", value1, value2, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andNotsigninnumNotBetween(Integer value1, Integer value2) {
            addCriterion("notsigninnum not between", value1, value2, "notsigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumIsNull() {
            addCriterion("resigninnum is null");
            return (Criteria) this;
        }

        public Criteria andResigninnumIsNotNull() {
            addCriterion("resigninnum is not null");
            return (Criteria) this;
        }

        public Criteria andResigninnumEqualTo(Integer value) {
            addCriterion("resigninnum =", value, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumNotEqualTo(Integer value) {
            addCriterion("resigninnum <>", value, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumGreaterThan(Integer value) {
            addCriterion("resigninnum >", value, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("resigninnum >=", value, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumLessThan(Integer value) {
            addCriterion("resigninnum <", value, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumLessThanOrEqualTo(Integer value) {
            addCriterion("resigninnum <=", value, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumIn(List<Integer> values) {
            addCriterion("resigninnum in", values, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumNotIn(List<Integer> values) {
            addCriterion("resigninnum not in", values, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumBetween(Integer value1, Integer value2) {
            addCriterion("resigninnum between", value1, value2, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andResigninnumNotBetween(Integer value1, Integer value2) {
            addCriterion("resigninnum not between", value1, value2, "resigninnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumIsNull() {
            addCriterion("travelnum is null");
            return (Criteria) this;
        }

        public Criteria andTravelnumIsNotNull() {
            addCriterion("travelnum is not null");
            return (Criteria) this;
        }

        public Criteria andTravelnumEqualTo(Integer value) {
            addCriterion("travelnum =", value, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumNotEqualTo(Integer value) {
            addCriterion("travelnum <>", value, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumGreaterThan(Integer value) {
            addCriterion("travelnum >", value, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("travelnum >=", value, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumLessThan(Integer value) {
            addCriterion("travelnum <", value, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumLessThanOrEqualTo(Integer value) {
            addCriterion("travelnum <=", value, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumIn(List<Integer> values) {
            addCriterion("travelnum in", values, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumNotIn(List<Integer> values) {
            addCriterion("travelnum not in", values, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumBetween(Integer value1, Integer value2) {
            addCriterion("travelnum between", value1, value2, "travelnum");
            return (Criteria) this;
        }

        public Criteria andTravelnumNotBetween(Integer value1, Integer value2) {
            addCriterion("travelnum not between", value1, value2, "travelnum");
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
            return  (Criteria) this;
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
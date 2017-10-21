package com.dtsjy.mdboss.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserVOExample() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andUserrankIsNull() {
            addCriterion("userrank is null");
            return (Criteria) this;
        }

        public Criteria andUserrankIsNotNull() {
            addCriterion("userrank is not null");
            return (Criteria) this;
        }

        public Criteria andUserrankEqualTo(String value) {
            addCriterion("userrank =", value, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankNotEqualTo(String value) {
            addCriterion("userrank <>", value, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankGreaterThan(String value) {
            addCriterion("userrank >", value, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankGreaterThanOrEqualTo(String value) {
            addCriterion("userrank >=", value, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankLessThan(String value) {
            addCriterion("userrank <", value, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankLessThanOrEqualTo(String value) {
            addCriterion("userrank <=", value, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankLike(String value) {
            addCriterion("userrank like", value, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankNotLike(String value) {
            addCriterion("userrank not like", value, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankIn(List<String> values) {
            addCriterion("userrank in", values, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankNotIn(List<String> values) {
            addCriterion("userrank not in", values, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankBetween(String value1, String value2) {
            addCriterion("userrank between", value1, value2, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserrankNotBetween(String value1, String value2) {
            addCriterion("userrank not between", value1, value2, "userrank");
            return (Criteria) this;
        }

        public Criteria andUserlevelIsNull() {
            addCriterion("userlevel is null");
            return (Criteria) this;
        }

        public Criteria andUserlevelIsNotNull() {
            addCriterion("userlevel is not null");
            return (Criteria) this;
        }

        public Criteria andUserlevelEqualTo(String value) {
            addCriterion("userlevel =", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelNotEqualTo(String value) {
            addCriterion("userlevel <>", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelGreaterThan(String value) {
            addCriterion("userlevel >", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelGreaterThanOrEqualTo(String value) {
            addCriterion("userlevel >=", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelLessThan(String value) {
            addCriterion("userlevel <", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelLessThanOrEqualTo(String value) {
            addCriterion("userlevel <=", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelLike(String value) {
            addCriterion("userlevel like", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelNotLike(String value) {
            addCriterion("userlevel not like", value, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelIn(List<String> values) {
            addCriterion("userlevel in", values, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelNotIn(List<String> values) {
            addCriterion("userlevel not in", values, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelBetween(String value1, String value2) {
            addCriterion("userlevel between", value1, value2, "userlevel");
            return (Criteria) this;
        }

        public Criteria andUserlevelNotBetween(String value1, String value2) {
            addCriterion("userlevel not between", value1, value2, "userlevel");
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

        public Criteria andMobilenoIsNull() {
            addCriterion("mobileno is null");
            return (Criteria) this;
        }

        public Criteria andMobilenoIsNotNull() {
            addCriterion("mobileno is not null");
            return (Criteria) this;
        }

        public Criteria andMobilenoEqualTo(String value) {
            addCriterion("mobileno =", value, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoNotEqualTo(String value) {
            addCriterion("mobileno <>", value, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoGreaterThan(String value) {
            addCriterion("mobileno >", value, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoGreaterThanOrEqualTo(String value) {
            addCriterion("mobileno >=", value, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoLessThan(String value) {
            addCriterion("mobileno <", value, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoLessThanOrEqualTo(String value) {
            addCriterion("mobileno <=", value, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoLike(String value) {
            addCriterion("mobileno like", value, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoNotLike(String value) {
            addCriterion("mobileno not like", value, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoIn(List<String> values) {
            addCriterion("mobileno in", values, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoNotIn(List<String> values) {
            addCriterion("mobileno not in", values, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoBetween(String value1, String value2) {
            addCriterion("mobileno between", value1, value2, "mobileno");
            return (Criteria) this;
        }

        public Criteria andMobilenoNotBetween(String value1, String value2) {
            addCriterion("mobileno not between", value1, value2, "mobileno");
            return (Criteria) this;
        }

        public Criteria andOfficephoneIsNull() {
            addCriterion("officephone is null");
            return (Criteria) this;
        }

        public Criteria andOfficephoneIsNotNull() {
            addCriterion("officephone is not null");
            return (Criteria) this;
        }

        public Criteria andOfficephoneEqualTo(String value) {
            addCriterion("officephone =", value, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneNotEqualTo(String value) {
            addCriterion("officephone <>", value, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneGreaterThan(String value) {
            addCriterion("officephone >", value, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneGreaterThanOrEqualTo(String value) {
            addCriterion("officephone >=", value, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneLessThan(String value) {
            addCriterion("officephone <", value, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneLessThanOrEqualTo(String value) {
            addCriterion("officephone <=", value, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneLike(String value) {
            addCriterion("officephone like", value, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneNotLike(String value) {
            addCriterion("officephone not like", value, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneIn(List<String> values) {
            addCriterion("officephone in", values, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneNotIn(List<String> values) {
            addCriterion("officephone not in", values, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneBetween(String value1, String value2) {
            addCriterion("officephone between", value1, value2, "officephone");
            return (Criteria) this;
        }

        public Criteria andOfficephoneNotBetween(String value1, String value2) {
            addCriterion("officephone not between", value1, value2, "officephone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andImnumberIsNull() {
            addCriterion("imnumber is null");
            return (Criteria) this;
        }

        public Criteria andImnumberIsNotNull() {
            addCriterion("imnumber is not null");
            return (Criteria) this;
        }

        public Criteria andImnumberEqualTo(String value) {
            addCriterion("imnumber =", value, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberNotEqualTo(String value) {
            addCriterion("imnumber <>", value, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberGreaterThan(String value) {
            addCriterion("imnumber >", value, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberGreaterThanOrEqualTo(String value) {
            addCriterion("imnumber >=", value, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberLessThan(String value) {
            addCriterion("imnumber <", value, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberLessThanOrEqualTo(String value) {
            addCriterion("imnumber <=", value, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberLike(String value) {
            addCriterion("imnumber like", value, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberNotLike(String value) {
            addCriterion("imnumber not like", value, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberIn(List<String> values) {
            addCriterion("imnumber in", values, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberNotIn(List<String> values) {
            addCriterion("imnumber not in", values, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberBetween(String value1, String value2) {
            addCriterion("imnumber between", value1, value2, "imnumber");
            return (Criteria) this;
        }

        public Criteria andImnumberNotBetween(String value1, String value2) {
            addCriterion("imnumber not between", value1, value2, "imnumber");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeIsNull() {
            addCriterion("avatarcode is null");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeIsNotNull() {
            addCriterion("avatarcode is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeEqualTo(String value) {
            addCriterion("avatarcode =", value, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeNotEqualTo(String value) {
            addCriterion("avatarcode <>", value, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeGreaterThan(String value) {
            addCriterion("avatarcode >", value, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("avatarcode >=", value, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeLessThan(String value) {
            addCriterion("avatarcode <", value, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeLessThanOrEqualTo(String value) {
            addCriterion("avatarcode <=", value, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeLike(String value) {
            addCriterion("avatarcode like", value, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeNotLike(String value) {
            addCriterion("avatarcode not like", value, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeIn(List<String> values) {
            addCriterion("avatarcode in", values, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeNotIn(List<String> values) {
            addCriterion("avatarcode not in", values, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeBetween(String value1, String value2) {
            addCriterion("avatarcode between", value1, value2, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andAvatarcodeNotBetween(String value1, String value2) {
            addCriterion("avatarcode not between", value1, value2, "avatarcode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeIsNull() {
            addCriterion("validatecode is null");
            return (Criteria) this;
        }

        public Criteria andValidatecodeIsNotNull() {
            addCriterion("validatecode is not null");
            return (Criteria) this;
        }

        public Criteria andValidatecodeEqualTo(String value) {
            addCriterion("validatecode =", value, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeNotEqualTo(String value) {
            addCriterion("validatecode <>", value, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeGreaterThan(String value) {
            addCriterion("validatecode >", value, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeGreaterThanOrEqualTo(String value) {
            addCriterion("validatecode >=", value, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeLessThan(String value) {
            addCriterion("validatecode <", value, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeLessThanOrEqualTo(String value) {
            addCriterion("validatecode <=", value, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeLike(String value) {
            addCriterion("validatecode like", value, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeNotLike(String value) {
            addCriterion("validatecode not like", value, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeIn(List<String> values) {
            addCriterion("validatecode in", values, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeNotIn(List<String> values) {
            addCriterion("validatecode not in", values, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeBetween(String value1, String value2) {
            addCriterion("validatecode between", value1, value2, "validatecode");
            return (Criteria) this;
        }

        public Criteria andValidatecodeNotBetween(String value1, String value2) {
            addCriterion("validatecode not between", value1, value2, "validatecode");
            return (Criteria) this;
        }

        public Criteria andIkeynumberIsNull() {
            addCriterion("ikeynumber is null");
            return (Criteria) this;
        }

        public Criteria andIkeynumberIsNotNull() {
            addCriterion("ikeynumber is not null");
            return (Criteria) this;
        }

        public Criteria andIkeynumberEqualTo(String value) {
            addCriterion("ikeynumber =", value, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberNotEqualTo(String value) {
            addCriterion("ikeynumber <>", value, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberGreaterThan(String value) {
            addCriterion("ikeynumber >", value, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberGreaterThanOrEqualTo(String value) {
            addCriterion("ikeynumber >=", value, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberLessThan(String value) {
            addCriterion("ikeynumber <", value, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberLessThanOrEqualTo(String value) {
            addCriterion("ikeynumber <=", value, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberLike(String value) {
            addCriterion("ikeynumber like", value, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberNotLike(String value) {
            addCriterion("ikeynumber not like", value, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberIn(List<String> values) {
            addCriterion("ikeynumber in", values, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberNotIn(List<String> values) {
            addCriterion("ikeynumber not in", values, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberBetween(String value1, String value2) {
            addCriterion("ikeynumber between", value1, value2, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andIkeynumberNotBetween(String value1, String value2) {
            addCriterion("ikeynumber not between", value1, value2, "ikeynumber");
            return (Criteria) this;
        }

        public Criteria andUserdescIsNull() {
            addCriterion("userdesc is null");
            return (Criteria) this;
        }

        public Criteria andUserdescIsNotNull() {
            addCriterion("userdesc is not null");
            return (Criteria) this;
        }

        public Criteria andUserdescEqualTo(String value) {
            addCriterion("userdesc =", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescNotEqualTo(String value) {
            addCriterion("userdesc <>", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescGreaterThan(String value) {
            addCriterion("userdesc >", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescGreaterThanOrEqualTo(String value) {
            addCriterion("userdesc >=", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescLessThan(String value) {
            addCriterion("userdesc <", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescLessThanOrEqualTo(String value) {
            addCriterion("userdesc <=", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescLike(String value) {
            addCriterion("userdesc like", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescNotLike(String value) {
            addCriterion("userdesc not like", value, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescIn(List<String> values) {
            addCriterion("userdesc in", values, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescNotIn(List<String> values) {
            addCriterion("userdesc not in", values, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescBetween(String value1, String value2) {
            addCriterion("userdesc between", value1, value2, "userdesc");
            return (Criteria) this;
        }

        public Criteria andUserdescNotBetween(String value1, String value2) {
            addCriterion("userdesc not between", value1, value2, "userdesc");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
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

        public Criteria andPinyinIsNull() {
            addCriterion("pinyin is null");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("pinyin =", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("pinyin <>", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("pinyin >", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin >=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("pinyin <", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("pinyin <=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLike(String value) {
            addCriterion("pinyin like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("pinyin not like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinIn(List<String> values) {
            addCriterion("pinyin in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotIn(List<String> values) {
            addCriterion("pinyin not in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("pinyin between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("pinyin not between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andIsenabledIsNull() {
            addCriterion("isenabled is null");
            return (Criteria) this;
        }

        public Criteria andIsenabledIsNotNull() {
            addCriterion("isenabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsenabledEqualTo(String value) {
            addCriterion("isenabled =", value, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledNotEqualTo(String value) {
            addCriterion("isenabled <>", value, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledGreaterThan(String value) {
            addCriterion("isenabled >", value, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledGreaterThanOrEqualTo(String value) {
            addCriterion("isenabled >=", value, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledLessThan(String value) {
            addCriterion("isenabled <", value, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledLessThanOrEqualTo(String value) {
            addCriterion("isenabled <=", value, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledLike(String value) {
            addCriterion("isenabled like", value, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledNotLike(String value) {
            addCriterion("isenabled not like", value, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledIn(List<String> values) {
            addCriterion("isenabled in", values, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledNotIn(List<String> values) {
            addCriterion("isenabled not in", values, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledBetween(String value1, String value2) {
            addCriterion("isenabled between", value1, value2, "isenabled");
            return (Criteria) this;
        }

        public Criteria andIsenabledNotBetween(String value1, String value2) {
            addCriterion("isenabled not between", value1, value2, "isenabled");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeIsNull() {
            addCriterion("signfilecode is null");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeIsNotNull() {
            addCriterion("signfilecode is not null");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeEqualTo(String value) {
            addCriterion("signfilecode =", value, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeNotEqualTo(String value) {
            addCriterion("signfilecode <>", value, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeGreaterThan(String value) {
            addCriterion("signfilecode >", value, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeGreaterThanOrEqualTo(String value) {
            addCriterion("signfilecode >=", value, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeLessThan(String value) {
            addCriterion("signfilecode <", value, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeLessThanOrEqualTo(String value) {
            addCriterion("signfilecode <=", value, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeLike(String value) {
            addCriterion("signfilecode like", value, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeNotLike(String value) {
            addCriterion("signfilecode not like", value, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeIn(List<String> values) {
            addCriterion("signfilecode in", values, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeNotIn(List<String> values) {
            addCriterion("signfilecode not in", values, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeBetween(String value1, String value2) {
            addCriterion("signfilecode between", value1, value2, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andSignfilecodeNotBetween(String value1, String value2) {
            addCriterion("signfilecode not between", value1, value2, "signfilecode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeIsNull() {
            addCriterion("extorgcode is null");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeIsNotNull() {
            addCriterion("extorgcode is not null");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeEqualTo(String value) {
            addCriterion("extorgcode =", value, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeNotEqualTo(String value) {
            addCriterion("extorgcode <>", value, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeGreaterThan(String value) {
            addCriterion("extorgcode >", value, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("extorgcode >=", value, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeLessThan(String value) {
            addCriterion("extorgcode <", value, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeLessThanOrEqualTo(String value) {
            addCriterion("extorgcode <=", value, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeLike(String value) {
            addCriterion("extorgcode like", value, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeNotLike(String value) {
            addCriterion("extorgcode not like", value, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeIn(List<String> values) {
            addCriterion("extorgcode in", values, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeNotIn(List<String> values) {
            addCriterion("extorgcode not in", values, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeBetween(String value1, String value2) {
            addCriterion("extorgcode between", value1, value2, "extorgcode");
            return (Criteria) this;
        }

        public Criteria andExtorgcodeNotBetween(String value1, String value2) {
            addCriterion("extorgcode not between", value1, value2, "extorgcode");
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

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNull() {
            addCriterion("allowance is null");
            return (Criteria) this;
        }

        public Criteria andAllowanceIsNotNull() {
            addCriterion("allowance is not null");
            return (Criteria) this;
        }

        public Criteria andAllowanceEqualTo(String value) {
            addCriterion("allowance =", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotEqualTo(String value) {
            addCriterion("allowance <>", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThan(String value) {
            addCriterion("allowance >", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceGreaterThanOrEqualTo(String value) {
            addCriterion("allowance >=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThan(String value) {
            addCriterion("allowance <", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLessThanOrEqualTo(String value) {
            addCriterion("allowance <=", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceLike(String value) {
            addCriterion("allowance like", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotLike(String value) {
            addCriterion("allowance not like", value, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceIn(List<String> values) {
            addCriterion("allowance in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotIn(List<String> values) {
            addCriterion("allowance not in", values, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceBetween(String value1, String value2) {
            addCriterion("allowance between", value1, value2, "allowance");
            return (Criteria) this;
        }

        public Criteria andAllowanceNotBetween(String value1, String value2) {
            addCriterion("allowance not between", value1, value2, "allowance");
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
package com.dtsjy.mdboss.oa.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DriverVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DriverVOExample() {
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

        public Criteria andDrivercodeIsNull() {
            addCriterion("drivercode is null");
            return (Criteria) this;
        }

        public Criteria andDrivercodeIsNotNull() {
            addCriterion("drivercode is not null");
            return (Criteria) this;
        }

        public Criteria andDrivercodeEqualTo(String value) {
            addCriterion("drivercode =", value, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeNotEqualTo(String value) {
            addCriterion("drivercode <>", value, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeGreaterThan(String value) {
            addCriterion("drivercode >", value, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeGreaterThanOrEqualTo(String value) {
            addCriterion("drivercode >=", value, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeLessThan(String value) {
            addCriterion("drivercode <", value, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeLessThanOrEqualTo(String value) {
            addCriterion("drivercode <=", value, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeLike(String value) {
            addCriterion("drivercode like", value, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeNotLike(String value) {
            addCriterion("drivercode not like", value, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeIn(List<String> values) {
            addCriterion("drivercode in", values, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeNotIn(List<String> values) {
            addCriterion("drivercode not in", values, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeBetween(String value1, String value2) {
            addCriterion("drivercode between", value1, value2, "drivercode");
            return (Criteria) this;
        }

        public Criteria andDrivercodeNotBetween(String value1, String value2) {
            addCriterion("drivercode not between", value1, value2, "drivercode");
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

        public Criteria andDrivernoIsNull() {
            addCriterion("driverno is null");
            return (Criteria) this;
        }

        public Criteria andDrivernoIsNotNull() {
            addCriterion("driverno is not null");
            return (Criteria) this;
        }

        public Criteria andDrivernoEqualTo(String value) {
            addCriterion("driverno =", value, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoNotEqualTo(String value) {
            addCriterion("driverno <>", value, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoGreaterThan(String value) {
            addCriterion("driverno >", value, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoGreaterThanOrEqualTo(String value) {
            addCriterion("driverno >=", value, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoLessThan(String value) {
            addCriterion("driverno <", value, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoLessThanOrEqualTo(String value) {
            addCriterion("driverno <=", value, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoLike(String value) {
            addCriterion("driverno like", value, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoNotLike(String value) {
            addCriterion("driverno not like", value, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoIn(List<String> values) {
            addCriterion("driverno in", values, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoNotIn(List<String> values) {
            addCriterion("driverno not in", values, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoBetween(String value1, String value2) {
            addCriterion("driverno between", value1, value2, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernoNotBetween(String value1, String value2) {
            addCriterion("driverno not between", value1, value2, "driverno");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNull() {
            addCriterion("drivername is null");
            return (Criteria) this;
        }

        public Criteria andDrivernameIsNotNull() {
            addCriterion("drivername is not null");
            return (Criteria) this;
        }

        public Criteria andDrivernameEqualTo(String value) {
            addCriterion("drivername =", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotEqualTo(String value) {
            addCriterion("drivername <>", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThan(String value) {
            addCriterion("drivername >", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameGreaterThanOrEqualTo(String value) {
            addCriterion("drivername >=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThan(String value) {
            addCriterion("drivername <", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLessThanOrEqualTo(String value) {
            addCriterion("drivername <=", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameLike(String value) {
            addCriterion("drivername like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotLike(String value) {
            addCriterion("drivername not like", value, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameIn(List<String> values) {
            addCriterion("drivername in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotIn(List<String> values) {
            addCriterion("drivername not in", values, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameBetween(String value1, String value2) {
            addCriterion("drivername between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDrivernameNotBetween(String value1, String value2) {
            addCriterion("drivername not between", value1, value2, "drivername");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceIsNull() {
            addCriterion("driverlicence is null");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceIsNotNull() {
            addCriterion("driverlicence is not null");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceEqualTo(String value) {
            addCriterion("driverlicence =", value, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceNotEqualTo(String value) {
            addCriterion("driverlicence <>", value, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceGreaterThan(String value) {
            addCriterion("driverlicence >", value, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceGreaterThanOrEqualTo(String value) {
            addCriterion("driverlicence >=", value, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceLessThan(String value) {
            addCriterion("driverlicence <", value, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceLessThanOrEqualTo(String value) {
            addCriterion("driverlicence <=", value, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceLike(String value) {
            addCriterion("driverlicence like", value, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceNotLike(String value) {
            addCriterion("driverlicence not like", value, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceIn(List<String> values) {
            addCriterion("driverlicence in", values, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceNotIn(List<String> values) {
            addCriterion("driverlicence not in", values, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceBetween(String value1, String value2) {
            addCriterion("driverlicence between", value1, value2, "driverlicence");
            return (Criteria) this;
        }

        public Criteria andDriverlicenceNotBetween(String value1, String value2) {
            addCriterion("driverlicence not between", value1, value2, "driverlicence");
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
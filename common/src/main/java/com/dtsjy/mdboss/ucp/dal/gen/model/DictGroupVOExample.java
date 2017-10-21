package com.dtsjy.mdboss.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictGroupVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictGroupVOExample() {
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

        public Criteria andGroupcodeIsNull() {
            addCriterion("groupcode is null");
            return (Criteria) this;
        }

        public Criteria andGroupcodeIsNotNull() {
            addCriterion("groupcode is not null");
            return (Criteria) this;
        }

        public Criteria andGroupcodeEqualTo(String value) {
            addCriterion("groupcode =", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeNotEqualTo(String value) {
            addCriterion("groupcode <>", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeGreaterThan(String value) {
            addCriterion("groupcode >", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeGreaterThanOrEqualTo(String value) {
            addCriterion("groupcode >=", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeLessThan(String value) {
            addCriterion("groupcode <", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeLessThanOrEqualTo(String value) {
            addCriterion("groupcode <=", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeLike(String value) {
            addCriterion("groupcode like", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeNotLike(String value) {
            addCriterion("groupcode not like", value, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeIn(List<String> values) {
            addCriterion("groupcode in", values, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeNotIn(List<String> values) {
            addCriterion("groupcode not in", values, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeBetween(String value1, String value2) {
            addCriterion("groupcode between", value1, value2, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupcodeNotBetween(String value1, String value2) {
            addCriterion("groupcode not between", value1, value2, "groupcode");
            return (Criteria) this;
        }

        public Criteria andGroupnameIsNull() {
            addCriterion("groupname is null");
            return (Criteria) this;
        }

        public Criteria andGroupnameIsNotNull() {
            addCriterion("groupname is not null");
            return (Criteria) this;
        }

        public Criteria andGroupnameEqualTo(String value) {
            addCriterion("groupname =", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotEqualTo(String value) {
            addCriterion("groupname <>", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameGreaterThan(String value) {
            addCriterion("groupname >", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameGreaterThanOrEqualTo(String value) {
            addCriterion("groupname >=", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLessThan(String value) {
            addCriterion("groupname <", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLessThanOrEqualTo(String value) {
            addCriterion("groupname <=", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLike(String value) {
            addCriterion("groupname like", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotLike(String value) {
            addCriterion("groupname not like", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameIn(List<String> values) {
            addCriterion("groupname in", values, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotIn(List<String> values) {
            addCriterion("groupname not in", values, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameBetween(String value1, String value2) {
            addCriterion("groupname between", value1, value2, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotBetween(String value1, String value2) {
            addCriterion("groupname not between", value1, value2, "groupname");
            return (Criteria) this;
        }

        public Criteria andGrouptypeIsNull() {
            addCriterion("grouptype is null");
            return (Criteria) this;
        }

        public Criteria andGrouptypeIsNotNull() {
            addCriterion("grouptype is not null");
            return (Criteria) this;
        }

        public Criteria andGrouptypeEqualTo(String value) {
            addCriterion("grouptype =", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeNotEqualTo(String value) {
            addCriterion("grouptype <>", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeGreaterThan(String value) {
            addCriterion("grouptype >", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeGreaterThanOrEqualTo(String value) {
            addCriterion("grouptype >=", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeLessThan(String value) {
            addCriterion("grouptype <", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeLessThanOrEqualTo(String value) {
            addCriterion("grouptype <=", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeLike(String value) {
            addCriterion("grouptype like", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeNotLike(String value) {
            addCriterion("grouptype not like", value, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeIn(List<String> values) {
            addCriterion("grouptype in", values, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeNotIn(List<String> values) {
            addCriterion("grouptype not in", values, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeBetween(String value1, String value2) {
            addCriterion("grouptype between", value1, value2, "grouptype");
            return (Criteria) this;
        }

        public Criteria andGrouptypeNotBetween(String value1, String value2) {
            addCriterion("grouptype not between", value1, value2, "grouptype");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andEffectdateIsNull() {
            addCriterion("effectdate is null");
            return (Criteria) this;
        }

        public Criteria andEffectdateIsNotNull() {
            addCriterion("effectdate is not null");
            return (Criteria) this;
        }

        public Criteria andEffectdateEqualTo(Date value) {
            addCriterion("effectdate =", value, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateNotEqualTo(Date value) {
            addCriterion("effectdate <>", value, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateGreaterThan(Date value) {
            addCriterion("effectdate >", value, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateGreaterThanOrEqualTo(Date value) {
            addCriterion("effectdate >=", value, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateLessThan(Date value) {
            addCriterion("effectdate <", value, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateLessThanOrEqualTo(Date value) {
            addCriterion("effectdate <=", value, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateIn(List<Date> values) {
            addCriterion("effectdate in", values, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateNotIn(List<Date> values) {
            addCriterion("effectdate not in", values, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateBetween(Date value1, Date value2) {
            addCriterion("effectdate between", value1, value2, "effectdate");
            return (Criteria) this;
        }

        public Criteria andEffectdateNotBetween(Date value1, Date value2) {
            addCriterion("effectdate not between", value1, value2, "effectdate");
            return (Criteria) this;
        }

        public Criteria andGroupdescIsNull() {
            addCriterion("groupdesc is null");
            return (Criteria) this;
        }

        public Criteria andGroupdescIsNotNull() {
            addCriterion("groupdesc is not null");
            return (Criteria) this;
        }

        public Criteria andGroupdescEqualTo(String value) {
            addCriterion("groupdesc =", value, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescNotEqualTo(String value) {
            addCriterion("groupdesc <>", value, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescGreaterThan(String value) {
            addCriterion("groupdesc >", value, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescGreaterThanOrEqualTo(String value) {
            addCriterion("groupdesc >=", value, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescLessThan(String value) {
            addCriterion("groupdesc <", value, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescLessThanOrEqualTo(String value) {
            addCriterion("groupdesc <=", value, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescLike(String value) {
            addCriterion("groupdesc like", value, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescNotLike(String value) {
            addCriterion("groupdesc not like", value, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescIn(List<String> values) {
            addCriterion("groupdesc in", values, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescNotIn(List<String> values) {
            addCriterion("groupdesc not in", values, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescBetween(String value1, String value2) {
            addCriterion("groupdesc between", value1, value2, "groupdesc");
            return (Criteria) this;
        }

        public Criteria andGroupdescNotBetween(String value1, String value2) {
            addCriterion("groupdesc not between", value1, value2, "groupdesc");
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
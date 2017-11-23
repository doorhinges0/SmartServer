package com.sunrise.wfs.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ViewDelegationVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewDelegationVOExample() {
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

        public Criteria andDelegateIsNull() {
            addCriterion("delegate is null");
            return (Criteria) this;
        }

        public Criteria andDelegateIsNotNull() {
            addCriterion("delegate is not null");
            return (Criteria) this;
        }

        public Criteria andDelegateEqualTo(String value) {
            addCriterion("delegate =", value, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateNotEqualTo(String value) {
            addCriterion("delegate <>", value, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateGreaterThan(String value) {
            addCriterion("delegate >", value, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateGreaterThanOrEqualTo(String value) {
            addCriterion("delegate >=", value, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateLessThan(String value) {
            addCriterion("delegate <", value, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateLessThanOrEqualTo(String value) {
            addCriterion("delegate <=", value, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateLike(String value) {
            addCriterion("delegate like", value, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateNotLike(String value) {
            addCriterion("delegate not like", value, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateIn(List<String> values) {
            addCriterion("delegate in", values, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateNotIn(List<String> values) {
            addCriterion("delegate not in", values, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateBetween(String value1, String value2) {
            addCriterion("delegate between", value1, value2, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegateNotBetween(String value1, String value2) {
            addCriterion("delegate not between", value1, value2, "delegate");
            return (Criteria) this;
        }

        public Criteria andDelegatenameIsNull() {
            addCriterion("delegatename is null");
            return (Criteria) this;
        }

        public Criteria andDelegatenameIsNotNull() {
            addCriterion("delegatename is not null");
            return (Criteria) this;
        }

        public Criteria andDelegatenameEqualTo(String value) {
            addCriterion("delegatename =", value, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameNotEqualTo(String value) {
            addCriterion("delegatename <>", value, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameGreaterThan(String value) {
            addCriterion("delegatename >", value, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameGreaterThanOrEqualTo(String value) {
            addCriterion("delegatename >=", value, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameLessThan(String value) {
            addCriterion("delegatename <", value, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameLessThanOrEqualTo(String value) {
            addCriterion("delegatename <=", value, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameLike(String value) {
            addCriterion("delegatename like", value, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameNotLike(String value) {
            addCriterion("delegatename not like", value, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameIn(List<String> values) {
            addCriterion("delegatename in", values, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameNotIn(List<String> values) {
            addCriterion("delegatename not in", values, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameBetween(String value1, String value2) {
            addCriterion("delegatename between", value1, value2, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatenameNotBetween(String value1, String value2) {
            addCriterion("delegatename not between", value1, value2, "delegatename");
            return (Criteria) this;
        }

        public Criteria andDelegatedIsNull() {
            addCriterion("delegated is null");
            return (Criteria) this;
        }

        public Criteria andDelegatedIsNotNull() {
            addCriterion("delegated is not null");
            return (Criteria) this;
        }

        public Criteria andDelegatedEqualTo(String value) {
            addCriterion("delegated =", value, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedNotEqualTo(String value) {
            addCriterion("delegated <>", value, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedGreaterThan(String value) {
            addCriterion("delegated >", value, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedGreaterThanOrEqualTo(String value) {
            addCriterion("delegated >=", value, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedLessThan(String value) {
            addCriterion("delegated <", value, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedLessThanOrEqualTo(String value) {
            addCriterion("delegated <=", value, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedLike(String value) {
            addCriterion("delegated like", value, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedNotLike(String value) {
            addCriterion("delegated not like", value, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedIn(List<String> values) {
            addCriterion("delegated in", values, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedNotIn(List<String> values) {
            addCriterion("delegated not in", values, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedBetween(String value1, String value2) {
            addCriterion("delegated between", value1, value2, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatedNotBetween(String value1, String value2) {
            addCriterion("delegated not between", value1, value2, "delegated");
            return (Criteria) this;
        }

        public Criteria andDelegatednameIsNull() {
            addCriterion("delegatedname is null");
            return (Criteria) this;
        }

        public Criteria andDelegatednameIsNotNull() {
            addCriterion("delegatedname is not null");
            return (Criteria) this;
        }

        public Criteria andDelegatednameEqualTo(String value) {
            addCriterion("delegatedname =", value, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameNotEqualTo(String value) {
            addCriterion("delegatedname <>", value, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameGreaterThan(String value) {
            addCriterion("delegatedname >", value, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameGreaterThanOrEqualTo(String value) {
            addCriterion("delegatedname >=", value, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameLessThan(String value) {
            addCriterion("delegatedname <", value, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameLessThanOrEqualTo(String value) {
            addCriterion("delegatedname <=", value, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameLike(String value) {
            addCriterion("delegatedname like", value, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameNotLike(String value) {
            addCriterion("delegatedname not like", value, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameIn(List<String> values) {
            addCriterion("delegatedname in", values, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameNotIn(List<String> values) {
            addCriterion("delegatedname not in", values, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameBetween(String value1, String value2) {
            addCriterion("delegatedname between", value1, value2, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andDelegatednameNotBetween(String value1, String value2) {
            addCriterion("delegatedname not between", value1, value2, "delegatedname");
            return (Criteria) this;
        }

        public Criteria andBustypeIsNull() {
            addCriterion("bustype is null");
            return (Criteria) this;
        }

        public Criteria andBustypeIsNotNull() {
            addCriterion("bustype is not null");
            return (Criteria) this;
        }

        public Criteria andBustypeEqualTo(String value) {
            addCriterion("bustype =", value, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeNotEqualTo(String value) {
            addCriterion("bustype <>", value, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeGreaterThan(String value) {
            addCriterion("bustype >", value, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeGreaterThanOrEqualTo(String value) {
            addCriterion("bustype >=", value, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeLessThan(String value) {
            addCriterion("bustype <", value, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeLessThanOrEqualTo(String value) {
            addCriterion("bustype <=", value, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeLike(String value) {
            addCriterion("bustype like", value, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeNotLike(String value) {
            addCriterion("bustype not like", value, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeIn(List<String> values) {
            addCriterion("bustype in", values, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeNotIn(List<String> values) {
            addCriterion("bustype not in", values, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeBetween(String value1, String value2) {
            addCriterion("bustype between", value1, value2, "bustype");
            return (Criteria) this;
        }

        public Criteria andBustypeNotBetween(String value1, String value2) {
            addCriterion("bustype not between", value1, value2, "bustype");
            return (Criteria) this;
        }

        public Criteria andBuscodeIsNull() {
            addCriterion("buscode is null");
            return (Criteria) this;
        }

        public Criteria andBuscodeIsNotNull() {
            addCriterion("buscode is not null");
            return (Criteria) this;
        }

        public Criteria andBuscodeEqualTo(String value) {
            addCriterion("buscode =", value, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeNotEqualTo(String value) {
            addCriterion("buscode <>", value, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeGreaterThan(String value) {
            addCriterion("buscode >", value, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeGreaterThanOrEqualTo(String value) {
            addCriterion("buscode >=", value, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeLessThan(String value) {
            addCriterion("buscode <", value, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeLessThanOrEqualTo(String value) {
            addCriterion("buscode <=", value, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeLike(String value) {
            addCriterion("buscode like", value, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeNotLike(String value) {
            addCriterion("buscode not like", value, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeIn(List<String> values) {
            addCriterion("buscode in", values, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeNotIn(List<String> values) {
            addCriterion("buscode not in", values, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeBetween(String value1, String value2) {
            addCriterion("buscode between", value1, value2, "buscode");
            return (Criteria) this;
        }

        public Criteria andBuscodeNotBetween(String value1, String value2) {
            addCriterion("buscode not between", value1, value2, "buscode");
            return (Criteria) this;
        }

        public Criteria andBusitemIsNull() {
            addCriterion("busitem is null");
            return (Criteria) this;
        }

        public Criteria andBusitemIsNotNull() {
            addCriterion("busitem is not null");
            return (Criteria) this;
        }

        public Criteria andBusitemEqualTo(String value) {
            addCriterion("busitem =", value, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemNotEqualTo(String value) {
            addCriterion("busitem <>", value, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemGreaterThan(String value) {
            addCriterion("busitem >", value, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemGreaterThanOrEqualTo(String value) {
            addCriterion("busitem >=", value, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemLessThan(String value) {
            addCriterion("busitem <", value, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemLessThanOrEqualTo(String value) {
            addCriterion("busitem <=", value, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemLike(String value) {
            addCriterion("busitem like", value, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemNotLike(String value) {
            addCriterion("busitem not like", value, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemIn(List<String> values) {
            addCriterion("busitem in", values, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemNotIn(List<String> values) {
            addCriterion("busitem not in", values, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemBetween(String value1, String value2) {
            addCriterion("busitem between", value1, value2, "busitem");
            return (Criteria) this;
        }

        public Criteria andBusitemNotBetween(String value1, String value2) {
            addCriterion("busitem not between", value1, value2, "busitem");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("starttime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("starttime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("endtime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("endtime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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
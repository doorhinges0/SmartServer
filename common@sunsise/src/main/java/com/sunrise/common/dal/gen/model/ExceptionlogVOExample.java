package com.sunrise.common.dal.gen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExceptionlogVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExceptionlogVOExample() {
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

        public Criteria andHostidIsNull() {
            addCriterion("hostid is null");
            return (Criteria) this;
        }

        public Criteria andHostidIsNotNull() {
            addCriterion("hostid is not null");
            return (Criteria) this;
        }

        public Criteria andHostidEqualTo(String value) {
            addCriterion("hostid =", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotEqualTo(String value) {
            addCriterion("hostid <>", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidGreaterThan(String value) {
            addCriterion("hostid >", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidGreaterThanOrEqualTo(String value) {
            addCriterion("hostid >=", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidLessThan(String value) {
            addCriterion("hostid <", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidLessThanOrEqualTo(String value) {
            addCriterion("hostid <=", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidLike(String value) {
            addCriterion("hostid like", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotLike(String value) {
            addCriterion("hostid not like", value, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidIn(List<String> values) {
            addCriterion("hostid in", values, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotIn(List<String> values) {
            addCriterion("hostid not in", values, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidBetween(String value1, String value2) {
            addCriterion("hostid between", value1, value2, "hostid");
            return (Criteria) this;
        }

        public Criteria andHostidNotBetween(String value1, String value2) {
            addCriterion("hostid not between", value1, value2, "hostid");
            return (Criteria) this;
        }

        public Criteria andAppcodeIsNull() {
            addCriterion("appcode is null");
            return (Criteria) this;
        }

        public Criteria andAppcodeIsNotNull() {
            addCriterion("appcode is not null");
            return (Criteria) this;
        }

        public Criteria andAppcodeEqualTo(String value) {
            addCriterion("appcode =", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeNotEqualTo(String value) {
            addCriterion("appcode <>", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeGreaterThan(String value) {
            addCriterion("appcode >", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeGreaterThanOrEqualTo(String value) {
            addCriterion("appcode >=", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeLessThan(String value) {
            addCriterion("appcode <", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeLessThanOrEqualTo(String value) {
            addCriterion("appcode <=", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeLike(String value) {
            addCriterion("appcode like", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeNotLike(String value) {
            addCriterion("appcode not like", value, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeIn(List<String> values) {
            addCriterion("appcode in", values, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeNotIn(List<String> values) {
            addCriterion("appcode not in", values, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeBetween(String value1, String value2) {
            addCriterion("appcode between", value1, value2, "appcode");
            return (Criteria) this;
        }

        public Criteria andAppcodeNotBetween(String value1, String value2) {
            addCriterion("appcode not between", value1, value2, "appcode");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andServicemethodIsNull() {
            addCriterion("servicemethod is null");
            return (Criteria) this;
        }

        public Criteria andServicemethodIsNotNull() {
            addCriterion("servicemethod is not null");
            return (Criteria) this;
        }

        public Criteria andServicemethodEqualTo(String value) {
            addCriterion("servicemethod =", value, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodNotEqualTo(String value) {
            addCriterion("servicemethod <>", value, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodGreaterThan(String value) {
            addCriterion("servicemethod >", value, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodGreaterThanOrEqualTo(String value) {
            addCriterion("servicemethod >=", value, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodLessThan(String value) {
            addCriterion("servicemethod <", value, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodLessThanOrEqualTo(String value) {
            addCriterion("servicemethod <=", value, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodLike(String value) {
            addCriterion("servicemethod like", value, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodNotLike(String value) {
            addCriterion("servicemethod not like", value, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodIn(List<String> values) {
            addCriterion("servicemethod in", values, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodNotIn(List<String> values) {
            addCriterion("servicemethod not in", values, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodBetween(String value1, String value2) {
            addCriterion("servicemethod between", value1, value2, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andServicemethodNotBetween(String value1, String value2) {
            addCriterion("servicemethod not between", value1, value2, "servicemethod");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgIsNull() {
            addCriterion("exceptionmsg is null");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgIsNotNull() {
            addCriterion("exceptionmsg is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgEqualTo(String value) {
            addCriterion("exceptionmsg =", value, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgNotEqualTo(String value) {
            addCriterion("exceptionmsg <>", value, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgGreaterThan(String value) {
            addCriterion("exceptionmsg >", value, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgGreaterThanOrEqualTo(String value) {
            addCriterion("exceptionmsg >=", value, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgLessThan(String value) {
            addCriterion("exceptionmsg <", value, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgLessThanOrEqualTo(String value) {
            addCriterion("exceptionmsg <=", value, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgLike(String value) {
            addCriterion("exceptionmsg like", value, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgNotLike(String value) {
            addCriterion("exceptionmsg not like", value, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgIn(List<String> values) {
            addCriterion("exceptionmsg in", values, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgNotIn(List<String> values) {
            addCriterion("exceptionmsg not in", values, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgBetween(String value1, String value2) {
            addCriterion("exceptionmsg between", value1, value2, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andExceptionmsgNotBetween(String value1, String value2) {
            addCriterion("exceptionmsg not between", value1, value2, "exceptionmsg");
            return (Criteria) this;
        }

        public Criteria andSerialnoIsNull() {
            addCriterion("serialno is null");
            return (Criteria) this;
        }

        public Criteria andSerialnoIsNotNull() {
            addCriterion("serialno is not null");
            return (Criteria) this;
        }

        public Criteria andSerialnoEqualTo(String value) {
            addCriterion("serialno =", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoNotEqualTo(String value) {
            addCriterion("serialno <>", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoGreaterThan(String value) {
            addCriterion("serialno >", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoGreaterThanOrEqualTo(String value) {
            addCriterion("serialno >=", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoLessThan(String value) {
            addCriterion("serialno <", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoLessThanOrEqualTo(String value) {
            addCriterion("serialno <=", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoLike(String value) {
            addCriterion("serialno like", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoNotLike(String value) {
            addCriterion("serialno not like", value, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoIn(List<String> values) {
            addCriterion("serialno in", values, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoNotIn(List<String> values) {
            addCriterion("serialno not in", values, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoBetween(String value1, String value2) {
            addCriterion("serialno between", value1, value2, "serialno");
            return (Criteria) this;
        }

        public Criteria andSerialnoNotBetween(String value1, String value2) {
            addCriterion("serialno not between", value1, value2, "serialno");
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
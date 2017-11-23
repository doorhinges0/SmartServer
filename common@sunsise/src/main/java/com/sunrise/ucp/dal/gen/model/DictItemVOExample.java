package com.sunrise.ucp.dal.gen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictItemVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictItemVOExample() {
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

        public Criteria andDictcodeIsNull() {
            addCriterion("dictcode is null");
            return (Criteria) this;
        }

        public Criteria andDictcodeIsNotNull() {
            addCriterion("dictcode is not null");
            return (Criteria) this;
        }

        public Criteria andDictcodeEqualTo(String value) {
            addCriterion("dictcode =", value, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeNotEqualTo(String value) {
            addCriterion("dictcode <>", value, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeGreaterThan(String value) {
            addCriterion("dictcode >", value, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeGreaterThanOrEqualTo(String value) {
            addCriterion("dictcode >=", value, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeLessThan(String value) {
            addCriterion("dictcode <", value, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeLessThanOrEqualTo(String value) {
            addCriterion("dictcode <=", value, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeLike(String value) {
            addCriterion("dictcode like", value, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeNotLike(String value) {
            addCriterion("dictcode not like", value, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeIn(List<String> values) {
            addCriterion("dictcode in", values, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeNotIn(List<String> values) {
            addCriterion("dictcode not in", values, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeBetween(String value1, String value2) {
            addCriterion("dictcode between", value1, value2, "dictcode");
            return (Criteria) this;
        }

        public Criteria andDictcodeNotBetween(String value1, String value2) {
            addCriterion("dictcode not between", value1, value2, "dictcode");
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

        public Criteria andDictnameIsNull() {
            addCriterion("dictname is null");
            return (Criteria) this;
        }

        public Criteria andDictnameIsNotNull() {
            addCriterion("dictname is not null");
            return (Criteria) this;
        }

        public Criteria andDictnameEqualTo(String value) {
            addCriterion("dictname =", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotEqualTo(String value) {
            addCriterion("dictname <>", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameGreaterThan(String value) {
            addCriterion("dictname >", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameGreaterThanOrEqualTo(String value) {
            addCriterion("dictname >=", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLessThan(String value) {
            addCriterion("dictname <", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLessThanOrEqualTo(String value) {
            addCriterion("dictname <=", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameLike(String value) {
            addCriterion("dictname like", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotLike(String value) {
            addCriterion("dictname not like", value, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameIn(List<String> values) {
            addCriterion("dictname in", values, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotIn(List<String> values) {
            addCriterion("dictname not in", values, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameBetween(String value1, String value2) {
            addCriterion("dictname between", value1, value2, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictnameNotBetween(String value1, String value2) {
            addCriterion("dictname not between", value1, value2, "dictname");
            return (Criteria) this;
        }

        public Criteria andDictorderIsNull() {
            addCriterion("dictorder is null");
            return (Criteria) this;
        }

        public Criteria andDictorderIsNotNull() {
            addCriterion("dictorder is not null");
            return (Criteria) this;
        }

        public Criteria andDictorderEqualTo(Byte value) {
            addCriterion("dictorder =", value, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderNotEqualTo(Byte value) {
            addCriterion("dictorder <>", value, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderGreaterThan(Byte value) {
            addCriterion("dictorder >", value, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderGreaterThanOrEqualTo(Byte value) {
            addCriterion("dictorder >=", value, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderLessThan(Byte value) {
            addCriterion("dictorder <", value, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderLessThanOrEqualTo(Byte value) {
            addCriterion("dictorder <=", value, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderIn(List<Byte> values) {
            addCriterion("dictorder in", values, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderNotIn(List<Byte> values) {
            addCriterion("dictorder not in", values, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderBetween(Byte value1, Byte value2) {
            addCriterion("dictorder between", value1, value2, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictorderNotBetween(Byte value1, Byte value2) {
            addCriterion("dictorder not between", value1, value2, "dictorder");
            return (Criteria) this;
        }

        public Criteria andDictstateIsNull() {
            addCriterion("dictstate is null");
            return (Criteria) this;
        }

        public Criteria andDictstateIsNotNull() {
            addCriterion("dictstate is not null");
            return (Criteria) this;
        }

        public Criteria andDictstateEqualTo(String value) {
            addCriterion("dictstate =", value, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateNotEqualTo(String value) {
            addCriterion("dictstate <>", value, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateGreaterThan(String value) {
            addCriterion("dictstate >", value, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateGreaterThanOrEqualTo(String value) {
            addCriterion("dictstate >=", value, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateLessThan(String value) {
            addCriterion("dictstate <", value, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateLessThanOrEqualTo(String value) {
            addCriterion("dictstate <=", value, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateLike(String value) {
            addCriterion("dictstate like", value, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateNotLike(String value) {
            addCriterion("dictstate not like", value, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateIn(List<String> values) {
            addCriterion("dictstate in", values, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateNotIn(List<String> values) {
            addCriterion("dictstate not in", values, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateBetween(String value1, String value2) {
            addCriterion("dictstate between", value1, value2, "dictstate");
            return (Criteria) this;
        }

        public Criteria andDictstateNotBetween(String value1, String value2) {
            addCriterion("dictstate not between", value1, value2, "dictstate");
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

        public Criteria andDictdescIsNull() {
            addCriterion("dictdesc is null");
            return (Criteria) this;
        }

        public Criteria andDictdescIsNotNull() {
            addCriterion("dictdesc is not null");
            return (Criteria) this;
        }

        public Criteria andDictdescEqualTo(String value) {
            addCriterion("dictdesc =", value, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescNotEqualTo(String value) {
            addCriterion("dictdesc <>", value, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescGreaterThan(String value) {
            addCriterion("dictdesc >", value, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescGreaterThanOrEqualTo(String value) {
            addCriterion("dictdesc >=", value, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescLessThan(String value) {
            addCriterion("dictdesc <", value, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescLessThanOrEqualTo(String value) {
            addCriterion("dictdesc <=", value, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescLike(String value) {
            addCriterion("dictdesc like", value, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescNotLike(String value) {
            addCriterion("dictdesc not like", value, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescIn(List<String> values) {
            addCriterion("dictdesc in", values, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescNotIn(List<String> values) {
            addCriterion("dictdesc not in", values, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescBetween(String value1, String value2) {
            addCriterion("dictdesc between", value1, value2, "dictdesc");
            return (Criteria) this;
        }

        public Criteria andDictdescNotBetween(String value1, String value2) {
            addCriterion("dictdesc not between", value1, value2, "dictdesc");
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
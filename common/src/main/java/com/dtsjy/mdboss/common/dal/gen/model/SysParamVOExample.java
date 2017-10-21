package com.dtsjy.mdboss.common.dal.gen.model;

import java.util.ArrayList;
import java.util.List;

public class SysParamVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysParamVOExample() {
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

        public Criteria andParamcodeIsNull() {
            addCriterion("paramcode is null");
            return (Criteria) this;
        }

        public Criteria andParamcodeIsNotNull() {
            addCriterion("paramcode is not null");
            return (Criteria) this;
        }

        public Criteria andParamcodeEqualTo(String value) {
            addCriterion("paramcode =", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeNotEqualTo(String value) {
            addCriterion("paramcode <>", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeGreaterThan(String value) {
            addCriterion("paramcode >", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeGreaterThanOrEqualTo(String value) {
            addCriterion("paramcode >=", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeLessThan(String value) {
            addCriterion("paramcode <", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeLessThanOrEqualTo(String value) {
            addCriterion("paramcode <=", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeLike(String value) {
            addCriterion("paramcode like", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeNotLike(String value) {
            addCriterion("paramcode not like", value, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeIn(List<String> values) {
            addCriterion("paramcode in", values, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeNotIn(List<String> values) {
            addCriterion("paramcode not in", values, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeBetween(String value1, String value2) {
            addCriterion("paramcode between", value1, value2, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamcodeNotBetween(String value1, String value2) {
            addCriterion("paramcode not between", value1, value2, "paramcode");
            return (Criteria) this;
        }

        public Criteria andParamtypeIsNull() {
            addCriterion("paramtype is null");
            return (Criteria) this;
        }

        public Criteria andParamtypeIsNotNull() {
            addCriterion("paramtype is not null");
            return (Criteria) this;
        }

        public Criteria andParamtypeEqualTo(String value) {
            addCriterion("paramtype =", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotEqualTo(String value) {
            addCriterion("paramtype <>", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeGreaterThan(String value) {
            addCriterion("paramtype >", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeGreaterThanOrEqualTo(String value) {
            addCriterion("paramtype >=", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLessThan(String value) {
            addCriterion("paramtype <", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLessThanOrEqualTo(String value) {
            addCriterion("paramtype <=", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeLike(String value) {
            addCriterion("paramtype like", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotLike(String value) {
            addCriterion("paramtype not like", value, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeIn(List<String> values) {
            addCriterion("paramtype in", values, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotIn(List<String> values) {
            addCriterion("paramtype not in", values, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeBetween(String value1, String value2) {
            addCriterion("paramtype between", value1, value2, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamtypeNotBetween(String value1, String value2) {
            addCriterion("paramtype not between", value1, value2, "paramtype");
            return (Criteria) this;
        }

        public Criteria andParamnameIsNull() {
            addCriterion("paramname is null");
            return (Criteria) this;
        }

        public Criteria andParamnameIsNotNull() {
            addCriterion("paramname is not null");
            return (Criteria) this;
        }

        public Criteria andParamnameEqualTo(String value) {
            addCriterion("paramname =", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotEqualTo(String value) {
            addCriterion("paramname <>", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThan(String value) {
            addCriterion("paramname >", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameGreaterThanOrEqualTo(String value) {
            addCriterion("paramname >=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThan(String value) {
            addCriterion("paramname <", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLessThanOrEqualTo(String value) {
            addCriterion("paramname <=", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameLike(String value) {
            addCriterion("paramname like", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotLike(String value) {
            addCriterion("paramname not like", value, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameIn(List<String> values) {
            addCriterion("paramname in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotIn(List<String> values) {
            addCriterion("paramname not in", values, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameBetween(String value1, String value2) {
            addCriterion("paramname between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andParamnameNotBetween(String value1, String value2) {
            addCriterion("paramname not between", value1, value2, "paramname");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
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

        public Criteria andParamdescIsNull() {
            addCriterion("paramdesc is null");
            return (Criteria) this;
        }

        public Criteria andParamdescIsNotNull() {
            addCriterion("paramdesc is not null");
            return (Criteria) this;
        }

        public Criteria andParamdescEqualTo(String value) {
            addCriterion("paramdesc =", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescNotEqualTo(String value) {
            addCriterion("paramdesc <>", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescGreaterThan(String value) {
            addCriterion("paramdesc >", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescGreaterThanOrEqualTo(String value) {
            addCriterion("paramdesc >=", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescLessThan(String value) {
            addCriterion("paramdesc <", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescLessThanOrEqualTo(String value) {
            addCriterion("paramdesc <=", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescLike(String value) {
            addCriterion("paramdesc like", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescNotLike(String value) {
            addCriterion("paramdesc not like", value, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescIn(List<String> values) {
            addCriterion("paramdesc in", values, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescNotIn(List<String> values) {
            addCriterion("paramdesc not in", values, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescBetween(String value1, String value2) {
            addCriterion("paramdesc between", value1, value2, "paramdesc");
            return (Criteria) this;
        }

        public Criteria andParamdescNotBetween(String value1, String value2) {
            addCriterion("paramdesc not between", value1, value2, "paramdesc");
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
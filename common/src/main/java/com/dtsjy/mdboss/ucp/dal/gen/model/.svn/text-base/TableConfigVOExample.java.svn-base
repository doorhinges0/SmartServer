package com.dtsjy.mdboss.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableConfigVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableConfigVOExample() {
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

        public Criteria andTablenameIsNull() {
            addCriterion("tablename is null");
            return (Criteria) this;
        }

        public Criteria andTablenameIsNotNull() {
            addCriterion("tablename is not null");
            return (Criteria) this;
        }

        public Criteria andTablenameEqualTo(String value) {
            addCriterion("tablename =", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotEqualTo(String value) {
            addCriterion("tablename <>", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThan(String value) {
            addCriterion("tablename >", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameGreaterThanOrEqualTo(String value) {
            addCriterion("tablename >=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThan(String value) {
            addCriterion("tablename <", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLessThanOrEqualTo(String value) {
            addCriterion("tablename <=", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameLike(String value) {
            addCriterion("tablename like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotLike(String value) {
            addCriterion("tablename not like", value, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameIn(List<String> values) {
            addCriterion("tablename in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotIn(List<String> values) {
            addCriterion("tablename not in", values, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameBetween(String value1, String value2) {
            addCriterion("tablename between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andTablenameNotBetween(String value1, String value2) {
            addCriterion("tablename not between", value1, value2, "tablename");
            return (Criteria) this;
        }

        public Criteria andDbnameIsNull() {
            addCriterion("dbname is null");
            return (Criteria) this;
        }

        public Criteria andDbnameIsNotNull() {
            addCriterion("dbname is not null");
            return (Criteria) this;
        }

        public Criteria andDbnameEqualTo(String value) {
            addCriterion("dbname =", value, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameNotEqualTo(String value) {
            addCriterion("dbname <>", value, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameGreaterThan(String value) {
            addCriterion("dbname >", value, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameGreaterThanOrEqualTo(String value) {
            addCriterion("dbname >=", value, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameLessThan(String value) {
            addCriterion("dbname <", value, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameLessThanOrEqualTo(String value) {
            addCriterion("dbname <=", value, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameLike(String value) {
            addCriterion("dbname like", value, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameNotLike(String value) {
            addCriterion("dbname not like", value, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameIn(List<String> values) {
            addCriterion("dbname in", values, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameNotIn(List<String> values) {
            addCriterion("dbname not in", values, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameBetween(String value1, String value2) {
            addCriterion("dbname between", value1, value2, "dbname");
            return (Criteria) this;
        }

        public Criteria andDbnameNotBetween(String value1, String value2) {
            addCriterion("dbname not between", value1, value2, "dbname");
            return (Criteria) this;
        }

        public Criteria andTablecnameIsNull() {
            addCriterion("tablecname is null");
            return (Criteria) this;
        }

        public Criteria andTablecnameIsNotNull() {
            addCriterion("tablecname is not null");
            return (Criteria) this;
        }

        public Criteria andTablecnameEqualTo(String value) {
            addCriterion("tablecname =", value, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameNotEqualTo(String value) {
            addCriterion("tablecname <>", value, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameGreaterThan(String value) {
            addCriterion("tablecname >", value, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameGreaterThanOrEqualTo(String value) {
            addCriterion("tablecname >=", value, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameLessThan(String value) {
            addCriterion("tablecname <", value, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameLessThanOrEqualTo(String value) {
            addCriterion("tablecname <=", value, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameLike(String value) {
            addCriterion("tablecname like", value, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameNotLike(String value) {
            addCriterion("tablecname not like", value, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameIn(List<String> values) {
            addCriterion("tablecname in", values, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameNotIn(List<String> values) {
            addCriterion("tablecname not in", values, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameBetween(String value1, String value2) {
            addCriterion("tablecname between", value1, value2, "tablecname");
            return (Criteria) this;
        }

        public Criteria andTablecnameNotBetween(String value1, String value2) {
            addCriterion("tablecname not between", value1, value2, "tablecname");
            return (Criteria) this;
        }

        public Criteria andDbcnameIsNull() {
            addCriterion("dbcname is null");
            return (Criteria) this;
        }

        public Criteria andDbcnameIsNotNull() {
            addCriterion("dbcname is not null");
            return (Criteria) this;
        }

        public Criteria andDbcnameEqualTo(String value) {
            addCriterion("dbcname =", value, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameNotEqualTo(String value) {
            addCriterion("dbcname <>", value, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameGreaterThan(String value) {
            addCriterion("dbcname >", value, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameGreaterThanOrEqualTo(String value) {
            addCriterion("dbcname >=", value, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameLessThan(String value) {
            addCriterion("dbcname <", value, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameLessThanOrEqualTo(String value) {
            addCriterion("dbcname <=", value, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameLike(String value) {
            addCriterion("dbcname like", value, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameNotLike(String value) {
            addCriterion("dbcname not like", value, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameIn(List<String> values) {
            addCriterion("dbcname in", values, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameNotIn(List<String> values) {
            addCriterion("dbcname not in", values, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameBetween(String value1, String value2) {
            addCriterion("dbcname between", value1, value2, "dbcname");
            return (Criteria) this;
        }

        public Criteria andDbcnameNotBetween(String value1, String value2) {
            addCriterion("dbcname not between", value1, value2, "dbcname");
            return (Criteria) this;
        }

        public Criteria andVonameIsNull() {
            addCriterion("voname is null");
            return (Criteria) this;
        }

        public Criteria andVonameIsNotNull() {
            addCriterion("voname is not null");
            return (Criteria) this;
        }

        public Criteria andVonameEqualTo(String value) {
            addCriterion("voname =", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameNotEqualTo(String value) {
            addCriterion("voname <>", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameGreaterThan(String value) {
            addCriterion("voname >", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameGreaterThanOrEqualTo(String value) {
            addCriterion("voname >=", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameLessThan(String value) {
            addCriterion("voname <", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameLessThanOrEqualTo(String value) {
            addCriterion("voname <=", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameLike(String value) {
            addCriterion("voname like", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameNotLike(String value) {
            addCriterion("voname not like", value, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameIn(List<String> values) {
            addCriterion("voname in", values, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameNotIn(List<String> values) {
            addCriterion("voname not in", values, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameBetween(String value1, String value2) {
            addCriterion("voname between", value1, value2, "voname");
            return (Criteria) this;
        }

        public Criteria andVonameNotBetween(String value1, String value2) {
            addCriterion("voname not between", value1, value2, "voname");
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

        public Criteria andUniqcodeIsNull() {
            addCriterion("uniqcode is null");
            return (Criteria) this;
        }

        public Criteria andUniqcodeIsNotNull() {
            addCriterion("uniqcode is not null");
            return (Criteria) this;
        }

        public Criteria andUniqcodeEqualTo(String value) {
            addCriterion("uniqcode =", value, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeNotEqualTo(String value) {
            addCriterion("uniqcode <>", value, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeGreaterThan(String value) {
            addCriterion("uniqcode >", value, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeGreaterThanOrEqualTo(String value) {
            addCriterion("uniqcode >=", value, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeLessThan(String value) {
            addCriterion("uniqcode <", value, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeLessThanOrEqualTo(String value) {
            addCriterion("uniqcode <=", value, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeLike(String value) {
            addCriterion("uniqcode like", value, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeNotLike(String value) {
            addCriterion("uniqcode not like", value, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeIn(List<String> values) {
            addCriterion("uniqcode in", values, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeNotIn(List<String> values) {
            addCriterion("uniqcode not in", values, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeBetween(String value1, String value2) {
            addCriterion("uniqcode between", value1, value2, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andUniqcodeNotBetween(String value1, String value2) {
            addCriterion("uniqcode not between", value1, value2, "uniqcode");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
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
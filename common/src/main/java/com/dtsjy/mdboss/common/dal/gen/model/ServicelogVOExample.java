package com.dtsjy.mdboss.common.dal.gen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicelogVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServicelogVOExample() {
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

        public Criteria andApinameIsNull() {
            addCriterion("apiname is null");
            return (Criteria) this;
        }

        public Criteria andApinameIsNotNull() {
            addCriterion("apiname is not null");
            return (Criteria) this;
        }

        public Criteria andApinameEqualTo(String value) {
            addCriterion("apiname =", value, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameNotEqualTo(String value) {
            addCriterion("apiname <>", value, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameGreaterThan(String value) {
            addCriterion("apiname >", value, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameGreaterThanOrEqualTo(String value) {
            addCriterion("apiname >=", value, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameLessThan(String value) {
            addCriterion("apiname <", value, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameLessThanOrEqualTo(String value) {
            addCriterion("apiname <=", value, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameLike(String value) {
            addCriterion("apiname like", value, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameNotLike(String value) {
            addCriterion("apiname not like", value, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameIn(List<String> values) {
            addCriterion("apiname in", values, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameNotIn(List<String> values) {
            addCriterion("apiname not in", values, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameBetween(String value1, String value2) {
            addCriterion("apiname between", value1, value2, "apiname");
            return (Criteria) this;
        }

        public Criteria andApinameNotBetween(String value1, String value2) {
            addCriterion("apiname not between", value1, value2, "apiname");
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

        public Criteria andInputdataIsNull() {
            addCriterion("inputdata is null");
            return (Criteria) this;
        }

        public Criteria andInputdataIsNotNull() {
            addCriterion("inputdata is not null");
            return (Criteria) this;
        }

        public Criteria andInputdataEqualTo(String value) {
            addCriterion("inputdata =", value, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataNotEqualTo(String value) {
            addCriterion("inputdata <>", value, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataGreaterThan(String value) {
            addCriterion("inputdata >", value, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataGreaterThanOrEqualTo(String value) {
            addCriterion("inputdata >=", value, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataLessThan(String value) {
            addCriterion("inputdata <", value, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataLessThanOrEqualTo(String value) {
            addCriterion("inputdata <=", value, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataLike(String value) {
            addCriterion("inputdata like", value, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataNotLike(String value) {
            addCriterion("inputdata not like", value, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataIn(List<String> values) {
            addCriterion("inputdata in", values, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataNotIn(List<String> values) {
            addCriterion("inputdata not in", values, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataBetween(String value1, String value2) {
            addCriterion("inputdata between", value1, value2, "inputdata");
            return (Criteria) this;
        }

        public Criteria andInputdataNotBetween(String value1, String value2) {
            addCriterion("inputdata not between", value1, value2, "inputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataIsNull() {
            addCriterion("outputdata is null");
            return (Criteria) this;
        }

        public Criteria andOutputdataIsNotNull() {
            addCriterion("outputdata is not null");
            return (Criteria) this;
        }

        public Criteria andOutputdataEqualTo(String value) {
            addCriterion("outputdata =", value, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataNotEqualTo(String value) {
            addCriterion("outputdata <>", value, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataGreaterThan(String value) {
            addCriterion("outputdata >", value, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataGreaterThanOrEqualTo(String value) {
            addCriterion("outputdata >=", value, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataLessThan(String value) {
            addCriterion("outputdata <", value, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataLessThanOrEqualTo(String value) {
            addCriterion("outputdata <=", value, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataLike(String value) {
            addCriterion("outputdata like", value, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataNotLike(String value) {
            addCriterion("outputdata not like", value, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataIn(List<String> values) {
            addCriterion("outputdata in", values, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataNotIn(List<String> values) {
            addCriterion("outputdata not in", values, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataBetween(String value1, String value2) {
            addCriterion("outputdata between", value1, value2, "outputdata");
            return (Criteria) this;
        }

        public Criteria andOutputdataNotBetween(String value1, String value2) {
            addCriterion("outputdata not between", value1, value2, "outputdata");
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
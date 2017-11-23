package com.sunrise.oa.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewDocReddocmanagerVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ViewDocReddocmanagerVOExample() {
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

        public Criteria andReddocnameIsNull() {
            addCriterion("reddocname is null");
            return (Criteria) this;
        }

        public Criteria andReddocnameIsNotNull() {
            addCriterion("reddocname is not null");
            return (Criteria) this;
        }

        public Criteria andReddocnameEqualTo(String value) {
            addCriterion("reddocname =", value, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameNotEqualTo(String value) {
            addCriterion("reddocname <>", value, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameGreaterThan(String value) {
            addCriterion("reddocname >", value, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameGreaterThanOrEqualTo(String value) {
            addCriterion("reddocname >=", value, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameLessThan(String value) {
            addCriterion("reddocname <", value, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameLessThanOrEqualTo(String value) {
            addCriterion("reddocname <=", value, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameLike(String value) {
            addCriterion("reddocname like", value, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameNotLike(String value) {
            addCriterion("reddocname not like", value, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameIn(List<String> values) {
            addCriterion("reddocname in", values, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameNotIn(List<String> values) {
            addCriterion("reddocname not in", values, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameBetween(String value1, String value2) {
            addCriterion("reddocname between", value1, value2, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddocnameNotBetween(String value1, String value2) {
            addCriterion("reddocname not between", value1, value2, "reddocname");
            return (Criteria) this;
        }

        public Criteria andReddoctypeIsNull() {
            addCriterion("reddoctype is null");
            return (Criteria) this;
        }

        public Criteria andReddoctypeIsNotNull() {
            addCriterion("reddoctype is not null");
            return (Criteria) this;
        }

        public Criteria andReddoctypeEqualTo(String value) {
            addCriterion("reddoctype =", value, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeNotEqualTo(String value) {
            addCriterion("reddoctype <>", value, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeGreaterThan(String value) {
            addCriterion("reddoctype >", value, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeGreaterThanOrEqualTo(String value) {
            addCriterion("reddoctype >=", value, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeLessThan(String value) {
            addCriterion("reddoctype <", value, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeLessThanOrEqualTo(String value) {
            addCriterion("reddoctype <=", value, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeLike(String value) {
            addCriterion("reddoctype like", value, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeNotLike(String value) {
            addCriterion("reddoctype not like", value, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeIn(List<String> values) {
            addCriterion("reddoctype in", values, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeNotIn(List<String> values) {
            addCriterion("reddoctype not in", values, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeBetween(String value1, String value2) {
            addCriterion("reddoctype between", value1, value2, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypeNotBetween(String value1, String value2) {
            addCriterion("reddoctype not between", value1, value2, "reddoctype");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameIsNull() {
            addCriterion("reddoctypename is null");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameIsNotNull() {
            addCriterion("reddoctypename is not null");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameEqualTo(String value) {
            addCriterion("reddoctypename =", value, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameNotEqualTo(String value) {
            addCriterion("reddoctypename <>", value, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameGreaterThan(String value) {
            addCriterion("reddoctypename >", value, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameGreaterThanOrEqualTo(String value) {
            addCriterion("reddoctypename >=", value, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameLessThan(String value) {
            addCriterion("reddoctypename <", value, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameLessThanOrEqualTo(String value) {
            addCriterion("reddoctypename <=", value, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameLike(String value) {
            addCriterion("reddoctypename like", value, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameNotLike(String value) {
            addCriterion("reddoctypename not like", value, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameIn(List<String> values) {
            addCriterion("reddoctypename in", values, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameNotIn(List<String> values) {
            addCriterion("reddoctypename not in", values, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameBetween(String value1, String value2) {
            addCriterion("reddoctypename between", value1, value2, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andReddoctypenameNotBetween(String value1, String value2) {
            addCriterion("reddoctypename not between", value1, value2, "reddoctypename");
            return (Criteria) this;
        }

        public Criteria andFilecodeIsNull() {
            addCriterion("filecode is null");
            return (Criteria) this;
        }

        public Criteria andFilecodeIsNotNull() {
            addCriterion("filecode is not null");
            return (Criteria) this;
        }

        public Criteria andFilecodeEqualTo(String value) {
            addCriterion("filecode =", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotEqualTo(String value) {
            addCriterion("filecode <>", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeGreaterThan(String value) {
            addCriterion("filecode >", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeGreaterThanOrEqualTo(String value) {
            addCriterion("filecode >=", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLessThan(String value) {
            addCriterion("filecode <", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLessThanOrEqualTo(String value) {
            addCriterion("filecode <=", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeLike(String value) {
            addCriterion("filecode like", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotLike(String value) {
            addCriterion("filecode not like", value, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeIn(List<String> values) {
            addCriterion("filecode in", values, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotIn(List<String> values) {
            addCriterion("filecode not in", values, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeBetween(String value1, String value2) {
            addCriterion("filecode between", value1, value2, "filecode");
            return (Criteria) this;
        }

        public Criteria andFilecodeNotBetween(String value1, String value2) {
            addCriterion("filecode not between", value1, value2, "filecode");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatornameIsNull() {
            addCriterion("creatorname is null");
            return (Criteria) this;
        }

        public Criteria andCreatornameIsNotNull() {
            addCriterion("creatorname is not null");
            return (Criteria) this;
        }

        public Criteria andCreatornameEqualTo(String value) {
            addCriterion("creatorname =", value, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameNotEqualTo(String value) {
            addCriterion("creatorname <>", value, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameGreaterThan(String value) {
            addCriterion("creatorname >", value, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameGreaterThanOrEqualTo(String value) {
            addCriterion("creatorname >=", value, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameLessThan(String value) {
            addCriterion("creatorname <", value, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameLessThanOrEqualTo(String value) {
            addCriterion("creatorname <=", value, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameLike(String value) {
            addCriterion("creatorname like", value, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameNotLike(String value) {
            addCriterion("creatorname not like", value, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameIn(List<String> values) {
            addCriterion("creatorname in", values, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameNotIn(List<String> values) {
            addCriterion("creatorname not in", values, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameBetween(String value1, String value2) {
            addCriterion("creatorname between", value1, value2, "creatorname");
            return (Criteria) this;
        }

        public Criteria andCreatornameNotBetween(String value1, String value2) {
            addCriterion("creatorname not between", value1, value2, "creatorname");
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
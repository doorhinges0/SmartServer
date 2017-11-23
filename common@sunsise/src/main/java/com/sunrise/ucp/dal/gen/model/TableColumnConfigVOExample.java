package com.sunrise.ucp.dal.gen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableColumnConfigVOExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TableColumnConfigVOExample() {
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

        public Criteria andColumnnameIsNull() {
            addCriterion("columnname is null");
            return (Criteria) this;
        }

        public Criteria andColumnnameIsNotNull() {
            addCriterion("columnname is not null");
            return (Criteria) this;
        }

        public Criteria andColumnnameEqualTo(String value) {
            addCriterion("columnname =", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotEqualTo(String value) {
            addCriterion("columnname <>", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThan(String value) {
            addCriterion("columnname >", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameGreaterThanOrEqualTo(String value) {
            addCriterion("columnname >=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThan(String value) {
            addCriterion("columnname <", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLessThanOrEqualTo(String value) {
            addCriterion("columnname <=", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameLike(String value) {
            addCriterion("columnname like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotLike(String value) {
            addCriterion("columnname not like", value, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameIn(List<String> values) {
            addCriterion("columnname in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotIn(List<String> values) {
            addCriterion("columnname not in", values, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameBetween(String value1, String value2) {
            addCriterion("columnname between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumnnameNotBetween(String value1, String value2) {
            addCriterion("columnname not between", value1, value2, "columnname");
            return (Criteria) this;
        }

        public Criteria andColumncnameIsNull() {
            addCriterion("columncname is null");
            return (Criteria) this;
        }

        public Criteria andColumncnameIsNotNull() {
            addCriterion("columncname is not null");
            return (Criteria) this;
        }

        public Criteria andColumncnameEqualTo(String value) {
            addCriterion("columncname =", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameNotEqualTo(String value) {
            addCriterion("columncname <>", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameGreaterThan(String value) {
            addCriterion("columncname >", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameGreaterThanOrEqualTo(String value) {
            addCriterion("columncname >=", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameLessThan(String value) {
            addCriterion("columncname <", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameLessThanOrEqualTo(String value) {
            addCriterion("columncname <=", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameLike(String value) {
            addCriterion("columncname like", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameNotLike(String value) {
            addCriterion("columncname not like", value, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameIn(List<String> values) {
            addCriterion("columncname in", values, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameNotIn(List<String> values) {
            addCriterion("columncname not in", values, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameBetween(String value1, String value2) {
            addCriterion("columncname between", value1, value2, "columncname");
            return (Criteria) this;
        }

        public Criteria andColumncnameNotBetween(String value1, String value2) {
            addCriterion("columncname not between", value1, value2, "columncname");
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

        public Criteria andVofieldnameIsNull() {
            addCriterion("vofieldname is null");
            return (Criteria) this;
        }

        public Criteria andVofieldnameIsNotNull() {
            addCriterion("vofieldname is not null");
            return (Criteria) this;
        }

        public Criteria andVofieldnameEqualTo(String value) {
            addCriterion("vofieldname =", value, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameNotEqualTo(String value) {
            addCriterion("vofieldname <>", value, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameGreaterThan(String value) {
            addCriterion("vofieldname >", value, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameGreaterThanOrEqualTo(String value) {
            addCriterion("vofieldname >=", value, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameLessThan(String value) {
            addCriterion("vofieldname <", value, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameLessThanOrEqualTo(String value) {
            addCriterion("vofieldname <=", value, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameLike(String value) {
            addCriterion("vofieldname like", value, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameNotLike(String value) {
            addCriterion("vofieldname not like", value, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameIn(List<String> values) {
            addCriterion("vofieldname in", values, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameNotIn(List<String> values) {
            addCriterion("vofieldname not in", values, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameBetween(String value1, String value2) {
            addCriterion("vofieldname between", value1, value2, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andVofieldnameNotBetween(String value1, String value2) {
            addCriterion("vofieldname not between", value1, value2, "vofieldname");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeIsNull() {
            addCriterion("isuniqcode is null");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeIsNotNull() {
            addCriterion("isuniqcode is not null");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeEqualTo(Boolean value) {
            addCriterion("isuniqcode =", value, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeNotEqualTo(Boolean value) {
            addCriterion("isuniqcode <>", value, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeGreaterThan(Boolean value) {
            addCriterion("isuniqcode >", value, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isuniqcode >=", value, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeLessThan(Boolean value) {
            addCriterion("isuniqcode <", value, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeLessThanOrEqualTo(Boolean value) {
            addCriterion("isuniqcode <=", value, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeIn(List<Boolean> values) {
            addCriterion("isuniqcode in", values, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeNotIn(List<Boolean> values) {
            addCriterion("isuniqcode not in", values, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeBetween(Boolean value1, Boolean value2) {
            addCriterion("isuniqcode between", value1, value2, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andIsuniqcodeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isuniqcode not between", value1, value2, "isuniqcode");
            return (Criteria) this;
        }

        public Criteria andColumntypeIsNull() {
            addCriterion("columntype is null");
            return (Criteria) this;
        }

        public Criteria andColumntypeIsNotNull() {
            addCriterion("columntype is not null");
            return (Criteria) this;
        }

        public Criteria andColumntypeEqualTo(String value) {
            addCriterion("columntype =", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeNotEqualTo(String value) {
            addCriterion("columntype <>", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeGreaterThan(String value) {
            addCriterion("columntype >", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeGreaterThanOrEqualTo(String value) {
            addCriterion("columntype >=", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeLessThan(String value) {
            addCriterion("columntype <", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeLessThanOrEqualTo(String value) {
            addCriterion("columntype <=", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeLike(String value) {
            addCriterion("columntype like", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeNotLike(String value) {
            addCriterion("columntype not like", value, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeIn(List<String> values) {
            addCriterion("columntype in", values, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeNotIn(List<String> values) {
            addCriterion("columntype not in", values, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeBetween(String value1, String value2) {
            addCriterion("columntype between", value1, value2, "columntype");
            return (Criteria) this;
        }

        public Criteria andColumntypeNotBetween(String value1, String value2) {
            addCriterion("columntype not between", value1, value2, "columntype");
            return (Criteria) this;
        }

        public Criteria andRulejsonIsNull() {
            addCriterion("rulejson is null");
            return (Criteria) this;
        }

        public Criteria andRulejsonIsNotNull() {
            addCriterion("rulejson is not null");
            return (Criteria) this;
        }

        public Criteria andRulejsonEqualTo(String value) {
            addCriterion("rulejson =", value, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonNotEqualTo(String value) {
            addCriterion("rulejson <>", value, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonGreaterThan(String value) {
            addCriterion("rulejson >", value, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonGreaterThanOrEqualTo(String value) {
            addCriterion("rulejson >=", value, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonLessThan(String value) {
            addCriterion("rulejson <", value, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonLessThanOrEqualTo(String value) {
            addCriterion("rulejson <=", value, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonLike(String value) {
            addCriterion("rulejson like", value, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonNotLike(String value) {
            addCriterion("rulejson not like", value, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonIn(List<String> values) {
            addCriterion("rulejson in", values, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonNotIn(List<String> values) {
            addCriterion("rulejson not in", values, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonBetween(String value1, String value2) {
            addCriterion("rulejson between", value1, value2, "rulejson");
            return (Criteria) this;
        }

        public Criteria andRulejsonNotBetween(String value1, String value2) {
            addCriterion("rulejson not between", value1, value2, "rulejson");
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

        public Criteria andSetoncreateIsNull() {
            addCriterion("setoncreate is null");
            return (Criteria) this;
        }

        public Criteria andSetoncreateIsNotNull() {
            addCriterion("setoncreate is not null");
            return (Criteria) this;
        }

        public Criteria andSetoncreateEqualTo(Boolean value) {
            addCriterion("setoncreate =", value, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateNotEqualTo(Boolean value) {
            addCriterion("setoncreate <>", value, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateGreaterThan(Boolean value) {
            addCriterion("setoncreate >", value, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("setoncreate >=", value, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateLessThan(Boolean value) {
            addCriterion("setoncreate <", value, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateLessThanOrEqualTo(Boolean value) {
            addCriterion("setoncreate <=", value, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateIn(List<Boolean> values) {
            addCriterion("setoncreate in", values, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateNotIn(List<Boolean> values) {
            addCriterion("setoncreate not in", values, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateBetween(Boolean value1, Boolean value2) {
            addCriterion("setoncreate between", value1, value2, "setoncreate");
            return (Criteria) this;
        }

        public Criteria andSetoncreateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("setoncreate not between", value1, value2, "setoncreate");
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
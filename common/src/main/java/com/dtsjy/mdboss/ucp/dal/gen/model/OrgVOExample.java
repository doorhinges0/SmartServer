package com.dtsjy.mdboss.ucp.dal.gen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgVOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgVOExample() {
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

        public Criteria andOrgtypeIsNull() {
            addCriterion("orgtype is null");
            return (Criteria) this;
        }

        public Criteria andOrgtypeIsNotNull() {
            addCriterion("orgtype is not null");
            return (Criteria) this;
        }

        public Criteria andOrgtypeEqualTo(String value) {
            addCriterion("orgtype =", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotEqualTo(String value) {
            addCriterion("orgtype <>", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeGreaterThan(String value) {
            addCriterion("orgtype >", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("orgtype >=", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLessThan(String value) {
            addCriterion("orgtype <", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLessThanOrEqualTo(String value) {
            addCriterion("orgtype <=", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeLike(String value) {
            addCriterion("orgtype like", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotLike(String value) {
            addCriterion("orgtype not like", value, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeIn(List<String> values) {
            addCriterion("orgtype in", values, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotIn(List<String> values) {
            addCriterion("orgtype not in", values, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeBetween(String value1, String value2) {
            addCriterion("orgtype between", value1, value2, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrgtypeNotBetween(String value1, String value2) {
            addCriterion("orgtype not between", value1, value2, "orgtype");
            return (Criteria) this;
        }

        public Criteria andOrglevelIsNull() {
            addCriterion("orglevel is null");
            return (Criteria) this;
        }

        public Criteria andOrglevelIsNotNull() {
            addCriterion("orglevel is not null");
            return (Criteria) this;
        }

        public Criteria andOrglevelEqualTo(String value) {
            addCriterion("orglevel =", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelNotEqualTo(String value) {
            addCriterion("orglevel <>", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelGreaterThan(String value) {
            addCriterion("orglevel >", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelGreaterThanOrEqualTo(String value) {
            addCriterion("orglevel >=", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelLessThan(String value) {
            addCriterion("orglevel <", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelLessThanOrEqualTo(String value) {
            addCriterion("orglevel <=", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelLike(String value) {
            addCriterion("orglevel like", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelNotLike(String value) {
            addCriterion("orglevel not like", value, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelIn(List<String> values) {
            addCriterion("orglevel in", values, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelNotIn(List<String> values) {
            addCriterion("orglevel not in", values, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelBetween(String value1, String value2) {
            addCriterion("orglevel between", value1, value2, "orglevel");
            return (Criteria) this;
        }

        public Criteria andOrglevelNotBetween(String value1, String value2) {
            addCriterion("orglevel not between", value1, value2, "orglevel");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNull() {
            addCriterion("parentcode is null");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNotNull() {
            addCriterion("parentcode is not null");
            return (Criteria) this;
        }

        public Criteria andParentcodeEqualTo(String value) {
            addCriterion("parentcode =", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotEqualTo(String value) {
            addCriterion("parentcode <>", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThan(String value) {
            addCriterion("parentcode >", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("parentcode >=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThan(String value) {
            addCriterion("parentcode <", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThanOrEqualTo(String value) {
            addCriterion("parentcode <=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLike(String value) {
            addCriterion("parentcode like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotLike(String value) {
            addCriterion("parentcode not like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeIn(List<String> values) {
            addCriterion("parentcode in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotIn(List<String> values) {
            addCriterion("parentcode not in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeBetween(String value1, String value2) {
            addCriterion("parentcode between", value1, value2, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotBetween(String value1, String value2) {
            addCriterion("parentcode not between", value1, value2, "parentcode");
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

        public Criteria andOrgorderIsNull() {
            addCriterion("orgorder is null");
            return (Criteria) this;
        }

        public Criteria andOrgorderIsNotNull() {
            addCriterion("orgorder is not null");
            return (Criteria) this;
        }

        public Criteria andOrgorderEqualTo(Byte value) {
            addCriterion("orgorder =", value, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderNotEqualTo(Byte value) {
            addCriterion("orgorder <>", value, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderGreaterThan(Byte value) {
            addCriterion("orgorder >", value, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderGreaterThanOrEqualTo(Byte value) {
            addCriterion("orgorder >=", value, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderLessThan(Byte value) {
            addCriterion("orgorder <", value, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderLessThanOrEqualTo(Byte value) {
            addCriterion("orgorder <=", value, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderIn(List<Byte> values) {
            addCriterion("orgorder in", values, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderNotIn(List<Byte> values) {
            addCriterion("orgorder not in", values, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderBetween(Byte value1, Byte value2) {
            addCriterion("orgorder between", value1, value2, "orgorder");
            return (Criteria) this;
        }

        public Criteria andOrgorderNotBetween(Byte value1, Byte value2) {
            addCriterion("orgorder not between", value1, value2, "orgorder");
            return (Criteria) this;
        }

        public Criteria andIconclassIsNull() {
            addCriterion("iconclass is null");
            return (Criteria) this;
        }

        public Criteria andIconclassIsNotNull() {
            addCriterion("iconclass is not null");
            return (Criteria) this;
        }

        public Criteria andIconclassEqualTo(String value) {
            addCriterion("iconclass =", value, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassNotEqualTo(String value) {
            addCriterion("iconclass <>", value, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassGreaterThan(String value) {
            addCriterion("iconclass >", value, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassGreaterThanOrEqualTo(String value) {
            addCriterion("iconclass >=", value, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassLessThan(String value) {
            addCriterion("iconclass <", value, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassLessThanOrEqualTo(String value) {
            addCriterion("iconclass <=", value, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassLike(String value) {
            addCriterion("iconclass like", value, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassNotLike(String value) {
            addCriterion("iconclass not like", value, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassIn(List<String> values) {
            addCriterion("iconclass in", values, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassNotIn(List<String> values) {
            addCriterion("iconclass not in", values, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassBetween(String value1, String value2) {
            addCriterion("iconclass between", value1, value2, "iconclass");
            return (Criteria) this;
        }

        public Criteria andIconclassNotBetween(String value1, String value2) {
            addCriterion("iconclass not between", value1, value2, "iconclass");
            return (Criteria) this;
        }

        public Criteria andOrgdescIsNull() {
            addCriterion("orgdesc is null");
            return (Criteria) this;
        }

        public Criteria andOrgdescIsNotNull() {
            addCriterion("orgdesc is not null");
            return (Criteria) this;
        }

        public Criteria andOrgdescEqualTo(String value) {
            addCriterion("orgdesc =", value, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescNotEqualTo(String value) {
            addCriterion("orgdesc <>", value, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescGreaterThan(String value) {
            addCriterion("orgdesc >", value, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescGreaterThanOrEqualTo(String value) {
            addCriterion("orgdesc >=", value, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescLessThan(String value) {
            addCriterion("orgdesc <", value, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescLessThanOrEqualTo(String value) {
            addCriterion("orgdesc <=", value, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescLike(String value) {
            addCriterion("orgdesc like", value, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescNotLike(String value) {
            addCriterion("orgdesc not like", value, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescIn(List<String> values) {
            addCriterion("orgdesc in", values, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescNotIn(List<String> values) {
            addCriterion("orgdesc not in", values, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescBetween(String value1, String value2) {
            addCriterion("orgdesc between", value1, value2, "orgdesc");
            return (Criteria) this;
        }

        public Criteria andOrgdescNotBetween(String value1, String value2) {
            addCriterion("orgdesc not between", value1, value2, "orgdesc");
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
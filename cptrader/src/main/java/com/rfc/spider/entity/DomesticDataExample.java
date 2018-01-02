package com.rfc.spider.entity;

import java.util.ArrayList;
import java.util.List;

public class DomesticDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DomesticDataExample() {
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

        public Criteria andBatchnoIsNull() {
            addCriterion("batchno is null");
            return (Criteria) this;
        }

        public Criteria andBatchnoIsNotNull() {
            addCriterion("batchno is not null");
            return (Criteria) this;
        }

        public Criteria andBatchnoEqualTo(Integer value) {
            addCriterion("batchno =", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotEqualTo(Integer value) {
            addCriterion("batchno <>", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoGreaterThan(Integer value) {
            addCriterion("batchno >", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("batchno >=", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLessThan(Integer value) {
            addCriterion("batchno <", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoLessThanOrEqualTo(Integer value) {
            addCriterion("batchno <=", value, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoIn(List<Integer> values) {
            addCriterion("batchno in", values, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotIn(List<Integer> values) {
            addCriterion("batchno not in", values, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoBetween(Integer value1, Integer value2) {
            addCriterion("batchno between", value1, value2, "batchno");
            return (Criteria) this;
        }

        public Criteria andBatchnoNotBetween(Integer value1, Integer value2) {
            addCriterion("batchno not between", value1, value2, "batchno");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNull() {
            addCriterion("biztype is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNotNull() {
            addCriterion("biztype is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeEqualTo(Integer value) {
            addCriterion("biztype =", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotEqualTo(Integer value) {
            addCriterion("biztype <>", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThan(Integer value) {
            addCriterion("biztype >", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("biztype >=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThan(Integer value) {
            addCriterion("biztype <", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThanOrEqualTo(Integer value) {
            addCriterion("biztype <=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIn(List<Integer> values) {
            addCriterion("biztype in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotIn(List<Integer> values) {
            addCriterion("biztype not in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeBetween(Integer value1, Integer value2) {
            addCriterion("biztype between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotBetween(Integer value1, Integer value2) {
            addCriterion("biztype not between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andHandicapIsNull() {
            addCriterion("handicap is null");
            return (Criteria) this;
        }

        public Criteria andHandicapIsNotNull() {
            addCriterion("handicap is not null");
            return (Criteria) this;
        }

        public Criteria andHandicapEqualTo(Integer value) {
            addCriterion("handicap =", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotEqualTo(Integer value) {
            addCriterion("handicap <>", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapGreaterThan(Integer value) {
            addCriterion("handicap >", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapGreaterThanOrEqualTo(Integer value) {
            addCriterion("handicap >=", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLessThan(Integer value) {
            addCriterion("handicap <", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapLessThanOrEqualTo(Integer value) {
            addCriterion("handicap <=", value, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapIn(List<Integer> values) {
            addCriterion("handicap in", values, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotIn(List<Integer> values) {
            addCriterion("handicap not in", values, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapBetween(Integer value1, Integer value2) {
            addCriterion("handicap between", value1, value2, "handicap");
            return (Criteria) this;
        }

        public Criteria andHandicapNotBetween(Integer value1, Integer value2) {
            addCriterion("handicap not between", value1, value2, "handicap");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andSubcompanyIsNull() {
            addCriterion("subcompany is null");
            return (Criteria) this;
        }

        public Criteria andSubcompanyIsNotNull() {
            addCriterion("subcompany is not null");
            return (Criteria) this;
        }

        public Criteria andSubcompanyEqualTo(String value) {
            addCriterion("subcompany =", value, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyNotEqualTo(String value) {
            addCriterion("subcompany <>", value, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyGreaterThan(String value) {
            addCriterion("subcompany >", value, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyGreaterThanOrEqualTo(String value) {
            addCriterion("subcompany >=", value, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyLessThan(String value) {
            addCriterion("subcompany <", value, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyLessThanOrEqualTo(String value) {
            addCriterion("subcompany <=", value, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyLike(String value) {
            addCriterion("subcompany like", value, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyNotLike(String value) {
            addCriterion("subcompany not like", value, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyIn(List<String> values) {
            addCriterion("subcompany in", values, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyNotIn(List<String> values) {
            addCriterion("subcompany not in", values, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyBetween(String value1, String value2) {
            addCriterion("subcompany between", value1, value2, "subcompany");
            return (Criteria) this;
        }

        public Criteria andSubcompanyNotBetween(String value1, String value2) {
            addCriterion("subcompany not between", value1, value2, "subcompany");
            return (Criteria) this;
        }

        public Criteria andTeamIsNull() {
            addCriterion("team is null");
            return (Criteria) this;
        }

        public Criteria andTeamIsNotNull() {
            addCriterion("team is not null");
            return (Criteria) this;
        }

        public Criteria andTeamEqualTo(String value) {
            addCriterion("team =", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotEqualTo(String value) {
            addCriterion("team <>", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThan(String value) {
            addCriterion("team >", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamGreaterThanOrEqualTo(String value) {
            addCriterion("team >=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThan(String value) {
            addCriterion("team <", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLessThanOrEqualTo(String value) {
            addCriterion("team <=", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamLike(String value) {
            addCriterion("team like", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotLike(String value) {
            addCriterion("team not like", value, "team");
            return (Criteria) this;
        }

        public Criteria andTeamIn(List<String> values) {
            addCriterion("team in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotIn(List<String> values) {
            addCriterion("team not in", values, "team");
            return (Criteria) this;
        }

        public Criteria andTeamBetween(String value1, String value2) {
            addCriterion("team between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andTeamNotBetween(String value1, String value2) {
            addCriterion("team not between", value1, value2, "team");
            return (Criteria) this;
        }

        public Criteria andSeqtimeIsNull() {
            addCriterion("seqtime is null");
            return (Criteria) this;
        }

        public Criteria andSeqtimeIsNotNull() {
            addCriterion("seqtime is not null");
            return (Criteria) this;
        }

        public Criteria andSeqtimeEqualTo(String value) {
            addCriterion("seqtime =", value, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeNotEqualTo(String value) {
            addCriterion("seqtime <>", value, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeGreaterThan(String value) {
            addCriterion("seqtime >", value, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeGreaterThanOrEqualTo(String value) {
            addCriterion("seqtime >=", value, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeLessThan(String value) {
            addCriterion("seqtime <", value, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeLessThanOrEqualTo(String value) {
            addCriterion("seqtime <=", value, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeLike(String value) {
            addCriterion("seqtime like", value, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeNotLike(String value) {
            addCriterion("seqtime not like", value, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeIn(List<String> values) {
            addCriterion("seqtime in", values, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeNotIn(List<String> values) {
            addCriterion("seqtime not in", values, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeBetween(String value1, String value2) {
            addCriterion("seqtime between", value1, value2, "seqtime");
            return (Criteria) this;
        }

        public Criteria andSeqtimeNotBetween(String value1, String value2) {
            addCriterion("seqtime not between", value1, value2, "seqtime");
            return (Criteria) this;
        }

        public Criteria andWratioIsNull() {
            addCriterion("wratio is null");
            return (Criteria) this;
        }

        public Criteria andWratioIsNotNull() {
            addCriterion("wratio is not null");
            return (Criteria) this;
        }

        public Criteria andWratioEqualTo(Double value) {
            addCriterion("wratio =", value, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioNotEqualTo(Double value) {
            addCriterion("wratio <>", value, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioGreaterThan(Double value) {
            addCriterion("wratio >", value, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioGreaterThanOrEqualTo(Double value) {
            addCriterion("wratio >=", value, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioLessThan(Double value) {
            addCriterion("wratio <", value, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioLessThanOrEqualTo(Double value) {
            addCriterion("wratio <=", value, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioIn(List<Double> values) {
            addCriterion("wratio in", values, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioNotIn(List<Double> values) {
            addCriterion("wratio not in", values, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioBetween(Double value1, Double value2) {
            addCriterion("wratio between", value1, value2, "wratio");
            return (Criteria) this;
        }

        public Criteria andWratioNotBetween(Double value1, Double value2) {
            addCriterion("wratio not between", value1, value2, "wratio");
            return (Criteria) this;
        }

        public Criteria andDratioIsNull() {
            addCriterion("dratio is null");
            return (Criteria) this;
        }

        public Criteria andDratioIsNotNull() {
            addCriterion("dratio is not null");
            return (Criteria) this;
        }

        public Criteria andDratioEqualTo(Double value) {
            addCriterion("dratio =", value, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioNotEqualTo(Double value) {
            addCriterion("dratio <>", value, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioGreaterThan(Double value) {
            addCriterion("dratio >", value, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioGreaterThanOrEqualTo(Double value) {
            addCriterion("dratio >=", value, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioLessThan(Double value) {
            addCriterion("dratio <", value, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioLessThanOrEqualTo(Double value) {
            addCriterion("dratio <=", value, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioIn(List<Double> values) {
            addCriterion("dratio in", values, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioNotIn(List<Double> values) {
            addCriterion("dratio not in", values, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioBetween(Double value1, Double value2) {
            addCriterion("dratio between", value1, value2, "dratio");
            return (Criteria) this;
        }

        public Criteria andDratioNotBetween(Double value1, Double value2) {
            addCriterion("dratio not between", value1, value2, "dratio");
            return (Criteria) this;
        }

        public Criteria andLratioIsNull() {
            addCriterion("lratio is null");
            return (Criteria) this;
        }

        public Criteria andLratioIsNotNull() {
            addCriterion("lratio is not null");
            return (Criteria) this;
        }

        public Criteria andLratioEqualTo(Double value) {
            addCriterion("lratio =", value, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioNotEqualTo(Double value) {
            addCriterion("lratio <>", value, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioGreaterThan(Double value) {
            addCriterion("lratio >", value, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioGreaterThanOrEqualTo(Double value) {
            addCriterion("lratio >=", value, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioLessThan(Double value) {
            addCriterion("lratio <", value, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioLessThanOrEqualTo(Double value) {
            addCriterion("lratio <=", value, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioIn(List<Double> values) {
            addCriterion("lratio in", values, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioNotIn(List<Double> values) {
            addCriterion("lratio not in", values, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioBetween(Double value1, Double value2) {
            addCriterion("lratio between", value1, value2, "lratio");
            return (Criteria) this;
        }

        public Criteria andLratioNotBetween(Double value1, Double value2) {
            addCriterion("lratio not between", value1, value2, "lratio");
            return (Criteria) this;
        }

        public Criteria andRatio1IsNull() {
            addCriterion("ratio1 is null");
            return (Criteria) this;
        }

        public Criteria andRatio1IsNotNull() {
            addCriterion("ratio1 is not null");
            return (Criteria) this;
        }

        public Criteria andRatio1EqualTo(Double value) {
            addCriterion("ratio1 =", value, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1NotEqualTo(Double value) {
            addCriterion("ratio1 <>", value, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1GreaterThan(Double value) {
            addCriterion("ratio1 >", value, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1GreaterThanOrEqualTo(Double value) {
            addCriterion("ratio1 >=", value, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1LessThan(Double value) {
            addCriterion("ratio1 <", value, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1LessThanOrEqualTo(Double value) {
            addCriterion("ratio1 <=", value, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1In(List<Double> values) {
            addCriterion("ratio1 in", values, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1NotIn(List<Double> values) {
            addCriterion("ratio1 not in", values, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1Between(Double value1, Double value2) {
            addCriterion("ratio1 between", value1, value2, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio1NotBetween(Double value1, Double value2) {
            addCriterion("ratio1 not between", value1, value2, "ratio1");
            return (Criteria) this;
        }

        public Criteria andRatio2IsNull() {
            addCriterion("ratio2 is null");
            return (Criteria) this;
        }

        public Criteria andRatio2IsNotNull() {
            addCriterion("ratio2 is not null");
            return (Criteria) this;
        }

        public Criteria andRatio2EqualTo(Double value) {
            addCriterion("ratio2 =", value, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2NotEqualTo(Double value) {
            addCriterion("ratio2 <>", value, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2GreaterThan(Double value) {
            addCriterion("ratio2 >", value, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2GreaterThanOrEqualTo(Double value) {
            addCriterion("ratio2 >=", value, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2LessThan(Double value) {
            addCriterion("ratio2 <", value, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2LessThanOrEqualTo(Double value) {
            addCriterion("ratio2 <=", value, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2In(List<Double> values) {
            addCriterion("ratio2 in", values, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2NotIn(List<Double> values) {
            addCriterion("ratio2 not in", values, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2Between(Double value1, Double value2) {
            addCriterion("ratio2 between", value1, value2, "ratio2");
            return (Criteria) this;
        }

        public Criteria andRatio2NotBetween(Double value1, Double value2) {
            addCriterion("ratio2 not between", value1, value2, "ratio2");
            return (Criteria) this;
        }

        public Criteria andCahandicapIsNull() {
            addCriterion("cahandicap is null");
            return (Criteria) this;
        }

        public Criteria andCahandicapIsNotNull() {
            addCriterion("cahandicap is not null");
            return (Criteria) this;
        }

        public Criteria andCahandicapEqualTo(String value) {
            addCriterion("cahandicap =", value, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapNotEqualTo(String value) {
            addCriterion("cahandicap <>", value, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapGreaterThan(String value) {
            addCriterion("cahandicap >", value, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapGreaterThanOrEqualTo(String value) {
            addCriterion("cahandicap >=", value, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapLessThan(String value) {
            addCriterion("cahandicap <", value, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapLessThanOrEqualTo(String value) {
            addCriterion("cahandicap <=", value, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapLike(String value) {
            addCriterion("cahandicap like", value, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapNotLike(String value) {
            addCriterion("cahandicap not like", value, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapIn(List<String> values) {
            addCriterion("cahandicap in", values, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapNotIn(List<String> values) {
            addCriterion("cahandicap not in", values, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapBetween(String value1, String value2) {
            addCriterion("cahandicap between", value1, value2, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCahandicapNotBetween(String value1, String value2) {
            addCriterion("cahandicap not between", value1, value2, "cahandicap");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("createdate like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("createdate not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
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
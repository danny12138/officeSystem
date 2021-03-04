package com.danny.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEnameIsNull() {
            addCriterion("ename is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("ename is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("ename =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("ename <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("ename >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("ename >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("ename <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("ename <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("ename like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("ename not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("ename in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("ename not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("ename between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("ename not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEsexIsNull() {
            addCriterion("esex is null");
            return (Criteria) this;
        }

        public Criteria andEsexIsNotNull() {
            addCriterion("esex is not null");
            return (Criteria) this;
        }

        public Criteria andEsexEqualTo(Integer value) {
            addCriterion("esex =", value, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexNotEqualTo(Integer value) {
            addCriterion("esex <>", value, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexGreaterThan(Integer value) {
            addCriterion("esex >", value, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexGreaterThanOrEqualTo(Integer value) {
            addCriterion("esex >=", value, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexLessThan(Integer value) {
            addCriterion("esex <", value, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexLessThanOrEqualTo(Integer value) {
            addCriterion("esex <=", value, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexIn(List<Integer> values) {
            addCriterion("esex in", values, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexNotIn(List<Integer> values) {
            addCriterion("esex not in", values, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexBetween(Integer value1, Integer value2) {
            addCriterion("esex between", value1, value2, "esex");
            return (Criteria) this;
        }

        public Criteria andEsexNotBetween(Integer value1, Integer value2) {
            addCriterion("esex not between", value1, value2, "esex");
            return (Criteria) this;
        }

        public Criteria andEageIsNull() {
            addCriterion("eage is null");
            return (Criteria) this;
        }

        public Criteria andEageIsNotNull() {
            addCriterion("eage is not null");
            return (Criteria) this;
        }

        public Criteria andEageEqualTo(Integer value) {
            addCriterion("eage =", value, "eage");
            return (Criteria) this;
        }

        public Criteria andEageNotEqualTo(Integer value) {
            addCriterion("eage <>", value, "eage");
            return (Criteria) this;
        }

        public Criteria andEageGreaterThan(Integer value) {
            addCriterion("eage >", value, "eage");
            return (Criteria) this;
        }

        public Criteria andEageGreaterThanOrEqualTo(Integer value) {
            addCriterion("eage >=", value, "eage");
            return (Criteria) this;
        }

        public Criteria andEageLessThan(Integer value) {
            addCriterion("eage <", value, "eage");
            return (Criteria) this;
        }

        public Criteria andEageLessThanOrEqualTo(Integer value) {
            addCriterion("eage <=", value, "eage");
            return (Criteria) this;
        }

        public Criteria andEageIn(List<Integer> values) {
            addCriterion("eage in", values, "eage");
            return (Criteria) this;
        }

        public Criteria andEageNotIn(List<Integer> values) {
            addCriterion("eage not in", values, "eage");
            return (Criteria) this;
        }

        public Criteria andEageBetween(Integer value1, Integer value2) {
            addCriterion("eage between", value1, value2, "eage");
            return (Criteria) this;
        }

        public Criteria andEageNotBetween(Integer value1, Integer value2) {
            addCriterion("eage not between", value1, value2, "eage");
            return (Criteria) this;
        }

        public Criteria andEphonenoIsNull() {
            addCriterion("ephoneno is null");
            return (Criteria) this;
        }

        public Criteria andEphonenoIsNotNull() {
            addCriterion("ephoneno is not null");
            return (Criteria) this;
        }

        public Criteria andEphonenoEqualTo(String value) {
            addCriterion("ephoneno =", value, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoNotEqualTo(String value) {
            addCriterion("ephoneno <>", value, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoGreaterThan(String value) {
            addCriterion("ephoneno >", value, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoGreaterThanOrEqualTo(String value) {
            addCriterion("ephoneno >=", value, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoLessThan(String value) {
            addCriterion("ephoneno <", value, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoLessThanOrEqualTo(String value) {
            addCriterion("ephoneno <=", value, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoLike(String value) {
            addCriterion("ephoneno like", value, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoNotLike(String value) {
            addCriterion("ephoneno not like", value, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoIn(List<String> values) {
            addCriterion("ephoneno in", values, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoNotIn(List<String> values) {
            addCriterion("ephoneno not in", values, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoBetween(String value1, String value2) {
            addCriterion("ephoneno between", value1, value2, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEphonenoNotBetween(String value1, String value2) {
            addCriterion("ephoneno not between", value1, value2, "ephoneno");
            return (Criteria) this;
        }

        public Criteria andEhiredateIsNull() {
            addCriterion("ehiredate is null");
            return (Criteria) this;
        }

        public Criteria andEhiredateIsNotNull() {
            addCriterion("ehiredate is not null");
            return (Criteria) this;
        }

        public Criteria andEhiredateEqualTo(Date value) {
            addCriterionForJDBCDate("ehiredate =", value, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ehiredate <>", value, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateGreaterThan(Date value) {
            addCriterionForJDBCDate("ehiredate >", value, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ehiredate >=", value, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateLessThan(Date value) {
            addCriterionForJDBCDate("ehiredate <", value, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ehiredate <=", value, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateIn(List<Date> values) {
            addCriterionForJDBCDate("ehiredate in", values, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ehiredate not in", values, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ehiredate between", value1, value2, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEhiredateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ehiredate not between", value1, value2, "ehiredate");
            return (Criteria) this;
        }

        public Criteria andEjobnoIsNull() {
            addCriterion("ejobno is null");
            return (Criteria) this;
        }

        public Criteria andEjobnoIsNotNull() {
            addCriterion("ejobno is not null");
            return (Criteria) this;
        }

        public Criteria andEjobnoEqualTo(String value) {
            addCriterion("ejobno =", value, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoNotEqualTo(String value) {
            addCriterion("ejobno <>", value, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoGreaterThan(String value) {
            addCriterion("ejobno >", value, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoGreaterThanOrEqualTo(String value) {
            addCriterion("ejobno >=", value, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoLessThan(String value) {
            addCriterion("ejobno <", value, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoLessThanOrEqualTo(String value) {
            addCriterion("ejobno <=", value, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoLike(String value) {
            addCriterion("ejobno like", value, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoNotLike(String value) {
            addCriterion("ejobno not like", value, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoIn(List<String> values) {
            addCriterion("ejobno in", values, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoNotIn(List<String> values) {
            addCriterion("ejobno not in", values, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoBetween(String value1, String value2) {
            addCriterion("ejobno between", value1, value2, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEjobnoNotBetween(String value1, String value2) {
            addCriterion("ejobno not between", value1, value2, "ejobno");
            return (Criteria) this;
        }

        public Criteria andEpasswordIsNull() {
            addCriterion("epassword is null");
            return (Criteria) this;
        }

        public Criteria andEpasswordIsNotNull() {
            addCriterion("epassword is not null");
            return (Criteria) this;
        }

        public Criteria andEpasswordEqualTo(String value) {
            addCriterion("epassword =", value, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordNotEqualTo(String value) {
            addCriterion("epassword <>", value, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordGreaterThan(String value) {
            addCriterion("epassword >", value, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("epassword >=", value, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordLessThan(String value) {
            addCriterion("epassword <", value, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordLessThanOrEqualTo(String value) {
            addCriterion("epassword <=", value, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordLike(String value) {
            addCriterion("epassword like", value, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordNotLike(String value) {
            addCriterion("epassword not like", value, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordIn(List<String> values) {
            addCriterion("epassword in", values, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordNotIn(List<String> values) {
            addCriterion("epassword not in", values, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordBetween(String value1, String value2) {
            addCriterion("epassword between", value1, value2, "epassword");
            return (Criteria) this;
        }

        public Criteria andEpasswordNotBetween(String value1, String value2) {
            addCriterion("epassword not between", value1, value2, "epassword");
            return (Criteria) this;
        }

        public Criteria andEremark1IsNull() {
            addCriterion("eremark1 is null");
            return (Criteria) this;
        }

        public Criteria andEremark1IsNotNull() {
            addCriterion("eremark1 is not null");
            return (Criteria) this;
        }

        public Criteria andEremark1EqualTo(String value) {
            addCriterion("eremark1 =", value, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1NotEqualTo(String value) {
            addCriterion("eremark1 <>", value, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1GreaterThan(String value) {
            addCriterion("eremark1 >", value, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1GreaterThanOrEqualTo(String value) {
            addCriterion("eremark1 >=", value, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1LessThan(String value) {
            addCriterion("eremark1 <", value, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1LessThanOrEqualTo(String value) {
            addCriterion("eremark1 <=", value, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1Like(String value) {
            addCriterion("eremark1 like", value, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1NotLike(String value) {
            addCriterion("eremark1 not like", value, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1In(List<String> values) {
            addCriterion("eremark1 in", values, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1NotIn(List<String> values) {
            addCriterion("eremark1 not in", values, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1Between(String value1, String value2) {
            addCriterion("eremark1 between", value1, value2, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark1NotBetween(String value1, String value2) {
            addCriterion("eremark1 not between", value1, value2, "eremark1");
            return (Criteria) this;
        }

        public Criteria andEremark2IsNull() {
            addCriterion("eremark2 is null");
            return (Criteria) this;
        }

        public Criteria andEremark2IsNotNull() {
            addCriterion("eremark2 is not null");
            return (Criteria) this;
        }

        public Criteria andEremark2EqualTo(String value) {
            addCriterion("eremark2 =", value, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2NotEqualTo(String value) {
            addCriterion("eremark2 <>", value, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2GreaterThan(String value) {
            addCriterion("eremark2 >", value, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2GreaterThanOrEqualTo(String value) {
            addCriterion("eremark2 >=", value, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2LessThan(String value) {
            addCriterion("eremark2 <", value, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2LessThanOrEqualTo(String value) {
            addCriterion("eremark2 <=", value, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2Like(String value) {
            addCriterion("eremark2 like", value, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2NotLike(String value) {
            addCriterion("eremark2 not like", value, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2In(List<String> values) {
            addCriterion("eremark2 in", values, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2NotIn(List<String> values) {
            addCriterion("eremark2 not in", values, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2Between(String value1, String value2) {
            addCriterion("eremark2 between", value1, value2, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark2NotBetween(String value1, String value2) {
            addCriterion("eremark2 not between", value1, value2, "eremark2");
            return (Criteria) this;
        }

        public Criteria andEremark3IsNull() {
            addCriterion("eremark3 is null");
            return (Criteria) this;
        }

        public Criteria andEremark3IsNotNull() {
            addCriterion("eremark3 is not null");
            return (Criteria) this;
        }

        public Criteria andEremark3EqualTo(String value) {
            addCriterion("eremark3 =", value, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3NotEqualTo(String value) {
            addCriterion("eremark3 <>", value, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3GreaterThan(String value) {
            addCriterion("eremark3 >", value, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3GreaterThanOrEqualTo(String value) {
            addCriterion("eremark3 >=", value, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3LessThan(String value) {
            addCriterion("eremark3 <", value, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3LessThanOrEqualTo(String value) {
            addCriterion("eremark3 <=", value, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3Like(String value) {
            addCriterion("eremark3 like", value, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3NotLike(String value) {
            addCriterion("eremark3 not like", value, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3In(List<String> values) {
            addCriterion("eremark3 in", values, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3NotIn(List<String> values) {
            addCriterion("eremark3 not in", values, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3Between(String value1, String value2) {
            addCriterion("eremark3 between", value1, value2, "eremark3");
            return (Criteria) this;
        }

        public Criteria andEremark3NotBetween(String value1, String value2) {
            addCriterion("eremark3 not between", value1, value2, "eremark3");
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
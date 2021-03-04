package com.danny.bean;

import java.util.ArrayList;
import java.util.List;

public class EfunctionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EfunctionExample() {
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

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFcodeIsNull() {
            addCriterion("fcode is null");
            return (Criteria) this;
        }

        public Criteria andFcodeIsNotNull() {
            addCriterion("fcode is not null");
            return (Criteria) this;
        }

        public Criteria andFcodeEqualTo(String value) {
            addCriterion("fcode =", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotEqualTo(String value) {
            addCriterion("fcode <>", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeGreaterThan(String value) {
            addCriterion("fcode >", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeGreaterThanOrEqualTo(String value) {
            addCriterion("fcode >=", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLessThan(String value) {
            addCriterion("fcode <", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLessThanOrEqualTo(String value) {
            addCriterion("fcode <=", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLike(String value) {
            addCriterion("fcode like", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotLike(String value) {
            addCriterion("fcode not like", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeIn(List<String> values) {
            addCriterion("fcode in", values, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotIn(List<String> values) {
            addCriterion("fcode not in", values, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeBetween(String value1, String value2) {
            addCriterion("fcode between", value1, value2, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotBetween(String value1, String value2) {
            addCriterion("fcode not between", value1, value2, "fcode");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("fname is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("fname is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("fname =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("fname <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("fname >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fname >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("fname <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("fname <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("fname like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("fname not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("fname in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("fname not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("fname between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("fname not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFurlIsNull() {
            addCriterion("furl is null");
            return (Criteria) this;
        }

        public Criteria andFurlIsNotNull() {
            addCriterion("furl is not null");
            return (Criteria) this;
        }

        public Criteria andFurlEqualTo(String value) {
            addCriterion("furl =", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotEqualTo(String value) {
            addCriterion("furl <>", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlGreaterThan(String value) {
            addCriterion("furl >", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlGreaterThanOrEqualTo(String value) {
            addCriterion("furl >=", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLessThan(String value) {
            addCriterion("furl <", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLessThanOrEqualTo(String value) {
            addCriterion("furl <=", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLike(String value) {
            addCriterion("furl like", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotLike(String value) {
            addCriterion("furl not like", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlIn(List<String> values) {
            addCriterion("furl in", values, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotIn(List<String> values) {
            addCriterion("furl not in", values, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlBetween(String value1, String value2) {
            addCriterion("furl between", value1, value2, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotBetween(String value1, String value2) {
            addCriterion("furl not between", value1, value2, "furl");
            return (Criteria) this;
        }

        public Criteria andFlevelIsNull() {
            addCriterion("flevel is null");
            return (Criteria) this;
        }

        public Criteria andFlevelIsNotNull() {
            addCriterion("flevel is not null");
            return (Criteria) this;
        }

        public Criteria andFlevelEqualTo(String value) {
            addCriterion("flevel =", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotEqualTo(String value) {
            addCriterion("flevel <>", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelGreaterThan(String value) {
            addCriterion("flevel >", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelGreaterThanOrEqualTo(String value) {
            addCriterion("flevel >=", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLessThan(String value) {
            addCriterion("flevel <", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLessThanOrEqualTo(String value) {
            addCriterion("flevel <=", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLike(String value) {
            addCriterion("flevel like", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotLike(String value) {
            addCriterion("flevel not like", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelIn(List<String> values) {
            addCriterion("flevel in", values, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotIn(List<String> values) {
            addCriterion("flevel not in", values, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelBetween(String value1, String value2) {
            addCriterion("flevel between", value1, value2, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotBetween(String value1, String value2) {
            addCriterion("flevel not between", value1, value2, "flevel");
            return (Criteria) this;
        }

        public Criteria andFparentidIsNull() {
            addCriterion("fparentid is null");
            return (Criteria) this;
        }

        public Criteria andFparentidIsNotNull() {
            addCriterion("fparentid is not null");
            return (Criteria) this;
        }

        public Criteria andFparentidEqualTo(Integer value) {
            addCriterion("fparentid =", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidNotEqualTo(Integer value) {
            addCriterion("fparentid <>", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidGreaterThan(Integer value) {
            addCriterion("fparentid >", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fparentid >=", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidLessThan(Integer value) {
            addCriterion("fparentid <", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidLessThanOrEqualTo(Integer value) {
            addCriterion("fparentid <=", value, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidIn(List<Integer> values) {
            addCriterion("fparentid in", values, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidNotIn(List<Integer> values) {
            addCriterion("fparentid not in", values, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidBetween(Integer value1, Integer value2) {
            addCriterion("fparentid between", value1, value2, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFparentidNotBetween(Integer value1, Integer value2) {
            addCriterion("fparentid not between", value1, value2, "fparentid");
            return (Criteria) this;
        }

        public Criteria andFremark1IsNull() {
            addCriterion("fremark1 is null");
            return (Criteria) this;
        }

        public Criteria andFremark1IsNotNull() {
            addCriterion("fremark1 is not null");
            return (Criteria) this;
        }

        public Criteria andFremark1EqualTo(String value) {
            addCriterion("fremark1 =", value, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1NotEqualTo(String value) {
            addCriterion("fremark1 <>", value, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1GreaterThan(String value) {
            addCriterion("fremark1 >", value, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1GreaterThanOrEqualTo(String value) {
            addCriterion("fremark1 >=", value, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1LessThan(String value) {
            addCriterion("fremark1 <", value, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1LessThanOrEqualTo(String value) {
            addCriterion("fremark1 <=", value, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1Like(String value) {
            addCriterion("fremark1 like", value, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1NotLike(String value) {
            addCriterion("fremark1 not like", value, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1In(List<String> values) {
            addCriterion("fremark1 in", values, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1NotIn(List<String> values) {
            addCriterion("fremark1 not in", values, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1Between(String value1, String value2) {
            addCriterion("fremark1 between", value1, value2, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark1NotBetween(String value1, String value2) {
            addCriterion("fremark1 not between", value1, value2, "fremark1");
            return (Criteria) this;
        }

        public Criteria andFremark2IsNull() {
            addCriterion("fremark2 is null");
            return (Criteria) this;
        }

        public Criteria andFremark2IsNotNull() {
            addCriterion("fremark2 is not null");
            return (Criteria) this;
        }

        public Criteria andFremark2EqualTo(String value) {
            addCriterion("fremark2 =", value, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2NotEqualTo(String value) {
            addCriterion("fremark2 <>", value, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2GreaterThan(String value) {
            addCriterion("fremark2 >", value, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2GreaterThanOrEqualTo(String value) {
            addCriterion("fremark2 >=", value, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2LessThan(String value) {
            addCriterion("fremark2 <", value, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2LessThanOrEqualTo(String value) {
            addCriterion("fremark2 <=", value, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2Like(String value) {
            addCriterion("fremark2 like", value, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2NotLike(String value) {
            addCriterion("fremark2 not like", value, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2In(List<String> values) {
            addCriterion("fremark2 in", values, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2NotIn(List<String> values) {
            addCriterion("fremark2 not in", values, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2Between(String value1, String value2) {
            addCriterion("fremark2 between", value1, value2, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark2NotBetween(String value1, String value2) {
            addCriterion("fremark2 not between", value1, value2, "fremark2");
            return (Criteria) this;
        }

        public Criteria andFremark3IsNull() {
            addCriterion("fremark3 is null");
            return (Criteria) this;
        }

        public Criteria andFremark3IsNotNull() {
            addCriterion("fremark3 is not null");
            return (Criteria) this;
        }

        public Criteria andFremark3EqualTo(String value) {
            addCriterion("fremark3 =", value, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3NotEqualTo(String value) {
            addCriterion("fremark3 <>", value, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3GreaterThan(String value) {
            addCriterion("fremark3 >", value, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3GreaterThanOrEqualTo(String value) {
            addCriterion("fremark3 >=", value, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3LessThan(String value) {
            addCriterion("fremark3 <", value, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3LessThanOrEqualTo(String value) {
            addCriterion("fremark3 <=", value, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3Like(String value) {
            addCriterion("fremark3 like", value, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3NotLike(String value) {
            addCriterion("fremark3 not like", value, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3In(List<String> values) {
            addCriterion("fremark3 in", values, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3NotIn(List<String> values) {
            addCriterion("fremark3 not in", values, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3Between(String value1, String value2) {
            addCriterion("fremark3 between", value1, value2, "fremark3");
            return (Criteria) this;
        }

        public Criteria andFremark3NotBetween(String value1, String value2) {
            addCriterion("fremark3 not between", value1, value2, "fremark3");
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
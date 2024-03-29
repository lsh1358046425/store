package com.lucien.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FocusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FocusExample() {
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

        public Criteria andFocusIdIsNull() {
            addCriterion("focus_id is null");
            return (Criteria) this;
        }

        public Criteria andFocusIdIsNotNull() {
            addCriterion("focus_id is not null");
            return (Criteria) this;
        }

        public Criteria andFocusIdEqualTo(Integer value) {
            addCriterion("focus_id =", value, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdNotEqualTo(Integer value) {
            addCriterion("focus_id <>", value, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdGreaterThan(Integer value) {
            addCriterion("focus_id >", value, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("focus_id >=", value, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdLessThan(Integer value) {
            addCriterion("focus_id <", value, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdLessThanOrEqualTo(Integer value) {
            addCriterion("focus_id <=", value, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdIn(List<Integer> values) {
            addCriterion("focus_id in", values, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdNotIn(List<Integer> values) {
            addCriterion("focus_id not in", values, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdBetween(Integer value1, Integer value2) {
            addCriterion("focus_id between", value1, value2, "focusId");
            return (Criteria) this;
        }

        public Criteria andFocusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("focus_id not between", value1, value2, "focusId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNull() {
            addCriterion("good_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("good_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(Integer value) {
            addCriterion("good_id =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(Integer value) {
            addCriterion("good_id <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(Integer value) {
            addCriterion("good_id >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_id >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(Integer value) {
            addCriterion("good_id <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("good_id <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<Integer> values) {
            addCriterion("good_id in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<Integer> values) {
            addCriterion("good_id not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(Integer value1, Integer value2) {
            addCriterion("good_id between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("good_id not between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIsNull() {
            addCriterion("focus_time is null");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIsNotNull() {
            addCriterion("focus_time is not null");
            return (Criteria) this;
        }

        public Criteria andFocusTimeEqualTo(Date value) {
            addCriterion("focus_time =", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotEqualTo(Date value) {
            addCriterion("focus_time <>", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeGreaterThan(Date value) {
            addCriterion("focus_time >", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("focus_time >=", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeLessThan(Date value) {
            addCriterion("focus_time <", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeLessThanOrEqualTo(Date value) {
            addCriterion("focus_time <=", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIn(List<Date> values) {
            addCriterion("focus_time in", values, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotIn(List<Date> values) {
            addCriterion("focus_time not in", values, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeBetween(Date value1, Date value2) {
            addCriterion("focus_time between", value1, value2, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotBetween(Date value1, Date value2) {
            addCriterion("focus_time not between", value1, value2, "focusTime");
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
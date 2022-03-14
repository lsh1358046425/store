package com.lucien.model.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailExample() {
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

        public Criteria andOrderdetailIdIsNull() {
            addCriterion("orderDetail_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdIsNotNull() {
            addCriterion("orderDetail_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdEqualTo(Integer value) {
            addCriterion("orderDetail_id =", value, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdNotEqualTo(Integer value) {
            addCriterion("orderDetail_id <>", value, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdGreaterThan(Integer value) {
            addCriterion("orderDetail_id >", value, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderDetail_id >=", value, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdLessThan(Integer value) {
            addCriterion("orderDetail_id <", value, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("orderDetail_id <=", value, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdIn(List<Integer> values) {
            addCriterion("orderDetail_id in", values, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdNotIn(List<Integer> values) {
            addCriterion("orderDetail_id not in", values, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdBetween(Integer value1, Integer value2) {
            addCriterion("orderDetail_id between", value1, value2, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderdetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("orderDetail_id not between", value1, value2, "orderdetailId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andOrderdetailNumIsNull() {
            addCriterion("orderDetail_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumIsNotNull() {
            addCriterion("orderDetail_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumEqualTo(Integer value) {
            addCriterion("orderDetail_num =", value, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumNotEqualTo(Integer value) {
            addCriterion("orderDetail_num <>", value, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumGreaterThan(Integer value) {
            addCriterion("orderDetail_num >", value, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderDetail_num >=", value, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumLessThan(Integer value) {
            addCriterion("orderDetail_num <", value, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumLessThanOrEqualTo(Integer value) {
            addCriterion("orderDetail_num <=", value, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumIn(List<Integer> values) {
            addCriterion("orderDetail_num in", values, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumNotIn(List<Integer> values) {
            addCriterion("orderDetail_num not in", values, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumBetween(Integer value1, Integer value2) {
            addCriterion("orderDetail_num between", value1, value2, "orderdetailNum");
            return (Criteria) this;
        }

        public Criteria andOrderdetailNumNotBetween(Integer value1, Integer value2) {
            addCriterion("orderDetail_num not between", value1, value2, "orderdetailNum");
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
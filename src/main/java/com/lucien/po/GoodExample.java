package com.lucien.po;

import java.util.ArrayList;
import java.util.List;

public class GoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected Integer limit;

    protected List<Criteria> oredCriteria;

    public GoodExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOredCriteria(List<Criteria> oredCriteria) {
        this.oredCriteria = oredCriteria;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
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

        public Criteria andGoodNameIsNull() {
            addCriterion("good_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNotNull() {
            addCriterion("good_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNameEqualTo(String value) {
            addCriterion("good_name =", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotEqualTo(String value) {
            addCriterion("good_name <>", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThan(String value) {
            addCriterion("good_name >", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("good_name >=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThan(String value) {
            addCriterion("good_name <", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThanOrEqualTo(String value) {
            addCriterion("good_name <=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLike(String value) {
            addCriterion("good_name like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotLike(String value) {
            addCriterion("good_name not like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameIn(List<String> values) {
            addCriterion("good_name in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotIn(List<String> values) {
            addCriterion("good_name not in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameBetween(String value1, String value2) {
            addCriterion("good_name between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotBetween(String value1, String value2) {
            addCriterion("good_name not between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNull() {
            addCriterion("good_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNotNull() {
            addCriterion("good_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceEqualTo(Double value) {
            addCriterion("good_price =", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotEqualTo(Double value) {
            addCriterion("good_price <>", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThan(Double value) {
            addCriterion("good_price >", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("good_price >=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThan(Double value) {
            addCriterion("good_price <", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThanOrEqualTo(Double value) {
            addCriterion("good_price <=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIn(List<Double> values) {
            addCriterion("good_price in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotIn(List<Double> values) {
            addCriterion("good_price not in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceBetween(Double value1, Double value2) {
            addCriterion("good_price between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotBetween(Double value1, Double value2) {
            addCriterion("good_price not between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPictureIsNull() {
            addCriterion("good_picture is null");
            return (Criteria) this;
        }

        public Criteria andGoodPictureIsNotNull() {
            addCriterion("good_picture is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPictureEqualTo(String value) {
            addCriterion("good_picture =", value, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureNotEqualTo(String value) {
            addCriterion("good_picture <>", value, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureGreaterThan(String value) {
            addCriterion("good_picture >", value, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureGreaterThanOrEqualTo(String value) {
            addCriterion("good_picture >=", value, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureLessThan(String value) {
            addCriterion("good_picture <", value, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureLessThanOrEqualTo(String value) {
            addCriterion("good_picture <=", value, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureLike(String value) {
            addCriterion("good_picture like", value, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureNotLike(String value) {
            addCriterion("good_picture not like", value, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureIn(List<String> values) {
            addCriterion("good_picture in", values, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureNotIn(List<String> values) {
            addCriterion("good_picture not in", values, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureBetween(String value1, String value2) {
            addCriterion("good_picture between", value1, value2, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andGoodPictureNotBetween(String value1, String value2) {
            addCriterion("good_picture not between", value1, value2, "goodPicture");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
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
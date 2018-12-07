package com.managementSystem.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop_PriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Shop_PriceExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("SHOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("SHOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addCriterion("SHOP_ID =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addCriterion("SHOP_ID <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addCriterion("SHOP_ID >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ID >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addCriterion("SHOP_ID <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ID <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLike(String value) {
            addCriterion("SHOP_ID like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotLike(String value) {
            addCriterion("SHOP_ID not like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addCriterion("SHOP_ID in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addCriterion("SHOP_ID not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addCriterion("SHOP_ID between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addCriterion("SHOP_ID not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceIsNull() {
            addCriterion("SINGLE_PAGE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceIsNotNull() {
            addCriterion("SINGLE_PAGE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceEqualTo(BigDecimal value) {
            addCriterion("SINGLE_PAGE_PRICE =", value, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceNotEqualTo(BigDecimal value) {
            addCriterion("SINGLE_PAGE_PRICE <>", value, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceGreaterThan(BigDecimal value) {
            addCriterion("SINGLE_PAGE_PRICE >", value, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SINGLE_PAGE_PRICE >=", value, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceLessThan(BigDecimal value) {
            addCriterion("SINGLE_PAGE_PRICE <", value, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SINGLE_PAGE_PRICE <=", value, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceIn(List<BigDecimal> values) {
            addCriterion("SINGLE_PAGE_PRICE in", values, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceNotIn(List<BigDecimal> values) {
            addCriterion("SINGLE_PAGE_PRICE not in", values, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINGLE_PAGE_PRICE between", value1, value2, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andSinglePagePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINGLE_PAGE_PRICE not between", value1, value2, "singlePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceIsNull() {
            addCriterion("DOUBLE_PAGE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceIsNotNull() {
            addCriterion("DOUBLE_PAGE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceEqualTo(BigDecimal value) {
            addCriterion("DOUBLE_PAGE_PRICE =", value, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceNotEqualTo(BigDecimal value) {
            addCriterion("DOUBLE_PAGE_PRICE <>", value, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceGreaterThan(BigDecimal value) {
            addCriterion("DOUBLE_PAGE_PRICE >", value, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DOUBLE_PAGE_PRICE >=", value, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceLessThan(BigDecimal value) {
            addCriterion("DOUBLE_PAGE_PRICE <", value, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DOUBLE_PAGE_PRICE <=", value, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceIn(List<BigDecimal> values) {
            addCriterion("DOUBLE_PAGE_PRICE in", values, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceNotIn(List<BigDecimal> values) {
            addCriterion("DOUBLE_PAGE_PRICE not in", values, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DOUBLE_PAGE_PRICE between", value1, value2, "doublePagePrice");
            return (Criteria) this;
        }

        public Criteria andDoublePagePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DOUBLE_PAGE_PRICE not between", value1, value2, "doublePagePrice");
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
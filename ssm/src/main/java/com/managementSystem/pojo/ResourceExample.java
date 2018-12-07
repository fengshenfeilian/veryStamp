package com.managementSystem.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
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

        public Criteria andResIdIsNull() {
            addCriterion("RES_ID is null");
            return (Criteria) this;
        }

        public Criteria andResIdIsNotNull() {
            addCriterion("RES_ID is not null");
            return (Criteria) this;
        }

        public Criteria andResIdEqualTo(String value) {
            addCriterion("RES_ID =", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotEqualTo(String value) {
            addCriterion("RES_ID <>", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThan(String value) {
            addCriterion("RES_ID >", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdGreaterThanOrEqualTo(String value) {
            addCriterion("RES_ID >=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThan(String value) {
            addCriterion("RES_ID <", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLessThanOrEqualTo(String value) {
            addCriterion("RES_ID <=", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdLike(String value) {
            addCriterion("RES_ID like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotLike(String value) {
            addCriterion("RES_ID not like", value, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdIn(List<String> values) {
            addCriterion("RES_ID in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotIn(List<String> values) {
            addCriterion("RES_ID not in", values, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdBetween(String value1, String value2) {
            addCriterion("RES_ID between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResIdNotBetween(String value1, String value2) {
            addCriterion("RES_ID not between", value1, value2, "resId");
            return (Criteria) this;
        }

        public Criteria andResNameIsNull() {
            addCriterion("RES_NAME is null");
            return (Criteria) this;
        }

        public Criteria andResNameIsNotNull() {
            addCriterion("RES_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andResNameEqualTo(String value) {
            addCriterion("RES_NAME =", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotEqualTo(String value) {
            addCriterion("RES_NAME <>", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThan(String value) {
            addCriterion("RES_NAME >", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThanOrEqualTo(String value) {
            addCriterion("RES_NAME >=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThan(String value) {
            addCriterion("RES_NAME <", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThanOrEqualTo(String value) {
            addCriterion("RES_NAME <=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLike(String value) {
            addCriterion("RES_NAME like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotLike(String value) {
            addCriterion("RES_NAME not like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameIn(List<String> values) {
            addCriterion("RES_NAME in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotIn(List<String> values) {
            addCriterion("RES_NAME not in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameBetween(String value1, String value2) {
            addCriterion("RES_NAME between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotBetween(String value1, String value2) {
            addCriterion("RES_NAME not between", value1, value2, "resName");
            return (Criteria) this;
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

        public Criteria andPageCountIsNull() {
            addCriterion("PAGE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPageCountIsNotNull() {
            addCriterion("PAGE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPageCountEqualTo(Integer value) {
            addCriterion("PAGE_COUNT =", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountNotEqualTo(Integer value) {
            addCriterion("PAGE_COUNT <>", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountGreaterThan(Integer value) {
            addCriterion("PAGE_COUNT >", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAGE_COUNT >=", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountLessThan(Integer value) {
            addCriterion("PAGE_COUNT <", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountLessThanOrEqualTo(Integer value) {
            addCriterion("PAGE_COUNT <=", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountIn(List<Integer> values) {
            addCriterion("PAGE_COUNT in", values, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountNotIn(List<Integer> values) {
            addCriterion("PAGE_COUNT not in", values, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_COUNT between", value1, value2, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_COUNT not between", value1, value2, "pageCount");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("TOTAL_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("TOTAL_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRICE =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRICE <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_PRICE >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRICE >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("TOTAL_PRICE <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_PRICE <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("TOTAL_PRICE in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_PRICE not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_PRICE between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_PRICE not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNull() {
            addCriterion("RES_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNotNull() {
            addCriterion("RES_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeEqualTo(String value) {
            addCriterion("RES_TYPE =", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotEqualTo(String value) {
            addCriterion("RES_TYPE <>", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThan(String value) {
            addCriterion("RES_TYPE >", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RES_TYPE >=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThan(String value) {
            addCriterion("RES_TYPE <", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThanOrEqualTo(String value) {
            addCriterion("RES_TYPE <=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLike(String value) {
            addCriterion("RES_TYPE like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotLike(String value) {
            addCriterion("RES_TYPE not like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeIn(List<String> values) {
            addCriterion("RES_TYPE in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotIn(List<String> values) {
            addCriterion("RES_TYPE not in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeBetween(String value1, String value2) {
            addCriterion("RES_TYPE between", value1, value2, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotBetween(String value1, String value2) {
            addCriterion("RES_TYPE not between", value1, value2, "resType");
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
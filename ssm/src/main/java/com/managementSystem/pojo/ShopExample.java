package com.managementSystem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeIsNull() {
            addCriterion("BUSINESS_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeIsNotNull() {
            addCriterion("BUSINESS_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeEqualTo(String value) {
            addCriterion("BUSINESS_START_TIME =", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeNotEqualTo(String value) {
            addCriterion("BUSINESS_START_TIME <>", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeGreaterThan(String value) {
            addCriterion("BUSINESS_START_TIME >", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_START_TIME >=", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeLessThan(String value) {
            addCriterion("BUSINESS_START_TIME <", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_START_TIME <=", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeLike(String value) {
            addCriterion("BUSINESS_START_TIME like", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeNotLike(String value) {
            addCriterion("BUSINESS_START_TIME not like", value, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeIn(List<String> values) {
            addCriterion("BUSINESS_START_TIME in", values, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeNotIn(List<String> values) {
            addCriterion("BUSINESS_START_TIME not in", values, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeBetween(String value1, String value2) {
            addCriterion("BUSINESS_START_TIME between", value1, value2, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessStartTimeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_START_TIME not between", value1, value2, "businessStartTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeIsNull() {
            addCriterion("BUSINESS_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeIsNotNull() {
            addCriterion("BUSINESS_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeEqualTo(String value) {
            addCriterion("BUSINESS_END_TIME =", value, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeNotEqualTo(String value) {
            addCriterion("BUSINESS_END_TIME <>", value, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeGreaterThan(String value) {
            addCriterion("BUSINESS_END_TIME >", value, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_END_TIME >=", value, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeLessThan(String value) {
            addCriterion("BUSINESS_END_TIME <", value, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_END_TIME <=", value, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeLike(String value) {
            addCriterion("BUSINESS_END_TIME like", value, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeNotLike(String value) {
            addCriterion("BUSINESS_END_TIME not like", value, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeIn(List<String> values) {
            addCriterion("BUSINESS_END_TIME in", values, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeNotIn(List<String> values) {
            addCriterion("BUSINESS_END_TIME not in", values, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeBetween(String value1, String value2) {
            addCriterion("BUSINESS_END_TIME between", value1, value2, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andBusinessEndTimeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_END_TIME not between", value1, value2, "businessEndTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeIsNull() {
            addCriterion("SIGNUP_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSignupTimeIsNotNull() {
            addCriterion("SIGNUP_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSignupTimeEqualTo(Date value) {
            addCriterion("SIGNUP_TIME =", value, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeNotEqualTo(Date value) {
            addCriterion("SIGNUP_TIME <>", value, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeGreaterThan(Date value) {
            addCriterion("SIGNUP_TIME >", value, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SIGNUP_TIME >=", value, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeLessThan(Date value) {
            addCriterion("SIGNUP_TIME <", value, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeLessThanOrEqualTo(Date value) {
            addCriterion("SIGNUP_TIME <=", value, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeIn(List<Date> values) {
            addCriterion("SIGNUP_TIME in", values, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeNotIn(List<Date> values) {
            addCriterion("SIGNUP_TIME not in", values, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeBetween(Date value1, Date value2) {
            addCriterion("SIGNUP_TIME between", value1, value2, "signupTime");
            return (Criteria) this;
        }

        public Criteria andSignupTimeNotBetween(Date value1, Date value2) {
            addCriterion("SIGNUP_TIME not between", value1, value2, "signupTime");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
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
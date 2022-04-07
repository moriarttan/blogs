package com.example.blogs.domain;

import java.util.ArrayList;
import java.util.List;

public class ConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConfigExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andBackAddressIsNull() {
            addCriterion("back_address is null");
            return (Criteria) this;
        }

        public Criteria andBackAddressIsNotNull() {
            addCriterion("back_address is not null");
            return (Criteria) this;
        }

        public Criteria andBackAddressEqualTo(String value) {
            addCriterion("back_address =", value, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressNotEqualTo(String value) {
            addCriterion("back_address <>", value, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressGreaterThan(String value) {
            addCriterion("back_address >", value, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressGreaterThanOrEqualTo(String value) {
            addCriterion("back_address >=", value, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressLessThan(String value) {
            addCriterion("back_address <", value, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressLessThanOrEqualTo(String value) {
            addCriterion("back_address <=", value, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressLike(String value) {
            addCriterion("back_address like", value, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressNotLike(String value) {
            addCriterion("back_address not like", value, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressIn(List<String> values) {
            addCriterion("back_address in", values, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressNotIn(List<String> values) {
            addCriterion("back_address not in", values, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressBetween(String value1, String value2) {
            addCriterion("back_address between", value1, value2, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackAddressNotBetween(String value1, String value2) {
            addCriterion("back_address not between", value1, value2, "backAddress");
            return (Criteria) this;
        }

        public Criteria andBackNameIsNull() {
            addCriterion("back_name is null");
            return (Criteria) this;
        }

        public Criteria andBackNameIsNotNull() {
            addCriterion("back_name is not null");
            return (Criteria) this;
        }

        public Criteria andBackNameEqualTo(String value) {
            addCriterion("back_name =", value, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameNotEqualTo(String value) {
            addCriterion("back_name <>", value, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameGreaterThan(String value) {
            addCriterion("back_name >", value, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameGreaterThanOrEqualTo(String value) {
            addCriterion("back_name >=", value, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameLessThan(String value) {
            addCriterion("back_name <", value, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameLessThanOrEqualTo(String value) {
            addCriterion("back_name <=", value, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameLike(String value) {
            addCriterion("back_name like", value, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameNotLike(String value) {
            addCriterion("back_name not like", value, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameIn(List<String> values) {
            addCriterion("back_name in", values, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameNotIn(List<String> values) {
            addCriterion("back_name not in", values, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameBetween(String value1, String value2) {
            addCriterion("back_name between", value1, value2, "backName");
            return (Criteria) this;
        }

        public Criteria andBackNameNotBetween(String value1, String value2) {
            addCriterion("back_name not between", value1, value2, "backName");
            return (Criteria) this;
        }

        public Criteria andBackPhoneIsNull() {
            addCriterion("back_phone is null");
            return (Criteria) this;
        }

        public Criteria andBackPhoneIsNotNull() {
            addCriterion("back_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBackPhoneEqualTo(String value) {
            addCriterion("back_phone =", value, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneNotEqualTo(String value) {
            addCriterion("back_phone <>", value, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneGreaterThan(String value) {
            addCriterion("back_phone >", value, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("back_phone >=", value, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneLessThan(String value) {
            addCriterion("back_phone <", value, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneLessThanOrEqualTo(String value) {
            addCriterion("back_phone <=", value, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneLike(String value) {
            addCriterion("back_phone like", value, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneNotLike(String value) {
            addCriterion("back_phone not like", value, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneIn(List<String> values) {
            addCriterion("back_phone in", values, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneNotIn(List<String> values) {
            addCriterion("back_phone not in", values, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneBetween(String value1, String value2) {
            addCriterion("back_phone between", value1, value2, "backPhone");
            return (Criteria) this;
        }

        public Criteria andBackPhoneNotBetween(String value1, String value2) {
            addCriterion("back_phone not between", value1, value2, "backPhone");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionIsNull() {
            addCriterion("integrate_proportion is null");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionIsNotNull() {
            addCriterion("integrate_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionEqualTo(Integer value) {
            addCriterion("integrate_proportion =", value, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionNotEqualTo(Integer value) {
            addCriterion("integrate_proportion <>", value, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionGreaterThan(Integer value) {
            addCriterion("integrate_proportion >", value, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionGreaterThanOrEqualTo(Integer value) {
            addCriterion("integrate_proportion >=", value, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionLessThan(Integer value) {
            addCriterion("integrate_proportion <", value, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionLessThanOrEqualTo(Integer value) {
            addCriterion("integrate_proportion <=", value, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionIn(List<Integer> values) {
            addCriterion("integrate_proportion in", values, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionNotIn(List<Integer> values) {
            addCriterion("integrate_proportion not in", values, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionBetween(Integer value1, Integer value2) {
            addCriterion("integrate_proportion between", value1, value2, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andIntegrateProportionNotBetween(Integer value1, Integer value2) {
            addCriterion("integrate_proportion not between", value1, value2, "integrateProportion");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountIsNull() {
            addCriterion("box_refresh_count is null");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountIsNotNull() {
            addCriterion("box_refresh_count is not null");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountEqualTo(Integer value) {
            addCriterion("box_refresh_count =", value, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountNotEqualTo(Integer value) {
            addCriterion("box_refresh_count <>", value, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountGreaterThan(Integer value) {
            addCriterion("box_refresh_count >", value, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("box_refresh_count >=", value, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountLessThan(Integer value) {
            addCriterion("box_refresh_count <", value, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountLessThanOrEqualTo(Integer value) {
            addCriterion("box_refresh_count <=", value, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountIn(List<Integer> values) {
            addCriterion("box_refresh_count in", values, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountNotIn(List<Integer> values) {
            addCriterion("box_refresh_count not in", values, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountBetween(Integer value1, Integer value2) {
            addCriterion("box_refresh_count between", value1, value2, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshCountNotBetween(Integer value1, Integer value2) {
            addCriterion("box_refresh_count not between", value1, value2, "boxRefreshCount");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumIsNull() {
            addCriterion("box_refresh_num is null");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumIsNotNull() {
            addCriterion("box_refresh_num is not null");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumEqualTo(Integer value) {
            addCriterion("box_refresh_num =", value, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumNotEqualTo(Integer value) {
            addCriterion("box_refresh_num <>", value, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumGreaterThan(Integer value) {
            addCriterion("box_refresh_num >", value, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("box_refresh_num >=", value, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumLessThan(Integer value) {
            addCriterion("box_refresh_num <", value, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumLessThanOrEqualTo(Integer value) {
            addCriterion("box_refresh_num <=", value, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumIn(List<Integer> values) {
            addCriterion("box_refresh_num in", values, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumNotIn(List<Integer> values) {
            addCriterion("box_refresh_num not in", values, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumBetween(Integer value1, Integer value2) {
            addCriterion("box_refresh_num between", value1, value2, "boxRefreshNum");
            return (Criteria) this;
        }

        public Criteria andBoxRefreshNumNotBetween(Integer value1, Integer value2) {
            addCriterion("box_refresh_num not between", value1, value2, "boxRefreshNum");
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
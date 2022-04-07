package com.example.blogs.domain;

import java.util.ArrayList;
import java.util.List;

public class AboutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AboutExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andLikeNumberIsNull() {
            addCriterion("like_number is null");
            return (Criteria) this;
        }

        public Criteria andLikeNumberIsNotNull() {
            addCriterion("like_number is not null");
            return (Criteria) this;
        }

        public Criteria andLikeNumberEqualTo(Integer value) {
            addCriterion("like_number =", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberNotEqualTo(Integer value) {
            addCriterion("like_number <>", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberGreaterThan(Integer value) {
            addCriterion("like_number >", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_number >=", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberLessThan(Integer value) {
            addCriterion("like_number <", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("like_number <=", value, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberIn(List<Integer> values) {
            addCriterion("like_number in", values, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberNotIn(List<Integer> values) {
            addCriterion("like_number not in", values, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberBetween(Integer value1, Integer value2) {
            addCriterion("like_number between", value1, value2, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andLikeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("like_number not between", value1, value2, "likeNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberIsNull() {
            addCriterion("visit_number is null");
            return (Criteria) this;
        }

        public Criteria andVisitNumberIsNotNull() {
            addCriterion("visit_number is not null");
            return (Criteria) this;
        }

        public Criteria andVisitNumberEqualTo(Integer value) {
            addCriterion("visit_number =", value, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberNotEqualTo(Integer value) {
            addCriterion("visit_number <>", value, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberGreaterThan(Integer value) {
            addCriterion("visit_number >", value, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("visit_number >=", value, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberLessThan(Integer value) {
            addCriterion("visit_number <", value, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberLessThanOrEqualTo(Integer value) {
            addCriterion("visit_number <=", value, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberIn(List<Integer> values) {
            addCriterion("visit_number in", values, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberNotIn(List<Integer> values) {
            addCriterion("visit_number not in", values, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberBetween(Integer value1, Integer value2) {
            addCriterion("visit_number between", value1, value2, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andVisitNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("visit_number not between", value1, value2, "visitNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberIsNull() {
            addCriterion("size_number is null");
            return (Criteria) this;
        }

        public Criteria andSizeNumberIsNotNull() {
            addCriterion("size_number is not null");
            return (Criteria) this;
        }

        public Criteria andSizeNumberEqualTo(Integer value) {
            addCriterion("size_number =", value, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberNotEqualTo(Integer value) {
            addCriterion("size_number <>", value, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberGreaterThan(Integer value) {
            addCriterion("size_number >", value, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("size_number >=", value, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberLessThan(Integer value) {
            addCriterion("size_number <", value, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberLessThanOrEqualTo(Integer value) {
            addCriterion("size_number <=", value, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberIn(List<Integer> values) {
            addCriterion("size_number in", values, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberNotIn(List<Integer> values) {
            addCriterion("size_number not in", values, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberBetween(Integer value1, Integer value2) {
            addCriterion("size_number between", value1, value2, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andSizeNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("size_number not between", value1, value2, "sizeNumber");
            return (Criteria) this;
        }

        public Criteria andIsLikeIsNull() {
            addCriterion("is_like is null");
            return (Criteria) this;
        }

        public Criteria andIsLikeIsNotNull() {
            addCriterion("is_like is not null");
            return (Criteria) this;
        }

        public Criteria andIsLikeEqualTo(Boolean value) {
            addCriterion("is_like =", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeNotEqualTo(Boolean value) {
            addCriterion("is_like <>", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeGreaterThan(Boolean value) {
            addCriterion("is_like >", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_like >=", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeLessThan(Boolean value) {
            addCriterion("is_like <", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_like <=", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeIn(List<Boolean> values) {
            addCriterion("is_like in", values, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeNotIn(List<Boolean> values) {
            addCriterion("is_like not in", values, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_like between", value1, value2, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_like not between", value1, value2, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNull() {
            addCriterion("is_comment is null");
            return (Criteria) this;
        }

        public Criteria andIsCommentIsNotNull() {
            addCriterion("is_comment is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommentEqualTo(Boolean value) {
            addCriterion("is_comment =", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotEqualTo(Boolean value) {
            addCriterion("is_comment <>", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThan(Boolean value) {
            addCriterion("is_comment >", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_comment >=", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThan(Boolean value) {
            addCriterion("is_comment <", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentLessThanOrEqualTo(Boolean value) {
            addCriterion("is_comment <=", value, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentIn(List<Boolean> values) {
            addCriterion("is_comment in", values, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotIn(List<Boolean> values) {
            addCriterion("is_comment not in", values, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentBetween(Boolean value1, Boolean value2) {
            addCriterion("is_comment between", value1, value2, "isComment");
            return (Criteria) this;
        }

        public Criteria andIsCommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_comment not between", value1, value2, "isComment");
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
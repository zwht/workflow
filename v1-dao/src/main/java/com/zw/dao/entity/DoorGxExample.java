package com.zw.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class DoorGxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoorGxExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGxIdIsNull() {
            addCriterion("gx_id is null");
            return (Criteria) this;
        }

        public Criteria andGxIdIsNotNull() {
            addCriterion("gx_id is not null");
            return (Criteria) this;
        }

        public Criteria andGxIdEqualTo(Long value) {
            addCriterion("gx_id =", value, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdNotEqualTo(Long value) {
            addCriterion("gx_id <>", value, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdGreaterThan(Long value) {
            addCriterion("gx_id >", value, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gx_id >=", value, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdLessThan(Long value) {
            addCriterion("gx_id <", value, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdLessThanOrEqualTo(Long value) {
            addCriterion("gx_id <=", value, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdIn(List<Long> values) {
            addCriterion("gx_id in", values, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdNotIn(List<Long> values) {
            addCriterion("gx_id not in", values, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdBetween(Long value1, Long value2) {
            addCriterion("gx_id between", value1, value2, "gxId");
            return (Criteria) this;
        }

        public Criteria andGxIdNotBetween(Long value1, Long value2) {
            addCriterion("gx_id not between", value1, value2, "gxId");
            return (Criteria) this;
        }

        public Criteria andDoorIdIsNull() {
            addCriterion("door_id is null");
            return (Criteria) this;
        }

        public Criteria andDoorIdIsNotNull() {
            addCriterion("door_id is not null");
            return (Criteria) this;
        }

        public Criteria andDoorIdEqualTo(Long value) {
            addCriterion("door_id =", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotEqualTo(Long value) {
            addCriterion("door_id <>", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdGreaterThan(Long value) {
            addCriterion("door_id >", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("door_id >=", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLessThan(Long value) {
            addCriterion("door_id <", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLessThanOrEqualTo(Long value) {
            addCriterion("door_id <=", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdIn(List<Long> values) {
            addCriterion("door_id in", values, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotIn(List<Long> values) {
            addCriterion("door_id not in", values, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdBetween(Long value1, Long value2) {
            addCriterion("door_id between", value1, value2, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotBetween(Long value1, Long value2) {
            addCriterion("door_id not between", value1, value2, "doorId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andIndexKeyIsNull() {
            addCriterion("index_key is null");
            return (Criteria) this;
        }

        public Criteria andIndexKeyIsNotNull() {
            addCriterion("index_key is not null");
            return (Criteria) this;
        }

        public Criteria andIndexKeyEqualTo(Short value) {
            addCriterion("index_key =", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyNotEqualTo(Short value) {
            addCriterion("index_key <>", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyGreaterThan(Short value) {
            addCriterion("index_key >", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyGreaterThanOrEqualTo(Short value) {
            addCriterion("index_key >=", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyLessThan(Short value) {
            addCriterion("index_key <", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyLessThanOrEqualTo(Short value) {
            addCriterion("index_key <=", value, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyIn(List<Short> values) {
            addCriterion("index_key in", values, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyNotIn(List<Short> values) {
            addCriterion("index_key not in", values, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyBetween(Short value1, Short value2) {
            addCriterion("index_key between", value1, value2, "indexKey");
            return (Criteria) this;
        }

        public Criteria andIndexKeyNotBetween(Short value1, Short value2) {
            addCriterion("index_key not between", value1, value2, "indexKey");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Short value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Short value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Short value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Short value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Short value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Short> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Short> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Short value1, Short value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Short value1, Short value2) {
            addCriterion("flag not between", value1, value2, "flag");
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
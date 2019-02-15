package com.zw.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andCoverSizeIsNull() {
            addCriterion("cover_size is null");
            return (Criteria) this;
        }

        public Criteria andCoverSizeIsNotNull() {
            addCriterion("cover_size is not null");
            return (Criteria) this;
        }

        public Criteria andCoverSizeEqualTo(String value) {
            addCriterion("cover_size =", value, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeNotEqualTo(String value) {
            addCriterion("cover_size <>", value, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeGreaterThan(String value) {
            addCriterion("cover_size >", value, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeGreaterThanOrEqualTo(String value) {
            addCriterion("cover_size >=", value, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeLessThan(String value) {
            addCriterion("cover_size <", value, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeLessThanOrEqualTo(String value) {
            addCriterion("cover_size <=", value, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeLike(String value) {
            addCriterion("cover_size like", value, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeNotLike(String value) {
            addCriterion("cover_size not like", value, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeIn(List<String> values) {
            addCriterion("cover_size in", values, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeNotIn(List<String> values) {
            addCriterion("cover_size not in", values, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeBetween(String value1, String value2) {
            addCriterion("cover_size between", value1, value2, "coverSize");
            return (Criteria) this;
        }

        public Criteria andCoverSizeNotBetween(String value1, String value2) {
            addCriterion("cover_size not between", value1, value2, "coverSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeIsNull() {
            addCriterion("door_size is null");
            return (Criteria) this;
        }

        public Criteria andDoorSizeIsNotNull() {
            addCriterion("door_size is not null");
            return (Criteria) this;
        }

        public Criteria andDoorSizeEqualTo(String value) {
            addCriterion("door_size =", value, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeNotEqualTo(String value) {
            addCriterion("door_size <>", value, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeGreaterThan(String value) {
            addCriterion("door_size >", value, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeGreaterThanOrEqualTo(String value) {
            addCriterion("door_size >=", value, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeLessThan(String value) {
            addCriterion("door_size <", value, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeLessThanOrEqualTo(String value) {
            addCriterion("door_size <=", value, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeLike(String value) {
            addCriterion("door_size like", value, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeNotLike(String value) {
            addCriterion("door_size not like", value, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeIn(List<String> values) {
            addCriterion("door_size in", values, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeNotIn(List<String> values) {
            addCriterion("door_size not in", values, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeBetween(String value1, String value2) {
            addCriterion("door_size between", value1, value2, "doorSize");
            return (Criteria) this;
        }

        public Criteria andDoorSizeNotBetween(String value1, String value2) {
            addCriterion("door_size not between", value1, value2, "doorSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeIsNull() {
            addCriterion("lb_size is null");
            return (Criteria) this;
        }

        public Criteria andLbSizeIsNotNull() {
            addCriterion("lb_size is not null");
            return (Criteria) this;
        }

        public Criteria andLbSizeEqualTo(String value) {
            addCriterion("lb_size =", value, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeNotEqualTo(String value) {
            addCriterion("lb_size <>", value, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeGreaterThan(String value) {
            addCriterion("lb_size >", value, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeGreaterThanOrEqualTo(String value) {
            addCriterion("lb_size >=", value, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeLessThan(String value) {
            addCriterion("lb_size <", value, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeLessThanOrEqualTo(String value) {
            addCriterion("lb_size <=", value, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeLike(String value) {
            addCriterion("lb_size like", value, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeNotLike(String value) {
            addCriterion("lb_size not like", value, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeIn(List<String> values) {
            addCriterion("lb_size in", values, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeNotIn(List<String> values) {
            addCriterion("lb_size not in", values, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeBetween(String value1, String value2) {
            addCriterion("lb_size between", value1, value2, "lbSize");
            return (Criteria) this;
        }

        public Criteria andLbSizeNotBetween(String value1, String value2) {
            addCriterion("lb_size not between", value1, value2, "lbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeIsNull() {
            addCriterion("db_size is null");
            return (Criteria) this;
        }

        public Criteria andDbSizeIsNotNull() {
            addCriterion("db_size is not null");
            return (Criteria) this;
        }

        public Criteria andDbSizeEqualTo(String value) {
            addCriterion("db_size =", value, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeNotEqualTo(String value) {
            addCriterion("db_size <>", value, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeGreaterThan(String value) {
            addCriterion("db_size >", value, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeGreaterThanOrEqualTo(String value) {
            addCriterion("db_size >=", value, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeLessThan(String value) {
            addCriterion("db_size <", value, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeLessThanOrEqualTo(String value) {
            addCriterion("db_size <=", value, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeLike(String value) {
            addCriterion("db_size like", value, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeNotLike(String value) {
            addCriterion("db_size not like", value, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeIn(List<String> values) {
            addCriterion("db_size in", values, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeNotIn(List<String> values) {
            addCriterion("db_size not in", values, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeBetween(String value1, String value2) {
            addCriterion("db_size between", value1, value2, "dbSize");
            return (Criteria) this;
        }

        public Criteria andDbSizeNotBetween(String value1, String value2) {
            addCriterion("db_size not between", value1, value2, "dbSize");
            return (Criteria) this;
        }

        public Criteria andCorporationIdIsNull() {
            addCriterion("corporation_id is null");
            return (Criteria) this;
        }

        public Criteria andCorporationIdIsNotNull() {
            addCriterion("corporation_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationIdEqualTo(Long value) {
            addCriterion("corporation_id =", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotEqualTo(Long value) {
            addCriterion("corporation_id <>", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdGreaterThan(Long value) {
            addCriterion("corporation_id >", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("corporation_id >=", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdLessThan(Long value) {
            addCriterion("corporation_id <", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdLessThanOrEqualTo(Long value) {
            addCriterion("corporation_id <=", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdIn(List<Long> values) {
            addCriterion("corporation_id in", values, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotIn(List<Long> values) {
            addCriterion("corporation_id not in", values, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdBetween(Long value1, Long value2) {
            addCriterion("corporation_id between", value1, value2, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotBetween(Long value1, Long value2) {
            addCriterion("corporation_id not between", value1, value2, "corporationId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Short value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Short value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Short value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Short value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Short value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Short value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Short> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Short> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Short value1, Short value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Short value1, Short value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSumIsNull() {
            addCriterion("sum is null");
            return (Criteria) this;
        }

        public Criteria andSumIsNotNull() {
            addCriterion("sum is not null");
            return (Criteria) this;
        }

        public Criteria andSumEqualTo(Short value) {
            addCriterion("sum =", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotEqualTo(Short value) {
            addCriterion("sum <>", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThan(Short value) {
            addCriterion("sum >", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThanOrEqualTo(Short value) {
            addCriterion("sum >=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThan(Short value) {
            addCriterion("sum <", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThanOrEqualTo(Short value) {
            addCriterion("sum <=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumIn(List<Short> values) {
            addCriterion("sum in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotIn(List<Short> values) {
            addCriterion("sum not in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumBetween(Short value1, Short value2) {
            addCriterion("sum between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotBetween(Short value1, Short value2) {
            addCriterion("sum not between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNull() {
            addCriterion("ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNotNull() {
            addCriterion("ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketIdEqualTo(Long value) {
            addCriterion("ticket_id =", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotEqualTo(Long value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThan(Long value) {
            addCriterion("ticket_id >", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThan(Long value) {
            addCriterion("ticket_id <", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThanOrEqualTo(Long value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIn(List<Long> values) {
            addCriterion("ticket_id in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotIn(List<Long> values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdBetween(Long value1, Long value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotBetween(Long value1, Long value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andDoorIsNull() {
            addCriterion("door is null");
            return (Criteria) this;
        }

        public Criteria andDoorIsNotNull() {
            addCriterion("door is not null");
            return (Criteria) this;
        }

        public Criteria andDoorEqualTo(String value) {
            addCriterion("door =", value, "door");
            return (Criteria) this;
        }

        public Criteria andDoorNotEqualTo(String value) {
            addCriterion("door <>", value, "door");
            return (Criteria) this;
        }

        public Criteria andDoorGreaterThan(String value) {
            addCriterion("door >", value, "door");
            return (Criteria) this;
        }

        public Criteria andDoorGreaterThanOrEqualTo(String value) {
            addCriterion("door >=", value, "door");
            return (Criteria) this;
        }

        public Criteria andDoorLessThan(String value) {
            addCriterion("door <", value, "door");
            return (Criteria) this;
        }

        public Criteria andDoorLessThanOrEqualTo(String value) {
            addCriterion("door <=", value, "door");
            return (Criteria) this;
        }

        public Criteria andDoorLike(String value) {
            addCriterion("door like", value, "door");
            return (Criteria) this;
        }

        public Criteria andDoorNotLike(String value) {
            addCriterion("door not like", value, "door");
            return (Criteria) this;
        }

        public Criteria andDoorIn(List<String> values) {
            addCriterion("door in", values, "door");
            return (Criteria) this;
        }

        public Criteria andDoorNotIn(List<String> values) {
            addCriterion("door not in", values, "door");
            return (Criteria) this;
        }

        public Criteria andDoorBetween(String value1, String value2) {
            addCriterion("door between", value1, value2, "door");
            return (Criteria) this;
        }

        public Criteria andDoorNotBetween(String value1, String value2) {
            addCriterion("door not between", value1, value2, "door");
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

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNull() {
            addCriterion("color_id is null");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNotNull() {
            addCriterion("color_id is not null");
            return (Criteria) this;
        }

        public Criteria andColorIdEqualTo(Long value) {
            addCriterion("color_id =", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotEqualTo(Long value) {
            addCriterion("color_id <>", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThan(Long value) {
            addCriterion("color_id >", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("color_id >=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThan(Long value) {
            addCriterion("color_id <", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThanOrEqualTo(Long value) {
            addCriterion("color_id <=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdIn(List<Long> values) {
            addCriterion("color_id in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotIn(List<Long> values) {
            addCriterion("color_id not in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdBetween(Long value1, Long value2) {
            addCriterion("color_id between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotBetween(Long value1, Long value2) {
            addCriterion("color_id not between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(Long value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(Long value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(Long value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(Long value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(Long value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<Long> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<Long> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(Long value1, Long value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(Long value1, Long value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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

        public Criteria andLineIsNull() {
            addCriterion("line is null");
            return (Criteria) this;
        }

        public Criteria andLineIsNotNull() {
            addCriterion("line is not null");
            return (Criteria) this;
        }

        public Criteria andLineEqualTo(String value) {
            addCriterion("line =", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotEqualTo(String value) {
            addCriterion("line <>", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThan(String value) {
            addCriterion("line >", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineGreaterThanOrEqualTo(String value) {
            addCriterion("line >=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThan(String value) {
            addCriterion("line <", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLessThanOrEqualTo(String value) {
            addCriterion("line <=", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineLike(String value) {
            addCriterion("line like", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotLike(String value) {
            addCriterion("line not like", value, "line");
            return (Criteria) this;
        }

        public Criteria andLineIn(List<String> values) {
            addCriterion("line in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotIn(List<String> values) {
            addCriterion("line not in", values, "line");
            return (Criteria) this;
        }

        public Criteria andLineBetween(String value1, String value2) {
            addCriterion("line between", value1, value2, "line");
            return (Criteria) this;
        }

        public Criteria andLineNotBetween(String value1, String value2) {
            addCriterion("line not between", value1, value2, "line");
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
package com.zw.dao.entity;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andDoorIdEqualTo(String value) {
            addCriterion("door_id =", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotEqualTo(String value) {
            addCriterion("door_id <>", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdGreaterThan(String value) {
            addCriterion("door_id >", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdGreaterThanOrEqualTo(String value) {
            addCriterion("door_id >=", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLessThan(String value) {
            addCriterion("door_id <", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLessThanOrEqualTo(String value) {
            addCriterion("door_id <=", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdLike(String value) {
            addCriterion("door_id like", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotLike(String value) {
            addCriterion("door_id not like", value, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdIn(List<String> values) {
            addCriterion("door_id in", values, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotIn(List<String> values) {
            addCriterion("door_id not in", values, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdBetween(String value1, String value2) {
            addCriterion("door_id between", value1, value2, "doorId");
            return (Criteria) this;
        }

        public Criteria andDoorIdNotBetween(String value1, String value2) {
            addCriterion("door_id not between", value1, value2, "doorId");
            return (Criteria) this;
        }

        public Criteria andProcessIdsIsNull() {
            addCriterion("process_ids is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdsIsNotNull() {
            addCriterion("process_ids is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdsEqualTo(String value) {
            addCriterion("process_ids =", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsNotEqualTo(String value) {
            addCriterion("process_ids <>", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsGreaterThan(String value) {
            addCriterion("process_ids >", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsGreaterThanOrEqualTo(String value) {
            addCriterion("process_ids >=", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsLessThan(String value) {
            addCriterion("process_ids <", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsLessThanOrEqualTo(String value) {
            addCriterion("process_ids <=", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsLike(String value) {
            addCriterion("process_ids like", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsNotLike(String value) {
            addCriterion("process_ids not like", value, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsIn(List<String> values) {
            addCriterion("process_ids in", values, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsNotIn(List<String> values) {
            addCriterion("process_ids not in", values, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsBetween(String value1, String value2) {
            addCriterion("process_ids between", value1, value2, "processIds");
            return (Criteria) this;
        }

        public Criteria andProcessIdsNotBetween(String value1, String value2) {
            addCriterion("process_ids not between", value1, value2, "processIds");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andCorporationIdEqualTo(String value) {
            addCriterion("corporation_id =", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotEqualTo(String value) {
            addCriterion("corporation_id <>", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdGreaterThan(String value) {
            addCriterion("corporation_id >", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdGreaterThanOrEqualTo(String value) {
            addCriterion("corporation_id >=", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdLessThan(String value) {
            addCriterion("corporation_id <", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdLessThanOrEqualTo(String value) {
            addCriterion("corporation_id <=", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdLike(String value) {
            addCriterion("corporation_id like", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotLike(String value) {
            addCriterion("corporation_id not like", value, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdIn(List<String> values) {
            addCriterion("corporation_id in", values, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotIn(List<String> values) {
            addCriterion("corporation_id not in", values, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdBetween(String value1, String value2) {
            addCriterion("corporation_id between", value1, value2, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCorporationIdNotBetween(String value1, String value2) {
            addCriterion("corporation_id not between", value1, value2, "corporationId");
            return (Criteria) this;
        }

        public Criteria andCoverWidthIsNull() {
            addCriterion("cover_width is null");
            return (Criteria) this;
        }

        public Criteria andCoverWidthIsNotNull() {
            addCriterion("cover_width is not null");
            return (Criteria) this;
        }

        public Criteria andCoverWidthEqualTo(Integer value) {
            addCriterion("cover_width =", value, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthNotEqualTo(Integer value) {
            addCriterion("cover_width <>", value, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthGreaterThan(Integer value) {
            addCriterion("cover_width >", value, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("cover_width >=", value, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthLessThan(Integer value) {
            addCriterion("cover_width <", value, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthLessThanOrEqualTo(Integer value) {
            addCriterion("cover_width <=", value, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthIn(List<Integer> values) {
            addCriterion("cover_width in", values, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthNotIn(List<Integer> values) {
            addCriterion("cover_width not in", values, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthBetween(Integer value1, Integer value2) {
            addCriterion("cover_width between", value1, value2, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("cover_width not between", value1, value2, "coverWidth");
            return (Criteria) this;
        }

        public Criteria andCoverHeightIsNull() {
            addCriterion("cover_height is null");
            return (Criteria) this;
        }

        public Criteria andCoverHeightIsNotNull() {
            addCriterion("cover_height is not null");
            return (Criteria) this;
        }

        public Criteria andCoverHeightEqualTo(Integer value) {
            addCriterion("cover_height =", value, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightNotEqualTo(Integer value) {
            addCriterion("cover_height <>", value, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightGreaterThan(Integer value) {
            addCriterion("cover_height >", value, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("cover_height >=", value, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightLessThan(Integer value) {
            addCriterion("cover_height <", value, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightLessThanOrEqualTo(Integer value) {
            addCriterion("cover_height <=", value, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightIn(List<Integer> values) {
            addCriterion("cover_height in", values, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightNotIn(List<Integer> values) {
            addCriterion("cover_height not in", values, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightBetween(Integer value1, Integer value2) {
            addCriterion("cover_height between", value1, value2, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("cover_height not between", value1, value2, "coverHeight");
            return (Criteria) this;
        }

        public Criteria andCoverDepthIsNull() {
            addCriterion("cover_depth is null");
            return (Criteria) this;
        }

        public Criteria andCoverDepthIsNotNull() {
            addCriterion("cover_depth is not null");
            return (Criteria) this;
        }

        public Criteria andCoverDepthEqualTo(Integer value) {
            addCriterion("cover_depth =", value, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthNotEqualTo(Integer value) {
            addCriterion("cover_depth <>", value, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthGreaterThan(Integer value) {
            addCriterion("cover_depth >", value, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthGreaterThanOrEqualTo(Integer value) {
            addCriterion("cover_depth >=", value, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthLessThan(Integer value) {
            addCriterion("cover_depth <", value, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthLessThanOrEqualTo(Integer value) {
            addCriterion("cover_depth <=", value, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthIn(List<Integer> values) {
            addCriterion("cover_depth in", values, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthNotIn(List<Integer> values) {
            addCriterion("cover_depth not in", values, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthBetween(Integer value1, Integer value2) {
            addCriterion("cover_depth between", value1, value2, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andCoverDepthNotBetween(Integer value1, Integer value2) {
            addCriterion("cover_depth not between", value1, value2, "coverDepth");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Integer value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Integer value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Integer value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Integer value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Integer value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Integer> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Integer> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Integer value1, Integer value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andLbWidthIsNull() {
            addCriterion("lb_width is null");
            return (Criteria) this;
        }

        public Criteria andLbWidthIsNotNull() {
            addCriterion("lb_width is not null");
            return (Criteria) this;
        }

        public Criteria andLbWidthEqualTo(Integer value) {
            addCriterion("lb_width =", value, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthNotEqualTo(Integer value) {
            addCriterion("lb_width <>", value, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthGreaterThan(Integer value) {
            addCriterion("lb_width >", value, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("lb_width >=", value, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthLessThan(Integer value) {
            addCriterion("lb_width <", value, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthLessThanOrEqualTo(Integer value) {
            addCriterion("lb_width <=", value, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthIn(List<Integer> values) {
            addCriterion("lb_width in", values, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthNotIn(List<Integer> values) {
            addCriterion("lb_width not in", values, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthBetween(Integer value1, Integer value2) {
            addCriterion("lb_width between", value1, value2, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("lb_width not between", value1, value2, "lbWidth");
            return (Criteria) this;
        }

        public Criteria andLbHeightIsNull() {
            addCriterion("lb_height is null");
            return (Criteria) this;
        }

        public Criteria andLbHeightIsNotNull() {
            addCriterion("lb_height is not null");
            return (Criteria) this;
        }

        public Criteria andLbHeightEqualTo(Integer value) {
            addCriterion("lb_height =", value, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightNotEqualTo(Integer value) {
            addCriterion("lb_height <>", value, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightGreaterThan(Integer value) {
            addCriterion("lb_height >", value, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("lb_height >=", value, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightLessThan(Integer value) {
            addCriterion("lb_height <", value, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightLessThanOrEqualTo(Integer value) {
            addCriterion("lb_height <=", value, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightIn(List<Integer> values) {
            addCriterion("lb_height in", values, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightNotIn(List<Integer> values) {
            addCriterion("lb_height not in", values, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightBetween(Integer value1, Integer value2) {
            addCriterion("lb_height between", value1, value2, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andLbHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("lb_height not between", value1, value2, "lbHeight");
            return (Criteria) this;
        }

        public Criteria andDbWidthIsNull() {
            addCriterion("db_width is null");
            return (Criteria) this;
        }

        public Criteria andDbWidthIsNotNull() {
            addCriterion("db_width is not null");
            return (Criteria) this;
        }

        public Criteria andDbWidthEqualTo(Integer value) {
            addCriterion("db_width =", value, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthNotEqualTo(Integer value) {
            addCriterion("db_width <>", value, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthGreaterThan(Integer value) {
            addCriterion("db_width >", value, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("db_width >=", value, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthLessThan(Integer value) {
            addCriterion("db_width <", value, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthLessThanOrEqualTo(Integer value) {
            addCriterion("db_width <=", value, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthIn(List<Integer> values) {
            addCriterion("db_width in", values, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthNotIn(List<Integer> values) {
            addCriterion("db_width not in", values, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthBetween(Integer value1, Integer value2) {
            addCriterion("db_width between", value1, value2, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("db_width not between", value1, value2, "dbWidth");
            return (Criteria) this;
        }

        public Criteria andDbHeightIsNull() {
            addCriterion("db_height is null");
            return (Criteria) this;
        }

        public Criteria andDbHeightIsNotNull() {
            addCriterion("db_height is not null");
            return (Criteria) this;
        }

        public Criteria andDbHeightEqualTo(Integer value) {
            addCriterion("db_height =", value, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightNotEqualTo(Integer value) {
            addCriterion("db_height <>", value, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightGreaterThan(Integer value) {
            addCriterion("db_height >", value, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("db_height >=", value, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightLessThan(Integer value) {
            addCriterion("db_height <", value, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightLessThanOrEqualTo(Integer value) {
            addCriterion("db_height <=", value, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightIn(List<Integer> values) {
            addCriterion("db_height in", values, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightNotIn(List<Integer> values) {
            addCriterion("db_height not in", values, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightBetween(Integer value1, Integer value2) {
            addCriterion("db_height between", value1, value2, "dbHeight");
            return (Criteria) this;
        }

        public Criteria andDbHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("db_height not between", value1, value2, "dbHeight");
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

        public Criteria andColorIdEqualTo(String value) {
            addCriterion("color_id =", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotEqualTo(String value) {
            addCriterion("color_id <>", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThan(String value) {
            addCriterion("color_id >", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThanOrEqualTo(String value) {
            addCriterion("color_id >=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThan(String value) {
            addCriterion("color_id <", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThanOrEqualTo(String value) {
            addCriterion("color_id <=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLike(String value) {
            addCriterion("color_id like", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotLike(String value) {
            addCriterion("color_id not like", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdIn(List<String> values) {
            addCriterion("color_id in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotIn(List<String> values) {
            addCriterion("color_id not in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdBetween(String value1, String value2) {
            addCriterion("color_id between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotBetween(String value1, String value2) {
            addCriterion("color_id not between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNull() {
            addCriterion("line_id is null");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNotNull() {
            addCriterion("line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLineIdEqualTo(String value) {
            addCriterion("line_id =", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotEqualTo(String value) {
            addCriterion("line_id <>", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThan(String value) {
            addCriterion("line_id >", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThanOrEqualTo(String value) {
            addCriterion("line_id >=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThan(String value) {
            addCriterion("line_id <", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThanOrEqualTo(String value) {
            addCriterion("line_id <=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLike(String value) {
            addCriterion("line_id like", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotLike(String value) {
            addCriterion("line_id not like", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdIn(List<String> values) {
            addCriterion("line_id in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotIn(List<String> values) {
            addCriterion("line_id not in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdBetween(String value1, String value2) {
            addCriterion("line_id between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotBetween(String value1, String value2) {
            addCriterion("line_id not between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineSumIsNull() {
            addCriterion("line_sum is null");
            return (Criteria) this;
        }

        public Criteria andLineSumIsNotNull() {
            addCriterion("line_sum is not null");
            return (Criteria) this;
        }

        public Criteria andLineSumEqualTo(Integer value) {
            addCriterion("line_sum =", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumNotEqualTo(Integer value) {
            addCriterion("line_sum <>", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumGreaterThan(Integer value) {
            addCriterion("line_sum >", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_sum >=", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumLessThan(Integer value) {
            addCriterion("line_sum <", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumLessThanOrEqualTo(Integer value) {
            addCriterion("line_sum <=", value, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumIn(List<Integer> values) {
            addCriterion("line_sum in", values, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumNotIn(List<Integer> values) {
            addCriterion("line_sum not in", values, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumBetween(Integer value1, Integer value2) {
            addCriterion("line_sum between", value1, value2, "lineSum");
            return (Criteria) this;
        }

        public Criteria andLineSumNotBetween(Integer value1, Integer value2) {
            addCriterion("line_sum not between", value1, value2, "lineSum");
            return (Criteria) this;
        }

        public Criteria andProductcolIsNull() {
            addCriterion("productcol is null");
            return (Criteria) this;
        }

        public Criteria andProductcolIsNotNull() {
            addCriterion("productcol is not null");
            return (Criteria) this;
        }

        public Criteria andProductcolEqualTo(String value) {
            addCriterion("productcol =", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolNotEqualTo(String value) {
            addCriterion("productcol <>", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolGreaterThan(String value) {
            addCriterion("productcol >", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolGreaterThanOrEqualTo(String value) {
            addCriterion("productcol >=", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolLessThan(String value) {
            addCriterion("productcol <", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolLessThanOrEqualTo(String value) {
            addCriterion("productcol <=", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolLike(String value) {
            addCriterion("productcol like", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolNotLike(String value) {
            addCriterion("productcol not like", value, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolIn(List<String> values) {
            addCriterion("productcol in", values, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolNotIn(List<String> values) {
            addCriterion("productcol not in", values, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolBetween(String value1, String value2) {
            addCriterion("productcol between", value1, value2, "productcol");
            return (Criteria) this;
        }

        public Criteria andProductcolNotBetween(String value1, String value2) {
            addCriterion("productcol not between", value1, value2, "productcol");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNull() {
            addCriterion("module_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("module_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(String value) {
            addCriterion("module_id =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(String value) {
            addCriterion("module_id <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(String value) {
            addCriterion("module_id >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("module_id >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(String value) {
            addCriterion("module_id <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(String value) {
            addCriterion("module_id <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLike(String value) {
            addCriterion("module_id like", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotLike(String value) {
            addCriterion("module_id not like", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(List<String> values) {
            addCriterion("module_id in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(List<String> values) {
            addCriterion("module_id not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(String value1, String value2) {
            addCriterion("module_id between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(String value1, String value2) {
            addCriterion("module_id not between", value1, value2, "moduleId");
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

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andLbSumIsNull() {
            addCriterion("lb_sum is null");
            return (Criteria) this;
        }

        public Criteria andLbSumIsNotNull() {
            addCriterion("lb_sum is not null");
            return (Criteria) this;
        }

        public Criteria andLbSumEqualTo(Integer value) {
            addCriterion("lb_sum =", value, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumNotEqualTo(Integer value) {
            addCriterion("lb_sum <>", value, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumGreaterThan(Integer value) {
            addCriterion("lb_sum >", value, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("lb_sum >=", value, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumLessThan(Integer value) {
            addCriterion("lb_sum <", value, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumLessThanOrEqualTo(Integer value) {
            addCriterion("lb_sum <=", value, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumIn(List<Integer> values) {
            addCriterion("lb_sum in", values, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumNotIn(List<Integer> values) {
            addCriterion("lb_sum not in", values, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumBetween(Integer value1, Integer value2) {
            addCriterion("lb_sum between", value1, value2, "lbSum");
            return (Criteria) this;
        }

        public Criteria andLbSumNotBetween(Integer value1, Integer value2) {
            addCriterion("lb_sum not between", value1, value2, "lbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumIsNull() {
            addCriterion("db_sum is null");
            return (Criteria) this;
        }

        public Criteria andDbSumIsNotNull() {
            addCriterion("db_sum is not null");
            return (Criteria) this;
        }

        public Criteria andDbSumEqualTo(Integer value) {
            addCriterion("db_sum =", value, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumNotEqualTo(Integer value) {
            addCriterion("db_sum <>", value, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumGreaterThan(Integer value) {
            addCriterion("db_sum >", value, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("db_sum >=", value, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumLessThan(Integer value) {
            addCriterion("db_sum <", value, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumLessThanOrEqualTo(Integer value) {
            addCriterion("db_sum <=", value, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumIn(List<Integer> values) {
            addCriterion("db_sum in", values, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumNotIn(List<Integer> values) {
            addCriterion("db_sum not in", values, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumBetween(Integer value1, Integer value2) {
            addCriterion("db_sum between", value1, value2, "dbSum");
            return (Criteria) this;
        }

        public Criteria andDbSumNotBetween(Integer value1, Integer value2) {
            addCriterion("db_sum not between", value1, value2, "dbSum");
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

        public Criteria andSumEqualTo(Integer value) {
            addCriterion("sum =", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotEqualTo(Integer value) {
            addCriterion("sum <>", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThan(Integer value) {
            addCriterion("sum >", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum >=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThan(Integer value) {
            addCriterion("sum <", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThanOrEqualTo(Integer value) {
            addCriterion("sum <=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumIn(List<Integer> values) {
            addCriterion("sum in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotIn(List<Integer> values) {
            addCriterion("sum not in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumBetween(Integer value1, Integer value2) {
            addCriterion("sum between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotBetween(Integer value1, Integer value2) {
            addCriterion("sum not between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andLineLengthIsNull() {
            addCriterion("line_length is null");
            return (Criteria) this;
        }

        public Criteria andLineLengthIsNotNull() {
            addCriterion("line_length is not null");
            return (Criteria) this;
        }

        public Criteria andLineLengthEqualTo(Integer value) {
            addCriterion("line_length =", value, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthNotEqualTo(Integer value) {
            addCriterion("line_length <>", value, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthGreaterThan(Integer value) {
            addCriterion("line_length >", value, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("line_length >=", value, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthLessThan(Integer value) {
            addCriterion("line_length <", value, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthLessThanOrEqualTo(Integer value) {
            addCriterion("line_length <=", value, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthIn(List<Integer> values) {
            addCriterion("line_length in", values, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthNotIn(List<Integer> values) {
            addCriterion("line_length not in", values, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthBetween(Integer value1, Integer value2) {
            addCriterion("line_length between", value1, value2, "lineLength");
            return (Criteria) this;
        }

        public Criteria andLineLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("line_length not between", value1, value2, "lineLength");
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

        public Criteria andTicketIdEqualTo(String value) {
            addCriterion("ticket_id =", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotEqualTo(String value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThan(String value) {
            addCriterion("ticket_id >", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThan(String value) {
            addCriterion("ticket_id <", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThanOrEqualTo(String value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLike(String value) {
            addCriterion("ticket_id like", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotLike(String value) {
            addCriterion("ticket_id not like", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIn(List<String> values) {
            addCriterion("ticket_id in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotIn(List<String> values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdBetween(String value1, String value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotBetween(String value1, String value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
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
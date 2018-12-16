package com.zw.dao.base;


import com.zw.common.vo.OffsetPagingVo;
import com.zw.common.vo.PageVo;
import org.jooq.*;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;

import javax.annotation.PostConstruct;
import java.util.*;

public abstract class BaseDaoImpl<R extends UpdatableRecord<R>, T> implements BaseDao<R, T> {

    private final Table<R> table;

    public BaseDaoImpl(Table<R> table) {
        this.table = table;
    }

    @PostConstruct
    public abstract Configuration getConfiguration();

    @Override
    public void insert(R object) throws DataAccessException {
        DSL.using(getConfiguration()).insertInto(object.getTable()).set(object).execute();
    }

    @Override
    public void insert(Collection<R> objects) throws DataAccessException {
        DSL.using(getConfiguration()).batchInsert(objects).execute();

    }

    @Override
    public void update(R object) throws DataAccessException {
        DSL.using(getConfiguration()).executeUpdate(object);
    }

    @Override
    public <Z> void updateOneFieldById(T id,Field<Z> field, Z value) throws DataAccessException {
        Field<T> primaryField = getPrimaryKey();
        if (primaryField != null) {
            DSL.using(getConfiguration()).update(table).set(field,value).where(primaryField.eq(id)).execute();
        }
    }

    @Override
    public <Z,S> void updateOneFieldByField(Field<Z> setField, Z setValue, Field<S> whereField, S whereValue) throws DataAccessException {
        DSL.using(getConfiguration()).update(table).set(setField,setValue).where(whereField.eq(whereValue)).execute();
    }

    @Override
    public void delete(R object) throws DataAccessException {
        DSL.using(getConfiguration()).executeDelete(object);
    }

    @Override
    public void delete(Collection<R> objects) throws DataAccessException {
        DSL.using(getConfiguration()).batchDelete(objects).execute();
    }

    @Override
    public void deleteById(Collection<T> ids) throws DataAccessException {
        Field<T> primaryField = getPrimaryKey();
        if (primaryField != null && ids.size() > 0) {
            DSL.using(getConfiguration()).delete(this.table).where(primaryField.in(ids)).execute();
        }
    }

    @Override
    public R findById(T id) throws DataAccessException {
        Field<T> primaryField = getPrimaryKey();
        if (primaryField != null) {
            return DSL.using(getConfiguration()).selectFrom(this.table).where(primaryField.eq(id)).fetchAny();
        }
        return null;
    }

    @Override
    public <Z> List<R> fetch(Field<Z> field, Z... values) throws DataAccessException {
        return DSL.using(getConfiguration()).selectFrom(this.table).where(new Condition[]{field.in(values)}).fetch();
    }

    @Override
    public <Z> List<R> fetch(Field<Z> field, Collection<Z> values) throws DataAccessException {
        return DSL.using(getConfiguration()).selectFrom(this.table).where(new Condition[]{field.in(values)}).fetch();
    }

    @Override
    public <Z> R fetchOne(Field<Z> field, Z value) throws DataAccessException {
        return DSL.using(getConfiguration()).selectFrom(this.table).where(new Condition[]{field.eq(value)}).fetchOne();
    }

    @Override
    public <Z> Optional<R> fetchOptional(Field<Z> field, Z value) throws DataAccessException {
        return Optional.ofNullable(this.fetchOne(field, value));
    }

    /**
     * @param conditions
     * @param offsetPagingVo
     * @param sortFields
     * @return
     */
    @Override
    public PageVo<R> fetchByPage(List<Condition> conditions, OffsetPagingVo offsetPagingVo, Collection<SortField<?>> sortFields) {
        PageVo<R> pageVo = new PageVo<>();
        ArrayList<R> arrayList = new ArrayList<>(Arrays.asList(DSL.using(getConfiguration()).selectFrom(this.table).where(conditions).orderBy(sortFields).limit(offsetPagingVo.getOffset(), offsetPagingVo.getSize()).fetchArray()));
        pageVo.setPageData(arrayList);
        Integer total = DSL.using(getConfiguration()).selectCount().from(this.table).where(conditions).fetchAny().value1();
        pageVo.setTotalCount(total);
        return pageVo;
    }

    private Field<T> getPrimaryKey() {
        UniqueKey key = this.table.getPrimaryKey();
        if (key == null || key.getFields() == null || key.getFields().isEmpty()) {
            return null;
        }
        List<TableField<R, T>> fields = key.getFields();
        return fields.get(0);
    }

    @Override
    public List<R> findByConditions(List<Condition> conditions, Collection<SortField<?>> sortFields) {
        return DSL.using(getConfiguration()).selectFrom(this.table).where(conditions).orderBy(sortFields).fetch();
    }

    @Override
    public List<R> findByCondition(Condition condition, Collection<SortField<?>> sortFields) {
        return DSL.using(getConfiguration()).selectFrom(this.table).where(condition).orderBy(sortFields).fetch();
    }
}

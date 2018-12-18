package com.zw.dao.user;

import com.zw.dao.base.BaseDaoImpl;
import com.zw.model.tables.records.UserRecord;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import static com.zw.model.tables.User.USER;

/**
 * @author：zhaowei
 * @Date：2018/12/18
 * @Time：上午11:54
 */


@Repository
public class UserDao extends BaseDaoImpl<UserRecord, Long> {

    @Autowired
    DSLContext dsl;

    public UserDao() {
        super(USER);
    }

    @Override
    public Configuration getConfiguration() {
        return dsl.configuration();
    }

    /**
     * 通过userId查询名字
     * @param userId
     * @return
     */
    public String getNameByUserId(Long userId) {
        String name = "";
        Record1<String> fetchAny = dsl
                .select(USER.NAME)
                .from(USER)
                .where(USER.ID.eq(userId))
                .fetchAny();
        if (!StringUtils.isEmpty(fetchAny)) {
            name = fetchAny.value1();
        }
        return name;
    }
}
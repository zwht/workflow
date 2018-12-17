package com.zw.dao.user;

import com.zw.dao.base.BaseDaoImpl;
import com.zw.model.tables.records.UserRecord;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.zw.model.tables.User.USER;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：zhaowei
 * Date：2018/12/16
 * Time：下午10:37
 * 魏翼超然：http://120.79.171.251:9876
 * ========================
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
     *
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
        if (fetchAny != null && fetchAny.size() > 0) {
            name = fetchAny.value1();
        }
        return name;
    }
}
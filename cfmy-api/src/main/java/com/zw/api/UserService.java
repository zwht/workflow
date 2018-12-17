package com.zw.api;

import com.zw.common.vo.ResultVo;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：zhaowei
 * Date：2018/12/17
 * Time：下午3:22
 * 魏翼超然：http://120.79.171.251:9876
 * ========================
 */
public interface UserService {
    /**
     * 根据id查询用户详情
     * @param id
     * @return
     */
    ResultVo<String> findById(Long id);
}

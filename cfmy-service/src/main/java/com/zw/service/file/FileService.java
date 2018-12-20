package com.zw.service.file;

import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.File;
import com.zw.vo.file.FileAddVo;
import com.zw.vo.file.FileSearchVo;

/**
 * @author：zhaowei
 * @Date：2018/12/20
 * @Time：下午3:20
 */
public interface FileService {
    ResponseVo add(FileAddVo fileAddVo);
    ResponseVo getById(Long id);
    ResponseVo update(File file);
    ResponseVo getList(Integer pageNum, Integer pageSize, FileSearchVo fileSearchVo);
    ResponseVo del(Long id);
}

package com.zw.service.file;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.File;
import com.zw.dao.entity.FileExample;
import com.zw.dao.mapper.FileMapper;
import com.zw.vo.file.FileAddVo;
import com.zw.vo.file.FileSearchVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * @author：zhaowei
 * @Date：2018/12/20
 * @Time：下午3:21
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper;

    @Override
    public ResponseVo add(FileAddVo fileAddVo) {
        ResponseVo response = new ResponseVo();
        try {
            File file = new File();
            BeanUtils.copyProperties(fileAddVo, file);
            FileExample fileExample = new FileExample();
            FileExample.Criteria criteria = fileExample.createCriteria();
            criteria.andNameEqualTo(file.getName());
            // 查询是否有相同
            List<File> files = fileMapper.selectByExample(fileExample);
            if (files.size() == 0) {
                file.setId(new SnowFlake(1, 1).nextId());
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<File>> constraintViolations = validator.validate(file);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    fileMapper.insert(file);
                    return response.success("添加成功");
                }
            } else {
                return response.failure(400, "数据重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getById(Long id) {
        ResponseVo<File> response = new ResponseVo();
        try {
            return response.success(fileMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(File file) {
        ResponseVo response = new ResponseVo();
        try {
            FileExample fileExample = new FileExample();
            FileExample.Criteria criteria = fileExample.createCriteria();
            criteria.andNameEqualTo(file.getName());
            criteria.andIdNotEqualTo(file.getId());
            // 查询是否有相同
            List<File> corporations = fileMapper.selectByExample(fileExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<File>> constraintViolations = validator.validate(file);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    FileExample example = new FileExample();
                    FileExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(file.getId());
                    fileMapper.updateByExampleSelective(file, example);
                    return response.success("修改成功");
                }

            } else {
                return response.failure(400, "名字重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getList(Integer pageNum, Integer pageSize, FileSearchVo fileSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        FileExample example = new FileExample();
        FileExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(fileSearchVo.getName())) {
            criteria.andNameLike("%"+fileSearchVo.getName()+"%");
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = fileMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        try {
            return response.success(fileMapper.deleteByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }
}

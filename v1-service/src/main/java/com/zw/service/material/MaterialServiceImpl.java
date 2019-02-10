package com.zw.service.material;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.Material;
import com.zw.dao.entity.MaterialExample;
import com.zw.dao.mapper.generate.MaterialMapper;
import com.zw.vo.material.MaterialAddVo;
import com.zw.vo.material.MaterialSearchVo;
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
 * @Date：2018/12/19
 * @Time：下午2:04
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    @Override
    public ResponseVo add(MaterialAddVo materialAddVo, String corporationId) {
        ResponseVo response = new ResponseVo();
        try {
            Material material = new Material();
            BeanUtils.copyProperties(materialAddVo, material);

            MaterialExample materialExample = new MaterialExample();
            MaterialExample.Criteria criteria = materialExample.createCriteria();
            criteria.andNameEqualTo(material.getName());
            // 查询是否有相同
            List<Material> materials = materialMapper.selectByExample(materialExample);
            if (materials.size() == 0) {
                material.setId(new SnowFlake(1, 1).nextId());
                material.setCorporationId(Long.parseLong(corporationId));
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Material>> constraintViolations = validator.validate(material);
                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    materialMapper.insert(material);
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
        ResponseVo<Material> response = new ResponseVo();
        try {
            return response.success(materialMapper.selectByPrimaryKey(Long.valueOf(id)));
        } catch (Exception e) {
            return response.failure(501, e.getMessage());
        }
    }

    @Override
    public ResponseVo update(Material material) {
        ResponseVo response = new ResponseVo();
        try {
            MaterialExample materialExample = new MaterialExample();
            MaterialExample.Criteria criteria = materialExample.createCriteria();
            criteria.andNameEqualTo(material.getName());
            criteria.andIdNotEqualTo(material.getId());
            // 查询是否有相同
            List<Material> corporations = materialMapper.selectByExample(materialExample);
            if (corporations.size() == 0) {
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<Material>> constraintViolations = validator.validate(material);

                if (constraintViolations.size() != 0) {
                    return response.validation(constraintViolations);
                } else {
                    MaterialExample example = new MaterialExample();
                    MaterialExample.Criteria criteria1 = example.createCriteria();
                    criteria1.andIdEqualTo(material.getId());
                    materialMapper.updateByExampleSelective(material, example);
                    return response.success("修改成功");
                }

            } else {
                return response.failure(400, "数据重复！");
            }
        } catch (Exception e) {
            return response.failure(400, e.toString());
        }
    }

    @Override
    public ResponseVo getList(Integer pageNum, Integer pageSize, MaterialSearchVo materialSearchVo) {
        ResponseVo response = new ResponseVo();
        //条件查询3句话
        MaterialExample example = new MaterialExample();
        // example.setOrderByClause("`index_key` ASC");
        MaterialExample.Criteria criteria = example.createCriteria();
        criteria.andFlagIsNull();
        if (!StringUtils.isEmpty(materialSearchVo.getName())) {
            criteria.andNameEqualTo(materialSearchVo.getName());
        }
        try {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List list = materialMapper.selectByExample(example);
            long count = page.getTotal();
            return response.success(new PageVo(pageNum, pageSize, count, list));
        } catch (Exception e) {
            return response.failure(400, e.getMessage());
        }
    }

    @Override
    public ResponseVo del(Long id) {
        ResponseVo response = new ResponseVo();
        Material material = materialMapper.selectByPrimaryKey(id);
        material.setFlag((short)1);
        MaterialExample example = new MaterialExample();
        MaterialExample.Criteria criteria1 = example.createCriteria();
        criteria1.andIdEqualTo(material.getId());
        materialMapper.updateByExampleSelective(material, example);
        return response.success("删除成功");
    }
}
package com.zw.controller.brand;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Brand;
import com.zw.service.brand.BrandService;
import com.zw.vo.brand.BrandAddVo;
import com.zw.vo.brand.BrandSearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/19
 * @Time：下午2:15
 */
@RestController
@RequestMapping("/v1")
@Api(description = "品牌")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @ApiOperation("新增")
    @PostMapping("/brand/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody BrandAddVo brandAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return brandService.add(brandAddVo,tokenVo);
    }


    @ApiOperation("详情")
    @GetMapping("/brand/getById")
    @ResponseBody
    public ResponseVo<Brand> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return brandService.getById(id);
    }

    @ApiOperation("更新")
    @PostMapping("/brand/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "BrandUpdateVo") @RequestBody Brand brand
    ) {
        return brandService.update(brand);
    }

    @ResponseBody
    @PostMapping("/brand/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Brand>>> getBrandList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "BrandSearchVo") @RequestBody BrandSearchVo brandListFind,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return brandService.getList(pageNum, pageSize, brandListFind,tokenVo);
    }


    @ApiOperation("删除")
    @GetMapping("/brand/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return brandService.del(id);
    }
}

package com.zw.controller.product;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Product;
import com.zw.service.product.ProductService;
import com.zw.vo.product.ProductAddVo;
import com.zw.vo.product.ProductSearchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@Api(description = "工单产品")
public class ProductController {

    @Autowired
    private ProductService productService;


    @ApiOperation("新增")
    @PostMapping("/product/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody ProductAddVo[] productAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return productService.add(productAddVo, tokenVo);
    }


    @ApiOperation("详情")
    @GetMapping("/product/getById")
    @ResponseBody
    public ResponseVo<Product> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return productService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/product/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "ProductUpdateVo") @RequestBody Product product
    ) {
        return productService.update(product);
    }

    @ResponseBody
    @PostMapping("/product/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Product>>> getProductList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "ProductSearchVo") @RequestBody ProductSearchVo productSearchVo,
            HttpServletRequest request
    ) {
        return productService.getList(pageNum, pageSize, productSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/product/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return productService.del(id);
    }

    @ApiOperation("修改状态")
    @GetMapping("/product/updateState")
    @ResponseBody
    public ResponseVo updateState(
            @ApiParam(required = true, value = "id") @RequestParam Long id,
            @ApiParam(required = true, value = "state") @RequestParam Short state
    ) {
        return productService.updateState(id, state);
    }

}

package com.zw.controller.material;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.common.vo.TokenVo;
import com.zw.dao.entity.Material;
import com.zw.service.material.MaterialService;
import com.zw.vo.material.MaterialAddVo;
import com.zw.vo.material.MaterialSearchVo;
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
@Api(description = "材质")
public class MaterialController {

    @Autowired
    private MaterialService materialService;


    @ApiOperation("新增")
    @PostMapping("/material/add")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "body内容") @RequestBody MaterialAddVo materialAddVo,
            HttpServletRequest request
    ) {
        TokenVo tokenVo = (TokenVo) request.getAttribute("tokenVo");
        return materialService.add(materialAddVo, tokenVo.getCorporationId());
    }


    @ApiOperation("详情")
    @GetMapping("/material/getById")
    @ResponseBody
    public ResponseVo<Material> selectByPrimaryKey(
            @ApiParam(required = true, value = "用户Id") @RequestParam Long id
    ) {
        return materialService.getById(id);
    }


    @ApiOperation("更新")
    @PostMapping("/material/update")
    @ResponseBody
    public ResponseVo update(
            @ApiParam(required = true, value = "MaterialUpdateVo") @RequestBody Material material
    ) {
        return materialService.update(material);
    }

    @ResponseBody
    @PostMapping("/material/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<Material>>> getMaterialList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "MaterialSearchVo") @RequestBody MaterialSearchVo materialSearchVo
    ) {
        return materialService.getList(pageNum, pageSize, materialSearchVo);
    }


    @ApiOperation("删除")
    @GetMapping("/material/del")
    @ResponseBody
    public ResponseVo del(
            @ApiParam(required = true, value = "id") @RequestParam Long id
    ) {
        return materialService.del(id);
    }
}

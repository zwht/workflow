package com.zw.controller.file;

import com.zw.common.vo.ResponseVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author：zhaowei
 * @Date：2018/12/20
 * @Time：下午2:16
 */

@RestController
@RequestMapping("/cfmy")
@Api(description = "文件管理")
public class FileController {

    @Value("${fileUpload.url}")
    private String fileUrl;
    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @ResponseBody
    @PostMapping(value = "/file/add", consumes = "multipart/*")
    @ApiOperation("上传文件")
    public ResponseVo add(
            @ApiParam(required = true, value = "选择文件") MultipartFile multipartFile,
            @ApiParam(value = "文件类型") @RequestParam String type,
            HttpServletRequest request
    ) throws IllegalStateException, IOException {
        ResponseVo response = new ResponseVo();

        if (multipartFile.isEmpty()) {
            return response.failure(400, "没有文件！");
        }
        String fileName = multipartFile.getOriginalFilename();
        int size = (int) multipartFile.getSize();
        if(size>10 * 1024 * 1024){
            return response.failure(500, "文件最大10M！");
        }

        File dest = new File(fileUrl + type + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest); //保存文件
            return response.success();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return response.failure(500, e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return response.failure(500, e.toString());
        }
    }
}

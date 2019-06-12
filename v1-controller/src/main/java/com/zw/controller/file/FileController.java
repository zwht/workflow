package com.zw.controller.file;

import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.*;
import com.zw.service.file.FileService;
import com.zw.vo.file.FileAddVo;
import com.zw.vo.file.FileSearchVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.File;
import java.util.List;

/**
 * @author：zhaowei
 * @Date：2018/12/20
 * @Time：下午2:16
 */

@RestController
@RequestMapping("/v1")
@Api(description = "文件管理")
public class FileController {

    @Value("${web.windowsFilePath}")
    private String windowsFilePath;

    @Value("${web.linuxFilePath}")
    private String linuxFilePath;

    @Autowired
    FileService fileService;

    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @ApiOperation("上传文件")
    @PostMapping(value = "/file/add", consumes = "multipart/*")
    @ResponseBody
    public ResponseVo add(
            @ApiParam(required = true, value = "选择文件") MultipartFile multipartFile,
            @ApiParam(value = "文件存放文件夹名字，如：img") @RequestParam(required = false) String type,
            @ApiParam(value = "关联Id") @RequestParam(required = false) Long id
    ) throws IllegalStateException, IOException {

        FileAddVo fileAddVo = new FileAddVo();
        if (StringUtils.isEmpty(type)) {
            type = "common";
        }
        fileAddVo.setType(type);
        if (!StringUtils.isEmpty(id)) {
            fileAddVo.setOtherId(id);
        }
        return fileService.add(multipartFile, fileAddVo);
    }

    /**
     * 添加多个文件
     *
     * @param id
     * @param type
     * @return
     */
    @ApiOperation("添加多个文件")
    @RequestMapping(value = "/adds", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo adds(
            @ApiParam(required = true, value = "选择文件") MultipartFile[] files,
            @ApiParam(value = "文件存放文件夹名字，如：img") @RequestParam(required = false) String type,
            @ApiParam(value = "关联Id") @RequestParam(required = false) Long id
    ) {
        FileAddVo fileAddVo = new FileAddVo();
        if (StringUtils.isEmpty(type)) {
            type = "common";
        }
        fileAddVo.setType(type);
        if (!StringUtils.isEmpty(id)) {
            fileAddVo.setOtherId(id);
        }
        return fileService.adds(files, fileAddVo);
    }

    @ApiOperation("详情")
    @GetMapping("/public/file/getById")
    @ResponseBody
    public String selectByPrimaryKey(
            @ApiParam(required = true, value = "文件Id") @RequestParam Long id,
            HttpServletResponse response
    ) {
        ResponseVo<com.zw.dao.entity.File> responseVo = fileService.getById(id);
        if (responseVo.getStatus() == 200) {
            com.zw.dao.entity.File file1 = responseVo.getResponse();

            String os2 = System.getProperty("os.name");
            String fileUrl = linuxFilePath;
            if (os2.toLowerCase().startsWith("win")) {
                fileUrl = windowsFilePath;
            }

            File file = new File(fileUrl + file1.getType() + "/" + file1.getId() + file1.getFileType());
            if (file.exists()) {
                // response.setContentType("application/force-download");// 设置强制下载不打开
                // response.addHeader("Content-Disposition", "attachment;fileName=" + file1.getName());// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "失败";
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return "失败";
                }
            }
        }
        return "失败";
    }


    @ResponseBody
    @PostMapping("/file/list")
    @ApiOperation("查询列表")
    public ResponseVo<PageVo<List<CodeGroup>>> getCodeGroupList(
            @ApiParam(required = true, value = "当前页面", defaultValue = "1") @RequestParam Integer pageNum,
            @ApiParam(required = true, value = "每页显示条数", defaultValue = "10") @RequestParam Integer pageSize,
            @ApiParam(value = "CodeGroupSearchVo") @RequestBody FileSearchVo fileSearchVo
    ) {
        return fileService.getList(pageNum, pageSize, fileSearchVo);
    }
}

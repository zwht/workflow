package com.zw.service.file;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zw.common.util.SnowFlake;
import com.zw.common.vo.PageVo;
import com.zw.common.vo.ResponseVo;
import com.zw.dao.entity.File;
import com.zw.dao.entity.FileExample;
import com.zw.dao.mapper.generate.FileMapper;
import com.zw.vo.file.FileAddVo;
import com.zw.vo.file.FileSearchVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author：zhaowei
 * @Date：2018/12/20
 * @Time：下午3:21
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${web.windowsFilePath}")
    private String windowsFilePath;

    @Value("${web.linuxFilePath}")
    private String linuxFilePath;

    @Autowired
    FileMapper fileMapper;

    // 上传数据添加到表
    public Boolean addFileToTable(FileAddVo fileAddVo) {
        try {
            File file = new File();
            BeanUtils.copyProperties(fileAddVo, file);
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<File>> constraintViolations = validator.validate(file);
            if (constraintViolations.size() != 0) {
                return false;
            } else {
                fileMapper.insert(file);
                return true;
            }

        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public ResponseVo add(MultipartFile file, FileAddVo fileAddVo) {
        ResponseVo response = new ResponseVo();

        if (file.isEmpty()) {
            return response.failure(400, "没有文件！");
        }
        Long size = file.getSize();
        if (size > 100 * 1048576) {
            return response.failure(400, "文件太大！");
        }
        try {
            String filetType = file.getContentType();
            if (!StringUtils.isEmpty(filetType)) {
                MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
                MimeType type = allTypes.forName(filetType);
                filetType = type.getExtension();
                fileAddVo.setFileType(filetType);
            } else {
                return response.failure(400, "文件类型很奇怪！");
            }

            Long id = new SnowFlake(1, 1).nextId();
            String fileName = id + filetType;
            fileAddVo.setId(id);
            fileAddVo.setUrl(fileName);
            fileAddVo.setName(file.getOriginalFilename());
            fileAddVo.setSize(Long.valueOf(size));

            String os2 = System.getProperty("os.name");
            String fileUrl = linuxFilePath;
            if (os2.toLowerCase().startsWith("win")) {
                fileUrl = windowsFilePath;
            }

            java.io.File dest = new java.io.File(fileUrl + "/" + fileAddVo.getType() + "/" + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdirs();
            }

            file.transferTo(dest); //保存文件
            Boolean s = addFileToTable(fileAddVo);
            if (s) {
                return response.success(fileAddVo);
            } else {
                return response.failure(500, "插入数据库错误");
            }
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return response.failure(500, e.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return response.failure(500, e.toString());
        }
    }


    /**
     * 添加
     *
     * @param files
     * @param fileAddVo1
     * @return
     */
    @Override
    public ResponseVo adds(MultipartFile[] files,
                           FileAddVo fileAddVo1) {
        ResponseVo responseVo = new ResponseVo();
        if (files.length == 0) {
            responseVo.setStatus(400);
            responseVo.setMsg("没有文件！");
            return responseVo;
        }
        ArrayList<FileAddVo> listVo = new ArrayList<>();
        //循环获取file数组中得文件
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];

            FileAddVo fileAddVo = new FileAddVo();
            BeanUtils.copyProperties(fileAddVo1, fileAddVo);

            if (!file.isEmpty()) {
                try {
                    String filetType = file.getContentType();
                    if (!StringUtils.isEmpty(filetType)) {
                        MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
                        MimeType type = allTypes.forName(filetType);
                        filetType = type.getExtension();
                        fileAddVo.setFileType(filetType);
                    } else {
                        //return response.failure(400, "文件类型很奇怪！");
                    }

                    Long size = file.getSize();
                    if (size > 100 * 1048576) {
                        continue;
                    }

                    Long id = new SnowFlake(1, 1).nextId();
                    String fileName = id + filetType;
                    fileAddVo.setId(id);
                    fileAddVo.setUrl(fileName);
                    fileAddVo.setName(file.getOriginalFilename());
                    fileAddVo.setSize(Long.valueOf(size));

                    String os2 = System.getProperty("os.name");
                    String fileUrl = linuxFilePath;
                    if (os2.toLowerCase().startsWith("win")) {
                        fileUrl = windowsFilePath;
                    }

                    java.io.File dest = new java.io.File(fileUrl + "/" + fileAddVo.getType() + "/" + fileName);
                    if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                        dest.getParentFile().mkdirs();
                    }

                    try {
                        file.transferTo(dest); //保存文件
                        Boolean s = addFileToTable(fileAddVo);
                        if (s) {
                            listVo.add(fileAddVo);
                        }
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        //return response.failure(500, e.toString());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        //return response.failure(500, e.toString());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        responseVo.setResponse(listVo);
        return responseVo;
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
            criteria.andIdNotEqualTo(file.getId());
            // 查询是否有相同
            List<File> departments = fileMapper.selectByExample(fileExample);
            if (departments.size() == 0) {
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
        if (!StringUtils.isEmpty(fileSearchVo.getType())) {
            criteria.andTypeEqualTo(fileSearchVo.getType());
        }
        if (!StringUtils.isEmpty(fileSearchVo.getOtherId())) {
            criteria.andOtherIdEqualTo(fileSearchVo.getOtherId());
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

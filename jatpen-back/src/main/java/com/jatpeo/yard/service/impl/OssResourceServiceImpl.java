package com.jatpeo.yard.service.impl;

import com.jatpeo.yard.common.constants.OssConstants;
import com.jatpeo.yard.common.util.AliyunOSSUtil;
import com.jatpeo.yard.common.util.UUIDUtils;
import com.jatpeo.yard.entity.oss.OssResource;
import com.jatpeo.yard.service.OssResourceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p>
 * 云存储资源表 服务实现类
 * </p>
 *
 * @author jiatp
 * @since 2018-11-30
 */
@Service
@Slf4j
public class OssResourceServiceImpl implements OssResourceService {

    private AliyunOSSUtil aliyunOSSUtil;  //utils

    @Override
    public OssResource upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String newName = UUIDUtils.getUUID() + fileName.substring(fileName.lastIndexOf("."));
        File dest = new File(OssConstants.UPLOAD_PREFIX + newName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return new OssResource(OssConstants.SHOW_PREFIX + newName, newName);
    }


    /*
     * 文件上传 使用aliyunOSS
     * */
    @Override
    public OssResource uploadAliyunOss(MultipartFile file){
        log.info("=========>文件上传");
        String uploadUrl = null;
        String picName =null;
        try {
            if(null != file){
                String originalFileName = file.getOriginalFilename();  //文件名称
                    //上传
                    if(!"".equals(originalFileName.trim())){
                        File newFile = new File(originalFileName);
                        FileOutputStream os = new FileOutputStream(newFile);
                        os.write(file.getBytes());
                        os.close();
                        file.transferTo(newFile);
                        //上传到OSS
                      picName = aliyunOSSUtil.upload(newFile);
                      uploadUrl = "https://jiatp-blog.oss-cn-beijing.aliyuncs.com/"+picName; //完整的图片路径
                    }
                    return new OssResource(uploadUrl,picName);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //如果错误返回 默认
        picName = "defaultPic";
        uploadUrl = "https://jiatp-blog.oss-cn-beijing.aliyuncs.com/blog/banner11.jpg";
        return new OssResource(uploadUrl,picName);
    }

}

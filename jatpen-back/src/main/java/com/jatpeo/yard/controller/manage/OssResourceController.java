package com.jatpeo.yard.controller.manage;

import com.jatpeo.yard.common.Result;
import com.jatpeo.yard.common.exception.MyException;
import com.jatpeo.yard.entity.oss.OssResource;
import com.jatpeo.yard.service.OssResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 云存储资源表 前端控制器
 * </p>
 *
 * @author jiatp
 * @since 2018-11-30
 */
@RestController
@RequestMapping("/admin/oss/resource")
public class OssResourceController {

    @Autowired
    private OssResourceService ossResourceService;

    @PostMapping("/upload")
    public Result uploadCover(MultipartFile file) {
        if (file != null && file.isEmpty()) {
            throw new MyException("上传文件不能为空");
        }
        //上传文件
        OssResource resource = ossResourceService.uploadAliyunOss(file);
        if (resource == null) {
            return Result.error("上传失败");
        }
        return Result.ok().put("resource", resource);
    }
}

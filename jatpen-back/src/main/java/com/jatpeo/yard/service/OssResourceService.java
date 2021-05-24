package com.jatpeo.yard.service;

import com.jatpeo.yard.entity.oss.OssResource;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 云存储资源表 服务类
 * </p>
 *
 * @author jiatp
 * @since 2018-11-30
 */
public interface OssResourceService {

    OssResource upload(MultipartFile file);
    OssResource uploadAliyunOss(MultipartFile file);
}

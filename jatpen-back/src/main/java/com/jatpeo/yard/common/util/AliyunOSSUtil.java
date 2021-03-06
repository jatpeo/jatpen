package com.jatpeo.yard.common.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/*
 * springboot整合阿里云OSS
 * */
@Slf4j
public class AliyunOSSUtil {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private static final String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static final String accessKeyId = "LTAI4GCpQD6z4PviNhRLgFGv";
    private static final String accessKeySecret = "Z8w6UjESq3p8OIeUCnWDc3Z2zfs1eC";
    private static final String bucketName = "jiatp-blog";
    private static final String fileHost = "jpps";


    /*
     * 上传
     * */
    public static String upload(File file) {
        log.info("=========>OSS文件上传开始：" + file.getName());
        System.out.println(endpoint + "endpoint");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());

        if (null == file) {
            return null;
        }

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            //容器不存在，就创建
            if (!ossClient.doesBucketExist(bucketName)) {
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if (null != result) {
                log.info("==========>OSS文件上传成功,OSS地址：" + fileUrl);
                return fileUrl;
            }
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * 删除
     *
     * @param fileKey
     * @return
     */
    public static String deleteBlog(String fileKey) {
        log.info("=========>OSS文件删除开始");
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

            if (!ossClient.doesBucketExist(bucketName)) {
                log.info("==============>您的Bucket不存在");
                return "您的Bucket不存在";
            } else {
                log.info("==============>开始删除Object");
                ossClient.deleteObject(bucketName, fileKey);
                log.info("==============>Object删除成功：" + fileKey);
                return "==============>Object删除成功：" + fileKey;
            }
        } catch (Exception ex) {
            log.info("删除Object失败", ex);
            return "删除Object失败";
        }
    }

    /**
     * 查询文件名列表
     *
     * @param bucketName
     * @return
     */
    public static List<String> getObjectList(String bucketName) {
        List<String> listRe = new ArrayList<String>();
        try {
            log.info("===========>查询文件名列表");
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
            //列出11111目录下今天所有文件
            listObjectsRequest.setPrefix("11111/" + format.format(new Date()) + "/");
            ObjectListing list = ossClient.listObjects(listObjectsRequest);
            for (OSSObjectSummary objectSummary : list.getObjectSummaries()) {
                System.out.println(objectSummary.getKey());
                listRe.add(objectSummary.getKey());
            }
            return listRe;
        } catch (Exception ex) {
            log.info("==========>查询列表失败", ex);
            return new ArrayList<String>();
        }
    }


}

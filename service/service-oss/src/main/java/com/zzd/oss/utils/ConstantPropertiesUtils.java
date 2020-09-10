package com.zzd.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author ZZD
 * @Date 2020/9/9 18:49
 * @Email 1396896729@qq.com
 * @description
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${aliyun-file-endpoint}")
    private String endpoint;
    @Value("${aliyun-file-accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun-file-accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun-file-bucketName}")
    private String bucketName;

    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = this.endpoint;
        ACCESS_KEY_ID = this.accessKeyId;
        ACCESS_KEY_SECRET = this.accessKeySecret;
        BUCKET_NAME = this.bucketName;
    }
}

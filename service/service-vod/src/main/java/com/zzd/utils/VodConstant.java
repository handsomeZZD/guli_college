package com.zzd.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author ZZD
 * @Date 2020/9/19 23:26
 * @Email 1396896729@qq.com
 * @description
 */
@Component
public class VodConstant implements InitializingBean {
    @Value("${aliyun-accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun-accessKeySecret}")
    private String accessKeySecret;


    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID = this.accessKeyId;
        ACCESS_KEY_SECRET = this.accessKeySecret;
    }
}

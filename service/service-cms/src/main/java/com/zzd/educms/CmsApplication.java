package com.zzd.educms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author ZZD
 * @Date 2020/10/4 23:27
 * @Email 1396896729@qq.com
 * @description
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.zzd"})
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class,args);
    }
}

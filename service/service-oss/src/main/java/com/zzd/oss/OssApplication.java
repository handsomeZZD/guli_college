package com.zzd.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author ZZD
 * @Date 2020/9/9 18:44
 * @Email 1396896729@qq.com
 * @description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}

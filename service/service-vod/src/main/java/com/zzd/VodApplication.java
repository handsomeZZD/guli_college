package com.zzd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author ZZD
 * @Date 2020/9/19 21:40
 * @Email 1396896729@qq.com
 * @description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class VodApplication {
    public static void main(String[] args) {
        SpringApplication.run(VodApplication.class,args);
    }
}

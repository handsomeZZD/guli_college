package com.zzd.educenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ZZD
 * @Date 2020/10/6 10:50
 * @Email 1396896729@qq.com
 * @description
 */
@SpringBootApplication(scanBasePackages = {"com.zzd"})
public class CenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class,args);
    }
}

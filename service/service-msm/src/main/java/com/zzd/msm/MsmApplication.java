package com.zzd.msm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ZZD
 * @Date 2020/10/5 19:25
 * @Email 1396896729@qq.com
 * @description
 */
@SpringBootApplication(scanBasePackages = {"com.zzd"})
public class MsmApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsmApplication.class,args);
    }
}

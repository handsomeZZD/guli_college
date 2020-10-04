package com.zzd.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ZZD
 * @Date 2020/9/2 22:16
 * @Email 1396896729@qq.com
 */
@SpringBootApplication
public class EduApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(EduApplication.class,args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

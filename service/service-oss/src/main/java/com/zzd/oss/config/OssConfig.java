package com.zzd.oss.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ZZD
 * @Date 2020/9/10 19:26
 * @Email 1396896729@qq.com
 * @description
 */
@Configuration
@ComponentScan(basePackages = {"com.zzd.eduservice"})
@EnableSwagger2
public class OssConfig {
}

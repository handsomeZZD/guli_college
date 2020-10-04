package com.zzd.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ZZD
 * @Date 2020/9/21 19:46
 * @Email 1396896729@qq.com
 * @description
 */
@Configuration
@ComponentScan(basePackages = {"com.zzd.eduservice"})
@EnableSwagger2
@EnableDiscoveryClient
public class VodConfig {
}

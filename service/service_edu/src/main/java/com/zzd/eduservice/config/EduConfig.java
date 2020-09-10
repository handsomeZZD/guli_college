package com.zzd.eduservice.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ZZD
 * @Date 2020/9/2 22:22
 * @Email 1396896729@qq.com
 */
@Configuration
@MapperScan("com.zzd.eduservice.dao")
@ComponentScan(basePackages = {"com.zzd.eduservice"})
@EnableSwagger2
public class EduConfig {

    /**
     *  配置数据库的分页插件
     */
    @Bean
    public PaginationInterceptor PaginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
}

package com.zzd.eduservice.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author ZZD
 * @Date 2020/9/3 21:56
 * @Email 1396896729@qq.com
 * @description 实现自动填充功能
 */
@Component
public class AutoFill implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"gmtCreate",Date.class,new Date());
        this.strictInsertFill(metaObject,"gmtModified",Date.class,new Date());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"gmtModified",Date.class,new Date());
    }
}

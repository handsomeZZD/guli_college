package com.zzd.eduservice.client.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.eduservice.client.UCenterClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author ZZD
 * @Date 2020/10/18 17:31
 * @Email 1396896729@qq.com
 * @description
 */
@Component
public class UCenterClientImpl implements UCenterClient {


    @Override
    public R getMemberInfo(HttpServletRequest request) {
        return R.failed("feign调用错误");
    }
}

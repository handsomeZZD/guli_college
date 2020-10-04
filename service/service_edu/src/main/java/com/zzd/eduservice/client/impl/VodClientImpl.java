package com.zzd.eduservice.client.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.zzd.eduservice.client.VodClient;
import org.springframework.stereotype.Component;

/**
 * @Author ZZD
 * @Date 2020/10/4 10:44
 * @Email 1396896729@qq.com
 * @description
 */
@Component
public class VodClientImpl implements VodClient {
    @Override
    public R removeVideo(String id) {
        return R.failed("调用远程失败");
    }
}
